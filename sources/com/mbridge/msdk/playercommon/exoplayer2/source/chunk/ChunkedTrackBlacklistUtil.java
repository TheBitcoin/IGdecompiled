package com.mbridge.msdk.playercommon.exoplayer2.source.chunk;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.HttpDataSource;

public final class ChunkedTrackBlacklistUtil {
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    private static final String TAG = "ChunkedTrackBlacklist";

    private ChunkedTrackBlacklistUtil() {
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i4, Exception exc) {
        return maybeBlacklistTrack(trackSelection, i4, exc, DEFAULT_TRACK_BLACKLIST_MS);
    }

    public static boolean shouldBlacklist(Exception exc) {
        if (!(exc instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i4 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (i4 == 404 || i4 == 410) {
            return true;
        }
        return false;
    }

    public static boolean maybeBlacklistTrack(TrackSelection trackSelection, int i4, Exception exc, long j4) {
        if (!shouldBlacklist(exc)) {
            return false;
        }
        boolean blacklist = trackSelection.blacklist(i4, j4);
        int i5 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
        if (blacklist) {
            Log.w(TAG, "Blacklisted: duration=" + j4 + ", responseCode=" + i5 + ", format=" + trackSelection.getFormat(i4));
            return blacklist;
        }
        Log.w(TAG, "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i5 + ", format=" + trackSelection.getFormat(i4));
        return blacklist;
    }
}
