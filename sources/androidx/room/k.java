package androidx.room;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f997a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f998b;

    public /* synthetic */ k(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f997a = queryInterceptorDatabase;
        this.f998b = str;
    }

    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$10(this.f997a, this.f998b);
    }
}
