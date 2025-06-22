package com.mbridge.msdk.playercommon.exoplayer2.text.ssa;

import android.util.Log;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    private static final String FORMAT_LINE_PREFIX = "Format: ";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private static final String TAG = "SsaDecoder";
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this((List<byte[]>) null);
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        long j4;
        if (this.formatKeyCount == 0) {
            Log.w(TAG, "Skipping dialogue line before complete format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.formatKeyCount);
        if (split.length != this.formatKeyCount) {
            Log.w(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
        if (parseTimecodeUs == C.TIME_UNSET) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.formatEndIndex];
        if (!str2.trim().isEmpty()) {
            j4 = parseTimecodeUs(str2);
            if (j4 == C.TIME_UNSET) {
                Log.w(TAG, "Skipping invalid timing: " + str);
                return;
            }
        } else {
            j4 = -9223372036854775807L;
        }
        list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        longArray.add(parseTimecodeUs);
        if (j4 != C.TIME_UNSET) {
            list.add((Object) null);
            longArray.add(j4);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.haveInitializationData && readLine.startsWith(FORMAT_LINE_PREFIX)) {
                parseFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                parseDialogueLine(readLine, list, longArray);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseFormatLine(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 8
            java.lang.String r7 = r7.substring(r1)
            java.lang.String r1 = ","
            java.lang.String[] r7 = android.text.TextUtils.split(r7, r1)
            int r1 = r7.length
            r6.formatKeyCount = r1
            r1 = -1
            r6.formatStartIndex = r1
            r6.formatEndIndex = r1
            r6.formatTextIndex = r1
            r2 = 0
            r3 = 0
        L_0x0019:
            int r4 = r6.formatKeyCount
            if (r3 >= r4) goto L_0x0061
            r4 = r7[r3]
            java.lang.String r4 = r4.trim()
            java.lang.String r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r4)
            r4.getClass()
            int r5 = r4.hashCode()
            switch(r5) {
                case 100571: goto L_0x0049;
                case 3556653: goto L_0x003e;
                case 109757538: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            r4 = -1
            goto L_0x0053
        L_0x0033:
            java.lang.String r5 = "start"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x003c
            goto L_0x0031
        L_0x003c:
            r4 = 2
            goto L_0x0053
        L_0x003e:
            java.lang.String r5 = "text"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0047
            goto L_0x0031
        L_0x0047:
            r4 = 1
            goto L_0x0053
        L_0x0049:
            java.lang.String r5 = "end"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0052
            goto L_0x0031
        L_0x0052:
            r4 = 0
        L_0x0053:
            switch(r4) {
                case 0: goto L_0x005d;
                case 1: goto L_0x005a;
                case 2: goto L_0x0057;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x005f
        L_0x0057:
            r6.formatStartIndex = r3
            goto L_0x005f
        L_0x005a:
            r6.formatTextIndex = r3
            goto L_0x005f
        L_0x005d:
            r6.formatEndIndex = r3
        L_0x005f:
            int r3 = r3 + r0
            goto L_0x0019
        L_0x0061:
            int r7 = r6.formatStartIndex
            if (r7 == r1) goto L_0x006f
            int r7 = r6.formatEndIndex
            if (r7 == r1) goto L_0x006f
            int r7 = r6.formatTextIndex
            if (r7 != r1) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            return
        L_0x006f:
            r6.formatKeyCount = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ssa.SsaDecoder.parseFormatLine(java.lang.String):void");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void parseHeader(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r3) {
        /*
            r2 = this;
        L_0x0000:
            java.lang.String r0 = r3.readLine()
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "[Events]"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ssa.SsaDecoder.parseHeader(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray):void");
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        return (Long.parseLong(matcher.group(1)) * 3600000000L) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            return;
        }
        this.haveInitializationData = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
        parseFormatLine(fromUtf8Bytes);
        parseHeader(new ParsableByteArray(list.get(1)));
    }

    /* access modifiers changed from: protected */
    public final SsaSubtitle decode(byte[] bArr, int i4, boolean z4) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i4);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SsaSubtitle(cueArr, longArray.toArray());
    }
}
