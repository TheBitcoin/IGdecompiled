package Z3;

import A1.d;
import C2.b;
import C2.c;
import E2.a;
import E2.g;
import U3.C2588a;
import android.content.Context;
import b3.C1642b;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.b  reason: case insensitive filesystem */
public final class C2613b implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f24372a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f24373b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f24374c;

    public C2613b(Context context, Locale locale) {
        m.e(context, "context");
        m.e(locale, "appLocale");
        this.f24372a = context;
        this.f24373b = locale;
    }

    public Object a(String str) {
        Long l4;
        Throwable th;
        m.e(str, "jsonString");
        try {
            if (str.length() == 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f24372a.getResources().openRawResource(d.cmp_list)));
                try {
                    str = bufferedReader.readLine();
                    C1642b.a(bufferedReader, (Throwable) null);
                } catch (Throwable th2) {
                    C1642b.a(bufferedReader, th);
                    throw th2;
                }
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f24374c = jSONObject;
            C2588a aVar = C2588a.f24052a;
            String string = jSONObject.getString("lastUpdated");
            m.d(string, "cmpListJson.getString(\"lastUpdated\")");
            Date a5 = C2588a.a(aVar, string, (String) null, this.f24373b, 2);
            if (a5 == null) {
                l4 = null;
            } else {
                l4 = Long.valueOf(a5.getTime());
            }
            return new g(l4, b());
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new g((Long) null, (Map) null, 3);
        }
    }

    public final Map b() {
        int i4;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = this.f24374c;
        if (jSONObject == null) {
            m.u("cmpListJson");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cmps");
        JSONArray names = jSONObject2.names();
        int i5 = 0;
        if (names == null) {
            i4 = 0;
        } else {
            i4 = names.length();
        }
        while (i5 < i4) {
            int i6 = i5 + 1;
            if (names == null || (str = names.getString(i5)) == null) {
                str = "0";
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
            int i7 = jSONObject3.getInt("id");
            String string = jSONObject3.getString(RewardPlus.NAME);
            m.d(string, "cmp.getString(\"name\")");
            linkedHashMap.put(str, new a(i7, string, jSONObject3.getBoolean("isCommercial")));
            i5 = i6;
        }
        return linkedHashMap;
    }
}
