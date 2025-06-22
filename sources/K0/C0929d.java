package k0;

/* renamed from: k0.d  reason: case insensitive filesystem */
public final class C0929d extends IllegalStateException {
    private C0929d(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(C0937l lVar) {
        String str;
        if (!lVar.m()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception i4 = lVar.i();
        if (i4 != null) {
            str = "failure";
        } else if (lVar.n()) {
            str = "result ".concat(String.valueOf(lVar.j()));
        } else if (lVar.l()) {
            str = "cancellation";
        } else {
            str = "unknown issue";
        }
        return new C0929d("Complete with: ".concat(str), i4);
    }
}
