package P;

import M.C0328i;
import android.util.Log;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f604a;

    /* renamed from: b  reason: collision with root package name */
    private final String f605b;

    /* renamed from: c  reason: collision with root package name */
    private final C0328i f606c;

    /* renamed from: d  reason: collision with root package name */
    private final int f607d;

    public a(String str, String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.f605b = str2;
        this.f604a = str;
        this.f606c = new C0328i(str);
        int i4 = 2;
        while (i4 <= 7 && !Log.isLoggable(this.f604a, i4)) {
            i4++;
        }
        this.f607d = i4;
    }

    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.f604a, c(str, objArr));
        }
    }

    public void b(String str, Object... objArr) {
        Log.e(this.f604a, c(str, objArr));
    }

    /* access modifiers changed from: protected */
    public String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f605b.concat(str);
    }

    public boolean d(int i4) {
        if (this.f607d <= i4) {
            return true;
        }
        return false;
    }
}
