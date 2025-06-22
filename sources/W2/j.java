package w2;

import android.view.animation.Interpolator;

public final class j implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private double f22033a;

    /* renamed from: b  reason: collision with root package name */
    private double f22034b;

    public j(double d5, double d6) {
        this.f22033a = d5;
        this.f22034b = d6;
    }

    public float getInterpolation(float f4) {
        return (float) ((((double) -1) * Math.pow(2.718281828459045d, ((double) (-f4)) / this.f22033a) * Math.cos(this.f22034b * ((double) f4))) + ((double) 1));
    }
}
