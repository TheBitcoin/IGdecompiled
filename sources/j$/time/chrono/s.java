package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.LocalDateTime;
import j$.time.g;
import j$.time.temporal.n;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class s extends C1116a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final s f4904c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    public final m A(int i4) {
        if (i4 == 0) {
            return t.BCE;
        }
        if (i4 == 1) {
            return t.CE;
        }
        throw new RuntimeException("Invalid era: " + i4);
    }

    public final String i() {
        return ExifInterface.TAG_RW2_ISO;
    }

    public final String s() {
        return "iso8601";
    }

    public final C1117b l(n nVar) {
        return g.E(nVar);
    }

    private s() {
    }

    public final C1120e o(LocalDateTime localDateTime) {
        return LocalDateTime.D(localDateTime);
    }

    public static boolean k(long j4) {
        if ((3 & j4) == 0) {
            return j4 % 100 != 0 || j4 % 400 == 0;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
