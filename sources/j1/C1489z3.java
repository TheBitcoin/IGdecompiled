package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.PreregistrationActivity;

/* renamed from: J1.z3  reason: case insensitive filesystem */
public final /* synthetic */ class C1489z3 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f7231a;

    public /* synthetic */ C1489z3(PreregistrationActivity preregistrationActivity) {
        this.f7231a = preregistrationActivity;
    }

    public final void onActivityResult(Object obj) {
        PreregistrationActivity.H3(this.f7231a, (ActivityResult) obj);
    }
}
