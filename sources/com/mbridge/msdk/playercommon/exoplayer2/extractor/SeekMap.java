package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public interface SeekMap {

    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SeekPoints.class == obj.getClass()) {
                SeekPoints seekPoints = (SeekPoints) obj;
                if (!this.first.equals(seekPoints.first) || !this.second.equals(seekPoints.second)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.first);
            if (this.first.equals(this.second)) {
                str = "";
            } else {
                str = ", " + this.second;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }
    }

    public static final class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        public Unseekable(long j4) {
            this(j4, 0);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final SeekPoints getSeekPoints(long j4) {
            return this.startSeekPoints;
        }

        public final boolean isSeekable() {
            return false;
        }

        public Unseekable(long j4, long j5) {
            this.durationUs = j4;
            this.startSeekPoints = new SeekPoints(j5 == 0 ? SeekPoint.START : new SeekPoint(0, j5));
        }
    }

    long getDurationUs();

    SeekPoints getSeekPoints(long j4);

    boolean isSeekable();
}
