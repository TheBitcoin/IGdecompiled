package N;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

public abstract class c {
    public static int a(Parcel parcel) {
        return r(parcel, 20293);
    }

    public static void b(Parcel parcel, int i4) {
        s(parcel, i4);
    }

    public static void c(Parcel parcel, int i4, boolean z4) {
        t(parcel, i4, 4);
        parcel.writeInt(z4 ? 1 : 0);
    }

    public static void d(Parcel parcel, int i4, Boolean bool, boolean z4) {
        if (bool != null) {
            t(parcel, i4, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void e(Parcel parcel, int i4, Bundle bundle, boolean z4) {
        if (bundle != null) {
            int r4 = r(parcel, i4);
            parcel.writeBundle(bundle);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void f(Parcel parcel, int i4, Double d5, boolean z4) {
        if (d5 != null) {
            t(parcel, i4, 8);
            parcel.writeDouble(d5.doubleValue());
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void g(Parcel parcel, int i4, Float f4, boolean z4) {
        if (f4 != null) {
            t(parcel, i4, 4);
            parcel.writeFloat(f4.floatValue());
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void h(Parcel parcel, int i4, IBinder iBinder, boolean z4) {
        if (iBinder != null) {
            int r4 = r(parcel, i4);
            parcel.writeStrongBinder(iBinder);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void i(Parcel parcel, int i4, int i5) {
        t(parcel, i4, 4);
        parcel.writeInt(i5);
    }

    public static void j(Parcel parcel, int i4, int[] iArr, boolean z4) {
        if (iArr != null) {
            int r4 = r(parcel, i4);
            parcel.writeIntArray(iArr);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void k(Parcel parcel, int i4, long j4) {
        t(parcel, i4, 8);
        parcel.writeLong(j4);
    }

    public static void l(Parcel parcel, int i4, Long l4, boolean z4) {
        if (l4 != null) {
            t(parcel, i4, 8);
            parcel.writeLong(l4.longValue());
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void m(Parcel parcel, int i4, Parcelable parcelable, int i5, boolean z4) {
        if (parcelable != null) {
            int r4 = r(parcel, i4);
            parcelable.writeToParcel(parcel, i5);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void n(Parcel parcel, int i4, String str, boolean z4) {
        if (str != null) {
            int r4 = r(parcel, i4);
            parcel.writeString(str);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void o(Parcel parcel, int i4, List list, boolean z4) {
        if (list != null) {
            int r4 = r(parcel, i4);
            parcel.writeStringList(list);
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void p(Parcel parcel, int i4, Parcelable[] parcelableArr, int i5, boolean z4) {
        if (parcelableArr != null) {
            int r4 = r(parcel, i4);
            parcel.writeInt(r7);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    u(parcel, parcelable, i5);
                }
            }
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    public static void q(Parcel parcel, int i4, List list, boolean z4) {
        if (list != null) {
            int r4 = r(parcel, i4);
            int size = list.size();
            parcel.writeInt(size);
            for (int i5 = 0; i5 < size; i5++) {
                Parcelable parcelable = (Parcelable) list.get(i5);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    u(parcel, parcelable, 0);
                }
            }
            s(parcel, r4);
        } else if (z4) {
            t(parcel, i4, 0);
        }
    }

    private static int r(Parcel parcel, int i4) {
        parcel.writeInt(i4 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void s(Parcel parcel, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i4 - 4);
        parcel.writeInt(dataPosition - i4);
        parcel.setDataPosition(dataPosition);
    }

    private static void t(Parcel parcel, int i4, int i5) {
        parcel.writeInt(i4 | (i5 << 16));
    }

    private static void u(Parcel parcel, Parcelable parcelable, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i4);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
