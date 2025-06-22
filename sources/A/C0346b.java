package a;

/* renamed from: a.b  reason: case insensitive filesystem */
public abstract class C0346b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f661a = "_COROUTINE";

    /* access modifiers changed from: private */
    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f661a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
