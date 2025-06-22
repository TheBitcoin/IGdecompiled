package g2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import g2.C2050h;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Q {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20451d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private C2053k f20452a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f20453b;

    /* renamed from: c  reason: collision with root package name */
    private int f20454c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final Q a(L l4, C2053k kVar) {
            int i4;
            m.e(l4, "res");
            m.e(kVar, "category");
            Q q4 = new Q((C2053k) null, (ArrayList) null, 0, 7, (C2103g) null);
            q4.e(kVar);
            if (l4.e() != null) {
                JSONObject e5 = l4.e();
                m.b(e5);
                if (!e5.isNull("success")) {
                    i4 = e5.optInt("success");
                } else {
                    i4 = 0;
                }
                JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
                        q4.b().s(optJSONObject.optString(CampaignEx.JSON_KEY_TITLE));
                    }
                    if (!optJSONObject.isNull("description")) {
                        q4.b().p(optJSONObject.optString("description"));
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("apps");
                    if (optJSONArray != null && i4 == 1 && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                            m.d(optJSONObject2, "optJSONObject(...)");
                            q4.a().add(C2050h.b.b(C2050h.f20600F0, optJSONObject2, (Context) null, 2, (Object) null));
                        }
                    }
                }
            }
            return q4;
        }

        private a() {
        }
    }

    public Q(C2053k kVar, ArrayList arrayList, int i4) {
        m.e(kVar, "category");
        m.e(arrayList, "apps");
        this.f20452a = kVar;
        this.f20453b = arrayList;
        this.f20454c = i4;
    }

    public final ArrayList a() {
        return this.f20453b;
    }

    public final C2053k b() {
        return this.f20452a;
    }

    public final int c() {
        return this.f20454c;
    }

    public final void d(ArrayList arrayList) {
        m.e(arrayList, "<set-?>");
        this.f20453b = arrayList;
    }

    public final void e(C2053k kVar) {
        m.e(kVar, "<set-?>");
        this.f20452a = kVar;
    }

    public final void f(int i4) {
        this.f20454c = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Q(C2053k kVar, ArrayList arrayList, int i4, int i5, C2103g gVar) {
        this((i5 & 1) != 0 ? new C2053k(0, (String) null, (String) null, 7, (C2103g) null) : kVar, (i5 & 2) != 0 ? new ArrayList() : arrayList, (i5 & 4) != 0 ? 0 : i4);
    }
}
