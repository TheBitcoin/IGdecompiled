package s1;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* renamed from: s1.d  reason: case insensitive filesystem */
public final class C2276d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21759a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f21760b;

    /* renamed from: c  reason: collision with root package name */
    private final C2273a f21761c;

    /* renamed from: d  reason: collision with root package name */
    private final C2275c f21762d;

    /* renamed from: e  reason: collision with root package name */
    private float f21763e;

    public C2276d(Handler handler, Context context, C2273a aVar, C2275c cVar) {
        super(handler);
        this.f21759a = context;
        this.f21760b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f21761c = aVar;
        this.f21762d = cVar;
    }

    private float a() {
        return this.f21761c.a(this.f21760b.getStreamVolume(3), this.f21760b.getStreamMaxVolume(3));
    }

    private boolean b(float f4) {
        if (f4 != this.f21763e) {
            return true;
        }
        return false;
    }

    private void c() {
        this.f21762d.a(this.f21763e);
    }

    public void d() {
        this.f21763e = a();
        c();
        this.f21759a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f21759a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z4) {
        super.onChange(z4);
        float a5 = a();
        if (b(a5)) {
            this.f21763e = a5;
            c();
        }
    }
}
