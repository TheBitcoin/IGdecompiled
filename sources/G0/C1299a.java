package G0;

import E0.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
import y0.C2420j;

/* renamed from: G0.a  reason: case insensitive filesystem */
public class C1299a {

    /* renamed from: a  reason: collision with root package name */
    private final File f6517a;

    public C1299a(g gVar) {
        this.f6517a = gVar.g("com.crashlytics.settings.json");
    }

    private File a() {
        return this.f6517a;
    }

    public JSONObject b() {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        v0.g.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File a5 = a();
            if (a5.exists()) {
                fileInputStream = new FileInputStream(a5);
                try {
                    jSONObject = new JSONObject(C2420j.A(fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e5) {
                    e = e5;
                    try {
                        v0.g.f().e("Failed to fetch cached settings", e);
                        C2420j.f(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        C2420j.f(fileInputStream, "Error while closing settings cache file.");
                        throw th;
                    }
                }
            } else {
                v0.g.f().i("Settings file does not exist.");
                jSONObject = null;
            }
            C2420j.f(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            v0.g.f().e("Failed to fetch cached settings", e);
            C2420j.f(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
            C2420j.f(fileInputStream, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j4, JSONObject jSONObject) {
        v0.g.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put("expires_at", j4);
                FileWriter fileWriter2 = new FileWriter(a());
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    C2420j.f(fileWriter2, "Failed to close settings writer.");
                } catch (Exception e5) {
                    e = e5;
                    fileWriter = fileWriter2;
                    try {
                        v0.g.f().e("Failed to cache settings", e);
                        C2420j.f(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        th = th;
                        C2420j.f(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    C2420j.f(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                v0.g.f().e("Failed to cache settings", e);
                C2420j.f(fileWriter, "Failed to close settings writer.");
            }
        }
    }
}
