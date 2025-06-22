package H0;

/* renamed from: H0.b  reason: case insensitive filesystem */
public class C1301b implements C1303d {

    /* renamed from: a  reason: collision with root package name */
    private final int f6619a;

    public C1301b(int i4) {
        this.f6619a = i4;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i4 = this.f6619a;
        if (length <= i4) {
            return stackTraceElementArr;
        }
        int i5 = i4 / 2;
        int i6 = i4 - i5;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i4];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i6);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i5, stackTraceElementArr2, i6, i5);
        return stackTraceElementArr2;
    }
}
