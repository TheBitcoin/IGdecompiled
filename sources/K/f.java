package K;

import L.C0319c;
import L.h;
import L.j;
import android.os.Looper;
import com.google.android.gms.common.api.internal.C0503b;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f379a = Collections.newSetFromMap(new WeakHashMap());

    public interface a extends C0319c {
    }

    public interface b extends h {
    }

    public static Set b() {
        Set set = f379a;
        synchronized (set) {
        }
        return set;
    }

    public abstract C0503b a(C0503b bVar);

    public abstract Looper c();

    public boolean d(j jVar) {
        throw new UnsupportedOperationException();
    }

    public void e() {
        throw new UnsupportedOperationException();
    }
}
