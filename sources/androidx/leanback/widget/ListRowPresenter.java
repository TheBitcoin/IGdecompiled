package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;
import androidx.leanback.system.Settings;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.ShadowOverlayHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

public class ListRowPresenter extends RowPresenter {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_RECYCLED_POOL_SIZE = 24;
    private static final String TAG = "ListRowPresenter";
    private static int sExpandedRowNoHovercardBottomPadding;
    private static int sExpandedSelectedRowTopPadding;
    private static int sSelectedRowTopPadding;
    private int mBrowseRowsFadingEdgeLength;
    private int mExpandedRowHeight;
    private int mFocusZoomFactor;
    private PresenterSelector mHoverCardPresenterSelector;
    private boolean mKeepChildForeground;
    private int mNumRows;
    private HashMap<Presenter, Integer> mRecycledPoolSize;
    private boolean mRoundedCornersEnabled;
    private int mRowHeight;
    private boolean mShadowEnabled;
    ShadowOverlayHelper mShadowOverlayHelper;
    private ItemBridgeAdapter.Wrapper mShadowOverlayWrapper;
    private boolean mUseFocusDimmer;

    class ListRowPresenterItemBridgeAdapter extends ItemBridgeAdapter {
        ViewHolder mRowViewHolder;

        ListRowPresenterItemBridgeAdapter(ViewHolder viewHolder) {
            this.mRowViewHolder = viewHolder;
        }

