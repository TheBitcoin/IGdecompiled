package J1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.RepliesActivity;

/* renamed from: J1.j4  reason: case insensitive filesystem */
public final /* synthetic */ class C1379j4 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f7048a;

    public /* synthetic */ C1379j4(RepliesActivity repliesActivity) {
        this.f7048a = repliesActivity;
    }

    public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        return RepliesActivity.z3(this.f7048a, textView, i4, keyEvent);
    }
}
