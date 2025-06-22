package androidx.room;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import d3.p;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import q3.a;
import r3.C1036f;

@f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {110}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$createFlow$1 extends l implements p {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    @f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {136}, m = "invokeSuspend")
    /* renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        private /* synthetic */ Object L$0;
        int label;

        public final d create(Object obj, d dVar) {
            AnonymousClass1 r02 = new AnonymousClass1(z4, roomDatabase, fVar, strArr, callable, dVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invokeSuspend(Object obj) {
            g gVar;
            Object c5 = b.c();
            int i4 = this.label;
            if (i4 == 0) {
                n.b(obj);
                J j4 = (J) this.L$0;
                final q3.d b5 = q3.g.b(-1, (a) null, (d3.l) null, 6, (Object) null);
                final CoroutinesRoom$Companion$createFlow$1$1$observer$1 coroutinesRoom$Companion$createFlow$1$1$observer$1 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(strArr, b5);
                b5.B(s.f8222a);
                TransactionElement transactionElement = (TransactionElement) j4.getCoroutineContext().get(TransactionElement.Key);
                if (transactionElement == null || (gVar = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                    if (z4) {
                        gVar = CoroutinesRoomKt.getTransactionDispatcher(roomDatabase);
                    } else {
                        gVar = CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
                    }
                }
                final q3.d b6 = q3.g.b(0, (a) null, (d3.l) null, 7, (Object) null);
                final RoomDatabase roomDatabase = roomDatabase;
                final Callable<R> callable = callable;
                C1001s0 unused = C0981i.d(j4, gVar, (L) null, new p((d) null) {
                    Object L$0;
                    int label;

                    public final d create(Object obj, d dVar) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        CoroutinesRoom$Companion$createFlow$1(boolean z4, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, d dVar) {
                            super(2, dVar);
                            this.$inTransaction = z4;
                            this.$db = roomDatabase;
                            this.$tableNames = strArr;
                            this.$callable = callable;
                        }

                        public final d create(Object obj, d dVar) {
                            CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, dVar);
                            coroutinesRoom$Companion$createFlow$1.L$0 = obj;
                            return coroutinesRoom$Companion$createFlow$1;
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object c5 = b.c();
                            int i4 = this.label;
                            if (i4 == 0) {
                                n.b(obj);
                                final C1036f fVar = (C1036f) this.L$0;
                                final boolean z4 = this.$inTransaction;
                                final RoomDatabase roomDatabase = this.$db;
                                final String[] strArr = this.$tableNames;
                                final Callable<R> callable = this.$callable;
                                AnonymousClass1 r32 = new AnonymousClass1((d) null);
                                this.label = 1;
                                if (K.d(r32, this) == c5) {
                                    return c5;
                                }
                            } else if (i4 == 1) {
                                n.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return s.f8222a;
                        }

                        public final Object invoke(C1036f fVar, d dVar) {
                            return ((CoroutinesRoom$Companion$createFlow$1) create(fVar, dVar)).invokeSuspend(s.f8222a);
                        }
                    }
