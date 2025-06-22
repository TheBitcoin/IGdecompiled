package androidx.datastore.core;

import V2.d;
import d3.p;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class DataMigrationInitializer<T> {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> java.lang.Object runMigrations(java.util.List<? extends androidx.datastore.core.DataMigration<T>> r7, androidx.datastore.core.InitializerApi<T> r8, V2.d r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r7 = r0.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.L$0
                kotlin.jvm.internal.C r8 = (kotlin.jvm.internal.C) r8
                R2.n.b(r9)     // Catch:{ all -> 0x0034 }
                goto L_0x006b
            L_0x0034:
                r9 = move-exception
                goto L_0x0084
            L_0x0036:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x003e:
                java.lang.Object r7 = r0.L$0
                java.util.List r7 = (java.util.List) r7
                R2.n.b(r9)
                goto L_0x0060
            L_0x0046:
                R2.n.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r2 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.L$0 = r9
                r0.label = r4
                java.lang.Object r7 = r8.updateData(r2, r0)
                if (r7 != r1) goto L_0x005f
                goto L_0x0083
            L_0x005f:
                r7 = r9
            L_0x0060:
                kotlin.jvm.internal.C r8 = new kotlin.jvm.internal.C
                r8.<init>()
                java.lang.Iterable r7 = (java.lang.Iterable) r7
                java.util.Iterator r7 = r7.iterator()
            L_0x006b:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L_0x0094
                java.lang.Object r9 = r7.next()
                d3.l r9 = (d3.l) r9
                r0.L$0 = r8     // Catch:{ all -> 0x0034 }
                r0.L$1 = r7     // Catch:{ all -> 0x0034 }
                r0.label = r3     // Catch:{ all -> 0x0034 }
                java.lang.Object r9 = r9.invoke(r0)     // Catch:{ all -> 0x0034 }
                if (r9 != r1) goto L_0x006b
            L_0x0083:
                return r1
            L_0x0084:
                java.lang.Object r2 = r8.f20968a
                if (r2 != 0) goto L_0x008b
                r8.f20968a = r9
                goto L_0x006b
            L_0x008b:
                kotlin.jvm.internal.m.b(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                R2.a.a(r2, r9)
                goto L_0x006b
            L_0x0094:
                java.lang.Object r7 = r8.f20968a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L_0x009d
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x009d:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.runMigrations(java.util.List, androidx.datastore.core.InitializerApi, V2.d):java.lang.Object");
        }

        public final <T> p getInitializer(List<? extends DataMigration<T>> list) {
            m.e(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, (d) null);
        }

        private Companion() {
        }
    }
}
