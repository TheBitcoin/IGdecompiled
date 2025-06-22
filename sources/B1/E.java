package b1;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.g;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import c1.C1648a;
import c1.C1649b;
import d3.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;

public final class E {

    /* renamed from: f  reason: collision with root package name */
    public static final b f8950f = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final g f8951a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Messenger f8952b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f8953c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LinkedBlockingDeque f8954d = new LinkedBlockingDeque(20);

    /* renamed from: e  reason: collision with root package name */
    private final d f8955e = new d(this);

    public static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final g f8956a;

        /* renamed from: b1.E$a$a  reason: collision with other inner class name */
        static final class C0133a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8957a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f8958b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0133a(String str, V2.d dVar) {
                super(2, dVar);
                this.f8958b = str;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0133a(this.f8958b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f8957a;
                if (i4 == 0) {
                    n.b(obj);
                    C1648a aVar = C1648a.f9655a;
                    this.f8957a = 1;
                    obj = aVar.c(this);
                    if (obj == c5) {
                        return c5;
                    }
                } else if (i4 == 1) {
                    n.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str = this.f8958b;
                for (C1649b bVar : ((Map) obj).values()) {
                    bVar.c(new C1649b.C0162b(str));
                    Log.d("SessionLifecycleClient", "Notified " + bVar.b() + " of new session " + str);
                }
                return s.f8222a;
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0133a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar) {
            super(Looper.getMainLooper());
            m.e(gVar, "backgroundDispatcher");
            this.f8956a = gVar;
        }

        private final void a(String str) {
            Log.d("SessionLifecycleClient", "Session update received: " + str);
            C1001s0 unused = C0981i.d(K.a(this.f8956a), (g) null, (L) null, new C0133a(str, (V2.d) null), 3, (Object) null);
        }

        public void handleMessage(Message message) {
            String str;
            m.e(message, NotificationCompat.CATEGORY_MESSAGE);
            if (message.what == 3) {
                Bundle data = message.getData();
                if (data == null || (str = data.getString("SessionUpdateExtra")) == null) {
                    str = "";
                }
                a(str);
                return;
            }
            Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + message);
            super.handleMessage(message);
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8959a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ E f8960b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f8961c;

        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Long.valueOf(((Message) obj).getWhen()), Long.valueOf(((Message) obj2).getWhen()));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(E e5, List list, V2.d dVar) {
            super(2, dVar);
            this.f8960b = e5;
            this.f8961c = list;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f8960b, this.f8961c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8959a;
            if (i4 == 0) {
                n.b(obj);
                C1648a aVar = C1648a.f9655a;
                this.f8959a = 1;
                obj = aVar.c(this);
                if (obj == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) obj;
            if (map.isEmpty()) {
                Log.d("SessionLifecycleClient", "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
            } else {
                Iterable values = map.values();
                if (!(values instanceof Collection) || !((Collection) values).isEmpty()) {
                    Iterator it = values.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((C1649b) it.next()).a()) {
                            E e5 = this.f8960b;
                            for (Message e6 : C1601o.W(C1601o.E(C1601o.l(this.f8960b.l(this.f8961c, 2), this.f8960b.l(this.f8961c, 1))), new a())) {
                                e5.p(e6);
                            }
                        }
                    }
                }
                Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class d implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ E f8962a;

        d(E e5) {
            this.f8962a = e5;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("SessionLifecycleClient", "Connected to SessionLifecycleService. Queue size " + this.f8962a.f8954d.size());
            this.f8962a.f8952b = new Messenger(iBinder);
            this.f8962a.f8953c = true;
            E e5 = this.f8962a;
            C1001s0 unused = e5.o(e5.j());
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
            this.f8962a.f8952b = null;
            this.f8962a.f8953c = false;
        }
    }

    public E(g gVar) {
        m.e(gVar, "backgroundDispatcher");
        this.f8951a = gVar;
    }

    /* access modifiers changed from: private */
    public final List j() {
        ArrayList arrayList = new ArrayList();
        this.f8954d.drainTo(arrayList);
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.os.Message} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Message l(java.util.List r7, int r8) {
        /*
            r6 = this;
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x000b:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r7.next()
            r2 = r1
            android.os.Message r2 = (android.os.Message) r2
            int r2 = r2.what
            if (r2 != r8) goto L_0x000b
            r0.add(r1)
            goto L_0x000b
        L_0x0020:
            java.util.Iterator r7 = r0.iterator()
            boolean r8 = r7.hasNext()
            if (r8 != 0) goto L_0x002c
            r7 = 0
            goto L_0x0057
        L_0x002c:
            java.lang.Object r8 = r7.next()
            boolean r0 = r7.hasNext()
            if (r0 != 0) goto L_0x0038
        L_0x0036:
            r7 = r8
            goto L_0x0057
        L_0x0038:
            r0 = r8
            android.os.Message r0 = (android.os.Message) r0
            long r0 = r0.getWhen()
        L_0x003f:
            java.lang.Object r2 = r7.next()
            r3 = r2
            android.os.Message r3 = (android.os.Message) r3
            long r3 = r3.getWhen()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0050
            r8 = r2
            r0 = r3
        L_0x0050:
            boolean r2 = r7.hasNext()
            if (r2 != 0) goto L_0x003f
            goto L_0x0036
        L_0x0057:
            android.os.Message r7 = (android.os.Message) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b1.E.l(java.util.List, int):android.os.Message");
    }

    private final void m(Message message) {
        if (this.f8954d.offer(message)) {
            Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + this.f8954d.size());
            return;
        }
        Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
    }

    private final void n(int i4) {
        List j4 = j();
        Message obtain = Message.obtain((Handler) null, i4, 0, 0);
        m.d(obtain, "obtain(null, messageCode, 0, 0)");
        j4.add(obtain);
        o(j4);
    }

    /* access modifiers changed from: private */
    public final C1001s0 o(List list) {
        return C0981i.d(K.a(this.f8951a), (g) null, (L) null, new c(this, list, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void p(Message message) {
        if (this.f8952b != null) {
            try {
                Log.d("SessionLifecycleClient", "Sending lifecycle " + message.what + " to service");
                Messenger messenger = this.f8952b;
                if (messenger != null) {
                    messenger.send(message);
                }
            } catch (RemoteException e5) {
                Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e5);
                m(message);
            }
        } else {
            m(message);
        }
    }

    public final void h() {
        n(2);
    }

    public final void i(G g4) {
        m.e(g4, "sessionLifecycleServiceBinder");
        g4.a(new Messenger(new a(this.f8951a)), this.f8955e);
    }

    public final void k() {
        n(1);
    }
}
