package u1;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;
import q1.n;
import t1.C2286c;
import u1.C2307a;
import w1.C2336c;
import w1.C2338e;
import w1.C2342i;

/* renamed from: u1.c  reason: case insensitive filesystem */
public class C2309c implements C2307a {

    /* renamed from: a  reason: collision with root package name */
    private final C2307a f21868a;

    public C2309c(C2307a aVar) {
        this.f21868a = aVar;
    }

    public JSONObject a(View view) {
        JSONObject b5 = C2336c.b(0, 0, 0, 0);
        C2336c.i(b5, C2338e.a());
        return b5;
    }

    /* access modifiers changed from: package-private */
    public ArrayList b() {
        View rootView;
        ArrayList arrayList = new ArrayList();
        C2286c e5 = C2286c.e();
        if (e5 != null) {
            Collection<n> a5 = e5.a();
            IdentityHashMap identityHashMap = new IdentityHashMap((a5.size() * 2) + 3);
            for (n n4 : a5) {
                View n5 = n4.n();
                if (n5 != null && C2342i.g(n5) && (rootView = n5.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float d5 = C2342i.d(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C2342i.d((View) arrayList.get(size - 1)) > d5) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    public void a(View view, JSONObject jSONObject, C2307a.C0268a aVar, boolean z4, boolean z5) {
        ArrayList b5 = b();
        int size = b5.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = b5.get(i4);
            i4++;
            aVar.a((View) obj, this.f21868a, jSONObject, z5);
        }
    }
}
