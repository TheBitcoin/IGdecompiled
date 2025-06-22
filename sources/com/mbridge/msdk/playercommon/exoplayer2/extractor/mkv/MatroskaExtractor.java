package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class MatroskaExtractor implements Extractor {
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    };
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    /* access modifiers changed from: private */
    public static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final byte[] SSA_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final byte[] SUBRIP_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    /* access modifiers changed from: private */
    public static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int[] blockLacingSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        private InnerEbmlReaderOutput() {
        }

        public final void binaryElement(int i4, int i5, ExtractorInput extractorInput) throws IOException, InterruptedException {
            MatroskaExtractor.this.binaryElement(i4, i5, extractorInput);
        }

        public final void endMasterElement(int i4) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i4);
        }

        public final void floatElement(int i4, double d5) throws ParserException {
            MatroskaExtractor.this.floatElement(i4, d5);
        }

        public final int getElementType(int i4) {
            switch (i4) {
                case MatroskaExtractor.ID_TRACK_TYPE /*131*/:
                case MatroskaExtractor.ID_FLAG_DEFAULT /*136*/:
                case MatroskaExtractor.ID_BLOCK_DURATION /*155*/:
                case MatroskaExtractor.ID_CHANNELS /*159*/:
                case MatroskaExtractor.ID_PIXEL_WIDTH /*176*/:
                case MatroskaExtractor.ID_CUE_TIME /*179*/:
                case MatroskaExtractor.ID_PIXEL_HEIGHT /*186*/:
                case MatroskaExtractor.ID_TRACK_NUMBER /*215*/:
                case MatroskaExtractor.ID_TIME_CODE /*231*/:
                case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /*241*/:
                case MatroskaExtractor.ID_REFERENCE_BLOCK /*251*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                case MatroskaExtractor.ID_DOC_TYPE_READ_VERSION /*17029*/:
                case MatroskaExtractor.ID_EBML_READ_VERSION /*17143*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING_ORDER /*20529*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING_SCOPE /*20530*/:
                case MatroskaExtractor.ID_SEEK_POSITION /*21420*/:
                case MatroskaExtractor.ID_STEREO_MODE /*21432*/:
                case MatroskaExtractor.ID_DISPLAY_WIDTH /*21680*/:
                case MatroskaExtractor.ID_DISPLAY_UNIT /*21682*/:
                case MatroskaExtractor.ID_DISPLAY_HEIGHT /*21690*/:
                case MatroskaExtractor.ID_FLAG_FORCED /*21930*/:
                case MatroskaExtractor.ID_COLOUR_RANGE /*21945*/:
                case MatroskaExtractor.ID_COLOUR_TRANSFER /*21946*/:
                case MatroskaExtractor.ID_COLOUR_PRIMARIES /*21947*/:
                case MatroskaExtractor.ID_MAX_CLL /*21948*/:
                case MatroskaExtractor.ID_MAX_FALL /*21949*/:
                case MatroskaExtractor.ID_CODEC_DELAY /*22186*/:
                case MatroskaExtractor.ID_SEEK_PRE_ROLL /*22203*/:
                case MatroskaExtractor.ID_AUDIO_BIT_DEPTH /*25188*/:
                case MatroskaExtractor.ID_DEFAULT_DURATION /*2352003*/:
                case MatroskaExtractor.ID_TIMECODE_SCALE /*2807729*/:
                    return 2;
                case 134:
                case MatroskaExtractor.ID_DOC_TYPE /*17026*/:
                case MatroskaExtractor.ID_LANGUAGE /*2274716*/:
                    return 3;
                case MatroskaExtractor.ID_BLOCK_GROUP /*160*/:
                case MatroskaExtractor.ID_TRACK_ENTRY /*174*/:
                case MatroskaExtractor.ID_CUE_TRACK_POSITIONS /*183*/:
                case MatroskaExtractor.ID_CUE_POINT /*187*/:
                case 224:
                case MatroskaExtractor.ID_AUDIO /*225*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_AES_SETTINGS /*18407*/:
                case MatroskaExtractor.ID_SEEK /*19899*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION /*20532*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION /*20533*/:
                case MatroskaExtractor.ID_COLOUR /*21936*/:
                case MatroskaExtractor.ID_MASTERING_METADATA /*21968*/:
                case MatroskaExtractor.ID_CONTENT_ENCODING /*25152*/:
                case MatroskaExtractor.ID_CONTENT_ENCODINGS /*28032*/:
                case MatroskaExtractor.ID_PROJECTION /*30320*/:
                case MatroskaExtractor.ID_SEEK_HEAD /*290298740*/:
                case 357149030:
                case MatroskaExtractor.ID_TRACKS /*374648427*/:
                case MatroskaExtractor.ID_SEGMENT /*408125543*/:
                case MatroskaExtractor.ID_EBML /*440786851*/:
                case MatroskaExtractor.ID_CUES /*475249515*/:
                case MatroskaExtractor.ID_CLUSTER /*524531317*/:
                    return 1;
                case MatroskaExtractor.ID_BLOCK /*161*/:
                case MatroskaExtractor.ID_SIMPLE_BLOCK /*163*/:
                case MatroskaExtractor.ID_CONTENT_COMPRESSION_SETTINGS /*16981*/:
                case MatroskaExtractor.ID_CONTENT_ENCRYPTION_KEY_ID /*18402*/:
                case MatroskaExtractor.ID_SEEK_ID /*21419*/:
                case MatroskaExtractor.ID_CODEC_PRIVATE /*25506*/:
                case MatroskaExtractor.ID_PROJECTION_PRIVATE /*30322*/:
                    return 4;
                case MatroskaExtractor.ID_SAMPLING_FREQUENCY /*181*/:
                case MatroskaExtractor.ID_DURATION /*17545*/:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                case MatroskaExtractor.ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                case MatroskaExtractor.ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                case MatroskaExtractor.ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                case MatroskaExtractor.ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                case MatroskaExtractor.ID_LUMNINANCE_MAX /*21977*/:
                case MatroskaExtractor.ID_LUMNINANCE_MIN /*21978*/:
                    return 5;
                default:
                    return 0;
            }
        }

        public final void integerElement(int i4, long j4) throws ParserException {
            MatroskaExtractor.this.integerElement(i4, j4);
        }

        public final boolean isLevel1Element(int i4) {
            return i4 == 357149030 || i4 == MatroskaExtractor.ID_CLUSTER || i4 == MatroskaExtractor.ID_CUES || i4 == MatroskaExtractor.ID_TRACKS;
        }

        public final void startMasterElement(int i4, long j4, long j5) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i4, j4, j5);
        }

        public final void stringElement(int i4, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i4, str);
        }
    }

    private static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        /* access modifiers changed from: private */
        public String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        @Nullable
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0;
            this.seekPreRollNs = 0;
            this.flagDefault = true;
            this.language = "eng";
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.put((byte) 0);
            wrap.putShort((short) ((int) ((this.primaryRChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryRChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryGChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryGChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryBChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.primaryBChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.whitePointChromaticityX * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) ((this.whitePointChromaticityY * 50000.0f) + 0.5f)));
            wrap.putShort((short) ((int) (this.maxMasteringLuminance + 0.5f)));
            wrap.putShort((short) ((int) (this.minMasteringLuminance + 0.5f)));
            wrap.putShort((short) this.maxContentLuminance);
            wrap.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_H263, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] bArr = parsableByteArray.data;
                    for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort == MatroskaExtractor.WAVE_FORMAT_EXTENSIBLE) {
                    parsableByteArray.setPosition(24);
                    if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            byte b5;
            byte b6;
            try {
                if (bArr[0] == 2) {
                    int i4 = 1;
                    int i5 = 0;
                    while (true) {
                        b5 = bArr[i4];
                        if (b5 != -1) {
                            break;
                        }
                        i5 += 255;
                        i4++;
                    }
                    int i6 = i4 + 1;
                    int i7 = i5 + b5;
                    int i8 = 0;
                    while (true) {
                        b6 = bArr[i6];
                        if (b6 != -1) {
                            break;
                        }
                        i8 += 255;
                        i6++;
                    }
                    int i9 = i6 + 1;
                    int i10 = i8 + b6;
                    if (bArr[i9] == 1) {
                        byte[] bArr2 = new byte[i7];
                        System.arraycopy(bArr, i9, bArr2, 0, i7);
                        int i11 = i9 + i7;
                        if (bArr[i11] == 3) {
                            int i12 = i11 + i10;
                            if (bArr[i12] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i12)];
                                System.arraycopy(bArr, i12, bArr3, 0, bArr.length - i12);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v12, resolved type: java.util.ArrayList} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0250, code lost:
            r22 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0252, code lost:
            r29 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x026e, code lost:
            r29 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0296, code lost:
            r22 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0299, code lost:
            r28 = r2;
            r22 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.AUDIO_RAW;
            r29 = null;
            r25 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x0317, code lost:
            r22 = r12;
            r29 = null;
            r25 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x0395, code lost:
            r1 = r0.flagDefault;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x0399, code lost:
            if (r0.flagForced == false) goto L_0x039d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x039b, code lost:
            r18 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x039d, code lost:
            r31 = r1 | r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x03a3, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isAudio(r22) == false) goto L_0x03c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x03a5, code lost:
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(java.lang.Integer.toString(r43), r22, (java.lang.String) null, -1, r25, r0.channelCount, r0.sampleRate, r28, r29, r0.drmInitData, r31, r0.language);
            r5 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:147:0x03c4, code lost:
            r1 = r31;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x03ca, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isVideo(r22) == false) goto L_0x0439;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x03ce, code lost:
            if (r0.displayUnit != 0) goto L_0x03e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x03d0, code lost:
            r1 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x03d2, code lost:
            if (r1 != -1) goto L_0x03d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x03d4, code lost:
            r1 = r0.width;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x03d6, code lost:
            r0.displayWidth = r1;
            r1 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x03da, code lost:
            if (r1 != -1) goto L_0x03de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x03dc, code lost:
            r1 = r0.height;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x03de, code lost:
            r0.displayHeight = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x03e0, code lost:
            r1 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x03e2, code lost:
            if (r1 == -1) goto L_0x03f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x03e4, code lost:
            r2 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x03e6, code lost:
            if (r2 == -1) goto L_0x03f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x03e8, code lost:
            r31 = ((float) (r0.height * r1)) / ((float) (r0.width * r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x03f6, code lost:
            r31 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x03fc, code lost:
            if (r0.hasColorInfo == false) goto L_0x0410;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x03fe, code lost:
            r34 = new com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo(r0.colorSpace, r0.colorRange, r0.colorTransfer, getHdrStaticInfo());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0410, code lost:
            r34 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x0412, code lost:
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(java.lang.Integer.toString(r43), r22, (java.lang.String) null, -1, r25, r0.width, r0.height, -1.0f, r29, -1, r31, r0.projectionData, r0.stereoMode, r34, r0.drmInitData);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0439, code lost:
            r12 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x043f, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r12) == false) goto L_0x044f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0441, code lost:
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(java.lang.Integer.toString(r43), r12, r1, r0.language, r0.drmInitData);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0453, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r12) == false) goto L_0x0489;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0455, code lost:
            r2 = new java.util.ArrayList(2);
            r2.add(com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.access$300());
            r2.add(r0.codecPrivate);
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(java.lang.Integer.toString(r43), r12, (java.lang.String) null, -1, r1, r0.language, -1, r0.drmInitData, Long.MAX_VALUE, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x0489, code lost:
            r31 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x048f, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r12) != false) goto L_0x04a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x0495, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r12) != false) goto L_0x04a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x049b, code lost:
            if (com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r12) == false) goto L_0x049e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x04a5, code lost:
            throw new com.mbridge.msdk.playercommon.exoplayer2.ParserException("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x04a6, code lost:
            r25 = r31;
            r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createImageSampleFormat(java.lang.Integer.toString(r43), r12, (java.lang.String) null, -1, r25, r29, r0.language, r0.drmInitData);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x04c0, code lost:
            r2 = r42.track(r0.number, r5);
            r0.output = r2;
            r2.format(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x04cd, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e7, code lost:
            r3 = 65535;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x023b, code lost:
            r28 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0247, code lost:
            r29 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0249, code lost:
            r22 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x024b, code lost:
            r25 = -1;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void initializeOutput(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput r42, int r43) throws com.mbridge.msdk.playercommon.exoplayer2.ParserException {
            /*
                r41 = this;
                r0 = r41
                r2 = 4
                java.lang.String r3 = r0.codecId
                r3.getClass()
                java.lang.String r7 = "application/dvbsubs"
                java.lang.String r8 = "application/vobsub"
                java.lang.String r9 = "application/pgs"
                java.lang.String r10 = ". Setting mimeType to "
                java.lang.String r11 = "Unsupported PCM bit depth: "
                java.lang.String r12 = "audio/raw"
                java.lang.String r13 = "text/x-ssa"
                java.lang.String r14 = "application/x-subrip"
                java.lang.String r15 = "MatroskaExtractor"
                r16 = 8
                java.lang.String r1 = "audio/x-unknown"
                r17 = 1
                r5 = 3
                r18 = 0
                r6 = -1
                r19 = 0
                int r20 = r3.hashCode()
                switch(r20) {
                    case -2095576542: goto L_0x01dd;
                    case -2095575984: goto L_0x01d0;
                    case -1985379776: goto L_0x01c3;
                    case -1784763192: goto L_0x01b6;
                    case -1730367663: goto L_0x01a9;
                    case -1482641358: goto L_0x019c;
                    case -1482641357: goto L_0x018f;
                    case -1373388978: goto L_0x0182;
                    case -933872740: goto L_0x0172;
                    case -538363189: goto L_0x0162;
                    case -538363109: goto L_0x0152;
                    case -425012669: goto L_0x0142;
                    case -356037306: goto L_0x0132;
                    case 62923557: goto L_0x0122;
                    case 62923603: goto L_0x0112;
                    case 62927045: goto L_0x0102;
                    case 82338133: goto L_0x00f2;
                    case 82338134: goto L_0x00e2;
                    case 99146302: goto L_0x00d2;
                    case 444813526: goto L_0x00c2;
                    case 542569478: goto L_0x00b2;
                    case 725957860: goto L_0x00a2;
                    case 738597099: goto L_0x0092;
                    case 855502857: goto L_0x0082;
                    case 1422270023: goto L_0x0072;
                    case 1809237540: goto L_0x0062;
                    case 1950749482: goto L_0x0052;
                    case 1950789798: goto L_0x0042;
                    case 1951062397: goto L_0x0032;
                    default: goto L_0x002d;
                }
            L_0x002d:
                r3 = -1
                r20 = 2
                goto L_0x01ea
            L_0x0032:
                r20 = 2
                java.lang.String r4 = "A_OPUS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x003e
                goto L_0x01e7
            L_0x003e:
                r3 = 28
                goto L_0x01ea
            L_0x0042:
                r20 = 2
                java.lang.String r4 = "A_FLAC"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x004e
                goto L_0x01e7
            L_0x004e:
                r3 = 27
                goto L_0x01ea
            L_0x0052:
                r20 = 2
                java.lang.String r4 = "A_EAC3"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x005e
                goto L_0x01e7
            L_0x005e:
                r3 = 26
                goto L_0x01ea
            L_0x0062:
                r20 = 2
                java.lang.String r4 = "V_MPEG2"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x006e
                goto L_0x01e7
            L_0x006e:
                r3 = 25
                goto L_0x01ea
            L_0x0072:
                r20 = 2
                java.lang.String r4 = "S_TEXT/UTF8"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x007e
                goto L_0x01e7
            L_0x007e:
                r3 = 24
                goto L_0x01ea
            L_0x0082:
                r20 = 2
                java.lang.String r4 = "V_MPEGH/ISO/HEVC"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x008e
                goto L_0x01e7
            L_0x008e:
                r3 = 23
                goto L_0x01ea
            L_0x0092:
                r20 = 2
                java.lang.String r4 = "S_TEXT/ASS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x009e
                goto L_0x01e7
            L_0x009e:
                r3 = 22
                goto L_0x01ea
            L_0x00a2:
                r20 = 2
                java.lang.String r4 = "A_PCM/INT/LIT"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00ae
                goto L_0x01e7
            L_0x00ae:
                r3 = 21
                goto L_0x01ea
            L_0x00b2:
                r20 = 2
                java.lang.String r4 = "A_DTS/EXPRESS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00be
                goto L_0x01e7
            L_0x00be:
                r3 = 20
                goto L_0x01ea
            L_0x00c2:
                r20 = 2
                java.lang.String r4 = "V_THEORA"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00ce
                goto L_0x01e7
            L_0x00ce:
                r3 = 19
                goto L_0x01ea
            L_0x00d2:
                r20 = 2
                java.lang.String r4 = "S_HDMV/PGS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00de
                goto L_0x01e7
            L_0x00de:
                r3 = 18
                goto L_0x01ea
            L_0x00e2:
                r20 = 2
                java.lang.String r4 = "V_VP9"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00ee
                goto L_0x01e7
            L_0x00ee:
                r3 = 17
                goto L_0x01ea
            L_0x00f2:
                r20 = 2
                java.lang.String r4 = "V_VP8"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00fe
                goto L_0x01e7
            L_0x00fe:
                r3 = 16
                goto L_0x01ea
            L_0x0102:
                r20 = 2
                java.lang.String r4 = "A_DTS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x010e
                goto L_0x01e7
            L_0x010e:
                r3 = 15
                goto L_0x01ea
            L_0x0112:
                r20 = 2
                java.lang.String r4 = "A_AC3"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x011e
                goto L_0x01e7
            L_0x011e:
                r3 = 14
                goto L_0x01ea
            L_0x0122:
                r20 = 2
                java.lang.String r4 = "A_AAC"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x012e
                goto L_0x01e7
            L_0x012e:
                r3 = 13
                goto L_0x01ea
            L_0x0132:
                r20 = 2
                java.lang.String r4 = "A_DTS/LOSSLESS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x013e
                goto L_0x01e7
            L_0x013e:
                r3 = 12
                goto L_0x01ea
            L_0x0142:
                r20 = 2
                java.lang.String r4 = "S_VOBSUB"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x014e
                goto L_0x01e7
            L_0x014e:
                r3 = 11
                goto L_0x01ea
            L_0x0152:
                r20 = 2
                java.lang.String r4 = "V_MPEG4/ISO/AVC"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x015e
                goto L_0x01e7
            L_0x015e:
                r3 = 10
                goto L_0x01ea
            L_0x0162:
                r20 = 2
                java.lang.String r4 = "V_MPEG4/ISO/ASP"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x016e
                goto L_0x01e7
            L_0x016e:
                r3 = 9
                goto L_0x01ea
            L_0x0172:
                r20 = 2
                java.lang.String r4 = "S_DVBSUB"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x017e
                goto L_0x01e7
            L_0x017e:
                r3 = 8
                goto L_0x01ea
            L_0x0182:
                r20 = 2
                java.lang.String r4 = "V_MS/VFW/FOURCC"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x018d
                goto L_0x01e7
            L_0x018d:
                r3 = 7
                goto L_0x01ea
            L_0x018f:
                r20 = 2
                java.lang.String r4 = "A_MPEG/L3"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x019a
                goto L_0x01e7
            L_0x019a:
                r3 = 6
                goto L_0x01ea
            L_0x019c:
                r20 = 2
                java.lang.String r4 = "A_MPEG/L2"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01a7
                goto L_0x01e7
            L_0x01a7:
                r3 = 5
                goto L_0x01ea
            L_0x01a9:
                r20 = 2
                java.lang.String r4 = "A_VORBIS"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01b4
                goto L_0x01e7
            L_0x01b4:
                r3 = 4
                goto L_0x01ea
            L_0x01b6:
                r20 = 2
                java.lang.String r4 = "A_TRUEHD"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01c1
                goto L_0x01e7
            L_0x01c1:
                r3 = 3
                goto L_0x01ea
            L_0x01c3:
                r20 = 2
                java.lang.String r4 = "A_MS/ACM"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01ce
                goto L_0x01e7
            L_0x01ce:
                r3 = 2
                goto L_0x01ea
            L_0x01d0:
                r20 = 2
                java.lang.String r4 = "V_MPEG4/ISO/SP"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01db
                goto L_0x01e7
            L_0x01db:
                r3 = 1
                goto L_0x01ea
            L_0x01dd:
                r20 = 2
                java.lang.String r4 = "V_MPEG4/ISO/AP"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x01e9
            L_0x01e7:
                r3 = -1
                goto L_0x01ea
            L_0x01e9:
                r3 = 0
            L_0x01ea:
                switch(r3) {
                    case 0: goto L_0x0386;
                    case 1: goto L_0x0386;
                    case 2: goto L_0x033f;
                    case 3: goto L_0x0334;
                    case 4: goto L_0x0322;
                    case 5: goto L_0x031f;
                    case 6: goto L_0x0315;
                    case 7: goto L_0x02ff;
                    case 8: goto L_0x02e1;
                    case 9: goto L_0x0386;
                    case 10: goto L_0x02cd;
                    case 11: goto L_0x02c1;
                    case 12: goto L_0x02be;
                    case 13: goto L_0x02b5;
                    case 14: goto L_0x02b2;
                    case 15: goto L_0x02af;
                    case 16: goto L_0x02ac;
                    case 17: goto L_0x02a9;
                    case 18: goto L_0x02a6;
                    case 19: goto L_0x02a3;
                    case 20: goto L_0x02af;
                    case 21: goto L_0x0274;
                    case 22: goto L_0x0271;
                    case 23: goto L_0x025b;
                    case 24: goto L_0x0258;
                    case 25: goto L_0x0255;
                    case 26: goto L_0x024e;
                    case 27: goto L_0x023f;
                    case 28: goto L_0x01f5;
                    default: goto L_0x01ed;
                }
            L_0x01ed:
                com.mbridge.msdk.playercommon.exoplayer2.ParserException r1 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01f5:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r5)
                byte[] r2 = r0.codecPrivate
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r16)
                java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r2 = r2.order(r3)
                long r3 = r0.codecDelayNs
                java.nio.ByteBuffer r2 = r2.putLong(r3)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r16)
                java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
                java.nio.ByteBuffer r2 = r2.order(r3)
                long r3 = r0.seekPreRollNs
                java.nio.ByteBuffer r2 = r2.putLong(r3)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.lang.String r12 = "audio/opus"
                r4 = 5760(0x1680, float:8.071E-42)
                r29 = r1
                r22 = r12
                r25 = 5760(0x1680, float:8.071E-42)
            L_0x023b:
                r28 = -1
                goto L_0x0395
            L_0x023f:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r12 = "audio/flac"
            L_0x0247:
                r29 = r1
            L_0x0249:
                r22 = r12
            L_0x024b:
                r25 = -1
                goto L_0x023b
            L_0x024e:
                java.lang.String r12 = "audio/eac3"
            L_0x0250:
                r22 = r12
            L_0x0252:
                r29 = r19
                goto L_0x024b
            L_0x0255:
                java.lang.String r12 = "video/mpeg2"
                goto L_0x0250
            L_0x0258:
                r22 = r14
                goto L_0x0252
            L_0x025b:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r2 = r0.codecPrivate
                r1.<init>((byte[]) r2)
                com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig r1 = com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig.parse(r1)
                java.util.List<byte[]> r2 = r1.initializationData
                int r1 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r1
                java.lang.String r12 = "video/hevc"
            L_0x026e:
                r29 = r2
                goto L_0x0249
            L_0x0271:
                r22 = r13
                goto L_0x0252
            L_0x0274:
                int r2 = r0.audioBitDepth
                int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmEncoding(r2)
                if (r2 != 0) goto L_0x0299
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r11)
                int r3 = r0.audioBitDepth
                r2.append(r3)
                r2.append(r10)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r15, r2)
            L_0x0296:
                r22 = r1
                goto L_0x0252
            L_0x0299:
                r28 = r2
                r22 = r12
                r29 = r19
                r25 = -1
                goto L_0x0395
            L_0x02a3:
                java.lang.String r12 = "video/x-unknown"
                goto L_0x0250
            L_0x02a6:
                r22 = r9
                goto L_0x0252
            L_0x02a9:
                java.lang.String r12 = "video/x-vnd.on2.vp9"
                goto L_0x0250
            L_0x02ac:
                java.lang.String r12 = "video/x-vnd.on2.vp8"
                goto L_0x0250
            L_0x02af:
                java.lang.String r12 = "audio/vnd.dts"
                goto L_0x0250
            L_0x02b2:
                java.lang.String r12 = "audio/ac3"
                goto L_0x0250
            L_0x02b5:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r12 = "audio/mp4a-latm"
                goto L_0x0247
            L_0x02be:
                java.lang.String r12 = "audio/vnd.dts.hd"
                goto L_0x0250
            L_0x02c1:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r29 = r1
                r22 = r8
                goto L_0x024b
            L_0x02cd:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r2 = r0.codecPrivate
                r1.<init>((byte[]) r2)
                com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig r1 = com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig.parse(r1)
                java.util.List<byte[]> r2 = r1.initializationData
                int r1 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r1
                java.lang.String r12 = "video/avc"
                goto L_0x026e
            L_0x02e1:
                byte[] r1 = r0.codecPrivate
                byte r3 = r1[r18]
                byte r4 = r1[r17]
                byte r10 = r1[r20]
                byte r1 = r1[r5]
                byte[] r2 = new byte[r2]
                r2[r18] = r3
                r2[r17] = r4
                r2[r20] = r10
                r2[r5] = r1
                java.util.List r1 = java.util.Collections.singletonList(r2)
                r29 = r1
                r22 = r7
                goto L_0x024b
            L_0x02ff:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r2 = r0.codecPrivate
                r1.<init>((byte[]) r2)
                android.util.Pair r1 = parseFourCcPrivate(r1)
                java.lang.Object r2 = r1.first
                r12 = r2
                java.lang.String r12 = (java.lang.String) r12
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
                goto L_0x0247
            L_0x0315:
                java.lang.String r12 = "audio/mpeg"
            L_0x0317:
                r22 = r12
                r29 = r19
                r25 = 4096(0x1000, float:5.74E-42)
                goto L_0x023b
            L_0x031f:
                java.lang.String r12 = "audio/mpeg-L2"
                goto L_0x0317
            L_0x0322:
                byte[] r1 = r0.codecPrivate
                java.util.List r1 = parseVorbisCodecPrivate(r1)
                java.lang.String r12 = "audio/vorbis"
                r4 = 8192(0x2000, float:1.14794E-41)
                r29 = r1
                r22 = r12
                r25 = 8192(0x2000, float:1.14794E-41)
                goto L_0x023b
            L_0x0334:
                com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker r1 = new com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker
                r1.<init>()
                r0.trueHdSampleRechunker = r1
                java.lang.String r12 = "audio/true-hd"
                goto L_0x0250
            L_0x033f:
                com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r2 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
                byte[] r3 = r0.codecPrivate
                r2.<init>((byte[]) r3)
                boolean r2 = parseMsAcmCodecPrivate(r2)
                if (r2 == 0) goto L_0x0370
                int r2 = r0.audioBitDepth
                int r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.getPcmEncoding(r2)
                if (r2 != 0) goto L_0x0299
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r11)
                int r3 = r0.audioBitDepth
                r2.append(r3)
                r2.append(r10)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r15, r2)
                goto L_0x0296
            L_0x0370:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r15, r2)
                goto L_0x0296
            L_0x0386:
                byte[] r1 = r0.codecPrivate
                if (r1 != 0) goto L_0x038d
                r1 = r19
                goto L_0x0391
            L_0x038d:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0391:
                java.lang.String r12 = "video/mp4v-es"
                goto L_0x0247
            L_0x0395:
                boolean r1 = r0.flagDefault
                boolean r2 = r0.flagForced
                if (r2 == 0) goto L_0x039d
                r18 = 2
            L_0x039d:
                r31 = r1 | r18
                boolean r1 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isAudio(r22)
                if (r1 == 0) goto L_0x03c4
                java.lang.String r21 = java.lang.Integer.toString(r43)
                int r1 = r0.channelCount
                int r2 = r0.sampleRate
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r3 = r0.drmInitData
                java.lang.String r4 = r0.language
                r23 = 0
                r24 = -1
                r26 = r1
                r27 = r2
                r30 = r3
                r32 = r4
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createAudioSampleFormat(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
                r5 = 1
                goto L_0x04c0
            L_0x03c4:
                r1 = r31
                boolean r2 = com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes.isVideo(r22)
                if (r2 == 0) goto L_0x0439
                int r1 = r0.displayUnit
                if (r1 != 0) goto L_0x03e0
                int r1 = r0.displayWidth
                if (r1 != r6) goto L_0x03d6
                int r1 = r0.width
            L_0x03d6:
                r0.displayWidth = r1
                int r1 = r0.displayHeight
                if (r1 != r6) goto L_0x03de
                int r1 = r0.height
            L_0x03de:
                r0.displayHeight = r1
            L_0x03e0:
                int r1 = r0.displayWidth
                if (r1 == r6) goto L_0x03f6
                int r2 = r0.displayHeight
                if (r2 == r6) goto L_0x03f6
                int r3 = r0.height
                int r3 = r3 * r1
                float r1 = (float) r3
                int r3 = r0.width
                int r3 = r3 * r2
                float r2 = (float) r3
                float r1 = r1 / r2
                r31 = r1
                goto L_0x03fa
            L_0x03f6:
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r31 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x03fa:
                boolean r1 = r0.hasColorInfo
                if (r1 == 0) goto L_0x0410
                byte[] r1 = r0.getHdrStaticInfo()
                com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo r2 = new com.mbridge.msdk.playercommon.exoplayer2.video.ColorInfo
                int r3 = r0.colorSpace
                int r4 = r0.colorRange
                int r5 = r0.colorTransfer
                r2.<init>(r3, r4, r5, r1)
                r34 = r2
                goto L_0x0412
            L_0x0410:
                r34 = r19
            L_0x0412:
                java.lang.String r21 = java.lang.Integer.toString(r43)
                int r1 = r0.width
                int r2 = r0.height
                byte[] r3 = r0.projectionData
                int r4 = r0.stereoMode
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r5 = r0.drmInitData
                r23 = 0
                r24 = -1
                r28 = -1082130432(0xffffffffbf800000, float:-1.0)
                r30 = -1
                r26 = r1
                r27 = r2
                r32 = r3
                r33 = r4
                r35 = r5
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createVideoSampleFormat(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
                r5 = 2
                goto L_0x04c0
            L_0x0439:
                r12 = r22
                boolean r2 = r14.equals(r12)
                if (r2 == 0) goto L_0x044f
                java.lang.String r2 = java.lang.Integer.toString(r43)
                java.lang.String r3 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r4 = r0.drmInitData
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(r2, r12, r1, r3, r4)
                goto L_0x04c0
            L_0x044f:
                boolean r2 = r13.equals(r12)
                if (r2 == 0) goto L_0x0489
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 2
                r2.<init>(r3)
                byte[] r3 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.SSA_DIALOGUE_FORMAT
                r2.add(r3)
                byte[] r3 = r0.codecPrivate
                r2.add(r3)
                java.lang.String r30 = java.lang.Integer.toString(r43)
                java.lang.String r3 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r4 = r0.drmInitData
                r38 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r32 = 0
                r33 = -1
                r36 = -1
                r34 = r1
                r40 = r2
                r35 = r3
                r37 = r4
                r31 = r12
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createTextSampleFormat(r30, r31, r32, r33, r34, r35, r36, r37, r38, r40)
                goto L_0x04c0
            L_0x0489:
                r31 = r1
                boolean r1 = r8.equals(r12)
                if (r1 != 0) goto L_0x04a6
                boolean r1 = r9.equals(r12)
                if (r1 != 0) goto L_0x04a6
                boolean r1 = r7.equals(r12)
                if (r1 == 0) goto L_0x049e
                goto L_0x04a6
            L_0x049e:
                com.mbridge.msdk.playercommon.exoplayer2.ParserException r1 = new com.mbridge.msdk.playercommon.exoplayer2.ParserException
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x04a6:
                java.lang.String r21 = java.lang.Integer.toString(r43)
                java.lang.String r1 = r0.language
                com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
                r23 = 0
                r24 = -1
                r27 = r1
                r28 = r2
                r22 = r12
                r26 = r29
                r25 = r31
                com.mbridge.msdk.playercommon.exoplayer2.Format r1 = com.mbridge.msdk.playercommon.exoplayer2.Format.createImageSampleFormat(r21, r22, r23, r24, r25, r26, r27, r28)
            L_0x04c0:
                int r2 = r0.number
                r3 = r42
                com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput r2 = r3.track(r2, r5)
                r0.output = r2
                r2.format(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        public final void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.outputPendingSampleMetadata(this);
            }
        }

        public final void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.reset();
            }
        }
    }

    private static final class TrueHdSampleRechunker {
        private int blockFlags;
        private int chunkSize;
        private boolean foundSyncframe;
        private int sampleCount;
        private final byte[] syncframePrefix = new byte[10];
        private long timeUs;

        public final void outputPendingSampleMetadata(Track track) {
            if (this.foundSyncframe && this.sampleCount > 0) {
                track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                this.sampleCount = 0;
            }
        }

        public final void reset() {
            this.foundSyncframe = false;
        }

        public final void sampleMetadata(Track track, long j4) {
            if (this.foundSyncframe) {
                int i4 = this.sampleCount;
                int i5 = i4 + 1;
                this.sampleCount = i5;
                if (i4 == 0) {
                    this.timeUs = j4;
                }
                if (i5 >= 16) {
                    track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                    this.sampleCount = 0;
                }
            }
        }

        public final void startSample(ExtractorInput extractorInput, int i4, int i5) throws IOException, InterruptedException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != -1) {
                    this.foundSyncframe = true;
                    this.sampleCount = 0;
                } else {
                    return;
                }
            }
            if (this.sampleCount == 0) {
                this.blockFlags = i4;
                this.chunkSize = 0;
            }
            this.chunkSize += i5;
        }
    }

    public MatroskaExtractor() {
        this(0);
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        if (this.segmentContentPosition == -1 || this.durationUs == C.TIME_UNSET || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            jArr3[i5] = this.cueTimesUs.get(i5);
            jArr[i5] = this.segmentContentPosition + this.cueClusterPositions.get(i5);
        }
        while (true) {
            int i6 = size - 1;
            if (i4 < i6) {
                int i7 = i4 + 1;
                iArr[i4] = (int) (jArr[i7] - jArr[i4]);
                jArr2[i4] = jArr3[i7] - jArr3[i4];
                i4 = i7;
            } else {
                iArr[i6] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i6]);
                jArr2[i6] = this.durationUs - jArr3[i6];
                this.cueTimesUs = null;
                this.cueClusterPositions = null;
                return new ChunkIndex(iArr, jArr, jArr2, jArr3);
            }
        }
    }

    private void commitSampleToOutput(Track track, long j4) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j4);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, 10000, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j4, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
        }
        this.sampleRead = true;
        resetSample();
    }

    private void commitSubtitleSample(Track track, String str, int i4, long j4, byte[] bArr) {
        setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i4, j4, bArr);
        TrackOutput trackOutput = track.output;
        ParsableByteArray parsableByteArray = this.subtitleSample;
        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
        this.sampleBytesWritten += this.subtitleSample.limit();
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i4) {
        if (iArr == null) {
            return new int[i4];
        }
        if (iArr.length >= i4) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i4)];
    }

    private static boolean isCodecSupported(String str) {
        if (CODEC_ID_VP8.equals(str) || CODEC_ID_VP9.equals(str) || CODEC_ID_MPEG2.equals(str) || CODEC_ID_MPEG4_SP.equals(str) || CODEC_ID_MPEG4_ASP.equals(str) || CODEC_ID_MPEG4_AP.equals(str) || CODEC_ID_H264.equals(str) || CODEC_ID_H265.equals(str) || CODEC_ID_FOURCC.equals(str) || CODEC_ID_THEORA.equals(str) || CODEC_ID_OPUS.equals(str) || CODEC_ID_VORBIS.equals(str) || CODEC_ID_AAC.equals(str) || CODEC_ID_MP2.equals(str) || CODEC_ID_MP3.equals(str) || CODEC_ID_AC3.equals(str) || CODEC_ID_E_AC3.equals(str) || CODEC_ID_TRUEHD.equals(str) || CODEC_ID_DTS.equals(str) || CODEC_ID_DTS_EXPRESS.equals(str) || CODEC_ID_DTS_LOSSLESS.equals(str) || CODEC_ID_FLAC.equals(str) || CODEC_ID_ACM.equals(str) || CODEC_ID_PCM_INT_LIT.equals(str) || CODEC_ID_SUBRIP.equals(str) || CODEC_ID_ASS.equals(str) || CODEC_ID_VOBSUB.equals(str) || CODEC_ID_PGS.equals(str) || CODEC_ID_DVBSUB.equals(str)) {
            return true;
        }
        return false;
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j4) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j4;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j5 = this.seekPositionAfterBuildingCues;
            if (j5 != -1) {
                positionHolder.position = j5;
                this.seekPositionAfterBuildingCues = -1;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i4) throws IOException, InterruptedException {
        if (this.scratch.limit() < i4) {
            if (this.scratch.capacity() < i4) {
                ParsableByteArray parsableByteArray = this.scratch;
                byte[] bArr = parsableByteArray.data;
                parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i4)), this.scratch.limit());
            }
            ParsableByteArray parsableByteArray2 = this.scratch;
            extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), i4 - this.scratch.limit());
            this.scratch.setLimit(i4);
        }
    }

    private int readToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i4) throws IOException, InterruptedException {
        int i5;
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft > 0) {
            i5 = Math.min(i4, bytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, i5);
        } else {
            i5 = trackOutput.sampleData(extractorInput, i4, false);
        }
        this.sampleBytesRead += i5;
        this.sampleBytesWritten += i5;
        return i5;
    }

    private void readToTarget(ExtractorInput extractorInput, byte[] bArr, int i4, int i5) throws IOException, InterruptedException {
        int min = Math.min(i5, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i4 + min, i5 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i4, min);
        }
        this.sampleBytesRead += i5;
    }

    private void resetSample() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long j4) throws ParserException {
        long j5 = this.timecodeScale;
        if (j5 != C.TIME_UNSET) {
            return Util.scaleLargeTimestamp(j4, j5, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSampleDuration(byte[] bArr, long j4, String str, int i4, long j5, byte[] bArr2) {
        byte[] bArr3;
        byte[] bArr4;
        if (j4 == C.TIME_UNSET) {
            bArr4 = bArr2;
            bArr3 = bArr4;
        } else {
            int i5 = (int) (j4 / 3600000000L);
            long j6 = j4 - (((long) (i5 * 3600)) * 1000000);
            int i6 = (int) (j6 / 60000000);
            long j7 = j6 - (((long) (i6 * 60)) * 1000000);
            int i7 = (int) (j7 / 1000000);
            int i8 = (int) ((j7 - (((long) i7) * 1000000)) / j5);
            bArr4 = Util.getUtf8Bytes(String.format(Locale.US, str, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
            bArr3 = bArr2;
        }
        System.arraycopy(bArr4, 0, bArr, i4, bArr3.length);
    }

    private void writeSampleData(ExtractorInput extractorInput, Track track, int i4) throws IOException, InterruptedException {
        boolean z4;
        int i5;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i4);
        } else if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i4);
        } else {
            TrackOutput trackOutput = track.output;
            boolean z5 = true;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    int i6 = 128;
                    if (!this.sampleSignalByteRead) {
                        extractorInput.readFully(this.scratch.data, 0, 1);
                        this.sampleBytesRead++;
                        byte b5 = this.scratch.data[0];
                        if ((b5 & 128) != 128) {
                            this.sampleSignalByte = b5;
                            this.sampleSignalByteRead = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b6 = this.sampleSignalByte;
                    if ((b6 & 1) == 1) {
                        if ((b6 & 2) == 2) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            ParsableByteArray parsableByteArray = this.scratch;
                            byte[] bArr = parsableByteArray.data;
                            if (!z4) {
                                i6 = 0;
                            }
                            bArr[0] = (byte) (i6 | 8);
                            parsableByteArray.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8);
                            this.sampleBytesWritten += 8;
                        }
                        if (z4) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.data, 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i7 = this.samplePartitionCount * 4;
                            this.scratch.reset(i7);
                            extractorInput.readFully(this.scratch.data, 0, i7);
                            this.sampleBytesRead += i7;
                            short s4 = (short) ((this.samplePartitionCount / 2) + 1);
                            int i8 = (s4 * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i8) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i8);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s4);
                            int i9 = 0;
                            int i10 = 0;
                            while (true) {
                                i5 = this.samplePartitionCount;
                                if (i9 >= i5) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                if (i9 % 2 == 0) {
                                    this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i10));
                                } else {
                                    this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i10);
                                }
                                i9++;
                                i10 = readUnsignedIntToInt;
                            }
                            int i11 = (i4 - this.sampleBytesRead) - i10;
                            if (i5 % 2 == 1) {
                                this.encryptionSubsampleDataBuffer.putInt(i11);
                            } else {
                                this.encryptionSubsampleDataBuffer.putShort((short) i11);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i8);
                            trackOutput.sampleData(this.encryptionSubsampleData, i8);
                            this.sampleBytesWritten += i8;
                        }
                    }
                } else {
                    byte[] bArr2 = track.sampleStrippedBytes;
                    if (bArr2 != null) {
                        this.sampleStrippedBytes.reset(bArr2, bArr2.length);
                    }
                }
                this.sampleEncodingHandled = true;
            }
            int limit = i4 + this.sampleStrippedBytes.limit();
            if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                if (track.trueHdSampleRechunker != null) {
                    if (this.sampleStrippedBytes.limit() != 0) {
                        z5 = false;
                    }
                    Assertions.checkState(z5);
                    track.trueHdSampleRechunker.startSample(extractorInput, this.blockFlags, limit);
                }
                while (true) {
                    int i12 = this.sampleBytesRead;
                    if (i12 >= limit) {
                        break;
                    }
                    readToOutput(extractorInput, trackOutput, limit - i12);
                }
            } else {
                byte[] bArr3 = this.nalLength.data;
                bArr3[0] = 0;
                bArr3[1] = 0;
                bArr3[2] = 0;
                int i13 = track.nalUnitLengthFieldLength;
                int i14 = 4 - i13;
                while (this.sampleBytesRead < limit) {
                    int i15 = this.sampleCurrentNalBytesRemaining;
                    if (i15 == 0) {
                        readToTarget(extractorInput, bArr3, i14, i13);
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        this.sampleCurrentNalBytesRemaining = i15 - readToOutput(extractorInput, trackOutput, i15);
                    }
                }
            }
            if (CODEC_ID_VORBIS.equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i4) throws IOException, InterruptedException {
        int length = bArr.length + i4;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(bArr, length + i4);
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i4);
        this.subtitleSample.reset(length);
    }

    /* access modifiers changed from: package-private */
    public final void binaryElement(int i4, int i5, ExtractorInput extractorInput) throws IOException, InterruptedException {
        char c5;
        char c6;
        boolean z4;
        int i6;
        int i7;
        int i8;
        long j4;
        int i9;
        int i10;
        int i11;
        int i12 = i4;
        int i13 = i5;
        ExtractorInput extractorInput2 = extractorInput;
        int i14 = 0;
        if (i12 == ID_BLOCK || i12 == ID_SIMPLE_BLOCK) {
            int i15 = 8;
            if (this.blockState == 0) {
                this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput2, false, true, 8);
                this.blockTrackNumberLength = this.varintReader.getLastLength();
                this.blockDurationUs = C.TIME_UNSET;
                this.blockState = 1;
                this.scratch.reset();
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            if (track == null) {
                extractorInput2.skipFully(i13 - this.blockTrackNumberLength);
                this.blockState = 0;
                return;
            }
            if (this.blockState == 1) {
                readScratch(extractorInput2, 3);
                int i16 = (this.scratch.data[2] & 6) >> 1;
                if (i16 == 0) {
                    this.blockLacingSampleCount = 1;
                    int[] ensureArrayCapacity = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
                    this.blockLacingSampleSizes = ensureArrayCapacity;
                    ensureArrayCapacity[0] = (i13 - this.blockTrackNumberLength) - 3;
                } else if (i12 == ID_SIMPLE_BLOCK) {
                    int i17 = 4;
                    readScratch(extractorInput2, 4);
                    int i18 = (this.scratch.data[3] & 255) + 1;
                    this.blockLacingSampleCount = i18;
                    int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockLacingSampleSizes, i18);
                    this.blockLacingSampleSizes = ensureArrayCapacity2;
                    if (i16 == 2) {
                        int i19 = this.blockLacingSampleCount;
                        Arrays.fill(ensureArrayCapacity2, 0, i19, ((i13 - this.blockTrackNumberLength) - 4) / i19);
                    } else if (i16 == 1) {
                        int i20 = 0;
                        int i21 = 0;
                        while (true) {
                            i9 = this.blockLacingSampleCount;
                            if (i20 >= i9 - 1) {
                                break;
                            }
                            this.blockLacingSampleSizes[i20] = 0;
                            while (true) {
                                i10 = i17 + 1;
                                readScratch(extractorInput2, i10);
                                byte b5 = this.scratch.data[i17] & 255;
                                int[] iArr = this.blockLacingSampleSizes;
                                i11 = iArr[i20] + b5;
                                iArr[i20] = i11;
                                if (b5 != 255) {
                                    break;
                                }
                                i17 = i10;
                            }
                            i21 += i11;
                            i20++;
                            i17 = i10;
                        }
                        this.blockLacingSampleSizes[i9 - 1] = ((i13 - this.blockTrackNumberLength) - i17) - i21;
                    } else if (i16 == 3) {
                        int i22 = 0;
                        int i23 = 0;
                        while (true) {
                            int i24 = this.blockLacingSampleCount;
                            if (i22 >= i24 - 1) {
                                c6 = 0;
                                c5 = 1;
                                this.blockLacingSampleSizes[i24 - 1] = ((i13 - this.blockTrackNumberLength) - i17) - i23;
                                break;
                            }
                            this.blockLacingSampleSizes[i22] = i14;
                            int i25 = i17 + 1;
                            readScratch(extractorInput2, i25);
                            if (this.scratch.data[i17] != 0) {
                                int i26 = 0;
                                while (true) {
                                    if (i26 >= i15) {
                                        i8 = i22;
                                        j4 = 0;
                                        break;
                                    }
                                    int i27 = 1 << (7 - i26);
                                    if ((this.scratch.data[i17] & i27) != 0) {
                                        i25 += i26;
                                        readScratch(extractorInput2, i25);
                                        j4 = (long) ((~i27) & this.scratch.data[i17] & 255);
                                        int i28 = i17 + 1;
                                        while (i28 < i25) {
                                            j4 = (j4 << i15) | ((long) (this.scratch.data[i28] & 255));
                                            i28++;
                                            i22 = i22;
                                            i15 = 8;
                                        }
                                        i8 = i22;
                                        if (i8 > 0) {
                                            j4 -= (1 << ((i26 * 7) + 6)) - 1;
                                        }
                                    } else {
                                        int i29 = i22;
                                        i26++;
                                        i15 = 8;
                                    }
                                }
                                i17 = i25;
                                if (j4 >= -2147483648L && j4 <= 2147483647L) {
                                    int i30 = (int) j4;
                                    int[] iArr2 = this.blockLacingSampleSizes;
                                    if (i8 != 0) {
                                        i30 += iArr2[i8 - 1];
                                    }
                                    iArr2[i8] = i30;
                                    i23 += i30;
                                    i22 = i8 + 1;
                                    i14 = 0;
                                    i15 = 8;
                                }
                            } else {
                                throw new ParserException("No valid varint length mask found");
                            }
                        }
                        throw new ParserException("EBML lacing sample size out of range.");
                    } else {
                        throw new ParserException("Unexpected lacing value: " + i16);
                    }
                } else {
                    throw new ParserException("Lacing only supported in SimpleBlocks.");
                }
                c6 = 0;
                c5 = 1;
                byte[] bArr = this.scratch.data;
                this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((long) ((bArr[c5] & 255) | (bArr[c6] << 8)));
                byte b6 = this.scratch.data[2];
                if ((b6 & 8) == 8) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (track.type == 2 || (i12 == ID_SIMPLE_BLOCK && (b6 & 128) == 128)) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                if (z4) {
                    i7 = Integer.MIN_VALUE;
                } else {
                    i7 = 0;
                }
                this.blockFlags = i6 | i7;
                this.blockState = 2;
                this.blockLacingSampleIndex = 0;
            }
            if (i12 == ID_SIMPLE_BLOCK) {
                while (true) {
                    int i31 = this.blockLacingSampleIndex;
                    if (i31 < this.blockLacingSampleCount) {
                        writeSampleData(extractorInput2, track, this.blockLacingSampleSizes[i31]);
                        commitSampleToOutput(track, this.blockTimeUs + ((long) ((this.blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000)));
                        this.blockLacingSampleIndex++;
                    } else {
                        this.blockState = 0;
                        return;
                    }
                }
            } else {
                writeSampleData(extractorInput2, track, this.blockLacingSampleSizes[0]);
            }
        } else if (i12 == ID_CONTENT_COMPRESSION_SETTINGS) {
            byte[] bArr2 = new byte[i13];
            this.currentTrack.sampleStrippedBytes = bArr2;
            extractorInput2.readFully(bArr2, 0, i13);
        } else if (i12 == ID_CONTENT_ENCRYPTION_KEY_ID) {
            byte[] bArr3 = new byte[i13];
            extractorInput2.readFully(bArr3, 0, i13);
            this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr3, 0, 0);
        } else if (i12 == ID_SEEK_ID) {
            Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
            extractorInput2.readFully(this.seekEntryIdBytes.data, 4 - i13, i13);
            this.seekEntryIdBytes.setPosition(0);
            this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
        } else if (i12 == ID_CODEC_PRIVATE) {
            byte[] bArr4 = new byte[i13];
            this.currentTrack.codecPrivate = bArr4;
            extractorInput2.readFully(bArr4, 0, i13);
        } else if (i12 == ID_PROJECTION_PRIVATE) {
            byte[] bArr5 = new byte[i13];
            this.currentTrack.projectionData = bArr5;
            extractorInput2.readFully(bArr5, 0, i13);
        } else {
            throw new ParserException("Unexpected id: " + i12);
        }
    }

    /* access modifiers changed from: package-private */
    public final void endMasterElement(int i4) throws ParserException {
        if (i4 != ID_BLOCK_GROUP) {
            if (i4 == ID_TRACK_ENTRY) {
                if (isCodecSupported(this.currentTrack.codecId)) {
                    Track track = this.currentTrack;
                    track.initializeOutput(this.extractorOutput, track.number);
                    SparseArray<Track> sparseArray = this.tracks;
                    Track track2 = this.currentTrack;
                    sparseArray.put(track2.number, track2);
                }
                this.currentTrack = null;
            } else if (i4 == ID_SEEK) {
                int i5 = this.seekEntryId;
                if (i5 != -1) {
                    long j4 = this.seekEntryPosition;
                    if (j4 != -1) {
                        if (i5 == ID_CUES) {
                            this.cuesContentPosition = j4;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i4 == ID_CONTENT_ENCODING) {
                Track track3 = this.currentTrack;
                if (!track3.hasContentEncryption) {
                    return;
                }
                if (track3.cryptoData != null) {
                    track3.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i4 == ID_CONTENT_ENCODINGS) {
                Track track4 = this.currentTrack;
                if (track4.hasContentEncryption && track4.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i4 == 357149030) {
                if (this.timecodeScale == C.TIME_UNSET) {
                    this.timecodeScale = 1000000;
                }
                long j5 = this.durationTimecode;
                if (j5 != C.TIME_UNSET) {
                    this.durationUs = scaleTimecodeToUs(j5);
                }
            } else if (i4 != ID_TRACKS) {
                if (i4 == ID_CUES && !this.sentSeekMap) {
                    this.extractorOutput.seekMap(buildSeekMap());
                    this.sentSeekMap = true;
                }
            } else if (this.tracks.size() != 0) {
                this.extractorOutput.endTracks();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        } else if (this.blockState == 2) {
            if (!this.sampleSeenReferenceBlock) {
                this.blockFlags |= 1;
            }
            commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
            this.blockState = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void floatElement(int i4, double d5) {
        if (i4 == ID_SAMPLING_FREQUENCY) {
            this.currentTrack.sampleRate = (int) d5;
        } else if (i4 != ID_DURATION) {
            switch (i4) {
                case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                    this.currentTrack.primaryRChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                    this.currentTrack.primaryRChromaticityY = (float) d5;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                    this.currentTrack.primaryGChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                    this.currentTrack.primaryGChromaticityY = (float) d5;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                    this.currentTrack.primaryBChromaticityX = (float) d5;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                    this.currentTrack.primaryBChromaticityY = (float) d5;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                    this.currentTrack.whitePointChromaticityX = (float) d5;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                    this.currentTrack.whitePointChromaticityY = (float) d5;
                    return;
                case ID_LUMNINANCE_MAX /*21977*/:
                    this.currentTrack.maxMasteringLuminance = (float) d5;
                    return;
                case ID_LUMNINANCE_MIN /*21978*/:
                    this.currentTrack.minMasteringLuminance = (float) d5;
                    return;
                default:
                    return;
            }
        } else {
            this.durationTimecode = (long) d5;
        }
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    /* access modifiers changed from: package-private */
    public final void integerElement(int i4, long j4) throws ParserException {
        if (i4 != ID_CONTENT_ENCODING_ORDER) {
            if (i4 != ID_CONTENT_ENCODING_SCOPE) {
                boolean z4 = false;
                switch (i4) {
                    case ID_TRACK_TYPE /*131*/:
                        this.currentTrack.type = (int) j4;
                        return;
                    case ID_FLAG_DEFAULT /*136*/:
                        Track track = this.currentTrack;
                        if (j4 == 1) {
                            z4 = true;
                        }
                        track.flagDefault = z4;
                        return;
                    case ID_BLOCK_DURATION /*155*/:
                        this.blockDurationUs = scaleTimecodeToUs(j4);
                        return;
                    case ID_CHANNELS /*159*/:
                        this.currentTrack.channelCount = (int) j4;
                        return;
                    case ID_PIXEL_WIDTH /*176*/:
                        this.currentTrack.width = (int) j4;
                        return;
                    case ID_CUE_TIME /*179*/:
                        this.cueTimesUs.add(scaleTimecodeToUs(j4));
                        return;
                    case ID_PIXEL_HEIGHT /*186*/:
                        this.currentTrack.height = (int) j4;
                        return;
                    case ID_TRACK_NUMBER /*215*/:
                        this.currentTrack.number = (int) j4;
                        return;
                    case ID_TIME_CODE /*231*/:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j4);
                        return;
                    case ID_CUE_CLUSTER_POSITION /*241*/:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            this.cueClusterPositions.add(j4);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case ID_REFERENCE_BLOCK /*251*/:
                        this.sampleSeenReferenceBlock = true;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                        if (j4 != 3) {
                            throw new ParserException("ContentCompAlgo " + j4 + " not supported");
                        }
                        return;
                    case ID_DOC_TYPE_READ_VERSION /*17029*/:
                        if (j4 < 1 || j4 > 2) {
                            throw new ParserException("DocTypeReadVersion " + j4 + " not supported");
                        }
                        return;
                    case ID_EBML_READ_VERSION /*17143*/:
                        if (j4 != 1) {
                            throw new ParserException("EBMLReadVersion " + j4 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                        if (j4 != 5) {
                            throw new ParserException("ContentEncAlgo " + j4 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                        if (j4 != 1) {
                            throw new ParserException("AESSettingsCipherMode " + j4 + " not supported");
                        }
                        return;
                    case ID_SEEK_POSITION /*21420*/:
                        this.seekEntryPosition = j4 + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /*21432*/:
                        int i5 = (int) j4;
                        if (i5 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i5 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i5 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i5 == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DISPLAY_WIDTH /*21680*/:
                        this.currentTrack.displayWidth = (int) j4;
                        return;
                    case ID_DISPLAY_UNIT /*21682*/:
                        this.currentTrack.displayUnit = (int) j4;
                        return;
                    case ID_DISPLAY_HEIGHT /*21690*/:
                        this.currentTrack.displayHeight = (int) j4;
                        return;
                    case ID_FLAG_FORCED /*21930*/:
                        Track track2 = this.currentTrack;
                        if (j4 == 1) {
                            z4 = true;
                        }
                        track2.flagForced = z4;
                        return;
                    case ID_CODEC_DELAY /*22186*/:
                        this.currentTrack.codecDelayNs = j4;
                        return;
                    case ID_SEEK_PRE_ROLL /*22203*/:
                        this.currentTrack.seekPreRollNs = j4;
                        return;
                    case ID_AUDIO_BIT_DEPTH /*25188*/:
                        this.currentTrack.audioBitDepth = (int) j4;
                        return;
                    case ID_DEFAULT_DURATION /*2352003*/:
                        this.currentTrack.defaultSampleDurationNs = (int) j4;
                        return;
                    case ID_TIMECODE_SCALE /*2807729*/:
                        this.timecodeScale = j4;
                        return;
                    default:
                        switch (i4) {
                            case ID_COLOUR_RANGE /*21945*/:
                                int i6 = (int) j4;
                                if (i6 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i6 == 2) {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_COLOUR_TRANSFER /*21946*/:
                                int i7 = (int) j4;
                                if (i7 != 1) {
                                    if (i7 == 16) {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    } else if (i7 == 18) {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    } else if (!(i7 == 6 || i7 == 7)) {
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case ID_COLOUR_PRIMARIES /*21947*/:
                                Track track3 = this.currentTrack;
                                track3.hasColorInfo = true;
                                int i8 = (int) j4;
                                if (i8 == 1) {
                                    track3.colorSpace = 1;
                                    return;
                                } else if (i8 == 9) {
                                    track3.colorSpace = 6;
                                    return;
                                } else if (i8 == 4 || i8 == 5 || i8 == 6 || i8 == 7) {
                                    track3.colorSpace = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_MAX_CLL /*21948*/:
                                this.currentTrack.maxContentLuminance = (int) j4;
                                return;
                            case ID_MAX_FALL /*21949*/:
                                this.currentTrack.maxFrameAverageLuminance = (int) j4;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j4 != 1) {
                throw new ParserException("ContentEncodingScope " + j4 + " not supported");
            }
        } else if (j4 != 0) {
            throw new ParserException("ContentEncodingOrder " + j4 + " not supported");
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        this.sampleRead = false;
        boolean z4 = true;
        while (z4 && !this.sampleRead) {
            z4 = this.reader.read(extractorInput);
            if (z4 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z4) {
            return 0;
        }
        for (int i4 = 0; i4 < this.tracks.size(); i4++) {
            this.tracks.valueAt(i4).outputPendingSampleMetadata();
        }
        return -1;
    }

    public final void release() {
    }

    public final void seek(long j4, long j5) {
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetSample();
        for (int i4 = 0; i4 < this.tracks.size(); i4++) {
            this.tracks.valueAt(i4).reset();
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return new Sniffer().sniff(extractorInput);
    }

    /* access modifiers changed from: package-private */
    public final void startMasterElement(int i4, long j4, long j5) throws ParserException {
        if (i4 == ID_BLOCK_GROUP) {
            this.sampleSeenReferenceBlock = false;
        } else if (i4 == ID_TRACK_ENTRY) {
            this.currentTrack = new Track();
        } else if (i4 == ID_CUE_POINT) {
            this.seenClusterPositionForCurrentCuePoint = false;
        } else if (i4 == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1;
        } else if (i4 == ID_CONTENT_ENCRYPTION) {
            this.currentTrack.hasContentEncryption = true;
        } else if (i4 == ID_MASTERING_METADATA) {
            this.currentTrack.hasColorInfo = true;
        } else if (i4 == ID_SEGMENT) {
            long j6 = this.segmentContentPosition;
            if (j6 == -1 || j6 == j4) {
                this.segmentContentPosition = j4;
                this.segmentContentSize = j5;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i4 == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i4 != ID_CLUSTER || this.sentSeekMap) {
        } else {
            if (!this.seekForCuesEnabled || this.cuesContentPosition == -1) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
                return;
            }
            this.seekForCues = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void stringElement(int i4, String str) throws ParserException {
        if (i4 == 134) {
            this.currentTrack.codecId = str;
        } else if (i4 != ID_DOC_TYPE) {
            if (i4 == ID_LANGUAGE) {
                String unused = this.currentTrack.language = str;
            }
        } else if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
            throw new ParserException("DocType " + str + " not supported");
        }
    }

    public MatroskaExtractor(int i4) {
        this(new DefaultEbmlReader(), i4);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i4) {
        this.segmentContentPosition = -1;
        this.timecodeScale = C.TIME_UNSET;
        this.durationTimecode = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.cuesContentPosition = -1;
        this.seekPositionAfterBuildingCues = -1;
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i4 & 1) != 0 ? false : true;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
    }
}
