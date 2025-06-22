package J1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.LoginActivity;

/* renamed from: J1.s0  reason: case insensitive filesystem */
public final /* synthetic */ class C1437s0 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f7127a;

    public /* synthetic */ C1437s0(LoginActivity loginActivity) {
        this.f7127a = loginActivity;
    }

    public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        return LoginActivity.d4(this.f7127a, textView, i4, keyEvent);
    }
}
