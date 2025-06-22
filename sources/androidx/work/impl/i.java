package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import java.util.List;
import java.util.Set;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f1067a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f1068b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f1069c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f1070d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1071e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Set f1072f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1073g;

    public /* synthetic */ i(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z4) {
        this.f1067a = workDatabase;
        this.f1068b = workSpec;
        this.f1069c = workSpec2;
        this.f1070d = list;
        this.f1071e = str;
        this.f1072f = set;
        this.f1073g = z4;
    }

    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$2(this.f1067a, this.f1068b, this.f1069c, this.f1070d, this.f1071e, this.f1072f, this.f1073g);
    }
}
