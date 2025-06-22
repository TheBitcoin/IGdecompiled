package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import java.util.Random;

public final class RandomTrackSelection extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    public static final class Factory implements TrackSelection.Factory {
        private final Random random;

        public Factory() {
            this.random = new Random();
        }

        public final RandomTrackSelection createTrackSelection(TrackGroup trackGroup, int... iArr) {
            return new RandomTrackSelection(trackGroup, iArr, this.random);
        }

        public Factory(int i4) {
            this.random = new Random((long) i4);
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        Random random2 = new Random();
        this.random = random2;
        this.selectedIndex = random2.nextInt(this.length);
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public final Object getSelectionData() {
        return null;
    }

    public final int getSelectionReason() {
        return 3;
    }

    public final void updateSelectedTrack(long j4, long j5, long j6) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i4 = 0;
        for (int i5 = 0; i5 < this.length; i5++) {
            if (!isBlacklisted(i5, elapsedRealtime)) {
                i4++;
            }
        }
        this.selectedIndex = this.random.nextInt(i4);
        if (i4 != this.length) {
            int i6 = 0;
            for (int i7 = 0; i7 < this.length; i7++) {
                if (!isBlacklisted(i7, elapsedRealtime)) {
                    int i8 = i6 + 1;
                    if (this.selectedIndex == i6) {
                        this.selectedIndex = i7;
                        return;
                    }
                    i6 = i8;
                }
            }
        }
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, long j4) {
        this(trackGroup, iArr, new Random(j4));
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] iArr, Random random2) {
        super(trackGroup, iArr);
        this.random = random2;
        this.selectedIndex = random2.nextInt(this.length);
    }
}
