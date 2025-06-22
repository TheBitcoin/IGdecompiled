package U;

import android.os.IBinder;
import android.os.IInterface;
import b0.b;

public interface a extends IInterface {

    /* renamed from: U.a$a  reason: collision with other inner class name */
    public static abstract class C0004a extends b implements a {
        public C0004a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static a i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new c(iBinder);
        }
    }
}
