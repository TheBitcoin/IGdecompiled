package F;

import K.j;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class b implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Status f200a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInAccount f201b;

    public b(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f201b = googleSignInAccount;
        this.f200a = status;
    }

    public GoogleSignInAccount a() {
        return this.f201b;
    }

    public Status getStatus() {
        return this.f200a;
    }
}
