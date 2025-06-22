package t3;

import R2.m;
import R2.n;
import a.C0345a;
import kotlin.coroutines.jvm.internal.a;

public abstract class E {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement f4464a = new C0345a().a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f4465b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f4466c;

    static {
        Object obj;
        Object obj2;
        try {
            m.a aVar = m.f8216a;
            obj = m.a(a.class.getCanonicalName());
        } catch (Throwable th) {
            m.a aVar2 = m.f8216a;
            obj = m.a(n.a(th));
        }
        if (m.b(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f4465b = (String) obj;
        try {
            obj2 = m.a(E.class.getCanonicalName());
        } catch (Throwable th2) {
            m.a aVar3 = m.f8216a;
            obj2 = m.a(n.a(th2));
        }
        if (m.b(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f4466c = (String) obj2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
