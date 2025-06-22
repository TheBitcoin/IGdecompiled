package j$.time;

import j$.time.zone.f;
import j$.time.zone.g;
import j$.time.zone.i;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

public final class w extends ZoneId {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f5048d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b  reason: collision with root package name */
    public final String f5049b;

    /* renamed from: c  reason: collision with root package name */
    public final transient f f5050c;

    public static w H(String str, boolean z4) {
        f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i4 == 0) && ((charAt < '0' || charAt > '9' || i4 == 0) && ((charAt != '~' || i4 == 0) && ((charAt != '.' || i4 == 0) && ((charAt != '_' || i4 == 0) && ((charAt != '+' || i4 == 0) && (charAt != '-' || i4 == 0))))))))) {
                    throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = i.a(str);
            } catch (g e5) {
                if (!z4) {
                    fVar = null;
                } else {
                    throw e5;
                }
            }
            return new w(str, fVar);
        }
        throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public w(String str, f fVar) {
        this.f5049b = str;
        this.f5050c = fVar;
    }

    public final String i() {
        return this.f5049b;
    }

    public final f C() {
        f fVar = this.f5050c;
        return fVar != null ? fVar : i.a(this.f5049b);
    }

    private Object writeReplace() {
        return new r((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void G(ObjectOutput objectOutput) {
        objectOutput.writeByte(7);
        objectOutput.writeUTF(this.f5049b);
    }
}
