package w2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

public final class m extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22038a;

    public m(int i4) {
        this.f22038a = i4;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        kotlin.jvm.internal.m.e(rect, "outRect");
        kotlin.jvm.internal.m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        kotlin.jvm.internal.m.e(recyclerView, "parent");
        kotlin.jvm.internal.m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i4 = this.f22038a;
        rect.left = i4;
        rect.right = i4;
        rect.bottom = i4;
        if (childLayoutPosition > 0) {
            rect.top = 0;
        } else {
            rect.top = i4;
        }
    }
}
