package j$.util;

import java.util.Arrays;

public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f5676a = "";

    /* renamed from: b  reason: collision with root package name */
    public final String f5677b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5678c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f5679d;

    /* renamed from: e  reason: collision with root package name */
    public int f5680e;

    /* renamed from: f  reason: collision with root package name */
    public int f5681f;

    public x0(CharSequence charSequence) {
        Objects.requireNonNull("", "The prefix must not be null");
        Objects.requireNonNull(charSequence, "The delimiter must not be null");
        Objects.requireNonNull("", "The suffix must not be null");
        this.f5677b = charSequence.toString();
        this.f5678c = "";
    }

    public static int c(String str, char[] cArr, int i4) {
        int length = str.length();
        str.getChars(0, length, cArr, i4);
        return length;
    }

    public final String toString() {
        String[] strArr = this.f5679d;
        int i4 = this.f5680e;
        String str = this.f5676a;
        int length = str.length();
        String str2 = this.f5678c;
        int length2 = str2.length() + length;
        if (length2 == 0) {
            b();
            return i4 == 0 ? "" : strArr[0];
        }
        char[] cArr = new char[(this.f5681f + length2)];
        int c5 = c(str, cArr, 0);
        if (i4 > 0) {
            int c6 = c(strArr[0], cArr, c5) + c5;
            for (int i5 = 1; i5 < i4; i5++) {
                int c7 = c(this.f5677b, cArr, c6) + c6;
                c6 = c(strArr[i5], cArr, c7) + c7;
            }
            c5 = c6;
        }
        c(str2, cArr, c5);
        return new String(cArr);
    }

    public final void a(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        String[] strArr = this.f5679d;
        if (strArr == null) {
            this.f5679d = new String[8];
        } else {
            int i4 = this.f5680e;
            if (i4 == strArr.length) {
                this.f5679d = (String[]) Arrays.copyOf(strArr, i4 * 2);
            }
            this.f5681f = this.f5677b.length() + this.f5681f;
        }
        this.f5681f = valueOf.length() + this.f5681f;
        String[] strArr2 = this.f5679d;
        int i5 = this.f5680e;
        this.f5680e = i5 + 1;
        strArr2[i5] = valueOf;
    }

    public final void b() {
        String[] strArr;
        if (this.f5680e > 1) {
            char[] cArr = new char[this.f5681f];
            int c5 = c(this.f5679d[0], cArr, 0);
            int i4 = 1;
            do {
                int c6 = c(this.f5677b, cArr, c5) + c5;
                c5 = c(this.f5679d[i4], cArr, c6) + c6;
                strArr = this.f5679d;
                strArr[i4] = null;
                i4++;
            } while (i4 < this.f5680e);
            this.f5680e = 1;
            strArr[0] = new String(cArr);
        }
    }
}
