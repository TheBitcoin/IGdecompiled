package androidx.room;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f1013a;

    public /* synthetic */ t(QueryInterceptorStatement queryInterceptorStatement) {
        this.f1013a = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.executeInsert$lambda$2(this.f1013a);
    }
}
