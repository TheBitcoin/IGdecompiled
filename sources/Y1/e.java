package y1;

import java.util.HashSet;
import org.json.JSONObject;
import q1.n;
import t1.C2286c;
import y1.b;

public class e extends C2436a {
    public e(b.C0274b bVar, HashSet hashSet, JSONObject jSONObject, long j4) {
        super(bVar, hashSet, jSONObject, j4);
    }

    private void e(String str) {
        C2286c e5 = C2286c.e();
        if (e5 != null) {
            for (n nVar : e5.c()) {
                if (this.f22741c.contains(nVar.s())) {
                    nVar.t().e(str, this.f22743e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        return this.f22742d.toString();
    }
}
