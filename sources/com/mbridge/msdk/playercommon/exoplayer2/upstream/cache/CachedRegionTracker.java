package com.mbridge.msdk.playercommon.exoplayer2.upstream.cache;

import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public final class CachedRegionTracker implements Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    private static final String TAG = "CachedRegionTracker";
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final Region lookupRegion = new Region(0, 0);
    private final TreeSet<Region> regions = new TreeSet<>();

    private static class Region implements Comparable<Region> {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long j4, long j5) {
            this.startOffset = j4;
            this.endOffset = j5;
        }

        public int compareTo(@NonNull Region region) {
            long j4 = this.startOffset;
            long j5 = region.startOffset;
            if (j4 < j5) {
                return -1;
            }
            return j4 == j5 ? 0 : 1;
        }
    }

    public CachedRegionTracker(Cache cache2, String str, ChunkIndex chunkIndex2) {
        this.cache = cache2;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex2;
        synchronized (this) {
            try {
                Iterator<CacheSpan> descendingIterator = cache2.addListener(str, this).descendingIterator();
                while (descendingIterator.hasNext()) {
                    mergeSpan(descendingIterator.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        long j4 = cacheSpan.position;
        Region region = new Region(j4, cacheSpan.length + j4);
        Region floor = this.regions.floor(region);
        Region ceiling = this.regions.ceiling(region);
        boolean regionsConnect = regionsConnect(floor, region);
        if (regionsConnect(region, ceiling)) {
            if (regionsConnect) {
                floor.endOffset = ceiling.endOffset;
                floor.endOffsetIndex = ceiling.endOffsetIndex;
            } else {
                region.endOffset = ceiling.endOffset;
                region.endOffsetIndex = ceiling.endOffsetIndex;
                this.regions.add(region);
            }
            this.regions.remove(ceiling);
        } else if (regionsConnect) {
            floor.endOffset = region.endOffset;
            int i4 = floor.endOffsetIndex;
            while (true) {
                ChunkIndex chunkIndex2 = this.chunkIndex;
                if (i4 >= chunkIndex2.length - 1) {
                    break;
                }
                int i5 = i4 + 1;
                if (chunkIndex2.offsets[i5] > floor.endOffset) {
                    break;
                }
                i4 = i5;
            }
            floor.endOffsetIndex = i4;
        } else {
            int binarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            region.endOffsetIndex = binarySearch;
            this.regions.add(region);
        }
    }

    private boolean regionsConnect(Region region, Region region2) {
        if (region == null || region2 == null || region.endOffset != region2.startOffset) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int getRegionEndTimeMs(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r0 = r8.lookupRegion     // Catch:{ all -> 0x0034 }
            r0.startOffset = r9     // Catch:{ all -> 0x0034 }
            java.util.TreeSet<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region> r1 = r8.regions     // Catch:{ all -> 0x0034 }
            java.lang.Object r0 = r1.floor(r0)     // Catch:{ all -> 0x0034 }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r0 = (com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker.Region) r0     // Catch:{ all -> 0x0034 }
            r1 = -1
            if (r0 == 0) goto L_0x0052
            long r2 = r0.endOffset     // Catch:{ all -> 0x0034 }
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0052
            int r9 = r0.endOffsetIndex     // Catch:{ all -> 0x0034 }
            if (r9 != r1) goto L_0x001b
            goto L_0x0052
        L_0x001b:
            com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex r10 = r8.chunkIndex     // Catch:{ all -> 0x0034 }
            int r0 = r10.length     // Catch:{ all -> 0x0034 }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x0036
            long[] r0 = r10.offsets     // Catch:{ all -> 0x0034 }
            r4 = r0[r9]     // Catch:{ all -> 0x0034 }
            int[] r0 = r10.sizes     // Catch:{ all -> 0x0034 }
            r0 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r0 = (long) r0
            long r4 = r4 + r0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0036
            monitor-exit(r8)
            r9 = -2
            return r9
        L_0x0034:
            r9 = move-exception
            goto L_0x0054
        L_0x0036:
            long[] r0 = r10.durationsUs     // Catch:{ all -> 0x0034 }
            r4 = r0[r9]     // Catch:{ all -> 0x0034 }
            long[] r0 = r10.offsets     // Catch:{ all -> 0x0034 }
            r6 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r2 = r2 - r6
            long r4 = r4 * r2
            int[] r0 = r10.sizes     // Catch:{ all -> 0x0034 }
            r0 = r0[r9]     // Catch:{ all -> 0x0034 }
            long r0 = (long) r0     // Catch:{ all -> 0x0034 }
            long r4 = r4 / r0
            long[] r10 = r10.timesUs     // Catch:{ all -> 0x0034 }
            r9 = r10[r9]     // Catch:{ all -> 0x0034 }
            long r9 = r9 + r4
            r0 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 / r0
            int r10 = (int) r9
            monitor-exit(r8)
            return r10
        L_0x0052:
            monitor-exit(r8)
            return r1
        L_0x0054:
            monitor-exit(r8)     // Catch:{ all -> 0x0034 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker.getRegionEndTimeMs(long):int");
    }

    public final synchronized void onSpanAdded(Cache cache2, CacheSpan cacheSpan) {
        mergeSpan(cacheSpan);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onSpanRemoved(com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache r7, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheSpan r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r7 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            long r0 = r8.position     // Catch:{ all -> 0x001e }
            long r2 = r8.length     // Catch:{ all -> 0x001e }
            long r2 = r2 + r0
            r7.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            java.util.TreeSet<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region> r8 = r6.regions     // Catch:{ all -> 0x001e }
            java.lang.Object r8 = r8.floor(r7)     // Catch:{ all -> 0x001e }
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r8 = (com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker.Region) r8     // Catch:{ all -> 0x001e }
            if (r8 != 0) goto L_0x0020
            java.lang.String r7 = "CachedRegionTracker"
            java.lang.String r8 = "Removed a span we were not aware of"
            android.util.Log.e(r7, r8)     // Catch:{ all -> 0x001e }
            monitor-exit(r6)
            return
        L_0x001e:
            r7 = move-exception
            goto L_0x0063
        L_0x0020:
            java.util.TreeSet<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region> r0 = r6.regions     // Catch:{ all -> 0x001e }
            r0.remove(r8)     // Catch:{ all -> 0x001e }
            long r0 = r8.startOffset     // Catch:{ all -> 0x001e }
            long r2 = r7.startOffset     // Catch:{ all -> 0x001e }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0048
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r4 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            r4.<init>(r0, r2)     // Catch:{ all -> 0x001e }
            com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex r0 = r6.chunkIndex     // Catch:{ all -> 0x001e }
            long[] r0 = r0.offsets     // Catch:{ all -> 0x001e }
            long r1 = r4.endOffset     // Catch:{ all -> 0x001e }
            int r0 = java.util.Arrays.binarySearch(r0, r1)     // Catch:{ all -> 0x001e }
            if (r0 >= 0) goto L_0x0041
            int r0 = -r0
            int r0 = r0 + -2
        L_0x0041:
            r4.endOffsetIndex = r0     // Catch:{ all -> 0x001e }
            java.util.TreeSet<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region> r0 = r6.regions     // Catch:{ all -> 0x001e }
            r0.add(r4)     // Catch:{ all -> 0x001e }
        L_0x0048:
            long r0 = r8.endOffset     // Catch:{ all -> 0x001e }
            long r2 = r7.endOffset     // Catch:{ all -> 0x001e }
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0061
            com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region r7 = new com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region     // Catch:{ all -> 0x001e }
            r4 = 1
            long r2 = r2 + r4
            r7.<init>(r2, r0)     // Catch:{ all -> 0x001e }
            int r8 = r8.endOffsetIndex     // Catch:{ all -> 0x001e }
            r7.endOffsetIndex = r8     // Catch:{ all -> 0x001e }
            java.util.TreeSet<com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker$Region> r8 = r6.regions     // Catch:{ all -> 0x001e }
            r8.add(r7)     // Catch:{ all -> 0x001e }
        L_0x0061:
            monitor-exit(r6)
            return
        L_0x0063:
            monitor-exit(r6)     // Catch:{ all -> 0x001e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedRegionTracker.onSpanRemoved(com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.Cache, com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheSpan):void");
    }

    public final void onSpanTouched(Cache cache2, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public final void release() {
        this.cache.removeListener(this.cacheKey, this);
    }
}
