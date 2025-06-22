package androidx.room;

import d3.l;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", l = {51, 52}, m = "withTransaction")
final class RoomDatabaseKt$withTransaction$1<R> extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    RoomDatabaseKt$withTransaction$1(V2.d dVar) {
        super(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RoomDatabaseKt.withTransaction((RoomDatabase) null, (l) null, this);
    }
}
