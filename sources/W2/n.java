package w2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class n extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22039a;

    public n(int i4) {
        this.f22039a = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 1) {
            rect.top = this.f22039a / 2;
        } else if (childLayoutPosition > 1) {
            rect.top = this.f22039a;
        }
    }
}
