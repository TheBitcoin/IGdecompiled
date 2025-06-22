package androidx.datastore.core;

import V2.d;
import d3.l;
import d3.p;
import r3.C1035e;

public interface InterProcessCoordinator {
    C1035e getUpdateNotifications();

    Object getVersion(d dVar);

    Object incrementAndGetVersion(d dVar);

    <T> Object lock(l lVar, d dVar);

    <T> Object tryLock(p pVar, d dVar);
}
