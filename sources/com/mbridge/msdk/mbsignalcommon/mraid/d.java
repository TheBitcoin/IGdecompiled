package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static double f14117a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private Context f14118b;

    /* renamed from: c  reason: collision with root package name */
    private AudioManager f14119c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14120d = false;

    /* renamed from: e  reason: collision with root package name */
    private b f14121e;

    /* renamed from: f  reason: collision with root package name */
    private a f14122f;

    private static class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<d> f14123a;

        public a(d dVar) {
            this.f14123a = new WeakReference<>(dVar);
        }

        public final void onReceive(Context context, Intent intent) {
            d dVar;
            b b5;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3 && (dVar = this.f14123a.get()) != null && (b5 = dVar.b()) != null) {
                double a5 = dVar.a();
                if (a5 >= 0.0d) {
                    b5.a(a5);
                }
            }
        }
    }

    public interface b {
        void a(double d5);
    }

    public d(Context context) {
        this.f14118b = context;
        this.f14119c = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public final double a() {
        AudioManager audioManager = this.f14119c;
        int i4 = -1;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f14119c;
        if (audioManager2 != null) {
            i4 = audioManager2.getStreamVolume(3);
        }
        double d5 = (((double) i4) * 100.0d) / ((double) streamMaxVolume);
        f14117a = d5;
        return d5;
    }

    public final b b() {
        return this.f14121e;
    }

    public final void c() {
        if (this.f14118b != null) {
            this.f14122f = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f14118b.registerReceiver(this.f14122f, intentFilter);
            this.f14120d = true;
        }
    }

    public final void d() {
        Context context;
        if (this.f14120d && (context = this.f14118b) != null) {
            try {
                context.unregisterReceiver(this.f14122f);
                this.f14121e = null;
                this.f14120d = false;
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(b bVar) {
        this.f14121e = bVar;
    }
}
