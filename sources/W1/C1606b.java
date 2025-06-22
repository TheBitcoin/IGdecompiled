package W1;

import java.io.InputStream;
import java.util.jar.JarFile;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m3.d;

/* renamed from: W1.b  reason: case insensitive filesystem */
public final class C1606b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8669b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f8670a = new StringBuilder();

    /* renamed from: W1.b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final String a(byte[] bArr, int i4, int i5, int i6) {
        if (i6 < 0) {
            return null;
        }
        return b(bArr, i5 + d(bArr, i4 + (i6 * 4)));
    }

    private final String b(byte[] bArr, int i4) {
        int i5 = ((bArr[i4 + 1] << 8) & 65280) | (bArr[i4] & 255);
        byte[] bArr2 = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr2[i6] = bArr[i4 + 2 + (i6 * 2)];
        }
        return new String(bArr2, d.f21160b);
    }

    private final void c(byte[] bArr) {
        int i4;
        String str;
        int d5 = (d(bArr, 16) * 4) + 36;
        int d6 = d(bArr, 12);
        int i5 = d6;
        while (true) {
            if (i5 >= bArr.length - 4) {
                break;
            } else if (d(bArr, i5) == 1048834) {
                d6 = i5;
                break;
            } else {
                i5 += 4;
            }
        }
        int i6 = 0;
        while (i4 < bArr.length) {
            int d7 = d(bArr, i4);
            int d8 = d(bArr, i4 + 20);
            switch (d7) {
                case 1048834:
                    int d9 = d(bArr, i4 + 28);
                    i4 += 36;
                    String a5 = a(bArr, 36, d5, d8);
                    StringBuilder sb = new StringBuilder();
                    for (int i7 = 0; i7 < d9; i7++) {
                        int d10 = d(bArr, i4 + 4);
                        int d11 = d(bArr, i4 + 8);
                        int d12 = d(bArr, i4 + 16);
                        i4 += 20;
                        String a6 = a(bArr, 36, d5, d10);
                        if (d11 != -1) {
                            str = a(bArr, 36, d5, d11);
                        } else {
                            str = String.valueOf(d12);
                        }
                        sb.append(' ' + a6 + "=\"" + str + '\"');
                    }
                    e(i6, '<' + a5 + sb + '>');
                    i6++;
                    break;
                case 1048835:
                    i6--;
                    i4 += 24;
                    e(i6, "</" + a(bArr, 36, d5, d8) + '>');
                    break;
                default:
                    return;
            }
        }
    }

    private final int d(byte[] bArr, int i4) {
        return (bArr[i4] & 255) | ((bArr[i4 + 3] << 24) & -16777216) | ((bArr[i4 + 2] << 16) & 16711680) | ((bArr[i4 + 1] << 8) & 65280);
    }

    private final void e(int i4, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = "                                             ".substring(0, (int) Math.min((double) (i4 * 2), (double) 45));
        m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = this.f8670a;
        sb3.append(sb2);
        sb3.append(10);
    }

    public final String f(String str) {
        try {
            JarFile jarFile = new JarFile(str);
            InputStream inputStream = jarFile.getInputStream(jarFile.getEntry("AndroidManifest.xml"));
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            c(bArr);
        } catch (Exception unused) {
        }
        String sb = this.f8670a.toString();
        m.d(sb, "sbResult.toString()");
        return sb;
    }
}
