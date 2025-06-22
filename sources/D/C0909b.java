package d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import d.C0908a;

/* renamed from: d.b  reason: case insensitive filesystem */
public class C0909b implements Parcelable {
    public static final Parcelable.Creator<C0909b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f3352a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f3353b = null;

    /* renamed from: c  reason: collision with root package name */
    C0908a f3354c;

    /* renamed from: d.b$a */
    class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C0909b createFromParcel(Parcel parcel) {
            return new C0909b(parcel);
        }

        /* renamed from: b */
        public C0909b[] newArray(int i4) {
            return new C0909b[i4];
        }
    }

    /* renamed from: d.b$b  reason: collision with other inner class name */
    class C0028b extends C0908a.C0026a {
        C0028b() {
        }

        public void j0(int i4, Bundle bundle) {
            C0909b bVar = C0909b.this;
            Handler handler = bVar.f3353b;
            if (handler != null) {
                handler.post(new c(i4, bundle));
            } else {
                bVar.a(i4, bundle);
            }
        }
    }

    /* renamed from: d.b$c */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f3356a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f3357b;

        c(int i4, Bundle bundle) {
            this.f3356a = i4;
            this.f3357b = bundle;
        }

        public void run() {
            C0909b.this.a(this.f3356a, this.f3357b);
        }
    }

    C0909b(Parcel parcel) {
        this.f3354c = C0908a.C0026a.h(parcel.readStrongBinder());
    }

    public void b(int i4, Bundle bundle) {
        if (this.f3352a) {
            Handler handler = this.f3353b;
            if (handler != null) {
                handler.post(new c(i4, bundle));
            } else {
                a(i4, bundle);
            }
        } else {
            C0908a aVar = this.f3354c;
            if (aVar != null) {
                try {
                    aVar.j0(i4, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        synchronized (this) {
            try {
                if (this.f3354c == null) {
                    this.f3354c = new C0028b();
                }
                parcel.writeStrongBinder(this.f3354c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i4, Bundle bundle) {
    }
}
