package f0;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.C0507a0;
import com.google.android.gms.internal.measurement.C0516b0;
import com.google.android.gms.measurement.internal.C0755e;
import com.google.android.gms.measurement.internal.E;
import com.google.android.gms.measurement.internal.M5;
import com.google.android.gms.measurement.internal.Y5;
import java.util.List;

public abstract class h extends C0516b0 implements C0917f {
    public h() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 1:
                C0507a0.f(parcel);
                i0((E) C0507a0.a(parcel, E.CREATOR), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                C0507a0.f(parcel);
                w((Y5) C0507a0.a(parcel, Y5.CREATOR), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                C0507a0.f(parcel);
                o((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                C0507a0.f(parcel);
                T((E) C0507a0.a(parcel, E.CREATOR), readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                C0507a0.f(parcel);
                g0((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                boolean h4 = C0507a0.h(parcel);
                C0507a0.f(parcel);
                List e02 = e0((M5) C0507a0.a(parcel, M5.CREATOR), h4);
                parcel2.writeNoException();
                parcel2.writeTypedList(e02);
                return true;
            case 9:
                String readString3 = parcel.readString();
                C0507a0.f(parcel);
                byte[] d02 = d0((E) C0507a0.a(parcel, E.CREATOR), readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(d02);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                C0507a0.f(parcel);
                H(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                C0507a0.f(parcel);
                String z4 = z((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(z4);
                break;
            case 12:
                C0507a0.f(parcel);
                G((C0755e) C0507a0.a(parcel, C0755e.CREATOR), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                C0507a0.f(parcel);
                L((C0755e) C0507a0.a(parcel, C0755e.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                C0507a0.f(parcel);
                List Z4 = Z(parcel.readString(), parcel.readString(), C0507a0.h(parcel), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(Z4);
                break;
            case 15:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                boolean h5 = C0507a0.h(parcel);
                C0507a0.f(parcel);
                List r4 = r(readString7, readString8, readString9, h5);
                parcel2.writeNoException();
                parcel2.writeTypedList(r4);
                break;
            case 16:
                C0507a0.f(parcel);
                List l4 = l(parcel.readString(), parcel.readString(), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(l4);
                break;
            case 17:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                C0507a0.f(parcel);
                List K4 = K(readString10, readString11, readString12);
                parcel2.writeNoException();
                parcel2.writeTypedList(K4);
                break;
            case 18:
                C0507a0.f(parcel);
                t((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 19:
                C0507a0.f(parcel);
                u((Bundle) C0507a0.a(parcel, Bundle.CREATOR), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 20:
                C0507a0.f(parcel);
                v((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 21:
                C0507a0.f(parcel);
                C0913b X4 = X((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                C0507a0.g(parcel2, X4);
                break;
            case 24:
                C0507a0.f(parcel);
                List c02 = c0((M5) C0507a0.a(parcel, M5.CREATOR), (Bundle) C0507a0.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(c02);
                break;
            case 25:
                C0507a0.f(parcel);
                W((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 26:
                C0507a0.f(parcel);
                b0((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 27:
                C0507a0.f(parcel);
                J((M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            case 28:
                C0507a0.f(parcel);
                m((Bundle) C0507a0.a(parcel, Bundle.CREATOR), (M5) C0507a0.a(parcel, M5.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
