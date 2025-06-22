package G;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface t extends IInterface {
    void M(Status status);

    void N(GoogleSignInAccount googleSignInAccount, Status status);

    void U(Status status);
}
