package M;

import K.b;
import K.i;
import com.google.android.gms.common.api.Status;

/* renamed from: M.b  reason: case insensitive filesystem */
public abstract class C0321b {
    public static b a(Status status) {
        if (status.j()) {
            return new i(status);
        }
        return new b(status);
    }
}
