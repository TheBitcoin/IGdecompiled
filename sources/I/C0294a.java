package I;

import N.a;
import N.c;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: I.a  reason: case insensitive filesystem */
public final class C0294a extends a {
    @NonNull
    public static final Parcelable.Creator<C0294a> CREATOR = new C0297d();

    /* renamed from: a  reason: collision with root package name */
    final Intent f241a;

    public C0294a(Intent intent) {
        this.f241a = intent;
    }

    public Intent c() {
        return this.f241a;
    }

    public String g() {
        String stringExtra = this.f241a.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return this.f241a.getStringExtra("message_id");
        }
        return stringExtra;
    }

    /* access modifiers changed from: package-private */
    public final Integer h() {
        if (this.f241a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f241a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.m(parcel, 1, this.f241a, i4, false);
        c.b(parcel, a5);
    }
}
