package androidx.core.os;

import android.os.Trace;
import d3.a;
import kotlin.jvm.internal.l;

public final class TraceKt {
    public static final <T> T trace(String str, a aVar) {
        Trace.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            l.b(1);
            Trace.endSection();
            l.a(1);
        }
    }
}
