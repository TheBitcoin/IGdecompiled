package androidx.constraintlayout.core.state;

public final /* synthetic */ class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f830a;

    public /* synthetic */ a(String str) {
        this.f830a = str;
    }

    public final float getInterpolation(float f4) {
        return Transition.d(this.f830a, f4);
    }
}
