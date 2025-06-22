package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

class PersistentFocusWrapper extends FrameLayout {
    private static final boolean DEBUG = false;
    private static final String TAG = "PersistentFocusWrapper";
    private boolean mPersistFocusVertical = true;
    private int mSelectedPosition = -1;

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean shouldPersistFocusFromDirection(int i4) {
        boolean z4 = this.mPersistFocusVertical;
        if (z4 && (i4 == 33 || i4 == 130)) {
            return true;
        }
        if (z4) {
            return false;
        }
        if (i4 == 17 || i4 == 66) {
            return true;
        }
        return false;
    }

    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        if (hasFocus() || getGrandChildCount() == 0 || !shouldPersistFocusFromDirection(i4)) {
            super.addFocusables(arrayList, i4, i5);
        } else {
            arrayList.add(this);
        }
    }

    public void clearSelection() {
        this.mSelectedPosition = -1;
        if (hasFocus()) {
            clearFocus();
        }
    }

    /* access modifiers changed from: package-private */
    public int getGrandChildCount() {
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup == null) {
            return 0;
        }
        return viewGroup.getChildCount();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mSelectedPosition = savedState.mSelectedPosition;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mSelectedPosition = this.mSelectedPosition;
        return savedState;
    }

    public void persistFocusHorizontal() {
        this.mPersistFocusVertical = false;
    }

    public void persistFocusVertical() {
        this.mPersistFocusVertical = true;
    }

    public void requestChildFocus(View view, View view2) {
        int i4;
        super.requestChildFocus(view, view2);
        while (view2 != null && view2.getParent() != view) {
            view2 = (View) view2.getParent();
        }
        if (view2 == null) {
            i4 = -1;
        } else {
            i4 = ((ViewGroup) view).indexOfChild(view2);
        }
        this.mSelectedPosition = i4;
    }

    public boolean requestFocus(int i4, Rect rect) {
        int i5;
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        if (viewGroup == null || (i5 = this.mSelectedPosition) < 0 || i5 >= getGrandChildCount() || !viewGroup.getChildAt(this.mSelectedPosition).requestFocus(i4, rect)) {
            return super.requestFocus(i4, rect);
        }
        return true;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };
        int mSelectedPosition;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mSelectedPosition = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.mSelectedPosition);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public PersistentFocusWrapper(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
