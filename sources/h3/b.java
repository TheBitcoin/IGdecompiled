package h3;

import java.util.Random;
import kotlin.jvm.internal.m;

public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a f20860c = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random d() {
        Object obj = this.f20860c.get();
        m.d(obj, "get(...)");
        return (Random) obj;
    }
}
