package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.c;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private String mCustomWaveShape = null;
    private float mElevation = Float.NaN;
    private float mProgress = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePeriod = Float.NaN;
    private int mWaveShape = 0;

    public MotionKeyTimeCycle() {
        this.mType = 3;
        this.mCustom = new HashMap<>();
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        for (String next : hashMap.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = hashMap.get(next);
            if (timeCycleSplineSet != null) {
                if (!next.startsWith("CUSTOM")) {
                    char c5 = 65535;
                    switch (next.hashCode()) {
                        case -1249320806:
                            if (next.equals("rotationX")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -1249320805:
                            if (next.equals("rotationY")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -1249320804:
                            if (next.equals("rotationZ")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case -1225497657:
                            if (next.equals("translationX")) {
                                c5 = 3;
                                break;
                            }
                            break;
                        case -1225497656:
                            if (next.equals("translationY")) {
                                c5 = 4;
                                break;
                            }
                            break;
                        case -1225497655:
                            if (next.equals("translationZ")) {
                                c5 = 5;
                                break;
                            }
                            break;
                        case -1001078227:
                            if (next.equals("progress")) {
                                c5 = 6;
                                break;
                            }
                            break;
                        case -908189618:
                            if (next.equals("scaleX")) {
                                c5 = 7;
                                break;
                            }
                            break;
                        case -908189617:
                            if (next.equals("scaleY")) {
                                c5 = 8;
                                break;
                            }
                            break;
                        case -4379043:
                            if (next.equals("elevation")) {
                                c5 = 9;
                                break;
                            }
                            break;
                        case 92909918:
                            if (next.equals("alpha")) {
                                c5 = 10;
                                break;
                            }
                            break;
                        case 803192288:
                            if (next.equals("pathRotate")) {
                                c5 = 11;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            if (Float.isNaN(this.mRotationX)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.mRotationY)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.mRotation)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.mTranslationX)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.mTranslationY)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.mTranslationZ)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.mProgress)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.mScaleX)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 8:
                            if (Float.isNaN(this.mScaleY)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 9:
                            if (Float.isNaN(this.mTranslationZ)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 10:
                            if (Float.isNaN(this.mAlpha)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.mTransitionPathRotate)) {
                                break;
                            } else {
                                timeCycleSplineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                                break;
                            }
                        default:
                            Utils.loge("KeyTimeCycles", "UNKNOWN addValues \"" + next + "\"");
                            break;
                    }
                } else {
                    CustomVariable customVariable = this.mCustom.get(next.substring(7));
                    if (customVariable != null) {
                        ((TimeCycleSplineSet.CustomVarSet) timeCycleSplineSet).setPoint(this.mFramePosition, customVariable, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    }
                }
            }
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public int getId(String str) {
        return c.a(str);
    }

    public boolean setValue(int i4, int i5) {
        if (i4 == 100) {
            this.mFramePosition = i5;
            return true;
        } else if (i4 != 421) {
            return super.setValue(i4, i5);
        } else {
            this.mWaveShape = i5;
            return true;
        }
    }

    public MotionKey clone() {
        return new MotionKeyTimeCycle().copy((MotionKey) this);
    }

    public MotionKeyTimeCycle copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.mTransitionEasing = motionKeyTimeCycle.mTransitionEasing;
        this.mCurveFit = motionKeyTimeCycle.mCurveFit;
        this.mWaveShape = motionKeyTimeCycle.mWaveShape;
        this.mWavePeriod = motionKeyTimeCycle.mWavePeriod;
        this.mWaveOffset = motionKeyTimeCycle.mWaveOffset;
        this.mProgress = motionKeyTimeCycle.mProgress;
        this.mAlpha = motionKeyTimeCycle.mAlpha;
        this.mElevation = motionKeyTimeCycle.mElevation;
        this.mRotation = motionKeyTimeCycle.mRotation;
        this.mTransitionPathRotate = motionKeyTimeCycle.mTransitionPathRotate;
        this.mRotationX = motionKeyTimeCycle.mRotationX;
        this.mRotationY = motionKeyTimeCycle.mRotationY;
        this.mScaleX = motionKeyTimeCycle.mScaleX;
        this.mScaleY = motionKeyTimeCycle.mScaleY;
        this.mTranslationX = motionKeyTimeCycle.mTranslationX;
        this.mTranslationY = motionKeyTimeCycle.mTranslationY;
        this.mTranslationZ = motionKeyTimeCycle.mTranslationZ;
        return this;
    }

    public boolean setValue(int i4, float f4) {
        if (i4 == 315) {
            this.mProgress = toFloat(Float.valueOf(f4));
            return true;
        } else if (i4 == 401) {
            this.mCurveFit = toInt(Float.valueOf(f4));
            return true;
        } else if (i4 == 403) {
            this.mAlpha = f4;
            return true;
        } else if (i4 == 416) {
            this.mTransitionPathRotate = toFloat(Float.valueOf(f4));
            return true;
        } else if (i4 == 423) {
            this.mWavePeriod = toFloat(Float.valueOf(f4));
            return true;
        } else if (i4 != 424) {
            switch (i4) {
                case 304:
                    this.mTranslationX = toFloat(Float.valueOf(f4));
                    return true;
                case 305:
                    this.mTranslationY = toFloat(Float.valueOf(f4));
                    return true;
                case 306:
                    this.mTranslationZ = toFloat(Float.valueOf(f4));
                    return true;
                case 307:
                    this.mElevation = toFloat(Float.valueOf(f4));
                    return true;
                case 308:
                    this.mRotationX = toFloat(Float.valueOf(f4));
                    return true;
                case 309:
                    this.mRotationY = toFloat(Float.valueOf(f4));
                    return true;
                case 310:
                    this.mRotation = toFloat(Float.valueOf(f4));
                    return true;
                case 311:
                    this.mScaleX = toFloat(Float.valueOf(f4));
                    return true;
                case 312:
                    this.mScaleY = toFloat(Float.valueOf(f4));
                    return true;
                default:
                    return super.setValue(i4, f4);
            }
        } else {
            this.mWaveOffset = toFloat(Float.valueOf(f4));
            return true;
        }
    }

    public boolean setValue(int i4, String str) {
        if (i4 == 420) {
            this.mTransitionEasing = str;
            return true;
        } else if (i4 != 421) {
            return super.setValue(i4, str);
        } else {
            this.mWaveShape = 7;
            this.mCustomWaveShape = str;
            return true;
        }
    }

    public boolean setValue(int i4, boolean z4) {
        return super.setValue(i4, z4);
    }
}
