package N;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;

public abstract class b {

    public static class a extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.String r3, android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N.b.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + s4);
        return readBundle;
    }

    public static int[] b(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + s4);
        return createIntArray;
    }

    public static Parcelable c(Parcel parcel, int i4, Parcelable.Creator creator) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + s4);
        return parcelable;
    }

    public static String d(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + s4);
        return readString;
    }

    public static ArrayList e(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + s4);
        return createStringArrayList;
    }

    public static Object[] f(Parcel parcel, int i4, Parcelable.Creator creator) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + s4);
        return createTypedArray;
    }

    public static ArrayList g(Parcel parcel, int i4, Parcelable.Creator creator) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + s4);
        return createTypedArrayList;
    }

    public static void h(Parcel parcel, int i4) {
        if (parcel.dataPosition() != i4) {
            throw new a("Overread allowed size end=" + i4, parcel);
        }
    }

    public static int i(int i4) {
        return (char) i4;
    }

    public static boolean j(Parcel parcel, int i4) {
        w(parcel, i4, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static Boolean k(Parcel parcel, int i4) {
        boolean z4;
        int s4 = s(parcel, i4);
        if (s4 == 0) {
            return null;
        }
        v(parcel, i4, s4, 4);
        if (parcel.readInt() != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    public static Double l(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        if (s4 == 0) {
            return null;
        }
        v(parcel, i4, s4, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static Float m(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        if (s4 == 0) {
            return null;
        }
        v(parcel, i4, s4, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int n(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder o(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        int dataPosition = parcel.dataPosition();
        if (s4 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + s4);
        return readStrongBinder;
    }

    public static int p(Parcel parcel, int i4) {
        w(parcel, i4, 4);
        return parcel.readInt();
    }

    public static long q(Parcel parcel, int i4) {
        w(parcel, i4, 8);
        return parcel.readLong();
    }

    public static Long r(Parcel parcel, int i4) {
        int s4 = s(parcel, i4);
        if (s4 == 0) {
            return null;
        }
        v(parcel, i4, s4, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int s(Parcel parcel, int i4) {
        if ((i4 & SupportMenu.CATEGORY_MASK) != -65536) {
            return (char) (i4 >> 16);
        }
        return parcel.readInt();
    }

    public static void t(Parcel parcel, int i4) {
        parcel.setDataPosition(parcel.dataPosition() + s(parcel, i4));
    }

    public static int u(Parcel parcel) {
        int n4 = n(parcel);
        int s4 = s(parcel, n4);
        int i4 = i(n4);
        int dataPosition = parcel.dataPosition();
        if (i4 == 20293) {
            int i5 = s4 + dataPosition;
            if (i5 >= dataPosition && i5 <= parcel.dataSize()) {
                return i5;
            }
            throw new a("Size read is invalid start=" + dataPosition + " end=" + i5, parcel);
        }
        throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(n4))), parcel);
    }

    private static void v(Parcel parcel, int i4, int i5, int i6) {
        if (i5 != i6) {
            String hexString = Integer.toHexString(i5);
            throw new a("Expected size " + i6 + " got " + i5 + " (0x" + hexString + ")", parcel);
        }
    }

    private static void w(Parcel parcel, int i4, int i5) {
        int s4 = s(parcel, i4);
        if (s4 != i5) {
            String hexString = Integer.toHexString(s4);
            throw new a("Expected size " + i5 + " got " + s4 + " (0x" + hexString + ")", parcel);
        }
    }
}
