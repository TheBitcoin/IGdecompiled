package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class GuidedActionItemContainer extends NonOverlappingLinearLayoutWithForeground {
    private boolean mFocusOutAllowed;

    public GuidedActionItemContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public View focusSearch(View view, int i4) {
        if (this.mFocusOutAllowed || !Util.isDescendant(this, view)) {
            return super.focusSearch(view, i4);
        }
        View focusSearch = super.focusSearch(view, i4);
        if (Util.isDescendant(this, focusSearch)) {
            return focusSearch;
        }
        return null;
    }

    public void setFocusOutAllowed(boolean z4) {
        this.mFocusOutAllowed = z4;
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuidedActionItemContainer(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mFocusOutAllowed = true;
    }
}
