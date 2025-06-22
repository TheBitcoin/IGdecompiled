package androidx.leanback.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DividerPresenter;
import androidx.leanback.widget.DividerRow;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.SectionRow;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;

public class HeadersSupportFragment extends BaseRowSupportFragment {
    private static final PresenterSelector sHeaderPresenter = new ClassPresenterSelector().addClassPresenter(DividerRow.class, new DividerPresenter()).addClassPresenter(SectionRow.class, new RowHeaderPresenter(R.layout.lb_section_header, false)).addClassPresenter(Row.class, new RowHeaderPresenter(R.layout.lb_header));
    static View.OnLayoutChangeListener sLayoutChangeListener = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            float f4;
            if (view.getLayoutDirection() == 1) {
                f4 = (float) view.getWidth();
            } else {
                f4 = 0.0f;
            }
            view.setPivotX(f4);
            view.setPivotY((float) (view.getMeasuredHeight() / 2));
        }
    };
    private final ItemBridgeAdapter.AdapterListener mAdapterListener = new ItemBridgeAdapter.AdapterListener() {
        public void onCreate(final ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.getViewHolder().view;
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    OnHeaderClickedListener onHeaderClickedListener = HeadersSupportFragment.this.mOnHeaderClickedListener;
                    if (onHeaderClickedListener != null) {
                        onHeaderClickedListener.onHeaderClicked((RowHeaderPresenter.ViewHolder) viewHolder.getViewHolder(), (Row) viewHolder.getItem());
                    }
                }
            });
            if (HeadersSupportFragment.this.mWrapper != null) {
                viewHolder.itemView.addOnLayoutChangeListener(HeadersSupportFragment.sLayoutChangeListener);
            } else {
                view.addOnLayoutChangeListener(HeadersSupportFragment.sLayoutChangeListener);
            }
        }
    };
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private boolean mHeadersEnabled = true;
    private boolean mHeadersGone = false;
    OnHeaderClickedListener mOnHeaderClickedListener;
    private OnHeaderViewSelectedListener mOnHeaderViewSelectedListener;
    final ItemBridgeAdapter.Wrapper mWrapper = new ItemBridgeAdapter.Wrapper() {
        public View createWrapper(View view) {
            return new NoOverlappingFrameLayout(view.getContext());
        }

        public void wrap(View view, View view2) {
            ((FrameLayout) view).addView(view2);
        }
    };

    static class NoOverlappingFrameLayout extends FrameLayout {
        public NoOverlappingFrameLayout(Context context) {
            super(context);
        }

        public boolean hasOverlappingRendering() {
            return false;
        }
    }

    public interface OnHeaderClickedListener {
        void onHeaderClicked(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    public interface OnHeaderViewSelectedListener {
        void onHeaderSelected(RowHeaderPresenter.ViewHolder viewHolder, Row row);
    }

    public HeadersSupportFragment() {
        setPresenterSelector(sHeaderPresenter);
        FocusHighlightHelper.setupHeaderItemFocusHighlight(getBridgeAdapter());
    }

    private void updateFadingEdgeToBrandColor(int i4) {
        Drawable background = getView().findViewById(R.id.fade_out_edge).getBackground();
        if (background instanceof GradientDrawable) {
            background.mutate();
            ((GradientDrawable) background).setColors(new int[]{0, i4});
        }
    }

    private void updateListViewVisibility() {
        int i4;
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            View view = getView();
            if (this.mHeadersGone) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            view.setVisibility(i4);
            if (this.mHeadersGone) {
                return;
            }
            if (this.mHeadersEnabled) {
                verticalGridView.setChildrenVisibility(0);
            } else {
                verticalGridView.setChildrenVisibility(4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public VerticalGridView findGridViewFromRoot(View view) {
        return (VerticalGridView) view.findViewById(R.id.browse_headers);
    }

    /* access modifiers changed from: package-private */
    public int getLayoutResourceId() {
        return R.layout.lb_headers_fragment;
    }

    public /* bridge */ /* synthetic */ int getSelectedPosition() {
        return super.getSelectedPosition();
    }

    public boolean isScrolling() {
        if (getVerticalGridView().getScrollState() != 0) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: package-private */
    public void onRowSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        OnHeaderViewSelectedListener onHeaderViewSelectedListener = this.mOnHeaderViewSelectedListener;
        if (onHeaderViewSelectedListener == null) {
            return;
        }
        if (viewHolder == null || i4 < 0) {
            onHeaderViewSelectedListener.onHeaderSelected((RowHeaderPresenter.ViewHolder) null, (Row) null);
            return;
        }
        ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder;
        onHeaderViewSelectedListener.onHeaderSelected((RowHeaderPresenter.ViewHolder) viewHolder2.getViewHolder(), (Row) viewHolder2.getItem());
    }

    public /* bridge */ /* synthetic */ void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onTransitionEnd() {
        VerticalGridView verticalGridView;
        if (this.mHeadersEnabled && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(262144);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
        super.onTransitionEnd();
    }

    public /* bridge */ /* synthetic */ boolean onTransitionPrepare() {
        return super.onTransitionPrepare();
    }

    public void onTransitionStart() {
        VerticalGridView verticalGridView;
        super.onTransitionStart();
        if (!this.mHeadersEnabled && (verticalGridView = getVerticalGridView()) != null) {
            verticalGridView.setDescendantFocusability(131072);
            if (verticalGridView.hasFocus()) {
                verticalGridView.requestFocus();
            }
        }
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        VerticalGridView verticalGridView = getVerticalGridView();
        if (verticalGridView != null) {
            if (this.mBackgroundColorSet) {
                verticalGridView.setBackgroundColor(this.mBackgroundColor);
                updateFadingEdgeToBrandColor(this.mBackgroundColor);
            } else {
                Drawable background = verticalGridView.getBackground();
                if (background instanceof ColorDrawable) {
                    updateFadingEdgeToBrandColor(((ColorDrawable) background).getColor());
                }
            }
            updateListViewVisibility();
        }
    }

    public /* bridge */ /* synthetic */ void setAlignment(int i4) {
        super.setAlignment(i4);
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundColor(int i4) {
        this.mBackgroundColor = i4;
        this.mBackgroundColorSet = true;
        if (getVerticalGridView() != null) {
            getVerticalGridView().setBackgroundColor(this.mBackgroundColor);
            updateFadingEdgeToBrandColor(this.mBackgroundColor);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHeadersEnabled(boolean z4) {
        this.mHeadersEnabled = z4;
        updateListViewVisibility();
    }

    /* access modifiers changed from: package-private */
    public void setHeadersGone(boolean z4) {
        this.mHeadersGone = z4;
        updateListViewVisibility();
    }

    public void setOnHeaderClickedListener(OnHeaderClickedListener onHeaderClickedListener) {
        this.mOnHeaderClickedListener = onHeaderClickedListener;
    }

    public void setOnHeaderViewSelectedListener(OnHeaderViewSelectedListener onHeaderViewSelectedListener) {
        this.mOnHeaderViewSelectedListener = onHeaderViewSelectedListener;
    }

    public /* bridge */ /* synthetic */ void setSelectedPosition(int i4) {
        super.setSelectedPosition(i4);
    }

    /* access modifiers changed from: package-private */
    public void updateAdapter() {
        super.updateAdapter();
        ItemBridgeAdapter bridgeAdapter = getBridgeAdapter();
        bridgeAdapter.setAdapterListener(this.mAdapterListener);
        bridgeAdapter.setWrapper(this.mWrapper);
    }

    public /* bridge */ /* synthetic */ void setSelectedPosition(int i4, boolean z4) {
        super.setSelectedPosition(i4, z4);
    }
}
