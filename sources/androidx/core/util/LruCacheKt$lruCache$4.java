package androidx.core.util;

import android.util.LruCache;
import d3.l;
import d3.p;
import d3.r;

public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i4, p pVar, l lVar, r rVar) {
        super(i4);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
    }

    /* access modifiers changed from: protected */
    public V create(K k4) {
        return this.$create.invoke(k4);
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z4, K k4, V v4, V v5) {
        this.$onEntryRemoved.invoke(Boolean.valueOf(z4), k4, v4, v5);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k4, V v4) {
        return ((Number) this.$sizeOf.invoke(k4, v4)).intValue();
    }
}
