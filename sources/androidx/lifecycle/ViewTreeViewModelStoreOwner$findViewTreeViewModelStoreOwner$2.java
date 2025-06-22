package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import com.mbridge.msdk.MBridgeConstans;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends n implements l {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    public final ViewModelStoreOwner invoke(View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
        if (tag instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) tag;
        }
        return null;
    }
}
