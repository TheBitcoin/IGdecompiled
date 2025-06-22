package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

public abstract class MotionKey implements TypedValues {
    public static final String ALPHA = "alpha";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String ROTATION = "rotationZ";
    public static final String ROTATION_X = "rotationX";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public HashMap<String, CustomVariable> mCustom;
    public int mFramePosition;
    int mTargetId;
    String mTargetString = null;
    public int mType;

    public MotionKey() {
        int i4 = UNSET;
        this.mFramePosition = i4;
        this.mTargetId = i4;
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    public abstract MotionKey clone();

    public MotionKey copy(MotionKey motionKey) {
        this.mFramePosition = motionKey.mFramePosition;
        this.mTargetId = motionKey.mTargetId;
        this.mTargetString = motionKey.mTargetString;
        this.mType = motionKey.mType;
        return this;
    }

    public abstract void getAttributeNames(HashSet<String> hashSet);

    public int getFramePosition() {
        return this.mFramePosition;
    }

    /* access modifiers changed from: package-private */
    public boolean matches(String str) {
        String str2 = this.mTargetString;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void setCustomAttribute(String str, int i4, float f4) {
        this.mCustom.put(str, new CustomVariable(str, i4, f4));
    }

    public void setFramePosition(int i4) {
        this.mFramePosition = i4;
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public boolean setValue(int i4, float f4) {
        return false;
    }

    public MotionKey setViewId(int i4) {
        this.mTargetId = i4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public float toFloat(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    /* access modifiers changed from: package-private */
    public int toInt(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }

    public void setCustomAttribute(String str, int i4, int i5) {
        this.mCustom.put(str, new CustomVariable(str, i4, i5));
    }

    public boolean setValue(int i4, boolean z4) {
        return false;
    }

    public void setCustomAttribute(String str, int i4, boolean z4) {
        this.mCustom.put(str, new CustomVariable(str, i4, z4));
    }

    public boolean setValue(int i4, int i5) {
        if (i4 != 100) {
            return false;
        }
        this.mFramePosition = i5;
        return true;
    }

    public void setCustomAttribute(String str, int i4, String str2) {
        this.mCustom.put(str, new CustomVariable(str, i4, str2));
    }

    public boolean setValue(int i4, String str) {
        if (i4 != 101) {
            return false;
        }
        this.mTargetString = str;
        return true;
    }
}
