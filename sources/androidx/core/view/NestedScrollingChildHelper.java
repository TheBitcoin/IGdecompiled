package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r9 = r19;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean dispatchNestedScrollInternal(int r14, int r15, int r16, int r17, @androidx.annotation.Nullable int[] r18, int r19, @androidx.annotation.Nullable int[] r20) {
        /*
            r13 = this;
            r0 = r18
            boolean r1 = r13.isNestedScrollingEnabled()
            r2 = 0
            if (r1 == 0) goto L_0x005e
            r9 = r19
            android.view.ViewParent r3 = r13.getNestedScrollingParentForType(r9)
            if (r3 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 1
            if (r14 != 0) goto L_0x0023
            if (r15 != 0) goto L_0x0023
            if (r16 != 0) goto L_0x0023
            if (r17 == 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            if (r0 == 0) goto L_0x005e
            r0[r2] = r2
            r0[r1] = r2
            goto L_0x005e
        L_0x0023:
            if (r0 == 0) goto L_0x0031
            android.view.View r4 = r13.mView
            r4.getLocationInWindow(r0)
            r4 = r0[r2]
            r5 = r0[r1]
            r11 = r4
            r12 = r5
            goto L_0x0033
        L_0x0031:
            r11 = 0
            r12 = 0
        L_0x0033:
            if (r20 != 0) goto L_0x003f
            int[] r4 = r13.getTempNestedScrollConsumed()
            r4[r2] = r2
            r4[r1] = r2
            r10 = r4
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            android.view.View r4 = r13.mView
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            androidx.core.view.ViewParentCompat.onNestedScroll(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x005d
            android.view.View r14 = r13.mView
            r14.getLocationInWindow(r0)
            r14 = r0[r2]
            int r14 = r14 - r11
            r0[r2] = r14
            r14 = r0[r1]
            int r14 = r14 - r12
            r0[r1] = r14
        L_0x005d:
            return r1
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.NestedScrollingChildHelper.dispatchNestedScrollInternal(int, int, int, int, int[], int, int[]):boolean");
    }

    private ViewParent getNestedScrollingParentForType(int i4) {
        if (i4 == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i4 != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i4, ViewParent viewParent) {
        if (i4 == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else if (i4 == 1) {
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f4, f5, z4);
    }

    public boolean dispatchNestedPreFling(float f4, float f5) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f4, f5);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i4, i5, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, 0, (int[]) null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z4) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z4;
    }

    public boolean startNestedScroll(int i4) {
        return startNestedScroll(i4, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6) {
        ViewParent nestedScrollingParentForType;
        int i7;
        int i8;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i6)) == null) {
            return false;
        }
        if (i4 == 0 && i5 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i7 = iArr2[1];
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i4, i5, iArr3, i6);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i7;
        }
        if (iArr3[0] == 0 && iArr3[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8) {
        return dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, i8, (int[]) null);
    }

    public boolean hasNestedScrollingParent(int i4) {
        return getNestedScrollingParentForType(i4) != null;
    }

    public boolean startNestedScroll(int i4, int i5) {
        if (hasNestedScrollingParent(i5)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i4, i5)) {
                setNestedScrollingParentForType(i5, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i4, i5);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i4) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i4);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i4);
            setNestedScrollingParentForType(i4, (ViewParent) null);
        }
    }

    public void dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i4, i5, i6, i7, iArr, i8, iArr2);
    }
}
