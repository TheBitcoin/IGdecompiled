package w2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class q extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22045a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22046b;

    public q(int i4) {
        this.f22045a = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (!this.f22046b && childAdapterPosition == this.f22045a) {
            rect.top = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
            this.f22046b = true;
        }
    }
}
