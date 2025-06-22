package H0;

import java.util.Stack;

/* renamed from: H0.e  reason: case insensitive filesystem */
public class C1304e {

    /* renamed from: a  reason: collision with root package name */
    public final String f6621a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6622b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f6623c;

    /* renamed from: d  reason: collision with root package name */
    public final C1304e f6624d;

    private C1304e(String str, String str2, StackTraceElement[] stackTraceElementArr, C1304e eVar) {
        this.f6621a = str;
        this.f6622b = str2;
        this.f6623c = stackTraceElementArr;
        this.f6624d = eVar;
    }

    public static C1304e a(Throwable th, C1303d dVar) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        C1304e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            eVar = new C1304e(th2.getLocalizedMessage(), th2.getClass().getName(), dVar.a(th2.getStackTrace()), eVar);
        }
        return eVar;
    }
}
