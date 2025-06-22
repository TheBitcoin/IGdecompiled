package androidx.collection;

import d3.l;
import d3.p;
import d3.r;
import kotlin.jvm.internal.m;

public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i4, p pVar, l lVar, r rVar) {
        m.f(pVar, "sizeOf");
        m.f(lVar, "create");
        m.f(rVar, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(pVar, lVar, rVar, i4, i4);
    }

    public static /* synthetic */ LruCache lruCache$default(int i4, p pVar, l lVar, r rVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        p pVar2 = pVar;
        if ((i5 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        l lVar2 = lVar;
        if ((i5 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        r rVar2 = rVar;
        m.f(pVar2, "sizeOf");
        m.f(lVar2, "create");
        m.f(rVar2, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(pVar2, lVar2, rVar2, i4, i4);
    }
}
