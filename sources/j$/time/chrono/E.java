package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.r;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class E implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a  reason: collision with root package name */
    public byte f4864a;

    /* renamed from: b  reason: collision with root package name */
    public Object f4865b;

    public E() {
    }

    public E(byte b5, Object obj) {
        this.f4864a = b5;
        this.f4865b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f4864a;
        Object obj = this.f4865b;
        objectOutput.writeByte(b5);
        switch (b5) {
            case 1:
                objectOutput.writeUTF(((C1116a) obj).i());
                return;
            case 2:
                C1122g gVar = (C1122g) obj;
                objectOutput.writeObject(gVar.f4875a);
                objectOutput.writeObject(gVar.f4876b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f4884a);
                objectOutput.writeObject(kVar.f4885b);
                objectOutput.writeObject(kVar.f4886c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(r.a(xVar, a.YEAR));
                objectOutput.writeByte(r.a(xVar, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(xVar, a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f4915a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f4899a);
                objectOutput.writeInt(r.a(qVar, a.YEAR));
                objectOutput.writeByte(r.a(qVar, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(qVar, a.DAY_OF_MONTH));
                return;
            case 7:
                C c5 = (C) obj;
                c5.getClass();
                objectOutput.writeInt(r.a(c5, a.YEAR));
                objectOutput.writeByte(r.a(c5, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(c5, a.DAY_OF_MONTH));
                return;
            case 8:
                I i4 = (I) obj;
                i4.getClass();
                objectOutput.writeInt(r.a(i4, a.YEAR));
                objectOutput.writeByte(r.a(i4, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(i4, a.DAY_OF_MONTH));
                return;
            case 9:
                C1123h hVar = (C1123h) obj;
                objectOutput.writeUTF(hVar.f4878a.i());
                objectOutput.writeInt(hVar.f4879b);
                objectOutput.writeInt(hVar.f4880c);
                objectOutput.writeInt(hVar.f4881d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f4864a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = C1116a.f4871a;
                obj = j$.com.android.tools.r8.a.E(objectInput.readUTF());
                break;
            case 2:
                obj = ((C1117b) objectInput.readObject()).v((j) objectInput.readObject());
                break;
            case 3:
                obj = ((C1120e) objectInput.readObject()).q((ZoneOffset) objectInput.readObject()).h((ZoneId) objectInput.readObject());
                break;
            case 4:
                g gVar = x.f4909d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                v.f4907c.getClass();
                obj = new x(g.K(readInt, readByte2, readByte3));
                break;
            case 5:
                y yVar = y.f4913d;
                obj = y.o(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                oVar.getClass();
                obj = new q(oVar, readInt2, readByte4, readByte5);
                break;
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                A.f4860c.getClass();
                obj = new C(g.K(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                G.f4867c.getClass();
                obj = new I(g.K(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i4 = C1123h.f4877e;
                obj = new C1123h(j$.com.android.tools.r8.a.E(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f4865b = obj;
    }

    private Object readResolve() {
        return this.f4865b;
    }
}
