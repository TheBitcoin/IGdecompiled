package w2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class o extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f22040a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22041b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22042c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22043d;

    public o(int i4, int i5, int i6, int i7) {
        this.f22040a = i4;
        this.f22041b = i5;
        this.f22042c = i6;
        this.f22043d = i7;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        m.e(rect, "outRect");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(recyclerView, "parent");
        m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        rect.left = this.f22040a;
        rect.right = this.f22041b;
        rect.bottom = this.f22042c;
        rect.top = this.f22043d;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}
