package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.l  reason: case insensitive filesystem */
public final /* synthetic */ class C1739l implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((DynamicScheme) obj).neutralVariantPalette;
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }
}
