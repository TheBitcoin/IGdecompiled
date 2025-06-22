package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final CellResolution DEFAULT_CELL_RESOLUTION = new CellResolution(32, 15);
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i4, int i5) {
            this.columns = i4;
            this.rows = i5;
        }
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f4, int i4, int i5) {
            this.effectiveFrameRate = f4;
            this.subFrameRate = i4;
            this.tickRate = i5;
        }
    }

    public TtmlDecoder() {
        super(TAG);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e5) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e5);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        if (ttmlStyle == null) {
            return new TtmlStyle();
        }
        return ttmlStyle;
    }

    private static boolean isSupportedTag(String str) {
        if (str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals("style") || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(TtmlNode.TAG_METADATA) || str.equals(TtmlNode.TAG_SMPTE_IMAGE) || str.equals(TtmlNode.TAG_SMPTE_DATA) || str.equals(TtmlNode.TAG_SMPTE_INFORMATION)) {
            return true;
        }
        return false;
    }

    private CellResolution parseCellResolution(XmlPullParser xmlPullParser, CellResolution cellResolution) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new CellResolution(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] split = Util.split(str, "\\s+");
        if (split.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (split.length == 2) {
            matcher = FONT_SIZE.matcher(split[1]);
            Log.w(TAG, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.getClass();
            char c5 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case 1:
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case 2:
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + group + "'.");
            }
            ttmlStyle.setFontSize(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        int i4;
        float f4;
        String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        if (attributeValue != null) {
            i4 = Integer.parseInt(attributeValue);
        } else {
            i4 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = Util.split(attributeValue2, " ");
            if (split.length == 2) {
                f4 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f4 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i5 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i5 = Integer.parseInt(attributeValue3);
        }
        int i6 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i6 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) i4) * f4, i5, i6);
    }

    private Map<String, TtmlStyle> parseHeader(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, CellResolution cellResolution) throws IOException, XmlPullParserException {
        TtmlRegion parseRegionAttributes;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        parseStyleAttributes.chain(map.get(str));
                    }
                }
                if (parseStyleAttributes.getId() != null) {
                    map.put(parseStyleAttributes.getId(), parseStyleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region") && (parseRegionAttributes = parseRegionAttributes(xmlPullParser, cellResolution)) != null) {
                map2.put(parseRegionAttributes.id, parseRegionAttributes);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map<String, TtmlRegion> map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j4;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TtmlNode ttmlNode2 = ttmlNode;
        FrameAndTickRate frameAndTickRate2 = frameAndTickRate;
        int attributeCount = xmlPullParser2.getAttributeCount();
        TtmlStyle parseStyleAttributes = parseStyleAttributes(xmlPullParser2, (TtmlStyle) null);
        String[] strArr = null;
        long j5 = -9223372036854775807L;
        long j6 = -9223372036854775807L;
        long j7 = -9223372036854775807L;
        String str = "";
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser2.getAttributeName(i4);
            String attributeValue = xmlPullParser2.getAttributeValue(i4);
            attributeName.getClass();
            char c5 = 65535;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals(ATTR_DURATION)) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals(ATTR_BEGIN)) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str = attributeValue;
                        continue;
                    }
                case 1:
                    j7 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 2:
                    j6 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 3:
                    j5 = parseTimeExpression(attributeValue, frameAndTickRate2);
                    break;
                case 4:
                    String[] parseStyleIds = parseStyleIds(attributeValue);
                    if (parseStyleIds.length > 0) {
                        strArr = parseStyleIds;
                        break;
                    }
                    break;
            }
            Map<String, TtmlRegion> map2 = map;
        }
        if (ttmlNode2 != null) {
            long j8 = ttmlNode2.startTimeUs;
            if (j8 != C.TIME_UNSET) {
                if (j5 != C.TIME_UNSET) {
                    j5 += j8;
                }
                if (j6 != C.TIME_UNSET) {
                    j6 += j8;
                }
            }
        }
        if (j6 == C.TIME_UNSET) {
            if (j7 != C.TIME_UNSET) {
                j6 = j5 + j7;
            } else if (ttmlNode2 != null) {
                long j9 = ttmlNode2.endTimeUs;
                if (j9 != C.TIME_UNSET) {
                    j4 = j9;
                    return TtmlNode.buildNode(xmlPullParser2.getName(), j5, j4, parseStyleAttributes, strArr, str);
                }
            }
        }
        j4 = j6;
        return TtmlNode.buildNode(xmlPullParser2.getName(), j5, j4, parseStyleAttributes, strArr, str);
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, CellResolution cellResolution) {
        float f4;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_ORIGIN);
        if (attributeValue2 != null) {
            Pattern pattern = PERCENTAGE_COORDINATES;
            Matcher matcher = pattern.matcher(attributeValue2);
            if (matcher.matches()) {
                int i4 = 1;
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
                    if (attributeValue3 != null) {
                        Matcher matcher2 = pattern.matcher(attributeValue3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                if (attributeValue4 != null) {
                                    String lowerInvariant = Util.toLowerInvariant(attributeValue4);
                                    lowerInvariant.getClass();
                                    if (lowerInvariant.equals(TtmlNode.CENTER)) {
                                        parseFloat2 += parseFloat4 / 2.0f;
                                        f4 = parseFloat2;
                                        return new TtmlRegion(attributeValue, parseFloat, f4, 0, i4, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                                    } else if (lowerInvariant.equals("after")) {
                                        f4 = parseFloat2 + parseFloat4;
                                        i4 = 2;
                                        return new TtmlRegion(attributeValue, parseFloat, f4, 0, i4, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                                    }
                                }
                                i4 = 0;
                                f4 = parseFloat2;
                                return new TtmlRegion(attributeValue, parseFloat, f4, 0, i4, parseFloat3, 1, 1.0f / ((float) cellResolution.rows));
                            } catch (NumberFormatException unused) {
                                Log.w(TAG, "Ignoring region with malformed extent: " + attributeValue2);
                                return null;
                            }
                        } else {
                            Log.w(TAG, "Ignoring region with unsupported extent: " + attributeValue2);
                            return null;
                        }
                    } else {
                        Log.w(TAG, "Ignoring region without an extent");
                        return null;
                    }
                } catch (NumberFormatException unused2) {
                    Log.w(TAG, "Ignoring region with malformed origin: " + attributeValue2);
                    return null;
                }
            } else {
                Log.w(TAG, "Ignoring region with unsupported origin: " + attributeValue2);
                return null;
            }
        } else {
            Log.w(TAG, "Ignoring region without an origin");
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r13, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14) {
        /*
            r12 = this;
            r0 = 4
            r1 = 3
            r2 = 2
            r3 = -1
            r4 = 1
            int r5 = r13.getAttributeCount()
            r6 = 0
            r7 = 0
        L_0x000b:
            if (r7 >= r5) goto L_0x021b
            java.lang.String r8 = r13.getAttributeValue(r7)
            java.lang.String r9 = r13.getAttributeName(r7)
            r9.getClass()
            java.lang.String r10 = "TtmlDecoder"
            int r11 = r9.hashCode()
            switch(r11) {
                case -1550943582: goto L_0x007e;
                case -1224696685: goto L_0x0073;
                case -1065511464: goto L_0x0068;
                case -879295043: goto L_0x005d;
                case -734428249: goto L_0x0052;
                case 3355: goto L_0x0047;
                case 94842723: goto L_0x003c;
                case 365601008: goto L_0x0031;
                case 1287124693: goto L_0x0024;
                default: goto L_0x0021;
            }
        L_0x0021:
            r9 = -1
            goto L_0x0088
        L_0x0024:
            java.lang.String r11 = "backgroundColor"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x002d
            goto L_0x0021
        L_0x002d:
            r9 = 8
            goto L_0x0088
        L_0x0031:
            java.lang.String r11 = "fontSize"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x003a
            goto L_0x0021
        L_0x003a:
            r9 = 7
            goto L_0x0088
        L_0x003c:
            java.lang.String r11 = "color"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0045
            goto L_0x0021
        L_0x0045:
            r9 = 6
            goto L_0x0088
        L_0x0047:
            java.lang.String r11 = "id"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0050
            goto L_0x0021
        L_0x0050:
            r9 = 5
            goto L_0x0088
        L_0x0052:
            java.lang.String r11 = "fontWeight"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x005b
            goto L_0x0021
        L_0x005b:
            r9 = 4
            goto L_0x0088
        L_0x005d:
            java.lang.String r11 = "textDecoration"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0066
            goto L_0x0021
        L_0x0066:
            r9 = 3
            goto L_0x0088
        L_0x0068:
            java.lang.String r11 = "textAlign"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0071
            goto L_0x0021
        L_0x0071:
            r9 = 2
            goto L_0x0088
        L_0x0073:
            java.lang.String r11 = "fontFamily"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x007c
            goto L_0x0021
        L_0x007c:
            r9 = 1
            goto L_0x0088
        L_0x007e:
            java.lang.String r11 = "fontStyle"
            boolean r9 = r9.equals(r11)
            if (r9 != 0) goto L_0x0087
            goto L_0x0021
        L_0x0087:
            r9 = 0
        L_0x0088:
            switch(r9) {
                case 0: goto L_0x020a;
                case 1: goto L_0x0201;
                case 2: goto L_0x0180;
                case 3: goto L_0x0118;
                case 4: goto L_0x0108;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00cf;
                case 7: goto L_0x00b0;
                case 8: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x0218
        L_0x008d:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.util.ColorParser.parseTtmlColor(r8)     // Catch:{ IllegalArgumentException -> 0x009a }
            r14.setBackgroundColor(r9)     // Catch:{ IllegalArgumentException -> 0x009a }
            goto L_0x0218
        L_0x009a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Failed parsing background value: "
            r9.append(r11)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.w(r10, r8)
            goto L_0x0218
        L_0x00b0:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)     // Catch:{ SubtitleDecoderException -> 0x00b9 }
            parseFontSize(r8, r14)     // Catch:{ SubtitleDecoderException -> 0x00b9 }
            goto L_0x0218
        L_0x00b9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Failed parsing fontSize value: "
            r9.append(r11)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.w(r10, r8)
            goto L_0x0218
        L_0x00cf:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            int r9 = com.mbridge.msdk.playercommon.exoplayer2.util.ColorParser.parseTtmlColor(r8)     // Catch:{ IllegalArgumentException -> 0x00dc }
            r14.setFontColor(r9)     // Catch:{ IllegalArgumentException -> 0x00dc }
            goto L_0x0218
        L_0x00dc:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Failed parsing color value: "
            r9.append(r11)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.w(r10, r8)
            goto L_0x0218
        L_0x00f2:
            java.lang.String r9 = "style"
            java.lang.String r10 = r13.getName()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0218
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setId(r8)
            goto L_0x0218
        L_0x0108:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            java.lang.String r9 = "bold"
            boolean r8 = r9.equalsIgnoreCase(r8)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setBold(r8)
            goto L_0x0218
        L_0x0118:
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r8)
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1461280213: goto L_0x0149;
                case -1026963764: goto L_0x013e;
                case 913457136: goto L_0x0133;
                case 1679736913: goto L_0x0128;
                default: goto L_0x0126;
            }
        L_0x0126:
            r8 = -1
            goto L_0x0153
        L_0x0128:
            java.lang.String r9 = "linethrough"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0131
            goto L_0x0126
        L_0x0131:
            r8 = 3
            goto L_0x0153
        L_0x0133:
            java.lang.String r9 = "nolinethrough"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x013c
            goto L_0x0126
        L_0x013c:
            r8 = 2
            goto L_0x0153
        L_0x013e:
            java.lang.String r9 = "underline"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0147
            goto L_0x0126
        L_0x0147:
            r8 = 1
            goto L_0x0153
        L_0x0149:
            java.lang.String r9 = "nounderline"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0152
            goto L_0x0126
        L_0x0152:
            r8 = 0
        L_0x0153:
            switch(r8) {
                case 0: goto L_0x0176;
                case 1: goto L_0x016c;
                case 2: goto L_0x0162;
                case 3: goto L_0x0158;
                default: goto L_0x0156;
            }
        L_0x0156:
            goto L_0x0218
        L_0x0158:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setLinethrough(r4)
            goto L_0x0218
        L_0x0162:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setLinethrough(r6)
            goto L_0x0218
        L_0x016c:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setUnderline(r4)
            goto L_0x0218
        L_0x0176:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setUnderline(r6)
            goto L_0x0218
        L_0x0180:
            java.lang.String r8 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r8)
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1364013995: goto L_0x01bc;
                case 100571: goto L_0x01b1;
                case 3317767: goto L_0x01a6;
                case 108511772: goto L_0x019b;
                case 109757538: goto L_0x0190;
                default: goto L_0x018e;
            }
        L_0x018e:
            r8 = -1
            goto L_0x01c6
        L_0x0190:
            java.lang.String r9 = "start"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0199
            goto L_0x018e
        L_0x0199:
            r8 = 4
            goto L_0x01c6
        L_0x019b:
            java.lang.String r9 = "right"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01a4
            goto L_0x018e
        L_0x01a4:
            r8 = 3
            goto L_0x01c6
        L_0x01a6:
            java.lang.String r9 = "left"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01af
            goto L_0x018e
        L_0x01af:
            r8 = 2
            goto L_0x01c6
        L_0x01b1:
            java.lang.String r9 = "end"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01ba
            goto L_0x018e
        L_0x01ba:
            r8 = 1
            goto L_0x01c6
        L_0x01bc:
            java.lang.String r9 = "center"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01c5
            goto L_0x018e
        L_0x01c5:
            r8 = 0
        L_0x01c6:
            switch(r8) {
                case 0: goto L_0x01f6;
                case 1: goto L_0x01eb;
                case 2: goto L_0x01e0;
                case 3: goto L_0x01d5;
                case 4: goto L_0x01ca;
                default: goto L_0x01c9;
            }
        L_0x01c9:
            goto L_0x0218
        L_0x01ca:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setTextAlign(r8)
            goto L_0x0218
        L_0x01d5:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setTextAlign(r8)
            goto L_0x0218
        L_0x01e0:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setTextAlign(r8)
            goto L_0x0218
        L_0x01eb:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setTextAlign(r8)
            goto L_0x0218
        L_0x01f6:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            android.text.Layout$Alignment r8 = android.text.Layout.Alignment.ALIGN_CENTER
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setTextAlign(r8)
            goto L_0x0218
        L_0x0201:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setFontFamily(r8)
            goto L_0x0218
        L_0x020a:
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r12.createIfNull(r14)
            java.lang.String r9 = "italic"
            boolean r8 = r9.equalsIgnoreCase(r8)
            com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle r14 = r14.setItalic(r8)
        L_0x0218:
            int r7 = r7 + r4
            goto L_0x000b
        L_0x021b:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle):com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlStyle");
    }

    private String[] parseStyleIds(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        return Util.split(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a0, code lost:
        if (r13.equals("ms") == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long parseTimeExpression(java.lang.String r13, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r14) throws com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException {
        /*
            r0 = 4
            r1 = 3
            java.util.regex.Pattern r2 = CLOCK_TIME
            java.util.regex.Matcher r2 = r2.matcher(r13)
            boolean r3 = r2.matches()
            r4 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0075
            java.lang.String r13 = r2.group(r7)
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r2.group(r6)
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r2.group(r1)
            long r9 = java.lang.Long.parseLong(r13)
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r2.group(r0)
            r0 = 0
            if (r13 == 0) goto L_0x0047
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0048
        L_0x0047:
            r9 = r0
        L_0x0048:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r2.group(r13)
            if (r13 == 0) goto L_0x005a
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r3 = r14.effectiveFrameRate
            float r13 = r13 / r3
            double r9 = (double) r13
            goto L_0x005b
        L_0x005a:
            r9 = r0
        L_0x005b:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r2.group(r13)
            if (r13 == 0) goto L_0x0070
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.subFrameRate
            double r2 = (double) r13
            double r0 = r0 / r2
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            double r0 = r0 / r13
        L_0x0070:
            double r7 = r7 + r0
            double r7 = r7 * r4
            long r13 = (long) r7
            return r13
        L_0x0075:
            java.util.regex.Pattern r2 = OFFSET_TIME
            java.util.regex.Matcher r2 = r2.matcher(r13)
            boolean r3 = r2.matches()
            if (r3 == 0) goto L_0x00f0
            java.lang.String r13 = r2.group(r7)
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r2.group(r6)
            r13.getClass()
            r2 = -1
            int r3 = r13.hashCode()
            switch(r3) {
                case 102: goto L_0x00c4;
                case 104: goto L_0x00b9;
                case 109: goto L_0x00ae;
                case 116: goto L_0x00a3;
                case 3494: goto L_0x009a;
                default: goto L_0x0098;
            }
        L_0x0098:
            r0 = -1
            goto L_0x00ce
        L_0x009a:
            java.lang.String r1 = "ms"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00ce
            goto L_0x0098
        L_0x00a3:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ac
            goto L_0x0098
        L_0x00ac:
            r0 = 3
            goto L_0x00ce
        L_0x00ae:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00b7
            goto L_0x0098
        L_0x00b7:
            r0 = 2
            goto L_0x00ce
        L_0x00b9:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00c2
            goto L_0x0098
        L_0x00c2:
            r0 = 1
            goto L_0x00ce
        L_0x00c4:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cd
            goto L_0x0098
        L_0x00cd:
            r0 = 0
        L_0x00ce:
            switch(r0) {
                case 0: goto L_0x00e8;
                case 1: goto L_0x00e2;
                case 2: goto L_0x00dd;
                case 3: goto L_0x00d9;
                case 4: goto L_0x00d2;
                default: goto L_0x00d1;
            }
        L_0x00d1:
            goto L_0x00ec
        L_0x00d2:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00d7:
            double r8 = r8 / r13
            goto L_0x00ec
        L_0x00d9:
            int r13 = r14.tickRate
            double r13 = (double) r13
            goto L_0x00d7
        L_0x00dd:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
        L_0x00df:
            double r8 = r8 * r13
            goto L_0x00ec
        L_0x00e2:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            goto L_0x00df
        L_0x00e8:
            float r13 = r14.effectiveFrameRate
            double r13 = (double) r13
            goto L_0x00d7
        L_0x00ec:
            double r8 = r8 * r4
            long r13 = (long) r8
            return r13
        L_0x00f0:
            com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException r14 = new com.mbridge.msdk.playercommon.exoplayer2.text.SubtitleDecoderException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    /* access modifiers changed from: protected */
    public final TtmlSubtitle decode(byte[] bArr, int i4, boolean z4) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            TtmlSubtitle ttmlSubtitle = null;
            hashMap2.put("", new TtmlRegion((String) null));
            int i5 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i4), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution cellResolution = DEFAULT_CELL_RESOLUTION;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i5 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            frameAndTickRate = parseFrameAndTickRates(newPullParser);
                            cellResolution = parseCellResolution(newPullParser, DEFAULT_CELL_RESOLUTION);
                        }
                        if (!isSupportedTag(name)) {
                            Log.i(TAG, "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if (TtmlNode.TAG_HEAD.equals(name)) {
                            parseHeader(newPullParser, hashMap, hashMap2, cellResolution);
                        } else {
                            try {
                                TtmlNode parseNode = parseNode(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                arrayDeque.push(parseNode);
                                if (ttmlNode != null) {
                                    ttmlNode.addChild(parseNode);
                                }
                            } catch (SubtitleDecoderException e5) {
                                Log.w(TAG, "Suppressing parser error", e5);
                            }
                        }
                    } else if (eventType == 4) {
                        ttmlNode.addChild(TtmlNode.buildTextNode(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) arrayDeque.peek(), hashMap, hashMap2);
                        }
                        arrayDeque.pop();
                    }
                    newPullParser.next();
                } else if (eventType != 2) {
                    if (eventType == 3) {
                        i5--;
                    }
                    newPullParser.next();
                }
                i5++;
                newPullParser.next();
            }
            return ttmlSubtitle;
        } catch (XmlPullParserException e6) {
            throw new SubtitleDecoderException("Unable to decode source", e6);
        } catch (IOException e7) {
            throw new IllegalStateException("Unexpected error when reading input.", e7);
        }
    }
}
