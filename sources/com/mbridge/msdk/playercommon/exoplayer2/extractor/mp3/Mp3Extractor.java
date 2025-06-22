package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Id3Peeker;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new Mp3Extractor()};
        }
    };
    public static final int FLAG_DISABLE_ID3_METADATA = 2;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    private static final int MAX_SNIFF_BYTES = 16384;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = Util.getIntegerCodeForString("Info");
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = Util.getIntegerCodeForString("VBRI");
    private static final int SEEK_HEADER_XING = Util.getIntegerCodeForString("Xing");
    private long basisTimeUs;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private Metadata metadata;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private Seeker seeker;
    private final MpegAudioHeader synchronizedHeader;
    private int synchronizedHeaderData;
    private TrackOutput trackOutput;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    interface Seeker extends SeekMap {
        long getTimeUs(long j4);
    }

    public Mp3Extractor() {
        this(0);
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.peekFully(this.scratch.data, 0, 4);
        this.scratch.setPosition(0);
        MpegAudioHeader.populateHeader(this.scratch.readInt(), this.synchronizedHeader);
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i4) {
        if (parsableByteArray.limit() >= i4 + 4) {
            parsableByteArray.setPosition(i4);
            int readInt = parsableByteArray.readInt();
            if (readInt == SEEK_HEADER_XING || readInt == SEEK_HEADER_INFO) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        int readInt2 = parsableByteArray.readInt();
        int i5 = SEEK_HEADER_VBRI;
        if (readInt2 == i5) {
            return i5;
        }
        return 0;
    }

    private static boolean headersMatch(int i4, long j4) {
        return ((long) (i4 & MPEG_AUDIO_HEADER_MASK)) == (j4 & -128000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker maybeReadSeekFrame(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r5 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r0 = r9.synchronizedHeader
            int r0 = r0.frameSize
            r5.<init>((int) r0)
            byte[] r0 = r5.data
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r1 = r9.synchronizedHeader
            int r1 = r1.frameSize
            r6 = 0
            r10.peekFully(r0, r6, r1)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r0 = r9.synchronizedHeader
            int r1 = r0.version
            r2 = 1
            r1 = r1 & r2
            r3 = 21
            int r0 = r0.channels
            if (r1 == 0) goto L_0x0029
            if (r0 == r2) goto L_0x0026
            r3 = 36
            r7 = 36
            goto L_0x0030
        L_0x0026:
            r7 = 21
            goto L_0x0030
        L_0x0029:
            if (r0 == r2) goto L_0x002c
            goto L_0x0026
        L_0x002c:
            r3 = 13
            r7 = 13
        L_0x0030:
            int r8 = getSeekFrameHeader(r5, r7)
            int r0 = SEEK_HEADER_XING
            if (r8 == r0) goto L_0x005c
            int r0 = SEEK_HEADER_INFO
            if (r8 != r0) goto L_0x003d
            goto L_0x005c
        L_0x003d:
            int r0 = SEEK_HEADER_VBRI
            if (r8 != r0) goto L_0x0057
            long r0 = r10.getLength()
            long r2 = r10.getPosition()
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r4 = r9.synchronizedHeader
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.VbriSeeker r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.VbriSeeker.create(r0, r2, r4, r5)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r1 = r9.synchronizedHeader
            int r1 = r1.frameSize
            r10.skipFully(r1)
            return r0
        L_0x0057:
            r10.resetPeekPosition()
            r10 = 0
            return r10
        L_0x005c:
            long r0 = r10.getLength()
            long r2 = r10.getPosition()
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r4 = r9.synchronizedHeader
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.XingSeeker r0 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.XingSeeker.create(r0, r2, r4, r5)
            if (r0 == 0) goto L_0x0094
            com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder r1 = r9.gaplessInfoHolder
            boolean r1 = r1.hasGaplessInfo()
            if (r1 != 0) goto L_0x0094
            r10.resetPeekPosition()
            int r7 = r7 + 141
            r10.advancePeekPosition(r7)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = r9.scratch
            byte[] r1 = r1.data
            r2 = 3
            r10.peekFully(r1, r6, r2)
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = r9.scratch
            r1.setPosition(r6)
            com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder r1 = r9.gaplessInfoHolder
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r2 = r9.scratch
            int r2 = r2.readUnsignedInt24()
            r1.setFromXingHeaderValue(r2)
        L_0x0094:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader r1 = r9.synchronizedHeader
            int r1 = r1.frameSize
            r10.skipFully(r1)
            if (r0 == 0) goto L_0x00ac
            boolean r1 = r0.isSeekable()
            if (r1 != 0) goto L_0x00ac
            int r1 = SEEK_HEADER_INFO
            if (r8 != r1) goto L_0x00ac
            com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor$Seeker r10 = r9.getConstantBitrateSeeker(r10)
            return r10
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.maybeReadSeekFrame(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput):com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor$Seeker");
    }

    private int readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (!extractorInput.peekFully(this.scratch.data, 0, 4, true)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if (!headersMatch(readInt, (long) this.synchronizedHeaderData) || MpegAudioHeader.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
            if (this.basisTimeUs == C.TIME_UNSET) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
        }
        int sampleData = this.trackOutput.sampleData(extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        int i4 = this.sampleBytesRemaining - sampleData;
        this.sampleBytesRemaining = i4;
        if (i4 > 0) {
            return 0;
        }
        long j4 = this.basisTimeUs;
        MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
        this.trackOutput.sampleMetadata(j4 + ((this.samplesRead * 1000000) / ((long) mpegAudioHeader.sampleRate)), 1, mpegAudioHeader.frameSize, 0, (TrackOutput.CryptoData) null);
        this.samplesRead += (long) this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z4) throws IOException, InterruptedException {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z5;
        int frameSize;
        Id3Decoder.FramePredicate framePredicate;
        if (z4) {
            i4 = 16384;
        } else {
            i4 = 131072;
        }
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.flags & 2) != 0) {
                framePredicate = GaplessInfoHolder.GAPLESS_INFO_ID3_FRAME_PREDICATE;
            } else {
                framePredicate = null;
            }
            Metadata peekId3Data = this.id3Peeker.peekId3Data(extractorInput, framePredicate);
            this.metadata = peekId3Data;
            if (peekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(peekId3Data);
            }
            i6 = (int) extractorInput.getPeekPosition();
            if (!z4) {
                extractorInput.skipFully(i6);
            }
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            byte[] bArr = this.scratch.data;
            if (i7 > 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!extractorInput.peekFully(bArr, 0, 4, z5)) {
                break;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if ((i8 == 0 || headersMatch(readInt, (long) i8)) && (frameSize = MpegAudioHeader.getFrameSize(readInt)) != -1) {
                i7++;
                if (i7 != 1) {
                    if (i7 == 4) {
                        break;
                    }
                } else {
                    MpegAudioHeader.populateHeader(readInt, this.synchronizedHeader);
                    i8 = readInt;
                }
                extractorInput.advancePeekPosition(frameSize - 4);
            } else {
                int i10 = i9 + 1;
                if (i9 != i4) {
                    if (z4) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i6 + i10);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i9 = i10;
                    i7 = 0;
                    i8 = 0;
                } else if (z4) {
                    return false;
                } else {
                    throw new ParserException("Searched too many bytes.");
                }
            }
        }
        if (z4) {
            extractorInput.skipFully(i6 + i9);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i8;
        return true;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        this.extractorOutput.endTracks();
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        Metadata metadata2;
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        } else {
            ExtractorInput extractorInput2 = extractorInput;
        }
        if (this.seeker == null) {
            Seeker maybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
            this.seeker = maybeReadSeekFrame;
            if (maybeReadSeekFrame == null || (!maybeReadSeekFrame.isSeekable() && (this.flags & 1) != 0)) {
                this.seeker = getConstantBitrateSeeker(extractorInput);
            }
            this.extractorOutput.seekMap(this.seeker);
            TrackOutput trackOutput2 = this.trackOutput;
            MpegAudioHeader mpegAudioHeader = this.synchronizedHeader;
            String str = mpegAudioHeader.mimeType;
            int i4 = mpegAudioHeader.channels;
            int i5 = mpegAudioHeader.sampleRate;
            GaplessInfoHolder gaplessInfoHolder2 = this.gaplessInfoHolder;
            int i6 = gaplessInfoHolder2.encoderDelay;
            int i7 = gaplessInfoHolder2.encoderPadding;
            if ((this.flags & 2) != 0) {
                metadata2 = null;
            } else {
                metadata2 = this.metadata;
            }
            trackOutput2.format(Format.createAudioSampleFormat((String) null, str, (String) null, -1, 4096, i4, i5, -1, i6, i7, (List<byte[]>) null, (DrmInitData) null, 0, (String) null, metadata2));
        }
        return readSample(extractorInput);
    }

    public final void release() {
    }

    public final void seek(long j4, long j5) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = C.TIME_UNSET;
        this.samplesRead = 0;
        this.sampleBytesRemaining = 0;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return synchronize(extractorInput, true);
    }

    public Mp3Extractor(int i4) {
        this(i4, C.TIME_UNSET);
    }

    public Mp3Extractor(int i4, long j4) {
        this.flags = i4;
        this.forcedFirstSampleTimestampUs = j4;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioHeader();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
        this.id3Peeker = new Id3Peeker();
    }
}
