package androidx.work.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f1046a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1048c;

    public /* synthetic */ b(Processor processor, ArrayList arrayList, String str) {
        this.f1046a = processor;
        this.f1047b = arrayList;
        this.f1048c = str;
    }

    public final Object call() {
        return this.f1047b.addAll(this.f1046a.mWorkDatabase.workTagDao().getTagsForWorkSpecId(this.f1048c));
    }
}
