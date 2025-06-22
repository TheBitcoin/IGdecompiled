package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class DataSpec {
    public static final int FLAG_ALLOW_CACHING_UNKNOWN_LENGTH = 2;
    public static final int FLAG_ALLOW_GZIP = 1;
    public final long absoluteStreamPosition;
    public final int flags;
    @Nullable
    public final String key;
    public final long length;
    public final long position;
    @Nullable
    public final byte[] postBody;
    public final Uri uri;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DataSpec(Uri uri2) {
        this(uri2, 0);
    }

    public final boolean isFlagSet(int i4) {
        if ((this.flags & i4) == i4) {
            return true;
        }
        return false;
    }

    public final DataSpec subrange(long j4) {
        long j5 = this.length;
        long j6 = -1;
        if (j5 != -1) {
            j6 = j5 - j4;
        }
        return subrange(j4, j6);
    }

    public final String toString() {
        return "DataSpec[" + this.uri + ", " + Arrays.toString(this.postBody) + ", " + this.absoluteStreamPosition + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }

    public final DataSpec withUri(Uri uri2) {
        return new DataSpec(uri2, this.postBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
    }

    public DataSpec(Uri uri2, int i4) {
        this(uri2, 0, -1, (String) null, i4);
    }

    public final DataSpec subrange(long j4, long j5) {
        if (j4 == 0 && this.length == j5) {
            return this;
        }
        return new DataSpec(this.uri, this.postBody, this.absoluteStreamPosition + j4, this.position + j4, j5, this.key, this.flags);
    }

    public DataSpec(Uri uri2, long j4, long j5, @Nullable String str) {
        this(uri2, j4, j4, j5, str, 0);
    }

    public DataSpec(Uri uri2, long j4, long j5, @Nullable String str, int i4) {
        this(uri2, j4, j4, j5, str, i4);
    }

    public DataSpec(Uri uri2, long j4, long j5, long j6, @Nullable String str, int i4) {
        this(uri2, (byte[]) null, j4, j5, j6, str, i4);
    }

    public DataSpec(Uri uri2, @Nullable byte[] bArr, long j4, long j5, long j6, @Nullable String str, int i4) {
        boolean z4 = false;
        Assertions.checkArgument(j4 >= 0);
        Assertions.checkArgument(j5 >= 0);
        Assertions.checkArgument((j6 > 0 || j6 == -1) ? true : z4);
        this.uri = uri2;
        this.postBody = bArr;
        this.absoluteStreamPosition = j4;
        this.position = j5;
        this.length = j6;
        this.key = str;
        this.flags = i4;
    }
}