        public void onAddPresenter(Presenter presenter, int i4) {
            this.mRowViewHolder.getGridView().getRecycledViewPool().setMaxRecycledViews(i4, ListRowPresenter.this.getRecycledPoolSize(presenter));
        }

        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            ListRowPresenter.this.applySelectLevelToChild(this.mRowViewHolder, viewHolder.itemView);
            this.mRowViewHolder.syncActivatedStatus(viewHolder.itemView);
        }

        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.mGridView.getChildViewHolder(viewHolder.itemView);
                        if (ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                            BaseOnItemViewClickedListener onItemViewClickedListener = ListRowPresenterItemBridgeAdapter.this.mRowViewHolder.getOnItemViewClickedListener();
                            Presenter.ViewHolder viewHolder2 = viewHolder.mHolder;
                            Object obj = viewHolder.mItem;
                            ViewHolder viewHolder3 = ListRowPresenterItemBridgeAdapter.this.mRowViewHolder;
                            onItemViewClickedListener.onItemClicked(viewHolder2, obj, viewHolder3, (ListRow) viewHolder3.mRow);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public void onCreate(ItemBridgeAdapter.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                TransitionHelper.setTransitionGroup((ViewGroup) view, true);
            }
            ShadowOverlayHelper shadowOverlayHelper = ListRowPresenter.this.mShadowOverlayHelper;
            if (shadowOverlayHelper != null) {
                shadowOverlayHelper.onViewCreated(viewHolder.itemView);
            }
        }

        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mRowViewHolder.getOnItemViewClickedListener() != null) {
                viewHolder.mHolder.view.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public static class SelectItemViewHolderTask extends Presenter.ViewHolderTask {
        private int mItemPosition;
        Presenter.ViewHolderTask mItemTask;
        private boolean mSmoothScroll = true;

        public SelectItemViewHolderTask(int i4) {
            setItemPosition(i4);
        }

        public int getItemPosition() {
            return this.mItemPosition;
        }

        public Presenter.ViewHolderTask getItemTask() {
            return this.mItemTask;
        }

        public boolean isSmoothScroll() {
            return this.mSmoothScroll;
        }

        public void run(Presenter.ViewHolder viewHolder) {
            AnonymousClass1 r02;
            if (viewHolder instanceof ViewHolder) {
                HorizontalGridView gridView = ((ViewHolder) viewHolder).getGridView();
                if (this.mItemTask != null) {
                    r02 = new ViewHolderTask() {
                        final Presenter.ViewHolderTask itemTask;

                        {
                            this.itemTask = SelectItemViewHolderTask.this.mItemTask;
                        }

                        public void run(RecyclerView.ViewHolder viewHolder) {
                            this.itemTask.run(((ItemBridgeAdapter.ViewHolder) viewHolder).getViewHolder());
                        }
                    };
                } else {
                    r02 = null;
                }
                if (isSmoothScroll()) {
                    gridView.setSelectedPositionSmooth(this.mItemPosition, r02);
                } else {
                    gridView.setSelectedPosition(this.mItemPosition, (ViewHolderTask) r02);
                }
            }
        }

        public void setItemPosition(int i4) {
            this.mItemPosition = i4;
        }

        public void setItemTask(Presenter.ViewHolderTask viewHolderTask) {
            this.mItemTask = viewHolderTask;
        }

        public void setSmoothScroll(boolean z4) {
            this.mSmoothScroll = z4;
        }
    }

    public static class ViewHolder extends RowPresenter.ViewHolder {
        final HorizontalGridView mGridView;
        final HorizontalHoverCardSwitcher mHoverCardViewSwitcher = new HorizontalHoverCardSwitcher();
        ItemBridgeAdapter mItemBridgeAdapter;
        final ListRowPresenter mListRowPresenter;
        final int mPaddingBottom;
        final int mPaddingLeft;
        final int mPaddingRight;
        final int mPaddingTop;

        public ViewHolder(View view, HorizontalGridView horizontalGridView, ListRowPresenter listRowPresenter) {
            super(view);
            this.mGridView = horizontalGridView;
            this.mListRowPresenter = listRowPresenter;
            this.mPaddingTop = horizontalGridView.getPaddingTop();
            this.mPaddingBottom = horizontalGridView.getPaddingBottom();
            this.mPaddingLeft = horizontalGridView.getPaddingLeft();
            this.mPaddingRight = horizontalGridView.getPaddingRight();
        }

        public final ItemBridgeAdapter getBridgeAdapter() {
            return this.mItemBridgeAdapter;
        }

        public final HorizontalGridView getGridView() {
            return this.mGridView;
        }

        public Presenter.ViewHolder getItemViewHolder(int i4) {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.mGridView.findViewHolderForAdapterPosition(i4);
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getViewHolder();
        }

        public final ListRowPresenter getListRowPresenter() {
            return this.mListRowPresenter;
        }

        public Object getSelectedItem() {
            ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) this.mGridView.findViewHolderForAdapterPosition(getSelectedPosition());
            if (viewHolder == null) {
                return null;
            }
            return viewHolder.getItem();
        }

        public Presenter.ViewHolder getSelectedItemViewHolder() {
            return getItemViewHolder(getSelectedPosition());
        }

        public int getSelectedPosition() {
            return this.mGridView.getSelectedPosition();
        }
    }

    public ListRowPresenter() {
        this(2);
    }

    private int getSpaceUnderBaseline(ViewHolder viewHolder) {
        RowHeaderPresenter.ViewHolder headerViewHolder = viewHolder.getHeaderViewHolder();
        if (headerViewHolder == null) {
            return 0;
        }
        if (getHeaderPresenter() != null) {
            return getHeaderPresenter().getSpaceUnderBaseline(headerViewHolder);
        }
        return headerViewHolder.view.getPaddingBottom();
    }

    private static void initStatics(Context context) {
        if (sSelectedRowTopPadding == 0) {
            sSelectedRowTopPadding = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_selected_row_top_padding);
            sExpandedSelectedRowTopPadding = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_expanded_selected_row_top_padding);
            sExpandedRowNoHovercardBottomPadding = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_expanded_row_no_hovercard_bottom_padding);
        }
    }

    private void setVerticalPadding(ViewHolder viewHolder) {
        int i4;
        int i5;
        int i6;
        if (viewHolder.isExpanded()) {
            int spaceUnderBaseline = getSpaceUnderBaseline(viewHolder);
            if (viewHolder.isSelected()) {
                i6 = sExpandedSelectedRowTopPadding;
            } else {
                i6 = viewHolder.mPaddingTop;
            }
            i4 = i6 - spaceUnderBaseline;
            if (this.mHoverCardPresenterSelector == null) {
                i5 = sExpandedRowNoHovercardBottomPadding;
            } else {
                i5 = viewHolder.mPaddingBottom;
            }
        } else if (viewHolder.isSelected()) {
            i5 = sSelectedRowTopPadding;
            i4 = i5 - viewHolder.mPaddingBottom;
        } else {
            i5 = viewHolder.mPaddingBottom;
            i4 = 0;
        }
        viewHolder.getGridView().setPadding(viewHolder.mPaddingLeft, i4, viewHolder.mPaddingRight, i5);
    }

    private void setupFadingEffect(ListRowView listRowView) {
        HorizontalGridView gridView = listRowView.getGridView();
        if (this.mBrowseRowsFadingEdgeLength < 0) {
            TypedArray obtainStyledAttributes = gridView.getContext().obtainStyledAttributes(R.styleable.LeanbackTheme);
            this.mBrowseRowsFadingEdgeLength = (int) obtainStyledAttributes.getDimension(R.styleable.LeanbackTheme_browseRowsFadingEdgeLength, 0.0f);
            obtainStyledAttributes.recycle();
        }
        gridView.setFadingLeftEdgeLength(this.mBrowseRowsFadingEdgeLength);
    }

    private void updateFooterViewSwitcher(ViewHolder viewHolder) {
        View view;
        if (viewHolder.mExpanded && viewHolder.mSelected) {
            PresenterSelector presenterSelector = this.mHoverCardPresenterSelector;
            if (presenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.init((ViewGroup) viewHolder.view, presenterSelector);
            }
            HorizontalGridView horizontalGridView = viewHolder.mGridView;
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
            if (viewHolder2 == null) {
                view = null;
            } else {
                view = viewHolder2.itemView;
            }
            selectChildView(viewHolder, view, false);
        } else if (this.mHoverCardPresenterSelector != null) {
            viewHolder.mHoverCardViewSwitcher.unselect();
        }
    }

    /* access modifiers changed from: protected */
    public void applySelectLevelToChild(ViewHolder viewHolder, View view) {
        ShadowOverlayHelper shadowOverlayHelper = this.mShadowOverlayHelper;
        if (shadowOverlayHelper != null && shadowOverlayHelper.needsOverlay()) {
            this.mShadowOverlayHelper.setOverlayColor(view, viewHolder.mColorDimmer.getPaint().getColor());
        }
    }

    public final boolean areChildRoundedCornersEnabled() {
        return this.mRoundedCornersEnabled;
    }

    /* access modifiers changed from: protected */
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        initStatics(viewGroup.getContext());
        ListRowView listRowView = new ListRowView(viewGroup.getContext());
        setupFadingEffect(listRowView);
        if (this.mRowHeight != 0) {
            listRowView.getGridView().setRowHeight(this.mRowHeight);
        }
        return new ViewHolder(listRowView, listRowView.getGridView(), this);
    }

    /* access modifiers changed from: protected */
    public ShadowOverlayHelper.Options createShadowOverlayOptions() {
        return ShadowOverlayHelper.Options.DEFAULT;
    }

    /* access modifiers changed from: protected */
    public void dispatchItemSelectedListener(RowPresenter.ViewHolder viewHolder, boolean z4) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        HorizontalGridView horizontalGridView = viewHolder2.mGridView;
        ItemBridgeAdapter.ViewHolder viewHolder3 = (ItemBridgeAdapter.ViewHolder) horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
        if (viewHolder3 == null) {
            super.dispatchItemSelectedListener(viewHolder, z4);
        } else if (z4 && viewHolder.getOnItemViewSelectedListener() != null) {
            viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder3.getViewHolder(), viewHolder3.mItem, viewHolder2, viewHolder2.getRow());
        }
    }

    public final void enableChildRoundedCorners(boolean z4) {
        this.mRoundedCornersEnabled = z4;
    }

    public void freeze(RowPresenter.ViewHolder viewHolder, boolean z4) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mGridView.setScrollEnabled(!z4);
        viewHolder2.mGridView.setAnimateChildLayout(!z4);
    }

    public int getExpandedRowHeight() {
        int i4 = this.mExpandedRowHeight;
        if (i4 != 0) {
            return i4;
        }
        return this.mRowHeight;
    }

    public final int getFocusZoomFactor() {
        return this.mFocusZoomFactor;
    }

    public final PresenterSelector getHoverCardPresenterSelector() {
        return this.mHoverCardPresenterSelector;
    }

    public int getRecycledPoolSize(Presenter presenter) {
        if (this.mRecycledPoolSize.containsKey(presenter)) {
            return this.mRecycledPoolSize.get(presenter).intValue();
        }
        return 24;
    }

    public int getRowHeight() {
        return this.mRowHeight;
    }

    public final boolean getShadowEnabled() {
        return this.mShadowEnabled;
    }

    @Deprecated
    public final int getZoomFactor() {
        return this.mFocusZoomFactor;
    }

    /* access modifiers changed from: protected */
    public void initializeRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        boolean z4;
        super.initializeRowViewHolder(viewHolder);
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Context context = viewHolder.view.getContext();
        boolean z5 = false;
        if (this.mShadowOverlayHelper == null) {
            ShadowOverlayHelper.Builder needsShadow = new ShadowOverlayHelper.Builder().needsOverlay(needsDefaultListSelectEffect()).needsShadow(needsDefaultShadow());
            if (!isUsingOutlineClipping(context) || !areChildRoundedCornersEnabled()) {
                z4 = false;
            } else {
                z4 = true;
            }
            ShadowOverlayHelper build = needsShadow.needsRoundedCorner(z4).preferZOrder(isUsingZOrder(context)).keepForegroundDrawable(this.mKeepChildForeground).options(createShadowOverlayOptions()).build(context);
            this.mShadowOverlayHelper = build;
            if (build.needsWrapper()) {
                this.mShadowOverlayWrapper = new ItemBridgeAdapterShadowOverlayWrapper(this.mShadowOverlayHelper);
            }
        }
        ListRowPresenterItemBridgeAdapter listRowPresenterItemBridgeAdapter = new ListRowPresenterItemBridgeAdapter(viewHolder2);
        viewHolder2.mItemBridgeAdapter = listRowPresenterItemBridgeAdapter;
        listRowPresenterItemBridgeAdapter.setWrapper(this.mShadowOverlayWrapper);
        this.mShadowOverlayHelper.prepareParentForShadow(viewHolder2.mGridView);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(viewHolder2.mItemBridgeAdapter, this.mFocusZoomFactor, this.mUseFocusDimmer);
        HorizontalGridView horizontalGridView = viewHolder2.mGridView;
        if (this.mShadowOverlayHelper.getShadowType() != 3) {
            z5 = true;
        }
        horizontalGridView.setFocusDrawingOrderEnabled(z5);
        viewHolder2.mGridView.setOnChildSelectedListener(new OnChildSelectedListener() {
            public void onChildSelected(ViewGroup viewGroup, View view, int i4, long j4) {
                ListRowPresenter.this.selectChildView(viewHolder2, view, true);
            }
        });
        viewHolder2.mGridView.setOnUnhandledKeyListener(new BaseGridView.OnUnhandledKeyListener() {
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                if (viewHolder2.getOnKeyListener() == null || !viewHolder2.getOnKeyListener().onKey(viewHolder2.view, keyEvent.getKeyCode(), keyEvent)) {
                    return false;
                }
                return true;
            }
        });
        viewHolder2.mGridView.setNumRows(this.mNumRows);
    }

    public final boolean isFocusDimmerUsed() {
        return this.mUseFocusDimmer;
    }

    public final boolean isKeepChildForeground() {
        return this.mKeepChildForeground;
    }

    public boolean isUsingDefaultListSelectEffect() {
        return true;
    }

    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public boolean isUsingDefaultShadow() {
        return ShadowOverlayHelper.supportsShadow();
    }

    public boolean isUsingOutlineClipping(Context context) {
        return !Settings.getInstance(context).isOutlineClippingDisabled();
    }

    public boolean isUsingZOrder(Context context) {
        return !Settings.getInstance(context).preferStaticShadows();
    }

    /* access modifiers changed from: package-private */
    public final boolean needsDefaultListSelectEffect() {
        if (!isUsingDefaultListSelectEffect() || !getSelectEffectEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean needsDefaultShadow() {
        if (!isUsingDefaultShadow() || !getShadowEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ListRow listRow = (ListRow) obj;
        viewHolder2.mItemBridgeAdapter.setAdapter(listRow.getAdapter());
        viewHolder2.mGridView.setAdapter(viewHolder2.mItemBridgeAdapter);
        viewHolder2.mGridView.setContentDescription(listRow.getContentDescription());
    }

    /* access modifiers changed from: protected */
    public void onRowViewExpanded(RowPresenter.ViewHolder viewHolder, boolean z4) {
        int i4;
        super.onRowViewExpanded(viewHolder, z4);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (getRowHeight() != getExpandedRowHeight()) {
            if (z4) {
                i4 = getExpandedRowHeight();
            } else {
                i4 = getRowHeight();
            }
            viewHolder2.getGridView().setRowHeight(i4);
        }
        setVerticalPadding(viewHolder2);
        updateFooterViewSwitcher(viewHolder2);
    }

    /* access modifiers changed from: protected */
    public void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z4) {
        super.onRowViewSelected(viewHolder, z4);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        setVerticalPadding(viewHolder2);
        updateFooterViewSwitcher(viewHolder2);
    }

    /* access modifiers changed from: protected */
    public void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int childCount = viewHolder2.mGridView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            applySelectLevelToChild(viewHolder2, viewHolder2.mGridView.getChildAt(i4));
        }
    }

    /* access modifiers changed from: protected */
    public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.mGridView.setAdapter((RecyclerView.Adapter) null);
        viewHolder2.mItemBridgeAdapter.clear();
        super.onUnbindRowViewHolder(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void selectChildView(ViewHolder viewHolder, View view, boolean z4) {
        if (view == null) {
            if (this.mHoverCardPresenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.unselect();
            }
            if (z4 && viewHolder.getOnItemViewSelectedListener() != null) {
                viewHolder.getOnItemViewSelectedListener().onItemSelected((Presenter.ViewHolder) null, (Object) null, viewHolder, viewHolder.mRow);
            }
        } else if (viewHolder.mSelected) {
            ItemBridgeAdapter.ViewHolder viewHolder2 = (ItemBridgeAdapter.ViewHolder) viewHolder.mGridView.getChildViewHolder(view);
            if (this.mHoverCardPresenterSelector != null) {
                viewHolder.mHoverCardViewSwitcher.select(viewHolder.mGridView, view, viewHolder2.mItem);
            }
            if (z4 && viewHolder.getOnItemViewSelectedListener() != null) {
                viewHolder.getOnItemViewSelectedListener().onItemSelected(viewHolder2.mHolder, viewHolder2.mItem, viewHolder, viewHolder.mRow);
            }
        }
    }

    public void setEntranceTransitionState(RowPresenter.ViewHolder viewHolder, boolean z4) {
        int i4;
        super.setEntranceTransitionState(viewHolder, z4);
        HorizontalGridView horizontalGridView = ((ViewHolder) viewHolder).mGridView;
        if (z4) {
            i4 = 0;
        } else {
            i4 = 4;
        }
        horizontalGridView.setChildrenVisibility(i4);
    }

    public void setExpandedRowHeight(int i4) {
        this.mExpandedRowHeight = i4;
    }

    public final void setHoverCardPresenterSelector(PresenterSelector presenterSelector) {
        this.mHoverCardPresenterSelector = presenterSelector;
    }

    public final void setKeepChildForeground(boolean z4) {
        this.mKeepChildForeground = z4;
    }

    public void setNumRows(int i4) {
        this.mNumRows = i4;
    }

    public void setRecycledPoolSize(Presenter presenter, int i4) {
        this.mRecycledPoolSize.put(presenter, Integer.valueOf(i4));
    }

    public void setRowHeight(int i4) {
        this.mRowHeight = i4;
    }

    public final void setShadowEnabled(boolean z4) {
        this.mShadowEnabled = z4;
    }

    public ListRowPresenter(int i4) {
        this(i4, false);
    }

    public ListRowPresenter(int i4, boolean z4) {
        this.mNumRows = 1;
        this.mShadowEnabled = true;
        this.mBrowseRowsFadingEdgeLength = -1;
        this.mRoundedCornersEnabled = true;
        this.mKeepChildForeground = true;
        this.mRecycledPoolSize = new HashMap<>();
        if (FocusHighlightHelper.isValidZoomIndex(i4)) {
            this.mFocusZoomFactor = i4;
            this.mUseFocusDimmer = z4;
            return;
        }
        throw new IllegalArgumentException("Unhandled zoom factor");
    }
}
