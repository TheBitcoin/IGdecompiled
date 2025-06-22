package j$.time.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.time.ZoneOffset;
import j$.time.d;
import j$.time.j;
import j$.time.l;
import j$.time.temporal.a;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a  reason: collision with root package name */
    public final l f5060a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f5061b;

    /* renamed from: c  reason: collision with root package name */
    public final d f5062c;

    /* renamed from: d  reason: collision with root package name */
    public final j f5063d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5064e;

    /* renamed from: f  reason: collision with root package name */
    public final d f5065f;

    /* renamed from: g  reason: collision with root package name */
    public final ZoneOffset f5066g;

    /* renamed from: h  reason: collision with root package name */
    public final ZoneOffset f5067h;

    /* renamed from: i  reason: collision with root package name */
    public final ZoneOffset f5068i;

    public e(l lVar, int i4, d dVar, j jVar, boolean z4, d dVar2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f5060a = lVar;
        this.f5061b = (byte) i4;
        this.f5062c = dVar;
        this.f5063d = jVar;
        this.f5064e = z4;
        this.f5065f = dVar2;
        this.f5066g = zoneOffset;
        this.f5067h = zoneOffset2;
        this.f5068i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        int i4;
        int i5;
        j jVar = this.f5063d;
        boolean z4 = this.f5064e;
        int O4 = z4 ? 86400 : jVar.O();
        ZoneOffset zoneOffset = this.f5066g;
        int i6 = this.f5067h.f4853b;
        int i7 = zoneOffset.f4853b;
        int i8 = i6 - i7;
        int i9 = this.f5068i.f4853b;
        int i10 = i9 - i7;
        byte b5 = O4 % 3600 == 0 ? z4 ? 24 : jVar.f4987a : 31;
        int i11 = i7 % TypedValues.Custom.TYPE_INT == 0 ? (i7 / TypedValues.Custom.TYPE_INT) + 128 : 255;
        if (i8 == 0 || i8 == 1800 || i8 == 3600) {
            i4 = i8 / 1800;
        } else {
            i4 = 3;
        }
        if (i10 == 0 || i10 == 1800 || i10 == 3600) {
            i5 = i10 / 1800;
        } else {
            i5 = 3;
        }
        d dVar = this.f5062c;
        objectOutput.writeInt((this.f5060a.getValue() << 28) + ((this.f5061b + 32) << 22) + ((dVar == null ? 0 : dVar.getValue()) << 19) + (b5 << 14) + (this.f5065f.ordinal() << 12) + (i11 << 4) + (i4 << 2) + i5);
        if (b5 == 31) {
            objectOutput.writeInt(O4);
        }
        if (i11 == 255) {
            objectOutput.writeInt(i7);
        }
        if (i4 == 3) {
            objectOutput.writeInt(i6);
        }
        if (i5 == 3) {
            objectOutput.writeInt(i9);
        }
    }

    public static e a(ObjectInput objectInput) {
        d C4;
        int i4;
        d dVar;
        j jVar;
        int readInt = objectInput.readInt();
        l F4 = l.F(readInt >>> 28);
        int i5 = ((264241152 & readInt) >>> 22) - 32;
        int i6 = (3670016 & readInt) >>> 19;
        if (i6 == 0) {
            C4 = null;
        } else {
            C4 = d.C(i6);
        }
        d dVar2 = C4;
        int i7 = (507904 & readInt) >>> 14;
        d dVar3 = d.values()[(readInt & 12288) >>> 12];
        int i8 = (readInt & 4080) >>> 4;
        int i9 = (readInt & 12) >>> 2;
        int i10 = readInt & 3;
        if (i7 == 31) {
            long readInt2 = (long) objectInput.readInt();
            j jVar2 = j.f4983e;
            a.SECOND_OF_DAY.w(readInt2);
            int i11 = (int) (readInt2 / 3600);
            i4 = i10;
            long j4 = readInt2 - ((long) (i11 * 3600));
            int i12 = (int) (j4 / 60);
            dVar = dVar3;
            jVar = j.D(i11, i12, (int) (j4 - ((long) (i12 * 60))), 0);
        } else {
            i4 = i10;
            dVar = dVar3;
            int i13 = i7 % 24;
            j jVar3 = j.f4983e;
            a.HOUR_OF_DAY.w((long) i13);
            jVar = j.f4986h[i13];
        }
        ZoneOffset J4 = i8 == 255 ? ZoneOffset.J(objectInput.readInt()) : ZoneOffset.J((i8 - 128) * TypedValues.Custom.TYPE_INT);
        int i14 = J4.f4853b;
        ZoneOffset J5 = ZoneOffset.J(i9 == 3 ? objectInput.readInt() : (i9 * 1800) + i14);
        int i15 = i4;
        ZoneOffset J6 = i15 == 3 ? ZoneOffset.J(objectInput.readInt()) : ZoneOffset.J((i15 * 1800) + i14);
        boolean z4 = i7 == 24;
        Objects.requireNonNull(F4, "month");
        Objects.requireNonNull(jVar, "time");
        d dVar4 = dVar;
        Objects.requireNonNull(dVar4, "timeDefnition");
        Objects.requireNonNull(J4, "standardOffset");
        Objects.requireNonNull(J5, "offsetBefore");
        Objects.requireNonNull(J6, "offsetAfter");
        if (i5 < -28 || i5 > 31 || i5 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        } else if (z4 && !jVar.equals(j.f4985g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        } else if (jVar.f4990d == 0) {
            return new e(F4, i5, dVar2, jVar, z4, dVar4, J4, J5, J6);
        } else {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.zone.e) r5;
        r1 = r5.f5060a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.zone.e
            r2 = 0
            if (r1 == 0) goto L_0x0052
            j$.time.zone.e r5 = (j$.time.zone.e) r5
            j$.time.l r1 = r5.f5060a
            j$.time.l r3 = r4.f5060a
            if (r3 != r1) goto L_0x0052
            byte r1 = r4.f5061b
            byte r3 = r5.f5061b
            if (r1 != r3) goto L_0x0052
            j$.time.d r1 = r4.f5062c
            j$.time.d r3 = r5.f5062c
            if (r1 != r3) goto L_0x0052
            j$.time.zone.d r1 = r4.f5065f
            j$.time.zone.d r3 = r5.f5065f
            if (r1 != r3) goto L_0x0052
            j$.time.j r1 = r4.f5063d
            j$.time.j r3 = r5.f5063d
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0052
            boolean r1 = r4.f5064e
            boolean r3 = r5.f5064e
            if (r1 != r3) goto L_0x0052
            j$.time.ZoneOffset r1 = r4.f5066g
            j$.time.ZoneOffset r3 = r5.f5066g
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0052
            j$.time.ZoneOffset r1 = r4.f5067h
            j$.time.ZoneOffset r3 = r5.f5067h
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0052
            j$.time.ZoneOffset r1 = r4.f5068i
            j$.time.ZoneOffset r5 = r5.f5068i
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0052
            return r0
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int O4 = ((this.f5063d.O() + (this.f5064e ? 1 : 0)) << 15) + (this.f5060a.ordinal() << 11) + ((this.f5061b + 32) << 5);
        d dVar = this.f5062c;
        return ((this.f5066g.f4853b ^ (this.f5065f.ordinal() + (O4 + ((dVar == null ? 7 : dVar.ordinal()) << 2)))) ^ this.f5067h.f4853b) ^ this.f5068i.f4853b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.f5067h;
        ZoneOffset zoneOffset2 = this.f5068i;
        sb.append(zoneOffset2.f4853b - zoneOffset.f4853b > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        l lVar = this.f5060a;
        byte b5 = this.f5061b;
        d dVar = this.f5062c;
        if (dVar == null) {
            sb.append(lVar.name());
            sb.append(' ');
            sb.append(b5);
        } else if (b5 == -1) {
            sb.append(dVar.name());
            sb.append(" on or before last day of ");
            sb.append(lVar.name());
        } else if (b5 < 0) {
            sb.append(dVar.name());
            sb.append(" on or before last day minus ");
            sb.append((-b5) - 1);
            sb.append(" of ");
            sb.append(lVar.name());
        } else {
            sb.append(dVar.name());
            sb.append(" on or after ");
            sb.append(lVar.name());
            sb.append(' ');
            sb.append(b5);
        }
        sb.append(" at ");
        sb.append(this.f5064e ? "24:00" : this.f5063d.toString());
        sb.append(" ");
        sb.append(this.f5065f);
        sb.append(", standard offset ");
        sb.append(this.f5066g);
        sb.append(']');
        return sb.toString();
    }
}
