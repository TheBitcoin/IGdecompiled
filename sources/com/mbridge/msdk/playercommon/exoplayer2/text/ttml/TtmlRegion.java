package com.mbridge.msdk.playercommon.exoplayer2.text.ttml;

final class TtmlRegion {
    public final String id;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final float textSize;
    public final int textSizeType;
    public final float width;

    public TtmlRegion(String str) {
        this(str, Float.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public TtmlRegion(String str, float f4, float f5, int i4, int i5, float f6, int i6, float f7) {
        this.id = str;
        this.position = f4;
        this.line = f5;
        this.lineType = i4;
        this.lineAnchor = i5;
        this.width = f6;
        this.textSizeType = i6;
        this.textSize = f7;
    }
}
