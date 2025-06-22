package h;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

/* renamed from: h.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0919a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f3394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f3395b;

    public /* synthetic */ C0919a(FragmentStrictMode.Policy policy, Violation violation) {
        this.f3394a = policy;
        this.f3395b = violation;
    }

    public final void run() {
        FragmentStrictMode.m0handlePolicyViolation$lambda0(this.f3394a, this.f3395b);
    }
}
