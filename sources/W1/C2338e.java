package w1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import q1.g;
import q1.j;

/* renamed from: w1.e  reason: case insensitive filesystem */
public abstract class C2338e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static j f22018a = j.UNKNOWN;

    /* renamed from: w1.e$a */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            j jVar;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    jVar = j.NOT_DETECTED;
                } else if (intExtra == 1) {
                    jVar = j.UNKNOWN;
                } else {
                    return;
                }
                j unused = C2338e.f22018a = jVar;
            }
        }
    }

    public static j a() {
        if (C2334a.a() != g.CTV) {
            return j.UNKNOWN;
        }
        return f22018a;
    }

    public static void c(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
