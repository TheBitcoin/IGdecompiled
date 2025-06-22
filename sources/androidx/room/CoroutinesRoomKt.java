package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import kotlin.jvm.internal.m;
import o3.C0986k0;
import o3.G;

public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final G getQueryDispatcher(RoomDatabase roomDatabase) {
        m.e(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            obj = C0986k0.a(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", obj);
        }
        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (G) obj;
    }

    public static final G getTransactionDispatcher(RoomDatabase roomDatabase) {
        m.e(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            obj = C0986k0.a(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (G) obj;
    }
}
