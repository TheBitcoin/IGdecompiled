package G2;

import R2.l;
import R2.p;
import S2.H;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import java.util.Map;
import kotlin.jvm.internal.m;
import m3.j;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0087a f6588a = new C0087a();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f6589b;

    /* renamed from: G2.a$a  reason: collision with other inner class name */
    public static final class C0087a {
        public final String a(String str) {
            String str2;
            m.e(str, "str");
            if (new j("^[A-Za-z0-9\\-_]+$").e(str)) {
                int length = str.length();
                String str3 = "";
                int i4 = 0;
                while (i4 < length) {
                    char charAt = str.charAt(i4);
                    i4++;
                    Integer num = (Integer) a.f6589b.get(String.valueOf(charAt));
                    if (num == null) {
                        str2 = null;
                    } else {
                        str2 = Integer.toString(num.intValue(), m3.a.a(2));
                        m.d(str2, "toString(this, checkRadix(radix))");
                    }
                    if (str2 != null) {
                        StringBuilder a5 = A2.a.a(str3);
                        a5.append(m3.m.s("0", 6 - str2.length()));
                        a5.append(str2);
                        str3 = a5.toString();
                    }
                }
                return str3;
            }
            C0087a aVar = a.f6588a;
            throw new e(m.m("g.a", ": Invalidly encoded Base64URL string"));
        }

        public final String b(String str) {
            m.e(str, "str");
            if (new j("^[0-1]+$").e(str)) {
                String str2 = "";
                for (String parseInt : m3.m.v0(str, 6)) {
                    str2 = m.m(str2, Character.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(Integer.parseInt(parseInt, 2))));
                }
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            C0087a aVar = a.f6588a;
            sb.append("g.a");
            sb.append(": invalid bitField + ");
            sb.append(str);
            throw new e(sb.toString());
        }
    }

    static {
        l a5 = p.a(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
        l a6 = p.a("B", 1);
        l a7 = p.a("C", 2);
        l a8 = p.a("D", 3);
        l a9 = p.a(ExifInterface.LONGITUDE_EAST, 4);
        l a10 = p.a("F", 5);
        l a11 = p.a("G", 6);
        l a12 = p.a("H", 7);
        l lVar = a12;
        f6589b = H.j(a5, a6, a7, a8, a9, a10, a11, lVar, p.a("I", 8), p.a("J", 9), p.a("K", 10), p.a("L", 11), p.a("M", 12), p.a("N", 13), p.a("O", 14), p.a("P", 15), p.a("Q", 16), p.a("R", 17), p.a(ExifInterface.LATITUDE_SOUTH, 18), p.a(ExifInterface.GPS_DIRECTION_TRUE, 19), p.a("U", 20), p.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 21), p.a(ExifInterface.LONGITUDE_WEST, 22), p.a("X", 23), p.a("Y", 24), p.a("Z", 25), p.a("a", 26), p.a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, 27), p.a("c", 28), p.a("d", 29), p.a("e", 30), p.a("f", 31), p.a("g", 32), p.a("h", 33), p.a(i.f13483a, 34), p.a("j", 35), p.a(CampaignEx.JSON_KEY_AD_K, 36), p.a("l", 37), p.a("m", 38), p.a("n", 39), p.a("o", 40), p.a(TtmlNode.TAG_P, 41), p.a(CampaignEx.JSON_KEY_AD_Q, 42), p.a(CampaignEx.JSON_KEY_AD_R, 43), p.a("s", 44), p.a("t", 45), p.a("u", 46), p.a("v", 47), p.a("w", 48), p.a("x", 49), p.a("y", 50), p.a("z", 51), p.a("0", 52), p.a("1", 53), p.a("2", 54), p.a(ExifInterface.GPS_MEASUREMENT_3D, 55), p.a("4", 56), p.a(CampaignEx.CLICKMODE_ON, 57), p.a("6", 58), p.a("7", 59), p.a("8", 60), p.a("9", 61), p.a("-", 62), p.a("_", 63));
    }
}
