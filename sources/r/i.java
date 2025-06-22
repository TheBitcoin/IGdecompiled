package R;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f617a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f618b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i4 = 0;
        for (byte b5 : bArr) {
            char[] cArr2 = f618b;
            cArr[i4] = cArr2[(b5 & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b5 & 15];
            i4 += 2;
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr, boolean z4) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i4 = 0;
        while (i4 < length && (!z4 || i4 != length - 1 || (bArr[i4] & 255) != 0)) {
            char[] cArr = f617a;
            sb.append(cArr[(bArr[i4] & 240) >>> 4]);
            sb.append(cArr[bArr[i4] & 15]);
            i4++;
        }
        return sb.toString();
    }
}
