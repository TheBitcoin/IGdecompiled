package M;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import b0.b;

/* renamed from: M.j  reason: case insensitive filesystem */
public interface C0329j extends IInterface {

    /* renamed from: M.j$a */
    public static abstract class a extends b implements C0329j {
        public static C0329j i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof C0329j) {
                return (C0329j) queryLocalInterface;
            }
            return new t0(iBinder);
        }
    }

    Account B();
}
