package h;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

/* renamed from: h.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0920b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3396a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f3397b;

    public /* synthetic */ C0920b(String str, Violation violation) {
        this.f3396a = str;
        this.f3397b = violation;
    }

    public final void run() {
        FragmentStrictMode.m1handlePolicyViolation$lambda1(this.f3396a, this.f3397b);
    }
}
