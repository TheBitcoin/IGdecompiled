package i3;

import j$.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import kotlin.jvm.internal.m;

public final class a extends h3.a {
    public Random d() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        m.d(current, "current(...)");
        return current;
    }
}
