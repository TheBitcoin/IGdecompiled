package androidx.room;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1000a;

    public /* synthetic */ m(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f1000a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.setTransactionSuccessful$lambda$5(this.f1000a);
    }
}
