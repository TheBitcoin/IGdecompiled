package Q3;

import P3.C2546b;
import Y3.C2611a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Q3.k  reason: case insensitive filesystem */
public class C2560k {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23908b = C2546b.i(C2560k.class);

    /* renamed from: a  reason: collision with root package name */
    private final String f23909a;

    public C2560k(String str) {
        this.f23909a = str;
    }

    private C2559j a(C2556g gVar) {
        if (gVar.a().isEmpty()) {
            return null;
        }
        return new C2559j(this.f23909a + gVar);
    }

    private C2559j b(List list) {
        if (list.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((C2556g) it.next()).a());
            }
            jSONObject.put("requests", jSONArray);
            return new C2559j(this.f23909a, jSONObject, list.size());
        } catch (JSONException e5) {
            C2611a.b(f23908b).i(e5, "Cannot create json object:\n%s", TextUtils.join(", ", list));
            return null;
        }
    }

    public List c(List list) {
        C2559j jVar;
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        if (list.size() == 1) {
            C2559j a5 = a((C2556g) list.get(0));
            if (a5 == null) {
                return Collections.EMPTY_LIST;
            }
            return Collections.singletonList(a5);
        }
        ArrayList arrayList = new ArrayList((int) Math.ceil((((double) list.size()) * 1.0d) / 20.0d));
        int i4 = 0;
        while (i4 < list.size()) {
            int i5 = i4 + 20;
            List subList = list.subList(i4, Math.min(i5, list.size()));
            if (subList.size() == 1) {
                jVar = a((C2556g) subList.get(0));
            } else {
                jVar = b(subList);
            }
            if (jVar != null) {
                arrayList.add(jVar);
            }
            i4 = i5;
        }
        return arrayList;
    }
}
