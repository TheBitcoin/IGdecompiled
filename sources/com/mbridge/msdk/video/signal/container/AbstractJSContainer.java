package com.mbridge.msdk.video.signal.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* renamed from: a  reason: collision with root package name */
    private int f16904a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f16905b = 1;
    /* access modifiers changed from: protected */

    /* renamed from: i  reason: collision with root package name */
    public Activity f16906i;
    /* access modifiers changed from: protected */

    /* renamed from: j  reason: collision with root package name */
    public String f16907j;
    /* access modifiers changed from: protected */

    /* renamed from: k  reason: collision with root package name */
    public String f16908k;
    /* access modifiers changed from: protected */

    /* renamed from: l  reason: collision with root package name */
    public c f16909l;

    /* renamed from: m  reason: collision with root package name */
    protected String f16910m;

    /* renamed from: n  reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.b.c f16911n;

    /* renamed from: o  reason: collision with root package name */
    protected String f16912o;

    /* renamed from: p  reason: collision with root package name */
    protected int f16913p = 2;
    /* access modifiers changed from: protected */

    /* renamed from: q  reason: collision with root package name */
    public boolean f16914q = false;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f16915r = false;

    /* renamed from: s  reason: collision with root package name */
    protected int f16916s;

    /* renamed from: t  reason: collision with root package name */
    protected int f16917t;

    /* renamed from: u  reason: collision with root package name */
    protected int f16918u;
    /* access modifiers changed from: protected */

    /* renamed from: v  reason: collision with root package name */
    public boolean f16919v = false;

    /* renamed from: w  reason: collision with root package name */
    protected IJSFactory f16920w = new a();

    public AbstractJSContainer(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        g.a().a(obj, a(this.f16904a));
    }

    /* access modifiers changed from: protected */
    public final k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0208a a5 = com.mbridge.msdk.videocommon.a.a(this.f16914q ? 287 : 94, campaignEx);
        if (a5 != null && a5.c()) {
            WindVaneWebView a6 = a5.a();
            if (a6.getObject() instanceof k) {
                return (k) a6.getObject();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final int c(CampaignEx campaignEx) {
        k b5 = b(campaignEx);
        if (b5 != null) {
            return b5.o();
        }
        return 0;
    }

    public b getActivityProxy() {
        return this.f16920w.getActivityProxy();
    }

    public i getIJSRewardVideoV1() {
        return this.f16920w.getIJSRewardVideoV1();
    }

    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.f16920w.getJSBTModule();
    }

    public d getJSCommon() {
        return this.f16920w.getJSCommon();
    }

    public f getJSContainerModule() {
        return this.f16920w.getJSContainerModule();
    }

    public com.mbridge.msdk.video.signal.g getJSNotifyProxy() {
        return this.f16920w.getJSNotifyProxy();
    }

    public j getJSVideoModule() {
        return this.f16920w.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.f16908k;
    }

    public String getUnitId() {
        return this.f16907j;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().b()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().b()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (!com.mbridge.msdk.foundation.d.b.f12876c) {
            if (getJSCommon().b()) {
                getActivityProxy().b();
            }
            getActivityProxy().a(0);
        }
    }

    public void onStart() {
        if (getJSCommon().b()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().b()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.f16920w = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.f16906i = activity;
    }

    public void setBidCampaign(boolean z4) {
        this.f16915r = z4;
    }

    public void setBigOffer(boolean z4) {
        this.f16919v = z4;
    }

    public void setIV(boolean z4) {
        this.f16914q = z4;
    }

    public void setIVRewardEnable(int i4, int i5, int i6) {
        this.f16916s = i4;
        this.f16917t = i5;
        this.f16918u = i6;
    }

    public void setMute(int i4) {
        this.f16913p = i4;
    }

    public void setPlacementId(String str) {
        this.f16908k = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.b.c cVar) {
        this.f16911n = cVar;
    }

    public void setRewardId(String str) {
        this.f16912o = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f16909l = cVar;
    }

    public void setUnitId(String str) {
        this.f16907j = str;
    }

    public void setUserId(String str) {
        this.f16910m = str;
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj, String str) {
        g.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    private String a(int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            af.b("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private boolean b(int i4) {
        if (i4 == 1) {
            this.f16906i.setRequestedOrientation(12);
            return true;
        } else if (i4 != 2) {
            return false;
        } else {
            try {
                this.f16906i.setRequestedOrientation(11);
                return true;
            } catch (Throwable th) {
                af.b("AbstractJSContainer", th.getMessage(), th);
                return false;
            }
        }
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final String b() {
        c cVar;
        if (!TextUtils.isEmpty(this.f16908k) || (cVar = this.f16909l) == null || TextUtils.isEmpty(cVar.z())) {
            return this.f16908k;
        }
        return this.f16909l.z();
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        af.b("AbstractJSContainer", str);
        Activity activity = this.f16906i;
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r4 = r4.getRewardTemplateMode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.videocommon.d.c r3, com.mbridge.msdk.foundation.entity.CampaignEx r4) {
        /*
            r2 = this;
            int r0 = r2.c(r4)
            r1 = 1
            if (r0 != r1) goto L_0x0008
            goto L_0x0027
        L_0x0008:
            if (r4 == 0) goto L_0x0019
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()
            if (r4 == 0) goto L_0x0019
            int r4 = r4.b()
            boolean r4 = r2.b((int) r4)
            goto L_0x001a
        L_0x0019:
            r4 = 0
        L_0x001a:
            if (r4 != 0) goto L_0x0027
            if (r3 == 0) goto L_0x0027
            com.mbridge.msdk.videocommon.d.c r3 = r2.f16909l
            int r3 = r3.c()
            r2.b((int) r3)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.container.AbstractJSContainer.a(com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }
}
