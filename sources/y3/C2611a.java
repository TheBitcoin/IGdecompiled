package Y3;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: Y3.a  reason: case insensitive filesystem */
public abstract class C2611a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0292a f24368a = new C0292a((C2103g) null);

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayList f24369b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile b[] f24370c = new b[0];

    /* renamed from: Y3.a$a  reason: collision with other inner class name */
    public static final class C0292a extends b {
        public /* synthetic */ C0292a(C2103g gVar) {
            this();
        }

        public void a(String str, Object... objArr) {
            m.e(objArr, "args");
            for (b a5 : C2611a.f24370c) {
                a5.a(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void b(Throwable th, String str, Object... objArr) {
            m.e(objArr, "args");
            for (b b5 : C2611a.f24370c) {
                b5.b(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void c(String str, Object... objArr) {
            m.e(objArr, "args");
            for (b c5 : C2611a.f24370c) {
                c5.c(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void d(Throwable th) {
            for (b d5 : C2611a.f24370c) {
                d5.d(th);
            }
        }

        public void e(Throwable th, String str, Object... objArr) {
            m.e(objArr, "args");
            for (b e5 : C2611a.f24370c) {
                e5.e(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void g(String str, Object... objArr) {
            m.e(objArr, "args");
            for (b g4 : C2611a.f24370c) {
                g4.g(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void h(String str, Object... objArr) {
            m.e(objArr, "args");
            for (b h4 : C2611a.f24370c) {
                h4.h(str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public void i(Throwable th, String str, Object... objArr) {
            m.e(objArr, "args");
            for (b i4 : C2611a.f24370c) {
                i4.i(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final b j(String str) {
            m.e(str, "tag");
            b[] a5 = C2611a.f24370c;
            int length = a5.length;
            int i4 = 0;
            while (i4 < length) {
                b bVar = a5[i4];
                i4++;
                bVar.f().set(str);
            }
            return this;
        }

        private C0292a() {
        }
    }

    /* renamed from: Y3.a$b */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal f24371a = new ThreadLocal();

        public abstract void a(String str, Object... objArr);

        public abstract void b(Throwable th, String str, Object... objArr);

        public abstract void c(String str, Object... objArr);

        public abstract void d(Throwable th);

        public abstract void e(Throwable th, String str, Object... objArr);

        public final /* synthetic */ ThreadLocal f() {
            return this.f24371a;
        }

        public abstract void g(String str, Object... objArr);

        public abstract void h(String str, Object... objArr);

        public abstract void i(Throwable th, String str, Object... objArr);
    }

    public static final b b(String str) {
        return f24368a.j(str);
    }
}
