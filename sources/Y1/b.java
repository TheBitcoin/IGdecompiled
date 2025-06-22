package y1;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private a f22744a;

    /* renamed from: b  reason: collision with root package name */
    protected final C0274b f22745b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: y1.b$b  reason: collision with other inner class name */
    public interface C0274b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0274b bVar) {
        this.f22745b = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.f22744a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }

    public void c(a aVar) {
        this.f22744a = aVar;
    }
}
