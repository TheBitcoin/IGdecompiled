package androidx.room;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f990a;

    public /* synthetic */ g(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f990a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.endTransaction$lambda$4(this.f990a);
    }
}
