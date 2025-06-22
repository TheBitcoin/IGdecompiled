package androidx.core.view;

public interface DifferentialMotionFlingTarget {
    float getScaledScrollFactor();

    boolean startDifferentialMotionFling(float f4);

    void stopDifferentialMotionFling();
}
