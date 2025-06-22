package androidx.core.util;

import android.util.LruCache;
import d3.l;
import d3.p;
import d3.r;

public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i4, p pVar, l lVar, r rVar) {
        return new LruCacheKt$lruCache$4(i4, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i4, p pVar, l lVar, r rVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i5 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i5 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        return new LruCacheKt$lruCache$4(i4, pVar, lVar, rVar);
    }
}
