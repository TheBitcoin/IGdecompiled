package l1;

/* renamed from: l1.o  reason: case insensitive filesystem */
public class C2120o extends C2108c {
    /* access modifiers changed from: protected */
    public String e(String str) {
        while (str.length() % 24 > 0) {
            str = str + "0";
        }
        return str;
    }
}
