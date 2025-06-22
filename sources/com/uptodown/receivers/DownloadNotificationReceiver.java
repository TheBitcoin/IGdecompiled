package com.uptodown.receivers;

import android.content.BroadcastReceiver;
import kotlin.jvm.internal.C2103g;

public final class DownloadNotificationReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19268a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r0 = com.uptodown.workers.DownloadWorker.f19459d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x0007
            java.lang.String r0 = r7.getAction()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x00b1
            int r1 = r0.hashCode()
            r2 = 261(0x105, float:3.66E-43)
            r3 = -1
            java.lang.String r4 = "notificationID"
            switch(r1) {
                case -1919974852: goto L_0x006b;
                case -1881097171: goto L_0x005c;
                case 75902422: goto L_0x004d;
                case 1980572282: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x00b1
        L_0x0018:
            java.lang.String r1 = "CANCEL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x00b1
        L_0x0022:
            int r7 = r7.getIntExtra(r4, r3)
            if (r7 != r2) goto L_0x00b1
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f19459d
            g2.s r1 = r0.g()
            if (r1 == 0) goto L_0x00b1
            r0.a(r1)
            if (r6 == 0) goto L_0x00b1
            r1.R(r6)
            u2.q r0 = new u2.q
            r0.<init>()
            java.util.ArrayList r0 = r0.i(r6)
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b1
            u2.C r0 = u2.C2313C.f21882a
            r0.d(r6, r7)
            return
        L_0x004d:
            java.lang.String r6 = "PAUSE"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x00b1
        L_0x0056:
            com.uptodown.workers.DownloadWorker$a r6 = com.uptodown.workers.DownloadWorker.f19459d
            r6.n()
            return
        L_0x005c:
            java.lang.String r6 = "RESUME"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0065
            goto L_0x00b1
        L_0x0065:
            com.uptodown.workers.DownloadWorker$a r6 = com.uptodown.workers.DownloadWorker.f19459d
            r6.o()
            return
        L_0x006b:
            java.lang.String r1 = "CANCEL_ALL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0074
            goto L_0x00b1
        L_0x0074:
            int r7 = r7.getIntExtra(r4, r3)
            if (r7 != r2) goto L_0x00b1
            if (r6 == 0) goto L_0x00b1
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f19459d
            g2.s r1 = r0.g()
            u2.q r2 = new u2.q
            r2.<init>()
            java.util.ArrayList r2 = r2.i(r6)
            if (r1 == 0) goto L_0x0093
            r0.a(r1)
            r1.R(r6)
        L_0x0093:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x00ac
            int r0 = r2.size()
            r1 = 0
        L_0x009e:
            if (r1 >= r0) goto L_0x00ac
            java.lang.Object r3 = r2.get(r1)
            int r1 = r1 + 1
            g2.s r3 = (g2.C2060s) r3
            r3.R(r6)
            goto L_0x009e
        L_0x00ac:
            u2.C r0 = u2.C2313C.f21882a
            r0.d(r6, r7)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.receivers.DownloadNotificationReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
