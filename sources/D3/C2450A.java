package D3;

import E3.c;
import N3.C2514e;
import N3.C2516g;
import java.io.Closeable;

/* renamed from: D3.A  reason: case insensitive filesystem */
public abstract class C2450A implements Closeable, AutoCloseable {

    /* renamed from: D3.A$a */
    class a extends C2450A {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22858a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2516g f22859b;

        a(C2472t tVar, long j4, C2516g gVar) {
            this.f22858a = j4;
            this.f22859b = gVar;
        }

        public long a() {
            return this.f22858a;
        }

        public C2516g i() {
            return this.f22859b;
        }
    }

    public static C2450A d(C2472t tVar, long j4, C2516g gVar) {
        if (gVar != null) {
            return new a(tVar, j4, gVar);
        }
        throw new NullPointerException("source == null");
    }

    public static C2450A g(C2472t tVar, byte[] bArr) {
        return d(tVar, (long) bArr.length, new C2514e().write(bArr));
    }

    public abstract long a();

    public void close() {
        c.d(i());
    }

    public abstract C2516g i();
}
