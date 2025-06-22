package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.FlacStreamInfo;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class FlacReader extends StreamReader {
    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    private static final byte SEEKTABLE_PACKET_TYPE = 3;
    private FlacOggSeeker flacOggSeeker;
    /* access modifiers changed from: private */
    public FlacStreamInfo streamInfo;

    private class FlacOggSeeker implements SeekMap, OggSeeker {
        private static final int METADATA_LENGTH_OFFSET = 1;
        private static final int SEEK_POINT_SIZE = 18;
        private long firstFrameOffset = -1;
        private long pendingSeekGranule = -1;
        private long[] seekPointGranules;
        private long[] seekPointOffsets;

        public FlacOggSeeker() {
        }

        public SeekMap createSeekMap() {
            return this;
        }

        public long getDurationUs() {
            return FlacReader.this.streamInfo.durationUs();
        }

        public SeekMap.SeekPoints getSeekPoints(long j4) {
            int binarySearchFloor = Util.binarySearchFloor(this.seekPointGranules, FlacReader.this.convertTimeToGranule(j4), true, true);
            long convertGranuleToTime = FlacReader.this.convertGranuleToTime(this.seekPointGranules[binarySearchFloor]);
            SeekPoint seekPoint = new SeekPoint(convertGranuleToTime, this.firstFrameOffset + this.seekPointOffsets[binarySearchFloor]);
            if (convertGranuleToTime < j4) {
                long[] jArr = this.seekPointGranules;
                if (binarySearchFloor != jArr.length - 1) {
                    int i4 = binarySearchFloor + 1;
                    return new SeekMap.SeekPoints(seekPoint, new SeekPoint(FlacReader.this.convertGranuleToTime(jArr[i4]), this.firstFrameOffset + this.seekPointOffsets[i4]));
                }
            }
            return new SeekMap.SeekPoints(seekPoint);
        }

        public boolean isSeekable() {
            return true;
        }

        public void parseSeekTable(ParsableByteArray parsableByteArray) {
            parsableByteArray.skipBytes(1);
            int readUnsignedInt24 = parsableByteArray.readUnsignedInt24() / 18;
            this.seekPointGranules = new long[readUnsignedInt24];
            this.seekPointOffsets = new long[readUnsignedInt24];
            for (int i4 = 0; i4 < readUnsignedInt24; i4++) {
                this.seekPointGranules[i4] = parsableByteArray.readLong();
                this.seekPointOffsets[i4] = parsableByteArray.readLong();
                parsableByteArray.skipBytes(2);
            }
        }

        public long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
            long j4 = this.pendingSeekGranule;
            if (j4 < 0) {
                return -1;
            }
            long j5 = -(j4 + 2);
            this.pendingSeekGranule = -1;
            return j5;
        }

        public void setFirstFrameOffset(long j4) {
            this.firstFrameOffset = j4;
        }

        public long startSeek(long j4) {
            long convertTimeToGranule = FlacReader.this.convertTimeToGranule(j4);
            this.pendingSeekGranule = this.seekPointGranules[Util.binarySearchFloor(this.seekPointGranules, convertTimeToGranule, true, true)];
            return convertTimeToGranule;
        }
    }

    FlacReader() {
    }

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray) {
        int i4;
        int i5;
        int i6;
        int i7 = (parsableByteArray.data[2] & AUDIO_PACKET_TYPE) >> 4;
        switch (i7) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                i4 = 576;
                i5 = i7 - 2;
                break;
            case 6:
            case 7:
                parsableByteArray.skipBytes(4);
                parsableByteArray.readUtf8EncodedLong();
                if (i7 == 6) {
                    i6 = parsableByteArray.readUnsignedByte();
                } else {
                    i6 = parsableByteArray.readUnsignedShort();
                }
                parsableByteArray.setPosition(0);
                return i6 + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i5 = i7 - 8;
                i4 = 256;
                break;
            default:
                return -1;
        }
        return i4 << i5;
    }

    private static boolean isAudioPacket(byte[] bArr) {
        if (bArr[0] == -1) {
            return true;
        }
        return false;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        if (!isAudioPacket(parsableByteArray.data)) {
            return -1;
        }
        return (long) getFlacFrameBlockSize(parsableByteArray);
    }

    /* access modifiers changed from: protected */
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j4, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        byte[] bArr = parsableByteArray.data;
        if (this.streamInfo == null) {
            this.streamInfo = new FlacStreamInfo(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, parsableByteArray.limit());
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            int bitRate = this.streamInfo.bitRate();
            FlacStreamInfo flacStreamInfo = this.streamInfo;
            setupData.format = Format.createAudioSampleFormat((String) null, MimeTypes.AUDIO_FLAC, (String) null, -1, bitRate, flacStreamInfo.channels, flacStreamInfo.sampleRate, singletonList, (DrmInitData) null, 0, (String) null);
            return true;
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            FlacOggSeeker flacOggSeeker2 = new FlacOggSeeker();
            this.flacOggSeeker = flacOggSeeker2;
            flacOggSeeker2.parseSeekTable(parsableByteArray);
            return true;
        } else if (!isAudioPacket(bArr)) {
            return true;
        } else {
            FlacOggSeeker flacOggSeeker3 = this.flacOggSeeker;
            if (flacOggSeeker3 != null) {
                flacOggSeeker3.setFirstFrameOffset(j4);
                setupData.oggSeeker = this.flacOggSeeker;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void reset(boolean z4) {
        super.reset(z4);
        if (z4) {
            this.streamInfo = null;
            this.flacOggSeeker = null;
        }
    }
}
