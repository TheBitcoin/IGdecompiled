package androidx.room;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f991a;

    public /* synthetic */ h(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f991a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListenerNonExclusive$lambda$3(this.f991a);
    }
}
