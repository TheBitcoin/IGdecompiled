package j$.time.zone;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final CopyOnWriteArrayList f5082b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap f5083c = new ConcurrentHashMap(512, 0.75f, 2);

    /* renamed from: a  reason: collision with root package name */
    public final Set f5084a;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        f5082b = copyOnWriteArrayList;
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new h(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    public static f a(String str) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentHashMap concurrentHashMap = f5083c;
        i iVar = (i) concurrentHashMap.get(str);
        if (iVar == null) {
            if (concurrentHashMap.isEmpty()) {
                throw new RuntimeException("No time-zone data files registered");
            }
            throw new RuntimeException("Unknown time-zone ID: " + str);
        } else if (iVar.f5084a.contains(str)) {
            return new f(TimeZone.getTimeZone(str));
        } else {
            throw new RuntimeException("Not a built-in time zone: " + str);
        }
    }

    public static void b(i iVar) {
        Objects.requireNonNull(iVar, "provider");
        synchronized (i.class) {
            try {
                for (String str : iVar.f5084a) {
                    Objects.requireNonNull(str, "zoneId");
                    if (((i) f5083c.putIfAbsent(str, iVar)) != null) {
                        throw new RuntimeException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + iVar);
                    }
                }
                Collections.unmodifiableSet(new HashSet(f5083c.keySet()));
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        f5082b.add(iVar);
    }

    public i() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(add);
        }
        this.f5084a = Collections.unmodifiableSet(linkedHashSet);
    }
}
