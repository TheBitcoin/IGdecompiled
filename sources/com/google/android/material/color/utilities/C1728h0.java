package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C1728h0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f10990a;

    public /* synthetic */ C1728h0(MaterialDynamicColors materialDynamicColors) {
        this.f10990a = materialDynamicColors;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MaterialDynamicColors.X1(this.f10990a, (DynamicScheme) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
