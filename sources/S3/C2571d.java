package S3;

import P3.C2546b;
import Y3.C2611a;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Locale;

/* renamed from: S3.d  reason: case insensitive filesystem */
public class C2571d {

    /* renamed from: d  reason: collision with root package name */
    private static final String f23947d = C2546b.i(C2571d.class);

    /* renamed from: a  reason: collision with root package name */
    private final Context f23948a;

    /* renamed from: b  reason: collision with root package name */
    private final C2572e f23949b;

    /* renamed from: c  reason: collision with root package name */
    private final C2568a f23950c;

    public C2571d(Context context, C2572e eVar, C2568a aVar) {
        this.f23948a = context;
        this.f23949b = eVar;
        this.f23950c = aVar;
    }

    public int[] a() {
        try {
            Display defaultDisplay = ((WindowManager) this.f23948a.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i4 = displayMetrics.widthPixels;
            int i5 = displayMetrics.heightPixels;
            if (i4 == -1 || i5 == -1) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                i4 = displayMetrics2.widthPixels;
                i5 = displayMetrics2.heightPixels;
            }
            return new int[]{i4, i5};
        } catch (NullPointerException e5) {
            C2611a.b(f23947d).e(e5, "Window service was not available from this context", new Object[0]);
            return null;
        }
    }

    public String b() {
        String a5 = this.f23949b.a();
        if (a5 != null && !a5.startsWith("Apache-HttpClient/UNAVAILABLE (java")) {
            return a5;
        }
        String b5 = this.f23949b.b();
        if (b5 == null) {
            b5 = "0.0.0";
        }
        String c5 = this.f23950c.c();
        String b6 = this.f23950c.b();
        String a6 = this.f23950c.a();
        return String.format(Locale.US, "Dalvik/%s (Linux; U; Android %s; %s Build/%s)", new Object[]{b5, c5, b6, a6});
    }

    public String c() {
        return Locale.getDefault().getLanguage();
    }
}
