package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private long mAnimationStartTime = 0;
    /* access modifiers changed from: private */
    public int mBeginState = -1;
    private RectF mBoundsCheck = new RectF();
    int mCurrentState = -1;
    int mDebugPath = 0;
    private DecelerateInterpolator mDecelerateLogic = new DecelerateInterpolator();
    private ArrayList<MotionHelper> mDecoratorsHelpers = null;
    private boolean mDelayedApply = false;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    /* access modifiers changed from: private */
    public int mEndState = -1;
    int mEndWrapHeight;
    int mEndWrapWidth;
    boolean mFirstDown = true;
    HashMap<View, MotionController> mFrameArrayList = new HashMap<>();
    private int mFrames = 0;
    int mHeightMeasureMode;
    private boolean mInLayout = false;
    /* access modifiers changed from: private */
    public boolean mInRotation = false;
    boolean mInTransition = false;
    boolean mIndirectTransition = false;
    private boolean mInteractionEnabled = true;
    Interpolator mInterpolator;
    private Matrix mInverseMatrix = null;
    boolean mIsAnimating = false;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache = new KeyCache();
    private long mLastDrawTime = -1;
    private float mLastFps = 0.0f;
    /* access modifiers changed from: private */
    public int mLastHeightMeasureSpec = 0;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    private float mLastPos;
    float mLastVelocity = 0.0f;
    /* access modifiers changed from: private */
    public int mLastWidthMeasureSpec = 0;
    private float mLastY;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    protected boolean mMeasureDuringTransition = false;
    Model mModel = new Model();
    private boolean mNeedsFireTransitionCompleted = false;
    int mOldHeight;
    int mOldWidth;
    private Runnable mOnComplete = null;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    float mPostInterpolationPosition;
    HashMap<View, ViewState> mPreRotate = new HashMap<>();
    /* access modifiers changed from: private */
    public int mPreRotateHeight;
    /* access modifiers changed from: private */
    public int mPreRotateWidth;
    private int mPreviouseRotation;
    Interpolator mProgressInterpolator = null;
    private View mRegionView = null;
    int mRotatMode = 0;
    MotionScene mScene;
    private int[] mScheduledTransitionTo = null;
    int mScheduledTransitions = 0;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    /* access modifiers changed from: private */
    public StateCache mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    Rect mTempRect = new Rect();
    private boolean mTemporalInterpolator = false;
    ArrayList<Integer> mTransitionCompleted = new ArrayList<>();
    private float mTransitionDuration = 1.0f;
    float mTransitionGoalPosition = 0.0f;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition = 0.0f;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private CopyOnWriteArrayList<TransitionListener> mTransitionListeners = null;
    float mTransitionPosition = 0.0f;
    TransitionState mTransitionState = TransitionState.UNDEFINED;
    boolean mUndergoingMotion = false;
    int mWidthMeasureMode;

    class DecelerateInterpolator extends MotionInterpolator {
        float mCurrentP = 0.0f;
        float mInitialV = 0.0f;
        float mMaxA;

        DecelerateInterpolator() {
        }

        public void config(float f4, float f5, float f6) {
            this.mInitialV = f4;
            this.mCurrentP = f5;
            this.mMaxA = f6;
        }

        public float getInterpolation(float f4) {
            float f5;
            float f6;
            float f7 = this.mInitialV;
            if (f7 > 0.0f) {
                float f8 = this.mMaxA;
                if (f7 / f8 < f4) {
                    f4 = f7 / f8;
                }
                MotionLayout.this.mLastVelocity = f7 - (f8 * f4);
                f5 = (f7 * f4) - (((f8 * f4) * f4) / 2.0f);
                f6 = this.mCurrentP;
            } else {
                float f9 = this.mMaxA;
                if ((-f7) / f9 < f4) {
                    f4 = (-f7) / f9;
                }
                MotionLayout.this.mLastVelocity = (f9 * f4) + f7;
                f5 = (f7 * f4) + (((f9 * f4) * f4) / 2.0f);
                f6 = this.mCurrentP;
            }
            return f5 + f6;
        }

        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    private class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        Rect mBounds = new Rect();
        DashPathEffect mDashPathEffect;
        final int mDiamondSize = 10;
        Paint mFillPaint;
        final int mGraphColor = -13391360;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        final int mKeyframeColor = -2067046;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode = false;
        private float[] mRectangle;
        final int mRedColor = -21965;
        final int mShadowColor = 1996488704;
        int mShadowTranslate = 1;
        Paint mTextPaint;

        DevModeDraw() {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(-21965);
            this.mPaint.setStrokeWidth(2.0f);
            Paint paint2 = this.mPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.mPaintKeyframes = paint3;
            paint3.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2.0f);
            this.mPaintKeyframes.setStyle(style);
            Paint paint4 = new Paint();
            this.mPaintGraph = paint4;
            paint4.setAntiAlias(true);
            this.mPaintGraph.setColor(-13391360);
            this.mPaintGraph.setStrokeWidth(2.0f);
            this.mPaintGraph.setStyle(style);
            Paint paint5 = new Paint();
            this.mTextPaint = paint5;
            paint5.setAntiAlias(true);
            this.mTextPaint.setColor(-13391360);
            this.mTextPaint.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.mRectangle = new float[8];
            Paint paint6 = new Paint();
            this.mFillPaint = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.mDashPathEffect = dashPathEffect;
            this.mPaintGraph.setPathEffect(dashPathEffect);
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if (this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8.0f);
                this.mFillPaint.setStrokeWidth(8.0f);
                this.mPaintKeyframes.setStrokeWidth(8.0f);
                this.mShadowTranslate = 4;
            }
        }

        private void drawBasicPath(Canvas canvas) {
            canvas.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas canvas) {
            boolean z4 = false;
            boolean z5 = false;
            for (int i4 = 0; i4 < this.mKeyFrameCount; i4++) {
                int i5 = this.mPathMode[i4];
                if (i5 == 1) {
                    z4 = true;
                }
                if (i5 == 0) {
                    z5 = true;
                }
            }
            if (z4) {
                drawPathRelative(canvas);
            }
            if (z5) {
                drawPathCartesian(canvas);
            }
        }

        private void drawPathCartesian(Canvas canvas) {
            float[] fArr = this.mPoints;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f4, f6), Math.max(f5, f7), Math.max(f4, f6), Math.max(f5, f7), this.mPaintGraph);
            canvas.drawLine(Math.min(f4, f6), Math.min(f5, f7), Math.min(f4, f6), Math.max(f5, f7), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas canvas, float f4, float f5) {
            Canvas canvas2 = canvas;
            float[] fArr = this.mPoints;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            float min = Math.min(f6, f8);
            float max = Math.max(f7, f9);
            float min2 = f4 - Math.min(f6, f8);
            float max2 = Math.max(f7, f9) - f5;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f8 - f6))) + 0.5d))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.mBounds.width() / 2))) + min, f5 - 20.0f, this.mTextPaint);
            canvas2.drawLine(f4, f5, Math.min(f6, f8), f5, this.mPaintGraph);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f9 - f7))) + 0.5d))) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas2.drawText(str2, f4 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas2.drawLine(f4, f5, f4, Math.max(f7, f9), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas canvas) {
            float[] fArr = this.mPoints;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas canvas, float f4, float f5) {
            float[] fArr = this.mPoints;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[fArr.length - 2];
            float f9 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f6 - f8), (double) (f7 - f9));
            float f10 = f8 - f6;
            float f11 = f9 - f7;
            float f12 = (((f4 - f6) * f10) + ((f5 - f7) * f11)) / (hypot * hypot);
            float f13 = f6 + (f10 * f12);
            float f14 = f7 + (f12 * f11);
            Path path = new Path();
            path.moveTo(f4, f5);
            path.lineTo(f13, f14);
            float hypot2 = (float) Math.hypot((double) (f13 - f4), (double) (f14 - f5));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            Canvas canvas2 = canvas;
            canvas2.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.mBounds.width() / 2)), -20.0f, this.mTextPaint);
            canvas2.drawLine(f4, f5, f13, f14, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas canvas, float f4, float f5, int i4, int i5) {
            String str = "" + (((float) ((int) (((double) (((f4 - ((float) (i4 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i4)))) + 0.5d))) / 100.0f);
            getTextBounds(str, this.mTextPaint);
            canvas.drawText(str, ((f4 / 2.0f) - ((float) (this.mBounds.width() / 2))) + 0.0f, f5 - 20.0f, this.mTextPaint);
            Canvas canvas2 = canvas;
            canvas2.drawLine(f4, f5, Math.min(0.0f, 1.0f), f5, this.mPaintGraph);
            String str2 = "" + (((float) ((int) (((double) (((f5 - ((float) (i5 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i5)))) + 0.5d))) / 100.0f);
            getTextBounds(str2, this.mTextPaint);
            canvas.drawText(str2, 5.0f + f4, 0.0f - ((f5 / 2.0f) - ((float) (this.mBounds.height() / 2))), this.mTextPaint);
            canvas2.drawLine(f4, f5, f4, Math.max(0.0f, 1.0f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas canvas, MotionController motionController) {
            this.mPath.reset();
            for (int i4 = 0; i4 <= 50; i4++) {
                motionController.buildRect(((float) i4) / ((float) 50), this.mRectangle, 0);
                Path path = this.mPath;
                float[] fArr = this.mRectangle;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.mPath;
                float[] fArr2 = this.mRectangle;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.mPath;
                float[] fArr3 = this.mRectangle;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.mPath;
                float[] fArr4 = this.mRectangle;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.mPath.close();
            }
            this.mPaint.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.translate(-2.0f, -2.0f);
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas canvas, int i4, int i5, MotionController motionController) {
            int i6;
            int i7;
            Canvas canvas2 = canvas;
            int i8 = i4;
            MotionController motionController2 = motionController;
            View view = motionController2.mView;
            if (view != null) {
                i7 = view.getWidth();
                i6 = motionController2.mView.getHeight();
            } else {
                i7 = 0;
                i6 = 0;
            }
            for (int i9 = 1; i9 < i5 - 1; i9++) {
                if (i8 != 4 || this.mPathMode[i9 - 1] != 0) {
                    float[] fArr = this.mKeyFramePoints;
                    int i10 = i9 * 2;
                    float f4 = fArr[i10];
                    float f5 = fArr[i10 + 1];
                    this.mPath.reset();
                    this.mPath.moveTo(f4, f5 + 10.0f);
                    this.mPath.lineTo(f4 + 10.0f, f5);
                    this.mPath.lineTo(f4, f5 - 10.0f);
                    this.mPath.lineTo(f4 - 10.0f, f5);
                    this.mPath.close();
                    int i11 = i9 - 1;
                    motionController2.getKeyFrame(i11);
                    if (i8 == 4) {
                        int i12 = this.mPathMode[i11];
                        if (i12 == 1) {
                            drawPathRelativeTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i12 == 0) {
                            drawPathCartesianTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (i12 == 2) {
                            drawPathScreenTicks(canvas2, f4 - 0.0f, f5 - 0.0f, i7, i6);
                        }
                        canvas2.drawPath(this.mPath, this.mFillPaint);
                    }
                    if (i8 == 2) {
                        drawPathRelativeTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                    }
                    if (i8 == 3) {
                        drawPathCartesianTicks(canvas2, f4 - 0.0f, f5 - 0.0f);
                    }
                    if (i8 == 6) {
                        drawPathScreenTicks(canvas2, f4 - 0.0f, f5 - 0.0f, i7, i6);
                    }
                    canvas2.drawPath(this.mPath, this.mFillPaint);
                }
            }
            float[] fArr2 = this.mPoints;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.mPaintKeyframes);
                float[] fArr3 = this.mPoints;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas canvas, float f4, float f5, float f6, float f7) {
            canvas.drawRect(f4, f5, f6, f7, this.mPaintGraph);
            canvas.drawLine(f4, f5, f6, f7, this.mPaintGraph);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i4, int i5) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i5 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.mTextPaint);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.mPaint);
                }
                for (MotionController next : hashMap.values()) {
                    int drawPath = next.getDrawPath();
                    if (i5 > 0 && drawPath == 0) {
                        drawPath = 1;
                    }
                    if (drawPath != 0) {
                        this.mKeyFrameCount = next.buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                        if (drawPath >= 1) {
                            int i6 = i4 / 16;
                            float[] fArr = this.mPoints;
                            if (fArr == null || fArr.length != i6 * 2) {
                                this.mPoints = new float[(i6 * 2)];
                                this.mPath = new Path();
                            }
                            int i7 = this.mShadowTranslate;
                            canvas.translate((float) i7, (float) i7);
                            this.mPaint.setColor(1996488704);
                            this.mFillPaint.setColor(1996488704);
                            this.mPaintKeyframes.setColor(1996488704);
                            this.mPaintGraph.setColor(1996488704);
                            next.buildPath(this.mPoints, i6);
                            drawAll(canvas, drawPath, this.mKeyFrameCount, next);
                            this.mPaint.setColor(-21965);
                            this.mPaintKeyframes.setColor(-2067046);
                            this.mFillPaint.setColor(-2067046);
                            this.mPaintGraph.setColor(-13391360);
                            int i8 = this.mShadowTranslate;
                            canvas.translate((float) (-i8), (float) (-i8));
                            drawAll(canvas, drawPath, this.mKeyFrameCount, next);
                            if (drawPath == 5) {
                                drawRectangle(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void drawAll(Canvas canvas, int i4, int i5, MotionController motionController) {
            if (i4 == 4) {
                drawPathAsConfigured(canvas);
            }
            if (i4 == 2) {
                drawPathRelative(canvas);
            }
            if (i4 == 3) {
                drawPathCartesian(canvas);
            }
            drawBasicPath(canvas);
            drawTicks(canvas, i4, i5, motionController);
        }

        /* access modifiers changed from: package-private */
        public void getTextBounds(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.mBounds);
        }
    }

    class Model {
        ConstraintSet mEnd = null;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd = new ConstraintWidgetContainer();
        ConstraintWidgetContainer mLayoutStart = new ConstraintWidgetContainer();
        ConstraintSet mStart = null;
        int mStartId;

        Model() {
        }

        private void computeStartEndSize(int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.mCurrentState == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutEnd;
                ConstraintSet constraintSet = this.mEnd;
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i9 = i4;
                } else {
                    i9 = i5;
                }
                if (constraintSet == null || constraintSet.mRotate == 0) {
                    i10 = i5;
                } else {
                    i10 = i4;
                }
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, i9, i10);
                ConstraintSet constraintSet2 = this.mStart;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    int i12 = constraintSet2.mRotate;
                    if (i12 == 0) {
                        i11 = i4;
                    } else {
                        i11 = i5;
                    }
                    if (i12 == 0) {
                        i4 = i5;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i11, i4);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.mStart;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                int i13 = constraintSet3.mRotate;
                if (i13 == 0) {
                    i7 = i4;
                } else {
                    i7 = i5;
                }
                if (i13 == 0) {
                    i8 = i5;
                } else {
                    i8 = i4;
                }
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i7, i8);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.mLayoutEnd;
            ConstraintSet constraintSet4 = this.mEnd;
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i6 = i4;
            } else {
                i6 = i5;
            }
            if (constraintSet4 == null || constraintSet4.mRotate == 0) {
                i4 = i5;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i6, i4);
        }

        @SuppressLint({"LogConditional"})
        private void debugLayout(String str, ConstraintWidgetContainer constraintWidgetContainer) {
            String str2;
            String str3;
            String str4;
            String str5 = str + " " + Debug.getName((View) constraintWidgetContainer.getCompanionWidget());
            Log.v(MotionLayout.TAG, str5 + "  ========= " + constraintWidgetContainer);
            int size = constraintWidgetContainer.getChildren().size();
            for (int i4 = 0; i4 < size; i4++) {
                String str6 = str5 + "[" + i4 + "] ";
                ConstraintWidget constraintWidget = constraintWidgetContainer.getChildren().get(i4);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                String str7 = "_";
                if (constraintWidget.mTop.mTarget != null) {
                    str2 = ExifInterface.GPS_DIRECTION_TRUE;
                } else {
                    str2 = str7;
                }
                sb.append(str2);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (constraintWidget.mBottom.mTarget != null) {
                    str3 = "B";
                } else {
                    str3 = str7;
                }
                sb3.append(str3);
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                if (constraintWidget.mLeft.mTarget != null) {
                    str4 = "L";
                } else {
                    str4 = str7;
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                if (constraintWidget.mRight.mTarget != null) {
                    str7 = "R";
                }
                sb7.append(str7);
                String sb8 = sb7.toString();
                View view = (View) constraintWidget.getCompanionWidget();
                String name = Debug.getName(view);
                if (view instanceof TextView) {
                    name = name + "(" + ((TextView) view).getText() + ")";
                }
                Log.v(MotionLayout.TAG, str6 + "  " + name + " " + constraintWidget + " " + sb8);
            }
            Log.v(MotionLayout.TAG, str5 + " done. ");
        }

        @SuppressLint({"LogConditional"})
        private void debugLayoutParam(String str, ConstraintLayout.LayoutParams layoutParams) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            if (layoutParams.startToStart != -1) {
                str2 = "SS";
            } else {
                str2 = "__";
            }
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            String str13 = "|__";
            if (layoutParams.startToEnd != -1) {
                str3 = "|SE";
            } else {
                str3 = str13;
            }
            sb3.append(str3);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            if (layoutParams.endToStart != -1) {
                str4 = "|ES";
            } else {
                str4 = str13;
            }
            sb5.append(str4);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            if (layoutParams.endToEnd != -1) {
                str5 = "|EE";
            } else {
                str5 = str13;
            }
            sb7.append(str5);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(sb8);
            if (layoutParams.leftToLeft != -1) {
                str6 = "|LL";
            } else {
                str6 = str13;
            }
            sb9.append(str6);
            String sb10 = sb9.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb10);
            if (layoutParams.leftToRight != -1) {
                str7 = "|LR";
            } else {
                str7 = str13;
            }
            sb11.append(str7);
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            if (layoutParams.rightToLeft != -1) {
                str8 = "|RL";
            } else {
                str8 = str13;
            }
            sb13.append(str8);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb14);
            if (layoutParams.rightToRight != -1) {
                str9 = "|RR";
            } else {
                str9 = str13;
            }
            sb15.append(str9);
            String sb16 = sb15.toString();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(sb16);
            if (layoutParams.topToTop != -1) {
                str10 = "|TT";
            } else {
                str10 = str13;
            }
            sb17.append(str10);
            String sb18 = sb17.toString();
            StringBuilder sb19 = new StringBuilder();
            sb19.append(sb18);
            if (layoutParams.topToBottom != -1) {
                str11 = "|TB";
            } else {
                str11 = str13;
            }
            sb19.append(str11);
            String sb20 = sb19.toString();
            StringBuilder sb21 = new StringBuilder();
            sb21.append(sb20);
            if (layoutParams.bottomToTop != -1) {
                str12 = "|BT";
            } else {
                str12 = str13;
            }
            sb21.append(str12);
            String sb22 = sb21.toString();
            StringBuilder sb23 = new StringBuilder();
            sb23.append(sb22);
            if (layoutParams.bottomToBottom != -1) {
                str13 = "|BB";
            }
            sb23.append(str13);
            String sb24 = sb23.toString();
            Log.v(MotionLayout.TAG, str + sb24);
        }

        @SuppressLint({"LogConditional"})
        private void debugWidget(String str, ConstraintWidget constraintWidget) {
            String str2;
            String str3;
            String str4;
            String str5;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            String str6 = "B";
            String str7 = "__";
            if (constraintWidget.mTop.mTarget != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ExifInterface.GPS_DIRECTION_TRUE);
                sb2.append(constraintWidget.mTop.mTarget.mType == ConstraintAnchor.Type.TOP ? ExifInterface.GPS_DIRECTION_TRUE : str6);
                str2 = sb2.toString();
            } else {
                str2 = str7;
            }
            sb.append(str2);
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb3);
            if (constraintWidget.mBottom.mTarget != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str6);
                if (constraintWidget.mBottom.mTarget.mType == ConstraintAnchor.Type.TOP) {
                    str6 = ExifInterface.GPS_DIRECTION_TRUE;
                }
                sb5.append(str6);
                str3 = sb5.toString();
            } else {
                str3 = str7;
            }
            sb4.append(str3);
            String sb6 = sb4.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(sb6);
            String str8 = "R";
            if (constraintWidget.mLeft.mTarget != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("L");
                if (constraintWidget.mLeft.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str5 = "L";
                } else {
                    str5 = str8;
                }
                sb8.append(str5);
                str4 = sb8.toString();
            } else {
                str4 = str7;
            }
            sb7.append(str4);
            String sb9 = sb7.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb9);
            if (constraintWidget.mRight.mTarget != null) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str8);
                if (constraintWidget.mRight.mTarget.mType == ConstraintAnchor.Type.LEFT) {
                    str8 = "L";
                }
                sb11.append(str8);
                str7 = sb11.toString();
            }
            sb10.append(str7);
            String sb12 = sb10.toString();
            Log.v(MotionLayout.TAG, str + sb12 + " ---  " + constraintWidget);
        }

        private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            int i4 = 0;
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (!(constraintSet == null || constraintSet.mRotate == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.mLayoutEnd, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            int i5 = 0;
            while (i5 < size) {
                ConstraintWidget constraintWidget = children.get(i5);
                i5++;
                ConstraintWidget constraintWidget2 = constraintWidget;
                constraintWidget2.setAnimated(true);
                sparseArray.put(((View) constraintWidget2.getCompanionWidget()).getId(), constraintWidget2);
            }
            ArrayList<ConstraintWidget> children2 = constraintWidgetContainer.getChildren();
            int size2 = children2.size();
            int i6 = 0;
            while (i6 < size2) {
                int i7 = i6 + 1;
                ConstraintWidget constraintWidget3 = children2.get(i6);
                View view = (View) constraintWidget3.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                constraintWidget3.setWidth(constraintSet.getWidth(view.getId()));
                constraintWidget3.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, constraintWidget3, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget3, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    constraintWidget3.setVisibility(view.getVisibility());
                } else {
                    constraintWidget3.setVisibility(constraintSet.getVisibility(view.getId()));
                }
                i6 = i7;
            }
            ArrayList<ConstraintWidget> children3 = constraintWidgetContainer.getChildren();
            int size3 = children3.size();
            while (i4 < size3) {
                ConstraintWidget constraintWidget4 = children3.get(i4);
                i4++;
                ConstraintWidget constraintWidget5 = constraintWidget4;
                if (constraintWidget5 instanceof VirtualLayout) {
                    Helper helper = (Helper) constraintWidget5;
                    ((ConstraintHelper) constraintWidget5.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0133 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void build() {
            /*
                r17 = this;
                r0 = r17
                androidx.constraintlayout.motion.widget.MotionLayout r1 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r1 = r1.getChildCount()
                androidx.constraintlayout.motion.widget.MotionLayout r2 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r2 = r2.mFrameArrayList
                r2.clear()
                android.util.SparseArray r2 = new android.util.SparseArray
                r2.<init>()
                int[] r3 = new int[r1]
                r4 = 0
                r5 = 0
            L_0x0018:
                if (r5 >= r1) goto L_0x0038
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r6 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionController r7 = new androidx.constraintlayout.motion.widget.MotionController
                r7.<init>(r6)
                int r8 = r6.getId()
                r3[r5] = r8
                r2.put(r8, r7)
                androidx.constraintlayout.motion.widget.MotionLayout r8 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r8 = r8.mFrameArrayList
                r8.put(r6, r7)
                int r5 = r5 + 1
                goto L_0x0018
            L_0x0038:
                r5 = 0
            L_0x0039:
                if (r5 >= r1) goto L_0x0137
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.view.View r9 = r6.getChildAt(r5)
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r6 = r6.mFrameArrayList
                java.lang.Object r6 = r6.get(r9)
                r7 = r6
                androidx.constraintlayout.motion.widget.MotionController r7 = (androidx.constraintlayout.motion.widget.MotionController) r7
                if (r7 != 0) goto L_0x0050
                goto L_0x0133
            L_0x0050:
                androidx.constraintlayout.widget.ConstraintSet r6 = r0.mStart
                java.lang.String r13 = ")"
                java.lang.String r14 = " ("
                java.lang.String r15 = "no widget for  "
                java.lang.String r8 = "MotionLayout"
                if (r6 == 0) goto L_0x00b2
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r0.mLayoutStart
                androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.getWidget(r6, r9)
                if (r6 == 0) goto L_0x007c
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r6 = r10.toRect(r6)
                androidx.constraintlayout.widget.ConstraintSet r10 = r0.mStart
                androidx.constraintlayout.motion.widget.MotionLayout r11 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r11 = r11.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r12 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r12 = r12.getHeight()
                r7.setStartState(r6, r10, r11, r12)
                goto L_0x00b0
            L_0x007c:
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r6 = r6.mDebugPath
                if (r6 == 0) goto L_0x00b0
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r6.append(r10)
                r6.append(r15)
                java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getName(r9)
                r6.append(r10)
                r6.append(r14)
                java.lang.Class r10 = r9.getClass()
                java.lang.String r10 = r10.getName()
                r6.append(r10)
                r6.append(r13)
                java.lang.String r6 = r6.toString()
                android.util.Log.e(r8, r6)
            L_0x00b0:
                r6 = r8
                goto L_0x00db
            L_0x00b2:
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                boolean r6 = r6.mInRotation
                if (r6 == 0) goto L_0x00b0
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                java.util.HashMap<android.view.View, androidx.constraintlayout.motion.utils.ViewState> r6 = r6.mPreRotate
                java.lang.Object r6 = r6.get(r9)
                androidx.constraintlayout.motion.utils.ViewState r6 = (androidx.constraintlayout.motion.utils.ViewState) r6
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                r11 = r10
                int r10 = r11.mRotatMode
                int r11 = r11.mPreRotateWidth
                androidx.constraintlayout.motion.widget.MotionLayout r12 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r12 = r12.mPreRotateHeight
                r16 = r8
                r8 = r6
                r6 = r16
                r7.setStartState(r8, r9, r10, r11, r12)
            L_0x00db:
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.mEnd
                if (r8 == 0) goto L_0x0133
                androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8 = r0.mLayoutEnd
                androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.getWidget(r8, r9)
                if (r8 == 0) goto L_0x00ff
                androidx.constraintlayout.motion.widget.MotionLayout r6 = androidx.constraintlayout.motion.widget.MotionLayout.this
                android.graphics.Rect r6 = r6.toRect(r8)
                androidx.constraintlayout.widget.ConstraintSet r8 = r0.mEnd
                androidx.constraintlayout.motion.widget.MotionLayout r9 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r9 = r9.getWidth()
                androidx.constraintlayout.motion.widget.MotionLayout r10 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r10 = r10.getHeight()
                r7.setEndState(r6, r8, r9, r10)
                goto L_0x0133
            L_0x00ff:
                androidx.constraintlayout.motion.widget.MotionLayout r7 = androidx.constraintlayout.motion.widget.MotionLayout.this
                int r7 = r7.mDebugPath
                if (r7 == 0) goto L_0x0133
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getLocation()
                r7.append(r8)
                r7.append(r15)
                java.lang.String r8 = androidx.constraintlayout.motion.widget.Debug.getName(r9)
                r7.append(r8)
                r7.append(r14)
                java.lang.Class r8 = r9.getClass()
                java.lang.String r8 = r8.getName()
                r7.append(r8)
                r7.append(r13)
                java.lang.String r7 = r7.toString()
                android.util.Log.e(r6, r7)
            L_0x0133:
                int r5 = r5 + 1
                goto L_0x0039
            L_0x0137:
                if (r4 >= r1) goto L_0x0154
                r5 = r3[r4]
                java.lang.Object r5 = r2.get(r5)
                androidx.constraintlayout.motion.widget.MotionController r5 = (androidx.constraintlayout.motion.widget.MotionController) r5
                int r6 = r5.getAnimateRelativeTo()
                r7 = -1
                if (r6 == r7) goto L_0x0151
                java.lang.Object r6 = r2.get(r6)
                androidx.constraintlayout.motion.widget.MotionController r6 = (androidx.constraintlayout.motion.widget.MotionController) r6
                r5.setupRelative(r6)
            L_0x0151:
                int r4 = r4 + 1
                goto L_0x0137
            L_0x0154:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.build():void");
        }

        /* access modifiers changed from: package-private */
        public void copy(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            int size = children.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                ConstraintWidget constraintWidget2 = children.get(i5);
                i5++;
                ConstraintWidget constraintWidget3 = constraintWidget2;
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.core.widgets.Barrier();
                } else if (constraintWidget3 instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (constraintWidget3 instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (constraintWidget3 instanceof Placeholder) {
                    constraintWidget = new Placeholder();
                } else if (constraintWidget3 instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(constraintWidget3, constraintWidget);
            }
            int size2 = children.size();
            while (i4 < size2) {
                ConstraintWidget constraintWidget4 = children.get(i4);
                i4++;
                ConstraintWidget constraintWidget5 = constraintWidget4;
                ((ConstraintWidget) hashMap.get(constraintWidget5)).copy(constraintWidget5, hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public ConstraintWidget getWidget(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget = children.get(i4);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void initFrom(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.mStart = constraintSet;
            this.mEnd = constraintSet2;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutStart);
            copy(MotionLayout.this.mLayoutWidget, this.mLayoutEnd);
            if (((double) MotionLayout.this.mTransitionLastPosition) > 0.5d) {
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
            } else {
                setupConstraintWidget(this.mLayoutEnd, constraintSet2);
                if (constraintSet != null) {
                    setupConstraintWidget(this.mLayoutStart, constraintSet);
                }
            }
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.mLayoutStart;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.mLayoutEnd.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean isNotConfiguredWith(int i4, int i5) {
            if (i4 == this.mStartId && i5 == this.mEndId) {
                return false;
            }
            return true;
        }

        public void measure(int i4, int i5) {
            boolean z4;
            boolean z5;
            boolean z6;
            int mode = View.MeasureSpec.getMode(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            computeStartEndSize(i4, i5);
            if (!((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824)) {
                computeStartEndSize(i4, i5);
                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout motionLayout2 = MotionLayout.this;
                if (motionLayout2.mStartWrapWidth == motionLayout2.mEndWrapWidth && motionLayout2.mStartWrapHeight == motionLayout2.mEndWrapHeight) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                motionLayout2.mMeasureDuringTransition = z6;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i6 = motionLayout3.mStartWrapWidth;
            int i7 = motionLayout3.mStartWrapHeight;
            int i8 = motionLayout3.mWidthMeasureMode;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                i6 = (int) (((float) i6) + (motionLayout3.mPostInterpolationPosition * ((float) (motionLayout3.mEndWrapWidth - i6))));
            }
            int i9 = i6;
            int i10 = motionLayout3.mHeightMeasureMode;
            if (i10 == Integer.MIN_VALUE || i10 == 0) {
                i7 = (int) (((float) i7) + (motionLayout3.mPostInterpolationPosition * ((float) (motionLayout3.mEndWrapHeight - i7))));
            }
            int i11 = i7;
            if (this.mLayoutStart.isWidthMeasuredTooSmall() || this.mLayoutEnd.isWidthMeasuredTooSmall()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (this.mLayoutStart.isHeightMeasuredTooSmall() || this.mLayoutEnd.isHeightMeasuredTooSmall()) {
                z5 = true;
            } else {
                z5 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i4, i5, i9, i11, z4, z5);
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int i4, int i5) {
            this.mStartId = i4;
            this.mEndId = i5;
        }
    }

    protected interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i4);

        void computeCurrentVelocity(int i4, float f4);

        float getXVelocity();

        float getXVelocity(int i4);

        float getYVelocity();

        float getYVelocity(int i4);

        void recycle();
    }

    class StateCache {
        int mEndState = -1;
        final String mKeyEndState = "motion.EndState";
        final String mKeyProgress = "motion.progress";
        final String mKeyStartState = "motion.StartState";
        final String mKeyVelocity = "motion.velocity";
        float mProgress = Float.NaN;
        int mStartState = -1;
        float mVelocity = Float.NaN;

        StateCache() {
        }

        /* access modifiers changed from: package-private */
        public void apply() {
            int i4 = this.mStartState;
            if (!(i4 == -1 && this.mEndState == -1)) {
                if (i4 == -1) {
                    MotionLayout.this.transitionToState(this.mEndState);
                } else {
                    int i5 = this.mEndState;
                    if (i5 == -1) {
                        MotionLayout.this.setState(i4, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i4, i5);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.mVelocity)) {
                MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
                this.mProgress = Float.NaN;
                this.mVelocity = Float.NaN;
                this.mStartState = -1;
                this.mEndState = -1;
            } else if (!Float.isNaN(this.mProgress)) {
                MotionLayout.this.setProgress(this.mProgress);
            }
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.mProgress);
            bundle.putFloat("motion.velocity", this.mVelocity);
            bundle.putInt("motion.StartState", this.mStartState);
            bundle.putInt("motion.EndState", this.mEndState);
            return bundle;
        }

        public void recordState() {
            this.mEndState = MotionLayout.this.mEndState;
            this.mStartState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int i4) {
            this.mEndState = i4;
        }

        public void setProgress(float f4) {
            this.mProgress = f4;
        }

        public void setStartState(int i4) {
            this.mStartState = i4;
        }

        public void setTransitionState(Bundle bundle) {
            this.mProgress = bundle.getFloat("motion.progress");
            this.mVelocity = bundle.getFloat("motion.velocity");
            this.mStartState = bundle.getInt("motion.StartState");
            this.mEndState = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f4) {
            this.mVelocity = f4;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i4, int i5, float f4);

        void onTransitionCompleted(MotionLayout motionLayout, int i4);

        void onTransitionStarted(MotionLayout motionLayout, int i4, int i5);

        void onTransitionTrigger(MotionLayout motionLayout, int i4, boolean z4, float f4);
    }

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private boolean callTransformedTouchEvent(View view, MotionEvent motionEvent, float f4, float f5) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f4, f5);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f4, -f5);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f4, f5);
        if (this.mInverseMatrix == null) {
            this.mInverseMatrix = new Matrix();
        }
        matrix.invert(this.mInverseMatrix);
        obtain.transform(this.mInverseMatrix);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList<MotionScene.Transition> definedTransitions = this.mScene.getDefinedTransitions();
        int size = definedTransitions.size();
        int i4 = 0;
        while (i4 < size) {
            MotionScene.Transition transition = definedTransitions.get(i4);
            i4++;
            MotionScene.Transition transition2 = transition;
            if (transition2 == this.mScene.mCurrentTransition) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(transition2);
            int startConstraintSetId = transition2.getStartConstraintSetId();
            int endConstraintSetId = transition2.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetStart " + name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetEnd " + name);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    @SuppressLint({"LogConditional"})
    private void debugPos() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        float f4;
        boolean z4;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        if (!(interpolator instanceof StopLogic)) {
            f4 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
        } else {
            f4 = 0.0f;
        }
        float f5 = this.mTransitionLastPosition + f4;
        if (this.mTransitionInstantly) {
            f5 = this.mTransitionGoalPosition;
        }
        int i4 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i4 <= 0 || f5 < this.mTransitionGoalPosition) && (signum > 0.0f || f5 > this.mTransitionGoalPosition)) {
            z4 = false;
        } else {
            f5 = this.mTransitionGoalPosition;
            z4 = true;
        }
        if (interpolator != null && !z4) {
            if (this.mTemporalInterpolator) {
                f5 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f5 = interpolator.getInterpolation(f5);
            }
        }
        if ((i4 > 0 && f5 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f5 <= this.mTransitionGoalPosition)) {
            f5 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f5;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.mProgressInterpolator;
        if (interpolator2 != null) {
            f5 = interpolator2.getInterpolation(f5);
        }
        float f6 = f5;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f6, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                fireTransitionStarted();
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f4 = this.mTransitionPosition;
            this.mListenerPosition = f4;
            TransitionListener transitionListener = this.mTransitionListener;
            if (transitionListener != null) {
                transitionListener.onTransitionChange(this, this.mBeginState, this.mEndState, f4);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted() {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handlesTouchEvent(float r8, float r9, android.view.View r10, android.view.MotionEvent r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof android.view.ViewGroup
            r1 = 1
            if (r0 == 0) goto L_0x0036
            r0 = r10
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r2 = r0.getChildCount()
            int r2 = r2 - r1
        L_0x000d:
            if (r2 < 0) goto L_0x0036
            android.view.View r3 = r0.getChildAt(r2)
            int r4 = r3.getLeft()
            float r4 = (float) r4
            float r4 = r4 + r8
            int r5 = r10.getScrollX()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = r5 + r9
            int r6 = r10.getScrollY()
            float r6 = (float) r6
            float r5 = r5 - r6
            boolean r3 = r7.handlesTouchEvent(r4, r5, r3, r11)
            if (r3 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0037
        L_0x0033:
            int r2 = r2 + -1
            goto L_0x000d
        L_0x0036:
            r0 = 0
        L_0x0037:
            if (r0 != 0) goto L_0x0075
            android.graphics.RectF r2 = r7.mBoundsCheck
            int r3 = r10.getRight()
            float r3 = (float) r3
            float r3 = r3 + r8
            int r4 = r10.getLeft()
            float r4 = (float) r4
            float r3 = r3 - r4
            int r4 = r10.getBottom()
            float r4 = (float) r4
            float r4 = r4 + r9
            int r5 = r10.getTop()
            float r5 = (float) r5
            float r4 = r4 - r5
            r2.set(r8, r9, r3, r4)
            int r2 = r11.getAction()
            if (r2 != 0) goto L_0x006c
            android.graphics.RectF r2 = r7.mBoundsCheck
            float r3 = r11.getX()
            float r4 = r11.getY()
            boolean r2 = r2.contains(r3, r4)
            if (r2 == 0) goto L_0x0075
        L_0x006c:
            float r8 = -r8
            float r9 = -r9
            boolean r8 = r7.callTransformedTouchEvent(r10, r11, r8, r9)
            if (r8 == 0) goto L_0x0075
            return r1
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.handlesTouchEvent(float, float, android.view.View, android.view.MotionEvent):boolean");
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i4;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z4 = true;
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z4 = obtainStyledAttributes.getBoolean(index, z4);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        this.mDebugPath = i4;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z4) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState == -1 && (motionScene = this.mScene) != null) {
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void processTransitionCompleted() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) {
            int i4 = 0;
            this.mIsAnimating = false;
            ArrayList<Integer> arrayList = this.mTransitionCompleted;
            int size = arrayList.size();
            while (i4 < size) {
                Integer num = arrayList.get(i4);
                i4++;
                Integer num2 = num;
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, num2.intValue());
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.mTransitionListeners;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionCompleted(this, num2.intValue());
                    }
                }
            }
            this.mTransitionCompleted.clear();
        }
    }

    /* access modifiers changed from: private */
    public void setupMotionViews() {
        float f4;
        float f5;
        int childCount = getChildCount();
        this.mModel.build();
        boolean z4 = true;
        this.mInTransition = true;
        SparseArray sparseArray = new SparseArray();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        if (gatPathMotionArc != -1) {
            for (int i6 = 0; i6 < childCount; i6++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i6));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.mFrameArrayList.size()];
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i8));
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i7] = motionController2.getAnimateRelativeTo();
                i7++;
            }
        }
        if (this.mDecoratorsHelpers != null) {
            for (int i9 = 0; i9 < i7; i9++) {
                MotionController motionController3 = this.mFrameArrayList.get(findViewById(iArr[i9]));
                if (motionController3 != null) {
                    this.mScene.getKeyFrames(motionController3);
                }
            }
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                MotionHelper motionHelper = arrayList.get(i10);
                i10++;
                motionHelper.onPreSetup(this, this.mFrameArrayList);
            }
            for (int i11 = 0; i11 < i7; i11++) {
                MotionController motionController4 = this.mFrameArrayList.get(findViewById(iArr[i11]));
                if (motionController4 != null) {
                    motionController4.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        } else {
            for (int i12 = 0; i12 < i7; i12++) {
                MotionController motionController5 = this.mFrameArrayList.get(findViewById(iArr[i12]));
                if (motionController5 != null) {
                    this.mScene.getKeyFrames(motionController5);
                    motionController5.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            MotionController motionController6 = this.mFrameArrayList.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.mScene.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            if (((double) staggered) >= 0.0d) {
                z4 = false;
            }
            float abs = Math.abs(staggered);
            float f6 = -3.4028235E38f;
            float f7 = Float.MAX_VALUE;
            float f8 = Float.MAX_VALUE;
            float f9 = -3.4028235E38f;
            for (int i14 = 0; i14 < childCount; i14++) {
                MotionController motionController7 = this.mFrameArrayList.get(getChildAt(i14));
                if (!Float.isNaN(motionController7.mMotionStagger)) {
                    for (int i15 = 0; i15 < childCount; i15++) {
                        MotionController motionController8 = this.mFrameArrayList.get(getChildAt(i15));
                        if (!Float.isNaN(motionController8.mMotionStagger)) {
                            f7 = Math.min(f7, motionController8.mMotionStagger);
                            f6 = Math.max(f6, motionController8.mMotionStagger);
                        }
                    }
                    while (i4 < childCount) {
                        MotionController motionController9 = this.mFrameArrayList.get(getChildAt(i4));
                        if (!Float.isNaN(motionController9.mMotionStagger)) {
                            motionController9.mStaggerScale = 1.0f / (1.0f - abs);
                            if (z4) {
                                motionController9.mStaggerOffset = abs - (((f6 - motionController9.mMotionStagger) / (f6 - f7)) * abs);
                            } else {
                                motionController9.mStaggerOffset = abs - (((motionController9.mMotionStagger - f7) * abs) / (f6 - f7));
                            }
                        }
                        i4++;
                    }
                    return;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                if (z4) {
                    f5 = finalY - finalX;
                } else {
                    f5 = finalY + finalX;
                }
                f8 = Math.min(f8, f5);
                f9 = Math.max(f9, f5);
            }
            while (i4 < childCount) {
                MotionController motionController10 = this.mFrameArrayList.get(getChildAt(i4));
                float finalX2 = motionController10.getFinalX();
                float finalY2 = motionController10.getFinalY();
                if (z4) {
                    f4 = finalY2 - finalX2;
                } else {
                    f4 = finalY2 + finalX2;
                }
                motionController10.mStaggerScale = 1.0f / (1.0f - abs);
                motionController10.mStaggerOffset = abs - (((f4 - f8) * abs) / (f9 - f8));
                i4++;
            }
        }
    }

    /* access modifiers changed from: private */
    public Rect toRect(ConstraintWidget constraintWidget) {
        this.mTempRect.top = constraintWidget.getY();
        this.mTempRect.left = constraintWidget.getX();
        Rect rect = this.mTempRect;
        int width = constraintWidget.getWidth();
        Rect rect2 = this.mTempRect;
        rect.right = width + rect2.left;
        int height = constraintWidget.getHeight();
        Rect rect3 = this.mTempRect;
        rect2.bottom = height + rect3.top;
        return rect3;
    }

    private static boolean willJump(float f4, float f5, float f6) {
        if (f4 > 0.0f) {
            float f7 = f4 / f6;
            return f5 + ((f4 * f7) - (((f6 * f7) * f7) / 2.0f)) > 1.0f;
        }
        float f8 = (-f4) / f6;
        return f5 + ((f4 * f8) + (((f6 * f8) * f8) / 2.0f)) < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new CopyOnWriteArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    /* access modifiers changed from: package-private */
    public void animateTo(float f4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f5 = this.mTransitionLastPosition;
            float f6 = this.mTransitionPosition;
            if (f5 != f6 && this.mTransitionInstantly) {
                this.mTransitionLastPosition = f6;
            }
            float f7 = this.mTransitionLastPosition;
            if (f7 != f4) {
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = f4;
                this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
                setProgress(this.mTransitionGoalPosition);
                this.mInterpolator = null;
                this.mProgressInterpolator = this.mScene.getInterpolator();
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                this.mInTransition = true;
                this.mTransitionPosition = f7;
                this.mTransitionLastPosition = f7;
                invalidate();
            }
        }
    }

    public boolean applyViewTransition(int i4, MotionController motionController) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i4, motionController);
        }
        return false;
    }

    public ConstraintSet cloneConstraintSet(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet constraintSet = motionScene.getConstraintSet(i4);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(constraintSet);
        return constraintSet2;
    }

    /* access modifiers changed from: package-private */
    public void disableAutoTransition(boolean z4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z4);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        String str;
        ViewTransitionController viewTransitionController;
        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
        int i4 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                MotionHelper motionHelper = arrayList.get(i5);
                i5++;
                motionHelper.onPreDraw(canvas);
            }
        }
        evaluate(false);
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (viewTransitionController = motionScene.mViewTransitionController) == null)) {
            viewTransitionController.animate();
        }
        super.dispatchDraw(canvas);
        if (this.mScene != null) {
            if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
                this.mFrames++;
                long nanoTime = getNanoTime();
                long j4 = this.mLastDrawTime;
                if (j4 != -1) {
                    long j5 = nanoTime - j4;
                    if (j5 > 200000000) {
                        this.mLastFps = ((float) ((int) ((((float) this.mFrames) / (((float) j5) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.mFrames = 0;
                        this.mLastDrawTime = nanoTime;
                    }
                } else {
                    this.mLastDrawTime = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
                sb.append(Debug.getState(this, this.mEndState));
                sb.append(" (progress: ");
                sb.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb.append(" ) state=");
                int i6 = this.mCurrentState;
                if (i6 == -1) {
                    str = "undefined";
                } else {
                    str = Debug.getState(this, i6);
                }
                sb.append(str);
                String sb2 = sb.toString();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawText(sb2, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb2, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.mDebugPath > 1) {
                if (this.mDevModeDraw == null) {
                    this.mDevModeDraw = new DevModeDraw();
                }
                this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
            }
            ArrayList<MotionHelper> arrayList2 = this.mDecoratorsHelpers;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                while (i4 < size2) {
                    MotionHelper motionHelper2 = arrayList2.get(i4);
                    i4++;
                    motionHelper2.onPostDraw(canvas);
                }
            }
        }
    }

    public void enableTransition(int i4, boolean z4) {
        MotionScene.Transition transition = getTransition(i4);
        if (z4) {
            transition.setEnabled(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i4, boolean z4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.enableViewTransition(i4, z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void endTrigger(boolean z4) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            MotionController motionController = this.mFrameArrayList.get(getChildAt(i4));
            if (motionController != null) {
                motionController.endTrigger(z4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x020b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluate(boolean r21) {
        /*
            r20 = this;
            r0 = r20
            long r1 = r0.mTransitionLastTime
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0010
            long r1 = r0.getNanoTime()
            r0.mTransitionLastTime = r1
        L_0x0010:
            float r1 = r0.mTransitionLastPosition
            r2 = -1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0020
            r0.mCurrentState = r2
        L_0x0020:
            boolean r5 = r0.mKeepAnimating
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x0032
            boolean r5 = r0.mInTransition
            if (r5 == 0) goto L_0x023b
            if (r21 != 0) goto L_0x0032
            float r5 = r0.mTransitionGoalPosition
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x023b
        L_0x0032:
            float r5 = r0.mTransitionGoalPosition
            float r5 = r5 - r1
            float r1 = java.lang.Math.signum(r5)
            long r8 = r0.getNanoTime()
            android.view.animation.Interpolator r5 = r0.mInterpolator
            boolean r10 = r5 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0053
            long r12 = r0.mTransitionLastTime
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.mTransitionDuration
            float r10 = r10 / r12
            goto L_0x0054
        L_0x0053:
            r10 = 0
        L_0x0054:
            float r12 = r0.mTransitionLastPosition
            float r12 = r12 + r10
            boolean r13 = r0.mTransitionInstantly
            if (r13 == 0) goto L_0x005d
            float r12 = r0.mTransitionGoalPosition
        L_0x005d:
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0067
            float r14 = r0.mTransitionGoalPosition
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0071
        L_0x0067:
            int r14 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r14 > 0) goto L_0x0077
            float r14 = r0.mTransitionGoalPosition
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0077
        L_0x0071:
            float r12 = r0.mTransitionGoalPosition
            r0.mInTransition = r7
            r14 = 1
            goto L_0x0078
        L_0x0077:
            r14 = 0
        L_0x0078:
            r0.mTransitionLastPosition = r12
            r0.mTransitionPosition = r12
            r0.mTransitionLastTime = r8
            r15 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r5 == 0) goto L_0x010a
            if (r14 != 0) goto L_0x010a
            boolean r14 = r0.mTemporalInterpolator
            if (r14 == 0) goto L_0x00e9
            r21 = 814313567(0x3089705f, float:1.0E-9)
            long r11 = r0.mAnimationStartTime
            long r11 = r8 - r11
            float r10 = (float) r11
            float r10 = r10 * r21
            float r5 = r5.getInterpolation(r10)
            android.view.animation.Interpolator r10 = r0.mInterpolator
            androidx.constraintlayout.motion.utils.StopLogic r11 = r0.mStopLogic
            r12 = 2
            if (r10 != r11) goto L_0x00a8
            boolean r10 = r11.isStopped()
            if (r10 == 0) goto L_0x00a6
            r10 = 2
            goto L_0x00a9
        L_0x00a6:
            r10 = 1
            goto L_0x00a9
        L_0x00a8:
            r10 = 0
        L_0x00a9:
            r0.mTransitionLastPosition = r5
            r0.mTransitionLastTime = r8
            android.view.animation.Interpolator r8 = r0.mInterpolator
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r9 == 0) goto L_0x00e7
            androidx.constraintlayout.motion.widget.MotionInterpolator r8 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r8
            float r8 = r8.getVelocity()
            r0.mLastVelocity = r8
            float r9 = java.lang.Math.abs(r8)
            float r11 = r0.mTransitionDuration
            float r9 = r9 * r11
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 > 0) goto L_0x00cb
            if (r10 != r12) goto L_0x00cb
            r0.mInTransition = r7
        L_0x00cb:
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x00d9
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 < 0) goto L_0x00d9
            r0.mTransitionLastPosition = r3
            r0.mInTransition = r7
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x00d9:
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x00e7
            int r8 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x00e7
            r0.mTransitionLastPosition = r4
            r0.mInTransition = r7
            r12 = 0
            goto L_0x010d
        L_0x00e7:
            r12 = r5
            goto L_0x010d
        L_0x00e9:
            float r5 = r5.getInterpolation(r12)
            android.view.animation.Interpolator r8 = r0.mInterpolator
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.MotionInterpolator
            if (r9 == 0) goto L_0x00fc
            androidx.constraintlayout.motion.widget.MotionInterpolator r8 = (androidx.constraintlayout.motion.widget.MotionInterpolator) r8
            float r8 = r8.getVelocity()
            r0.mLastVelocity = r8
            goto L_0x0107
        L_0x00fc:
            float r12 = r12 + r10
            float r8 = r8.getInterpolation(r12)
            float r8 = r8 - r5
            float r8 = r8 * r1
            float r8 = r8 / r10
            r0.mLastVelocity = r8
        L_0x0107:
            r12 = r5
        L_0x0108:
            r10 = 0
            goto L_0x010d
        L_0x010a:
            r0.mLastVelocity = r10
            goto L_0x0108
        L_0x010d:
            float r5 = r0.mLastVelocity
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x011c
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r5 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r5)
        L_0x011c:
            if (r10 == r6) goto L_0x0143
            if (r13 <= 0) goto L_0x0126
            float r5 = r0.mTransitionGoalPosition
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0130
        L_0x0126:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0134
            float r5 = r0.mTransitionGoalPosition
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0134
        L_0x0130:
            float r12 = r0.mTransitionGoalPosition
            r0.mInTransition = r7
        L_0x0134:
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x013c
            int r5 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0143
        L_0x013c:
            r0.mInTransition = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r5 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r5)
        L_0x0143:
            int r5 = r0.getChildCount()
            r0.mKeepAnimating = r7
            long r17 = r0.getNanoTime()
            r0.mPostInterpolationPosition = r12
            android.view.animation.Interpolator r8 = r0.mProgressInterpolator
            if (r8 != 0) goto L_0x0156
            r16 = r12
            goto L_0x015c
        L_0x0156:
            float r8 = r8.getInterpolation(r12)
            r16 = r8
        L_0x015c:
            android.view.animation.Interpolator r8 = r0.mProgressInterpolator
            if (r8 == 0) goto L_0x0174
            float r9 = r0.mTransitionDuration
            float r9 = r1 / r9
            float r9 = r9 + r12
            float r8 = r8.getInterpolation(r9)
            r0.mLastVelocity = r8
            android.view.animation.Interpolator r9 = r0.mProgressInterpolator
            float r9 = r9.getInterpolation(r12)
            float r8 = r8 - r9
            r0.mLastVelocity = r8
        L_0x0174:
            r8 = 0
        L_0x0175:
            if (r8 >= r5) goto L_0x0196
            android.view.View r15 = r0.getChildAt(r8)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r9 = r0.mFrameArrayList
            java.lang.Object r9 = r9.get(r15)
            r14 = r9
            androidx.constraintlayout.motion.widget.MotionController r14 = (androidx.constraintlayout.motion.widget.MotionController) r14
            if (r14 == 0) goto L_0x0193
            boolean r9 = r0.mKeepAnimating
            androidx.constraintlayout.core.motion.utils.KeyCache r10 = r0.mKeyCache
            r19 = r10
            boolean r10 = r14.interpolate(r15, r16, r17, r19)
            r9 = r9 | r10
            r0.mKeepAnimating = r9
        L_0x0193:
            int r8 = r8 + 1
            goto L_0x0175
        L_0x0196:
            if (r13 <= 0) goto L_0x019e
            float r5 = r0.mTransitionGoalPosition
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x01a8
        L_0x019e:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x01aa
            float r5 = r0.mTransitionGoalPosition
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01aa
        L_0x01a8:
            r5 = 1
            goto L_0x01ab
        L_0x01aa:
            r5 = 0
        L_0x01ab:
            boolean r8 = r0.mKeepAnimating
            if (r8 != 0) goto L_0x01ba
            boolean r8 = r0.mInTransition
            if (r8 != 0) goto L_0x01ba
            if (r5 == 0) goto L_0x01ba
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r8 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r8)
        L_0x01ba:
            boolean r8 = r0.mMeasureDuringTransition
            if (r8 == 0) goto L_0x01c1
            r0.requestLayout()
        L_0x01c1:
            boolean r8 = r0.mKeepAnimating
            r5 = r5 ^ r6
            r5 = r5 | r8
            r0.mKeepAnimating = r5
            int r5 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x01e4
            int r5 = r0.mBeginState
            if (r5 == r2) goto L_0x01e4
            int r2 = r0.mCurrentState
            if (r2 == r5) goto L_0x01e4
            r0.mCurrentState = r5
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r2 = r2.getConstraintSet(r5)
            r2.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x01e4:
            double r8 = (double) r12
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 < 0) goto L_0x0202
            int r2 = r0.mCurrentState
            int r5 = r0.mEndState
            if (r2 == r5) goto L_0x0202
            r0.mCurrentState = r5
            androidx.constraintlayout.motion.widget.MotionScene r2 = r0.mScene
            androidx.constraintlayout.widget.ConstraintSet r2 = r2.getConstraintSet(r5)
            r2.applyCustomAttributes(r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x0202:
            boolean r2 = r0.mKeepAnimating
            if (r2 != 0) goto L_0x021f
            boolean r2 = r0.mInTransition
            if (r2 == 0) goto L_0x020b
            goto L_0x021f
        L_0x020b:
            if (r13 <= 0) goto L_0x0211
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0219
        L_0x0211:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0222
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0222
        L_0x0219:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            goto L_0x0222
        L_0x021f:
            r0.invalidate()
        L_0x0222:
            boolean r2 = r0.mKeepAnimating
            if (r2 != 0) goto L_0x023b
            boolean r2 = r0.mInTransition
            if (r2 != 0) goto L_0x023b
            if (r13 <= 0) goto L_0x0230
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0238
        L_0x0230:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x023b
            int r1 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x023b
        L_0x0238:
            r0.onNewStateAttachHandlers()
        L_0x023b:
            float r1 = r0.mTransitionLastPosition
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x024d
            int r1 = r0.mCurrentState
            int r2 = r0.mEndState
            if (r1 == r2) goto L_0x0248
            goto L_0x0249
        L_0x0248:
            r6 = r7
        L_0x0249:
            r0.mCurrentState = r2
        L_0x024b:
            r7 = r6
            goto L_0x025c
        L_0x024d:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x025c
            int r1 = r0.mCurrentState
            int r2 = r0.mBeginState
            if (r1 == r2) goto L_0x0258
            goto L_0x0259
        L_0x0258:
            r6 = r7
        L_0x0259:
            r0.mCurrentState = r2
            goto L_0x024b
        L_0x025c:
            boolean r1 = r0.mNeedsFireTransitionCompleted
            r1 = r1 | r7
            r0.mNeedsFireTransitionCompleted = r1
            if (r7 == 0) goto L_0x026a
            boolean r1 = r0.mInLayout
            if (r1 != 0) goto L_0x026a
            r0.requestLayout()
        L_0x026a:
            float r1 = r0.mTransitionLastPosition
            r0.mTransitionPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.evaluate(boolean):void");
    }

    /* access modifiers changed from: protected */
    public void fireTransitionCompleted() {
        int i4;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.mTransitionListener != null || ((copyOnWriteArrayList = this.mTransitionListeners) != null && !copyOnWriteArrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                ArrayList<Integer> arrayList = this.mTransitionCompleted;
                i4 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i4 = -1;
            }
            int i5 = this.mCurrentState;
            if (!(i4 == i5 || i5 == -1)) {
                this.mTransitionCompleted.add(Integer.valueOf(i5));
            }
        }
        processTransitionCompleted();
        Runnable runnable = this.mOnComplete;
        if (runnable != null) {
            runnable.run();
            this.mOnComplete = null;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr != null && this.mScheduledTransitions > 0) {
            transitionToState(iArr[0]);
            int[] iArr2 = this.mScheduledTransitionTo;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.mScheduledTransitions--;
        }
    }

    public void fireTrigger(int i4, boolean z4, float f4) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i4, z4, f4);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i4, z4, f4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void getAnchorDpDt(int i4, float f4, float f5, float f6, float[] fArr) {
        String str;
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i4);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f4, f5, f6, fArr);
            float y4 = viewById.getY();
            this.mLastPos = f4;
            this.mLastY = y4;
            return;
        }
        if (viewById == null) {
            str = "" + i4;
        } else {
            str = viewById.getContext().getResources().getResourceName(i4);
        }
        Log.w(TAG, "WARNING could not find view id " + str);
    }

    public ConstraintSet getConstraintSet(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i4);
    }

    @IdRes
    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    /* access modifiers changed from: package-private */
    public String getConstraintSetNames(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i4);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public int[] getMatchingConstraintSetIds(String... strArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getMatchingStateLabels(strArr);
    }

    /* access modifiers changed from: package-private */
    public MotionController getMotionController(int i4) {
        return this.mFrameArrayList.get(findViewById(i4));
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public MotionScene getScene() {
        return this.mScene;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i4) {
        return this.mScene.getTransitionById(i4);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f4, float f5, float[] fArr, int i4) {
        float f6;
        float[] fArr2;
        float f7 = this.mLastVelocity;
        float f8 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f8);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f6 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f7 = (signum * ((interpolation - f6) / EPSILON)) / this.mTransitionDuration;
        } else {
            f6 = f8;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f7 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i4 & 1) == 0) {
            fArr2 = fArr;
            motionController.getPostLayoutDvDp(f6, view.getWidth(), view.getHeight(), f4, f5, fArr2);
        } else {
            fArr2 = fArr;
            motionController.getDpDt(f6, f4, f5, fArr2);
        }
        if (i4 < 2) {
            fArr2[0] = fArr2[0] * f7;
            fArr2[1] = fArr2[1] * f7;
        }
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.mDelayedApply;
    }

    public boolean isInRotation() {
        return this.mInRotation;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public boolean isViewTransitionEnabled(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i4);
        }
        return false;
    }

    public void jumpToState(int i4) {
        if (!isAttachedToWindow()) {
            this.mCurrentState = i4;
        }
        if (this.mBeginState == i4) {
            setProgress(0.0f);
        } else if (this.mEndState == i4) {
            setProgress(1.0f);
        } else {
            setTransition(i4, i4);
        }
    }

    public void loadLayoutDescription(int i4) {
        int i5;
        MotionScene.Transition transition;
        if (i4 != 0) {
            try {
                MotionScene motionScene = new MotionScene(getContext(), this, i4);
                this.mScene = motionScene;
                if (this.mCurrentState == -1) {
                    this.mCurrentState = motionScene.getStartId();
                    this.mBeginState = this.mScene.getStartId();
                    this.mEndState = this.mScene.getEndId();
                }
                if (isAttachedToWindow()) {
                    Display display = getDisplay();
                    int i6 = 0;
                    if (display == null) {
                        i5 = 0;
                    } else {
                        i5 = display.getRotation();
                    }
                    this.mPreviouseRotation = i5;
                    MotionScene motionScene2 = this.mScene;
                    if (motionScene2 != null) {
                        ConstraintSet constraintSet = motionScene2.getConstraintSet(this.mCurrentState);
                        this.mScene.readFallback(this);
                        ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            while (i6 < size) {
                                MotionHelper motionHelper = arrayList.get(i6);
                                i6++;
                                motionHelper.onFinishedMotionScene(this);
                            }
                        }
                        if (constraintSet != null) {
                            constraintSet.applyTo(this);
                        }
                        this.mBeginState = this.mCurrentState;
                    }
                    onNewStateAttachHandlers();
                    StateCache stateCache = this.mStateCache;
                    if (stateCache == null) {
                        MotionScene motionScene3 = this.mScene;
                        if (motionScene3 != null && (transition = motionScene3.mCurrentTransition) != null && transition.getAutoTransition() == 4) {
                            transitionToEnd();
                            setState(TransitionState.SETUP);
                            setState(TransitionState.MOVING);
                        }
                    } else if (this.mDelayedApply) {
                        post(new Runnable() {
                            public void run() {
                                MotionLayout.this.mStateCache.apply();
                            }
                        });
                    } else {
                        stateCache.apply();
                    }
                } else {
                    this.mScene = null;
                }
            } catch (Exception e5) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e5);
            } catch (Exception e6) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e6);
            }
        } else {
            this.mScene = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    /* access modifiers changed from: protected */
    public MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i4;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.mPreviouseRotation = display.getRotation();
        }
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (i4 = this.mCurrentState) == -1)) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i4);
            this.mScene.readFallback(this);
            ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
            if (arrayList != null) {
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    MotionHelper motionHelper = arrayList.get(i5);
                    i5++;
                    motionHelper.onFinishedMotionScene(this);
                }
            }
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        StateCache stateCache = this.mStateCache;
        if (stateCache == null) {
            MotionScene motionScene2 = this.mScene;
            if (motionScene2 != null && (transition = motionScene2.mCurrentTransition) != null && transition.getAutoTransition() == 4) {
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.mDelayedApply) {
            post(new Runnable() {
                public void run() {
                    MotionLayout.this.mStateCache.apply();
                }
            });
        } else {
            stateCache.apply();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int touchRegionId;
        RectF touchRegion;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled) {
            ViewTransitionController viewTransitionController = motionScene.mViewTransitionController;
            if (viewTransitionController != null) {
                viewTransitionController.touchEvent(motionEvent);
            }
            MotionScene.Transition transition = this.mScene.mCurrentTransition;
            if (transition != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (touchRegion = touchResponse.getTouchRegion(this, new RectF())) == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && (touchRegionId = touchResponse.getTouchRegionId()) != -1)) {
                View view = this.mRegionView;
                if (view == null || view.getId() != touchRegionId) {
                    this.mRegionView = findViewById(touchRegionId);
                }
                View view2 = this.mRegionView;
                if (view2 != null) {
                    this.mBoundsCheck.set((float) view2.getLeft(), (float) this.mRegionView.getTop(), (float) this.mRegionView.getRight(), (float) this.mRegionView.getBottom());
                    if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent((float) this.mRegionView.getLeft(), (float) this.mRegionView.getTop(), this.mRegionView, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        MotionLayout motionLayout;
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z4, i4, i5, i6, i7);
                this.mInLayout = false;
                return;
            }
            motionLayout = this;
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            try {
                if (motionLayout.mLastLayoutWidth == i8) {
                    if (motionLayout.mLastLayoutHeight != i9) {
                    }
                    motionLayout.mLastLayoutWidth = i8;
                    motionLayout.mLastLayoutHeight = i9;
                    motionLayout.mOldWidth = i8;
                    motionLayout.mOldHeight = i9;
                    motionLayout.mInLayout = false;
                }
                rebuildScene();
                evaluate(true);
                motionLayout.mLastLayoutWidth = i8;
                motionLayout.mLastLayoutHeight = i9;
                motionLayout.mOldWidth = i8;
                motionLayout.mOldHeight = i9;
                motionLayout.mInLayout = false;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                motionLayout.mInLayout = false;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            motionLayout = this;
            Throwable th22 = th;
            motionLayout.mInLayout = false;
            throw th22;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        boolean z4;
        if (this.mScene == null) {
            super.onMeasure(i4, i5);
            return;
        }
        boolean z5 = false;
        if (this.mLastWidthMeasureSpec == i4 && this.mLastHeightMeasureSpec == i5) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z4 = true;
        }
        if (this.mDirtyHierarchy) {
            z4 = true;
        }
        this.mLastWidthMeasureSpec = i4;
        this.mLastHeightMeasureSpec = i5;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z4 || this.mModel.isNotConfiguredWith(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i4, i5);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(startId, endId);
        } else {
            if (z4) {
                super.onMeasure(i4, i5);
            }
            z5 = true;
        }
        if (this.mMeasureDuringTransition || z5) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i6 = this.mWidthMeasureMode;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                int i7 = this.mStartWrapWidth;
                width = (int) (((float) i7) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapWidth - i7))));
                requestLayout();
            }
            int i8 = this.mHeightMeasureMode;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                int i9 = this.mStartWrapHeight;
                height = (int) (((float) i9) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapHeight - i9))));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    public boolean onNestedFling(@NonNull View view, float f4, float f5, boolean z4) {
        return false;
    }

    public boolean onNestedPreFling(@NonNull View view, float f4, float f5) {
        return false;
    }

    public void onNestedPreScroll(@NonNull final View view, int i4, int i5, @NonNull int[] iArr, int i6) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int touchRegionId;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled()) {
            int i7 = -1;
            if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (touchRegionId = touchResponse.getTouchRegionId()) == -1 || view.getId() == touchRegionId) {
                if (motionScene.getMoveWhenScrollAtTop()) {
                    TouchResponse touchResponse2 = transition.getTouchResponse();
                    if (!(touchResponse2 == null || (touchResponse2.getFlags() & 4) == 0)) {
                        i7 = i5;
                    }
                    float f4 = this.mTransitionPosition;
                    if ((f4 == 1.0f || f4 == 0.0f) && view.canScrollVertically(i7)) {
                        return;
                    }
                }
                if (!(transition.getTouchResponse() == null || (transition.getTouchResponse().getFlags() & 1) == 0)) {
                    float progressDirection = motionScene.getProgressDirection((float) i4, (float) i5);
                    float f5 = this.mTransitionLastPosition;
                    if ((f5 <= 0.0f && progressDirection < 0.0f) || (f5 >= 1.0f && progressDirection > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() {
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                }
                float f6 = this.mTransitionPosition;
                long nanoTime = getNanoTime();
                float f7 = (float) i4;
                this.mScrollTargetDX = f7;
                float f8 = (float) i5;
                this.mScrollTargetDY = f8;
                this.mScrollTargetDT = (float) (((double) (nanoTime - this.mScrollTargetTime)) * 1.0E-9d);
                this.mScrollTargetTime = nanoTime;
                motionScene.processScrollMove(f7, f8);
                if (f6 != this.mTransitionPosition) {
                    iArr[0] = i4;
                    iArr[1] = i5;
                }
                evaluate(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mUndergoingMotion = true;
                }
            }
        }
    }

    public void onNestedScroll(@NonNull View view, int i4, int i5, int i6, int i7, int i8) {
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i4, int i5) {
        this.mScrollTargetTime = getNanoTime();
        this.mScrollTargetDT = 0.0f;
        this.mScrollTargetDX = 0.0f;
        this.mScrollTargetDY = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            if (motionScene.autoTransition(this, this.mCurrentState)) {
                requestLayout();
                return;
            }
            int i4 = this.mCurrentState;
            if (i4 != -1) {
                this.mScene.addOnClickListeners(this, i4);
            }
            if (this.mScene.supportTouch()) {
                this.mScene.setupTouch();
            }
        }
    }

    public void onRtlPropertiesChanged(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i4, int i5) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(@NonNull View view, int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f4 = this.mScrollTargetDT;
            if (f4 != 0.0f) {
                motionScene.processScrollUp(this.mScrollTargetDX / f4, this.mScrollTargetDY / f4);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        if (this.mScene.mCurrentTransition.isTransitionFlag(4)) {
            return this.mScene.mCurrentTransition.getTouchResponse().isDragStarted();
        }
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new CopyOnWriteArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.mDecoratorsHelpers == null) {
                    this.mDecoratorsHelpers = new ArrayList<>();
                }
                this.mDecoratorsHelpers.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i4) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.mTransitionListeners;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && (transition = motionScene.mCurrentTransition) != null) {
            int layoutDuringTransition = transition.getLayoutDuringTransition();
            if (layoutDuringTransition != 0) {
                if (layoutDuringTransition == 2) {
                    int childCount = getChildCount();
                    for (int i4 = 0; i4 < childCount; i4++) {
                        this.mFrameArrayList.get(getChildAt(i4)).remeasure();
                    }
                    return;
                }
            } else {
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i4, int i5) {
        int i6 = 1;
        this.mInRotation = true;
        this.mPreRotateWidth = getWidth();
        this.mPreRotateHeight = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.mPreviouseRotation + 1) % 4) {
            i6 = 2;
        }
        this.mRotatMode = i6;
        this.mPreviouseRotation = rotation;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewState viewState = this.mPreRotate.get(childAt);
            if (viewState == null) {
                viewState = new ViewState();
                this.mPreRotate.put(childAt, viewState);
            }
            viewState.getState(childAt);
        }
        this.mBeginState = -1;
        this.mEndState = i4;
        this.mScene.setTransition(-1, i4);
        this.mModel.initFrom(this.mLayoutWidget, (ConstraintSet) null, this.mScene.getConstraintSet(this.mEndState));
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() {
            public void run() {
                boolean unused = MotionLayout.this.mInRotation = false;
            }
        });
        if (i5 > 0) {
            this.mTransitionDuration = ((float) i5) / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i4) {
        if (getCurrentState() == -1) {
            transitionToState(i4);
            return;
        }
        int[] iArr = this.mScheduledTransitionTo;
        if (iArr == null) {
            this.mScheduledTransitionTo = new int[4];
        } else if (iArr.length <= this.mScheduledTransitions) {
            this.mScheduledTransitionTo = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mScheduledTransitionTo;
        int i5 = this.mScheduledTransitions;
        this.mScheduledTransitions = i5 + 1;
        iArr2[i5] = i4;
    }

    public void setDebugMode(int i4) {
        this.mDebugPath = i4;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z4) {
        this.mDelayedApply = z4;
    }

    public void setInteractionEnabled(boolean z4) {
        this.mInteractionEnabled = z4;
    }

    public void setInterpolatedProgress(float f4) {
        if (this.mScene != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f4));
                return;
            }
        }
        setProgress(f4);
    }

    public void setOnHide(float f4) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mOnHideHelpers.get(i4).setProgress(f4);
            }
        }
    }

    public void setOnShow(float f4) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mOnShowHelpers.get(i4).setProgress(f4);
            }
        }
    }

    public void setProgress(float f4, float f5) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f4);
            this.mStateCache.setVelocity(f5);
            return;
        }
        setProgress(f4);
        setState(TransitionState.MOVING);
        this.mLastVelocity = f5;
        float f6 = 1.0f;
        int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i4 != 0) {
            if (i4 <= 0) {
                f6 = 0.0f;
            }
            animateTo(f6);
        } else if (f4 != 0.0f && f4 != 1.0f) {
            if (f4 <= 0.5f) {
                f6 = 0.0f;
            }
            animateTo(f6);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    /* access modifiers changed from: package-private */
    public void setStartState(int i4) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i4);
            this.mStateCache.setEndState(i4);
            return;
        }
        this.mCurrentState = i4;
    }

    /* access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.mCurrentState != -1) {
            TransitionState transitionState3 = this.mTransitionState;
            this.mTransitionState = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                fireTransitionChange();
            }
            int ordinal = transitionState3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (transitionState == transitionState4) {
                    fireTransitionChange();
                }
                if (transitionState == transitionState2) {
                    fireTransitionCompleted();
                }
            } else if (ordinal == 2 && transitionState == transitionState2) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i4, int i5) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setStartState(i4);
            this.mStateCache.setEndState(i5);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i4;
            this.mEndState = i5;
            motionScene.setTransition(i4, i5);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(i4), this.mScene.getConstraintSet(i5));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i4) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            motionScene.setDuration(i4);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache();
        }
        this.mStateCache.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r10 != 7) goto L_0x00f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            r9 = this;
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            if (r0 != 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            float r0 = r9.mTransitionLastPosition
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x000c
        L_0x000b:
            return
        L_0x000c:
            r0 = 1
            r9.mTemporalInterpolator = r0
            long r1 = r9.getNanoTime()
            r9.mAnimationStartTime = r1
            androidx.constraintlayout.motion.widget.MotionScene r1 = r9.mScene
            int r1 = r1.getDuration()
            float r1 = (float) r1
            r2 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 / r2
            r9.mTransitionDuration = r1
            r9.mTransitionGoalPosition = r11
            r9.mInTransition = r0
            r1 = 0
            r2 = 7
            r3 = 6
            r4 = 2
            if (r10 == 0) goto L_0x003b
            if (r10 == r0) goto L_0x003b
            if (r10 == r4) goto L_0x003b
            r5 = 4
            if (r10 == r5) goto L_0x0083
            r5 = 5
            if (r10 == r5) goto L_0x003d
            if (r10 == r3) goto L_0x003b
            if (r10 == r2) goto L_0x003b
            goto L_0x00f8
        L_0x003b:
            r5 = r12
            goto L_0x0096
        L_0x003d:
            float r10 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            float r0 = r0.getMaxAcceleration()
            boolean r10 = willJump(r12, r10, r0)
            if (r10 == 0) goto L_0x005e
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r0 = r9.mScene
            float r0 = r0.getMaxAcceleration()
            r10.config(r12, r11, r0)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.mInterpolator = r10
            goto L_0x00f8
        L_0x005e:
            androidx.constraintlayout.motion.utils.StopLogic r2 = r9.mStopLogic
            float r3 = r9.mTransitionLastPosition
            float r6 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r7 = r10.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r8 = r10.getMaxVelocity()
            r4 = r11
            r5 = r12
            r2.config(r3, r4, r5, r6, r7, r8)
            r9.mLastVelocity = r1
            int r10 = r9.mCurrentState
            r9.mTransitionGoalPosition = r11
            r9.mCurrentState = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.mInterpolator = r10
            goto L_0x00f8
        L_0x0083:
            r5 = r12
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            float r11 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r12 = r9.mScene
            float r12 = r12.getMaxAcceleration()
            r10.config(r5, r11, r12)
            androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator r10 = r9.mDecelerateLogic
            r9.mInterpolator = r10
            goto L_0x00f8
        L_0x0096:
            if (r10 == r0) goto L_0x00a7
            if (r10 != r2) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            if (r10 == r4) goto L_0x00a2
            if (r10 != r3) goto L_0x00a0
            goto L_0x00a2
        L_0x00a0:
            r2 = r11
            goto L_0x00a8
        L_0x00a2:
            r11 = 1065353216(0x3f800000, float:1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            int r10 = r10.getAutoCompleteMode()
            if (r10 != 0) goto L_0x00c8
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.mTransitionLastPosition
            float r4 = r9.mTransitionDuration
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r10 = r10.getMaxAcceleration()
            androidx.constraintlayout.motion.widget.MotionScene r11 = r9.mScene
            float r6 = r11.getMaxVelocity()
            r3 = r5
            r5 = r10
            r0.config(r1, r2, r3, r4, r5, r6)
            goto L_0x00ee
        L_0x00c8:
            r3 = r5
            androidx.constraintlayout.motion.utils.StopLogic r0 = r9.mStopLogic
            float r1 = r9.mTransitionLastPosition
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r4 = r10.getSpringMass()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r5 = r10.getSpringStiffiness()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r6 = r10.getSpringDamping()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            float r7 = r10.getSpringStopThreshold()
            androidx.constraintlayout.motion.widget.MotionScene r10 = r9.mScene
            int r8 = r10.getSpringBoundary()
            r0.springConfig(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x00ee:
            int r10 = r9.mCurrentState
            r9.mTransitionGoalPosition = r2
            r9.mCurrentState = r10
            androidx.constraintlayout.motion.utils.StopLogic r10 = r9.mStopLogic
            r9.mInterpolator = r10
        L_0x00f8:
            r10 = 0
            r9.mTransitionInstantly = r10
            long r10 = r9.getNanoTime()
            r9.mAnimationStartTime = r10
            r9.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f4, float f5) {
        if (this.mScene != null && this.mTransitionLastPosition != f4) {
            this.mTemporalInterpolator = true;
            this.mAnimationStartTime = getNanoTime();
            this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
            this.mTransitionGoalPosition = f4;
            this.mInTransition = true;
            float f6 = f4;
            this.mStopLogic.springConfig(this.mTransitionLastPosition, f6, f5, this.mScene.getSpringMass(), this.mScene.getSpringStiffiness(), this.mScene.getSpringDamping(), this.mScene.getSpringStopThreshold(), this.mScene.getSpringBoundary());
            int i4 = this.mCurrentState;
            this.mTransitionGoalPosition = f6;
            this.mCurrentState = i4;
            this.mInterpolator = this.mStopLogic;
            this.mTransitionInstantly = false;
            this.mAnimationStartTime = getNanoTime();
            invalidate();
        }
    }

    public void transitionToEnd() {
        animateTo(1.0f);
        this.mOnComplete = null;
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i4) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i4);
            return;
        }
        transitionToState(i4, -1, -1);
    }

    public void updateState(int i4, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i4, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i4) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i4, ConstraintSet constraintSet, int i5) {
        if (this.mScene != null && this.mCurrentState == i4) {
            int i6 = R.id.view_transition;
            updateState(i6, getConstraintSet(i4));
            setState(i6, -1, -1);
            updateState(i4, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.mScene, i6, i4);
            transition.setDuration(i5);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i4, View... viewArr) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.viewTransition(i4, viewArr);
        } else {
            Log.e(TAG, " no motionScene");
        }
    }

    private static class MyTracker implements MotionTracker {
        private static MyTracker sMe = new MyTracker();
        VelocityTracker mTracker;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            sMe.mTracker = VelocityTracker.obtain();
            return sMe;
        }

        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public void clear() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        public void computeCurrentVelocity(int i4) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i4);
            }
        }

        public float getXVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float getYVelocity() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        public void recycle() {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mTracker = null;
            }
        }

        public void computeCurrentVelocity(int i4, float f4) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i4, f4);
            }
        }

        public float getXVelocity(int i4) {
            VelocityTracker velocityTracker = this.mTracker;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i4);
            }
            return 0.0f;
        }

        public float getYVelocity(int i4) {
            if (this.mTracker != null) {
                return getYVelocity(i4);
            }
            return 0.0f;
        }
    }

    public void onNestedScroll(@NonNull View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        if (!(!this.mUndergoingMotion && i4 == 0 && i5 == 0)) {
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i7;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToStart(Runnable runnable) {
        animateTo(0.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToEnd(Runnable runnable) {
        animateTo(1.0f);
        this.mOnComplete = runnable;
    }

    public void transitionToState(int i4, int i5) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setEndState(i4);
            return;
        }
        transitionToState(i4, -1, -1, i5);
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setState(int i4, int i5, int i6) {
        setState(TransitionState.SETUP);
        this.mCurrentState = i4;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i4, (float) i5, (float) i6);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i4).applyTo(this);
        }
    }

    public void setProgress(float f4) {
        int i4 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        if (i4 < 0 || f4 > 1.0f) {
            Log.w(TAG, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache();
            }
            this.mStateCache.setProgress(f4);
            return;
        }
        if (i4 <= 0) {
            if (this.mTransitionLastPosition == 1.0f && this.mCurrentState == this.mEndState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f4 >= 1.0f) {
            if (this.mTransitionLastPosition == 0.0f && this.mCurrentState == this.mBeginState) {
                setState(TransitionState.MOVING);
            }
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(TransitionState.MOVING);
        }
        if (this.mScene != null) {
            this.mTransitionInstantly = true;
            this.mTransitionGoalPosition = f4;
            this.mTransitionPosition = f4;
            this.mTransitionLastTime = -1;
            this.mAnimationStartTime = -1;
            this.mInterpolator = null;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void transitionToState(int i4, int i5, int i6) {
        transitionToState(i4, i5, i6, -1);
    }

    public void transitionToState(int i4, int i5, int i6, int i7) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (stateSet = motionScene.mStateSet) == null || (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i4, (float) i5, (float) i6)) == -1)) {
            i4 = convertToConstraintSet;
        }
        int i8 = this.mCurrentState;
        if (i8 != i4) {
            if (this.mBeginState == i4) {
                animateTo(0.0f);
                if (i7 > 0) {
                    this.mTransitionDuration = ((float) i7) / 1000.0f;
                }
            } else if (this.mEndState == i4) {
                animateTo(1.0f);
                if (i7 > 0) {
                    this.mTransitionDuration = ((float) i7) / 1000.0f;
                }
            } else {
                this.mEndState = i4;
                if (i8 != -1) {
                    setTransition(i8, i4);
                    animateTo(1.0f);
                    this.mTransitionLastPosition = 0.0f;
                    transitionToEnd();
                    if (i7 > 0) {
                        this.mTransitionDuration = ((float) i7) / 1000.0f;
                        return;
                    }
                    return;
                }
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = 1.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.mInterpolator = null;
                if (i7 == -1) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                }
                this.mBeginState = -1;
                this.mScene.setTransition(-1, this.mEndState);
                SparseArray sparseArray = new SparseArray();
                if (i7 == 0) {
                    this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                } else if (i7 > 0) {
                    this.mTransitionDuration = ((float) i7) / 1000.0f;
                }
                int childCount = getChildCount();
                this.mFrameArrayList.clear();
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt = getChildAt(i9);
                    this.mFrameArrayList.put(childAt, new MotionController(childAt));
                    sparseArray.put(childAt.getId(), this.mFrameArrayList.get(childAt));
                }
                this.mInTransition = true;
                this.mModel.initFrom(this.mLayoutWidget, (ConstraintSet) null, this.mScene.getConstraintSet(i4));
                rebuildScene();
                this.mModel.build();
                computeCurrentPositions();
                int width = getWidth();
                int height = getHeight();
                if (this.mDecoratorsHelpers != null) {
                    for (int i10 = 0; i10 < childCount; i10++) {
                        MotionController motionController = this.mFrameArrayList.get(getChildAt(i10));
                        if (motionController != null) {
                            this.mScene.getKeyFrames(motionController);
                        }
                    }
                    ArrayList<MotionHelper> arrayList = this.mDecoratorsHelpers;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        MotionHelper motionHelper = arrayList.get(i11);
                        i11++;
                        motionHelper.onPreSetup(this, this.mFrameArrayList);
                    }
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i12));
                        if (motionController2 != null) {
                            motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                } else {
                    for (int i13 = 0; i13 < childCount; i13++) {
                        MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i13));
                        if (motionController3 != null) {
                            this.mScene.getKeyFrames(motionController3);
                            motionController3.setup(width, height, this.mTransitionDuration, getNanoTime());
                        }
                    }
                }
                float staggered = this.mScene.getStaggered();
                if (staggered != 0.0f) {
                    float f4 = Float.MAX_VALUE;
                    float f5 = -3.4028235E38f;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i14));
                        float finalY = motionController4.getFinalY() + motionController4.getFinalX();
                        f4 = Math.min(f4, finalY);
                        f5 = Math.max(f5, finalY);
                    }
                    for (int i15 = 0; i15 < childCount; i15++) {
                        MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i15));
                        float finalX = motionController5.getFinalX();
                        float finalY2 = motionController5.getFinalY();
                        motionController5.mStaggerScale = 1.0f / (1.0f - staggered);
                        motionController5.mStaggerOffset = staggered - ((((finalX + finalY2) - f4) * staggered) / (f5 - f4));
                    }
                }
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mInTransition = true;
                invalidate();
            }
        }
    }

    public void setTransition(int i4) {
        float f4;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i4);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new StateCache();
                }
                this.mStateCache.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            int i5 = this.mCurrentState;
            float f5 = 0.0f;
            if (i5 == this.mBeginState) {
                f4 = 0.0f;
            } else {
                f4 = i5 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (this.mTransitionLastPosition != f4) {
                if (f4 == 0.0f) {
                    endTrigger(true);
                    this.mScene.getConstraintSet(this.mBeginState).applyTo(this);
                } else if (f4 == 1.0f) {
                    endTrigger(false);
                    this.mScene.getConstraintSet(this.mEndState).applyTo(this);
                }
            }
            if (!Float.isNaN(f4)) {
                f5 = f4;
            }
            this.mTransitionLastPosition = f5;
            if (Float.isNaN(f4)) {
                Log.v(TAG, Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f4);
        }
    }

    private void checkStructure(int i4, ConstraintSet constraintSet) {
        String name = Debug.getName(getContext(), i4);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(TAG, "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id) == null) {
                Log.w(TAG, "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i6 = 0; i6 < knownIds.length; i6++) {
            int i7 = knownIds[i6];
            String name2 = Debug.getName(getContext(), i7);
            if (findViewById(knownIds[i6]) == null) {
                Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i7) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i7) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1 : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId != this.mBeginState || endId != this.mEndState) {
            this.mBeginState = startId;
            this.mEndState = endId;
            this.mScene.setTransition(startId, endId);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
            this.mModel.reEvaluateState();
            rebuildScene();
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(attributeSet);
    }
}
