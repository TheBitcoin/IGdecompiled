package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class GpsStatusWrapper extends GnssStatusCompat {
    private static final int BEIDOU_PRN_COUNT = 35;
    private static final int BEIDOU_PRN_OFFSET = 200;
    private static final int GLONASS_PRN_COUNT = 24;
    private static final int GLONASS_PRN_OFFSET = 64;
    private static final int GPS_PRN_COUNT = 32;
    private static final int GPS_PRN_OFFSET = 0;
    private static final int QZSS_SVID_MAX = 200;
    private static final int QZSS_SVID_MIN = 193;
    private static final int SBAS_PRN_MAX = 64;
    private static final int SBAS_PRN_MIN = 33;
    private static final int SBAS_PRN_OFFSET = -87;
    @GuardedBy("mWrapped")
    private Iterator<GpsSatellite> mCachedIterator;
    @GuardedBy("mWrapped")
    private int mCachedIteratorPosition;
    @GuardedBy("mWrapped")
    private GpsSatellite mCachedSatellite;
    @GuardedBy("mWrapped")
    private int mCachedSatelliteCount = -1;
    private final GpsStatus mWrapped;

    GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.checkNotNull(gpsStatus);
        this.mWrapped = gpsStatus2;
        this.mCachedIterator = gpsStatus2.getSatellites().iterator();
        this.mCachedIteratorPosition = -1;
        this.mCachedSatellite = null;
    }

    private static int getConstellationFromPrn(int i4) {
        if (i4 > 0 && i4 <= 32) {
            return 1;
        }
        if (i4 >= 33 && i4 <= 64) {
            return 2;
        }
        if (i4 > 64 && i4 <= 88) {
            return 3;
        }
        if (i4 <= 200 || i4 > 235) {
            return (i4 < QZSS_SVID_MIN || i4 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite getSatellite(int i4) {
        GpsSatellite gpsSatellite;
        synchronized (this.mWrapped) {
            try {
                if (i4 < this.mCachedIteratorPosition) {
                    this.mCachedIterator = this.mWrapped.getSatellites().iterator();
                    this.mCachedIteratorPosition = -1;
                }
                while (true) {
                    int i5 = this.mCachedIteratorPosition;
                    if (i5 >= i4) {
                        break;
                    }
                    this.mCachedIteratorPosition = i5 + 1;
                    if (!this.mCachedIterator.hasNext()) {
                        this.mCachedSatellite = null;
                        break;
                    }
                    this.mCachedSatellite = this.mCachedIterator.next();
                }
                gpsSatellite = this.mCachedSatellite;
            } finally {
                while (true) {
                }
            }
        }
        return (GpsSatellite) Preconditions.checkNotNull(gpsSatellite);
    }

    private static int getSvidFromPrn(int i4) {
        int constellationFromPrn = getConstellationFromPrn(i4);
        if (constellationFromPrn == 2) {
            return i4 + 87;
        }
        if (constellationFromPrn == 3) {
            return i4 - 64;
        }
        if (constellationFromPrn != 5) {
            return i4;
        }
        return i4 - 200;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GpsStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i4) {
        return getSatellite(i4).getAzimuth();
    }

    public float getBasebandCn0DbHz(int i4) {
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i4) {
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i4) {
        return getSatellite(i4).getSnr();
    }

    public int getConstellationType(int i4) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return getConstellationFromPrn(getSatellite(i4).getPrn());
    }

    public float getElevationDegrees(int i4) {
        return getSatellite(i4).getElevation();
    }

    public int getSatelliteCount() {
        int i4;
        synchronized (this.mWrapped) {
            try {
                if (this.mCachedSatelliteCount == -1) {
                    for (GpsSatellite next : this.mWrapped.getSatellites()) {
                        this.mCachedSatelliteCount++;
                    }
                    this.mCachedSatelliteCount++;
                }
                i4 = this.mCachedSatelliteCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i4;
    }

    public int getSvid(int i4) {
        if (Build.VERSION.SDK_INT < 24) {
            return getSatellite(i4).getPrn();
        }
        return getSvidFromPrn(getSatellite(i4).getPrn());
    }

    public boolean hasAlmanacData(int i4) {
        return getSatellite(i4).hasAlmanac();
    }

    public boolean hasBasebandCn0DbHz(int i4) {
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i4) {
        return false;
    }

    public boolean hasEphemerisData(int i4) {
        return getSatellite(i4).hasEphemeris();
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i4) {
        return getSatellite(i4).usedInFix();
    }
}
