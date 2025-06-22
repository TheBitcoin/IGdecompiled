package androidx.datastore;

import N3.Q;
import android.content.Context;
import d3.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class DataStoreSingletonDelegate$getValue$1$1 extends n implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ DataStoreSingletonDelegate<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataStoreSingletonDelegate$getValue$1$1(Context context, DataStoreSingletonDelegate<T> dataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = dataStoreSingletonDelegate;
    }

    public final Q invoke() {
        Q.a aVar = Q.f23639b;
        Context context = this.$applicationContext;
        m.d(context, "applicationContext");
        String absolutePath = DataStoreFile.dataStoreFile(context, this.this$0.fileName).getAbsolutePath();
        m.d(absolutePath, "applicationContext.dataS…le(fileName).absolutePath");
        return Q.a.e(aVar, absolutePath, false, 1, (Object) null);
    }
}
