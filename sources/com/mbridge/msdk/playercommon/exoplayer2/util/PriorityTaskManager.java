package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority = Integer.MIN_VALUE;
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i4, int i5) {
            super("Priority too low [priority=" + i4 + ", highest=" + i5 + "]");
        }
    }

    public final void add(int i4) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i4));
            this.highestPriority = Math.max(this.highestPriority, i4);
        }
    }

    public final void proceed(int i4) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i4) {
                try {
                    this.lock.wait();
                } finally {
                }
            }
        }
    }

    public final boolean proceedNonBlocking(int i4) {
        boolean z4;
        synchronized (this.lock) {
            if (this.highestPriority == i4) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        return z4;
    }

    public final void proceedOrThrow(int i4) throws PriorityTooLowException {
        synchronized (this.lock) {
            try {
                if (this.highestPriority != i4) {
                    throw new PriorityTooLowException(i4, this.highestPriority);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void remove(int i4) {
        int i5;
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i4));
            if (this.queue.isEmpty()) {
                i5 = Integer.MIN_VALUE;
            } else {
                i5 = this.queue.peek().intValue();
            }
            this.highestPriority = i5;
            this.lock.notifyAll();
        }
    }
}
