package androidx.room;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f992a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f993b;

    public /* synthetic */ i(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f992a = queryInterceptorDatabase;
        this.f993b = str;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$6(this.f992a, this.f993b);
    }
}
