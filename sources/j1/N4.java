package J1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.SearchActivity;

public final /* synthetic */ class N4 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f6841a;

    public /* synthetic */ N4(SearchActivity searchActivity) {
        this.f6841a = searchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        return SearchActivity.B3(this.f6841a, textView, i4, keyEvent);
    }
}
