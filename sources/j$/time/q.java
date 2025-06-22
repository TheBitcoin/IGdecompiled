package j$.time;

import j$.time.temporal.b;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public final class q implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final q f5002d = new q(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a  reason: collision with root package name */
    public final int f5003a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5004b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5005c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Object[] objArr = {b.YEARS, b.MONTHS, b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i4 = 0; i4 < 3; i4++) {
            arrayList.add(Objects.requireNonNull(objArr[i4]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public q(int i4, int i5, int i6) {
        this.f5003a = i4;
        this.f5004b = i5;
        this.f5005c = i6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.q) r5;
        r1 = r5.f5003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.q
            r2 = 0
            if (r1 == 0) goto L_0x001e
            j$.time.q r5 = (j$.time.q) r5
            int r1 = r5.f5003a
            int r3 = r4.f5003a
            if (r3 != r1) goto L_0x001e
            int r1 = r4.f5004b
            int r3 = r5.f5004b
            if (r1 != r3) goto L_0x001e
            int r1 = r4.f5005c
            int r5 = r5.f5005c
            if (r1 != r5) goto L_0x001e
            return r0
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f5005c, 16) + Integer.rotateLeft(this.f5004b, 8) + this.f5003a;
    }

    public final String toString() {
        if (this == f5002d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i4 = this.f5003a;
        if (i4 != 0) {
            sb.append(i4);
            sb.append('Y');
        }
        int i5 = this.f5004b;
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        int i6 = this.f5005c;
        if (i6 != 0) {
            sb.append(i6);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
