package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "Carousel";
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    /* access modifiers changed from: private */
    public Adapter mAdapter = null;
    private int mAnimateTargetDelay = 200;
    private int mBackwardTransition = -1;
    /* access modifiers changed from: private */
    public float mDampening = 0.9f;
    private int mEmptyViewBehavior = 4;
    private int mFirstViewReference = -1;
    private int mForwardTransition = -1;
    /* access modifiers changed from: private */
    public int mIndex = 0;
    private boolean mInfiniteCarousel = false;
    int mLastStartId = -1;
    private final ArrayList<View> mList = new ArrayList<>();
    /* access modifiers changed from: private */
    public MotionLayout mMotionLayout;
    private int mNextState = -1;
    /* access modifiers changed from: private */
    public int mPreviousIndex = 0;
    private int mPreviousState = -1;
    private int mStartIndex = 0;
    private int mTargetIndex = -1;
    /* access modifiers changed from: private */
    public int mTouchUpMode = 1;
    Runnable mUpdateRunnable = new Runnable() {
        public void run() {
            Carousel.this.mMotionLayout.setProgress(0.0f);
            Carousel.this.updateItems();
            Carousel.this.mAdapter.onNewItem(Carousel.this.mIndex);
            float velocity = Carousel.this.mMotionLayout.getVelocity();
            if (Carousel.this.mTouchUpMode == 2 && velocity > Carousel.this.mVelocityThreshold && Carousel.this.mIndex < Carousel.this.mAdapter.count() - 1) {
                final float access$600 = velocity * Carousel.this.mDampening;
                if (Carousel.this.mIndex == 0 && Carousel.this.mPreviousIndex > Carousel.this.mIndex) {
                    return;
                }
                if (Carousel.this.mIndex != Carousel.this.mAdapter.count() - 1 || Carousel.this.mPreviousIndex >= Carousel.this.mIndex) {
                    Carousel.this.mMotionLayout.post(new Runnable() {
                        public void run() {
                            Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, access$600);
                        }
                    });
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public float mVelocityThreshold = 2.0f;

    public interface Adapter {
        int count();

        void onNewItem(int i4);

        void populate(View view, int i4);
    }

    public Carousel(Context context) {
        super(context);
    }

    public static /* synthetic */ void a(Carousel carousel) {
        carousel.mMotionLayout.setTransitionDuration(carousel.mAnimateTargetDelay);
        if (carousel.mTargetIndex < carousel.mIndex) {
            carousel.mMotionLayout.transitionToState(carousel.mPreviousState, carousel.mAnimateTargetDelay);
        } else {
            carousel.mMotionLayout.transitionToState(carousel.mNextState, carousel.mAnimateTargetDelay);
        }
    }

    private void enableAllTransitions(boolean z4) {
        ArrayList<MotionScene.Transition> definedTransitions = this.mMotionLayout.getDefinedTransitions();
        int size = definedTransitions.size();
        int i4 = 0;
        while (i4 < size) {
            MotionScene.Transition transition = definedTransitions.get(i4);
            i4++;
            transition.setEnabled(z4);
        }
    }

    private boolean enableTransition(int i4, boolean z4) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i4 == -1 || (motionLayout = this.mMotionLayout) == null || (transition = motionLayout.getTransition(i4)) == null || z4 == transition.isEnabled()) {
            return false;
        }
        transition.setEnabled(z4);
        return true;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.mFirstViewReference = obtainStyledAttributes.getResourceId(index, this.mFirstViewReference);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.mBackwardTransition = obtainStyledAttributes.getResourceId(index, this.mBackwardTransition);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.mForwardTransition = obtainStyledAttributes.getResourceId(index, this.mForwardTransition);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.mEmptyViewBehavior = obtainStyledAttributes.getInt(index, this.mEmptyViewBehavior);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.mPreviousState = obtainStyledAttributes.getResourceId(index, this.mPreviousState);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.mNextState = obtainStyledAttributes.getResourceId(index, this.mNextState);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.mDampening = obtainStyledAttributes.getFloat(index, this.mDampening);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.mTouchUpMode = obtainStyledAttributes.getInt(index, this.mTouchUpMode);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.mVelocityThreshold = obtainStyledAttributes.getFloat(index, this.mVelocityThreshold);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.mInfiniteCarousel = obtainStyledAttributes.getBoolean(index, this.mInfiniteCarousel);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public void updateItems() {
        Adapter adapter = this.mAdapter;
        if (adapter != null && this.mMotionLayout != null && adapter.count() != 0) {
            int size = this.mList.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = this.mList.get(i4);
                int i5 = (this.mIndex + i4) - this.mStartIndex;
                if (this.mInfiniteCarousel) {
                    if (i5 < 0) {
                        int i6 = this.mEmptyViewBehavior;
                        if (i6 != 4) {
                            updateViewVisibility(view, i6);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        if (i5 % this.mAdapter.count() == 0) {
                            this.mAdapter.populate(view, 0);
                        } else {
                            Adapter adapter2 = this.mAdapter;
                            adapter2.populate(view, adapter2.count() + (i5 % this.mAdapter.count()));
                        }
                    } else if (i5 >= this.mAdapter.count()) {
                        if (i5 == this.mAdapter.count()) {
                            i5 = 0;
                        } else if (i5 > this.mAdapter.count()) {
                            i5 %= this.mAdapter.count();
                        }
                        int i7 = this.mEmptyViewBehavior;
                        if (i7 != 4) {
                            updateViewVisibility(view, i7);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        this.mAdapter.populate(view, i5);
                    } else {
                        updateViewVisibility(view, 0);
                        this.mAdapter.populate(view, i5);
                    }
                } else if (i5 < 0) {
                    updateViewVisibility(view, this.mEmptyViewBehavior);
                } else if (i5 >= this.mAdapter.count()) {
                    updateViewVisibility(view, this.mEmptyViewBehavior);
                } else {
                    updateViewVisibility(view, 0);
                    this.mAdapter.populate(view, i5);
                }
            }
            int i8 = this.mTargetIndex;
            if (i8 != -1 && i8 != this.mIndex) {
                this.mMotionLayout.post(new a(this));
            } else if (i8 == this.mIndex) {
                this.mTargetIndex = -1;
            }
            if (this.mBackwardTransition == -1 || this.mForwardTransition == -1) {
                Log.w(TAG, "No backward or forward transitions defined for Carousel!");
            } else if (!this.mInfiniteCarousel) {
                int count = this.mAdapter.count();
                if (this.mIndex == 0) {
                    enableTransition(this.mBackwardTransition, false);
                } else {
                    enableTransition(this.mBackwardTransition, true);
                    this.mMotionLayout.setTransition(this.mBackwardTransition);
                }
                if (this.mIndex == count - 1) {
                    enableTransition(this.mForwardTransition, false);
                    return;
                }
                enableTransition(this.mForwardTransition, true);
                this.mMotionLayout.setTransition(this.mForwardTransition);
            }
        }
    }

    private boolean updateViewVisibility(View view, int i4) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z4 = false;
        for (int updateViewVisibility : constraintSetIds) {
            z4 |= updateViewVisibility(updateViewVisibility, view, i4);
        }
        return z4;
    }

    public int getCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public boolean isInfinite() {
        return this.mInfiniteCarousel;
    }

    public void jumpToIndex(int i4) {
        this.mIndex = Math.max(0, Math.min(getCount() - 1, i4));
        refresh();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            this.mList.clear();
            for (int i4 = 0; i4 < this.mCount; i4++) {
                int i5 = this.mIds[i4];
                View viewById = motionLayout.getViewById(i5);
                if (this.mFirstViewReference == i5) {
                    this.mStartIndex = i4;
                }
                this.mList.add(viewById);
            }
            this.mMotionLayout = motionLayout;
            if (this.mTouchUpMode == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.mForwardTransition);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.mMotionLayout.getTransition(this.mBackwardTransition);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            updateItems();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mList.clear();
    }

    public void onTransitionChange(MotionLayout motionLayout, int i4, int i5, float f4) {
        this.mLastStartId = i4;
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i4) {
        int i5 = this.mIndex;
        this.mPreviousIndex = i5;
        if (i4 == this.mNextState) {
            this.mIndex = i5 + 1;
        } else if (i4 == this.mPreviousState) {
            this.mIndex = i5 - 1;
        }
        if (this.mInfiniteCarousel) {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = 0;
            }
            if (this.mIndex < 0) {
                this.mIndex = this.mAdapter.count() - 1;
            }
        } else {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = this.mAdapter.count() - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        }
        if (this.mPreviousIndex != this.mIndex) {
            this.mMotionLayout.post(this.mUpdateRunnable);
        }
    }

    public void refresh() {
        int size = this.mList.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.mList.get(i4);
            if (this.mAdapter.count() == 0) {
                updateViewVisibility(view, this.mEmptyViewBehavior);
            } else {
                updateViewVisibility(view, 0);
            }
        }
        this.mMotionLayout.rebuildScene();
        updateItems();
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public void setInfinite(boolean z4) {
        this.mInfiniteCarousel = z4;
    }

    public void transitionToIndex(int i4, int i5) {
        this.mTargetIndex = Math.max(0, Math.min(getCount() - 1, i4));
        int max = Math.max(0, i5);
        this.mAnimateTargetDelay = max;
        this.mMotionLayout.setTransitionDuration(max);
        if (i4 < this.mIndex) {
            this.mMotionLayout.transitionToState(this.mPreviousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.mNextState, this.mAnimateTargetDelay);
        }
    }

    private boolean updateViewVisibility(int i4, View view, int i5) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = this.mMotionLayout.getConstraintSet(i4);
        if (constraintSet == null || (constraint = constraintSet.getConstraint(view.getId())) == null) {
            return false;
        }
        constraint.propertySet.mVisibilityMode = 1;
        view.setVisibility(i5);
        return true;
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet);
    }
}
