package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CustomTabsCallback {
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET = 1;
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET_MAXIMIZED = 2;
    public static final int ACTIVITY_LAYOUT_STATE_FULL_SCREEN = 5;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET = 3;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET_MAXIMIZED = 4;
    public static final int ACTIVITY_LAYOUT_STATE_UNKNOWN = 0;
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivityLayoutState {
    }

    public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
    }

    @Nullable
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
        return null;
    }

    public void onActivityLayout(@Dimension(unit = 1) int i4, @Dimension(unit = 1) int i5, @Dimension(unit = 1) int i6, @Dimension(unit = 1) int i7, int i8, @NonNull Bundle bundle) {
    }

    public void onActivityResized(@Dimension(unit = 1) int i4, @Dimension(unit = 1) int i5, @NonNull Bundle bundle) {
    }

    public void onMessageChannelReady(@Nullable Bundle bundle) {
    }

    @ExperimentalMinimizationCallback
    public void onMinimized(@NonNull Bundle bundle) {
    }

    public void onNavigationEvent(int i4, @Nullable Bundle bundle) {
    }

    public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
    }

    public void onRelationshipValidationResult(int i4, @NonNull Uri uri, boolean z4, @Nullable Bundle bundle) {
    }

    @ExperimentalMinimizationCallback
    public void onUnminimized(@NonNull Bundle bundle) {
    }

    public void onWarmupCompleted(@NonNull Bundle bundle) {
    }
}
