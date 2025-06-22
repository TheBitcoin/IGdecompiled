package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* renamed from: androidx.room.r  reason: case insensitive filesystem */
public final /* synthetic */ class C0495r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1009a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f1010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f1011c;

    public /* synthetic */ C0495r(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f1009a = queryInterceptorDatabase;
        this.f1010b = supportSQLiteQuery;
        this.f1011c = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$9(this.f1009a, this.f1010b, this.f1011c);
    }
}
