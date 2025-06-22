package androidx.room;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f999a;

    public /* synthetic */ l(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f999a = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransaction$lambda$0(this.f999a);
    }
}
