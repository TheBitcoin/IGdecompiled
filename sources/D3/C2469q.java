package D3;

import E3.c;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: D3.q  reason: case insensitive filesystem */
public final class C2469q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f23106a;

    /* renamed from: D3.q$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List f23107a = new ArrayList(20);

        private void e(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = str.charAt(i4);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(c.o("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i4), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i5 = 0;
                    while (i5 < length2) {
                        char charAt2 = str2.charAt(i5);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i5++;
                        } else {
                            throw new IllegalArgumentException(c.o("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i5), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value for name " + str + " == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public a a(String str, String str2) {
            e(str, str2);
            return c(str, str2);
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return c(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        /* access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f23107a.add(str);
            this.f23107a.add(str2.trim());
            return this;
        }

        public C2469q d() {
            return new C2469q(this);
        }

        public String f(String str) {
            for (int size = this.f23107a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f23107a.get(size))) {
                    return (String) this.f23107a.get(size + 1);
                }
            }
            return null;
        }

        public a g(String str) {
            int i4 = 0;
            while (i4 < this.f23107a.size()) {
                if (str.equalsIgnoreCase((String) this.f23107a.get(i4))) {
                    this.f23107a.remove(i4);
                    this.f23107a.remove(i4);
                    i4 -= 2;
                }
                i4 += 2;
            }
            return this;
        }

        public a h(String str, String str2) {
            e(str, str2);
            g(str);
            c(str, str2);
            return this;
        }
    }

    C2469q(a aVar) {
        List list = aVar.f23107a;
        this.f23106a = (String[]) list.toArray(new String[list.size()]);
    }

    private static String b(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public String a(String str) {
        return b(this.f23106a, str);
    }

    public String c(int i4) {
        return this.f23106a[i4 * 2];
    }

    public a d() {
        a aVar = new a();
        Collections.addAll(aVar.f23107a, this.f23106a);
        return aVar;
    }

    public int e() {
        return this.f23106a.length / 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2469q) || !Arrays.equals(((C2469q) obj).f23106a, this.f23106a)) {
            return false;
        }
        return true;
    }

    public String f(int i4) {
        return this.f23106a[(i4 * 2) + 1];
    }

    public List g(String str) {
        int e5 = e();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < e5; i4++) {
            if (str.equalsIgnoreCase(c(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(f(i4));
            }
        }
        if (arrayList != null) {
            return DesugarCollections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f23106a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int e5 = e();
        for (int i4 = 0; i4 < e5; i4++) {
            sb.append(c(i4));
            sb.append(": ");
            sb.append(f(i4));
            sb.append("\n");
        }
        return sb.toString();
    }
}
