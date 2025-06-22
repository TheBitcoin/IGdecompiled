package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.os.Looper;
import android.os.Message;

public interface HandlerWrapper {
    Looper getLooper();

    Message obtainMessage(int i4);

    Message obtainMessage(int i4, int i5, int i6);

    Message obtainMessage(int i4, int i5, int i6, Object obj);

    Message obtainMessage(int i4, Object obj);

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j4);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i4);

    boolean sendEmptyMessage(int i4);

    boolean sendEmptyMessageAtTime(int i4, long j4);
}
