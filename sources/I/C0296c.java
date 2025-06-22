package I;

import a0.a;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import j$.util.Objects;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;

/* renamed from: I.c  reason: case insensitive filesystem */
public class C0296c {

    /* renamed from: h  reason: collision with root package name */
    private static int f244h;

    /* renamed from: i  reason: collision with root package name */
    private static PendingIntent f245i;

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f246j = G.f238a;

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f247k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: a  reason: collision with root package name */
    private final SimpleArrayMap f248a = new SimpleArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f249b;

    /* renamed from: c  reason: collision with root package name */
    private final E f250c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f251d;

    /* renamed from: e  reason: collision with root package name */
    private final Messenger f252e;

    /* renamed from: f  reason: collision with root package name */
    private Messenger f253f;

    /* renamed from: g  reason: collision with root package name */
    private l f254g;

    public C0296c(Context context) {
        this.f249b = context;
        this.f250c = new E(context);
        this.f252e = new Messenger(new i(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f251d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ C0937l e(Bundle bundle) {
        if (m(bundle)) {
            return C0940o.e((Object) null);
        }
        return C0940o.e(bundle);
    }

    static /* bridge */ /* synthetic */ void g(C0296c cVar, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new k());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof l) {
                        cVar.f254g = (l) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        cVar.f253f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                        if (stringExtra2 == null) {
                            Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !Objects.equals(split[1], "ID")) {
                                Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
                                return;
                            }
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(":")) {
                                str2 = str2.substring(1);
                            }
                            cVar.l(str, intent2.putExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2).getExtras());
                            return;
                        }
                        synchronized (cVar.f248a) {
                            int i4 = 0;
                            while (i4 < cVar.f248a.size()) {
                                try {
                                    cVar.l((String) cVar.f248a.keyAt(i4), intent2.getExtras());
                                    i4++;
                                } finally {
                                }
                            }
                        }
                        return;
                    }
                    Matcher matcher = f247k.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            cVar.l(group, extras);
                            return;
                        }
                        return;
                    } else if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    private final C0937l i(Bundle bundle) {
        String j4 = j();
        C0938m mVar = new C0938m();
        synchronized (this.f248a) {
            this.f248a.put(j4, mVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f250c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        k(this.f249b, intent);
        intent.putExtra("kid", "|ID|" + j4 + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f252e);
        if (!(this.f253f == null && this.f254g == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f253f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.f254g.b(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            mVar.a().b(f246j, new C0301h(this, j4, this.f251d.schedule(new C0300g(mVar), 30, TimeUnit.SECONDS)));
            return mVar.a();
        }
        if (this.f250c.b() == 2) {
            this.f249b.sendBroadcast(intent);
        } else {
            this.f249b.startService(intent);
        }
        mVar.a().b(f246j, new C0301h(this, j4, this.f251d.schedule(new C0300g(mVar), 30, TimeUnit.SECONDS)));
        return mVar.a();
    }

    private static synchronized String j() {
        String num;
        synchronized (C0296c.class) {
            int i4 = f244h;
            f244h = i4 + 1;
            num = Integer.toString(i4);
        }
        return num;
    }

    private static synchronized void k(Context context, Intent intent) {
        synchronized (C0296c.class) {
            try {
                if (f245i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f245i = PendingIntent.getBroadcast(context, 0, intent2, a.f662a);
                }
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, f245i);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private final void l(String str, Bundle bundle) {
        synchronized (this.f248a) {
            try {
                C0938m mVar = (C0938m) this.f248a.remove(str);
                if (mVar == null) {
                    Log.w("Rpc", "Missing callback for " + str);
                    return;
                }
                mVar.c(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean m(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("google.messenger")) {
            return false;
        }
        return true;
    }

    public C0937l a() {
        if (this.f250c.a() >= 241100000) {
            return D.b(this.f249b).d(5, Bundle.EMPTY).g(f246j, C0299f.f256a);
        }
        return C0940o.d(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public C0937l b(C0294a aVar) {
        if (this.f250c.a() < 233700000) {
            return C0940o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", aVar.g());
        Integer h4 = aVar.h();
        if (h4 != null) {
            bundle.putInt("google.product_id", h4.intValue());
        }
        return D.b(this.f249b).c(3, bundle);
    }

    public C0937l c(Bundle bundle) {
        if (this.f250c.a() >= 12000000) {
            return D.b(this.f249b).d(1, bundle).g(f246j, C0298e.f255a);
        }
        if (this.f250c.b() != 0) {
            return i(bundle).h(f246j, new H(this, bundle));
        }
        return C0940o.d(new IOException("MISSING_INSTANCEID_SERVICE"));
    }

    public C0937l d(boolean z4) {
        if (this.f250c.a() < 241100000) {
            return C0940o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z4);
        return D.b(this.f249b).c(4, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C0937l f(Bundle bundle, C0937l lVar) {
        if (lVar.n() && m((Bundle) lVar.j())) {
            return i(bundle).o(f246j, F.f237a);
        }
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, C0937l lVar) {
        synchronized (this.f248a) {
            this.f248a.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
