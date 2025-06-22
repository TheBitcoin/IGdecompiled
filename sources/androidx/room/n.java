package androidx.room;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1001a;

    public /* synthetic */ n(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f1001a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionNonExclusive$lambda$1(this.f1001a);
    }
}
