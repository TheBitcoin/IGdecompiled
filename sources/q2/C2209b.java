package q2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import g2.C2050h;
import g2.C2060s;
import java.util.List;
import kotlin.jvm.internal.m;
import u2.x;

/* renamed from: q2.b  reason: case insensitive filesystem */
public abstract class C2209b extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    private x f21576a;

    /* renamed from: q2.b$a */
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2060s f21577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2209b f21578b;

        public a(C2209b bVar, C2060s sVar) {
            m.e(sVar, "download");
            this.f21578b = bVar;
            this.f21577a = sVar;
        }

        public void run() {
            List<Fragment> fragments = this.f21578b.getSupportFragmentManager().getFragments();
            m.d(fragments, "getFragments(...)");
            if (fragments.size() > 0) {
                String string = this.f21578b.getString(R.string.tv_msg_download_complete, new Object[]{this.f21577a.i()});
                m.d(string, "getString(...)");
                Toast.makeText(fragments.get(0).getContext(), string, 1).show();
            }
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public final x k() {
        return this.f21576a;
    }

    public final void l(C2050h hVar, Presenter.ViewHolder viewHolder) {
        m.e(hVar, "appInfo");
        m.e(viewHolder, "itemViewHolder");
        Intent intent = new Intent(this, TvAppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        if (com.uptodown.activities.preferences.a.f18818a.N(this)) {
            View view = viewHolder.view;
            if (view instanceof ImageCardView) {
                m.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, ((ImageCardView) view).getMainImageView(), "transition_name").toBundle());
                return;
            }
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21576a = new x(this);
    }

    public boolean onSearchRequested() {
        startActivity(new Intent(this, TvSearchActivity.class));
        return true;
    }
}
