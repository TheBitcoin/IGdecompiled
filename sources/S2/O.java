package S2;

import T2.h;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.m;

abstract class O {
    public static Set a(Set set) {
        m.e(set, "builder");
        return ((h) set).h();
    }

    public static Set b() {
        return new h();
    }

    public static Set c(Object obj) {
        Set singleton = Collections.singleton(obj);
        m.d(singleton, "singleton(...)");
        return singleton;
    }
}
