package S2;

public abstract class S {
    public static final void a(int i4, int i5) {
        String str;
        if (i4 <= 0 || i5 <= 0) {
            if (i4 != i5) {
                str = "Both size " + i4 + " and step " + i5 + " must be greater than zero.";
            } else {
                str = "size " + i4 + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }
}
