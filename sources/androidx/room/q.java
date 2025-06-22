package androidx.room;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1008a;

    public /* synthetic */ q(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f1008a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f1008a);
    }
}
