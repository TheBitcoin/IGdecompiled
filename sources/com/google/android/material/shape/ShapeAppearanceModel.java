package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

public class ShapeAppearanceModel {
    public static final CornerSize PILL = new RelativeCornerSize(0.5f);
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    public static final class Builder {
        /* access modifiers changed from: private */
        @NonNull
        public EdgeTreatment bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerTreatment bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull
        public CornerTreatment bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull
        public EdgeTreatment leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public EdgeTreatment rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public EdgeTreatment topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerTreatment topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull
        public CornerTreatment topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        /* access modifiers changed from: private */
        @NonNull
        public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);

        public Builder() {
        }

        private static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this);
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCorners(int i4, @Dimension float f4) {
            return setAllCorners(MaterialShapeUtils.createCornerTreatment(i4)).setAllCornerSizes(f4);
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.bottomEdge = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setBottomLeftCorner(int i4, @Dimension float f4) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i4)).setBottomLeftCornerSize(f4);
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float f4) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(int i4, @Dimension float f4) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i4)).setBottomRightCornerSize(f4);
        }

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float f4) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.leftEdge = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.rightEdge = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.topEdge = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(int i4, @Dimension float f4) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i4)).setTopLeftCornerSize(f4);
        }

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float f4) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(int i4, @Dimension float f4) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i4)).setTopRightCornerSize(f4);
        }

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float f4) {
            this.topRightCornerSize = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.bottomLeftCornerSize = cornerSize;
            return this;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize cornerSize) {
            this.bottomRightCornerSize = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.topLeftCornerSize = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize cornerSize) {
            this.topRightCornerSize = cornerSize;
            return this;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        @NonNull
        public Builder setBottomLeftCorner(int i4, @NonNull CornerSize cornerSize) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i4)).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setBottomRightCorner(int i4, @NonNull CornerSize cornerSize) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i4)).setBottomRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopLeftCorner(int i4, @NonNull CornerSize cornerSize) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i4)).setTopLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopRightCorner(int i4, @NonNull CornerSize cornerSize) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i4)).setTopRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCornerSizes(@Dimension float f4) {
            return setTopLeftCornerSize(f4).setTopRightCornerSize(f4).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f4);
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.bottomLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.bottomRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.topLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.topRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize);
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    private static CornerSize getCornerSize(TypedArray typedArray, int i4, @NonNull CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i4);
        if (peekValue != null) {
            int i5 = peekValue.type;
            if (i5 == 5) {
                return new AbsoluteCornerSize((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i5 == 6) {
                return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF rectF) {
        boolean z4;
        boolean z5;
        boolean z6;
        Class<EdgeTreatment> cls = EdgeTreatment.class;
        if (!this.leftEdge.getClass().equals(cls) || !this.rightEdge.getClass().equals(cls) || !this.topEdge.getClass().equals(cls) || !this.bottomEdge.getClass().equals(cls)) {
            z4 = false;
        } else {
            z4 = true;
        }
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        if (this.topRightCornerSize.getCornerSize(rectF) == cornerSize && this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize && this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!(this.topRightCorner instanceof RoundedCornerTreatment) || !(this.topLeftCorner instanceof RoundedCornerTreatment) || !(this.bottomRightCorner instanceof RoundedCornerTreatment) || !(this.bottomLeftCorner instanceof RoundedCornerTreatment)) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (!z4 || !z5 || !z6) {
            return false;
        }
        return true;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(float f4) {
        return toBuilder().setAllCornerSizes(f4).build();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }

    private ShapeAppearanceModel(@NonNull Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        return builder(context, attributeSet, i4, i5, 0);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5, int i6) {
        return builder(context, attributeSet, i4, i5, (CornerSize) new AbsoluteCornerSize((float) i6));
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5, @NonNull CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    @NonNull
    public static Builder builder(Context context, @StyleRes int i4, @StyleRes int i5) {
        return builder(context, i4, i5, 0);
    }

    @NonNull
    private static Builder builder(Context context, @StyleRes int i4, @StyleRes int i5, int i6) {
        return builder(context, i4, i5, (CornerSize) new AbsoluteCornerSize((float) i6));
    }

    @NonNull
    private static Builder builder(Context context, @StyleRes int i4, @StyleRes int i5, @NonNull CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
        if (i5 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i5);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i6);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i6);
            int i9 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i6);
            int i10 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i6);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            return new Builder().setTopLeftCorner(i7, cornerSize3).setTopRightCorner(i8, cornerSize4).setBottomRightCorner(i9, cornerSize5).setBottomLeftCorner(i10, getCornerSize(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }
}
