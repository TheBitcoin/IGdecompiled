package G0;

import org.json.JSONObject;
import v0.g;
import y0.C2410C;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final C2410C f6550a;

    h(C2410C c5) {
        this.f6550a = c5;
    }

    private static i a(int i4) {
        if (i4 == 3) {
            return new m();
        }
        g f4 = g.f();
        f4.d("Could not determine SettingsJsonTransform for settings version " + i4 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f6550a, jSONObject);
    }
}
