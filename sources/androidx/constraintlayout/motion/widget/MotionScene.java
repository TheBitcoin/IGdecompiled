package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DESKTOP = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    Transition mCurrentTransition = null;
    /* access modifiers changed from: private */
    public int mDefaultDuration = 400;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch = false;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    /* access modifiers changed from: private */
    public int mLayoutDuringTransition = 0;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    StateSet mStateSet = null;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int i4;
        if (str.contains("/")) {
            i4 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i4 = -1;
        }
        if (i4 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        }
        return i4;
    }

    private int getIndex(Transition transition) {
        int access$300 = transition.mId;
        if (access$300 != -1) {
            for (int i4 = 0; i4 < this.mTransitionList.size(); i4++) {
                if (this.mTransitionList.get(i4).mId == access$300) {
                    return i4;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    static String getLine(Context context, int i4, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i4) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i4) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i4, -1, -1)) == -1) {
            return i4;
        }
        return stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i4) {
        int i5 = this.mDeriveMap.get(i4);
        int size = this.mDeriveMap.size();
        while (i5 > 0) {
            if (i5 == i4) {
                return true;
            }
            int i6 = size - 1;
            if (size < 0) {
                return true;
            }
            i5 = this.mDeriveMap.get(i5);
            size = i6;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "MotionScene"
            android.content.res.Resources r2 = r10.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r11)
            int r3 = r2.getEventType()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4 = 0
        L_0x0011:
            r5 = 1
            if (r3 == r5) goto L_0x0180
            r6 = 2
            if (r3 == r6) goto L_0x0019
            goto L_0x0155
        L_0x0019:
            java.lang.String r3 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r7 = r3.hashCode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r8 = -1
            switch(r7) {
                case -1349929691: goto L_0x0087;
                case -1239391468: goto L_0x007c;
                case -687739768: goto L_0x0072;
                case 61998586: goto L_0x0067;
                case 269306229: goto L_0x005e;
                case 312750793: goto L_0x0054;
                case 327855227: goto L_0x004a;
                case 793277014: goto L_0x0042;
                case 1382829617: goto L_0x0038;
                case 1942574248: goto L_0x0027;
                default: goto L_0x0025;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0025:
            goto L_0x0091
        L_0x0027:
            java.lang.String r5 = "include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 6
            goto L_0x0092
        L_0x0032:
            r10 = move-exception
            goto L_0x015b
        L_0x0035:
            r10 = move-exception
            goto L_0x016e
        L_0x0038:
            java.lang.String r5 = "StateSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 4
            goto L_0x0092
        L_0x0042:
            boolean r3 = r3.equals(r1)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 0
            goto L_0x0092
        L_0x004a:
            java.lang.String r5 = "OnSwipe"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 2
            goto L_0x0092
        L_0x0054:
            java.lang.String r5 = "OnClick"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 3
            goto L_0x0092
        L_0x005e:
            java.lang.String r6 = "Transition"
            boolean r3 = r3.equals(r6)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0067:
            java.lang.String r5 = "ViewTransition"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 9
            goto L_0x0092
        L_0x0072:
            java.lang.String r5 = "Include"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 7
            goto L_0x0092
        L_0x007c:
            java.lang.String r5 = "KeyFrameSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 8
            goto L_0x0092
        L_0x0087:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0091
            r5 = 5
            goto L_0x0092
        L_0x0091:
            r5 = -1
        L_0x0092:
            switch(r5) {
                case 0: goto L_0x0152;
                case 1: goto L_0x0111;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00c6;
                case 4: goto L_0x00bd;
                case 5: goto L_0x00b8;
                case 6: goto L_0x00b3;
                case 7: goto L_0x00b3;
                case 8: goto L_0x00a3;
                case 9: goto L_0x0097;
                default: goto L_0x0095;
            }     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0095:
            goto L_0x0155
        L_0x0097:
            androidx.constraintlayout.motion.widget.ViewTransition r3 = new androidx.constraintlayout.motion.widget.ViewTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.ViewTransitionController r5 = r9.mViewTransitionController     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00a3:
            androidx.constraintlayout.motion.widget.KeyFrames r3 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r4 == 0) goto L_0x0155
            java.util.ArrayList r5 = r4.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r5.add(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b3:
            r9.parseInclude((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00b8:
            r9.parseConstraintSet(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00bd:
            androidx.constraintlayout.widget.StateSet r3 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r9.mStateSet = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00c6:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r3 = r3.isInEditMode()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0155
            r4.addOnClick((android.content.Context) r10, (org.xmlpull.v1.XmlPullParser) r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x00d5:
            if (r4 != 0) goto L_0x0104
            android.content.res.Resources r3 = r10.getResources()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r3.getResourceEntryName(r11)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            int r5 = r2.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r7 = " OnSwipe ("
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ".xml:"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = ")"
            r6.append(r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            java.lang.String r3 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            android.util.Log.v(r1, r3)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0104:
            if (r4 == 0) goto L_0x0155
            androidx.constraintlayout.motion.widget.TouchResponse r3 = new androidx.constraintlayout.motion.widget.TouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionLayout r5 = r9.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.<init>(r10, r5, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse unused = r4.mTouchResponse = r3     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0111:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r4.<init>(r9, r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != 0) goto L_0x0138
            r9.mCurrentTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r4.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0138
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            androidx.constraintlayout.motion.widget.TouchResponse r3 = r3.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            boolean r5 = r9.mRtl     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.setRTL(r5)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0138:
            boolean r3 = r4.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0155
            int r3 = r4.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            if (r3 != r8) goto L_0x0147
            r9.mDefaultTransition = r4     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x014c
        L_0x0147:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.add(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x014c:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            r3.remove(r4)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0155
        L_0x0152:
            r9.parseMotionSceneTags(r10, r2)     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
        L_0x0155:
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0035, IOException -> 0x0032 }
            goto L_0x0011
        L_0x015b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
            goto L_0x0180
        L_0x016e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            android.util.Log.e(r1, r11, r10)
        L_0x0180:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseConstraintSet(android.content.Context r18, org.xmlpull.v1.XmlPullParser r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            androidx.constraintlayout.widget.ConstraintSet r7 = new androidx.constraintlayout.widget.ConstraintSet
            r7.<init>()
            r8 = 0
            r7.setForceId(r8)
            int r9 = r2.getAttributeCount()
            r11 = 0
            r12 = -1
            r13 = -1
        L_0x001a:
            if (r11 >= r9) goto L_0x00e3
            java.lang.String r14 = r2.getAttributeName(r11)
            java.lang.String r15 = r2.getAttributeValue(r11)
            r14.getClass()
            int r16 = r14.hashCode()
            switch(r16) {
                case -1496482599: goto L_0x0051;
                case -1153153640: goto L_0x0046;
                case 3355: goto L_0x003b;
                case 973381616: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            r10 = -1
            goto L_0x005b
        L_0x0030:
            java.lang.String r10 = "stateLabels"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r10 = 3
            goto L_0x005b
        L_0x003b:
            java.lang.String r10 = "id"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            r10 = 2
            goto L_0x005b
        L_0x0046:
            java.lang.String r10 = "constraintRotate"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x004f
            goto L_0x002e
        L_0x004f:
            r10 = 1
            goto L_0x005b
        L_0x0051:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r10 = r14.equals(r10)
            if (r10 != 0) goto L_0x005a
            goto L_0x002e
        L_0x005a:
            r10 = 0
        L_0x005b:
            switch(r10) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x007e;
                case 2: goto L_0x0065;
                case 3: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x00e0
        L_0x0060:
            r7.setStateLabels(r15)
            goto L_0x00e0
        L_0x0065:
            int r12 = r0.getId(r1, r15)
            java.util.HashMap<java.lang.String, java.lang.Integer> r10 = r0.mConstraintSetIdMap
            java.lang.String r14 = stripID(r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r12)
            r10.put(r14, r15)
            java.lang.String r10 = androidx.constraintlayout.motion.widget.Debug.getName((android.content.Context) r1, (int) r12)
            r7.mIdString = r10
            goto L_0x00e0
        L_0x007e:
            int r10 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x0086 }
            r7.mRotate = r10     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x00e0
        L_0x0086:
            r15.getClass()
            int r10 = r15.hashCode()
            switch(r10) {
                case -768416914: goto L_0x00bf;
                case 3317767: goto L_0x00b4;
                case 3387192: goto L_0x00a9;
                case 108511772: goto L_0x009e;
                case 1954540437: goto L_0x0093;
                default: goto L_0x0091;
            }
        L_0x0091:
            r10 = -1
            goto L_0x00c9
        L_0x0093:
            java.lang.String r10 = "x_right"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x009c
            goto L_0x0091
        L_0x009c:
            r10 = 4
            goto L_0x00c9
        L_0x009e:
            java.lang.String r10 = "right"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00a7
            goto L_0x0091
        L_0x00a7:
            r10 = 3
            goto L_0x00c9
        L_0x00a9:
            java.lang.String r10 = "none"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00b2
            goto L_0x0091
        L_0x00b2:
            r10 = 2
            goto L_0x00c9
        L_0x00b4:
            java.lang.String r10 = "left"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00bd
            goto L_0x0091
        L_0x00bd:
            r10 = 1
            goto L_0x00c9
        L_0x00bf:
            java.lang.String r10 = "x_left"
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00c8
            goto L_0x0091
        L_0x00c8:
            r10 = 0
        L_0x00c9:
            switch(r10) {
                case 0: goto L_0x00d9;
                case 1: goto L_0x00d6;
                case 2: goto L_0x00d3;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00cd;
                default: goto L_0x00cc;
            }
        L_0x00cc:
            goto L_0x00e0
        L_0x00cd:
            r7.mRotate = r4
            goto L_0x00e0
        L_0x00d0:
            r7.mRotate = r6
            goto L_0x00e0
        L_0x00d3:
            r7.mRotate = r8
            goto L_0x00e0
        L_0x00d6:
            r7.mRotate = r5
            goto L_0x00e0
        L_0x00d9:
            r7.mRotate = r3
            goto L_0x00e0
        L_0x00dc:
            int r13 = r0.getId(r1, r15)
        L_0x00e0:
            int r11 = r11 + r6
            goto L_0x001a
        L_0x00e3:
            r10 = -1
            if (r12 == r10) goto L_0x00fe
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r0.mMotionLayout
            int r3 = r3.mDebugPath
            if (r3 == 0) goto L_0x00ef
            r7.setValidateOnParse(r6)
        L_0x00ef:
            r7.load((android.content.Context) r1, (org.xmlpull.v1.XmlPullParser) r2)
            if (r13 == r10) goto L_0x00f9
            android.util.SparseIntArray r1 = r0.mDeriveMap
            r1.put(r12, r13)
        L_0x00f9:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r1 = r0.mConstraintSetMap
            r1.put(r12, r7)
        L_0x00fe:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, obtainStyledAttributes.getResourceId(index, -1));
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = obtainStyledAttributes.getIndex(i4);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i5 = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i5;
                if (i5 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i4, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i4);
        constraintSet.derivedState = constraintSet.mIdString;
        int i5 = this.mDeriveMap.get(i4);
        if (i5 > 0) {
            readConstraintChain(i5, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i5);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i5));
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback((ConstraintLayout) motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i4) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition = arrayList.get(i5);
            i5++;
            Transition transition2 = transition;
            if (transition2.mOnClicks.size() > 0) {
                ArrayList access$400 = transition2.mOnClicks;
                int size2 = access$400.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj = access$400.get(i6);
                    i6++;
                    ((Transition.TransitionOnClick) obj).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList2 = this.mAbstractTransitionList;
        int size3 = arrayList2.size();
        int i7 = 0;
        while (i7 < size3) {
            Transition transition3 = arrayList2.get(i7);
            i7++;
            Transition transition4 = transition3;
            if (transition4.mOnClicks.size() > 0) {
                ArrayList access$4002 = transition4.mOnClicks;
                int size4 = access$4002.size();
                int i8 = 0;
                while (i8 < size4) {
                    Object obj2 = access$4002.get(i8);
                    i8++;
                    ((Transition.TransitionOnClick) obj2).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList3 = this.mTransitionList;
        int size5 = arrayList3.size();
        int i9 = 0;
        while (i9 < size5) {
            Transition transition5 = arrayList3.get(i9);
            i9++;
            Transition transition6 = transition5;
            if (transition6.mOnClicks.size() > 0) {
                ArrayList access$4003 = transition6.mOnClicks;
                int size6 = access$4003.size();
                int i10 = 0;
                while (i10 < size6) {
                    Object obj3 = access$4003.get(i10);
                    i10++;
                    ((Transition.TransitionOnClick) obj3).addOnClickListeners(motionLayout, i4, transition6);
                }
            }
        }
        ArrayList<Transition> arrayList4 = this.mAbstractTransitionList;
        int size7 = arrayList4.size();
        int i11 = 0;
        while (i11 < size7) {
            Transition transition7 = arrayList4.get(i11);
            i11++;
            Transition transition8 = transition7;
            if (transition8.mOnClicks.size() > 0) {
                ArrayList access$4004 = transition8.mOnClicks;
                int size8 = access$4004.size();
                int i12 = 0;
                while (i12 < size8) {
                    Object obj4 = access$4004.get(i12);
                    i12++;
                    ((Transition.TransitionOnClick) obj4).addOnClickListeners(motionLayout, i4, transition8);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i4, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i4, motionController);
    }

    /* access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int i4) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition2 = arrayList.get(i5);
            i5++;
            Transition transition3 = transition2;
            if (transition3.mAutoTransition != 0 && ((transition = this.mCurrentTransition) != transition3 || !transition.isTransitionFlag(2))) {
                if (i4 == transition3.mConstraintSetStart && (transition3.mAutoTransition == 4 || transition3.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                } else if (i4 == transition3.mConstraintSetEnd && (transition3.mAutoTransition == 3 || transition3.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i4, float f4, float f5, MotionEvent motionEvent) {
        RectF limitBoundsTo;
        float f6;
        int i5 = i4;
        float f7 = f4;
        float f8 = f5;
        if (i5 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i4);
        RectF rectF = new RectF();
        float f9 = 0.0f;
        Transition transition = null;
        for (Transition next : transitionsWithState) {
            if (!next.mDisable && next.mTouchResponse != null) {
                next.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = next.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if ((touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) && ((limitBoundsTo = next.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF)) == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float dot = next.mTouchResponse.dot(f7, f8);
                    if (next.mTouchResponse.mIsRotateMode && motionEvent != null) {
                        float x4 = motionEvent.getX() - next.mTouchResponse.mRotateCenterX;
                        float y4 = motionEvent.getY() - next.mTouchResponse.mRotateCenterY;
                        dot = ((float) (Math.atan2((double) (f8 + y4), (double) (f7 + x4)) - Math.atan2((double) x4, (double) y4))) * 10.0f;
                    }
                    if (next.mConstraintSetEnd == i5) {
                        f6 = -1.0f;
                    } else {
                        f6 = 1.1f;
                    }
                    float f10 = dot * f6;
                    if (f10 > f9) {
                        transition = next;
                        f9 = f10;
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z4) {
        this.mDisableAutoTransition = z4;
    }

    public void enableViewTransition(int i4, boolean z4) {
        this.mViewTransitionController.enableViewTransition(i4, z4);
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getAutoCompleteMode() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getAutoCompleteMode();
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        for (int i4 = 0; i4 < this.mConstraintSetMap.size(); i4++) {
            int keyAt = this.mConstraintSetMap.keyAt(i4);
            if (str.equals(context.getResources().getResourceName(keyAt))) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = this.mConstraintSetMap.keyAt(i4);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    /* access modifiers changed from: package-private */
    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int access$1500 = this.mCurrentTransition.mDefaultInterpolator;
        if (access$1500 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (access$1500 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() {
                public float getInterpolation(float f4) {
                    return (float) interpolator.get((double) f4);
                }
            };
        } else if (access$1500 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (access$1500 == 1) {
                return new AccelerateInterpolator();
            }
            if (access$1500 == 2) {
                return new DecelerateInterpolator();
            }
            if (access$1500 == 4) {
                return new BounceInterpolator();
            }
            if (access$1500 == 5) {
                return new OvershootInterpolator();
            }
            if (access$1500 != 6) {
                return null;
            }
            return new AnticipateInterpolator();
        }
    }

    /* access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int i4, int i5, int i6) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        ArrayList access$1400 = transition.mKeyFramesList;
        int size = access$1400.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = access$1400.get(i7);
            i7++;
            KeyFrames keyFrames = (KeyFrames) obj;
            Iterator<Integer> it = keyFrames.getKeys().iterator();
            while (true) {
                if (it.hasNext()) {
                    Integer next = it.next();
                    if (i5 == next.intValue()) {
                        ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(next.intValue());
                        int size2 = keyFramesForView.size();
                        int i8 = 0;
                        while (i8 < size2) {
                            Key key = keyFramesForView.get(i8);
                            i8++;
                            Key key2 = key;
                            if (key2.mFramePosition == i6 && key2.mType == i4) {
                                return key2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        int i4 = 0;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                ArrayList access$1400 = transition2.mKeyFramesList;
                int size = access$1400.size();
                while (i4 < size) {
                    Object obj = access$1400.get(i4);
                    i4++;
                    ((KeyFrames) obj).addFrames(motionController);
                }
                return;
            }
            return;
        }
        ArrayList access$14002 = transition.mKeyFramesList;
        int size2 = access$14002.size();
        while (i4 < size2) {
            Object obj2 = access$14002.get(i4);
            i4++;
            ((KeyFrames) obj2).addFrames(motionController);
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintSet valueAt = this.mConstraintSetMap.valueAt(i5);
            int keyAt = this.mConstraintSetMap.keyAt(i5);
            if (valueAt.matchesLabels(strArr)) {
                valueAt.getStateLabels();
                iArr[i4] = keyAt;
                i4++;
            }
        }
        return Arrays.copyOf(iArr, i4);
    }

    /* access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    /* access modifiers changed from: package-private */
    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    /* access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i4) {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getProgressDirection(float f4, float f5) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f4, f5);
    }

    /* access modifiers changed from: package-private */
    public int getSpringBoundary() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringBoundary();
    }

    /* access modifiers changed from: package-private */
    public float getSpringDamping() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringDamping();
    }

    /* access modifiers changed from: package-private */
    public float getSpringMass() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringMass();
    }

    /* access modifiers changed from: package-private */
    public float getSpringStiffiness() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStiffness();
    }

    /* access modifiers changed from: package-private */
    public float getSpringStopThreshold() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i4) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition = arrayList.get(i5);
            i5++;
            Transition transition2 = transition;
            if (transition2.mId == i4) {
                return transition2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getTransitionDirection(int i4) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition = arrayList.get(i5);
            i5++;
            if (transition.mConstraintSetStart == i4) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i4) {
        int realID = getRealID(i4);
        ArrayList arrayList = new ArrayList();
        ArrayList<Transition> arrayList2 = this.mTransitionList;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Transition transition = arrayList2.get(i5);
            i5++;
            Transition transition2 = transition;
            if (transition2.mConstraintSetStart == realID || transition2.mConstraintSetEnd == realID) {
                arrayList.add(transition2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int i4) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        ArrayList access$1400 = transition.mKeyFramesList;
        int size = access$1400.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = access$1400.get(i5);
            i5++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i6 = 0;
            while (true) {
                if (i6 < size2) {
                    Key key = keyFramesForView.get(i6);
                    i6++;
                    if (key.mFramePosition == i4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i4) {
        return this.mViewTransitionController.isViewTransitionEnabled(i4);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i4) {
        for (Map.Entry next : this.mConstraintSetIdMap.entrySet()) {
            Integer num = (Integer) next.getValue();
            if (num != null && num.intValue() == i4) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
    }

    /* access modifiers changed from: package-private */
    public void processScrollMove(float f4, float f5) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollMove(f4, f5);
        }
    }

    /* access modifiers changed from: package-private */
    public void processScrollUp(float f4, float f5) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollUp(f4, f5);
        }
    }

    /* access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, int i4, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i4 != -1) {
            int action = motionEvent.getAction();
            boolean z4 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo == null || limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                        return;
                    }
                    this.mLastTouchDown = null;
                    this.mIgnoreTouch = true;
                    return;
                }
                return;
            } else if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.mLastTouchDown) != null) {
                    Transition bestTransitionFor = bestTransitionFor(i4, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                        if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z4 = true;
                        }
                        this.mMotionOutsideRegion = z4;
                        this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                    }
                } else {
                    return;
                }
            }
        }
        if (!this.mIgnoreTouch) {
            Transition transition = this.mCurrentTransition;
            if (!(transition == null || transition.mTouchResponse == null || this.mMotionOutsideRegion)) {
                this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i4, this);
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
                motionTracker.recycle();
                this.mVelocityTracker = null;
                int i5 = motionLayout.mCurrentState;
                if (i5 != -1) {
                    autoTransition(motionLayout, i5);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        int i4 = 0;
        while (i4 < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i4);
            if (hasCycleDependency(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            } else {
                readConstraintChain(keyAt, motionLayout);
                i4++;
            }
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i4, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i4, constraintSet);
    }

    public void setDuration(int i4) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i4);
        } else {
            this.mDefaultDuration = i4;
        }
    }

    public void setKeyframe(View view, int i4, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            ArrayList access$1400 = transition.mKeyFramesList;
            int size = access$1400.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = access$1400.get(i5);
                i5++;
                ArrayList<Key> keyFramesForView = ((KeyFrames) obj2).getKeyFramesForView(view.getId());
                int size2 = keyFramesForView.size();
                int i6 = 0;
                while (i6 < size2) {
                    Key key = keyFramesForView.get(i6);
                    i6++;
                    if (key.mFramePosition == i4 && obj != null) {
                        Float f4 = (Float) obj;
                    }
                }
            }
        }
    }

    public void setRtl(boolean z4) {
        this.mRtl = z4;
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransition(int r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.widget.StateSet r0 = r9.mStateSet
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.stateGetConstraintID(r10, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r10
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r9.mStateSet
            int r2 = r2.stateGetConstraintID(r11, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r11
            goto L_0x001a
        L_0x0018:
            r0 = r10
            goto L_0x0016
        L_0x001a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            if (r3 == 0) goto L_0x002d
            int r3 = r3.mConstraintSetEnd
            if (r3 != r11) goto L_0x002d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            int r3 = r3.mConstraintSetStart
            if (r3 != r10) goto L_0x002d
            goto L_0x006c
        L_0x002d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList
            int r4 = r3.size()
            r5 = 0
            r6 = 0
        L_0x0035:
            if (r6 >= r4) goto L_0x006d
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r7
            int r8 = r7.mConstraintSetEnd
            if (r8 != r2) goto L_0x004b
            int r8 = r7.mConstraintSetStart
            if (r8 == r0) goto L_0x0057
        L_0x004b:
            int r8 = r7.mConstraintSetEnd
            if (r8 != r11) goto L_0x0035
            int r8 = r7.mConstraintSetStart
            if (r8 != r10) goto L_0x0035
        L_0x0057:
            r9.mCurrentTransition = r7
            if (r7 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = r7.mTouchResponse
            if (r10 == 0) goto L_0x006c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r10 = r10.mTouchResponse
            boolean r11 = r9.mRtl
            r10.setRTL(r11)
        L_0x006c:
            return
        L_0x006d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList
            int r4 = r3.size()
        L_0x0075:
            if (r5 >= r4) goto L_0x0087
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r6
            int r7 = r6.mConstraintSetEnd
            if (r7 != r11) goto L_0x0075
            r10 = r6
            goto L_0x0075
        L_0x0087:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r11 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r11.<init>(r9, r10)
            int unused = r11.mConstraintSetStart = r0
            int unused = r11.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x0099
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r10 = r9.mTransitionList
            r10.add(r11)
        L_0x0099:
            r9.mCurrentTransition = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setupTouch();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean supportTouch() {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Transition transition = arrayList.get(i4);
            i4++;
            if (transition.mTouchResponse != null) {
                return true;
            }
        }
        Transition transition2 = this.mCurrentTransition;
        if (transition2 == null || transition2.mTouchResponse == null) {
            return false;
        }
        return true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.mMotionLayout && motionLayout.mScene == this) {
            return true;
        }
        return false;
    }

    public void viewTransition(int i4, View... viewArr) {
        this.mViewTransitionController.viewTransition(i4, viewArr);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTERCEPT_TOUCH = 4;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        /* access modifiers changed from: private */
        public int mAutoTransition = 0;
        /* access modifiers changed from: private */
        public int mConstraintSetEnd = -1;
        /* access modifiers changed from: private */
        public int mConstraintSetStart = -1;
        /* access modifiers changed from: private */
        public int mDefaultInterpolator = 0;
        /* access modifiers changed from: private */
        public int mDefaultInterpolatorID = -1;
        /* access modifiers changed from: private */
        public String mDefaultInterpolatorString = null;
        /* access modifiers changed from: private */
        public boolean mDisable = false;
        /* access modifiers changed from: private */
        public int mDuration = 400;
        /* access modifiers changed from: private */
        public int mId = -1;
        /* access modifiers changed from: private */
        public boolean mIsAbstract = false;
        /* access modifiers changed from: private */
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        private int mLayoutDuringTransition = 0;
        /* access modifiers changed from: private */
        public final MotionScene mMotionScene;
        /* access modifiers changed from: private */
        public ArrayList<TransitionOnClick> mOnClicks = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mPathMotionArc = -1;
        /* access modifiers changed from: private */
        public float mStagger = 0.0f;
        /* access modifiers changed from: private */
        public TouchResponse mTouchResponse = null;
        private int mTransitionFlags = 0;

        Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = typedArray.getIndex(i4);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i5 = typedArray.peekValue(index).type;
                    if (i5 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i5 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i6 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i6;
                    if (i6 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i4, int i5) {
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                TransitionOnClick transitionOnClick = arrayList.get(i6);
                i6++;
                TransitionOnClick transitionOnClick2 = transitionOnClick;
                if (transitionOnClick2.mTargetId == i4) {
                    transitionOnClick2.mMode = i5;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i4, i5));
        }

        public String debugString(Context context) {
            String str;
            if (this.mConstraintSetStart == -1) {
                str = "null";
            } else {
                str = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return str + " -> null";
            }
            return str + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i4) {
            if ((i4 & this.mTransitionFlags) != 0) {
                return true;
            }
            return false;
        }

        public void removeOnClick(int i4) {
            TransitionOnClick transitionOnClick;
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    transitionOnClick = null;
                    break;
                }
                TransitionOnClick transitionOnClick2 = arrayList.get(i5);
                i5++;
                transitionOnClick = transitionOnClick2;
                if (transitionOnClick.mTargetId == i4) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i4) {
            this.mAutoTransition = i4;
        }

        public void setDuration(int i4) {
            this.mDuration = Math.max(i4, 8);
        }

        public void setEnabled(boolean z4) {
            this.mDisable = !z4;
        }

        public void setInterpolatorInfo(int i4, String str, int i5) {
            this.mDefaultInterpolator = i4;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i5;
        }

        public void setLayoutDuringTransition(int i4) {
            this.mLayoutDuringTransition = i4;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            TouchResponse touchResponse;
            if (onSwipe == null) {
                touchResponse = null;
            } else {
                touchResponse = new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
            }
            this.mTouchResponse = touchResponse;
        }

        public void setOnTouchUp(int i4) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i4);
            }
        }

        public void setPathMotionArc(int i4) {
            this.mPathMotionArc = i4;
        }

        public void setStagger(float f4) {
            this.mStagger = f4;
        }

        public void setTransitionFlag(int i4) {
            this.mTransitionFlags = i4;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i4 = 0; i4 < indexCount; i4++) {
                    int index = obtainStyledAttributes.getIndex(i4);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i4, Transition transition) {
                boolean z4;
                boolean z5;
                boolean z6;
                boolean z7;
                int i5 = this.mTargetId;
                View view = motionLayout;
                if (i5 != -1) {
                    view = motionLayout.findViewById(i5);
                }
                if (view == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.mTargetId);
                    return;
                }
                int access$100 = transition.mConstraintSetStart;
                int access$000 = transition.mConstraintSetEnd;
                if (access$100 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i6 = this.mMode;
                boolean z8 = false;
                if ((i6 & 1) == 0 || i4 != access$100) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if ((i6 & 256) == 0 || i4 != access$100) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                boolean z9 = z4 | z5;
                if ((i6 & 1) == 0 || i4 != access$100) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                boolean z10 = z6 | z9;
                if ((i6 & 16) == 0 || i4 != access$000) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                boolean z11 = z10 | z7;
                if ((i6 & 4096) != 0 && i4 == access$000) {
                    z8 = true;
                }
                if (z11 || z8) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int access$000 = transition2.mConstraintSetEnd;
                int access$100 = this.mTransition.mConstraintSetStart;
                if (access$100 != -1) {
                    int i4 = motionLayout.mCurrentState;
                    if (i4 == access$100 || i4 == access$000) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.mCurrentState != access$000) {
                    return true;
                } else {
                    return false;
                }
            }

            public void onClick(View view) {
                boolean z4;
                boolean z5;
                MotionLayout access$700 = this.mTransition.mMotionScene.mMotionLayout;
                if (access$700.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = access$700.getCurrentState();
                        if (currentState == -1) {
                            access$700.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        int unused = transition.mConstraintSetStart = currentState;
                        int unused2 = transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        access$700.setTransition(transition);
                        access$700.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i4 = this.mMode;
                    boolean z6 = false;
                    if ((i4 & 1) == 0 && (i4 & 256) == 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if ((i4 & 16) == 0 && (i4 & 4096) == 0) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z4 || !z5) {
                        z6 = z4;
                    } else {
                        Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            access$700.setTransition(transition4);
                        }
                        if (access$700.getCurrentState() != access$700.getEndState() && access$700.getProgress() <= 0.5f) {
                            z6 = z4;
                            z5 = false;
                        }
                    }
                    if (!isTransitionViable(transition2, access$700)) {
                        return;
                    }
                    if (z6 && (this.mMode & 1) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.transitionToEnd();
                    } else if (z5 && (this.mMode & 16) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.transitionToStart();
                    } else if (z6 && (this.mMode & 256) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.setProgress(1.0f);
                    } else if (z5 && (this.mMode & 4096) != 0) {
                        access$700.setTransition(this.mTransition);
                        access$700.setProgress(0.0f);
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i4 = this.mTargetId;
                if (i4 != -1) {
                    View findViewById = motionLayout.findViewById(i4);
                    if (findViewById == null) {
                        Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.mTargetId);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            public TransitionOnClick(Transition transition, int i4, int i5) {
                this.mTransition = transition;
                this.mTargetId = i4;
                this.mMode = i5;
            }
        }

        public Transition(int i4, MotionScene motionScene, int i5, int i6) {
            this.mId = i4;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i5;
            this.mConstraintSetEnd = i6;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i4) {
        return getConstraintSet(i4, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i4, int i5, int i6) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i4, i5, i6)) == -1)) {
            i4 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i4) != null) {
            return this.mConstraintSetMap.get(i4);
        }
        Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i4) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    /* access modifiers changed from: private */
    public int parseInclude(Context context, int i4) {
        XmlResourceParser xml = context.getResources().getXml(i4);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (XmlPullParserException e5) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i4, e5);
            return -1;
        } catch (IOException e6) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i4, e6);
            return -1;
        }
    }

    MotionScene(Context context, MotionLayout motionLayout, int i4) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i4);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i5 = R.id.motion_base;
        sparseArray.put(i5, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i5));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
        }
    }
}
