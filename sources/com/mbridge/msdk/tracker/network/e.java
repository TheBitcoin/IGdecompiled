package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

public final class e implements z {

    /* renamed from: a  reason: collision with root package name */
    private int f15526a;

    /* renamed from: b  reason: collision with root package name */
    private long f15527b;

    /* renamed from: c  reason: collision with root package name */
    private int f15528c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15529d;

    public e() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1);
    }

    public final int a() {
        return this.f15526a;
    }

    public final long b() {
        return this.f15527b;
    }

    public final int c() {
        return this.f15528c;
    }

    public e(int i4, int i5) {
        this(i4, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS, i5);
    }

    public final boolean a(ad adVar) {
        int i4 = this.f15528c + 1;
        this.f15528c = i4;
        if (i4 <= this.f15529d) {
            return true;
        }
        return false;
    }

    public e(int i4, long j4, int i5) {
        this.f15527b = j4;
        this.f15526a = i4;
        this.f15529d = i5;
    }
}
