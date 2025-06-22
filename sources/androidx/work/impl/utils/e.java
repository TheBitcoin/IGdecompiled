package androidx.work.impl.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdGenerator f1084a;

    public /* synthetic */ e(IdGenerator idGenerator) {
        this.f1084a = idGenerator;
    }

    public final Object call() {
        return IdGenerator.nextAlarmManagerId$lambda$1(this.f1084a);
    }
}
