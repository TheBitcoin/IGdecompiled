package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount = -1;
    Object mLastEventPayload = null;
    int mLastEventPosition = -1;
    int mLastEventType = 0;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i4 = this.mLastEventType;
        if (i4 != 0) {
            if (i4 == 1) {
                this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
            } else if (i4 == 2) {
                this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
            } else if (i4 == 3) {
                this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
            }
            this.mLastEventPayload = null;
            this.mLastEventType = 0;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i4, int i5, Object obj) {
        int i6;
        if (this.mLastEventType == 3) {
            int i7 = this.mLastEventPosition;
            int i8 = this.mLastEventCount;
            if (i4 <= i7 + i8 && (i6 = i4 + i5) >= i7 && this.mLastEventPayload == obj) {
                this.mLastEventPosition = Math.min(i4, i7);
                this.mLastEventCount = Math.max(i8 + i7, i6) - this.mLastEventPosition;
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i4;
        this.mLastEventCount = i5;
        this.mLastEventPayload = obj;
        this.mLastEventType = 3;
    }

    public void onInserted(int i4, int i5) {
        int i6;
        if (this.mLastEventType == 1 && i4 >= (i6 = this.mLastEventPosition)) {
            int i7 = this.mLastEventCount;
            if (i4 <= i6 + i7) {
                this.mLastEventCount = i7 + i5;
                this.mLastEventPosition = Math.min(i4, i6);
                return;
            }
        }
        dispatchLastEvent();
        this.mLastEventPosition = i4;
        this.mLastEventCount = i5;
        this.mLastEventType = 1;
    }

    public void onMoved(int i4, int i5) {
        dispatchLastEvent();
        this.mWrapped.onMoved(i4, i5);
    }

    public void onRemoved(int i4, int i5) {
        int i6;
        if (this.mLastEventType != 2 || (i6 = this.mLastEventPosition) < i4 || i6 > i4 + i5) {
            dispatchLastEvent();
            this.mLastEventPosition = i4;
            this.mLastEventCount = i5;
            this.mLastEventType = 2;
            return;
        }
        this.mLastEventCount += i5;
        this.mLastEventPosition = i4;
    }
}
