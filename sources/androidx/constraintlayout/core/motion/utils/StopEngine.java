package androidx.constraintlayout.core.motion.utils;

public interface StopEngine {
    String debug(String str, float f4);

    float getInterpolation(float f4);

    float getVelocity();

    float getVelocity(float f4);

    boolean isStopped();
}
