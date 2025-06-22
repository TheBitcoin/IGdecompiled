package w2;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.m;

public final class p extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22044a;

    public p(int i4) {
        this.f22044a = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        a.C0236a aVar = a.f18818a;
        Context context = view.getContext();
        m.d(context, "getContext(...)");
        if (m.a(aVar.p(context), "ar")) {
            rect.right = this.f22044a;
            rect.left = 0;
            if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
                rect.left = this.f22044a;
                return;
            }
            return;
        }
        rect.left = this.f22044a;
        rect.right = 0;
        if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
            rect.right = this.f22044a;
        }
    }
}
