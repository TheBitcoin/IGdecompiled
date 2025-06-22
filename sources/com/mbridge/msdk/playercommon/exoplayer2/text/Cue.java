package com.mbridge.msdk.playercommon.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Cue {
    public static final int ANCHOR_TYPE_END = 2;
    public static final int ANCHOR_TYPE_MIDDLE = 1;
    public static final int ANCHOR_TYPE_START = 0;
    public static final float DIMEN_UNSET = Float.MIN_VALUE;
    public static final int LINE_TYPE_FRACTION = 0;
    public static final int LINE_TYPE_NUMBER = 1;
    public static final int TEXT_SIZE_TYPE_ABSOLUTE = 2;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL = 0;
    public static final int TEXT_SIZE_TYPE_FRACTIONAL_IGNORE_PADDING = 1;
    public static final int TYPE_UNSET = Integer.MIN_VALUE;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final float position;
    public final int positionAnchor;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int windowColor;
    public final boolean windowColorSet;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    public Cue(Bitmap bitmap2, float f4, int i4, float f5, int i5, float f6, float f7) {
        this((CharSequence) null, (Layout.Alignment) null, bitmap2, f5, 0, i5, f4, i4, Integer.MIN_VALUE, Float.MIN_VALUE, f6, f7, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f4, int i4, int i5, float f5, int i6, float f6) {
        this(charSequence, alignment, f4, i4, i5, f5, i6, f6, false, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f4, int i4, int i5, float f5, int i6, float f6, int i7, float f7) {
        this(charSequence, alignment, (Bitmap) null, f4, i4, i5, f5, i6, i7, f7, f6, Float.MIN_VALUE, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, float f4, int i4, int i5, float f5, int i6, float f6, boolean z4, int i7) {
        this(charSequence, alignment, (Bitmap) null, f4, i4, i5, f5, i6, Integer.MIN_VALUE, Float.MIN_VALUE, f6, Float.MIN_VALUE, z4, i7);
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap2, float f4, int i4, int i5, float f5, int i6, int i7, float f6, float f7, float f8, boolean z4, int i8) {
        this.text = charSequence;
        this.textAlignment = alignment;
        this.bitmap = bitmap2;
        this.line = f4;
        this.lineType = i4;
        this.lineAnchor = i5;
        this.position = f5;
        this.positionAnchor = i6;
        this.size = f7;
        this.bitmapHeight = f8;
        this.windowColorSet = z4;
        this.windowColor = i8;
        this.textSizeType = i7;
        this.textSize = f6;
    }
}
