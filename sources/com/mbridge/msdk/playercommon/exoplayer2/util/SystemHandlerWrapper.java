package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler2) {
        this.handler = handler2;
    }

    public final Looper getLooper() {
        return this.handler.getLooper();
    }

    public final Message obtainMessage(int i4) {
        return this.handler.obtainMessage(i4);
    }

    public final boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public final boolean postDelayed(Runnable runnable, long j4) {
        return this.handler.postDelayed(runnable, j4);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    public final void removeMessages(int i4) {
        this.handler.removeMessages(i4);
    }

    public final boolean sendEmptyMessage(int i4) {
        return this.handler.sendEmptyMessage(i4);
    }

    public final boolean sendEmptyMessageAtTime(int i4, long j4) {
        return this.handler.sendEmptyMessageAtTime(i4, j4);
    }

    public final Message obtainMessage(int i4, Object obj) {
        return this.handler.obtainMessage(i4, obj);
    }

    public final Message obtainMessage(int i4, int i5, int i6) {
        return this.handler.obtainMessage(i4, i5, i6);
    }

    public final Message obtainMessage(int i4, int i5, int i6, Object obj) {
        return this.handler.obtainMessage(i4, i5, i6, obj);
    }
}
