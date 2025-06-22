package j$.time.format;

import j$.time.temporal.a;
import j$.util.Objects;

public final class j implements f {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f4945d = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};

    /* renamed from: e  reason: collision with root package name */
    public static final j f4946e = new j("+HH:MM:ss", "Z");

    /* renamed from: a  reason: collision with root package name */
    public final String f4947a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4948b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4949c;

    static {
        new j("+HH:MM:ss", "0");
    }

    public j(String str, String str2) {
        Objects.requireNonNull(str, "pattern");
        Objects.requireNonNull(str2, "noOffsetText");
        int i4 = 0;
        while (true) {
            String[] strArr = f4945d;
            if (i4 >= 22) {
                throw new IllegalArgumentException("Invalid zone offset pattern: ".concat(str));
            } else if (strArr[i4].equals(str)) {
                this.f4948b = i4;
                this.f4949c = i4 % 11;
                this.f4947a = str2;
                return;
            } else {
                i4++;
            }
        }
    }

    public final boolean j(p pVar, StringBuilder sb) {
        String str;
        Long a5 = pVar.a(a.OFFSET_SECONDS);
        boolean z4 = false;
        if (a5 == null) {
            return false;
        }
        long longValue = a5.longValue();
        int i4 = (int) longValue;
        if (longValue == ((long) i4)) {
            String str2 = this.f4947a;
            if (i4 == 0) {
                sb.append(str2);
                return true;
            }
            int abs = Math.abs((i4 / 3600) % 100);
            int abs2 = Math.abs((i4 / 60) % 60);
            int abs3 = Math.abs(i4 % 60);
            int length = sb.length();
            if (i4 < 0) {
                str = "-";
            } else {
                str = "+";
            }
            sb.append(str);
            if (this.f4948b >= 11 && abs < 10) {
                sb.append((char) (abs + 48));
            } else {
                a(false, abs, sb);
            }
            int i5 = this.f4949c;
            if ((i5 >= 3 && i5 <= 8) || ((i5 >= 9 && abs3 > 0) || (i5 >= 1 && abs2 > 0))) {
                a(i5 > 0 && i5 % 2 == 0, abs2, sb);
                abs += abs2;
                if (i5 == 7 || i5 == 8 || (i5 >= 5 && abs3 > 0)) {
                    if (i5 > 0 && i5 % 2 == 0) {
                        z4 = true;
                    }
                    a(z4, abs3, sb);
                    abs += abs3;
                }
            }
            if (abs == 0) {
                sb.setLength(length);
                sb.append(str2);
            }
            return true;
        }
        throw new ArithmeticException();
    }

    public static void a(boolean z4, int i4, StringBuilder sb) {
        sb.append(z4 ? ":" : "");
        sb.append((char) ((i4 / 10) + 48));
        sb.append((char) ((i4 % 10) + 48));
    }

    public final String toString() {
        String replace = this.f4947a.replace("'", "''");
        String str = f4945d[this.f4948b];
        return "Offset(" + str + ",'" + replace + "')";
    }
}
