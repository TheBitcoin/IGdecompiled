package androidx.room;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f994a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f995b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f996c;

    public /* synthetic */ j(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        this.f994a = queryInterceptorDatabase;
        this.f995b = str;
        this.f996c = objArr;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$7(this.f994a, this.f995b, this.f996c);
    }
}
