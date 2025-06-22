package androidx.room;

import V2.d;
import V2.e;
import W2.b;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C0988l0;
import o3.C0991n;
import o3.L;
import r3.C1035e;
import r3.C1037g;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final <R> C1035e createFlow(RoomDatabase roomDatabase, boolean z4, String[] strArr, Callable<R> callable) {
            m.e(roomDatabase, "db");
            m.e(strArr, "tableNames");
            m.e(callable, "callable");
            return C1037g.r(new CoroutinesRoom$Companion$createFlow$1(z4, roomDatabase, strArr, callable, (d) null));
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z4, Callable<R> callable, d dVar) {
            e eVar;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (eVar = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                eVar = z4 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return C0977g.g(eVar, new CoroutinesRoom$Companion$execute$2(callable, (d) null), dVar);
        }

        private Companion() {
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z4, CancellationSignal cancellationSignal, Callable<R> callable, d dVar) {
            e transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z4 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            e eVar = transactionDispatcher;
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            nVar.q(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, C0981i.d(C0988l0.f3711a, eVar, (L) null, new CoroutinesRoom$Companion$execute$4$job$1(callable, nVar, (d) null), 2, (Object) null)));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar);
            }
            return v4;
        }
    }

    private CoroutinesRoom() {
    }

    public static final <R> C1035e createFlow(RoomDatabase roomDatabase, boolean z4, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z4, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z4, CancellationSignal cancellationSignal, Callable<R> callable, d dVar) {
        return Companion.execute(roomDatabase, z4, cancellationSignal, callable, dVar);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z4, Callable<R> callable, d dVar) {
        return Companion.execute(roomDatabase, z4, callable, dVar);
    }
}
