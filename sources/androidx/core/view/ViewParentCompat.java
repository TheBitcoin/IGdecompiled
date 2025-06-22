package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean onNestedFling(ViewParent viewParent, View view, float f4, float f5, boolean z4) {
            return viewParent.onNestedFling(view, f4, f5, z4);
        }

        @DoNotInline
        static boolean onNestedPreFling(ViewParent viewParent, View view, float f4, float f5) {
            return viewParent.onNestedPreFling(view, f4, f5);
        }

        @DoNotInline
        static void onNestedPreScroll(ViewParent viewParent, View view, int i4, int i5, int[] iArr) {
            viewParent.onNestedPreScroll(view, i4, i5, iArr);
        }

        @DoNotInline
        static void onNestedScroll(ViewParent viewParent, View view, int i4, int i5, int i6, int i7) {
            viewParent.onNestedScroll(view, i4, i5, i6, i7);
        }

        @DoNotInline
        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i4) {
            viewParent.onNestedScrollAccepted(view, view2, i4);
        }

        @DoNotInline
        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i4) {
            return viewParent.onStartNestedScroll(view, view2, i4);
        }

        @DoNotInline
        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i4) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i4);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f5, boolean z4) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f4, f5, z4);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f4, float f5) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f4, f5);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4, int i5, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i4, i5, iArr, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4, int i5, int i6, int i7) {
        onNestedScroll(viewParent, view, i4, i5, i6, i7, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i4) {
        onNestedScrollAccepted(viewParent, view, view2, i4, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i4) {
        return onStartNestedScroll(viewParent, view, view2, i4, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4, int i5, @NonNull int[] iArr, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i4, i5, iArr, i6);
        } else if (i6 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i4, i5, iArr);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e5);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i4, i5);
        } else if (i5 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i4);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e5);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i4, i5);
        }
        if (i5 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i4);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e5);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i4);
        } else if (i4 == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e5);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4, int i5, int i6, int i7, int i8) {
        onNestedScroll(viewParent, view, i4, i5, i6, i7, i8, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i4, i5, i6, i7, i8, iArr);
            return;
        }
        int i9 = i4;
        View view2 = view;
        int[] iArr2 = iArr;
        int i10 = i8;
        int i11 = i7;
        int i12 = i6;
        int i13 = i5;
        int i14 = i9;
        iArr2[0] = iArr2[0] + i12;
        iArr2[1] = iArr2[1] + i11;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view2, i14, i13, i12, i11, i10);
        } else if (i10 == 0) {
            ViewParent viewParent2 = viewParent;
            try {
                Api21Impl.onNestedScroll(viewParent2, view2, i14, i13, i12, i11);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent2 + " does not implement interface method onNestedScroll", e5);
            }
        }
    }
}
