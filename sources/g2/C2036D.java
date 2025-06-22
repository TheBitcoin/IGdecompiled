package g2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g2.D  reason: case insensitive filesystem */
public final class C2036D {

    /* renamed from: a  reason: collision with root package name */
    private long f20349a;

    /* renamed from: b  reason: collision with root package name */
    private String f20350b;

    /* renamed from: c  reason: collision with root package name */
    private String f20351c;

    /* renamed from: d  reason: collision with root package name */
    private String f20352d;

    /* renamed from: e  reason: collision with root package name */
    private String f20353e;

    /* renamed from: f  reason: collision with root package name */
    private String f20354f;

    /* renamed from: g  reason: collision with root package name */
    private String f20355g;

    /* renamed from: h  reason: collision with root package name */
    private String f20356h;

    /* renamed from: i  reason: collision with root package name */
    private String f20357i;

    /* renamed from: j  reason: collision with root package name */
    private long f20358j;

    /* renamed from: k  reason: collision with root package name */
    private C2050h f20359k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList f20360l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private ArrayList f20361m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private ArrayList f20362n = new ArrayList();

    public final String a() {
        return this.f20357i;
    }

    public final ArrayList b() {
        return this.f20361m;
    }

    public final String c() {
        return this.f20355g;
    }

    public final String d() {
        if (this.f20355g == null) {
            return null;
        }
        return this.f20355g + UptodownApp.f17422D.o() + ":webp";
    }

    public final String e() {
        return this.f20356h;
    }

    public final String f() {
        if (this.f20356h == null) {
            return null;
        }
        return this.f20356h + UptodownApp.f17422D.q() + ":webp";
    }

    public final ArrayList g() {
        return this.f20360l;
    }

    public final String h() {
        return this.f20353e;
    }

    public final C2050h i() {
        return this.f20359k;
    }

    public final ArrayList j() {
        return this.f20362n;
    }

    public final String k() {
        return this.f20350b;
    }

    public final String l() {
        return this.f20354f;
    }

    public final String m() {
        return this.f20352d;
    }

    public final String n() {
        return this.f20351c;
    }

    public final ArrayList o(JSONArray jSONArray) {
        m.e(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            C2050h hVar = new C2050h();
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            m.b(optJSONObject);
            C2050h.b(hVar, optJSONObject, (Context) null, 2, (Object) null);
            arrayList.add(hVar);
        }
        return arrayList;
    }

    public final void p(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject != null) {
            if (!optJSONObject.isNull(RewardPlus.NAME)) {
                this.f20350b = optJSONObject.optString(RewardPlus.NAME);
            }
            if (!optJSONObject.isNull("webpage")) {
                this.f20351c = optJSONObject.optString("webpage");
            }
            if (!optJSONObject.isNull("twitter")) {
                this.f20352d = optJSONObject.optString("twitter");
            }
            if (!optJSONObject.isNull("instagram")) {
                this.f20353e = optJSONObject.optString("instagram");
            }
            if (!optJSONObject.isNull("tiktok")) {
                this.f20354f = optJSONObject.optString("tiktok");
            }
            if (!optJSONObject.isNull("feature")) {
                this.f20355g = optJSONObject.optString("feature");
            }
            if (!optJSONObject.isNull(RewardPlus.ICON)) {
                this.f20356h = optJSONObject.optString(RewardPlus.ICON);
            }
            if (!optJSONObject.isNull("mainAppID")) {
                this.f20358j = optJSONObject.optLong("mainAppID");
            }
            if (!optJSONObject.isNull("organizationID")) {
                this.f20349a = optJSONObject.optLong("organizationID");
            }
            if (!optJSONObject.isNull("bio")) {
                this.f20357i = optJSONObject.optString("bio");
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mainApp");
        if (optJSONObject2 != null) {
            C2050h hVar = new C2050h();
            C2050h.b(hVar, optJSONObject2, (Context) null, 2, (Object) null);
            this.f20359k = hVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("importantApps");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                C2050h hVar2 = new C2050h();
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i4);
                m.b(optJSONObject3);
                C2050h.b(hVar2, optJSONObject3, (Context) null, 2, (Object) null);
                arrayList.add(hVar2);
            }
            if (!arrayList.isEmpty()) {
                this.f20360l = arrayList;
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("carouselApps");
        if (optJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            int length2 = optJSONArray2.length();
            for (int i5 = 0; i5 < length2; i5++) {
                C2050h hVar3 = new C2050h();
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i5);
                m.b(optJSONObject4);
                C2050h.b(hVar3, optJSONObject4, (Context) null, 2, (Object) null);
                arrayList2.add(hVar3);
            }
            if (!arrayList2.isEmpty()) {
                this.f20361m = arrayList2;
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("apps");
        if (optJSONArray3 != null) {
            ArrayList arrayList3 = new ArrayList();
            int length3 = optJSONArray3.length();
            for (int i6 = 0; i6 < length3; i6++) {
                C2050h hVar4 = new C2050h();
                JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i6);
                m.b(optJSONObject5);
                C2050h.b(hVar4, optJSONObject5, (Context) null, 2, (Object) null);
                arrayList3.add(hVar4);
            }
            if (!arrayList3.isEmpty()) {
                this.f20362n = arrayList3;
            }
        }
    }

    public final void q(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f20362n = arrayList;
    }
}
