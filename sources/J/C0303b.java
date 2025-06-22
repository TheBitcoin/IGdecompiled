package J;

import M.C0333n;
import N.a;
import N.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: J.b  reason: case insensitive filesystem */
public final class C0303b extends a {
    @NonNull
    public static final Parcelable.Creator<C0303b> CREATOR = new r();

    /* renamed from: e  reason: collision with root package name */
    public static final C0303b f322e = new C0303b(0);

    /* renamed from: a  reason: collision with root package name */
    final int f323a;

    /* renamed from: b  reason: collision with root package name */
    private final int f324b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f325c;

    /* renamed from: d  reason: collision with root package name */
    private final String f326d;

    C0303b(int i4, int i5, PendingIntent pendingIntent, String str) {
        this.f323a = i4;
        this.f324b = i5;
        this.f325c = pendingIntent;
        this.f326d = str;
    }

    static String l(int i4) {
        if (i4 == 99) {
            return "UNFINISHED";
        }
        if (i4 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i4) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i4) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i4 + ")";
                }
        }
    }

    public int c() {
        return this.f324b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0303b)) {
            return false;
        }
        C0303b bVar = (C0303b) obj;
        if (this.f324b != bVar.f324b || !C0333n.a(this.f325c, bVar.f325c) || !C0333n.a(this.f326d, bVar.f326d)) {
            return false;
        }
        return true;
    }

    public String g() {
        return this.f326d;
    }

    public PendingIntent h() {
        return this.f325c;
    }

    public int hashCode() {
        return C0333n.b(Integer.valueOf(this.f324b), this.f325c, this.f326d);
    }

    public boolean j() {
        if (this.f324b == 0 || this.f325c == null) {
            return false;
        }
        return true;
    }

    public boolean k() {
        if (this.f324b == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        C0333n.a c5 = C0333n.c(this);
        c5.a("statusCode", l(this.f324b));
        c5.a("resolution", this.f325c);
        c5.a("message", this.f326d);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f323a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.i(parcel, 2, c());
        c.m(parcel, 3, h(), i4, false);
        c.n(parcel, 4, g(), false);
        c.b(parcel, a5);
    }

    public C0303b(int i4) {
        this(i4, (PendingIntent) null, (String) null);
    }

    public C0303b(int i4, PendingIntent pendingIntent) {
        this(i4, pendingIntent, (String) null);
    }

    public C0303b(int i4, PendingIntent pendingIntent, String str) {
        this(1, i4, pendingIntent, str);
    }
}
