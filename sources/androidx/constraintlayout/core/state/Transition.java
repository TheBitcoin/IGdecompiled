package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Transition implements TypedValues {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    public static final int START = 0;
    private int mAutoTransition = 0;
    private TypedBundle mBundle = new TypedBundle();
    private int mDefaultInterpolator = 0;
    private String mDefaultInterpolatorString = null;
    private int mDuration = 400;
    private Easing mEasing = null;
    private HashMap<Integer, HashMap<String, KeyPosition>> mKeyPositions = new HashMap<>();
    private OnSwipe mOnSwipe = null;
    int mParentEndHeight;
    int mParentEndWidth;
    int mParentInterpolateHeight;
    int mParentInterpolatedWidth;
    int mParentStartHeight;
    int mParentStartWidth;
    private float mStagger = 0.0f;
    private HashMap<String, WidgetState> mState = new HashMap<>();
    final CorePixelDp mToPixel;
    boolean mWrap;

    static class KeyPosition {
        int mFrame;
        String mTarget;
        int mType;
        float mX;
        float mY;

        KeyPosition(String str, int i4, int i5, float f4, float f5) {
            this.mTarget = str;
            this.mFrame = i4;
            this.mType = i5;
            this.mX = f4;
            this.mY = f5;
        }
    }

    static class OnSwipe {
        public static final int ANCHOR_SIDE_BOTTOM = 3;
        public static final int ANCHOR_SIDE_END = 6;
        public static final int ANCHOR_SIDE_LEFT = 1;
        public static final int ANCHOR_SIDE_MIDDLE = 4;
        public static final int ANCHOR_SIDE_RIGHT = 2;
        public static final int ANCHOR_SIDE_START = 5;
        public static final int ANCHOR_SIDE_TOP = 0;
        public static final String[] BOUNDARY = {"overshoot", "bounceStart", "bounceEnd", "bounceBoth"};
        public static final int BOUNDARY_BOUNCE_BOTH = 3;
        public static final int BOUNDARY_BOUNCE_END = 2;
        public static final int BOUNDARY_BOUNCE_START = 1;
        public static final int BOUNDARY_OVERSHOOT = 0;
        public static final String[] DIRECTIONS = {"up", "down", TtmlNode.LEFT, TtmlNode.RIGHT, "start", TtmlNode.END, "clockwise", "anticlockwise"};
        public static final int DRAG_ANTICLOCKWISE = 7;
        public static final int DRAG_CLOCKWISE = 6;
        public static final int DRAG_DOWN = 1;
        public static final int DRAG_END = 5;
        public static final int DRAG_LEFT = 2;
        public static final int DRAG_RIGHT = 3;
        public static final int DRAG_START = 4;
        public static final int DRAG_UP = 0;
        public static final String[] MODE = {"velocity", "spring"};
        public static final int MODE_CONTINUOUS_VELOCITY = 0;
        public static final int MODE_SPRING = 1;
        public static final int ON_UP_AUTOCOMPLETE = 0;
        public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
        public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
        public static final int ON_UP_DECELERATE = 4;
        public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
        public static final int ON_UP_NEVER_COMPLETE_TO_END = 7;
        public static final int ON_UP_NEVER_COMPLETE_TO_START = 6;
        public static final int ON_UP_STOP = 3;
        public static final String[] SIDES = {"top", TtmlNode.LEFT, TtmlNode.RIGHT, "bottom", "middle", "start", TtmlNode.END};
        private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
        private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
        public static final String[] TOUCH_UP = {"autocomplete", "toStart", "toEnd", "stop", "decelerate", "decelerateComplete", "neverCompleteStart", "neverCompleteEnd"};
        String mAnchorId;
        private int mAnchorSide;
        private int mAutoCompleteMode = 0;
        private float mDestination = 0.0f;
        private int mDragDirection = 0;
        private float mDragScale = 1.0f;
        private float mDragThreshold = 10.0f;
        private boolean mDragVertical = true;
        private StopEngine mEngine;
        String mLimitBoundsTo;
        private float mMaxAcceleration = 1.2f;
        private float mMaxVelocity = 4.0f;
        private int mOnTouchUp = 0;
        private String mRotationCenterId;
        private int mSpringBoundary = 0;
        private float mSpringDamping = 10.0f;
        private float mSpringMass = 1.0f;
        private float mSpringStiffness = 400.0f;
        private float mSpringStopThreshold = 0.01f;
        private long mStart;

        OnSwipe() {
        }

        /* access modifiers changed from: package-private */
        public void config(float f4, float f5, long j4, float f6) {
            SpringStopEngine springStopEngine;
            StopLogicEngine stopLogicEngine;
            StopLogicEngine.Decelerate decelerate;
            this.mStart = j4;
            float abs = Math.abs(f5);
            float f7 = this.mMaxVelocity;
            if (abs > f7) {
                f5 = Math.signum(f5) * f7;
            }
            float f8 = f5;
            float destinationPosition = getDestinationPosition(f4, f8, f6);
            this.mDestination = destinationPosition;
            if (destinationPosition == f4) {
                this.mEngine = null;
            } else if (this.mOnTouchUp == 4 && this.mAutoCompleteMode == 0) {
                StopEngine stopEngine = this.mEngine;
                if (stopEngine instanceof StopLogicEngine.Decelerate) {
                    decelerate = (StopLogicEngine.Decelerate) stopEngine;
                } else {
                    decelerate = new StopLogicEngine.Decelerate();
                    this.mEngine = decelerate;
                }
                decelerate.config(f4, this.mDestination, f8);
            } else if (this.mAutoCompleteMode == 0) {
                StopEngine stopEngine2 = this.mEngine;
                if (stopEngine2 instanceof StopLogicEngine) {
                    stopLogicEngine = (StopLogicEngine) stopEngine2;
                } else {
                    stopLogicEngine = new StopLogicEngine();
                    this.mEngine = stopLogicEngine;
                }
                stopLogicEngine.config(f4, this.mDestination, f8, f6, this.mMaxAcceleration, this.mMaxVelocity);
            } else {
                float f9 = f4;
                StopEngine stopEngine3 = this.mEngine;
                if (stopEngine3 instanceof SpringStopEngine) {
                    springStopEngine = (SpringStopEngine) stopEngine3;
                } else {
                    springStopEngine = new SpringStopEngine();
                    this.mEngine = springStopEngine;
                }
                springStopEngine.springConfig(f9, this.mDestination, f8, this.mSpringMass, this.mSpringStiffness, this.mSpringDamping, this.mSpringStopThreshold, this.mSpringBoundary);
            }
        }

        /* access modifiers changed from: package-private */
        public float getDestinationPosition(float f4, float f5, float f6) {
            float abs = (((Math.abs(f5) * 0.5f) * f5) / this.mMaxAcceleration) + f4;
            switch (this.mOnTouchUp) {
                case 1:
                    if (f4 >= 1.0f) {
                        return 1.0f;
                    }
                    return 0.0f;
                case 2:
                    if (f4 <= 0.0f) {
                        return 0.0f;
                    }
                    return 1.0f;
                case 3:
                    return Float.NaN;
                case 4:
                    return Math.max(0.0f, Math.min(1.0f, abs));
                case 5:
                    if (abs > 0.2f && abs < 0.8f) {
                        return abs;
                    }
                    if (abs > 0.5f) {
                        return 1.0f;
                    }
                    return 0.0f;
                case 6:
                    return 1.0f;
                case 7:
                    break;
                default:
                    if (((double) abs) > 0.5d) {
                        return 1.0f;
                    }
                    break;
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        public float[] getDirection() {
            return TOUCH_DIRECTION[this.mDragDirection];
        }

        /* access modifiers changed from: package-private */
        public float getScale() {
            return this.mDragScale;
        }

        /* access modifiers changed from: package-private */
        public float[] getSide() {
            return TOUCH_SIDES[this.mAnchorSide];
        }

        public float getTouchUpProgress(long j4) {
            float interpolation = this.mEngine.getInterpolation(((float) (j4 - this.mStart)) * 1.0E-9f);
            if (this.mEngine.isStopped()) {
                return this.mDestination;
            }
            return interpolation;
        }

        public boolean isNotDone(float f4) {
            StopEngine stopEngine;
            if (this.mOnTouchUp == 3 || (stopEngine = this.mEngine) == null || stopEngine.isStopped()) {
                return false;
            }
            return true;
        }

        public void printInfo() {
            if (this.mAutoCompleteMode == 0) {
                PrintStream printStream = System.out;
                printStream.println("velocity = " + this.mEngine.getVelocity());
                PrintStream printStream2 = System.out;
                printStream2.println("mMaxAcceleration = " + this.mMaxAcceleration);
                PrintStream printStream3 = System.out;
                printStream3.println("mMaxVelocity = " + this.mMaxVelocity);
                return;
            }
            PrintStream printStream4 = System.out;
            printStream4.println("mSpringMass          = " + this.mSpringMass);
            PrintStream printStream5 = System.out;
            printStream5.println("mSpringStiffness     = " + this.mSpringStiffness);
            PrintStream printStream6 = System.out;
            printStream6.println("mSpringDamping       = " + this.mSpringDamping);
            PrintStream printStream7 = System.out;
            printStream7.println("mSpringStopThreshold = " + this.mSpringStopThreshold);
            PrintStream printStream8 = System.out;
            printStream8.println("mSpringBoundary      = " + this.mSpringBoundary);
        }

        /* access modifiers changed from: package-private */
        public void setAnchorId(String str) {
            this.mAnchorId = str;
        }

        /* access modifiers changed from: package-private */
        public void setAnchorSide(int i4) {
            this.mAnchorSide = i4;
        }

        /* access modifiers changed from: package-private */
        public void setAutoCompleteMode(int i4) {
            this.mAutoCompleteMode = i4;
        }

        /* access modifiers changed from: package-private */
        public void setDragDirection(int i4) {
            boolean z4;
            this.mDragDirection = i4;
            if (i4 < 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mDragVertical = z4;
        }

        /* access modifiers changed from: package-private */
        public void setDragScale(float f4) {
            if (!Float.isNaN(f4)) {
                this.mDragScale = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setDragThreshold(float f4) {
            if (!Float.isNaN(f4)) {
                this.mDragThreshold = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setLimitBoundsTo(String str) {
            this.mLimitBoundsTo = str;
        }

        /* access modifiers changed from: package-private */
        public void setMaxAcceleration(float f4) {
            if (!Float.isNaN(f4)) {
                this.mMaxAcceleration = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setMaxVelocity(float f4) {
            if (!Float.isNaN(f4)) {
                this.mMaxVelocity = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnTouchUp(int i4) {
            this.mOnTouchUp = i4;
        }

        /* access modifiers changed from: package-private */
        public void setRotationCenterId(String str) {
            this.mRotationCenterId = str;
        }

        /* access modifiers changed from: package-private */
        public void setSpringBoundary(int i4) {
            this.mSpringBoundary = i4;
        }

        /* access modifiers changed from: package-private */
        public void setSpringDamping(float f4) {
            if (!Float.isNaN(f4)) {
                this.mSpringDamping = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSpringMass(float f4) {
            if (!Float.isNaN(f4)) {
                this.mSpringMass = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSpringStiffness(float f4) {
            if (!Float.isNaN(f4)) {
                this.mSpringStiffness = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setSpringStopThreshold(float f4) {
            if (!Float.isNaN(f4)) {
                this.mSpringStopThreshold = f4;
            }
        }
    }

    public Transition(@NonNull CorePixelDp corePixelDp) {
        this.mToPixel = corePixelDp;
    }

    public static /* synthetic */ float a(float f4) {
        return (float) Easing.getInterpolator("standard").get((double) f4);
    }

    public static /* synthetic */ float b(float f4) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get((double) f4);
    }

    public static /* synthetic */ float c(float f4) {
        return (float) Easing.getInterpolator("anticipate").get((double) f4);
    }

    private void calculateParentDimensions(float f4) {
        int i4 = this.mParentStartWidth;
        this.mParentInterpolatedWidth = (int) (((float) i4) + 0.5f + (((float) (this.mParentEndWidth - i4)) * f4));
        int i5 = this.mParentStartHeight;
        this.mParentInterpolateHeight = (int) (((float) i5) + 0.5f + (((float) (this.mParentEndHeight - i5)) * f4));
    }

    public static /* synthetic */ float d(String str, float f4) {
        return (float) Easing.getInterpolator(str).get((double) f4);
    }

    public static /* synthetic */ float e(float f4) {
        return (float) Easing.getInterpolator("linear").get((double) f4);
    }

    public static /* synthetic */ float f(float f4) {
        return (float) Easing.getInterpolator("decelerate").get((double) f4);
    }

    public static /* synthetic */ float g(float f4) {
        return (float) Easing.getInterpolator("overshoot").get((double) f4);
    }

    public static Interpolator getInterpolator(int i4, String str) {
        switch (i4) {
            case -1:
                return new a(str);
            case 0:
                return new b();
            case 1:
                return new c();
            case 2:
                return new d();
            case 3:
                return new e();
            case 4:
                return new h();
            case 5:
                return new g();
            case 6:
                return new f();
            default:
                return null;
        }
    }

    private WidgetState getWidgetState(String str) {
        return this.mState.get(str);
    }

    public static /* synthetic */ float h(float f4) {
        return (float) Easing.getInterpolator("accelerate").get((double) f4);
    }

    public void addCustomColor(int i4, String str, String str2, int i5) {
        getWidgetState(str, (ConstraintWidget) null, i4).getFrame(i4).addCustomColor(str2, i5);
    }

    public void addCustomFloat(int i4, String str, String str2, float f4) {
        getWidgetState(str, (ConstraintWidget) null, i4).getFrame(i4).addCustomFloat(str2, f4);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
    }

    public void calcStagger() {
        boolean z4;
        float f4;
        float f5;
        float f6 = this.mStagger;
        if (f6 != 0.0f) {
            if (((double) f6) < 0.0d) {
                z4 = true;
            } else {
                z4 = false;
            }
            float abs = Math.abs(f6);
            Iterator<String> it = this.mState.keySet().iterator();
            do {
                f4 = Float.MAX_VALUE;
                f5 = -3.4028235E38f;
                if (it.hasNext()) {
                } else {
                    for (String str : this.mState.keySet()) {
                        Motion motion = this.mState.get(str).mMotionControl;
                        float finalX = motion.getFinalX() + motion.getFinalY();
                        f4 = Math.min(f4, finalX);
                        f5 = Math.max(f5, finalX);
                    }
                    for (String str2 : this.mState.keySet()) {
                        Motion motion2 = this.mState.get(str2).mMotionControl;
                        float finalX2 = motion2.getFinalX() + motion2.getFinalY();
                        float f7 = f5 - f4;
                        float f8 = abs - (((finalX2 - f4) * abs) / f7);
                        if (z4) {
                            f8 = abs - (((f5 - finalX2) / f7) * abs);
                        }
                        motion2.setStaggerScale(1.0f / (1.0f - abs));
                        motion2.setStaggerOffset(f8);
                    }
                    return;
                }
            } while (Float.isNaN(this.mState.get(it.next()).mMotionControl.getMotionStagger()));
            for (String str3 : this.mState.keySet()) {
                float motionStagger = this.mState.get(str3).mMotionControl.getMotionStagger();
                if (!Float.isNaN(motionStagger)) {
                    f4 = Math.min(f4, motionStagger);
                    f5 = Math.max(f5, motionStagger);
                }
            }
            for (String str4 : this.mState.keySet()) {
                Motion motion3 = this.mState.get(str4).mMotionControl;
                float motionStagger2 = motion3.getMotionStagger();
                if (!Float.isNaN(motionStagger2)) {
                    float f9 = 1.0f / (1.0f - abs);
                    float f10 = f5 - f4;
                    float f11 = abs - (((motionStagger2 - f4) * abs) / f10);
                    if (z4) {
                        f11 = abs - (((f5 - motionStagger2) / f10) * abs);
                    }
                    motion3.setStaggerScale(f9);
                    motion3.setStaggerOffset(f11);
                }
            }
        }
    }

    public void clear() {
        this.mState.clear();
    }

    public boolean contains(String str) {
        return this.mState.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public OnSwipe createOnSwipe() {
        OnSwipe onSwipe = new OnSwipe();
        this.mOnSwipe = onSwipe;
        return onSwipe;
    }

    public float dragToProgress(float f4, int i4, int i5, float f5, float f6) {
        WidgetState widgetState;
        float f7;
        float scale;
        float abs;
        Iterator<WidgetState> it = this.mState.values().iterator();
        if (it.hasNext()) {
            widgetState = it.next();
        } else {
            widgetState = null;
        }
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null && widgetState != null) {
            String str = onSwipe.mAnchorId;
            if (str == null) {
                float[] direction = onSwipe.getDirection();
                int i6 = widgetState.mParentHeight;
                float f8 = (float) i6;
                float f9 = (float) i6;
                float f10 = direction[0];
                if (f10 != 0.0f) {
                    f7 = (f5 * Math.abs(f10)) / f8;
                } else {
                    f7 = (f6 * Math.abs(direction[1])) / f9;
                }
                scale = this.mOnSwipe.getScale();
            } else {
                WidgetState widgetState2 = this.mState.get(str);
                float[] direction2 = this.mOnSwipe.getDirection();
                float[] side = this.mOnSwipe.getSide();
                float[] fArr = new float[2];
                widgetState2.interpolate(i4, i5, f4, this);
                widgetState2.mMotionControl.getDpDt(f4, side[0], side[1], fArr);
                float f11 = direction2[0];
                if (f11 != 0.0f) {
                    abs = (f5 * Math.abs(f11)) / fArr[0];
                } else {
                    abs = (f6 * Math.abs(direction2[1])) / fArr[1];
                }
                scale = this.mOnSwipe.getScale();
            }
            return f7 * scale;
        } else if (widgetState != null) {
            return (-f6) / ((float) widgetState.mParentHeight);
        } else {
            return 1.0f;
        }
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i4 = 0;
        for (int i5 = 0; i5 <= 100; i5++) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i5));
            if (!(hashMap == null || (keyPosition = (KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                fArr[i4] = keyPosition.mX;
                fArr2[i4] = keyPosition.mY;
                fArr3[i4] = (float) keyPosition.mFrame;
                i4++;
            }
        }
    }

    public KeyPosition findNextPosition(String str, int i4) {
        KeyPosition keyPosition;
        while (i4 <= 100) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i4));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i4++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i4) {
        KeyPosition keyPosition;
        while (i4 >= 0) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i4));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i4--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mEnd;
    }

    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mInterpolated;
    }

    public int getInterpolatedHeight() {
        return this.mParentInterpolateHeight;
    }

    public int getInterpolatedWidth() {
        return this.mParentInterpolatedWidth;
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.mState.get(str).mMotionControl.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return getWidgetState(str, (ConstraintWidget) null, 0).mMotionControl;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i4 = 0;
        for (int i5 = 0; i5 <= 100; i5++) {
            HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i5));
            if (!(hashMap == null || ((KeyPosition) hashMap.get(widgetFrame.widget.stringId)) == null)) {
                i4++;
            }
        }
        return i4;
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.mState.get(str).mMotionControl.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.mStart;
    }

    public float getTouchUpProgress(long j4) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            return onSwipe.getTouchUpProgress(j4);
        }
        return 0.0f;
    }

    public boolean hasOnSwipe() {
        if (this.mOnSwipe != null) {
            return true;
        }
        return false;
    }

    public boolean hasPositionKeyframes() {
        if (this.mKeyPositions.size() > 0) {
            return true;
        }
        return false;
    }

    public void interpolate(int i4, int i5, float f4) {
        if (this.mWrap) {
            calculateParentDimensions(f4);
        }
        Easing easing = this.mEasing;
        if (easing != null) {
            f4 = (float) easing.get((double) f4);
        }
        for (String str : this.mState.keySet()) {
            this.mState.get(str).interpolate(i4, i5, f4, this);
        }
    }

    public boolean isEmpty() {
        return this.mState.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isFirstDownAccepted(float f4, float f5) {
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe == null) {
            return false;
        }
        String str = onSwipe.mLimitBoundsTo;
        if (str == null) {
            return true;
        }
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            System.err.println("mLimitBoundsTo target is null");
            return false;
        }
        WidgetFrame frame = widgetState.getFrame(2);
        if (f4 < ((float) frame.left) || f4 >= ((float) frame.right) || f5 < ((float) frame.top) || f5 >= ((float) frame.bottom)) {
            return false;
        }
        return true;
    }

    public boolean isTouchNotDone(float f4) {
        return this.mOnSwipe.isNotDone(f4);
    }

    /* access modifiers changed from: package-private */
    public void resetProperties() {
        this.mOnSwipe = null;
        this.mBundle.clear();
    }

    public void setTouchUp(float f4, long j4, float f5, float f6) {
        float f7;
        OnSwipe onSwipe = this.mOnSwipe;
        if (onSwipe != null) {
            float[] fArr = new float[2];
            float[] direction = this.mOnSwipe.getDirection();
            float[] side = this.mOnSwipe.getSide();
            this.mState.get(onSwipe.mAnchorId).mMotionControl.getDpDt(f4, side[0], side[1], fArr);
            if (((double) Math.abs((direction[0] * fArr[0]) + (direction[1] * fArr[1]))) < 0.01d) {
                fArr[0] = 0.01f;
                fArr[1] = 0.01f;
            }
            if (direction[0] != 0.0f) {
                f7 = f5 / fArr[0];
            } else {
                f7 = f6 / fArr[1];
            }
            this.mOnSwipe.config(f4, f7 * this.mOnSwipe.getScale(), j4, ((float) this.mDuration) * 0.001f);
        }
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.mBundle);
        typedBundle.applyDelta((TypedValues) this);
    }

    public boolean setValue(int i4, int i5) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i4) {
        boolean z4;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = true;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mWrap = z4;
        if (dimensionBehaviourArr[1] != dimensionBehaviour2) {
            z5 = false;
        }
        this.mWrap = z4 | z5;
        if (i4 == 0) {
            int width = constraintWidgetContainer.getWidth();
            this.mParentStartWidth = width;
            this.mParentInterpolatedWidth = width;
            int height = constraintWidgetContainer.getHeight();
            this.mParentStartHeight = height;
            this.mParentInterpolateHeight = height;
        } else {
            this.mParentEndWidth = constraintWidgetContainer.getWidth();
            this.mParentEndHeight = constraintWidgetContainer.getHeight();
        }
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        WidgetState[] widgetStateArr = new WidgetState[size];
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = children.get(i5);
            WidgetState widgetState = getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, i4);
            widgetStateArr[i5] = widgetState;
            widgetState.update(constraintWidget, i4);
            String pathRelativeId = widgetState.getPathRelativeId();
            if (pathRelativeId != null) {
                widgetState.setPathRelative(getWidgetState(pathRelativeId, (ConstraintWidget) null, i4));
            }
        }
        calcStagger();
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle, CustomVariable[] customVariableArr) {
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyAttribute(typedBundle, customVariableArr);
    }

    public void addKeyPosition(String str, int i4, int i5, float f4, float f5) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add((int) TypedValues.PositionType.TYPE_POSITION_TYPE, 2);
        typedBundle.add(100, i4);
        typedBundle.add((int) TypedValues.PositionType.TYPE_PERCENT_X, f4);
        typedBundle.add((int) TypedValues.PositionType.TYPE_PERCENT_Y, f5);
        getWidgetState(str, (ConstraintWidget) null, 0).setKeyPosition(typedBundle);
        String str2 = str;
        int i6 = i4;
        KeyPosition keyPosition = new KeyPosition(str2, i6, i5, f4, f5);
        HashMap hashMap = this.mKeyPositions.get(Integer.valueOf(i6));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.mKeyPositions.put(Integer.valueOf(i6), hashMap);
        }
        hashMap.put(str2, keyPosition);
    }

    public WidgetState getWidgetState(String str, ConstraintWidget constraintWidget, int i4) {
        WidgetState widgetState = this.mState.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.mBundle.applyDelta((TypedValues) widgetState.mMotionControl);
            widgetState.mMotionWidgetStart.updateMotion(widgetState.mMotionControl);
            this.mState.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.update(constraintWidget, i4);
            }
        }
        return widgetState;
    }

    public boolean setValue(int i4, boolean z4) {
        return false;
    }

    public static class WidgetState {
        WidgetFrame mEnd = new WidgetFrame();
        WidgetFrame mInterpolated = new WidgetFrame();
        KeyCache mKeyCache = new KeyCache();
        Motion mMotionControl;
        MotionWidget mMotionWidgetEnd = new MotionWidget(this.mEnd);
        MotionWidget mMotionWidgetInterpolated = new MotionWidget(this.mInterpolated);
        MotionWidget mMotionWidgetStart = new MotionWidget(this.mStart);
        boolean mNeedSetup = true;
        int mParentHeight = -1;
        int mParentWidth = -1;
        WidgetFrame mStart = new WidgetFrame();

        public WidgetState() {
            Motion motion = new Motion(this.mMotionWidgetStart);
            this.mMotionControl = motion;
            motion.setStart(this.mMotionWidgetStart);
            this.mMotionControl.setEnd(this.mMotionWidgetEnd);
        }

        public WidgetFrame getFrame(int i4) {
            if (i4 == 0) {
                return this.mStart;
            }
            if (i4 == 1) {
                return this.mEnd;
            }
            return this.mInterpolated;
        }

        /* access modifiers changed from: package-private */
        public String getPathRelativeId() {
            return this.mMotionControl.getAnimateRelativeTo();
        }

        public void interpolate(int i4, int i5, float f4, Transition transition) {
            this.mParentHeight = i5;
            this.mParentWidth = i4;
            if (this.mNeedSetup) {
                this.mMotionControl.setup(i4, i5, 1.0f, System.nanoTime());
                this.mNeedSetup = false;
            }
            WidgetFrame.interpolate(i4, i5, this.mInterpolated, this.mStart, this.mEnd, transition, f4);
            this.mInterpolated.interpolatedPos = f4;
            this.mMotionControl.interpolate(this.mMotionWidgetInterpolated, f4, System.nanoTime(), this.mKeyCache);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta((TypedValues) motionKeyAttributes);
            this.mMotionControl.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta((TypedValues) motionKeyCycle);
            this.mMotionControl.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta((TypedValues) motionKeyPosition);
            this.mMotionControl.addKey(motionKeyPosition);
        }

        public void setPathRelative(WidgetState widgetState) {
            this.mMotionControl.setupRelative(widgetState.mMotionControl);
        }

        public void update(ConstraintWidget constraintWidget, int i4) {
            if (i4 == 0) {
                this.mStart.update(constraintWidget);
                MotionWidget motionWidget = this.mMotionWidgetStart;
                motionWidget.updateMotion(motionWidget);
                this.mMotionControl.setStart(this.mMotionWidgetStart);
                this.mNeedSetup = true;
            } else if (i4 == 1) {
                this.mEnd.update(constraintWidget);
                this.mMotionControl.setEnd(this.mMotionWidgetEnd);
                this.mNeedSetup = true;
            }
            this.mParentWidth = -1;
        }

        public void setKeyAttribute(TypedBundle typedBundle, CustomVariable[] customVariableArr) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta((TypedValues) motionKeyAttributes);
            if (customVariableArr != null) {
                for (int i4 = 0; i4 < customVariableArr.length; i4++) {
                    motionKeyAttributes.mCustom.put(customVariableArr[i4].getName(), customVariableArr[i4]);
                }
            }
            this.mMotionControl.addKey(motionKeyAttributes);
        }
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 1).mEnd;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 2).mInterpolated;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return getWidgetState(constraintWidget.stringId, (ConstraintWidget) null, 0).mStart;
    }

    public boolean setValue(int i4, float f4) {
        if (i4 != 706) {
            return false;
        }
        this.mStagger = f4;
        return false;
    }

    public boolean setValue(int i4, String str) {
        if (i4 != 705) {
            return false;
        }
        this.mDefaultInterpolatorString = str;
        this.mEasing = Easing.getInterpolator(str);
        return false;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.mDefaultInterpolator, this.mDefaultInterpolatorString);
    }
}
