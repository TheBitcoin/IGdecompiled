package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

abstract class CarouselOrientationHelper {
    final int orientation;

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) {
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f4 = rectF2.left;
                float f5 = rectF3.left;
                if (f4 < f5 && rectF2.right > f5) {
                    float f6 = f5 - f4;
                    rectF.left += f6;
                    rectF2.left += f6;
                }
                float f7 = rectF2.right;
                float f8 = rectF3.right;
                if (f7 > f8 && rectF2.left < f8) {
                    float f9 = f7 - f8;
                    rectF.right = Math.max(rectF.right - f9, rectF.left);
                    rectF2.right = Math.max(rectF2.right - f9, rectF2.left);
                }
            }

            /* access modifiers changed from: package-private */
            public int getDecoratedCrossAxisMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.rightMargin + layoutParams.leftMargin);
            }

            public RectF getMaskRect(float f4, float f5, float f6, float f7) {
                return new RectF(f7, 0.0f, f5 - f7, f4);
            }

            /* access modifiers changed from: package-private */
            public int getParentBottom() {
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            }

            /* access modifiers changed from: package-private */
            public int getParentEnd() {
                if (carouselLayoutManager.isLayoutRtl()) {
                    return getParentLeft();
                }
                return getParentRight();
            }

            /* access modifiers changed from: package-private */
            public int getParentLeft() {
                return 0;
            }

            /* access modifiers changed from: package-private */
            public int getParentRight() {
                return carouselLayoutManager.getWidth();
            }

            /* access modifiers changed from: package-private */
            public int getParentStart() {
                if (carouselLayoutManager.isLayoutRtl()) {
                    return getParentRight();
                }
                return getParentLeft();
            }

            /* access modifiers changed from: package-private */
            public int getParentTop() {
                return carouselLayoutManager.getPaddingTop();
            }

            public void layoutDecoratedWithMargins(View view, int i4, int i5) {
                int parentTop = getParentTop();
                carouselLayoutManager.layoutDecoratedWithMargins(view, i4, parentTop, i5, parentTop + getDecoratedCrossAxisMeasurement(view));
            }

            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    float floor = ((float) Math.floor((double) rectF.right)) - 1.0f;
                    rectF.right = floor;
                    rectF.left = Math.min(rectF.left, floor);
                }
                if (rectF2.left >= rectF3.right) {
                    float ceil = ((float) Math.ceil((double) rectF.left)) + 1.0f;
                    rectF.left = ceil;
                    rectF.right = Math.max(ceil, rectF.right);
                }
            }

            public void offsetChild(View view, Rect rect, float f4, float f5) {
                view.offsetLeftAndRight((int) (f5 - (((float) rect.left) + f4)));
            }
        };
    }

    static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager carouselLayoutManager, int i4) {
        if (i4 == 0) {
            return createHorizontalHelper(carouselLayoutManager);
        }
        if (i4 == 1) {
            return createVerticalHelper(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) {
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f4 = rectF2.top;
                float f5 = rectF3.top;
                if (f4 < f5 && rectF2.bottom > f5) {
                    float f6 = f5 - f4;
                    rectF.top += f6;
                    rectF3.top += f6;
                }
                float f7 = rectF2.bottom;
                float f8 = rectF3.bottom;
                if (f7 > f8 && rectF2.top < f8) {
                    float f9 = f7 - f8;
                    rectF.bottom = Math.max(rectF.bottom - f9, rectF.top);
                    rectF2.bottom = Math.max(rectF2.bottom - f9, rectF2.top);
                }
            }

            /* access modifiers changed from: package-private */
            public int getDecoratedCrossAxisMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return (float) (layoutParams.topMargin + layoutParams.bottomMargin);
            }

            public RectF getMaskRect(float f4, float f5, float f6, float f7) {
                return new RectF(0.0f, f6, f5, f4 - f6);
            }

            /* access modifiers changed from: package-private */
            public int getParentBottom() {
                return carouselLayoutManager.getHeight();
            }

            /* access modifiers changed from: package-private */
            public int getParentEnd() {
                return getParentBottom();
            }

            /* access modifiers changed from: package-private */
            public int getParentLeft() {
                return carouselLayoutManager.getPaddingLeft();
            }

            /* access modifiers changed from: package-private */
            public int getParentRight() {
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            }

            /* access modifiers changed from: package-private */
            public int getParentStart() {
                return getParentTop();
            }

            /* access modifiers changed from: package-private */
            public int getParentTop() {
                return 0;
            }

            public void layoutDecoratedWithMargins(View view, int i4, int i5) {
                int parentLeft = getParentLeft();
                carouselLayoutManager.layoutDecoratedWithMargins(view, parentLeft, i4, parentLeft + getDecoratedCrossAxisMeasurement(view), i5);
            }

            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    float floor = ((float) Math.floor((double) rectF.bottom)) - 1.0f;
                    rectF.bottom = floor;
                    rectF.top = Math.min(rectF.top, floor);
                }
                if (rectF2.top >= rectF3.bottom) {
                    float ceil = ((float) Math.ceil((double) rectF.top)) + 1.0f;
                    rectF.top = ceil;
                    rectF.bottom = Math.max(ceil, rectF.bottom);
                }
            }

            public void offsetChild(View view, Rect rect, float f4, float f5) {
                view.offsetTopAndBottom((int) (f5 - (((float) rect.top) + f4)));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    /* access modifiers changed from: package-private */
    public abstract int getDecoratedCrossAxisMeasurement(View view);

    /* access modifiers changed from: package-private */
    public abstract float getMaskMargins(RecyclerView.LayoutParams layoutParams);

    /* access modifiers changed from: package-private */
    public abstract RectF getMaskRect(float f4, float f5, float f6, float f7);

    /* access modifiers changed from: package-private */
    public abstract int getParentBottom();

    /* access modifiers changed from: package-private */
    public abstract int getParentEnd();

    /* access modifiers changed from: package-private */
    public abstract int getParentLeft();

    /* access modifiers changed from: package-private */
    public abstract int getParentRight();

    /* access modifiers changed from: package-private */
    public abstract int getParentStart();

    /* access modifiers changed from: package-private */
    public abstract int getParentTop();

    /* access modifiers changed from: package-private */
    public abstract void layoutDecoratedWithMargins(View view, int i4, int i5);

    /* access modifiers changed from: package-private */
    public abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    /* access modifiers changed from: package-private */
    public abstract void offsetChild(View view, Rect rect, float f4, float f5);

    private CarouselOrientationHelper(int i4) {
        this.orientation = i4;
    }
}
