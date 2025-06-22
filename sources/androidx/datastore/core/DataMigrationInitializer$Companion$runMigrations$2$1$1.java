package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends l implements d3.l {
    final /* synthetic */ DataMigration<T> $migration;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$2$1$1(DataMigration<T> dataMigration, d dVar) {
        super(1, dVar);
        this.$migration = dataMigration;
    }

    public final d create(d dVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, dVar);
    }

    public final Object invoke(d dVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            DataMigration<T> dataMigration = this.$migration;
            this.label = 1;
            if (dataMigration.cleanUp(this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s.f8222a;
    }
}
