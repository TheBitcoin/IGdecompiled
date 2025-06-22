package androidx.leanback.widget;

import android.view.View;
import androidx.annotation.RestrictTo;

interface FocusHighlightHandler {
    void onInitializeView(View view);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    void onItemFocused(View view, boolean z4);
}
