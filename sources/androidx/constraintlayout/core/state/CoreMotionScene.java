package androidx.constraintlayout.core.state;

public interface CoreMotionScene {
    String getConstraintSet(int i4);

    String getConstraintSet(String str);

    String getTransition(String str);

    void setConstraintSetContent(String str, String str2);

    void setDebugName(String str);

    void setTransitionContent(String str, String str2);
}
