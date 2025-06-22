package androidx.room;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f1016a;

    public /* synthetic */ w(QueryInterceptorStatement queryInterceptorStatement) {
        this.f1016a = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.executeUpdateDelete$lambda$1(this.f1016a);
    }
}
