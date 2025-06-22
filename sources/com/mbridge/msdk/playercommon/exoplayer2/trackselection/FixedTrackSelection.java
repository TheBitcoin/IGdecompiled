package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class FixedTrackSelection extends BaseTrackSelection {
    @Nullable
    private final Object data;
    private final int reason;

    public static final class Factory implements TrackSelection.Factory {
        @Nullable
        private final Object data;
        private final int reason;

        public Factory() {
            this.reason = 0;
            this.data = null;
        }

        public final FixedTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            boolean z4 = true;
            if (iArr.length != 1) {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            return new FixedTrackSelection(trackGroup, iArr[0], this.reason, this.data);
        }

        public Factory(int i4, @Nullable Object obj) {
            this.reason = i4;
            this.data = obj;
        }
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i4) {
        this(trackGroup, i4, 0, (Object) null);
    }

    public final int getSelectedIndex() {
        return 0;
    }

    @Nullable
    public final Object getSelectionData() {
        return this.data;
    }

    public final int getSelectionReason() {
        return this.reason;
    }

    public final void updateSelectedTrack(long j4, long j5, long j6) {
    }

    public FixedTrackSelection(TrackGroup trackGroup, int i4, int i5, @Nullable Object obj) {
        super(trackGroup, i4);
        this.reason = i5;
        this.data = obj;
    }
}
