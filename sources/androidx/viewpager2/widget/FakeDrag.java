package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j4, int i4, float f4, float f5) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j4, i4, f4, f5, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean beginFakeDrag() {
        if (this.mScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = (float) 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean endFakeDrag() {
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        this.mScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
        if (this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.mViewPager.snapToPage();
        return true;
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean fakeDragBy(float f4) {
        boolean z4;
        int i4;
        float f5;
        float f6;
        int i5 = 0;
        if (!this.mScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        float f7 = this.mRequestedDragDistance - f4;
        this.mRequestedDragDistance = f7;
        int round = Math.round(f7 - ((float) this.mActualDraggedDistance));
        this.mActualDraggedDistance += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i4 = round;
        } else {
            i4 = 0;
        }
        if (!z4) {
            i5 = round;
        }
        if (z4) {
            f5 = this.mRequestedDragDistance;
        } else {
            f5 = 0.0f;
        }
        if (z4) {
            f6 = 0.0f;
        } else {
            f6 = this.mRequestedDragDistance;
        }
        this.mRecyclerView.scrollBy(i4, i5);
        addFakeMotionEvent(uptimeMillis, 2, f5, f6);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}
