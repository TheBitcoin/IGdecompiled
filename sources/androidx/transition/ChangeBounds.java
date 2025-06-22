package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.Map;

public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY;
    private static final Property<View, PointF> POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY;
    private static final RectEvaluator sRectEvaluator = new RectEvaluator();
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private boolean mResizeClip = false;

    private static class ClipListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int mEndBottom;
        private final Rect mEndClip;
        private final boolean mEndClipIsNull;
        private final int mEndLeft;
        private final int mEndRight;
        private final int mEndTop;
        private boolean mIsCanceled;
        private final int mStartBottom;
        private final Rect mStartClip;
        private final boolean mStartClipIsNull;
        private final int mStartLeft;
        private final int mStartRight;
        private final int mStartTop;
        private final View mView;

        ClipListener(View view, Rect rect, boolean z4, Rect rect2, boolean z5, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.mView = view;
            this.mStartClip = rect;
            this.mStartClipIsNull = z4;
            this.mEndClip = rect2;
            this.mEndClipIsNull = z5;
            this.mStartLeft = i4;
            this.mStartTop = i5;
            this.mStartRight = i6;
            this.mStartBottom = i7;
            this.mEndLeft = i8;
            this.mEndTop = i9;
            this.mEndRight = i10;
            this.mEndBottom = i11;
        }

        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            this.mIsCanceled = true;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
        }

        public void onTransitionPause(@NonNull Transition transition) {
            Rect rect;
            this.mView.setTag(R.id.transition_clip, this.mView.getClipBounds());
            if (this.mEndClipIsNull) {
                rect = null;
            } else {
                rect = this.mEndClip;
            }
            this.mView.setClipBounds(rect);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            View view = this.mView;
            int i4 = R.id.transition_clip;
            this.mView.setTag(i4, (Object) null);
            this.mView.setClipBounds((Rect) view.getTag(i4));
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator, boolean z4) {
            if (!this.mIsCanceled) {
                Rect rect = null;
                if (z4) {
                    if (!this.mStartClipIsNull) {
                        rect = this.mStartClip;
                    }
                } else if (!this.mEndClipIsNull) {
                    rect = this.mEndClip;
                }
                this.mView.setClipBounds(rect);
                if (z4) {
                    ViewUtils.setLeftTopRightBottom(this.mView, this.mStartLeft, this.mStartTop, this.mStartRight, this.mStartBottom);
                } else {
                    ViewUtils.setLeftTopRightBottom(this.mView, this.mEndLeft, this.mEndTop, this.mEndRight, this.mEndBottom);
                }
            }
        }

        public void onAnimationStart(Animator animator, boolean z4) {
            int max = Math.max(this.mStartRight - this.mStartLeft, this.mEndRight - this.mEndLeft);
            int max2 = Math.max(this.mStartBottom - this.mStartTop, this.mEndBottom - this.mEndTop);
            int i4 = z4 ? this.mEndLeft : this.mStartLeft;
            int i5 = z4 ? this.mEndTop : this.mStartTop;
            ViewUtils.setLeftTopRightBottom(this.mView, i4, i5, max + i4, max2 + i5);
            this.mView.setClipBounds(z4 ? this.mEndClip : this.mStartClip);
        }

        public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
            e.a(this, transition, z4);
        }

        public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
            e.b(this, transition, z4);
        }
    }

    private static class SuppressLayoutListener extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final ViewGroup mParent;

        SuppressLayoutListener(@NonNull ViewGroup viewGroup) {
            this.mParent = viewGroup;
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
            this.mCanceled = true;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(this.mParent, false);
            }
            transition.removeListener(this);
        }

        public void onTransitionPause(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, false);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(this.mParent, true);
        }
    }

    private static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private final View mView;

        ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        /* access modifiers changed from: package-private */
        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i4 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i4;
            if (this.mTopLeftCalls == i4) {
                setLeftTopRightBottom();
            }
        }

        /* access modifiers changed from: package-private */
        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i4 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i4;
            if (i4 == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    static {
        Class<PointF> cls = PointF.class;
        TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(cls, "topLeft") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setTopLeft(pointF);
            }
        };
        BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(cls, "bottomRight") {
            public PointF get(ViewBounds viewBounds) {
                return null;
            }

            public void set(ViewBounds viewBounds, PointF pointF) {
                viewBounds.setBottomRight(pointF);
            }
        };
        BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(cls, "bottomRight") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
            }
        };
        TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(cls, "topLeft") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
            }
        };
        POSITION_PROPERTY = new Property<View, PointF>(cls, "position") {
            public PointF get(View view) {
                return null;
            }

            public void set(View view, PointF pointF) {
                int round = Math.round(pointF.x);
                int round2 = Math.round(pointF.y);
                ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
            }
        };
    }

    public ChangeBounds() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
            if (this.mResizeClip) {
                transitionValues.values.put(PROPNAME_CLIP, view.getClipBounds());
            }
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        Rect rect;
        captureValues(transitionValues);
        if (this.mResizeClip && (rect = (Rect) transitionValues.view.getTag(R.id.transition_clip)) != null) {
            transitionValues.values.put(PROPNAME_CLIP, rect);
        }
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i4;
        Animator animator;
        int i5;
        int i6;
        int i7;
        ObjectAnimator objectAnimator;
        boolean z4;
        int i8;
        Rect rect;
        boolean z5;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (transitionValues3 == null || transitionValues4 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues3.values;
        Map<String, Object> map2 = transitionValues4.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = transitionValues4.view;
        Rect rect3 = (Rect) transitionValues3.values.get(PROPNAME_BOUNDS);
        Rect rect4 = (Rect) transitionValues4.values.get(PROPNAME_BOUNDS);
        int i9 = rect3.left;
        int i10 = rect4.left;
        int i11 = rect3.top;
        int i12 = rect4.top;
        int i13 = rect3.right;
        int i14 = rect4.right;
        int i15 = rect3.bottom;
        int i16 = rect4.bottom;
        int i17 = i13 - i9;
        int i18 = i15 - i11;
        int i19 = i14 - i10;
        int i20 = i16 - i12;
        Rect rect5 = (Rect) transitionValues3.values.get(PROPNAME_CLIP);
        Rect rect6 = (Rect) transitionValues4.values.get(PROPNAME_CLIP);
        if ((i17 == 0 || i18 == 0) && (i19 == 0 || i20 == 0)) {
            i4 = 0;
        } else {
            if (i9 == i10 && i11 == i12) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (!(i13 == i14 && i15 == i16)) {
                i4++;
            }
        }
        if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
            i4++;
        }
        if (i4 <= 0) {
            return null;
        }
        Rect rect7 = rect5;
        if (!this.mResizeClip) {
            ViewUtils.setLeftTopRightBottom(view, i9, i11, i13, i15);
            if (i4 == 2) {
                if (i17 == i19 && i18 == i20) {
                    animator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath((float) i9, (float) i11, (float) i10, (float) i12));
                } else {
                    ViewBounds viewBounds = new ViewBounds(view);
                    ObjectAnimator ofPointF = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath((float) i9, (float) i11, (float) i10, (float) i12));
                    ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{ofPointF, ofPointF2});
                    animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) {
                        private final ViewBounds mViewBounds;
                        final /* synthetic */ ViewBounds val$viewBounds;

                        {
                            this.val$viewBounds = r2;
                            this.mViewBounds = r2;
                        }
                    });
                    animator = animatorSet;
                }
            } else if (i9 == i10 && i11 == i12) {
                animator = ObjectAnimatorUtils.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath((float) i13, (float) i15, (float) i14, (float) i16));
            } else {
                animator = ObjectAnimatorUtils.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath((float) i9, (float) i11, (float) i10, (float) i12));
            }
        } else {
            int i21 = i20;
            Rect rect8 = rect6;
            ViewUtils.setLeftTopRightBottom(view, i9, i11, Math.max(i17, i19) + i9, i11 + Math.max(i18, i21));
            if (i9 == i10 && i11 == i12) {
                objectAnimator = null;
                i7 = i15;
                i5 = i16;
                i6 = i10;
            } else {
                i7 = i15;
                i5 = i16;
                i6 = i10;
                objectAnimator = ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath((float) i9, (float) i11, (float) i10, (float) i12));
            }
            int i22 = i12;
            if (rect7 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                i8 = 0;
                rect = new Rect(0, 0, i17, i18);
            } else {
                i8 = 0;
                rect = rect7;
            }
            int i23 = i14;
            if (rect8 == null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                rect2 = new Rect(i8, i8, i19, i21);
            } else {
                rect2 = rect8;
            }
            if (!rect.equals(rect2)) {
                view.setClipBounds(rect);
                RectEvaluator rectEvaluator = sRectEvaluator;
                Object[] objArr = new Object[2];
                objArr[i8] = rect;
                objArr[1] = rect2;
                objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                ClipListener clipListener = new ClipListener(view, rect, z4, rect2, z5, i9, i11, i13, i7, i6, i22, i23, i5);
                objectAnimator2.addListener(clipListener);
                addListener(clipListener);
            } else {
                objectAnimator2 = null;
            }
            animator = TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            ViewGroupUtils.suppressLayout(viewGroup4, true);
            getRootTransition().addListener(new SuppressLayoutListener(viewGroup4));
        }
        return animator;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public void setResizeClip(boolean z4) {
        this.mResizeClip = z4;
    }

    public ChangeBounds(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
