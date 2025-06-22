package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.measurement.q4  reason: case insensitive filesystem */
public abstract class C0653q4 {

    /* renamed from: a  reason: collision with root package name */
    private static String f2115a = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    static C0556f4 a(Class cls) {
        String str;
        Class<C0653q4> cls2 = C0653q4.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(C0556f4.class)) {
            str = f2115a;
        } else if (!cls.getPackage().equals(cls2.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        }
        try {
            a.a(Class.forName(str, true, classLoader).getConstructor((Class[]) null).newInstance((Object[]) null));
            throw null;
        } catch (NoSuchMethodException e5) {
            throw new IllegalStateException(e5);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        } catch (IllegalAccessException e7) {
            throw new IllegalStateException(e7);
        } catch (InvocationTargetException e8) {
            throw new IllegalStateException(e8);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    a.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e9) {
                    ServiceConfigurationError serviceConfigurationError = e9;
                    Logger logger = Logger.getLogger(C0520b4.class.getName());
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + simpleName, serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (C0556f4) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (C0556f4) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException(e10);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException(e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(e12);
            }
        }
    }
}
