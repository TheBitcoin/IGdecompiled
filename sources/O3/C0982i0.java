package o3;

import V2.b;
import V2.g;
import d3.l;
import java.io.Closeable;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.n;

/* renamed from: o3.i0  reason: case insensitive filesystem */
public abstract class C0982i0 extends G implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3707a = new a((C2103g) null);

    /* renamed from: o3.i0$a */
    public static final class a extends b {

        /* renamed from: o3.i0$a$a  reason: collision with other inner class name */
        static final class C0031a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0031a f3708a = new C0031a();

            C0031a() {
                super(1);
            }

            /* renamed from: a */
            public final C0982i0 invoke(g.b bVar) {
                if (bVar instanceof C0982i0) {
                    return (C0982i0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
            super(G.Key, C0031a.f3708a);
        }
    }
}
