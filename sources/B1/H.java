package b1;

import R2.s;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.sessions.SessionLifecycleService;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import p0.C2194f;

public final class H implements G {

    /* renamed from: b  reason: collision with root package name */
    private static final a f8963b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2194f f8964a;

    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public H(C2194f fVar) {
        m.e(fVar, "firebaseApp");
        this.f8964a = fVar;
    }

    private final Object b(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return s.f8222a;
        } catch (IllegalArgumentException e5) {
            return Integer.valueOf(Log.w("LifecycleServiceBinder", "Session lifecycle service binding failed.", e5));
        }
    }

    public void a(Messenger messenger, ServiceConnection serviceConnection) {
        boolean z4;
        m.e(messenger, "callback");
        m.e(serviceConnection, "serviceConnection");
        Context applicationContext = this.f8964a.k().getApplicationContext();
        m.d(applicationContext, "firebaseApp.applicationContext.applicationContext");
        Intent intent = new Intent(applicationContext, SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", messenger);
        intent.setPackage(applicationContext.getPackageName());
        try {
            z4 = applicationContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e5) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", e5);
            z4 = false;
        }
        if (!z4) {
            b(applicationContext, serviceConnection);
            Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
        }
    }
}
