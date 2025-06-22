package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams ZERO_MARGIN_LAYOUT_PARAMS;
    private LinearLayoutManager mLayoutManager;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        ZERO_MARGIN_LAYOUT_PARAMS = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(@NonNull LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    private boolean arePagesLaidOutContiguously() {
        boolean z4;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i4;
        int bottom;
        int i5;
        int childCount = this.mLayoutManager.getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (this.mLayoutManager.getOrientation() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = childCount;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = this.mLayoutManager.getChildAt(i6);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = ZERO_MARGIN_LAYOUT_PARAMS;
                }
                int[] iArr3 = iArr2[i6];
                if (z4) {
                    top = childAt.getLeft();
                    i4 = marginLayoutParams.leftMargin;
                } else {
                    top = childAt.getTop();
                    i4 = marginLayoutParams.topMargin;
                }
                iArr3[0] = top - i4;
                int[] iArr4 = iArr2[i6];
                if (z4) {
                    bottom = childAt.getRight();
                    i5 = marginLayoutParams.rightMargin;
                } else {
                    bottom = childAt.getBottom();
                    i5 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = bottom + i5;
                i6++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i7 = 1; i7 < childCount; i7++) {
            if (iArr2[i7 - 1][1] != iArr2[i7][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i8 = iArr5[1];
        int i9 = iArr5[0];
        int i10 = i8 - i9;
        if (i9 > 0 || iArr2[childCount - 1][1] < i10) {
            return false;
        }
        return true;
    }

    private boolean hasRunningChangingLayoutTransition() {
        int childCount = this.mLayoutManager.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (hasRunningChangingLayoutTransition(this.mLayoutManager.getChildAt(i4))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean mayHaveInterferingAnimations() {
        if ((!arePagesLaidOutContiguously() || this.mLayoutManager.getChildCount() <= 1) && hasRunningChangingLayoutTransition()) {
            return true;
        }
        return false;
    }

    private static boolean hasRunningChangingLayoutTransition(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                if (hasRunningChangingLayoutTransition(viewGroup.getChildAt(i4))) {
                    return true;
                }
            }
        }
        return false;
    }
}
