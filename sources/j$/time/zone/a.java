package j$.time.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

public final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a  reason: collision with root package name */
    public byte f5052a;

    /* renamed from: b  reason: collision with root package name */
    public Serializable f5053b;

    public a() {
    }

    public a(byte b5, Serializable serializable) {
        this.f5052a = b5;
        this.f5053b = serializable;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f5052a;
        Serializable serializable = this.f5053b;
        objectOutput.writeByte(b5);
        if (b5 == 1) {
            f fVar = (f) serializable;
            long[] jArr = fVar.f5073a;
            objectOutput.writeInt(jArr.length);
            for (long c5 : jArr) {
                c(c5, objectOutput);
            }
            for (ZoneOffset d5 : fVar.f5074b) {
                d(d5, objectOutput);
            }
            long[] jArr2 = fVar.f5075c;
            objectOutput.writeInt(jArr2.length);
            for (long c6 : jArr2) {
                c(c6, objectOutput);
            }
            for (ZoneOffset d6 : fVar.f5077e) {
                d(d6, objectOutput);
            }
            e[] eVarArr = fVar.f5078f;
            objectOutput.writeByte(eVarArr.length);
            for (e writeExternal : eVarArr) {
                writeExternal.writeExternal(objectOutput);
            }
        } else if (b5 == 2) {
            b bVar = (b) serializable;
            c(bVar.f5054a, objectOutput);
            d(bVar.f5056c, objectOutput);
            d(bVar.f5057d, objectOutput);
        } else if (b5 == 3) {
            ((e) serializable).writeExternal(objectOutput);
        } else if (b5 == 100) {
            objectOutput.writeUTF(((f) serializable).f5079g.getID());
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        Serializable serializable;
        long[] jArr;
        byte readByte = objectInput.readByte();
        this.f5052a = readByte;
        if (readByte == 1) {
            int readInt = objectInput.readInt();
            long[] jArr2 = f.f5069i;
            if (readInt == 0) {
                jArr = jArr2;
            } else {
                jArr = new long[readInt];
            }
            for (int i4 = 0; i4 < readInt; i4++) {
                jArr[i4] = a(objectInput);
            }
            int i5 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                zoneOffsetArr[i6] = b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr2 = new long[readInt2];
            }
            long[] jArr3 = jArr2;
            for (int i7 = 0; i7 < readInt2; i7++) {
                jArr3[i7] = a(objectInput);
            }
            int i8 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                zoneOffsetArr2[i9] = b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            e[] eVarArr = readByte2 == 0 ? f.f5070j : new e[readByte2];
            for (int i10 = 0; i10 < readByte2; i10++) {
                eVarArr[i10] = e.a(objectInput);
            }
            serializable = new f(jArr, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (readByte == 2) {
            long a5 = a(objectInput);
            ZoneOffset b5 = b(objectInput);
            ZoneOffset b6 = b(objectInput);
            if (!b5.equals(b6)) {
                serializable = new b(a5, b5, b6);
            } else {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
        } else if (readByte == 3) {
            serializable = e.a(objectInput);
        } else if (readByte == 100) {
            serializable = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f5053b = serializable;
    }

    private Object readResolve() {
        return this.f5053b;
    }

    public static ZoneOffset b(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.J(objectInput.readInt()) : ZoneOffset.J(readByte * 900);
    }

    public static void c(long j4, ObjectOutput objectOutput) {
        if (j4 < -4575744000L || j4 >= 10413792000L || j4 % 900 != 0) {
            objectOutput.writeByte(255);
            objectOutput.writeLong(j4);
            return;
        }
        int i4 = (int) ((j4 + 4575744000L) / 900);
        objectOutput.writeByte((i4 >>> 16) & 255);
        objectOutput.writeByte((i4 >>> 8) & 255);
        objectOutput.writeByte(i4 & 255);
    }

    public static long a(ObjectInput objectInput) {
        byte readByte = objectInput.readByte() & 255;
        if (readByte == 255) {
            return objectInput.readLong();
        }
        return (((long) (((readByte << 16) + ((objectInput.readByte() & 255) << 8)) + (objectInput.readByte() & 255))) * 900) - 4575744000L;
    }

    public static void d(ZoneOffset zoneOffset, ObjectOutput objectOutput) {
        int i4 = zoneOffset.f4853b;
        int i5 = i4 % TypedValues.Custom.TYPE_INT == 0 ? i4 / TypedValues.Custom.TYPE_INT : ModuleDescriptor.MODULE_VERSION;
        objectOutput.writeByte(i5);
        if (i5 == 127) {
            objectOutput.writeInt(i4);
        }
    }
}
