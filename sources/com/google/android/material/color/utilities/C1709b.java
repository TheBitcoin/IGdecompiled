package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1709b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Hct f10984a;

    public /* synthetic */ C1709b(Hct hct) {
        this.f10984a = hct;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Double.valueOf(this.f10984a.getTone());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
