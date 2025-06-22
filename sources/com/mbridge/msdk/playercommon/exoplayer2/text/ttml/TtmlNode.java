package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SMPTE_DATA = "smpte:data";
    public static final String TAG_SMPTE_IMAGE = "smpte:image";
    public static final String TAG_SMPTE_INFORMATION = "smpte:information";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    private TtmlNode(String str, String str2, long j4, long j5, TtmlStyle ttmlStyle, String[] strArr, String str3) {
        boolean z4;
        this.tag = str;
        this.text = str2;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        if (str2 != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.isTextNode = z4;
        this.startTimeUs = j4;
        this.endTimeUs = j5;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, SpannableStringBuilder spannableStringBuilder, int i4, int i5) {
        TtmlStyle resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map);
        if (resolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder, i4, i5, resolveStyle);
        }
    }

    public static TtmlNode buildNode(String str, long j4, long j5, TtmlStyle ttmlStyle, String[] strArr, String str2) {
        return new TtmlNode(str, (String) null, j4, j5, ttmlStyle, strArr, str2);
    }

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode((String) null, TtmlRenderUtil.applyTextElementSpacePolicy(str), C.TIME_UNSET, C.TIME_UNSET, (TtmlStyle) null, (String[]) null, "");
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        int i4;
        int i5;
        int length = spannableStringBuilder.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                int i9 = i8;
                while (i9 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i9) == ' ') {
                    i9++;
                }
                int i10 = i9 - i8;
                if (i10 > 0) {
                    spannableStringBuilder.delete(i7, i7 + i10);
                    length -= i10;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i11 = 0;
        while (true) {
            i4 = length - 1;
            if (i11 >= i4) {
                break;
            }
            if (spannableStringBuilder.charAt(i11) == 10) {
                int i12 = i11 + 1;
                if (spannableStringBuilder.charAt(i12) == ' ') {
                    spannableStringBuilder.delete(i12, i11 + 2);
                    length--;
                }
            }
            i11++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i4) == ' ') {
            spannableStringBuilder.delete(i4, length);
            length--;
        }
        while (true) {
            i5 = length - 1;
            if (i6 >= i5) {
                break;
            }
            if (spannableStringBuilder.charAt(i6) == ' ') {
                int i13 = i6 + 1;
                if (spannableStringBuilder.charAt(i13) == 10) {
                    spannableStringBuilder.delete(i6, i13);
                    length--;
                }
            }
            i6++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i5) == 10) {
            spannableStringBuilder.delete(i5, length);
        }
        return spannableStringBuilder;
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z4) {
        boolean z5;
        boolean equals = TAG_P.equals(this.tag);
        if (z4 || equals) {
            long j4 = this.startTimeUs;
            if (j4 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j4));
            }
            long j5 = this.endTimeUs;
            if (j5 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j5));
            }
        }
        if (this.children != null) {
            for (int i4 = 0; i4 < this.children.size(); i4++) {
                TtmlNode ttmlNode = this.children.get(i4);
                if (z4 || equals) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                ttmlNode.getEventTimes(treeSet, z5);
            }
        }
    }

    private static SpannableStringBuilder getRegionOutput(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void traverseForStyle(long j4, Map<String, TtmlStyle> map, Map<String, SpannableStringBuilder> map2) {
        int i4;
        if (isActive(j4)) {
            Iterator<Map.Entry<String, Integer>> it = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                i4 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                String str = (String) next.getKey();
                if (this.nodeStartsByRegion.containsKey(str)) {
                    i4 = this.nodeStartsByRegion.get(str).intValue();
                }
                int intValue = ((Integer) next.getValue()).intValue();
                if (i4 != intValue) {
                    applyStyleToOutput(map, map2.get(str), i4, intValue);
                }
            }
            while (i4 < getChildCount()) {
                getChild(i4).traverseForStyle(j4, map, map2);
                i4++;
            }
        }
    }

    private void traverseForText(long j4, boolean z4, String str, Map<String, SpannableStringBuilder> map) {
        boolean z5;
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if (!TAG_METADATA.equals(this.tag)) {
            if (!"".equals(this.regionId)) {
                str = this.regionId;
            }
            String str2 = str;
            if (this.isTextNode && z4) {
                getRegionOutput(str2, map).append(this.text);
            } else if (TAG_BR.equals(this.tag) && z4) {
                getRegionOutput(str2, map).append(10);
            } else if (isActive(j4)) {
                for (Map.Entry next : map.entrySet()) {
                    this.nodeStartsByRegion.put(next.getKey(), Integer.valueOf(((SpannableStringBuilder) next.getValue()).length()));
                }
                boolean equals = TAG_P.equals(this.tag);
                int i4 = 0;
                while (i4 < getChildCount()) {
                    TtmlNode child = getChild(i4);
                    if (z4 || equals) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    long j5 = j4;
                    Map<String, SpannableStringBuilder> map2 = map;
                    child.traverseForText(j5, z5, str2, map2);
                    i4++;
                    j4 = j5;
                    map = map2;
                }
                Map<String, SpannableStringBuilder> map3 = map;
                if (equals) {
                    TtmlRenderUtil.endParagraph(getRegionOutput(str2, map3));
                }
                for (Map.Entry next2 : map3.entrySet()) {
                    this.nodeEndsByRegion.put(next2.getKey(), Integer.valueOf(((SpannableStringBuilder) next2.getValue()).length()));
                }
            }
        }
    }

    public final void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public final TtmlNode getChild(int i4) {
        List<TtmlNode> list = this.children;
        if (list != null) {
            return list.get(i4);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final List<Cue> getCues(long j4, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        TreeMap treeMap = new TreeMap();
        long j5 = j4;
        traverseForText(j5, false, this.regionId, treeMap);
        traverseForStyle(j5, map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion = map2.get(entry.getKey());
            arrayList.add(new Cue((CharSequence) cleanUpText((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, ttmlRegion.line, ttmlRegion.lineType, ttmlRegion.lineAnchor, ttmlRegion.position, Integer.MIN_VALUE, ttmlRegion.width, ttmlRegion.textSizeType, ttmlRegion.textSize));
        }
        return arrayList;
    }

    public final long[] getEventTimesUs() {
        TreeSet treeSet = new TreeSet();
        int i4 = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i4] = ((Long) it.next()).longValue();
            i4++;
        }
        return jArr;
    }

    public final String[] getStyleIds() {
        return this.styleIds;
    }

    public final boolean isActive(long j4) {
        long j5 = this.startTimeUs;
        if (j5 == C.TIME_UNSET && this.endTimeUs == C.TIME_UNSET) {
            return true;
        }
        if (j5 <= j4 && this.endTimeUs == C.TIME_UNSET) {
            return true;
        }
        if (j5 == C.TIME_UNSET && j4 < this.endTimeUs) {
            return true;
        }
        if (j5 > j4 || j4 >= this.endTimeUs) {
            return false;
        }
        return true;
    }
}
