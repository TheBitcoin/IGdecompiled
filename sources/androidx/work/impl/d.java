package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.List;
import java.util.concurrent.Executor;

public final /* synthetic */ class d implements ExecutionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Executor f1058a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f1059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Configuration f1060c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f1061d;

    public /* synthetic */ d(Executor executor, List list, Configuration configuration, WorkDatabase workDatabase) {
        this.f1058a = executor;
        this.f1059b = list;
        this.f1060c = configuration;
        this.f1061d = workDatabase;
    }

    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z4) {
        this.f1058a.execute(new e(this.f1059b, workGenerationalId, this.f1060c, this.f1061d));
    }
}
