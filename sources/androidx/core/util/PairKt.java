package androidx.core.util;

import R2.l;
import android.annotation.SuppressLint;
import android.util.Pair;

public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(l lVar) {
        return new Pair<>(lVar.c(), lVar.d());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(l lVar) {
        return new Pair<>(lVar.c(), lVar.d());
    }

    public static final <F, S> l toKotlinPair(Pair<F, S> pair) {
        return new l(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> l toKotlinPair(Pair<F, S> pair) {
        return new l(pair.first, pair.second);
    }
}
