package u2;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import kotlin.jvm.internal.C2103g;

public abstract class I {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21896a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void c() {
            Process.killProcess(Process.myPid());
        }

        public final void b() {
            new Handler(Looper.getMainLooper()).postDelayed(new H(), 1000);
        }

        private a() {
        }
    }
}
