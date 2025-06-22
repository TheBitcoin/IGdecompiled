package androidx.core.view;

import androidx.annotation.Nullable;

public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i4, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6);

    boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, @Nullable int[] iArr, int i8);

    boolean hasNestedScrollingParent(int i4);

    boolean startNestedScroll(int i4, int i5);

    void stopNestedScroll(int i4);
}
