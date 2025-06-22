package U3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.m;

/* renamed from: U3.a  reason: case insensitive filesystem */
public final class C2588a {

    /* renamed from: a  reason: collision with root package name */
    public static final C2588a f24052a = new C2588a();

    public static Date a(C2588a aVar, String str, String str2, Locale locale, int i4) {
        String str3;
        if ((i4 & 2) != 0) {
            str3 = "yyyy-MM-dd'T'HH:mm:ss";
        } else {
            str3 = null;
        }
        m.e(str, "dateString");
        m.e(str3, "format");
        m.e(locale, "locale");
        return new SimpleDateFormat(str3, locale).parse(str);
    }
}
