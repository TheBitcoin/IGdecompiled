package Z3;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.i  reason: case insensitive filesystem */
public abstract class C2620i {
    public static final List a(JSONObject jSONObject, String str) {
        m.e(jSONObject, "<this>");
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    int optInt = jSONArray.optInt(i4);
                    Integer valueOf = Integer.valueOf(optInt);
                    if (optInt == 0) {
                        valueOf = null;
                    }
                    if (valueOf != null) {
                        arrayList.add(Integer.valueOf(valueOf.intValue()));
                    }
                    i4 = i5;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final List b(JSONObject jSONObject, String str) {
        m.e(jSONObject, "<this>");
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    String optString = jSONArray.optString(i4);
                    m.d(optString, "item");
                    if (optString.length() <= 0) {
                        optString = null;
                    }
                    if (optString != null) {
                        arrayList.add(optString);
                    }
                    i4 = i5;
                }
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }
}
