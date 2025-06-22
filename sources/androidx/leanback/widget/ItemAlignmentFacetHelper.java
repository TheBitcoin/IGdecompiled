package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.GridLayoutManager;
import androidx.leanback.widget.ItemAlignmentFacet;

class ItemAlignmentFacetHelper {
    private static Rect sRect = new Rect();

    private ItemAlignmentFacetHelper() {
    }

    static int getAlignmentPosition(View view, ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef, int i4) {
        View view2;
        int i5;
        int i6;
        int i7;
        int i8;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        int i9 = itemAlignmentDef.mViewId;
        if (i9 == 0 || (view2 = view.findViewById(i9)) == null) {
            view2 = view;
        }
        int i10 = itemAlignmentDef.mOffset;
        if (i4 != 0) {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f4 = itemAlignmentDef.mOffsetPercent;
                if (f4 == 0.0f) {
                    i10 += view2.getPaddingTop();
                } else if (f4 == 100.0f) {
                    i10 -= view2.getPaddingBottom();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i5 = layoutParams.getOpticalHeight(view2);
                } else {
                    i5 = view2.getHeight();
                }
                i10 += (int) ((((float) i5) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view != view2) {
                Rect rect = sRect;
                rect.top = i10;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                i10 = sRect.top - layoutParams.getOpticalTopInset();
            }
            if (itemAlignmentDef.isAlignedToTextViewBaseLine()) {
                return i10 + view2.getBaseline();
            }
            return i10;
        } else if (view.getLayoutDirection() == 1) {
            if (view2 == view) {
                i7 = layoutParams.getOpticalWidth(view2);
            } else {
                i7 = view2.getWidth();
            }
            int i11 = i7 - i10;
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f5 = itemAlignmentDef.mOffsetPercent;
                if (f5 == 0.0f) {
                    i11 -= view2.getPaddingRight();
                } else if (f5 == 100.0f) {
                    i11 += view2.getPaddingLeft();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i8 = layoutParams.getOpticalWidth(view2);
                } else {
                    i8 = view2.getWidth();
                }
                i11 -= (int) ((((float) i8) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == view2) {
                return i11;
            }
            Rect rect2 = sRect;
            rect2.right = i11;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect2);
            return sRect.right + layoutParams.getOpticalRightInset();
        } else {
            if (itemAlignmentDef.mOffsetWithPadding) {
                float f6 = itemAlignmentDef.mOffsetPercent;
                if (f6 == 0.0f) {
                    i10 += view2.getPaddingLeft();
                } else if (f6 == 100.0f) {
                    i10 -= view2.getPaddingRight();
                }
            }
            if (itemAlignmentDef.mOffsetPercent != -1.0f) {
                if (view2 == view) {
                    i6 = layoutParams.getOpticalWidth(view2);
                } else {
                    i6 = view2.getWidth();
                }
                i10 += (int) ((((float) i6) * itemAlignmentDef.mOffsetPercent) / 100.0f);
            }
            if (view == view2) {
                return i10;
            }
            Rect rect3 = sRect;
            rect3.left = i10;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect3);
            return sRect.left - layoutParams.getOpticalLeftInset();
        }
    }
}
