package r;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: r.k  reason: case insensitive filesystem */
class C1028k implements C1022e {

    /* renamed from: a  reason: collision with root package name */
    private final a f4131a;

    /* renamed from: b  reason: collision with root package name */
    private final C1026i f4132b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f4133c;

    /* renamed from: r.k$a */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4134a;

        /* renamed from: b  reason: collision with root package name */
        private Map f4135b = null;

        a(Context context) {
            this.f4134a = context;
        }

        private Map a(Context context) {
            Bundle d5 = d(context);
            if (d5 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.EMPTY_MAP;
            }
            HashMap hashMap = new HashMap();
            for (String next : d5.keySet()) {
                Object obj = d5.get(next);
                if ((obj instanceof String) && next.startsWith("backend:")) {
                    for (String trim : ((String) obj).split(",", -1)) {
                        String trim2 = trim.trim();
                        if (!trim2.isEmpty()) {
                            hashMap.put(trim2, next.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map c() {
            if (this.f4135b == null) {
                this.f4135b = a(this.f4134a);
            }
            return this.f4135b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public C1021d b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (C1021d) Class.forName(str2).asSubclass(C1021d.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            } catch (ClassNotFoundException e5) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", new Object[]{str2}), e5);
                return null;
            } catch (IllegalAccessException e6) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e6);
                return null;
            } catch (InstantiationException e7) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", new Object[]{str2}), e7);
                return null;
            } catch (NoSuchMethodException e8) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e8);
                return null;
            } catch (InvocationTargetException e9) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", new Object[]{str2}), e9);
                return null;
            }
        }
    }

    C1028k(Context context, C1026i iVar) {
        this(new a(context), iVar);
    }

    public synchronized C1030m get(String str) {
        if (this.f4133c.containsKey(str)) {
            return (C1030m) this.f4133c.get(str);
        }
        C1021d b5 = this.f4131a.b(str);
        if (b5 == null) {
            return null;
        }
        C1030m create = b5.create(this.f4132b.a(str));
        this.f4133c.put(str, create);
        return create;
    }

    C1028k(a aVar, C1026i iVar) {
        this.f4133c = new HashMap();
        this.f4131a = aVar;
        this.f4132b = iVar;
    }
}
