package com.mbridge.msdk.video.signal.a;

import android.util.Base64;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import org.json.JSONObject;

public final class n extends f {

    /* renamed from: a  reason: collision with root package name */
    private WebView f16619a;

    public n(WebView webView) {
        this.f16619a = webView;
    }

    public final void a(int i4) {
        super.a(i4);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i4);
            g.a().a(this.f16619a, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i4, String str) {
        super.a(i4, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i4);
            jSONObject.put("pt", str);
            g.a().a(this.f16619a, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(MBridgeVideoView.b bVar) {
        super.a(bVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(bVar.f16494a, bVar.f16495b));
            jSONObject.put("time", String.valueOf(bVar.f16494a));
            jSONObject.put(TypedValues.TransitionType.S_DURATION, String.valueOf(bVar.f16495b));
            g.a().a(this.f16619a, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private String a(int i4, int i5) {
        if (i5 != 0) {
            double d5 = (double) (((float) i4) / ((float) i5));
            try {
                return ak.a(Double.valueOf(d5)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i5 + "";
    }

    public final void a(Object obj) {
        String str;
        super.a(obj);
        if (obj == null || !(obj instanceof String)) {
            str = "";
        } else {
            str = Base64.encodeToString(obj.toString().getBytes(), 2);
        }
        g.a().a(this.f16619a, "webviewshow", str);
    }

    public final void a(int i4, int i5, int i6, int i7) {
        super.a(i4, i5, i6, i7);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = "landscape";
            if (i4 != 2 ? i5 != 2 : i5 == 1) {
                str = "portrait";
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i6);
            jSONObject2.put("screen_height", i7);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
            g.a().a(this.f16619a, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
