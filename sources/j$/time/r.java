package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import j$.util.Objects;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public final class r implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a  reason: collision with root package name */
    public byte f5006a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5007b;

    public r() {
    }

    public r(byte b5, Object obj) {
        this.f5006a = b5;
        this.f5007b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f5006a;
        Object obj = this.f5007b;
        objectOutput.writeByte(b5);
        switch (b5) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f4836a);
                objectOutput.writeInt(duration.f4837b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f4839a);
                objectOutput.writeInt(instant.f4840b);
                return;
            case 3:
                g gVar = (g) obj;
                objectOutput.writeInt(gVar.f4977a);
                objectOutput.writeByte(gVar.f4978b);
                objectOutput.writeByte(gVar.f4979c);
                return;
            case 4:
                ((j) obj).R(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                g gVar2 = localDateTime.f4843a;
                objectOutput.writeInt(gVar2.f4977a);
                objectOutput.writeByte(gVar2.f4978b);
                objectOutput.writeByte(gVar2.f4979c);
                localDateTime.f4844b.R(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f4855a;
                g gVar3 = localDateTime2.f4843a;
                objectOutput.writeInt(gVar3.f4977a);
                objectOutput.writeByte(gVar3.f4978b);
                objectOutput.writeByte(gVar3.f4979c);
                localDateTime2.f4844b.R(objectOutput);
                zonedDateTime.f4856b.M(objectOutput);
                zonedDateTime.f4857c.G(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((w) obj).f5049b);
                return;
            case 8:
                ((ZoneOffset) obj).M(objectOutput);
                return;
            case 9:
                p pVar = (p) obj;
                pVar.f5000a.R(objectOutput);
                pVar.f5001b.M(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f4846a;
                g gVar4 = localDateTime3.f4843a;
                objectOutput.writeInt(gVar4.f4977a);
                objectOutput.writeByte(gVar4.f4978b);
                objectOutput.writeByte(gVar4.f4979c);
                localDateTime3.f4844b.R(objectOutput);
                offsetDateTime.f4847b.M(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((t) obj).f5011a);
                return;
            case 12:
                v vVar = (v) obj;
                objectOutput.writeInt(vVar.f5046a);
                objectOutput.writeByte(vVar.f5047b);
                return;
            case 13:
                n nVar = (n) obj;
                objectOutput.writeByte(nVar.f4996a);
                objectOutput.writeByte(nVar.f4997b);
                return;
            case 14:
                q qVar = (q) obj;
                objectOutput.writeInt(qVar.f5003a);
                objectOutput.writeInt(qVar.f5004b);
                objectOutput.writeInt(qVar.f5005c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f5006a = readByte;
        this.f5007b = a(readByte, objectInput);
    }

    public static Serializable a(byte b5, ObjectInput objectInput) {
        switch (b5) {
            case 1:
                Duration duration = Duration.f4835c;
                long readLong = objectInput.readLong();
                long readInt = (long) objectInput.readInt();
                return Duration.j(a.x(readLong, a.B(readInt, C.NANOS_PER_SECOND)), (int) a.A(readInt, C.NANOS_PER_SECOND));
            case 2:
                Instant instant = Instant.f4838c;
                return Instant.D(objectInput.readLong(), (long) objectInput.readInt());
            case 3:
                g gVar = g.f4975d;
                return g.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return j.M(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f4841c;
                g gVar2 = g.f4975d;
                return LocalDateTime.F(g.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.M(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f4841c;
                g gVar3 = g.f4975d;
                LocalDateTime F4 = LocalDateTime.F(g.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.M(objectInput));
                ZoneOffset L4 = ZoneOffset.L(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(F4, "localDateTime");
                Objects.requireNonNull(L4, TypedValues.CycleType.S_WAVE_OFFSET);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || L4.equals(zoneId)) {
                    return new ZonedDateTime(F4, zoneId, L4);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i4 = w.f5048d;
                return ZoneId.D(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.L(objectInput);
            case 9:
                int i5 = p.f4999c;
                return new p(j.M(objectInput), ZoneOffset.L(objectInput));
            case 10:
                int i6 = OffsetDateTime.f4845c;
                g gVar4 = g.f4975d;
                return new OffsetDateTime(LocalDateTime.F(g.K(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.M(objectInput)), ZoneOffset.L(objectInput));
            case 11:
                int i7 = t.f5010b;
                return t.C(objectInput.readInt());
            case 12:
                int i8 = v.f5045c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                j$.time.temporal.a.YEAR.w((long) readInt2);
                j$.time.temporal.a.MONTH_OF_YEAR.w((long) readByte);
                return new v(readInt2, readByte);
            case 13:
                int i9 = n.f4995c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                l F5 = l.F(readByte2);
                Objects.requireNonNull(F5, "month");
                j$.time.temporal.a.DAY_OF_MONTH.w((long) readByte3);
                if (readByte3 <= F5.E()) {
                    return new n(F5.getValue(), readByte3);
                }
                String name = F5.name();
                throw new RuntimeException("Illegal value for DayOfMonth field, value " + readByte3 + " is not valid for month " + name);
            case 14:
                q qVar = q.f5002d;
                int readInt3 = objectInput.readInt();
                int readInt4 = objectInput.readInt();
                int readInt5 = objectInput.readInt();
                if ((readInt3 | readInt4 | readInt5) == 0) {
                    return q.f5002d;
                }
                return new q(readInt3, readInt4, readInt5);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f5007b;
    }
}
