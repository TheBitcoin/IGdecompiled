package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

public final /* synthetic */ class J1 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f10965a;

    public /* synthetic */ J1(MaterialDynamicColors materialDynamicColors) {
        this.f10965a = materialDynamicColors;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MaterialDynamicColors.A0(this.f10965a, (DynamicScheme) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
