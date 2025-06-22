package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.C1117b;
import j$.time.j;
import j$.time.temporal.m;

public interface ChronoZonedDateTime<D extends C1117b> extends m, Comparable<ChronoZonedDateTime<?>> {
    long B();

    l a();

    j b();

    C1117b c();

    ZoneOffset g();

    ChronoZonedDateTime h(ZoneId zoneId);

    ZoneId r();

    Instant toInstant();

    C1120e y();
}
