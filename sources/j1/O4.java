package J1;

import android.view.View;
import android.widget.AdapterView;
import com.uptodown.activities.SearchActivity;

public final /* synthetic */ class O4 implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f6849a;

    public /* synthetic */ O4(SearchActivity searchActivity) {
        this.f6849a = searchActivity;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        SearchActivity.C3(this.f6849a, adapterView, view, i4, j4);
    }
}
