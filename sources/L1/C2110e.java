package l1;

/* renamed from: l1.e  reason: case insensitive filesystem */
public class C2110e extends C2108c {
    /* access modifiers changed from: protected */
    public String e(String str) {
        while (str.length() % 8 > 0) {
            str = str + "0";
        }
        while (str.length() % 6 > 0) {
            str = str + "0";
        }
        return str;
    }
}
