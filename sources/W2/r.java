package w2;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class r extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22047a;

    public r(Context context) {
        m.e(context, "context");
        this.f22047a = context.getResources().getDimensionPixelSize(R.dimen.margin_m);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            int i4 = this.f22047a;
            rect.left = i4;
            rect.right = i4;
            return;
        }
        rect.right = this.f22047a;
    }
}
