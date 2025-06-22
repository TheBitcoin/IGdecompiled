package androidx.room.migration;

import d3.l;
import kotlin.jvm.internal.m;

public final class MigrationKt {
    public static final Migration Migration(int i4, int i5, l lVar) {
        m.e(lVar, "migrate");
        return new MigrationImpl(i4, i5, lVar);
    }
}
