package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1062a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f1063b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Configuration f1064c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f1065d;

    public /* synthetic */ e(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        this.f1062a = list;
        this.f1063b = workGenerationalId;
        this.f1064c = configuration;
        this.f1065d = workDatabase;
    }

    public final void run() {
        Schedulers.b(this.f1062a, this.f1063b, this.f1064c, this.f1065d);
    }
}
