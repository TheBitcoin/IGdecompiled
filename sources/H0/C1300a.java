package H0;

/* renamed from: H0.a  reason: case insensitive filesystem */
public class C1300a implements C1303d {

    /* renamed from: a  reason: collision with root package name */
    private final int f6616a;

    /* renamed from: b  reason: collision with root package name */
    private final C1303d[] f6617b;

    /* renamed from: c  reason: collision with root package name */
    private final C1301b f6618c;

    public C1300a(int i4, C1303d... dVarArr) {
        this.f6616a = i4;
        this.f6617b = dVarArr;
        this.f6618c = new C1301b(i4);
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f6616a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (C1303d dVar : this.f6617b) {
            if (stackTraceElementArr2.length <= this.f6616a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f6616a) {
            return this.f6618c.a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
