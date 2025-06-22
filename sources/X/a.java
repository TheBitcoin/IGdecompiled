package X;

import android.os.IBinder;
import android.os.IInterface;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f647a;

    /* renamed from: b  reason: collision with root package name */
    private final String f648b;

    protected a(IBinder iBinder, String str) {
        this.f647a = iBinder;
        this.f648b = str;
    }

    public final IBinder asBinder() {
        return this.f647a;
    }
}
