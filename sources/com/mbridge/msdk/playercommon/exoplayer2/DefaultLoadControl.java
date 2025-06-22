package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultAllocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.PriorityTaskManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_MS = 15000;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = true;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    private final DefaultAllocator allocator;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isBuffering;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final PriorityTaskManager priorityTaskManager;
    private final int targetBufferBytesOverwrite;
    private int targetBufferSize;

    public static final class Builder {
        private DefaultAllocator allocator = null;
        private int bufferForPlaybackAfterRebufferMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
        private int bufferForPlaybackMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
        private int maxBufferMs = DefaultLoadControl.DEFAULT_MAX_BUFFER_MS;
        private int minBufferMs = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        private boolean prioritizeTimeOverSizeThresholds = true;
        private PriorityTaskManager priorityTaskManager = null;
        private int targetBufferBytes = -1;

        public final DefaultLoadControl createDefaultLoadControl() {
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.priorityTaskManager);
        }

        public final Builder setAllocator(DefaultAllocator defaultAllocator) {
            this.allocator = defaultAllocator;
            return this;
        }

        public final Builder setBufferDurationsMs(int i4, int i5, int i6, int i7) {
            this.minBufferMs = i4;
            this.maxBufferMs = i5;
            this.bufferForPlaybackMs = i6;
            this.bufferForPlaybackAfterRebufferMs = i7;
            return this;
        }

        public final Builder setPrioritizeTimeOverSizeThresholds(boolean z4) {
            this.prioritizeTimeOverSizeThresholds = z4;
            return this;
        }

        public final Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
            this.priorityTaskManager = priorityTaskManager2;
            return this;
        }

        public final Builder setTargetBufferBytes(int i4) {
            this.targetBufferBytes = i4;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536));
    }

    private static void assertGreaterOrEqual(int i4, int i5, String str, String str2) {
        boolean z4;
        if (i4 >= i5) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4, str + " cannot be less than " + str2);
    }

    private void reset(boolean z4) {
        this.targetBufferSize = 0;
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (priorityTaskManager2 != null && this.isBuffering) {
            priorityTaskManager2.remove(0);
        }
        this.isBuffering = false;
        if (z4) {
            this.allocator.reset();
        }
    }

    /* access modifiers changed from: protected */
    public int calculateTargetBufferSize(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i4 = 0;
        for (int i5 = 0; i5 < rendererArr.length; i5++) {
            if (trackSelectionArray.get(i5) != null) {
                i4 += Util.getDefaultBufferSize(rendererArr[i5].getTrackType());
            }
        }
        return i4;
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return 0;
    }

    public void onPrepared() {
        reset(false);
    }

    public void onReleased() {
        reset(true);
    }

    public void onStopped() {
        reset(true);
    }

    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        int i4 = this.targetBufferBytesOverwrite;
        if (i4 == -1) {
            i4 = calculateTargetBufferSize(rendererArr, trackSelectionArray);
        }
        this.targetBufferSize = i4;
        this.allocator.setTargetBufferSize(i4);
    }

    public boolean retainBackBufferFromKeyframe() {
        return false;
    }

    public boolean shouldContinueLoading(long j4, float f4) {
        boolean z4;
        boolean z5;
        boolean z6 = true;
        if (this.allocator.getTotalBytesAllocated() >= this.targetBufferSize) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = this.isBuffering;
        long j5 = this.minBufferUs;
        if (f4 > 1.0f) {
            j5 = Math.min(Util.getMediaDurationForPlayoutDuration(j5, f4), this.maxBufferUs);
        }
        if (j4 < j5) {
            if (!this.prioritizeTimeOverSizeThresholds && z4) {
                z6 = false;
            }
            this.isBuffering = z6;
        } else if (j4 > this.maxBufferUs || z4) {
            this.isBuffering = false;
        }
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        if (!(priorityTaskManager2 == null || (z5 = this.isBuffering) == z7)) {
            if (z5) {
                priorityTaskManager2.add(0);
            } else {
                priorityTaskManager2.remove(0);
            }
        }
        return this.isBuffering;
    }

    public boolean shouldStartPlayback(long j4, float f4, boolean z4) {
        long j5;
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j4, f4);
        if (z4) {
            j5 = this.bufferForPlaybackAfterRebufferUs;
        } else {
            j5 = this.bufferForPlaybackUs;
        }
        if (j5 <= 0 || playoutDurationForMediaDuration >= j5) {
            return true;
        }
        if (this.prioritizeTimeOverSizeThresholds || this.allocator.getTotalBytesAllocated() < this.targetBufferSize) {
            return false;
        }
        return true;
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, DEFAULT_MIN_BUFFER_MS, DEFAULT_MAX_BUFFER_MS, DEFAULT_BUFFER_FOR_PLAYBACK_MS, DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS, -1, true);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i4, int i5, int i6, int i7, int i8, boolean z4) {
        this(defaultAllocator, i4, i5, i6, i7, i8, z4, (PriorityTaskManager) null);
    }

    @Deprecated
    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i4, int i5, int i6, int i7, int i8, boolean z4, PriorityTaskManager priorityTaskManager2) {
        assertGreaterOrEqual(i6, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i7, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i4, i6, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i4, i7, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i5, i4, "maxBufferMs", "minBufferMs");
        this.allocator = defaultAllocator;
        this.minBufferUs = ((long) i4) * 1000;
        this.maxBufferUs = ((long) i5) * 1000;
        this.bufferForPlaybackUs = ((long) i6) * 1000;
        this.bufferForPlaybackAfterRebufferUs = ((long) i7) * 1000;
        this.targetBufferBytesOverwrite = i8;
        this.prioritizeTimeOverSizeThresholds = z4;
        this.priorityTaskManager = priorityTaskManager2;
    }
}
