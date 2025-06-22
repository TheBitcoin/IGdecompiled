package com.uptodown.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadWorker;
import g2.C2060s;
import g2.S;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import u2.C2313C;

public final class DownloadUpdateNotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        int intExtra;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1881097171) {
                if (hashCode != 75902422) {
                    if (hashCode == 1980572282 && str.equals("CANCEL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 262 && context != null) {
                        UptodownApp.a aVar = UptodownApp.f17422D;
                        aVar.g();
                        Iterator it = aVar.D().iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            S s4 = (S) next;
                            UptodownApp.f17422D.f0(s4.h());
                            C2060s b5 = s4.b(context);
                            if (b5 != null) {
                                b5.g();
                            }
                        }
                        C2313C.f21882a.d(context, intExtra);
                    }
                } else if (str.equals("PAUSE")) {
                    DownloadWorker.f19459d.n();
                }
            } else if (str.equals("RESUME")) {
                DownloadWorker.f19459d.o();
            }
        }
    }
}
