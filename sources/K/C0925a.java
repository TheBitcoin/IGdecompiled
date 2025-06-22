package k;

import A1.b;
import A1.c;
import A1.f;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

/* renamed from: k.a  reason: case insensitive filesystem */
public abstract class C0925a extends BottomSheetDialogFragment {
    public final void g() {
        FragmentActivity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            activity.isFinishing();
            if ((!true) && isResumed()) {
                dismiss();
            }
        }
    }

    public abstract void h(ViewStub viewStub);

    public final void i(boolean z4) {
        View view;
        Dialog dialog = getDialog();
        if (dialog == null) {
            view = null;
        } else {
            view = dialog.findViewById(R.id.design_bottom_sheet);
        }
        if (view != null) {
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            m.d(from, "from(bottomSheetView as View)");
            from.setDraggable(z4);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public void onCancel(DialogInterface dialogInterface) {
        m.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, f.SheetDialog);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.base_bottom_sheet, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        ViewStub viewStub = (ViewStub) inflate.findViewById(b.container_vs);
        if (viewStub == null) {
            return inflate;
        }
        h(viewStub);
        return inflate;
    }

    public void onResume() {
        View view;
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onResume();
        View view2 = getView();
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(view);
                m.d(from, "from(parentView)");
                Context context = getContext();
                if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    int i4 = displayMetrics.heightPixels;
                    from.setPeekHeight(i4);
                    ViewStub viewStub = (ViewStub) view.findViewById(b.container_vs);
                    if (viewStub != null) {
                        viewStub.inflate().setMinimumHeight((int) (((double) i4) * 0.25d));
                    }
                }
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        ViewStub viewStub = (ViewStub) view.findViewById(b.container_vs);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(b.container_fl);
        ImageView imageView = (ImageView) view.findViewById(b.img_view);
    }
}
