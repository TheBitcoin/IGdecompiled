package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.MediaChunk;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class BaseTrackSelection implements TrackSelection {
    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    private static final class DecreasingBandwidthComparator implements Comparator<Format> {
        private DecreasingBandwidthComparator() {
        }

        public final int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        boolean z4;
        int i4 = 0;
        if (iArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        this.group = (TrackGroup) Assertions.checkNotNull(trackGroup);
        int length2 = iArr.length;
        this.length = length2;
        this.formats = new Format[length2];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.formats[i5] = trackGroup.getFormat(iArr[i5]);
        }
        Arrays.sort(this.formats, new DecreasingBandwidthComparator());
        this.tracks = new int[this.length];
        while (true) {
            int i6 = this.length;
            if (i4 < i6) {
                this.tracks[i4] = trackGroup.indexOf(this.formats[i4]);
                i4++;
            } else {
                this.blacklistUntilTimes = new long[i6];
                return;
            }
        }
    }

    public final boolean blacklist(int i4, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i4, elapsedRealtime);
        for (int i5 = 0; i5 < this.length && !isBlacklisted; i5++) {
            if (i5 == i4 || isBlacklisted(i5, elapsedRealtime)) {
                isBlacklisted = false;
            } else {
                isBlacklisted = true;
            }
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[i4] = Math.max(jArr[i4], elapsedRealtime + j4);
        return true;
    }

    public void disable() {
    }

    public void enable() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
            if (this.group != baseTrackSelection.group || !Arrays.equals(this.tracks, baseTrackSelection.tracks)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int evaluateQueueSize(long j4, List<? extends MediaChunk> list) {
        return list.size();
    }

    public final Format getFormat(int i4) {
        return this.formats[i4];
    }

    public final int getIndexInTrackGroup(int i4) {
        return this.tracks[i4];
    }

    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    public final int indexOf(Format format) {
        for (int i4 = 0; i4 < this.length; i4++) {
            if (this.formats[i4] == format) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public final boolean isBlacklisted(int i4, long j4) {
        if (this.blacklistUntilTimes[i4] > j4) {
            return true;
        }
        return false;
    }

    public final int length() {
        return this.tracks.length;
    }

    public void onPlaybackSpeed(float f4) {
    }

    public final int indexOf(int i4) {
        for (int i5 = 0; i5 < this.length; i5++) {
            if (this.tracks[i5] == i4) {
                return i5;
            }
        }
        return -1;
    }
}
