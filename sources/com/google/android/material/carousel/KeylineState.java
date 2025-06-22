package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private int firstFocalKeylineIndex = -1;
        private final float itemSize;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;
        private Keyline tmpFirstFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private Keyline tmpLastFocalKeyline;

        Builder(float f4, float f5) {
            this.itemSize = f4;
            this.availableSpace = f5;
        }

        private static float calculateKeylineLocationForItemPosition(float f4, float f5, int i4, int i5) {
            return (f4 - (((float) i4) * f5)) + (((float) i5) * f5);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addAnchorKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
            return addKeyline(f4, f5, f6, false, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, boolean z4) {
            return addKeyline(f4, f5, f6, z4, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeylineRange(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, int i4) {
            return addKeylineRange(f4, f5, f6, i4, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline != null) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < this.tmpKeylines.size(); i4++) {
                    Keyline keyline = this.tmpKeylines.get(i4);
                    arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i4), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
                }
                return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
            return addKeyline(f4, f5, f6, false);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeylineRange(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, int i4, boolean z4) {
            if (i4 > 0 && f6 > 0.0f) {
                for (int i5 = 0; i5 < i4; i5++) {
                    addKeyline((((float) i5) * f6) + f4, f5, f6, z4);
                }
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, boolean z4, boolean z5, float f7, float f8, float f9) {
            if (f6 <= 0.0f) {
                return this;
            }
            if (z5) {
                if (!z4) {
                    int i4 = this.latestAnchorKeylineIndex;
                    if (i4 == -1 || i4 == 0) {
                        this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                    } else {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f4, f5, f6, z5, f7, f8, f9);
            if (z4) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                } else if (f6 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            } else if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, boolean z4, boolean z5, float f7) {
            return addKeyline(f4, f5, f6, z4, z5, f7, 0.0f, 0.0f);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Builder addKeyline(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6, boolean z4, boolean z5) {
            float f7;
            boolean z6;
            boolean z7;
            float f8;
            float f9;
            float f10;
            Builder builder;
            float abs;
            float f11 = f6 / 2.0f;
            float f12 = f4 - f11;
            float f13 = f11 + f4;
            float f14 = this.availableSpace;
            if (f13 > f14) {
                abs = Math.abs(f13 - Math.max(f13 - f6, f14));
            } else if (f12 < 0.0f) {
                abs = Math.abs(f12 - Math.min(f12 + f6, 0.0f));
            } else {
                builder = this;
                f10 = f4;
                f9 = f5;
                f8 = f6;
                z7 = z4;
                z6 = z5;
                f7 = 0.0f;
                return builder.addKeyline(f10, f9, f8, z7, z6, f7);
            }
            builder = this;
            f10 = f4;
            f9 = f5;
            f8 = f6;
            z7 = z4;
            z6 = z5;
            f7 = abs;
            return builder.addKeyline(f10, f9, f8, z7, z6, f7);
        }
    }

    static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        Keyline(float f4, float f5, float f6, float f7) {
            this(f4, f5, f6, f7, false, 0.0f, 0.0f, 0.0f);
        }

        static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f4), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f4), AnimationUtils.lerp(keyline.mask, keyline2.mask, f4), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f4));
        }

        Keyline(float f4, float f5, float f6, float f7, boolean z4, float f8, float f9, float f10) {
            this.loc = f4;
            this.locOffset = f5;
            this.mask = f6;
            this.maskedItemSize = f7;
            this.isAnchor = z4;
            this.cutoff = f8;
            this.leftOrTopPaddingShift = f9;
            this.rightOrBottomPaddingShift = f10;
        }
    }

    static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f4) {
        if (keylineState.getItemSize() == keylineState2.getItemSize()) {
            List<Keyline> keylines2 = keylineState.getKeylines();
            List<Keyline> keylines3 = keylineState2.getKeylines();
            if (keylines2.size() == keylines3.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < keylineState.getKeylines().size(); i4++) {
                    arrayList.add(Keyline.lerp(keylines2.get(i4), keylines3.get(i4), f4));
                }
                return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f4), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f4));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    static KeylineState reverse(KeylineState keylineState, float f4) {
        boolean z4;
        Builder builder = new Builder(keylineState.getItemSize(), f4);
        float f5 = (f4 - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            Keyline keyline = keylineState.getKeylines().get(size);
            float f6 = (keyline.maskedItemSize / 2.0f) + f5;
            if (size < keylineState.getFirstFocalKeylineIndex() || size > keylineState.getLastFocalKeylineIndex()) {
                z4 = false;
            } else {
                z4 = true;
            }
            builder.addKeyline(f6, keyline.mask, keyline.maskedItemSize, z4, keyline.isAnchor);
            f5 += keyline.maskedItemSize;
        }
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    /* access modifiers changed from: package-private */
    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    /* access modifiers changed from: package-private */
    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i4 = 0; i4 < this.keylines.size(); i4++) {
            Keyline keyline = this.keylines.get(i4);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    /* access modifiers changed from: package-private */
    public float getItemSize() {
        return this.itemSize;
    }

    /* access modifiers changed from: package-private */
    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    /* access modifiers changed from: package-private */
    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    /* access modifiers changed from: package-private */
    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    /* access modifiers changed from: package-private */
    public Keyline getLastKeyline() {
        List<Keyline> list = this.keylines;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getNumberOfNonAnchorKeylines() {
        int i4 = 0;
        for (Keyline keyline : this.keylines) {
            if (keyline.isAnchor) {
                i4++;
            }
        }
        return this.keylines.size() - i4;
    }

    private KeylineState(float f4, List<Keyline> list, int i4, int i5) {
        this.itemSize = f4;
        this.keylines = DesugarCollections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i4;
        this.lastFocalKeylineIndex = i5;
    }
}
