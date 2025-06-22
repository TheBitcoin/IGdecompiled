package j$.time.chrono;

import j$.time.temporal.b;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: j$.time.chrono.h  reason: case insensitive filesystem */
public final class C1123h implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ int f4877e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a  reason: collision with root package name */
    public final l f4878a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4879b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4880c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4881d;

    static {
        Object[] objArr = {b.YEARS, b.MONTHS, b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i4 = 0; i4 < 3; i4++) {
            arrayList.add(Objects.requireNonNull(objArr[i4]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public C1123h(l lVar, int i4, int i5, int i6) {
        Objects.requireNonNull(lVar, "chrono");
        this.f4878a = lVar;
        this.f4879b = i4;
        this.f4880c = i5;
        this.f4881d = i6;
    }

    public final String toString() {
        l lVar = this.f4878a;
        int i4 = this.f4881d;
        int i5 = this.f4880c;
        int i6 = this.f4879b;
        if (i6 == 0 && i5 == 0 && i4 == 0) {
            String lVar2 = lVar.toString();
            return lVar2 + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lVar.toString());
        sb.append(" P");
        if (i6 != 0) {
            sb.append(i6);
            sb.append('Y');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i4 != 0) {
            sb.append(i4);
            sb.append('D');
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.chrono.C1123h) r5;
        r1 = r5.f4879b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.chrono.C1123h
            r2 = 0
            if (r1 == 0) goto L_0x0028
            j$.time.chrono.h r5 = (j$.time.chrono.C1123h) r5
            int r1 = r5.f4879b
            int r3 = r4.f4879b
            if (r3 != r1) goto L_0x0028
            int r1 = r4.f4880c
            int r3 = r5.f4880c
            if (r1 != r3) goto L_0x0028
            int r1 = r4.f4881d
            int r3 = r5.f4881d
            if (r1 != r3) goto L_0x0028
            j$.time.chrono.l r1 = r4.f4878a
            j$.time.chrono.l r5 = r5.f4878a
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0028
            return r0
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.C1123h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f4878a.hashCode() ^ (Integer.rotateLeft(this.f4881d, 16) + (Integer.rotateLeft(this.f4880c, 8) + this.f4879b));
    }

    public Object writeReplace() {
        return new E((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
