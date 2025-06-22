package androidx.room;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f1015a;

    public /* synthetic */ v(QueryInterceptorStatement queryInterceptorStatement) {
        this.f1015a = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.execute$lambda$0(this.f1015a);
    }
}
