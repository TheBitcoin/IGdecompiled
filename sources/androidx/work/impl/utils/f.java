package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f1085a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1087c;

    public /* synthetic */ f(IdGenerator idGenerator, int i4, int i5) {
        this.f1085a = idGenerator;
        this.f1086b = i4;
        this.f1087c = i5;
    }

    public final Object call() {
        return IdGenerator.nextJobSchedulerIdWithRange$lambda$0(this.f1085a, this.f1086b, this.f1087c);
    }
}
