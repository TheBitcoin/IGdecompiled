package com.mbridge.msdk.newreward.player.redirect;

import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.newreward.function.command.c;

public class UrlReDirectController {
    private c commandManager;
    private b mLoader;

    /* renamed from: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.newreward.player.redirect.RedirectType[] r0 = com.mbridge.msdk.newreward.player.redirect.RedirectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType = r0
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.CLICK_URL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.player.redirect.RedirectType r1 = com.mbridge.msdk.newreward.player.redirect.RedirectType.NOTICE_URL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController.AnonymousClass2.<clinit>():void");
        }
    }

    public UrlReDirectController() {
        this.mLoader = null;
        this.mLoader = new b(com.mbridge.msdk.foundation.controller.c.m().c());
    }

    private void reDirect(final String str) {
        this.mLoader.a(new a() {
            public void cancelTask() {
            }

            public void pauseTask(boolean z4) {
            }

            public void runTask() {
                UrlReDirectController.this.realDoDirectUrl(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void realDoDirectUrl(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0060, all -> 0x005b }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0060, all -> 0x005b }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x0060, all -> 0x005b }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0060, all -> 0x005b }
            r0 = 0
            r4.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r0 = "GET"
            r4.setRequestMethod(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r0 = 10000(0x2710, float:1.4013E-41)
            r4.setConnectTimeout(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r4.setReadTimeout(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r0 = "User-Agent"
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.ab.g()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r4.setRequestProperty(r0, r1)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            int r0 = r4.getResponseCode()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r1 = 302(0x12e, float:4.23E-43)
            if (r0 == r1) goto L_0x0032
            r1 = 301(0x12d, float:4.22E-43)
            if (r0 != r1) goto L_0x0057
        L_0x0032:
            java.lang.String r0 = "Location"
            java.lang.String r0 = r4.getHeaderField(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            java.lang.String r1 = "market:"
            boolean r1 = r0.startsWith(r1)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            if (r1 == 0) goto L_0x0051
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            com.mbridge.msdk.click.c.a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r0 = move-exception
            goto L_0x0062
        L_0x004e:
            r0 = r4
            goto L_0x0068
        L_0x0051:
            r4.disconnect()     // Catch:{ Exception -> 0x004e, all -> 0x004c }
            r3.realDoDirectUrl(r0)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
        L_0x0057:
            r4.disconnect()
            return
        L_0x005b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L_0x0062
        L_0x0060:
            goto L_0x0068
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            r4.disconnect()
        L_0x0067:
            throw r0
        L_0x0068:
            if (r0 == 0) goto L_0x006d
            r0.disconnect()
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.redirect.UrlReDirectController.realDoDirectUrl(java.lang.String):void");
    }

    public void doReDirect(RedirectModel redirectModel) {
        int i4 = AnonymousClass2.$SwitchMap$com$mbridge$msdk$newreward$player$redirect$RedirectType[redirectModel.getRedirectType().ordinal()];
        if (i4 == 1) {
            reDirect((String) null);
        } else if (i4 == 2) {
            reDirect((String) null);
        }
    }

    public c getCommandManager() {
        return this.commandManager;
    }

    public void setCommandManager(c cVar) {
        this.commandManager = cVar;
    }
}
