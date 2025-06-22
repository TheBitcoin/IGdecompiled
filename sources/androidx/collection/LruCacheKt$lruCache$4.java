package androidx.collection;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.l;
import d3.p;
import d3.r;
import kotlin.jvm.internal.m;

public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(p pVar, l lVar, r rVar, int i4, int i5) {
        super(i5);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i4;
    }

    /* access modifiers changed from: protected */
    public V create(K k4) {
        m.f(k4, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.$create.invoke(k4);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z4, K k4, V v4, V v5) {
        m.f(k4, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.f(v4, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z4), k4, v4, v5);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k4, V v4) {
        m.f(k4, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.f(v4, "value");
        return ((Number) this.$sizeOf.invoke(k4, v4)).intValue();
    }
}
