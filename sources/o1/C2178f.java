package o1;

import j$.util.Collection$EL;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: o1.f  reason: case insensitive filesystem */
public abstract class C2178f {

    /* renamed from: a  reason: collision with root package name */
    public static List f21385a = ((List) Collection$EL.stream(new ArrayList(f21386b.keySet())).sorted().map(new C2177e()).collect(Collectors.toList()));

    /* renamed from: b  reason: collision with root package name */
    public static Map f21386b;

    static {
        HashMap hashMap = new HashMap();
        f21386b = hashMap;
        hashMap.put(Integer.valueOf(C2180h.f21393d), C2180h.f21395f);
        f21386b.put(Integer.valueOf(C2179g.f21387d), C2179g.f21389f);
        f21386b.put(Integer.valueOf(C2187o.f21423b), C2187o.f21425d);
        f21386b.put(Integer.valueOf(C2184l.f21411d), C2184l.f21413f);
        f21386b.put(Integer.valueOf(C2181i.f21399d), C2181i.f21401f);
        f21386b.put(Integer.valueOf(C2186n.f21419d), C2186n.f21421f);
        f21386b.put(Integer.valueOf(C2182j.f21403d), C2182j.f21405f);
        f21386b.put(Integer.valueOf(C2185m.f21415d), C2185m.f21417f);
        f21386b.put(Integer.valueOf(C2183k.f21407d), C2183k.f21409f);
    }

    public static /* synthetic */ String a(Integer num) {
        return (String) f21386b.get(num);
    }
}
