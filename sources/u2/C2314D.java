package u2;

import android.content.Context;
import com.uptodown.UptodownApp;
import g0.a;
import kotlin.jvm.internal.m;

/* renamed from: u2.D  reason: case insensitive filesystem */
public final class C2314D {
    public final void a(Context context) {
        m.e(context, "context");
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (!aVar.u()) {
            aVar.D0(true);
            try {
                a.a(context);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
