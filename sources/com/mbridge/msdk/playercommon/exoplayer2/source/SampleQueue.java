package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.CryptoInfo;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue = new SampleMetadataQueue();
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    private static final class AllocationNode {
        @Nullable
        public Allocation allocation;
        public final long endPosition;
        @Nullable
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j4, int i4) {
            this.startPosition = j4;
            this.endPosition = j4 + ((long) i4);
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public final void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j4) {
            return ((int) (j4 - this.startPosition)) + this.allocation.offset;
        }
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator2) {
        this.allocator = allocator2;
        int individualAllocationLength = allocator2.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        AllocationNode allocationNode = new AllocationNode(0, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j4) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j4 >= allocationNode.endPosition) {
                this.readAllocationNode = allocationNode.next;
            } else {
                return;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i4 = (allocationNode2.wasInitialized ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                allocationArr[i5] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j4) {
        AllocationNode allocationNode;
        if (j4 != -1) {
            while (true) {
                allocationNode = this.firstAllocationNode;
                if (j4 < allocationNode.endPosition) {
                    break;
                }
                this.allocator.release(allocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
                this.readAllocationNode = allocationNode;
            }
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j4) {
        if (format == null) {
            return null;
        }
        if (j4 == 0) {
            return format;
        }
        long j5 = format.subsampleOffsetUs;
        if (j5 != Long.MAX_VALUE) {
            return format.copyWithSubsampleOffsetUs(j5 + j4);
        }
        return format;
    }

    private void postAppend(int i4) {
        long j4 = this.totalBytesWritten + ((long) i4);
        this.totalBytesWritten = j4;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j4 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i4) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i4, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j4, ByteBuffer byteBuffer, int i4) {
        advanceReadTo(j4);
        while (i4 > 0) {
            int min = Math.min(i4, (int) (this.readAllocationNode.endPosition - j4));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j4), min);
            i4 -= min;
            j4 += (long) min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j4 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        boolean z4;
        int i4;
        DecoderInputBuffer decoderInputBuffer2 = decoderInputBuffer;
        SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        long j4 = sampleExtrasHolder2.offset;
        this.scratch.reset(1);
        readData(j4, this.scratch.data, 1);
        long j5 = j4 + 1;
        byte b5 = this.scratch.data[0];
        if ((b5 & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        byte b6 = b5 & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer2.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        }
        readData(j5, cryptoInfo.iv, (int) b6);
        long j6 = j5 + ((long) b6);
        if (z4) {
            this.scratch.reset(2);
            readData(j6, this.scratch.data, 2);
            j6 += 2;
            i4 = this.scratch.readUnsignedShort();
        } else {
            i4 = 1;
        }
        CryptoInfo cryptoInfo2 = decoderInputBuffer2.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < i4) {
            iArr = new int[i4];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i4) {
            iArr3 = new int[i4];
        }
        int[] iArr4 = iArr3;
        if (z4) {
            int i5 = i4 * 6;
            this.scratch.reset(i5);
            readData(j6, this.scratch.data, i5);
            j6 += (long) i5;
            this.scratch.setPosition(0);
            for (int i6 = 0; i6 < i4; i6++) {
                iArr2[i6] = this.scratch.readUnsignedShort();
                iArr4[i6] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j6 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder2.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer2.cryptoInfo;
        cryptoInfo3.set(i4, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j7 = sampleExtrasHolder2.offset;
        int i7 = (int) (j6 - j7);
        sampleExtrasHolder2.offset = j7 + ((long) i7);
        sampleExtrasHolder2.size -= i7;
    }

    public final int advanceTo(long j4, boolean z4, boolean z5) {
        return this.metadataQueue.advanceTo(j4, z4, z5);
    }

    public final int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public final void discardTo(long j4, boolean z4, boolean z5) {
        discardDownstreamTo(this.metadataQueue.discardTo(j4, z4, z5));
    }

    public final void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public final void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public final void discardUpstreamSamples(int i4) {
        long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i4);
        this.totalBytesWritten = discardUpstreamSamples;
        if (discardUpstreamSamples != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (discardUpstreamSamples != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    public final void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && format2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    public final int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public final long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public final long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public final int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public final Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public final int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public final boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public final int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public final int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4, boolean z5, long j4) {
        FormatHolder formatHolder2 = formatHolder;
        DecoderInputBuffer decoderInputBuffer2 = decoderInputBuffer;
        int read = this.metadataQueue.read(formatHolder2, decoderInputBuffer2, z4, z5, this.downstreamFormat, this.extrasHolder);
        if (read == -5) {
            this.downstreamFormat = formatHolder2.format;
            return -5;
        } else if (read == -4) {
            if (!decoderInputBuffer2.isEndOfStream()) {
                if (decoderInputBuffer2.timeUs < j4) {
                    decoderInputBuffer2.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer2.isEncrypted()) {
                    readEncryptionData(decoderInputBuffer2, this.extrasHolder);
                }
                decoderInputBuffer2.ensureSpaceForWrite(this.extrasHolder.size);
                SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
                readData(sampleExtrasHolder.offset, decoderInputBuffer2.data, sampleExtrasHolder.size);
            }
            return -4;
        } else if (read == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void reset() {
        reset(false);
    }

    public final void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    public final int sampleData(ExtractorInput extractorInput, int i4, boolean z4) throws IOException, InterruptedException {
        int preAppend = preAppend(i4);
        AllocationNode allocationNode = this.writeAllocationNode;
        int read = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z4) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void sampleMetadata(long j4, int i4, int i5, int i6, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i4 & 1) != 0 && this.metadataQueue.attemptSplice(j4)) {
                this.pendingSplice = false;
            } else {
                return;
            }
        }
        this.metadataQueue.commitSample(j4 + this.sampleOffsetUs, i4, (this.totalBytesWritten - ((long) i5)) - ((long) i6), i5, cryptoData);
    }

    public final boolean setReadPosition(int i4) {
        return this.metadataQueue.setReadPosition(i4);
    }

    public final void setSampleOffsetUs(long j4) {
        if (this.sampleOffsetUs != j4) {
            this.sampleOffsetUs = j4;
            this.pendingFormatAdjustment = true;
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void sourceId(int i4) {
        this.metadataQueue.sourceId(i4);
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final void reset(boolean z4) {
        this.metadataQueue.reset(z4);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    private void readData(long j4, byte[] bArr, int i4) {
        advanceReadTo(j4);
        int i5 = i4;
        while (i5 > 0) {
            int min = Math.min(i5, (int) (this.readAllocationNode.endPosition - j4));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j4), bArr, i4 - i5, min);
            i5 -= min;
            j4 += (long) min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j4 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i4) {
        while (i4 > 0) {
            int preAppend = preAppend(i4);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i4 -= preAppend;
            postAppend(preAppend);
        }
    }
}
