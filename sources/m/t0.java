package M;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import b0.a;
import b0.c;

public final class t0 extends a implements C0329j {
    t0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account B() {
        Parcel h4 = h(2, i());
        Account account = (Account) c.a(h4, Account.CREATOR);
        h4.recycle();
        return account;
    }
}
