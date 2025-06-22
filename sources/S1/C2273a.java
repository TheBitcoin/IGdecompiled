package s1;

/* renamed from: s1.a  reason: case insensitive filesystem */
public class C2273a {
    public float a(int i4, int i5) {
        if (i5 <= 0 || i4 <= 0) {
            return 0.0f;
        }
        float f4 = ((float) i4) / ((float) i5);
        if (f4 > 1.0f) {
            return 1.0f;
        }
        return f4;
    }
}
