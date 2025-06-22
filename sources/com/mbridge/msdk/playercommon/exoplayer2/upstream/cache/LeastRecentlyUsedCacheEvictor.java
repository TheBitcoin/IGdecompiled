package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor, Comparator<CacheSpan> {
    private long currentSize;
    private final TreeSet<CacheSpan> leastRecentlyUsed = new TreeSet<>(this);
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j4) {
        this.maxBytes = j4;
    }

    private void evictCache(Cache cache, long j4) {
        while (this.currentSize + j4 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
            try {
                cache.removeSpan(this.leastRecentlyUsed.first());
            } catch (Cache.CacheException unused) {
            }
        }
    }

    public final void onCacheInitialized() {
    }

    public final void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        this.currentSize += cacheSpan.length;
        evictCache(cache, 0);
    }

    public final void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        this.currentSize -= cacheSpan.length;
    }

    public final void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        onSpanRemoved(cache, cacheSpan);
        onSpanAdded(cache, cacheSpan2);
    }

    public final void onStartFile(Cache cache, String str, long j4, long j5) {
        evictCache(cache, j5);
    }

    public final int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j4 = cacheSpan.lastAccessTimestamp;
        long j5 = cacheSpan2.lastAccessTimestamp;
        if (j4 - j5 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j4 < j5 ? -1 : 1;
    }
}
