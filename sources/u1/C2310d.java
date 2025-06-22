package u1;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;
import u1.C2307a;
import w1.C2336c;

/* renamed from: u1.d  reason: case insensitive filesystem */
public class C2310d implements C2307a {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21869a = new int[2];

    private void b(ViewGroup viewGroup, JSONObject jSONObject, C2307a.C0268a aVar, boolean z4) {
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            aVar.a(viewGroup.getChildAt(i4), this, jSONObject, z4);
        }
    }

    private void c(ViewGroup viewGroup, JSONObject jSONObject, C2307a.C0268a aVar, boolean z4) {
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList2.get(i5);
            i5++;
            ArrayList arrayList3 = (ArrayList) hashMap.get((Float) obj);
            int size2 = arrayList3.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList3.get(i6);
                i6++;
                aVar.a((View) obj2, this, jSONObject, z4);
            }
        }
    }

    public JSONObject a(View view) {
        if (view == null) {
            return C2336c.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f21869a);
        int[] iArr = this.f21869a;
        return C2336c.b(iArr[0], iArr[1], width, height);
    }

    public void a(View view, JSONObject jSONObject, C2307a.C0268a aVar, boolean z4, boolean z5) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (z4) {
                c(viewGroup, jSONObject, aVar, z5);
            } else {
                b(viewGroup, jSONObject, aVar, z5);
            }
        }
    }
}
