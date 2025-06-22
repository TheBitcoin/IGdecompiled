package androidx.room;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorStatement f1012a;

    public /* synthetic */ s(QueryInterceptorStatement queryInterceptorStatement) {
        this.f1012a = queryInterceptorStatement;
    }

    public final void run() {
        QueryInterceptorStatement.simpleQueryForLong$lambda$3(this.f1012a);
    }
}
