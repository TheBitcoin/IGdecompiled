package androidx.room;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.J;

@f(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabaseExt.kt", l = {59}, m = "invokeSuspend")
final class RoomDatabaseKt$withTransaction$2 extends l implements p {
    final /* synthetic */ d3.l $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt$withTransaction$2(RoomDatabase roomDatabase, d3.l lVar, d dVar) {
        super(2, dVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    public final d create(Object obj, d dVar) {
        RoomDatabaseKt$withTransaction$2 roomDatabaseKt$withTransaction$2 = new RoomDatabaseKt$withTransaction$2(this.$this_withTransaction, this.$block, dVar);
        roomDatabaseKt$withTransaction$2.L$0 = obj;
        return roomDatabaseKt$withTransaction$2;
    }

    public final Object invokeSuspend(Object obj) {
        TransactionElement transactionElement;
        Throwable th;
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            g.b bVar = ((J) this.L$0).getCoroutineContext().get(TransactionElement.Key);
            m.b(bVar);
            TransactionElement transactionElement2 = (TransactionElement) bVar;
            transactionElement2.acquire();
            try {
                this.$this_withTransaction.beginTransaction();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                transactionElement = transactionElement2;
                th = th3;
                transactionElement.release();
                throw th;
            }
            try {
                d3.l lVar = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                Object invoke = lVar.invoke(this);
                if (invoke == c5) {
                    return c5;
                }
                transactionElement = transactionElement2;
                obj = invoke;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                transactionElement = transactionElement2;
                th = th5;
                this.$this_withTransaction.endTransaction();
                throw th;
            }
        } else if (i4 == 1) {
            transactionElement = (TransactionElement) this.L$0;
            try {
                n.b(obj);
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$this_withTransaction.setTransactionSuccessful();
        try {
            this.$this_withTransaction.endTransaction();
            transactionElement.release();
            return obj;
        } catch (Throwable th7) {
            th = th7;
            transactionElement.release();
            throw th;
        }
    }

    public final Object invoke(J j4, d dVar) {
        return ((RoomDatabaseKt$withTransaction$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
