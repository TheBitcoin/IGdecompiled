package w2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22036a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22037b;

    public l(int i4, int i5) {
        this.f22036a = i4;
        this.f22037b = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i4 = this.f22036a;
        rect.left = i4;
        rect.right = i4;
        if (childLayoutPosition == 0) {
            int i5 = this.f22037b;
            rect.top = i5 / 2;
            rect.bottom = i5;
        } else if (childLayoutPosition > 0) {
            rect.top = 0;
            rect.bottom = i4;
        }
    }
}
