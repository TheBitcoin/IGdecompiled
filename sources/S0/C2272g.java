package s0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: s0.g  reason: case insensitive filesystem */
public final class C2272g {

    /* renamed from: a  reason: collision with root package name */
    private final Object f21717a;

    /* renamed from: b  reason: collision with root package name */
    private final c f21718b;

    /* renamed from: s0.g$b */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f21719a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f21719a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f21719a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        /* renamed from: c */
        public List a(Context context) {
            Bundle b5 = b(context);
            if (b5 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            for (String next : b5.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b5.get(next)) && next.startsWith("com.google.firebase.components:")) {
                    arrayList.add(next.substring(31));
                }
            }
            return arrayList;
        }

        private b(Class cls) {
            this.f21719a = cls;
        }
    }

    /* renamed from: s0.g$c */
    interface c {
        List a(Object obj);
    }

    C2272g(Object obj, c cVar) {
        this.f21717a = obj;
        this.f21718b = cVar;
    }

    public static C2272g c(Context context, Class cls) {
        return new C2272g(context, new b(cls));
    }

    /* access modifiers changed from: private */
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
            throw new w(String.format("Class %s is not an instance of %s", new Object[]{str, "com.google.firebase.components.ComponentRegistrar"}));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{str}));
            return null;
        } catch (IllegalAccessException e5) {
            throw new w(String.format("Could not instantiate %s.", new Object[]{str}), e5);
        } catch (InstantiationException e6) {
            throw new w(String.format("Could not instantiate %s.", new Object[]{str}), e6);
        } catch (NoSuchMethodException e7) {
            throw new w(String.format("Could not instantiate %s", new Object[]{str}), e7);
        } catch (InvocationTargetException e8) {
            throw new w(String.format("Could not instantiate %s", new Object[]{str}), e8);
        }
    }

    public List b() {
        ArrayList arrayList = new ArrayList();
        for (String fVar : this.f21718b.a(this.f21717a)) {
            arrayList.add(new C2271f(fVar));
        }
        return arrayList;
    }
}
