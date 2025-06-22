package v0;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import y0.C2420j;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21970a;

    /* renamed from: b  reason: collision with root package name */
    private b f21971b = null;

    private class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f21972a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f21973b;

        private b() {
            int p4 = C2420j.p(f.this.f21970a, "com.google.firebase.crashlytics.unity_version", TypedValues.Custom.S_STRING);
            if (p4 != 0) {
                this.f21972a = "Unity";
                String string = f.this.f21970a.getResources().getString(p4);
                this.f21973b = string;
                g f4 = g.f();
                f4.i("Unity Editor version is: " + string);
            } else if (f.this.c("flutter_assets/NOTICES.Z")) {
                this.f21972a = "Flutter";
                this.f21973b = null;
                g.f().i("Development platform is: Flutter");
            } else {
                this.f21972a = null;
                this.f21973b = null;
            }
        }
    }

    public f(Context context) {
        this.f21970a = context;
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f21970a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f21970a.getAssets().open(str);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.f21971b == null) {
            this.f21971b = new b();
        }
        return this.f21971b;
    }

    public String d() {
        return f().f21972a;
    }

    public String e() {
        return f().f21973b;
    }
}
