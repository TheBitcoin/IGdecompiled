package i1;

import com.google.gson.internal.e;
import j$.util.Objects;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/* renamed from: i1.a  reason: case insensitive filesystem */
public class C2079a implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final Reader f20863a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20864b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f20865c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f20866d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f20867e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f20868f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f20869g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f20870h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f20871i;

    /* renamed from: j  reason: collision with root package name */
    private int f20872j;

    /* renamed from: k  reason: collision with root package name */
    private String f20873k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f20874l;

    /* renamed from: m  reason: collision with root package name */
    private int f20875m;

    /* renamed from: n  reason: collision with root package name */
    private String[] f20876n;

    /* renamed from: o  reason: collision with root package name */
    private int[] f20877o;

    /* renamed from: i1.a$a  reason: collision with other inner class name */
    class C0257a extends e {
        C0257a() {
        }

        public void a(C2079a aVar) {
            int i4 = aVar.f20870h;
            if (i4 == 0) {
                i4 = aVar.k();
            }
            if (i4 == 13) {
                aVar.f20870h = 9;
            } else if (i4 == 12) {
                aVar.f20870h = 8;
            } else if (i4 == 14) {
                aVar.f20870h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.L() + aVar.x());
            }
        }
    }

    static {
        e.f11681a = new C0257a();
    }

    public C2079a(Reader reader) {
        int[] iArr = new int[32];
        this.f20874l = iArr;
        this.f20875m = 1;
        iArr[0] = 6;
        this.f20876n = new String[32];
        this.f20877o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f20863a = reader;
    }

    private int G(boolean z4) {
        char c5;
        char[] cArr = this.f20865c;
        int i4 = this.f20866d;
        int i5 = this.f20867e;
        while (true) {
            if (i4 == i5) {
                this.f20866d = i4;
                if (o(1)) {
                    i4 = this.f20866d;
                    i5 = this.f20867e;
                } else if (!z4) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + x());
                }
            }
            int i6 = i4 + 1;
            c5 = cArr[i4];
            if (c5 == 10) {
                this.f20868f++;
                this.f20869g = i6;
            } else if (!(c5 == ' ' || c5 == 13 || c5 == 9)) {
                if (c5 == '/') {
                    this.f20866d = i6;
                    if (i6 == i5) {
                        this.f20866d = i4;
                        boolean o4 = o(2);
                        this.f20866d++;
                        if (!o4) {
                            break;
                        }
                    }
                    g();
                    int i7 = this.f20866d;
                    char c6 = cArr[i7];
                    if (c6 == '*') {
                        this.f20866d = i7 + 1;
                        if (S("*/")) {
                            i4 = this.f20866d + 2;
                            i5 = this.f20867e;
                        } else {
                            throw W("Unterminated comment");
                        }
                    } else if (c6 != '/') {
                        break;
                    } else {
                        this.f20866d = i7 + 1;
                        T();
                        i4 = this.f20866d;
                        i5 = this.f20867e;
                    }
                } else if (c5 == '#') {
                    this.f20866d = i6;
                    g();
                    T();
                    i4 = this.f20866d;
                    i5 = this.f20867e;
                } else {
                    this.f20866d = i6;
                    return c5;
                }
            }
            i4 = i6;
        }
        return c5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f20866d = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String I(char r10) {
        /*
            r9 = this;
            char[] r0 = r9.f20865c
            r1 = 0
        L_0x0003:
            int r2 = r9.f20866d
            int r3 = r9.f20867e
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.f20866d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004d
            r9.f20866d = r7
            int r7 = r7 - r3
            int r2 = r7 + -1
            if (r1 != 0) goto L_0x003e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L_0x003e:
            r1.append(r0, r3, r2)
            char r2 = r9.P()
            r1.append(r2)
            int r2 = r9.f20866d
            int r3 = r9.f20867e
            goto L_0x0007
        L_0x004d:
            r5 = 10
            if (r2 != r5) goto L_0x0058
            int r2 = r9.f20868f
            int r2 = r2 + r6
            r9.f20868f = r2
            r9.f20869g = r7
        L_0x0058:
            r2 = r7
            goto L_0x0009
        L_0x005a:
            if (r1 != 0) goto L_0x006a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f20866d = r2
            boolean r2 = r9.o(r6)
            if (r2 == 0) goto L_0x0078
            goto L_0x0003
        L_0x0078:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.W(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.C2079a.I(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String K() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.f20866d
            int r4 = r3 + r2
            int r5 = r6.f20867e
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f20865c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.g()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f20865c
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.o(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r1 = r2
            goto L_0x007e
        L_0x005e:
            if (r0 != 0) goto L_0x006b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L_0x006b:
            char[] r3 = r6.f20865c
            int r4 = r6.f20866d
            r0.append(r3, r4, r2)
            int r3 = r6.f20866d
            int r3 = r3 + r2
            r6.f20866d = r3
            r2 = 1
            boolean r2 = r6.o(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r0 != 0) goto L_0x008a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f20865c
            int r3 = r6.f20866d
            r0.<init>(r2, r3, r1)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.f20865c
            int r3 = r6.f20866d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L_0x0095:
            int r2 = r6.f20866d
            int r2 = r2 + r1
            r6.f20866d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.C2079a.K():java.lang.String");
    }

    private int M() {
        int i4;
        String str;
        String str2;
        char c5 = this.f20865c[this.f20866d];
        if (c5 == 't' || c5 == 'T') {
            str2 = "true";
            str = "TRUE";
            i4 = 5;
        } else if (c5 == 'f' || c5 == 'F') {
            str2 = "false";
            str = "FALSE";
            i4 = 6;
        } else if (c5 != 'n' && c5 != 'N') {
            return 0;
        } else {
            str2 = "null";
            str = "NULL";
            i4 = 7;
        }
        int length = str2.length();
        for (int i5 = 1; i5 < length; i5++) {
            if (this.f20866d + i5 >= this.f20867e && !o(i5 + 1)) {
                return 0;
            }
            char c6 = this.f20865c[this.f20866d + i5];
            if (c6 != str2.charAt(i5) && c6 != str.charAt(i5)) {
                return 0;
            }
        }
        if ((this.f20866d + length < this.f20867e || o(length + 1)) && w(this.f20865c[this.f20866d + length])) {
            return 0;
        }
        this.f20866d += length;
        this.f20870h = i4;
        return i4;
    }

    private int N() {
        int i4;
        char c5;
        boolean z4;
        char[] cArr = this.f20865c;
        int i5 = this.f20866d;
        int i6 = this.f20867e;
        int i7 = 0;
        int i8 = 0;
        char c6 = 0;
        boolean z5 = true;
        long j4 = 0;
        boolean z6 = false;
        while (true) {
            if (i5 + i8 == i6) {
                if (i8 == cArr.length) {
                    return i7;
                }
                if (!o(i8 + 1)) {
                    i4 = 0;
                    break;
                }
                i5 = this.f20866d;
                i6 = this.f20867e;
            }
            c5 = cArr[i5 + i8];
            i4 = 0;
            if (c5 != '+') {
                if (c5 != 'E' && c5 != 'e') {
                    if (c5 != '-') {
                        if (c5 != '.') {
                            if (c5 >= '0' && c5 <= '9') {
                                if (c6 == 1 || c6 == 0) {
                                    j4 = (long) (-(c5 - '0'));
                                    c6 = 2;
                                } else if (c6 == 2) {
                                    if (j4 == 0) {
                                        return 0;
                                    }
                                    long j5 = (10 * j4) - ((long) (c5 - '0'));
                                    int i9 = (j4 > -922337203685477580L ? 1 : (j4 == -922337203685477580L ? 0 : -1));
                                    if (i9 > 0 || (i9 == 0 && j5 < j4)) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    z5 &= z4;
                                    j4 = j5;
                                } else if (c6 == 3) {
                                    c6 = 4;
                                } else if (c6 == 5 || c6 == 6) {
                                    c6 = 7;
                                }
                            }
                        } else if (c6 != 2) {
                            return 0;
                        } else {
                            c6 = 3;
                        }
                    } else if (c6 == 0) {
                        c6 = 1;
                        z6 = true;
                    } else if (c6 != 5) {
                        return 0;
                    }
                    i8++;
                    i7 = 0;
                } else if (c6 != 2 && c6 != 4) {
                    return 0;
                } else {
                    c6 = 5;
                    i8++;
                    i7 = 0;
                }
            } else if (c6 != 5) {
                return 0;
            }
            c6 = 6;
            i8++;
            i7 = 0;
        }
        if (w(c5)) {
            return 0;
        }
        if (c6 == 2 && z5 && ((j4 != Long.MIN_VALUE || z6) && (j4 != 0 || !z6))) {
            if (!z6) {
                j4 = -j4;
            }
            this.f20871i = j4;
            this.f20866d += i8;
            this.f20870h = 15;
            return 15;
        } else if (c6 != 2 && c6 != 4 && c6 != 7) {
            return i4;
        } else {
            this.f20872j = i8;
            this.f20870h = 16;
            return 16;
        }
    }

    private void O(int i4) {
        int i5 = this.f20875m;
        int[] iArr = this.f20874l;
        if (i5 == iArr.length) {
            int i6 = i5 * 2;
            this.f20874l = Arrays.copyOf(iArr, i6);
            this.f20877o = Arrays.copyOf(this.f20877o, i6);
            this.f20876n = (String[]) Arrays.copyOf(this.f20876n, i6);
        }
        int[] iArr2 = this.f20874l;
        int i7 = this.f20875m;
        this.f20875m = i7 + 1;
        iArr2[i7] = i4;
    }

    private char P() {
        int i4;
        if (this.f20866d != this.f20867e || o(1)) {
            char[] cArr = this.f20865c;
            int i5 = this.f20866d;
            int i6 = i5 + 1;
            this.f20866d = i6;
            char c5 = cArr[i5];
            if (c5 == 10) {
                this.f20868f++;
                this.f20869g = i6;
                return c5;
            } else if (c5 == '\"' || c5 == '\'' || c5 == '/' || c5 == '\\') {
                return c5;
            } else {
                if (c5 == 'b') {
                    return 8;
                }
                if (c5 == 'f') {
                    return 12;
                }
                if (c5 == 'n') {
                    return 10;
                }
                if (c5 == 'r') {
                    return 13;
                }
                if (c5 == 't') {
                    return 9;
                }
                if (c5 != 'u') {
                    throw W("Invalid escape sequence");
                } else if (i5 + 5 <= this.f20867e || o(4)) {
                    int i7 = this.f20866d;
                    int i8 = i7 + 4;
                    char c6 = 0;
                    while (i7 < i8) {
                        char c7 = this.f20865c[i7];
                        char c8 = (char) (c6 << 4);
                        if (c7 >= '0' && c7 <= '9') {
                            i4 = c7 - '0';
                        } else if (c7 >= 'a' && c7 <= 'f') {
                            i4 = c7 - 'W';
                        } else if (c7 < 'A' || c7 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f20865c, this.f20866d, 4));
                        } else {
                            i4 = c7 - '7';
                        }
                        c6 = (char) (c8 + i4);
                        i7++;
                    }
                    this.f20866d += 4;
                    return c6;
                } else {
                    throw W("Unterminated escape sequence");
                }
            }
        } else {
            throw W("Unterminated escape sequence");
        }
    }

    private void R(char c5) {
        char[] cArr = this.f20865c;
        do {
            int i4 = this.f20866d;
            int i5 = this.f20867e;
            while (i4 < i5) {
                int i6 = i4 + 1;
                char c6 = cArr[i4];
                if (c6 == c5) {
                    this.f20866d = i6;
                    return;
                } else if (c6 == '\\') {
                    this.f20866d = i6;
                    P();
                    i4 = this.f20866d;
                    i5 = this.f20867e;
                } else {
                    if (c6 == 10) {
                        this.f20868f++;
                        this.f20869g = i6;
                    }
                    i4 = i6;
                }
            }
            this.f20866d = i4;
        } while (o(1));
        throw W("Unterminated string");
    }

    private boolean S(String str) {
        int length = str.length();
        while (true) {
            int i4 = 0;
            if (this.f20866d + length > this.f20867e && !o(length)) {
                return false;
            }
            char[] cArr = this.f20865c;
            int i5 = this.f20866d;
            if (cArr[i5] == 10) {
                this.f20868f++;
                this.f20869g = i5 + 1;
            } else {
                while (i4 < length) {
                    if (this.f20865c[this.f20866d + i4] == str.charAt(i4)) {
                        i4++;
                    }
                }
                return true;
            }
            this.f20866d++;
        }
    }

    private void T() {
        char c5;
        do {
            if (this.f20866d < this.f20867e || o(1)) {
                char[] cArr = this.f20865c;
                int i4 = this.f20866d;
                int i5 = i4 + 1;
                this.f20866d = i5;
                c5 = cArr[i4];
                if (c5 == 10) {
                    this.f20868f++;
                    this.f20869g = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c5 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void U() {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.f20866d
            int r2 = r1 + r0
            int r3 = r4.f20867e
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.f20865c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.g()
        L_0x004b:
            int r1 = r4.f20866d
            int r1 = r1 + r0
            r4.f20866d = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.f20866d = r1
            r0 = 1
            boolean r0 = r4.o(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.C2079a.U():void");
    }

    private IOException W(String str) {
        throw new C2082d(str + x());
    }

    private void g() {
        if (!this.f20864b) {
            throw W("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void i() {
        G(true);
        int i4 = this.f20866d;
        this.f20866d = i4 - 1;
        if (i4 + 4 <= this.f20867e || o(5)) {
            int i5 = this.f20866d;
            char[] cArr = this.f20865c;
            if (cArr[i5] == ')' && cArr[i5 + 1] == ']' && cArr[i5 + 2] == '}' && cArr[i5 + 3] == '\'' && cArr[i5 + 4] == 10) {
                this.f20866d = i5 + 5;
            }
        }
    }

    private boolean o(int i4) {
        int i5;
        int i6;
        char[] cArr = this.f20865c;
        int i7 = this.f20869g;
        int i8 = this.f20866d;
        this.f20869g = i7 - i8;
        int i9 = this.f20867e;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.f20867e = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.f20867e = 0;
        }
        this.f20866d = 0;
        do {
            Reader reader = this.f20863a;
            int i11 = this.f20867e;
            int read = reader.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            i5 = this.f20867e + read;
            this.f20867e = i5;
            if (this.f20868f == 0 && (i6 = this.f20869g) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.f20866d++;
                this.f20869g = i6 + 1;
                i4++;
                continue;
            }
        } while (i5 < i4);
        return true;
    }

    private String p(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i4 = 0;
        while (true) {
            int i5 = this.f20875m;
            if (i4 >= i5) {
                return sb.toString();
            }
            int i6 = this.f20874l[i4];
            if (i6 == 1 || i6 == 2) {
                int i7 = this.f20877o[i4];
                if (z4 && i7 > 0 && i4 == i5 - 1) {
                    i7--;
                }
                sb.append('[');
                sb.append(i7);
                sb.append(']');
            } else if (i6 == 3 || i6 == 4 || i6 == 5) {
                sb.append('.');
                String str = this.f20876n[i4];
                if (str != null) {
                    sb.append(str);
                }
            }
            i4++;
        }
    }

    private boolean w(char c5) {
        if (c5 == 9 || c5 == 10 || c5 == 12 || c5 == 13 || c5 == ' ') {
            return false;
        }
        if (c5 != '#') {
            if (c5 == ',') {
                return false;
            }
            if (!(c5 == '/' || c5 == '=')) {
                if (c5 == '{' || c5 == '}' || c5 == ':') {
                    return false;
                }
                if (c5 != ';') {
                    switch (c5) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        g();
        return false;
    }

    public double A() {
        char c5;
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 15) {
            this.f20870h = 0;
            int[] iArr = this.f20877o;
            int i5 = this.f20875m - 1;
            iArr[i5] = iArr[i5] + 1;
            return (double) this.f20871i;
        }
        if (i4 == 16) {
            this.f20873k = new String(this.f20865c, this.f20866d, this.f20872j);
            this.f20866d += this.f20872j;
        } else if (i4 == 8 || i4 == 9) {
            if (i4 == 8) {
                c5 = '\'';
            } else {
                c5 = '\"';
            }
            this.f20873k = I(c5);
        } else if (i4 == 10) {
            this.f20873k = K();
        } else if (i4 != 11) {
            throw new IllegalStateException("Expected a double but was " + L() + x());
        }
        this.f20870h = 11;
        double parseDouble = Double.parseDouble(this.f20873k);
        if (this.f20864b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f20873k = null;
            this.f20870h = 0;
            int[] iArr2 = this.f20877o;
            int i6 = this.f20875m - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return parseDouble;
        }
        throw new C2082d("JSON forbids NaN and infinities: " + parseDouble + x());
    }

    public int D() {
        char c5;
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 15) {
            long j4 = this.f20871i;
            int i5 = (int) j4;
            if (j4 == ((long) i5)) {
                this.f20870h = 0;
                int[] iArr = this.f20877o;
                int i6 = this.f20875m - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f20871i + x());
        }
        if (i4 == 16) {
            this.f20873k = new String(this.f20865c, this.f20866d, this.f20872j);
            this.f20866d += this.f20872j;
        } else if (i4 == 8 || i4 == 9 || i4 == 10) {
            if (i4 == 10) {
                this.f20873k = K();
            } else {
                if (i4 == 8) {
                    c5 = '\'';
                } else {
                    c5 = '\"';
                }
                this.f20873k = I(c5);
            }
            try {
                int parseInt = Integer.parseInt(this.f20873k);
                this.f20870h = 0;
                int[] iArr2 = this.f20877o;
                int i7 = this.f20875m - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + L() + x());
        }
        this.f20870h = 11;
        double parseDouble = Double.parseDouble(this.f20873k);
        int i8 = (int) parseDouble;
        if (((double) i8) == parseDouble) {
            this.f20873k = null;
            this.f20870h = 0;
            int[] iArr3 = this.f20877o;
            int i9 = this.f20875m - 1;
            iArr3[i9] = iArr3[i9] + 1;
            return i8;
        }
        throw new NumberFormatException("Expected an int but was " + this.f20873k + x());
    }

    public long E() {
        char c5;
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 15) {
            this.f20870h = 0;
            int[] iArr = this.f20877o;
            int i5 = this.f20875m - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f20871i;
        }
        if (i4 == 16) {
            this.f20873k = new String(this.f20865c, this.f20866d, this.f20872j);
            this.f20866d += this.f20872j;
        } else if (i4 == 8 || i4 == 9 || i4 == 10) {
            if (i4 == 10) {
                this.f20873k = K();
            } else {
                if (i4 == 8) {
                    c5 = '\'';
                } else {
                    c5 = '\"';
                }
                this.f20873k = I(c5);
            }
            try {
                long parseLong = Long.parseLong(this.f20873k);
                this.f20870h = 0;
                int[] iArr2 = this.f20877o;
                int i6 = this.f20875m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + L() + x());
        }
        this.f20870h = 11;
        double parseDouble = Double.parseDouble(this.f20873k);
        long j4 = (long) parseDouble;
        if (((double) j4) == parseDouble) {
            this.f20873k = null;
            this.f20870h = 0;
            int[] iArr3 = this.f20877o;
            int i7 = this.f20875m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return j4;
        }
        throw new NumberFormatException("Expected a long but was " + this.f20873k + x());
    }

    public String F() {
        String str;
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 14) {
            str = K();
        } else if (i4 == 12) {
            str = I('\'');
        } else if (i4 == 13) {
            str = I('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + L() + x());
        }
        this.f20870h = 0;
        this.f20876n[this.f20875m - 1] = str;
        return str;
    }

    public void H() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 7) {
            this.f20870h = 0;
            int[] iArr = this.f20877o;
            int i5 = this.f20875m - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + L() + x());
    }

    public String J() {
        String str;
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 10) {
            str = K();
        } else if (i4 == 8) {
            str = I('\'');
        } else if (i4 == 9) {
            str = I('\"');
        } else if (i4 == 11) {
            str = this.f20873k;
            this.f20873k = null;
        } else if (i4 == 15) {
            str = Long.toString(this.f20871i);
        } else if (i4 == 16) {
            str = new String(this.f20865c, this.f20866d, this.f20872j);
            this.f20866d += this.f20872j;
        } else {
            throw new IllegalStateException("Expected a string but was " + L() + x());
        }
        this.f20870h = 0;
        int[] iArr = this.f20877o;
        int i5 = this.f20875m - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public C2080b L() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        switch (i4) {
            case 1:
                return C2080b.BEGIN_OBJECT;
            case 2:
                return C2080b.END_OBJECT;
            case 3:
                return C2080b.BEGIN_ARRAY;
            case 4:
                return C2080b.END_ARRAY;
            case 5:
            case 6:
                return C2080b.BOOLEAN;
            case 7:
                return C2080b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return C2080b.STRING;
            case 12:
            case 13:
            case 14:
                return C2080b.NAME;
            case 15:
            case 16:
                return C2080b.NUMBER;
            case 17:
                return C2080b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void Q(boolean z4) {
        this.f20864b = z4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r7.f20870h = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void V() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r7.f20870h
            if (r2 != 0) goto L_0x000a
            int r2 = r7.k()
        L_0x000a:
            r3 = 39
            r4 = 34
            java.lang.String r5 = "<skipped>"
            r6 = 1
            switch(r2) {
                case 1: goto L_0x006f;
                case 2: goto L_0x005f;
                case 3: goto L_0x0059;
                case 4: goto L_0x0051;
                case 5: goto L_0x0014;
                case 6: goto L_0x0014;
                case 7: goto L_0x0014;
                case 8: goto L_0x004d;
                case 9: goto L_0x0049;
                case 10: goto L_0x0045;
                case 11: goto L_0x0014;
                case 12: goto L_0x0038;
                case 13: goto L_0x002b;
                case 14: goto L_0x001e;
                case 15: goto L_0x0014;
                case 16: goto L_0x0016;
                case 17: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0074
        L_0x0015:
            return
        L_0x0016:
            int r2 = r7.f20866d
            int r3 = r7.f20872j
            int r2 = r2 + r3
            r7.f20866d = r2
            goto L_0x0074
        L_0x001e:
            r7.U()
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f20876n
            int r3 = r7.f20875m
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x002b:
            r7.R(r4)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f20876n
            int r3 = r7.f20875m
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0038:
            r7.R(r3)
            if (r1 != 0) goto L_0x0074
            java.lang.String[] r2 = r7.f20876n
            int r3 = r7.f20875m
            int r3 = r3 - r6
            r2[r3] = r5
            goto L_0x0074
        L_0x0045:
            r7.U()
            goto L_0x0074
        L_0x0049:
            r7.R(r4)
            goto L_0x0074
        L_0x004d:
            r7.R(r3)
            goto L_0x0074
        L_0x0051:
            int r2 = r7.f20875m
            int r2 = r2 - r6
            r7.f20875m = r2
        L_0x0056:
            int r1 = r1 + -1
            goto L_0x0074
        L_0x0059:
            r7.O(r6)
        L_0x005c:
            int r1 = r1 + 1
            goto L_0x0074
        L_0x005f:
            if (r1 != 0) goto L_0x0069
            java.lang.String[] r2 = r7.f20876n
            int r3 = r7.f20875m
            int r3 = r3 - r6
            r4 = 0
            r2[r3] = r4
        L_0x0069:
            int r2 = r7.f20875m
            int r2 = r2 - r6
            r7.f20875m = r2
            goto L_0x0056
        L_0x006f:
            r2 = 3
            r7.O(r2)
            goto L_0x005c
        L_0x0074:
            r7.f20870h = r0
            if (r1 > 0) goto L_0x0002
            int[] r0 = r7.f20877o
            int r1 = r7.f20875m
            int r1 = r1 - r6
            r2 = r0[r1]
            int r2 = r2 + r6
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.C2079a.V():void");
    }

    public void a() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 3) {
            O(1);
            this.f20877o[this.f20875m - 1] = 0;
            this.f20870h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + L() + x());
    }

    public void close() {
        this.f20870h = 0;
        this.f20874l[0] = 8;
        this.f20875m = 1;
        this.f20863a.close();
    }

    public void d() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 1) {
            O(3);
            this.f20870h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + L() + x());
    }

    public String getPath() {
        return p(false);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        int G4;
        int[] iArr = this.f20874l;
        int i4 = this.f20875m;
        int i5 = iArr[i4 - 1];
        if (i5 == 1) {
            iArr[i4 - 1] = 2;
        } else if (i5 == 2) {
            int G5 = G(true);
            if (G5 != 44) {
                if (G5 == 59) {
                    g();
                } else if (G5 == 93) {
                    this.f20870h = 4;
                    return 4;
                } else {
                    throw W("Unterminated array");
                }
            }
        } else if (i5 == 3 || i5 == 5) {
            iArr[i4 - 1] = 4;
            if (i5 == 5 && (G4 = G(true)) != 44) {
                if (G4 == 59) {
                    g();
                } else if (G4 == 125) {
                    this.f20870h = 2;
                    return 2;
                } else {
                    throw W("Unterminated object");
                }
            }
            int G6 = G(true);
            if (G6 == 34) {
                this.f20870h = 13;
                return 13;
            } else if (G6 == 39) {
                g();
                this.f20870h = 12;
                return 12;
            } else if (G6 != 125) {
                g();
                this.f20866d--;
                if (w((char) G6)) {
                    this.f20870h = 14;
                    return 14;
                }
                throw W("Expected name");
            } else if (i5 != 5) {
                this.f20870h = 2;
                return 2;
            } else {
                throw W("Expected name");
            }
        } else if (i5 == 4) {
            iArr[i4 - 1] = 5;
            int G7 = G(true);
            if (G7 != 58) {
                if (G7 == 61) {
                    g();
                    if (this.f20866d < this.f20867e || o(1)) {
                        char[] cArr = this.f20865c;
                        int i6 = this.f20866d;
                        if (cArr[i6] == '>') {
                            this.f20866d = i6 + 1;
                        }
                    }
                } else {
                    throw W("Expected ':'");
                }
            }
        } else if (i5 == 6) {
            if (this.f20864b) {
                i();
            }
            this.f20874l[this.f20875m - 1] = 7;
        } else if (i5 == 7) {
            if (G(false) == -1) {
                this.f20870h = 17;
                return 17;
            }
            g();
            this.f20866d--;
        } else if (i5 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int G8 = G(true);
        if (G8 == 34) {
            this.f20870h = 9;
            return 9;
        } else if (G8 != 39) {
            if (!(G8 == 44 || G8 == 59)) {
                if (G8 == 91) {
                    this.f20870h = 3;
                    return 3;
                } else if (G8 != 93) {
                    if (G8 != 123) {
                        this.f20866d--;
                        int M4 = M();
                        if (M4 != 0) {
                            return M4;
                        }
                        int N4 = N();
                        if (N4 != 0) {
                            return N4;
                        }
                        if (w(this.f20865c[this.f20866d])) {
                            g();
                            this.f20870h = 10;
                            return 10;
                        }
                        throw W("Expected value");
                    }
                    this.f20870h = 1;
                    return 1;
                } else if (i5 == 1) {
                    this.f20870h = 4;
                    return 4;
                }
            }
            if (i5 == 1 || i5 == 2) {
                g();
                this.f20866d--;
                this.f20870h = 7;
                return 7;
            }
            throw W("Unexpected value");
        } else {
            g();
            this.f20870h = 8;
            return 8;
        }
    }

    public void l() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 4) {
            int i5 = this.f20875m;
            this.f20875m = i5 - 1;
            int[] iArr = this.f20877o;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f20870h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + L() + x());
    }

    public void n() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 2) {
            int i5 = this.f20875m;
            int i6 = i5 - 1;
            this.f20875m = i6;
            this.f20876n[i6] = null;
            int[] iArr = this.f20877o;
            int i7 = i5 - 2;
            iArr[i7] = iArr[i7] + 1;
            this.f20870h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + L() + x());
    }

    public String r() {
        return p(true);
    }

    public String toString() {
        return getClass().getSimpleName() + x();
    }

    public boolean u() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 2 || i4 == 4 || i4 == 17) {
            return false;
        }
        return true;
    }

    public final boolean v() {
        return this.f20864b;
    }

    /* access modifiers changed from: package-private */
    public String x() {
        return " at line " + (this.f20868f + 1) + " column " + ((this.f20866d - this.f20869g) + 1) + " path " + getPath();
    }

    public boolean z() {
        int i4 = this.f20870h;
        if (i4 == 0) {
            i4 = k();
        }
        if (i4 == 5) {
            this.f20870h = 0;
            int[] iArr = this.f20877o;
            int i5 = this.f20875m - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i4 == 6) {
            this.f20870h = 0;
            int[] iArr2 = this.f20877o;
            int i6 = this.f20875m - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + L() + x());
        }
    }
}
