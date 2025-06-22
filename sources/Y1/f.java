package y1;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;
import q1.n;
import t1.C2286c;
import w1.C2336c;
import y1.b;

public class f extends C2436a {
    public f(b.C0274b bVar, HashSet hashSet, JSONObject jSONObject, long j4) {
        super(bVar, hashSet, jSONObject, j4);
    }

    private void e(String str) {
        C2286c e5 = C2286c.e();
        if (e5 != null) {
            for (n nVar : e5.c()) {
                if (this.f22741c.contains(nVar.s())) {
                    nVar.t().p(str, this.f22743e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String doInBackground(Object... objArr) {
        if (C2336c.v(this.f22742d, this.f22745b.a())) {
            return null;
        }
        this.f22745b.a(this.f22742d);
        return this.f22742d.toString();
    }
}
