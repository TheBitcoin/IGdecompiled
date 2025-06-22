package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

public abstract class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private int f15428a;

    /* renamed from: b  reason: collision with root package name */
    private int f15429b;

    /* renamed from: d  reason: collision with root package name */
    public long f15430d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f15431e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f15432f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f15433g = 0.0f;

    public b(int i4, int i5) {
        this.f15428a = i4;
        this.f15429b = i5;
    }

    public abstract void a();

    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (java.lang.Math.abs(r10 - r2) > ((float) r9.f15428a)) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r10) {
        /*
            r9 = this;
            float[] r10 = r10.values
            r0 = 0
            r0 = r10[r0]
            float r0 = -r0
            r1 = 1
            r1 = r10[r1]
            float r1 = -r1
            r2 = 2
            r10 = r10[r2]
            float r10 = -r10
            float r2 = r9.f15431e
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f15428a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0022:
            float r2 = r9.f15432f
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            float r2 = r1 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.f15428a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0035:
            float r2 = r9.f15433g
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x005c
            float r2 = r10 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.f15428a
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x005c
        L_0x0048:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r9.f15430d
            long r4 = r2 - r4
            int r6 = r9.f15429b
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x005c
            r9.f15430d = r2
            r9.a()
        L_0x005c:
            r9.f15431e = r0
            r9.f15432f = r1
            r9.f15433g = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.shake.b.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
