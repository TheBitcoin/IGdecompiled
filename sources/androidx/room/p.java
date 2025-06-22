package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1005a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f1006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f1007c;

    public /* synthetic */ p(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f1005a = queryInterceptorDatabase;
        this.f1006b = supportSQLiteQuery;
        this.f1007c = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$8(this.f1005a, this.f1006b, this.f1007c);
    }
}
