package androidx.room;

import java.util.List;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f1002a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f1004c;

    public /* synthetic */ o(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.f1002a = queryInterceptorDatabase;
        this.f1003b = str;
        this.f1004c = list;
    }

    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$11(this.f1002a, this.f1003b, this.f1004c);
    }
}
