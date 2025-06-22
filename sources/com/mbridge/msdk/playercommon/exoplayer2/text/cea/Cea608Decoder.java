package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.Subtitle;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleOutputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class Cea608Decoder extends CeaDecoder {
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_608_ID = 4;
    private static final int CC_VALID_FLAG = 4;
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    /* access modifiers changed from: private */
    public static final int[] STYLE_COLORS = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, -256, -65281};
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ArrayList<CueBuilder> cueBuilders = new ArrayList<>();
    private List<Cue> cues;
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedField;

    private static class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private final StringBuilder captionStringBuilder = new StringBuilder();
        private final List<CueStyle> cueStyles = new ArrayList();
        private int indent;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private int row;
        private int tabOffset;

        private static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i4, boolean z4, int i5) {
                this.style = i4;
                this.underline = z4;
                this.start = i5;
            }
        }

        public CueBuilder(int i4, int i5) {
            reset(i4);
            setCaptionRowCount(i5);
        }

        private static void setColorSpan(SpannableStringBuilder spannableStringBuilder, int i4, int i5, int i6) {
            if (i6 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i6), i4, i5, 33);
            }
        }

        private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder, int i4, int i5) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, 33);
        }

        private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder, int i4, int i5) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, 33);
        }

        public void append(char c5) {
            this.captionStringBuilder.append(c5);
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
                int size = this.cueStyles.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.cueStyles.get(size);
                    int i4 = cueStyle.start;
                    if (i4 == length) {
                        cueStyle.start = i4 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Cue build() {
            float f4;
            int i4;
            int i5;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i6 = 0; i6 < this.rolledUpCaptions.size(); i6++) {
                spannableStringBuilder.append(this.rolledUpCaptions.get(i6));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(buildSpannableString());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i7 = this.indent + this.tabOffset;
            int length = (32 - i7) - spannableStringBuilder.length();
            int i8 = i7 - length;
            int i9 = 2;
            if (this.captionMode == 2 && (Math.abs(i8) < 3 || length < 0)) {
                f4 = 0.5f;
                i9 = 1;
            } else if (this.captionMode != 2 || i8 <= 0) {
                f4 = ((((float) i7) / 32.0f) * 0.8f) + 0.1f;
                i9 = 0;
            } else {
                f4 = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
            }
            if (this.captionMode == 1 || (i5 = this.row) > 7) {
                i5 = this.row - 17;
                i4 = 2;
            } else {
                i4 = 0;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i5, 1, i4, f4, i9, Float.MIN_VALUE);
        }

        public SpannableString buildSpannableString() {
            int i4;
            boolean z4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            boolean z5 = false;
            while (i5 < this.cueStyles.size()) {
                CueStyle cueStyle = this.cueStyles.get(i5);
                boolean z6 = cueStyle.underline;
                int i11 = cueStyle.style;
                if (i11 != 8) {
                    if (i11 == 7) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (i11 != 7) {
                        i10 = Cea608Decoder.STYLE_COLORS[i11];
                    }
                    z5 = z4;
                }
                int i12 = cueStyle.start;
                i5++;
                if (i5 < this.cueStyles.size()) {
                    i4 = this.cueStyles.get(i5).start;
                } else {
                    i4 = length;
                }
                if (i12 != i4) {
                    if (i6 != -1 && !z6) {
                        setUnderlineSpan(spannableStringBuilder, i6, i12);
                        i6 = -1;
                    } else if (i6 == -1 && z6) {
                        i6 = i12;
                    }
                    if (i7 != -1 && !z5) {
                        setItalicSpan(spannableStringBuilder, i7, i12);
                        i7 = -1;
                    } else if (i7 == -1 && z5) {
                        i7 = i12;
                    }
                    if (i10 != i9) {
                        setColorSpan(spannableStringBuilder, i8, i12, i9);
                        i9 = i10;
                        i8 = i12;
                    }
                }
            }
            if (!(i6 == -1 || i6 == length)) {
                setUnderlineSpan(spannableStringBuilder, i6, length);
            }
            if (!(i7 == -1 || i7 == length)) {
                setItalicSpan(spannableStringBuilder, i7, length);
            }
            if (i8 != length) {
                setColorSpan(spannableStringBuilder, i8, length, i9);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public int getRow() {
            return this.row;
        }

        public boolean isEmpty() {
            if (!this.cueStyles.isEmpty() || !this.rolledUpCaptions.isEmpty() || this.captionStringBuilder.length() != 0) {
                return false;
            }
            return true;
        }

        public void reset(int i4) {
            this.captionMode = i4;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildSpannableString());
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setCaptionRowCount(int i4) {
            this.captionRowCount = i4;
        }

        public void setIndent(int i4) {
            this.indent = i4;
        }

        public void setRow(int i4) {
            this.row = i4;
        }

        public void setStyle(int i4, boolean z4) {
            this.cueStyles.add(new CueStyle(i4, z4, this.captionStringBuilder.length()));
        }

        public void setTab(int i4) {
            this.tabOffset = i4;
        }

        public String toString() {
            return this.captionStringBuilder.toString();
        }
    }

    public Cea608Decoder(String str, int i4) {
        int i5;
        if (MimeTypes.APPLICATION_MP4CEA608.equals(str)) {
            i5 = 2;
        } else {
            i5 = 3;
        }
        this.packetLength = i5;
        if (i4 == 3 || i4 == 4) {
            this.selectedField = 2;
        } else {
            this.selectedField = 1;
        }
        setCaptionMode(0);
        resetCueBuilders();
    }

    private static char getChar(byte b5) {
        return (char) BASIC_CHARACTER_SET[(b5 & Byte.MAX_VALUE) - 32];
    }

    private List<Cue> getDisplayCues() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.cueBuilders.size(); i4++) {
            Cue build = this.cueBuilders.get(i4).build();
            if (build != null) {
                arrayList.add(build);
            }
        }
        return arrayList;
    }

    private static char getExtendedEsFrChar(byte b5) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b5 & 31];
    }

    private static char getExtendedPtDeChar(byte b5) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b5 & 31];
    }

    private static char getSpecialChar(byte b5) {
        return (char) SPECIAL_CHARACTER_SET[b5 & 15];
    }

    private boolean handleCtrl(byte b5, byte b6) {
        boolean isRepeatable = isRepeatable(b5);
        if (isRepeatable) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b5 && this.repeatableControlCc2 == b6) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b5;
            this.repeatableControlCc2 = b6;
        }
        if (isMidrowCtrlCode(b5, b6)) {
            handleMidrowCtrl(b6);
            return isRepeatable;
        } else if (isPreambleAddressCode(b5, b6)) {
            handlePreambleAddressCode(b5, b6);
            return isRepeatable;
        } else if (isTabCtrlCode(b5, b6)) {
            this.currentCueBuilder.setTab(b6 - 32);
            return isRepeatable;
        } else {
            if (isMiscCode(b5, b6)) {
                handleMiscCode(b6);
            }
            return isRepeatable;
        }
    }

    private void handleMidrowCtrl(byte b5) {
        boolean z4;
        this.currentCueBuilder.append(' ');
        if ((b5 & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.currentCueBuilder.setStyle((b5 >> 1) & 7, z4);
    }

    private void handleMiscCode(byte b5) {
        if (b5 == 32) {
            setCaptionMode(2);
        } else if (b5 != 41) {
            switch (b5) {
                case 37:
                    setCaptionMode(1);
                    setCaptionRowCount(2);
                    return;
                case 38:
                    setCaptionMode(1);
                    setCaptionRowCount(3);
                    return;
                case 39:
                    setCaptionMode(1);
                    setCaptionRowCount(4);
                    return;
                default:
                    int i4 = this.captionMode;
                    if (i4 != 0) {
                        if (b5 != 33) {
                            switch (b5) {
                                case 44:
                                    this.cues = null;
                                    if (i4 == 1 || i4 == 3) {
                                        resetCueBuilders();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i4 == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        return;
                                    }
                                    return;
                                case 46:
                                    resetCueBuilders();
                                    return;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.currentCueBuilder.backspace();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            setCaptionMode(3);
        }
    }

    private void handlePreambleAddressCode(byte b5, byte b6) {
        boolean z4;
        int i4;
        int i5 = ROW_INDICES[b5 & 7];
        if ((b6 & CTRL_RESUME_CAPTION_LOADING) != 0) {
            i5++;
        }
        if (i5 != this.currentCueBuilder.getRow()) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            this.currentCueBuilder.setRow(i5);
        }
        boolean z5 = false;
        if ((b6 & 16) == 16) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((b6 & 1) == 1) {
            z5 = true;
        }
        int i6 = (b6 >> 1) & 7;
        CueBuilder cueBuilder2 = this.currentCueBuilder;
        if (z4) {
            i4 = 8;
        } else {
            i4 = i6;
        }
        cueBuilder2.setStyle(i4, z5);
        if (z4) {
            this.currentCueBuilder.setIndent(COLUMN_INDICES[i6]);
        }
    }

    private static boolean isMidrowCtrlCode(byte b5, byte b6) {
        return (b5 & 247) == 17 && (b6 & 240) == 32;
    }

    private static boolean isMiscCode(byte b5, byte b6) {
        return (b5 & 247) == 20 && (b6 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b5, byte b6) {
        return (b5 & 240) == 16 && (b6 & 192) == 64;
    }

    private static boolean isRepeatable(byte b5) {
        return (b5 & 240) == 16;
    }

    private static boolean isTabCtrlCode(byte b5, byte b6) {
        return (b5 & 247) == 23 && b6 >= 33 && b6 <= 35;
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void setCaptionMode(int i4) {
        int i5 = this.captionMode;
        if (i5 != i4) {
            this.captionMode = i4;
            resetCueBuilders();
            if (i5 == 3 || i4 == 1 || i4 == 0) {
                this.cues = null;
            }
        }
    }

    private void setCaptionRowCount(int i4) {
        this.captionRowCount = i4;
        this.currentCueBuilder.setCaptionRowCount(i4);
    }

    /* access modifiers changed from: protected */
    public final Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle(list);
    }

    /* access modifiers changed from: protected */
    public final void decode(SubtitleInputBuffer subtitleInputBuffer) {
        byte b5;
        int i4;
        this.ccData.reset(subtitleInputBuffer.data.array(), subtitleInputBuffer.data.limit());
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            int bytesLeft = this.ccData.bytesLeft();
            int i5 = this.packetLength;
            if (bytesLeft < i5) {
                break;
            }
            if (i5 == 2) {
                b5 = CC_IMPLICIT_DATA_HEADER;
            } else {
                b5 = (byte) this.ccData.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.ccData.readUnsignedByte() & ModuleDescriptor.MODULE_VERSION);
            byte readUnsignedByte2 = (byte) (this.ccData.readUnsignedByte() & ModuleDescriptor.MODULE_VERSION);
            if ((b5 & 6) == 4 && (((i4 = this.selectedField) != 1 || (b5 & 1) == 0) && ((i4 != 2 || (b5 & 1) == 1) && !(readUnsignedByte == 0 && readUnsignedByte2 == 0)))) {
                if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & 240) == 48) {
                    this.currentCueBuilder.append(getSpecialChar(readUnsignedByte2));
                } else if ((readUnsignedByte & 246) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.currentCueBuilder.backspace();
                    if ((readUnsignedByte & 1) == 0) {
                        this.currentCueBuilder.append(getExtendedEsFrChar(readUnsignedByte2));
                    } else {
                        this.currentCueBuilder.append(getExtendedPtDeChar(readUnsignedByte2));
                    }
                } else if ((readUnsignedByte & 224) == 0) {
                    z5 = handleCtrl(readUnsignedByte, readUnsignedByte2);
                } else {
                    this.currentCueBuilder.append(getChar(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.currentCueBuilder.append(getChar(readUnsignedByte2));
                    }
                }
                z4 = true;
            }
        }
        if (z4) {
            if (!z5) {
                this.repeatableControlSet = false;
            }
            int i6 = this.captionMode;
            if (i6 == 1 || i6 == 3) {
                this.cues = getDisplayCues();
            }
        }
    }

    public final /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public final /* bridge */ /* synthetic */ SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    public final void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
    }

    public final String getName() {
        return "Cea608Decoder";
    }

    /* access modifiers changed from: protected */
    public final boolean isNewSubtitleDataAvailable() {
        if (this.cues != this.lastCues) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    public final void release() {
    }

    public final /* bridge */ /* synthetic */ void setPositionUs(long j4) {
        super.setPositionUs(j4);
    }
}
