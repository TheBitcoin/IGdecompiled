package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

public final /* synthetic */ class Y implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f10981a;

    public /* synthetic */ Y(MaterialDynamicColors materialDynamicColors) {
        this.f10981a = materialDynamicColors;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f10981a.errorContainer();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
