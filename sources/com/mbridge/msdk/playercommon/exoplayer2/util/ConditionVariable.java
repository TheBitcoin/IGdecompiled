package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.SystemClock;

public final class ConditionVariable {
    private boolean isOpen;

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean close() {
        boolean z4;
        z4 = this.isOpen;
        this.isOpen = false;
        return z4;
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean block(long j4) throws InterruptedException {
        boolean z4;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j4 + elapsedRealtime;
        while (true) {
            z4 = this.isOpen;
            if (!z4 && elapsedRealtime < j5) {
                wait(j5 - elapsedRealtime);
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
        }
        return z4;
    }
}
