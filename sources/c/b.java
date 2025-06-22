package C;

import android.net.Uri;
import java.util.Map;

final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Map f104a;

    b(a aVar, Map map) {
        this.f104a = map;
    }

    public final void run() {
        Map map = this.f104a;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        d.a(buildUpon.build().toString());
    }
}
