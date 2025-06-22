package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.sessions.c;
import d1.f;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class SessionLifecycleService extends Service {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11438d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final HandlerThread f11439a = new HandlerThread("FirebaseSessions_HandlerThread");

    /* renamed from: b  reason: collision with root package name */
    private b f11440b;

    /* renamed from: c  reason: collision with root package name */
    private Messenger f11441c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11442a;

        /* renamed from: b  reason: collision with root package name */
        private long f11443b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f11444c = new ArrayList();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            m.e(looper, "looper");
        }

        private final void a() {
            StringBuilder sb = new StringBuilder();
            sb.append("Broadcasting new session: ");
            c.b bVar = c.f11449f;
            sb.append(bVar.a().c());
            Log.d("SessionLifecycleService", sb.toString());
            b.f11447a.a().a(bVar.a().c());
            ArrayList arrayList = new ArrayList(this.f11444c);
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                Messenger messenger = (Messenger) obj;
                m.d(messenger, "it");
                f(messenger);
            }
        }

        private final void b(Message message) {
            Log.d("SessionLifecycleService", "Activity backgrounding at " + message.getWhen());
            this.f11443b = message.getWhen();
        }

        private final void c(Message message) {
            this.f11444c.add(message.replyTo);
            Messenger messenger = message.replyTo;
            m.d(messenger, "msg.replyTo");
            f(messenger);
            Log.d("SessionLifecycleService", "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + this.f11444c.size());
        }

        private final void d(Message message) {
            Log.d("SessionLifecycleService", "Activity foregrounding at " + message.getWhen() + '.');
            if (!this.f11442a) {
                Log.d("SessionLifecycleService", "Cold start detected.");
                this.f11442a = true;
                g();
            } else if (e(message.getWhen())) {
                Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                g();
            }
            this.f11443b = message.getWhen();
        }

        private final boolean e(long j4) {
            if (j4 - this.f11443b > n3.a.l(f.f19560c.c().c())) {
                return true;
            }
            return false;
        }

        private final void f(Messenger messenger) {
            if (this.f11442a) {
                h(messenger, c.f11449f.a().c().b());
                return;
            }
            String a5 = a.f11445a.a().a();
            Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session: " + a5);
            if (a5 != null) {
                h(messenger, a5);
            }
        }

        private final void g() {
            c.b bVar = c.f11449f;
            bVar.a().a();
            Log.d("SessionLifecycleService", "Generated new session " + bVar.a().c().b());
            a();
            a.f11445a.a().b(bVar.a().c().b());
        }

        private final void h(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", str);
                Message obtain = Message.obtain((Handler) null, 3, 0, 0);
                obtain.setData(bundle);
                messenger.send(obtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
                this.f11444c.remove(messenger);
            } catch (Exception e5) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + '.', e5);
            }
        }

        public void handleMessage(Message message) {
            m.e(message, NotificationCompat.CATEGORY_MESSAGE);
            if (this.f11443b > message.getWhen()) {
                Log.d("SessionLifecycleService", "Ignoring old message from " + message.getWhen() + " which is older than " + this.f11443b + '.');
                return;
            }
            int i4 = message.what;
            if (i4 == 1) {
                d(message);
            } else if (i4 == 2) {
                b(message);
            } else if (i4 != 4) {
                Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + message);
                super.handleMessage(message);
            } else {
                c(message);
            }
        }
    }

    private final Messenger a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class);
        }
        return (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger a5 = a(intent);
        if (a5 != null) {
            Message obtain = Message.obtain((Handler) null, 4, 0, 0);
            obtain.replyTo = a5;
            b bVar = this.f11440b;
            if (bVar != null) {
                bVar.sendMessage(obtain);
            }
        }
        Messenger messenger = this.f11441c;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f11439a.start();
        Looper looper = this.f11439a.getLooper();
        m.d(looper, "handlerThread.looper");
        this.f11440b = new b(looper);
        this.f11441c = new Messenger(this.f11440b);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f11439a.quit();
    }
}
