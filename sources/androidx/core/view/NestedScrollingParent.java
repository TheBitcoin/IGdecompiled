package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f4, float f5, boolean z4);

    boolean onNestedPreFling(@NonNull View view, float f4, float f5);

    void onNestedPreScroll(@NonNull View view, int i4, int i5, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i4, int i5, int i6, int i7);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i4);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i4);

    void onStopNestedScroll(@NonNull View view);
}
