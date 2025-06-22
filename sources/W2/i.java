package w2;

import android.content.Context;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.m;
import u2.z;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f22032a = new i();

    private i() {
    }

    private final float a(float f4) {
        float f5 = f4 / 2.0f;
        if (((double) f5) < 0.5d) {
            return 0.5f;
        }
        return f5;
    }

    private final float b(float f4) {
        if (f4 <= 2.0f) {
            return f4 + ((float) 2);
        }
        return f4;
    }

    public final float c(Context context) {
        m.e(context, "context");
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = 0.5f;
        if (f4 > 3.0f) {
            f4 = 3.0f;
        } else if (f4 > 2.0f) {
            f4 -= 0.75f;
        } else if (f4 > 1.0f) {
            f4 -= 0.5f;
        }
        if (((double) f4) >= 0.5d) {
            f5 = f4;
        }
        int k4 = a.f18818a.k(context);
        if (k4 == 0) {
            return a(f5);
        }
        if (k4 != 1) {
            if (k4 == 2 && UptodownApp.f17422D.S(context)) {
                return b(f5);
            }
        } else if (!z.f21956a.c()) {
            return a(f5);
        } else {
            if (UptodownApp.f17422D.S(context)) {
                return b(f5);
            }
        }
        return f5;
    }
}
