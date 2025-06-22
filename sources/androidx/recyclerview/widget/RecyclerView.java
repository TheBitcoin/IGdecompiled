package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import j$.util.DesugarCollections;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled = false;
    static final StretchEdgeEffectFactory sDefaultEdgeEffectFactory = new StretchEdgeEffectFactory();
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    };
    static boolean sVerboseLoggingEnabled = false;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AnonymousClass7.<clinit>():void");
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds = false;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(@NonNull VH vh, int i4) {
            boolean z4;
            if (vh.mBindingAdapter == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                vh.mPosition = i4;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i4);
                }
                vh.setFlags(1, 519);
                TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView) != vh.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(vh.itemView) + ", holder: " + vh);
                } else if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh);
                }
            }
            onBindViewHolder(vh, i4, vh.getUnmodifiedPayloads());
            if (z4) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                TraceCompat.endSection();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean canRestoreState() {
            int i4 = AnonymousClass7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
            if (i4 == 1 || (i4 == 2 && getItemCount() <= 0)) {
                return false;
            }
            return true;
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i4) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i4);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i4;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends ViewHolder> adapter, @NonNull ViewHolder viewHolder, int i4) {
            if (adapter == this) {
                return i4;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i4) {
            return -1;
        }

        public int getItemViewType(int i4) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i4) {
            this.mObservable.notifyItemRangeChanged(i4, 1);
        }

        public final void notifyItemInserted(int i4) {
            this.mObservable.notifyItemRangeInserted(i4, 1);
        }

        public final void notifyItemMoved(int i4, int i5) {
            this.mObservable.notifyItemMoved(i4, i5);
        }

        public final void notifyItemRangeChanged(int i4, int i5) {
            this.mObservable.notifyItemRangeChanged(i4, i5);
        }

        public final void notifyItemRangeInserted(int i4, int i5) {
            this.mObservable.notifyItemRangeInserted(i4, i5);
        }

        public final void notifyItemRangeRemoved(int i4, int i5) {
            this.mObservable.notifyItemRangeRemoved(i4, i5);
        }

        public final void notifyItemRemoved(int i4) {
            this.mObservable.notifyItemRangeRemoved(i4, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i4);

        public void onBindViewHolder(@NonNull VH vh, int i4, @NonNull List<Object> list) {
            onBindViewHolder(vh, i4);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z4) {
            if (!hasObservers()) {
                this.mHasStableIds = z4;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i4, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i4, 1, obj);
        }

        public final void notifyItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i4, i5, obj);
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i4, i5, 1);
            }
        }

        public void notifyItemRangeChanged(int i4, int i5) {
            notifyItemRangeChanged(i4, i5, (Object) null);
        }

        public void notifyItemRangeInserted(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i4, i5);
            }
        }

        public void notifyItemRangeRemoved(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i4, i5);
            }
        }

        public void notifyStateRestorationPolicyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        public void notifyItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i4, i5, obj);
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i4, int i5) {
        }

        public void onItemRangeInserted(int i4, int i5) {
        }

        public void onItemRangeMoved(int i4, int i5, int i6) {
        }

        public void onItemRangeRemoved(int i4, int i5) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            onItemRangeChanged(i4, i5);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i4, int i5);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i4) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        private ItemAnimatorListener mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder viewHolder);
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i4) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i4 = viewHolder.mFlags;
            int i5 = i4 & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i4 & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                if (!(oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition)) {
                    return i5 | 2048;
                }
            }
            return i5;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mFinishedListeners.get(i4).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                    return isRunning;
                }
                this.mFinishedListeners.add(itemAnimatorFinishedListener);
            }
            return isRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i4, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j4) {
            this.mAddDuration = j4;
        }

        public void setChangeDuration(long j4) {
            this.mChangeDuration = j4;
        }

        /* access modifiers changed from: package-private */
        public void setListener(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public void setMoveDuration(long j4) {
            this.mMoveDuration = j4;
        }

        public void setRemoveDuration(long j4) {
            this.mRemoveDuration = j4;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i4, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int i4, int i5);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            AnonymousClass1 r02 = new ViewBoundsCheck.Callback() {
                public View getChildAt(int i4) {
                    return LayoutManager.this.getChildAt(i4);
                }

                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }

                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public int getParentEnd() {
                    return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
                }

                public int getParentStart() {
                    return LayoutManager.this.getPaddingLeft();
                }
            };
            this.mHorizontalBoundCheckCallback = r02;
            AnonymousClass2 r12 = new ViewBoundsCheck.Callback() {
                public View getChildAt(int i4) {
                    return LayoutManager.this.getChildAt(i4);
                }

                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }

                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                public int getParentEnd() {
                    return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
                }

                public int getParentStart() {
                    return LayoutManager.this.getPaddingTop();
                }
            };
            this.mVerticalBoundCheckCallback = r12;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r02);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r12);
        }

        private void addViewInt(View view, int i4, boolean z4) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z4 || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i4, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int indexOfChild = this.mChildHelper.indexOfChild(view);
                if (i4 == -1) {
                    i4 = this.mChildHelper.getChildCount();
                }
                if (indexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (indexOfChild != i4) {
                    this.mRecyclerView.mLayout.moveView(indexOfChild, i4);
                }
            } else {
                this.mChildHelper.addView(view, i4, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + layoutParams.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i5, i6));
            }
            if (mode != 1073741824) {
                return Math.max(i5, i6);
            }
            return size;
        }

        private void detachViewInternal(int i4, @NonNull View view) {
            this.mChildHelper.detachViewFromParent(i4);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x000c;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x0011
                if (r3 < 0) goto L_0x000f
            L_0x000c:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x000f:
                r3 = 0
                goto L_0x0021
            L_0x0011:
                if (r3 < 0) goto L_0x0014
                goto L_0x000c
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i4 = left - paddingLeft;
            int min = Math.min(0, i4);
            int i5 = top - paddingTop;
            int min2 = Math.min(0, i5);
            int i6 = width2 - width;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i4, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i6);
            }
            if (min2 == 0) {
                min2 = Math.min(i5, max2);
            }
            return new int[]{max, min2};
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i4, i5);
            properties.orientation = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i4, int i5) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i4 >= width || rect.right - i4 <= paddingLeft || rect.top - i5 >= height || rect.bottom - i5 <= paddingTop) {
                return false;
            }
            return true;
        }

        private static boolean isMeasurementUpToDate(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (i6 > 0 && i4 != i6) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode == 1073741824 && size == i4) {
                    return true;
                }
                return false;
            } else if (size >= i4) {
                return true;
            } else {
                return false;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i4, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "ignoring view " + childViewHolderInt);
                }
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                detachViewAt(i4);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
            } else {
                removeViewAt(i4);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(@NonNull View view, int i4, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i4, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i4, int i5, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i4, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i4, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, i4, getChildAt(i4));
        }

        public void detachView(@NonNull View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                detachViewInternal(indexOfChild, view);
            }
        }

        public void detachViewAt(int i4) {
            detachViewInternal(i4, getChildAt(i4));
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i4) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i4 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int i4) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i4);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.mClipToPadding) {
                return false;
            }
            return true;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z4, @NonNull Rect rect) {
            Matrix matrix;
            if (z4) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i4).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.hasFocus()) {
                return false;
            }
            return true;
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.isFocused()) {
                return false;
            }
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller == null || !smoothScroller.isRunning()) {
                return false;
            }
            return true;
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z4, boolean z5) {
            boolean z6;
            if (!this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) || !this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579)) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (z4) {
                return z6;
            }
            return !z6;
        }

        public void layoutDecorated(@NonNull View view, int i4, int i5, int i6, int i7) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i4 + rect.left, i5 + rect.top, i6 - rect.right, i7 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i4, int i5, int i6, int i7) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i4 + rect.left + layoutParams.leftMargin, i5 + rect.top + layoutParams.topMargin, (i6 - rect.right) - layoutParams.rightMargin, (i7 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void measureChild(@NonNull View view, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i6 = i4 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i7 = i5 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i6, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i7, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i6 = i4 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i7 = i5 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i6, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i7, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i4, int i5) {
            View childAt = getChildAt(i4);
            if (childAt != null) {
                detachViewAt(i4);
                attachView(childAt, i5);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i4 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(@Px int i4) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i4);
            }
        }

        public void offsetChildrenVertical(@Px int i4) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i4);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i4, int i5) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i4, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i4) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i4, int i5) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i4, int i5, int i6) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i4, int i5) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i4, int i5) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i4, int i5) {
            this.mRecyclerView.defaultOnMeasure(i4, i5);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i4) {
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i4, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i4, bundle);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i4, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i4 = scrapCount - 1; i4 >= 0; i4--) {
                View scrapViewAt = recycler.getScrapViewAt(i4);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.quickRecycleScrapView(scrapViewAt);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i4, @NonNull Recycler recycler) {
            View childAt = getChildAt(i4);
            removeViewAt(i4);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.removeView(view);
        }

        public void removeViewAt(int i4) {
            if (getChildAt(i4) != null) {
                this.mChildHelper.removeViewAt(i4);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z4) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z4, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i4, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i4) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i4, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z4) {
            this.mAutoMeasure = z4;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z4) {
            if (z4 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z4;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i4, int i5) {
            this.mWidth = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i4, int i5) {
            setMeasuredDimension(chooseSize(i4, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i5, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i4, int i5) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i4, i5);
                return;
            }
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = Integer.MAX_VALUE;
            int i9 = Integer.MAX_VALUE;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i11 = rect.left;
                if (i11 < i8) {
                    i8 = i11;
                }
                int i12 = rect.right;
                if (i12 > i6) {
                    i6 = i12;
                }
                int i13 = rect.top;
                if (i13 < i9) {
                    i9 = i13;
                }
                int i14 = rect.bottom;
                if (i14 > i7) {
                    i7 = i14;
                }
            }
            this.mRecyclerView.mTempRect.set(i8, i9, i6, i7);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i4, i5);
        }

        public void setMeasurementCacheEnabled(boolean z4) {
            this.mMeasurementCacheEnabled = z4;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i4, int i5, LayoutParams layoutParams) {
            if (view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i4, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i5, layoutParams.height)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i4, int i5, LayoutParams layoutParams) {
            if (!this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i4, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i5, layoutParams.height)) {
                return true;
            }
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i4) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i4) {
            addViewInt(view, i4, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i4) {
            addViewInt(view, i4, false);
        }

        @CallSuper
        @SuppressLint({"UnknownNullness"})
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z4 = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z4 = false;
                }
                accessibilityEvent.setScrollable(z4);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i4, int i5, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i4, i5);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0094 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler r9, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State r10, int r11, @androidx.annotation.Nullable android.os.Bundle r12) {
            /*
                r8 = this;
                androidx.recyclerview.widget.RecyclerView r9 = r8.mRecyclerView
                r10 = 0
                if (r9 != 0) goto L_0x0006
                return r10
            L_0x0006:
                int r9 = r8.getHeight()
                int r12 = r8.getWidth()
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L_0x002f
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L_0x002f
                int r9 = r0.height()
                int r12 = r0.width()
            L_0x002f:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r11 == r0) goto L_0x006a
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r0) goto L_0x003b
                r3 = 0
                r4 = 0
                goto L_0x0092
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                r0 = -1
                boolean r11 = r11.canScrollVertically(r0)
                if (r11 == 0) goto L_0x0050
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                int r9 = -r9
                goto L_0x0051
            L_0x0050:
                r9 = 0
            L_0x0051:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r0)
                if (r11 == 0) goto L_0x0067
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r12 = r12 - r11
                int r11 = -r12
            L_0x0064:
                r4 = r9
                r3 = r11
                goto L_0x0092
            L_0x0067:
                r4 = r9
                r3 = 0
                goto L_0x0092
            L_0x006a:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollVertically(r1)
                if (r11 == 0) goto L_0x007d
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                goto L_0x007e
            L_0x007d:
                r9 = 0
            L_0x007e:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r1)
                if (r11 == 0) goto L_0x0067
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r11 = r12 - r11
                goto L_0x0064
            L_0x0092:
                if (r4 != 0) goto L_0x0097
                if (r3 != 0) goto L_0x0097
                return r10
            L_0x0097:
                androidx.recyclerview.widget.RecyclerView r2 = r8.mRecyclerView
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = 1
                r5 = 0
                r2.smoothScrollBy(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(@NonNull View view, int i4, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i4, bundle);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z4, boolean z5) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i4 = childRectangleOnScreenScrollAmount[0];
            int i5 = childRectangleOnScreenScrollAmount[1];
            if ((z5 && !isFocusedChildVisibleAfterScrolling(recyclerView, i4, i5)) || (i4 == 0 && i5 == 0)) {
                return false;
            }
            if (z4) {
                recyclerView.scrollBy(i4, i5);
            } else {
                recyclerView.smoothScrollBy(i4, i5);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
            if (r5 == 1073741824) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001e
                if (r7 < 0) goto L_0x0013
            L_0x0010:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x0013:
                if (r7 != r1) goto L_0x001b
                if (r5 == r2) goto L_0x0023
                if (r5 == 0) goto L_0x001b
                if (r5 == r3) goto L_0x0023
            L_0x001b:
                r5 = 0
                r7 = 0
                goto L_0x0031
            L_0x001e:
                if (r7 < 0) goto L_0x0021
                goto L_0x0010
            L_0x0021:
                if (r7 != r1) goto L_0x0025
            L_0x0023:
                r7 = r4
                goto L_0x0031
            L_0x0025:
                if (r7 != r0) goto L_0x001b
                if (r5 == r2) goto L_0x002e
                if (r5 != r3) goto L_0x002c
                goto L_0x002e
            L_0x002c:
                r5 = 0
                goto L_0x0023
            L_0x002e:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0023
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(@NonNull View view, int i4) {
            attachView(view, i4, (LayoutParams) view.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i4, int i5) {
            this.mRecyclerView.setMeasuredDimension(i4, i5);
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i4, int i5);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z4);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i4) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i4, int i5) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        int mAttachCountForClearing = 0;
        Set<Adapter<?>> mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());
        SparseArray<ScrapData> mScrap = new SparseArray<>();

        static class ScrapData {
            long mBindRunningAverageNs = 0;
            long mCreateRunningAverageNs = 0;
            int mMaxScrap = 5;
            final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();

            ScrapData() {
            }
        }

        private ScrapData getScrapDataForType(int i4) {
            ScrapData scrapData = this.mScrap.get(i4);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.mScrap.put(i4, scrapData2);
            return scrapData2;
        }

        /* access modifiers changed from: package-private */
        public void attach() {
            this.mAttachCountForClearing++;
        }

        /* access modifiers changed from: package-private */
        public void attachForPoolingContainer(@NonNull Adapter<?> adapter) {
            this.mAttachedAdaptersForPoolingContainer.add(adapter);
        }

        public void clear() {
            for (int i4 = 0; i4 < this.mScrap.size(); i4++) {
                ScrapData valueAt = this.mScrap.valueAt(i4);
                ArrayList<ViewHolder> arrayList = valueAt.mScrapHeap;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    ViewHolder viewHolder = arrayList.get(i5);
                    i5++;
                    PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
                }
                valueAt.mScrapHeap.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            this.mAttachCountForClearing--;
        }

        /* access modifiers changed from: package-private */
        public void detachForPoolingContainer(@NonNull Adapter<?> adapter, boolean z4) {
            this.mAttachedAdaptersForPoolingContainer.remove(adapter);
            if (this.mAttachedAdaptersForPoolingContainer.size() == 0 && !z4) {
                for (int i4 = 0; i4 < this.mScrap.size(); i4++) {
                    SparseArray<ScrapData> sparseArray = this.mScrap;
                    ArrayList<ViewHolder> arrayList = sparseArray.get(sparseArray.keyAt(i4)).mScrapHeap;
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        PoolingContainer.callPoolingContainerOnRelease(arrayList.get(i5).itemView);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void factorInBindTime(int i4, long j4) {
            ScrapData scrapDataForType = getScrapDataForType(i4);
            scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j4);
        }

        /* access modifiers changed from: package-private */
        public void factorInCreateTime(int i4, long j4) {
            ScrapData scrapDataForType = getScrapDataForType(i4);
            scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j4);
        }

        @Nullable
        public ViewHolder getRecycledView(int i4) {
            ScrapData scrapData = this.mScrap.get(i4);
            if (scrapData == null || scrapData.mScrapHeap.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int getRecycledViewCount(int i4) {
            return getScrapDataForType(i4).mScrapHeap.size();
        }

        /* access modifiers changed from: package-private */
        public void onAdapterChanged(Adapter<?> adapter, Adapter<?> adapter2, boolean z4) {
            if (adapter != null) {
                detach();
            }
            if (!z4 && this.mAttachCountForClearing == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach();
            }
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
                PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
            } else if (!RecyclerView.sDebugAssertionsEnabled || !arrayList.contains(viewHolder)) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            } else {
                throw new IllegalArgumentException("this scrap item already exists");
            }
        }

        /* access modifiers changed from: package-private */
        public long runningAverage(long j4, long j5) {
            if (j4 == 0) {
                return j5;
            }
            return ((j4 / 4) * 3) + (j5 / 4);
        }

        public void setMaxRecycledViews(int i4, int i5) {
            ScrapData scrapDataForType = getScrapDataForType(i4);
            scrapDataForType.mMaxScrap = i5;
            ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
            while (arrayList.size() > i5) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        /* access modifiers changed from: package-private */
        public int size() {
            int i4 = 0;
            for (int i5 = 0; i5 < this.mScrap.size(); i5++) {
                ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i5).mScrapHeap;
                if (arrayList != null) {
                    i4 += arrayList.size();
                }
            }
            return i4;
        }

        /* access modifiers changed from: package-private */
        public boolean willBindInTime(int i4, long j4, long j5) {
            long j6 = getScrapDataForType(i4).mBindRunningAverageNs;
            if (j6 == 0 || j4 + j6 < j5) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean willCreateInTime(int i4, long j4, long j5) {
            long j6 = getScrapDataForType(i4).mCreateRunningAverageNs;
            if (j6 == 0 || j4 + j6 < j5) {
                return true;
            }
            return false;
        }
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews = new ArrayList<>();
        ArrayList<ViewHolder> mChangedScrap = null;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mUnmodifiableAttachedScrap = DesugarCollections.unmodifiableList(arrayList);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                    if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view);
                    }
                    ViewCompat.setAccessibilityDelegate(view, itemDelegate);
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view, false);
            }
        }

        private void maybeSendPoolingContainerAttach() {
            if (this.mRecyclerPool != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter != null && recyclerView.isAttachedToWindow()) {
                    this.mRecyclerPool.attachForPoolingContainer(RecyclerView.this.mAdapter);
                }
            }
        }

        private void poolingContainerDetach(Adapter<?> adapter) {
            poolingContainerDetach(adapter, false);
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i4, int i5, long j4) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z4 = false;
            if (j4 != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j4)) {
                return false;
            }
            if (viewHolder.isTmpDetached()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(viewHolder.itemView, recyclerView.getChildCount(), viewHolder.itemView.getLayoutParams());
                z4 = true;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i4);
            if (z4) {
                RecyclerView.this.detachViewFromParent(viewHolder.itemView);
            }
            this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (RecyclerView.this.mState.isPreLayout()) {
                viewHolder.mPreLayoutPosition = i5;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder viewHolder, boolean z4) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            }
            if (z4) {
                dispatchViewRecycled(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        public void bindViewToPosition(@NonNull View view, int i4) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                int findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i4);
                if (findPositionOffset < 0 || findPositionOffset >= RecyclerView.this.mAdapter.getItemCount()) {
                    int i5 = i4;
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i5 + "(offset:" + findPositionOffset + ").state:" + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
                }
                tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i4, Long.MAX_VALUE);
                ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                    childViewHolderInt.itemView.setLayoutParams(layoutParams);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                    layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                    childViewHolderInt.itemView.setLayoutParams(layoutParams);
                } else {
                    layoutParams = (LayoutParams) layoutParams2;
                }
                boolean z4 = true;
                layoutParams.mInsetsDirty = true;
                layoutParams.mViewHolder = childViewHolderInt;
                if (childViewHolderInt.itemView.getParent() != null) {
                    z4 = false;
                }
                layoutParams.mPendingInvalidate = z4;
                return;
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.exceptionLabel());
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        /* access modifiers changed from: package-private */
        public void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mCachedViews.get(i4).clearOldPosition();
            }
            int size2 = this.mAttachedScrap.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.mAttachedScrap.get(i5).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    this.mChangedScrap.get(i6).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int convertPreLayoutPositionToPostLayout(int i4) {
            if (i4 < 0 || i4 >= RecyclerView.this.mState.getItemCount()) {
                throw new IndexOutOfBoundsException("invalid position " + i4 + ". State item count is " + RecyclerView.this.mState.getItemCount() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.isPreLayout()) {
                return i4;
            } else {
                return RecyclerView.this.mAdapterHelper.findPositionOffset(i4);
            }
        }

        /* access modifiers changed from: package-private */
        public void dispatchViewRecycled(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView.this.mRecyclerListeners.get(i4).onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getChangedScrapViewForPosition(int i4) {
            int size;
            int findPositionOffset;
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i5 = 0;
                int i6 = 0;
                while (i6 < size) {
                    ViewHolder viewHolder = this.mChangedScrap.get(i6);
                    if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i4) {
                        i6++;
                    } else {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (findPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i4)) > 0 && findPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(findPositionOffset);
                    while (i5 < size) {
                        ViewHolder viewHolder2 = this.mChangedScrap.get(i5);
                        if (viewHolder2.wasReturnedFromScrap() || viewHolder2.getItemId() != itemId) {
                            i5++;
                        } else {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
                maybeSendPoolingContainerAttach();
            }
            return this.mRecyclerPool;
        }

        /* access modifiers changed from: package-private */
        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getScrapOrCachedViewForId(long j4, int i4, boolean z4) {
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j4 && !viewHolder.wasReturnedFromScrap()) {
                    if (i4 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z4) {
                        this.mAttachedScrap.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        quickRecycleScrapView(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.mCachedViews.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j4 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i4 == viewHolder2.getItemViewType()) {
                        if (!z4) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z4) {
                        recycleCachedViewAt(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i4, boolean z4) {
            View findHiddenNonRemovedView;
            int size = this.mAttachedScrap.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i6);
                if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i4 || viewHolder.isInvalid() || (!RecyclerView.this.mState.mInPreLayout && viewHolder.isRemoved())) {
                    i6++;
                } else {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (z4 || (findHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i4)) == null) {
                int size2 = this.mCachedViews.size();
                while (i5 < size2) {
                    ViewHolder viewHolder2 = this.mCachedViews.get(i5);
                    if (viewHolder2.isInvalid() || viewHolder2.getLayoutPosition() != i4 || viewHolder2.isAttachedToTransitionOverlay()) {
                        i5++;
                    } else {
                        if (!z4) {
                            this.mCachedViews.remove(i5);
                        }
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + i4 + ") found match in cache: " + viewHolder2);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
            RecyclerView.this.mChildHelper.unhide(findHiddenNonRemovedView);
            int indexOfChild = RecyclerView.this.mChildHelper.indexOfChild(findHiddenNonRemovedView);
            if (indexOfChild != -1) {
                RecyclerView.this.mChildHelper.detachViewFromParent(indexOfChild);
                scrapView(findHiddenNonRemovedView);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* access modifiers changed from: package-private */
        public View getScrapViewAt(int i4) {
            return this.mAttachedScrap.get(i4).itemView;
        }

        @NonNull
        public View getViewForPosition(int i4) {
            return getViewForPosition(i4, false);
        }

        /* access modifiers changed from: package-private */
        public void markItemDecorInsetsDirty() {
            int size = this.mCachedViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i4).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void markKnownViewsInvalid() {
            int size = this.mCachedViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = this.mCachedViews.get(i4);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                recycleAndClearCachedViews();
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForInsert(int i4, int i5) {
            int size = this.mCachedViews.size();
            for (int i6 = 0; i6 < size; i6++) {
                ViewHolder viewHolder = this.mCachedViews.get(i6);
                if (viewHolder != null && viewHolder.mPosition >= i4) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + i6 + " holder " + viewHolder + " now at position " + (viewHolder.mPosition + i5));
                    }
                    viewHolder.offsetPosition(i5, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForMove(int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            if (i4 < i5) {
                i8 = -1;
                i7 = i4;
                i6 = i5;
            } else {
                i8 = 1;
                i6 = i4;
                i7 = i5;
            }
            int size = this.mCachedViews.size();
            for (int i10 = 0; i10 < size; i10++) {
                ViewHolder viewHolder = this.mCachedViews.get(i10);
                if (viewHolder != null && (i9 = viewHolder.mPosition) >= i7 && i9 <= i6) {
                    if (i9 == i4) {
                        viewHolder.offsetPosition(i5 - i4, false);
                    } else {
                        viewHolder.offsetPosition(i8, false);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + i10 + " holder " + viewHolder);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void offsetPositionRecordsForRemove(int i4, int i5, boolean z4) {
            int i6 = i4 + i5;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    int i7 = viewHolder.mPosition;
                    if (i7 >= i6) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.mPosition - i5));
                        }
                        viewHolder.offsetPosition(-i5, z4);
                    } else if (i7 >= i4) {
                        viewHolder.addFlags(8);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onAdapterChanged(Adapter<?> adapter, Adapter<?> adapter2, boolean z4) {
            clear();
            poolingContainerDetach(adapter, true);
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z4);
            maybeSendPoolingContainerAttach();
        }

        /* access modifiers changed from: package-private */
        public void onAttachedToWindow() {
            maybeSendPoolingContainerAttach();
        }

        /* access modifiers changed from: package-private */
        public void onDetachedFromWindow() {
            for (int i4 = 0; i4 < this.mCachedViews.size(); i4++) {
                PoolingContainer.callPoolingContainerOnRelease(this.mCachedViews.get(i4).itemView);
            }
            poolingContainerDetach(RecyclerView.this.mAdapter);
        }

        /* access modifiers changed from: package-private */
        public void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        /* access modifiers changed from: package-private */
        public void recycleCachedViewAt(int i4) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "Recycling cached view at index " + i4);
            }
            ViewHolder viewHolder = this.mCachedViews.get(i4);
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + viewHolder);
            }
            addViewHolderToRecycledViewPool(viewHolder, true);
            this.mCachedViews.remove(i4);
        }

        public void recycleView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z4;
            boolean z5;
            boolean z6 = false;
            boolean z7 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z6 = true;
                }
                sb.append(z6);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!viewHolder.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.mAdapter;
                if (adapter == null || !doesTransientStatePreventRecycling || !adapter.onFailedToRecycleView(viewHolder)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!RecyclerView.sDebugAssertionsEnabled || !this.mCachedViews.contains(viewHolder)) {
                    if (z4 || viewHolder.isRecyclable()) {
                        if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                            z5 = false;
                        } else {
                            int size = this.mCachedViews.size();
                            if (size >= this.mViewCacheMax && size > 0) {
                                recycleCachedViewAt(0);
                                size--;
                            }
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                                int i4 = size - 1;
                                while (i4 >= 0) {
                                    if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i4).mPosition)) {
                                        break;
                                    }
                                    i4--;
                                }
                                size = i4 + 1;
                            }
                            this.mCachedViews.add(size, viewHolder);
                            z5 = true;
                        }
                        if (!z5) {
                            addViewHolderToRecycledViewPool(viewHolder, true);
                            z6 = z5;
                            RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                            if (!z6 && !z7 && doesTransientStatePreventRecycling) {
                                PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
                                viewHolder.mBindingAdapter = null;
                                viewHolder.mOwnerRecyclerView = null;
                                return;
                            }
                            return;
                        }
                        z6 = z5;
                    } else if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.exceptionLabel());
                    }
                    z7 = false;
                    RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
                    if (!z6) {
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("cached view received recycle internal? " + viewHolder + RecyclerView.this.exceptionLabel());
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.mAttachedScrap.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            poolingContainerDetach(RecyclerView.this.mAdapter);
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (!(recycledViewPool == null || RecyclerView.this.getAdapter() == null)) {
                this.mRecyclerPool.attach();
            }
            maybeSendPoolingContainerAttach();
        }

        /* access modifiers changed from: package-private */
        public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        public void setViewCacheSize(int i4) {
            this.mRequestedCacheMax = i4;
            updateViewCacheSize();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x0248  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01c6  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01ef  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01f2  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r0 = r16
                r3 = r17
                r1 = r18
                if (r3 < 0) goto L_0x0279
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.getItemCount()
                if (r3 >= r2) goto L_0x0279
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                boolean r2 = r2.isPreLayout()
                r4 = 0
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r16.getChangedScrapViewForPosition(r17)
                if (r2 == 0) goto L_0x0028
                r5 = 1
                goto L_0x0029
            L_0x0027:
                r2 = r4
            L_0x0028:
                r5 = 0
            L_0x0029:
                if (r2 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r16.getScrapOrHiddenOrCachedHolderForPosition(r17, r18)
                if (r2 == 0) goto L_0x005d
                boolean r8 = r0.validateViewHolderForOffsetPosition(r2)
                if (r8 != 0) goto L_0x005c
                if (r1 != 0) goto L_0x005a
                r8 = 4
                r2.addFlags(r8)
                boolean r8 = r2.isScrap()
                if (r8 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r2.itemView
                r8.removeDetachedView(r9, r7)
                r2.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r8 = r2.wasReturnedFromScrap()
                if (r8 == 0) goto L_0x0057
                r2.clearReturnedFromScrapFlag()
            L_0x0057:
                r0.recycleViewHolderInternal(r2)
            L_0x005a:
                r2 = r4
                goto L_0x005d
            L_0x005c:
                r5 = 1
            L_0x005d:
                if (r2 != 0) goto L_0x016c
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r8 = r8.mAdapterHelper
                int r8 = r8.findPositionOffset(r3)
                if (r8 < 0) goto L_0x016f
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r8 >= r9) goto L_0x016f
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r11 = r9.getItemViewType(r8)
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                boolean r9 = r9.hasStableIds()
                if (r9 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r2.mAdapter
                long r9 = r2.getItemId(r8)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r0.getScrapOrCachedViewForId(r9, r11, r1)
                if (r2 == 0) goto L_0x0096
                r2.mPosition = r8
                r5 = 1
            L_0x0096:
                if (r2 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r1 = r0.mViewCacheExtension
                if (r1 == 0) goto L_0x00eb
                android.view.View r1 = r1.getViewForPositionAndType(r0, r3, r11)
                if (r1 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r2.getChildViewHolder(r1)
                if (r2 == 0) goto L_0x00ce
                boolean r1 = r2.shouldIgnore()
                if (r1 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r3 = r3.exceptionLabel()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x00ce:
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r3 = r3.exceptionLabel()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x00eb:
                java.lang.String r1 = "RecyclerView"
                if (r2 != 0) goto L_0x0120
                boolean r2 = androidx.recyclerview.widget.RecyclerView.sVerboseLoggingEnabled
                if (r2 == 0) goto L_0x010c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = "tryGetViewHolderForPositionByDeadline("
                r2.append(r8)
                r2.append(r3)
                java.lang.String r8 = ") fetching from shared pool"
                r2.append(r8)
                java.lang.String r2 = r2.toString()
                android.util.Log.d(r1, r2)
            L_0x010c:
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r2 = r0.getRecycledViewPool()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r2.getRecycledView(r11)
                if (r2 == 0) goto L_0x0120
                r2.resetInternal()
                boolean r8 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r8 == 0) goto L_0x0120
                r0.invalidateDisplayListInt(r2)
            L_0x0120:
                if (r2 != 0) goto L_0x016c
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                long r12 = r2.getNanoTime()
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r2 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
                if (r2 == 0) goto L_0x013c
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r0.mRecyclerPool
                r14 = r19
                boolean r2 = r10.willCreateInTime(r11, r12, r14)
                if (r2 != 0) goto L_0x013c
                return r4
            L_0x013c:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r4 = r2.mAdapter
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r4.createViewHolder(r2, r11)
                boolean r4 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r4 == 0) goto L_0x0157
                android.view.View r4 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r4)
                if (r4 == 0) goto L_0x0157
                java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference
                r8.<init>(r4)
                r2.mNestedRecyclerView = r8
            L_0x0157:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                long r8 = r4.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r4 = r0.mRecyclerPool
                long r8 = r8 - r12
                r4.factorInCreateTime(r11, r8)
                boolean r4 = androidx.recyclerview.widget.RecyclerView.sVerboseLoggingEnabled
                if (r4 == 0) goto L_0x016c
                java.lang.String r4 = "tryGetViewHolderForPositionByDeadline created new ViewHolder"
                android.util.Log.d(r1, r4)
            L_0x016c:
                r1 = r2
                r8 = r5
                goto L_0x01a7
            L_0x016f:
                java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Inconsistency detected. Invalid item position "
                r2.append(r4)
                r2.append(r3)
                java.lang.String r3 = "(offset:"
                r2.append(r3)
                r2.append(r8)
                java.lang.String r3 = ").state:"
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                int r3 = r3.getItemCount()
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r3 = r3.exceptionLabel()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x01a7:
                if (r8 == 0) goto L_0x01df
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                boolean r2 = r2.isPreLayout()
                if (r2 != 0) goto L_0x01df
                r2 = 8192(0x2000, float:1.14794E-41)
                boolean r4 = r1.hasAnyOfTheFlags(r2)
                if (r4 == 0) goto L_0x01df
                r1.setFlags(r7, r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                boolean r2 = r2.mRunSimpleAnimations
                if (r2 == 0) goto L_0x01df
                int r2 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r1)
                r2 = r2 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r5 = r4.mItemAnimator
                androidx.recyclerview.widget.RecyclerView$State r4 = r4.mState
                java.util.List r9 = r1.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r2 = r5.recordPreLayoutInformation(r4, r1, r2, r9)
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                r4.recordAnimationInfoIfBouncedHiddenView(r1, r2)
            L_0x01df:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                boolean r2 = r2.isPreLayout()
                if (r2 == 0) goto L_0x01f2
                boolean r2 = r1.isBound()
                if (r2 == 0) goto L_0x01f2
                r1.mPreLayoutPosition = r3
                goto L_0x0205
            L_0x01f2:
                boolean r2 = r1.isBound()
                if (r2 == 0) goto L_0x0207
                boolean r2 = r1.needsUpdate()
                if (r2 != 0) goto L_0x0207
                boolean r2 = r1.isInvalid()
                if (r2 == 0) goto L_0x0205
                goto L_0x0207
            L_0x0205:
                r2 = 0
                goto L_0x0240
            L_0x0207:
                boolean r2 = androidx.recyclerview.widget.RecyclerView.sDebugAssertionsEnabled
                if (r2 == 0) goto L_0x0232
                boolean r2 = r1.isRemoved()
                if (r2 != 0) goto L_0x0212
                goto L_0x0232
            L_0x0212:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Removed holder should be bound and it should come here only in pre-layout. Holder: "
                r3.append(r4)
                r3.append(r1)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r1 = r1.exceptionLabel()
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x0232:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r2 = r2.mAdapterHelper
                int r2 = r2.findPositionOffset(r3)
                r4 = r19
                boolean r2 = r0.tryBindViewHolderByDeadline(r1, r2, r3, r4)
            L_0x0240:
                android.view.View r3 = r1.itemView
                android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
                if (r3 != 0) goto L_0x0256
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r3 = r3.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
                android.view.View r4 = r1.itemView
                r4.setLayoutParams(r3)
                goto L_0x026e
            L_0x0256:
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                boolean r4 = r4.checkLayoutParams(r3)
                if (r4 != 0) goto L_0x026c
                androidx.recyclerview.widget.RecyclerView r4 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r3 = r4.generateLayoutParams((android.view.ViewGroup.LayoutParams) r3)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
                android.view.View r4 = r1.itemView
                r4.setLayoutParams(r3)
                goto L_0x026e
            L_0x026c:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
            L_0x026e:
                r3.mViewHolder = r1
                if (r8 == 0) goto L_0x0275
                if (r2 == 0) goto L_0x0275
                goto L_0x0276
            L_0x0275:
                r6 = 0
            L_0x0276:
                r3.mPendingInvalidate = r6
                return r1
            L_0x0279:
                java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Invalid item position "
                r2.append(r4)
                r2.append(r3)
                java.lang.String r4 = "("
                r2.append(r4)
                r2.append(r3)
                java.lang.String r3 = "). Item count:"
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r3 = r3.mState
                int r3 = r3.getItemCount()
                r2.append(r3)
                androidx.recyclerview.widget.RecyclerView r3 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r3 = r3.exceptionLabel()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.tryGetViewHolderForPositionByDeadline(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        /* access modifiers changed from: package-private */
        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public void updateViewCacheSize() {
            int i4;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                i4 = layoutManager.mPrefetchMaxCountObserved;
            } else {
                i4 = 0;
            }
            this.mViewCacheMax = this.mRequestedCacheMax + i4;
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            if (!viewHolder.isRemoved()) {
                int i4 = viewHolder.mPosition;
                if (i4 < 0 || i4 >= RecyclerView.this.mAdapter.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
                } else if (!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                    return false;
                } else {
                    if (!RecyclerView.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                        return true;
                    }
                    return false;
                }
            } else if (!RecyclerView.sDebugAssertionsEnabled || RecyclerView.this.mState.isPreLayout()) {
                return RecyclerView.this.mState.isPreLayout();
            } else {
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void viewRangeUpdate(int i4, int i5) {
            int i6;
            int i7 = i5 + i4;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (i6 = viewHolder.mPosition) >= i4 && i6 < i7) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        private void poolingContainerDetach(Adapter<?> adapter, boolean z4) {
            RecycledViewPool recycledViewPool = this.mRecyclerPool;
            if (recycledViewPool != null) {
                recycledViewPool.detachForPoolingContainer(adapter, z4);
            }
        }

        /* access modifiers changed from: package-private */
        public View getViewForPosition(int i4, boolean z4) {
            return tryGetViewHolderForPositionByDeadline(i4, z4, Long.MAX_VALUE).itemView;
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z4) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z4) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i4, int i5, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i4, i5, obj)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeInserted(int i4, int i5) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i4, i5)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeMoved(int i4, int i5, int i6) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i4, i5, i6)) {
                triggerUpdateProcessor();
            }
        }

        public void onItemRangeRemoved(int i4, int i5) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i4, i5)) {
                triggerUpdateProcessor();
            }
        }

        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        /* access modifiers changed from: package-private */
        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z4) {
        }

        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction = new Action(0, 0);
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int i4, @Px int i5) {
                this(i4, i5, Integer.MIN_VALUE, (Interpolator) null);
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            /* access modifiers changed from: package-private */
            public boolean hasJumpTarget() {
                if (this.mJumpToPosition >= 0) {
                    return true;
                }
                return false;
            }

            public void jumpTo(int i4) {
                this.mJumpToPosition = i4;
            }

            /* access modifiers changed from: package-private */
            public void runIfNecessary(RecyclerView recyclerView) {
                int i4 = this.mJumpToPosition;
                if (i4 >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i4);
                    this.mChanged = false;
                } else if (this.mChanged) {
                    validate();
                    recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    int i5 = this.mConsecutiveUpdates + 1;
                    this.mConsecutiveUpdates = i5;
                    if (i5 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.mChanged = false;
                } else {
                    this.mConsecutiveUpdates = 0;
                }
            }

            public void setDuration(int i4) {
                this.mChanged = true;
                this.mDuration = i4;
            }

            public void setDx(@Px int i4) {
                this.mChanged = true;
                this.mDx = i4;
            }

            public void setDy(@Px int i4) {
                this.mChanged = true;
                this.mDy = i4;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void update(@Px int i4, @Px int i5, int i6, @Nullable Interpolator interpolator) {
                this.mDx = i4;
                this.mDy = i5;
                this.mDuration = i6;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }

            public Action(@Px int i4, @Px int i5, int i6) {
                this(i4, i5, i6, (Interpolator) null);
            }

            public Action(@Px int i4, @Px int i5, int i6, @Nullable Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i4;
                this.mDy = i5;
                this.mDuration = i6;
                this.mInterpolator = interpolator;
            }
        }

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i4);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i4) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i4);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i4) {
            return this.mRecyclerView.mLayout.findViewByPosition(i4);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i4) {
            this.mRecyclerView.scrollToPosition(i4);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        /* access modifiers changed from: protected */
        public void normalize(@NonNull PointF pointF) {
            float f4 = pointF.x;
            float f5 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f4 * f4) + (f5 * f5)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i4, int i5) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f4 = computeScrollVectorForPosition.x;
                if (!(f4 == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
                    recyclerView.scrollStep((int) Math.signum(f4), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i4, i5, recyclerView.mState, this.mRecyclingAction);
                boolean hasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (hasJumpTarget && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(@Px int i4, @Px int i5, @NonNull State state, @NonNull Action action);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        public void setTargetPosition(int i4) {
            this.mTargetPosition = i4;
        }

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i4 = this.mTargetPosition;
            if (i4 != -1) {
                recyclerView.mState.mTargetPosition = i4;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.postOnAnimation();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout = false;
        boolean mIsMeasuring = false;
        int mItemCount = 0;
        int mLayoutStep = 1;
        int mPreviousLayoutItemCount = 0;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations = false;
        boolean mRunSimpleAnimations = false;
        boolean mStructureChanged = false;
        int mTargetPosition = -1;
        boolean mTrackOldChangeHolders = false;

        /* access modifiers changed from: package-private */
        public void assertLayoutStep(int i4) {
            if ((this.mLayoutStep & i4) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i4) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
            }
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int i4) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i4);
        }

        public int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition != -1) {
                return true;
            }
            return false;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        /* access modifiers changed from: package-private */
        public void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int i4, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i4, obj);
        }

        public void remove(int i4) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray != null) {
                sparseArray.remove(i4);
            }
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        StretchEdgeEffectFactory() {
        }

        /* access modifiers changed from: protected */
        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i4) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i4, int i5);
    }

    class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest = false;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int computeScrollDuration(int i4, int i5) {
            boolean z4;
            int i6;
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            if (abs > abs2) {
                z4 = true;
            } else {
                z4 = false;
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (z4) {
                i6 = recyclerView.getWidth();
            } else {
                i6 = recyclerView.getHeight();
            }
            if (!z4) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) i6)) + 1.0f) * 300.0f), 2000);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i4, int i5) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i4, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        /* access modifiers changed from: package-private */
        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        public void run() {
            int i4;
            int i5;
            boolean z4;
            boolean z5;
            boolean z6;
            int i6;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i7 = currX - this.mLastFlingX;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int consumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i7);
                int consumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(currY - this.mLastFlingY);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    consumeFlingInHorizontalStretch -= iArr2[0];
                    consumeFlingInVerticalStretch -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    int i8 = iArr4[0];
                    int i9 = iArr4[1];
                    consumeFlingInHorizontalStretch -= i8;
                    consumeFlingInVerticalStretch -= i9;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i8, i9);
                        } else {
                            smoothScroller.onAnimation(i8, i9);
                        }
                    }
                    i5 = i9;
                    i4 = i8;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                int i10 = consumeFlingInHorizontalStretch;
                int i11 = consumeFlingInVerticalStretch;
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i4, i5, i10, i11, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i12 = i10 - iArr6[0];
                int i13 = i11 - iArr6[1];
                if (!(i4 == 0 && i5 == 0)) {
                    recyclerView6.dispatchOnScrolled(i4, i5);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (overScroller.isFinished() || ((z4 || i12 != 0) && (z5 || i13 != 0))) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 == null || !smoothScroller2.isPendingInitialRun()) && z6) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i12 < 0) {
                            i6 = -currVelocity;
                        } else if (i12 > 0) {
                            i6 = currVelocity;
                        } else {
                            i6 = 0;
                        }
                        if (i13 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i13 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i6, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView7, i4, i5);
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }

        public void smoothScrollBy(int i4, int i5, int i6, @Nullable Interpolator interpolator) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = computeScrollDuration(i4, i5);
            }
            int i7 = i6;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i4, i5, i7);
            if (Build.VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        @NonNull
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        @VisibleForTesting
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        Recycler mScrapContainer = null;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(@NonNull View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = DesugarCollections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i4) {
            this.mFlags = i4 | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) != 0 || !ViewCompat.hasTransientState(this.itemView)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i4, int i5, boolean z4) {
            addFlags(8);
            offsetPosition(i5, z4);
            this.mPosition = i4;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i4 = this.mPreLayoutPosition;
            if (i4 == -1) {
                return this.mPosition;
            }
            return i4;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i4 = this.mPreLayoutPosition;
            if (i4 == -1) {
                return this.mPosition;
            }
            return i4;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i4) {
            if ((i4 & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) != 0 || isInvalid()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) != 0 || ViewCompat.hasTransientState(this.itemView)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            if ((this.mFlags & 256) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i4, boolean z4) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z4) {
                this.mPreLayoutPosition += i4;
            }
            this.mPosition += i4;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i4 = this.mPendingAccessibilityState;
            if (i4 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i4;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            if (!RecyclerView.sDebugAssertionsEnabled || !isTmpDetached()) {
                this.mFlags = 0;
                this.mPosition = -1;
                this.mOldPosition = -1;
                this.mItemId = -1;
                this.mPreLayoutPosition = -1;
                this.mIsRecyclableCount = 0;
                this.mShadowedHolder = null;
                this.mShadowingHolder = null;
                clearPayload();
                this.mWasImportantForAccessibilityBeforeHidden = 0;
                this.mPendingAccessibilityState = -1;
                RecyclerView.clearNestedRecyclerViewIfNotNested(this);
                return;
            }
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i4, int i5) {
            this.mFlags = (i4 & i5) | (this.mFlags & (~i5));
        }

        public final void setIsRecyclable(boolean z4) {
            int i4;
            int i5 = this.mIsRecyclableCount;
            if (z4) {
                i4 = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
            this.mIsRecyclableCount = i4;
            if (i4 < 0) {
                this.mIsRecyclableCount = 0;
                if (!RecyclerView.sDebugAssertionsEnabled) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else if (!z4 && i4 == 1) {
                this.mFlags |= 16;
            } else if (z4 && i4 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "setIsRecyclable val:" + z4 + ":" + this);
            }
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(Recycler recycler, boolean z4) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z4;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            if ((this.mFlags & 128) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String str;
            String str2;
            if (getClass().isAnonymousClass()) {
                str = "ViewHolder";
            } else {
                str = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(str + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str2 = "[changeScrap]";
                } else {
                    str2 = "[attachedScrap]";
                }
                sb.append(str2);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            r1 = 0
            r2 = 16843830(0x1010436, float:2.369658E-38)
            int[] r2 = new int[]{r2}
            NESTED_SCROLLING_ATTRS = r2
            r2 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r2 = java.lang.Math.log(r2)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r2 = r2 / r4
            float r2 = (float) r2
            DECELERATION_RATE = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            FORCE_INVALIDATE_DISPLAY_LIST = r1
            r3 = 23
            if (r2 < r3) goto L_0x002b
            r2 = 1
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r2
            POST_UPDATES_ON_ANIMATION = r0
            ALLOW_THREAD_GAP_WORK = r0
            FORCE_ABS_FOCUS_SEARCH_DIRECTION = r1
            IGNORE_DETACHED_FOCUSED_CHILD = r1
            r2 = 4
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r1] = r3
            java.lang.Class<android.util.AttributeSet> r1 = android.util.AttributeSet.class
            r2[r0] = r1
            java.lang.Class r0 = java.lang.Integer.TYPE
            r1 = 2
            r2[r1] = r0
            r1 = 3
            r2[r1] = r0
            LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = r2
            androidx.recyclerview.widget.RecyclerView$3 r0 = new androidx.recyclerview.widget.RecyclerView$3
            r0.<init>()
            sQuinticInterpolator = r0
            androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory r0 = new androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory
            r0.<init>()
            sDefaultEdgeEffectFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        boolean z4;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z4) {
            this.mChildHelper.addView(view, true);
        } else {
            this.mChildHelper.hide(view);
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z4, boolean z5) {
        viewHolder.setIsRecyclable(false);
        if (z4) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z5) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            View view = weakReference.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                    } else {
                        view = null;
                    }
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i4, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i5) {
        if (i4 > 0 && edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != 0.0f) {
            int round = Math.round((((float) (-i5)) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(edgeEffect, (((float) (-i4)) * FLING_DESTRETCH_FACTOR) / ((float) i5), 0.5f));
            if (round != i4) {
                edgeEffect.finish();
            }
            return i4 - round;
        } else if (i4 >= 0 || edgeEffect2 == null || EdgeEffectCompat.getDistance(edgeEffect2) == 0.0f) {
            return i4;
        } else {
            float f4 = (float) i5;
            int round2 = Math.round((f4 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(edgeEffect2, (((float) i4) * FLING_DESTRETCH_FACTOR) / f4, 0.5f));
            if (round2 != i4) {
                edgeEffect2.finish();
            }
            return i4 - round2;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i4, int i5) {
        ClassLoader classLoader;
        Object[] objArr;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i4), Integer.valueOf(i5)};
                    } catch (NoSuchMethodException e5) {
                        objArr = null;
                        constructor = asSubclass.getConstructor((Class[]) null);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e6) {
                    e6.initCause(e5);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e6);
                } catch (ClassNotFoundException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
                } catch (InstantiationException e9) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e9);
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e10);
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e11);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i4, int i5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        if (iArr[0] == i4 && iArr[1] == i5) {
            return false;
        }
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i4 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i4 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.setContentChangeTypes(obtain, i4);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z4 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (!state.mRunSimpleAnimations || !this.mItemsChanged) {
            z4 = false;
        }
        state.mTrackOldChangeHolders = z4;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        state.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z5 = state2.mStructureChanged;
            state2.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.mStructureChanged = z5;
            for (int i5 = 0; i5 < this.mChildHelper.getChildCount(); i5++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i5));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z4;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        if (!state2.mRunSimpleAnimations || this.mItemAnimator == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        state2.mRunSimpleAnimations = z4;
        state2.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        RecyclerView recyclerView;
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders == null || fromOldChangeHolders.shouldIgnore()) {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                    } else {
                        boolean isDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean isDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (!isDisappearing || fromOldChangeHolders != childViewHolderInt) {
                            ItemAnimator.ItemHolderInfo popFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo popFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (popFromPreLayout == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            } else {
                                animateChange(fromOldChangeHolders, childViewHolderInt, popFromPreLayout, popFromPostLayout, isDisappearing, isDisappearing2);
                            }
                        } else {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, recordPostLayoutInformation);
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.mViewInfoStore.process(recyclerView.mViewInfoProcessCallback);
        } else {
            recyclerView = this;
        }
        recyclerView.mLayout.removeAndRecycleScrapInt(recyclerView.mRecycler);
        State state2 = recyclerView.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        recyclerView.mDataSetHasChangedAfterLayout = false;
        recyclerView.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        recyclerView.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = recyclerView.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = recyclerView.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            recyclerView.mRecycler.updateViewCacheSize();
        }
        recyclerView.mLayout.onLayoutCompleted(recyclerView.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        recyclerView.mViewInfoStore.clear();
        int[] iArr = recyclerView.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener != null) {
            onItemTouchListener.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i4 = 0;
        while (i4 < size) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i4);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i4++;
            } else {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        for (int i6 = 0; i6 < childCount; i6++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i6));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i4) {
                    i4 = layoutPosition;
                }
                if (layoutPosition > i5) {
                    i5 = layoutPosition;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
    }

    @Nullable
    static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i4));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.mState;
        int i4 = state.mFocusedItemPosition;
        if (i4 == -1) {
            i4 = 0;
        }
        int itemCount = state.getItemCount();
        int i5 = i4;
        while (i5 < itemCount) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i5);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i5++;
            }
        }
        int min = Math.min(itemCount, i4);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i4) {
        double log = Math.log((double) ((((float) Math.abs(i4)) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION)));
        float f4 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoef * SCROLL_FRICTION)) * Math.exp((((double) f4) / (((double) f4) - 1.0d)) * log));
    }

    private void handleMissingPreInfoForChangeError(long j4, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j4) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
            public void addView(View view, int i4) {
                RecyclerView.this.addView(view, i4);
                RecyclerView.this.dispatchChildAttached(view);
            }

            public void attachViewToParent(View view, int i4, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "reAttach " + childViewHolderInt);
                        }
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                } else if (RecyclerView.sDebugAssertionsEnabled) {
                    throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i4 + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.attachViewToParent(view, i4, layoutParams);
            }

            public void detachViewFromParent(int i4) {
                View childAt = getChildAt(i4);
                if (childAt != null) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                    if (childViewHolderInt != null) {
                        if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                            if (RecyclerView.sVerboseLoggingEnabled) {
                                Log.d(RecyclerView.TAG, "tmpDetach " + childViewHolderInt);
                            }
                            childViewHolderInt.addFlags(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                        }
                    }
                } else if (RecyclerView.sDebugAssertionsEnabled) {
                    throw new IllegalArgumentException("No view at offset " + i4 + RecyclerView.this.exceptionLabel());
                }
                RecyclerView.this.detachViewFromParent(i4);
            }

            public View getChildAt(int i4) {
                return RecyclerView.this.getChildAt(i4);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void onEnteredHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public void onLeftHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int i4) {
                View childAt = RecyclerView.this.getChildAt(i4);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i4);
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i4) {
        int i5;
        int i6;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c5 = 65535;
        if (this.mLayout.getLayoutDirection() == 1) {
            i5 = -1;
        } else {
            i5 = 1;
        }
        Rect rect = this.mTempRect;
        int i7 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i8 = rect2.left;
        if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
            i6 = 1;
        } else {
            int i9 = rect.right;
            int i10 = rect2.right;
            if ((i9 > i10 || i7 >= i10) && i7 > i8) {
                i6 = -1;
            } else {
                i6 = 0;
            }
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        if ((i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom) {
            c5 = 1;
        } else {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 <= i14 && i11 < i14) || i11 <= i12) {
                c5 = 0;
            }
        }
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 17) {
                    if (i4 != 33) {
                        if (i4 != 66) {
                            if (i4 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i4 + exceptionLabel());
                            } else if (c5 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i6 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c5 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i6 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c5 > 0 || (c5 == 0 && i6 * i5 > 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c5 < 0 || (c5 == 0 && i6 * i5 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void nestedScrollByInternal(int i4, int i5, @Nullable MotionEvent motionEvent, int i6) {
        boolean z4;
        float f4;
        float f5;
        int i7;
        int i8;
        int i9;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i10 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollVertically) {
                z4 = canScrollHorizontally | true;
            } else {
                z4 = canScrollHorizontally;
            }
            if (motionEvent == null) {
                f4 = ((float) getHeight()) / 2.0f;
            } else {
                f4 = motionEvent.getY();
            }
            if (motionEvent == null) {
                f5 = ((float) getWidth()) / 2.0f;
            } else {
                f5 = motionEvent.getX();
            }
            int releaseHorizontalGlow = i4 - releaseHorizontalGlow(i4, f4);
            int releaseVerticalGlow = i5 - releaseVerticalGlow(i5, f5);
            startNestedScroll(z4 ? 1 : 0, i6);
            if (canScrollHorizontally) {
                i7 = releaseHorizontalGlow;
            } else {
                i7 = 0;
            }
            if (canScrollVertically) {
                i8 = releaseVerticalGlow;
            } else {
                i8 = 0;
            }
            int i11 = i6;
            if (dispatchNestedPreScroll(i7, i8, this.mReusableIntPair, this.mScrollOffset, i11)) {
                int[] iArr2 = this.mReusableIntPair;
                releaseHorizontalGlow -= iArr2[0];
                releaseVerticalGlow -= iArr2[1];
            }
            if (canScrollHorizontally) {
                i9 = releaseHorizontalGlow;
            } else {
                i9 = 0;
            }
            if (canScrollVertically) {
                i10 = releaseVerticalGlow;
            }
            scrollByInternal(i9, i10, motionEvent, i11);
            GapWorker gapWorker = this.mGapWorker;
            if (!(gapWorker == null || (releaseHorizontalGlow == 0 && releaseVerticalGlow == 0))) {
                gapWorker.postFromTraversal(this, releaseHorizontalGlow, releaseVerticalGlow);
            }
            stopNestedScroll(i11);
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i4;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i4);
            int x4 = (int) (motionEvent.getX(i4) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(i4) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            return false;
        }
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z4;
        boolean z5;
        boolean z6;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z7 = true;
        if (this.mItemsAddedOrRemoved || this.mItemsChanged) {
            z4 = true;
        } else {
            z4 = false;
        }
        State state = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || ((!(z6 = this.mDataSetHasChangedAfterLayout) && !z4 && !this.mLayout.mRequestedSimpleAnimations) || (z6 && !this.mAdapter.hasStableIds()))) {
            z5 = false;
        } else {
            z5 = true;
        }
        state.mRunSimpleAnimations = z5;
        State state2 = this.mState;
        if (!state2.mRunSimpleAnimations || !z4 || this.mDataSetHasChangedAfterLayout || !predictiveItemAnimationsEnabled()) {
            z7 = false;
        }
        state2.mRunPredictiveAnimations = z7;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.EdgeEffectCompat.onPullDistance(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.onPullDistance(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.onPullDistance(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.onPullDistance(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007e
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007e
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            return
        L_0x007e:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.isHidden(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.getChildCount() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                if (this.mState.mFocusedItemId == -1 || !this.mAdapter.hasStableIds()) {
                    viewHolder = null;
                } else {
                    viewHolder = findViewHolderForItemId(this.mState.mFocusedItemId);
                }
                if (viewHolder != null && !this.mChildHelper.isHidden(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view = viewHolder.itemView;
                } else if (this.mChildHelper.getChildCount() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i4 = this.mState.mFocusedSubChildId;
                    if (!(((long) i4) == -1 || (findViewById = view.findViewById(i4)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z4;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z4 = this.mLeftGlow.isFinished();
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z4 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z4 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z4 |= this.mBottomGlow.isFinished();
        }
        if (z4) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private int releaseHorizontalGlow(int i4, float f4) {
        float height = f4 / ((float) getHeight());
        float width = ((float) i4) / ((float) getWidth());
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f5 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (!(edgeEffect2 == null || EdgeEffectCompat.getDistance(edgeEffect2) == 0.0f)) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float onPullDistance = EdgeEffectCompat.onPullDistance(this.mRightGlow, width, height);
                    if (EdgeEffectCompat.getDistance(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f5 = onPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f6 = -EdgeEffectCompat.onPullDistance(this.mLeftGlow, -width, 1.0f - height);
                if (EdgeEffectCompat.getDistance(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f5 = f6;
            }
            invalidate();
        }
        return Math.round(f5 * ((float) getWidth()));
    }

    private int releaseVerticalGlow(int i4, float f4) {
        float width = f4 / ((float) getWidth());
        float height = ((float) i4) / ((float) getHeight());
        EdgeEffect edgeEffect = this.mTopGlow;
        float f5 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (!(edgeEffect2 == null || EdgeEffectCompat.getDistance(edgeEffect2) == 0.0f)) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float onPullDistance = EdgeEffectCompat.onPullDistance(this.mBottomGlow, height, 1.0f - width);
                    if (EdgeEffectCompat.getDistance(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f5 = onPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f6 = -EdgeEffectCompat.onPullDistance(this.mTopGlow, -height, width);
                if (EdgeEffectCompat.getDistance(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f5 = f6;
            }
            invalidate();
        }
        return Math.round(f5 * ((float) getHeight()));
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3;
        boolean z4;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z5 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z5, z4);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View view;
        long j4;
        int i4;
        ViewHolder viewHolder = null;
        if (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        State state = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j4 = viewHolder.getItemId();
        } else {
            j4 = -1;
        }
        state.mFocusedItemId = j4;
        State state2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i4 = -1;
        } else if (viewHolder.isRemoved()) {
            i4 = viewHolder.mOldPosition;
        } else {
            i4 = viewHolder.getAbsoluteAdapterPosition();
        }
        state2.mFocusedItemPosition = i4;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(@Nullable Adapter<?> adapter, boolean z4, boolean z5) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z4 || z5) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z4);
        this.mState.mStructureChanged = true;
    }

    public static void setDebugAssertionsEnabled(boolean z4) {
        sDebugAssertionsEnabled = z4;
    }

    public static void setVerboseLoggingEnabled(boolean z4) {
        sVerboseLoggingEnabled = z4;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i4, int i5) {
        if (i4 > 0) {
            return true;
        }
        if (getSplineFlingDistance(-i4) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) i5)) {
            return true;
        }
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z4;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z4 = false;
        } else {
            EdgeEffectCompat.onPullDistance(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / ((float) getHeight())));
            z4 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (!(edgeEffect2 == null || EdgeEffectCompat.getDistance(edgeEffect2) == 0.0f || canScrollHorizontally(1))) {
            EdgeEffectCompat.onPullDistance(this.mRightGlow, 0.0f, motionEvent.getY() / ((float) getHeight()));
            z4 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (!(edgeEffect3 == null || EdgeEffectCompat.getDistance(edgeEffect3) == 0.0f || canScrollVertically(-1))) {
            EdgeEffectCompat.onPullDistance(this.mTopGlow, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z4 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || EdgeEffectCompat.getDistance(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z4;
        }
        EdgeEffectCompat.onPullDistance(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i4, int i5) {
        if (i4 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i4);
            }
        }
        if (i5 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i5);
            }
        } else if (i5 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i5);
            }
        }
        if (i4 != 0 || i5 != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i4, i5)) {
            super.addFocusables(arrayList, i4, i5);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i4 < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i4, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        boolean z4;
        if (recyclerListener != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerListener);
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i4, int i5) {
        boolean z4;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i4 <= 0) {
            z4 = false;
        } else {
            this.mLeftGlow.onRelease();
            z4 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.mRightGlow.onRelease();
            z4 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.mTopGlow.onRelease();
            z4 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.mBottomGlow.onRelease();
            z4 |= this.mBottomGlow.isFinished();
        }
        if (z4) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInHorizontalStretch(int i4) {
        return consumeFlingInStretch(i4, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInVerticalStretch(int i4) {
        return consumeFlingInStretch(i4, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
        } else if (this.mAdapterHelper.hasPendingUpdates()) {
            if (this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.consumePostponedUpdates();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.endSection();
            } else if (this.mAdapterHelper.hasPendingUpdates()) {
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.endSection();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i4, int i5) {
        setMeasuredDimension(LayoutManager.chooseSize(i4, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i5, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        boolean z4;
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.mIsMeasuring = false;
            if (!this.mLastAutoMeasureSkippedDueToExact || (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight())) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.mLayoutStep == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (this.mAdapterHelper.hasUpdates() || z4 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return getScrollingChildHelper().dispatchNestedFling(f4, f5, z4);
    }

    public boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().dispatchNestedPreFling(f4, f5);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i4, i5, i6, i7, iArr);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i4);
        }
        onScrollStateChanged(i4);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i4);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i4, int i5) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i4, scrollY - i5);
        onScrolled(i4, i5);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i4, i5);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i4, i5);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i4;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i4 = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i4);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z4;
        int i4;
        boolean z5;
        boolean z6;
        int i5;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z7 = false;
        for (int i6 = 0; i6 < size; i6++) {
            this.mItemDecorations.get(i6).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z8 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i5 = getPaddingBottom();
            } else {
                i5 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i5), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 == null || !edgeEffect2.draw(canvas)) {
                z4 = false;
            } else {
                z4 = true;
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 == null || !edgeEffect4.draw(canvas)) {
                z6 = false;
            } else {
                z6 = true;
            }
            z4 |= z6;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i4 = getPaddingTop();
            } else {
                i4 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) i4, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 == null || !edgeEffect6.draw(canvas)) {
                z5 = false;
            } else {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z7 = true;
            }
            z4 |= z7;
            canvas.restoreToCount(save4);
        }
        if (z4 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z8 = z4;
        }
        if (z8) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
            this.mBottomGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
            this.mLeftGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
            this.mRightGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                createEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect createEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
            this.mTopGlow = createEdgeEffect;
            if (this.mClipToPadding) {
                createEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                createEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.mRemainingScrollHorizontal = 0;
        state.mRemainingScrollVertical = 0;
    }

    @Nullable
    public View findChildViewUnder(float f4, float f5) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f4 >= ((float) childAt.getLeft()) + translationX && f4 <= ((float) childAt.getRight()) + translationX && f5 >= ((float) childAt.getTop()) + translationY && f5 <= ((float) childAt.getBottom()) + translationY) {
                return childAt;
            }
        }
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i4) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i5 = 0; i5 < unfilteredChildCount; i5++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i5));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i4) {
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j4) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j4) {
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i4) {
        return findViewHolderForPosition(i4, false);
    }

    @Deprecated
    @Nullable
    public ViewHolder findViewHolderForPosition(int i4) {
        return findViewHolderForPosition(i4, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r7.mLayout
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r8 = "RecyclerView"
            java.lang.String r9 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument."
            android.util.Log.e(r8, r9)
            return r1
        L_0x000d:
            boolean r2 = r7.mLayoutSuppressed
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r7.mLayout
            boolean r2 = r2.canScrollVertically()
            if (r0 == 0) goto L_0x0026
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0031
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r8 != 0) goto L_0x0037
            if (r9 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r3 = 0
            if (r8 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            if (r4 == 0) goto L_0x005c
            float r4 = androidx.core.widget.EdgeEffectCompat.getDistance(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r5, r6)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r8 = r7.mLeftGlow
            r8.onAbsorb(r5)
        L_0x0058:
            r8 = 0
        L_0x0059:
            r4 = r8
            r8 = 0
            goto L_0x007b
        L_0x005c:
            android.widget.EdgeEffect r4 = r7.mRightGlow
            if (r4 == 0) goto L_0x007a
            float r4 = androidx.core.widget.EdgeEffectCompat.getDistance(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mRightGlow
            int r5 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r8, r5)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r4 = r7.mRightGlow
            r4.onAbsorb(r8)
            goto L_0x0058
        L_0x007a:
            r4 = 0
        L_0x007b:
            if (r9 == 0) goto L_0x00bc
            android.widget.EdgeEffect r5 = r7.mTopGlow
            if (r5 == 0) goto L_0x009e
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            android.widget.EdgeEffect r3 = r7.mTopGlow
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r5, r6)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r9 = r7.mTopGlow
            r9.onAbsorb(r5)
        L_0x009b:
            r9 = 0
        L_0x009c:
            r3 = 0
            goto L_0x00be
        L_0x009e:
            android.widget.EdgeEffect r5 = r7.mBottomGlow
            if (r5 == 0) goto L_0x00bc
            float r5 = androidx.core.widget.EdgeEffectCompat.getDistance(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            int r5 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r9, r5)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            r3.onAbsorb(r9)
            goto L_0x009b
        L_0x00bc:
            r3 = r9
            r9 = 0
        L_0x00be:
            if (r4 != 0) goto L_0x00c2
            if (r9 == 0) goto L_0x00dd
        L_0x00c2:
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r5 = r7.mViewFlinger
            r5.fling(r4, r9)
        L_0x00dd:
            r5 = 1
            if (r8 != 0) goto L_0x00e9
            if (r3 != 0) goto L_0x00e9
            if (r4 != 0) goto L_0x00e8
            if (r9 == 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            return r1
        L_0x00e8:
            return r5
        L_0x00e9:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x012c
            if (r0 != 0) goto L_0x00f8
            if (r2 == 0) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            r6 = 0
            goto L_0x00f9
        L_0x00f8:
            r6 = 1
        L_0x00f9:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r9 = r7.mOnFlingListener
            if (r9 == 0) goto L_0x0107
            boolean r9 = r9.onFling(r8, r3)
            if (r9 == 0) goto L_0x0107
            return r5
        L_0x0107:
            if (r6 == 0) goto L_0x012c
            if (r2 == 0) goto L_0x010d
            r0 = r0 | 2
        L_0x010d:
            r7.startNestedScroll(r0, r5)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r0 = r7.mViewFlinger
            r0.fling(r8, r9)
            return r5
        L_0x012c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    public View focusSearch(View view, int i4) {
        boolean z4;
        View view2;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        int i6;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i4);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z8 = true;
        if (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) {
            z4 = false;
        } else {
            z4 = true;
        }
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i4 == 2 || i4 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i4);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                if (i4 == 2) {
                    i6 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                } else {
                    i6 = 33;
                }
                if (instance.findNextFocus(this, view, i6) == null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i6;
                }
            } else {
                z5 = false;
            }
            if (!z5 && this.mLayout.canScrollHorizontally()) {
                if (this.mLayout.getLayoutDirection() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i4 == 2) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z6 ^ z7) {
                    i5 = 66;
                } else {
                    i5 = 17;
                }
                if (instance.findNextFocus(this, view, i5) != null) {
                    z8 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i5;
                }
                z5 = z8;
            }
            if (z5) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i4);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (isPreferredNextFocus(view, view2, i4)) {
                return view2;
            }
            return super.focusSearch(view, i4);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i4);
        } else {
            requestChildOnScreen(view2, (View) null);
            return view;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return (long) viewHolder.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i4, int i5) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i4, i5);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i4, i5);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i4).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i5 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i5 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i4) {
        int itemDecorationCount = getItemDecorationCount();
        if (i4 >= 0 && i4 < itemDecorationCount) {
            return this.mItemDecorations.get(i4);
        }
        throw new IndexOutOfBoundsException(i4 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
            /* access modifiers changed from: package-private */
            public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                int i4 = updateOp.cmd;
                if (i4 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
                } else if (i4 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
                } else if (i4 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                } else if (i4 == 8) {
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
                }
            }

            public ViewHolder findViewHolder(int i4) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i4, true);
                if (findViewHolderForPosition == null) {
                    return null;
                }
                if (!RecyclerView.this.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "assuming view holder cannot be find because it is hidden");
                }
                return null;
            }

            public void markViewHoldersUpdated(int i4, int i5, Object obj) {
                RecyclerView.this.viewRangeUpdate(i4, i5, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            public void offsetPositionsForAdd(int i4, int i5) {
                RecyclerView.this.offsetPositionRecordsForInsert(i4, i5);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForMove(int i4, int i5) {
                RecyclerView.this.offsetPositionRecordsForMove(i4, i5);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void offsetPositionsForRemovingInvisible(int i4, int i5) {
                RecyclerView.this.offsetPositionRecordsForRemove(i4, i5, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i5;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int i4, int i5) {
                RecyclerView.this.offsetPositionRecordsForRemove(i4, i5, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator == null || !itemAnimator.isRunning()) {
            return false;
        }
        return true;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i4) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i4);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i4).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void nestedScrollBy(int i4, int i5) {
        nestedScrollByInternal(i4, i5, (MotionEvent) null, 1);
    }

    public void offsetChildrenHorizontal(@Px int i4) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            this.mChildHelper.getChildAt(i5).offsetLeftAndRight(i4);
        }
    }

    public void offsetChildrenVertical(@Px int i4) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            this.mChildHelper.getChildAt(i5).offsetTopAndBottom(i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i4, int i5) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i6));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i4) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert attached child " + i6 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition + i5));
                }
                childViewHolderInt.offsetPosition(i5, false);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i4, i5);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        if (i4 < i5) {
            i8 = -1;
            i7 = i4;
            i6 = i5;
        } else {
            i6 = i4;
            i7 = i5;
            i8 = 1;
        }
        for (int i10 = 0; i10 < unfilteredChildCount; i10++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i7 && i9 <= i6) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove attached child " + i10 + " holder " + childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i4) {
                    childViewHolderInt.offsetPosition(i5 - i4, false);
                } else {
                    childViewHolderInt.offsetPosition(i8, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i4, i5);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i4, int i5, boolean z4) {
        int i6 = i4 + i5;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i7 = 0; i7 < unfilteredChildCount; i7++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i7));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i8 = childViewHolderInt.mPosition;
                if (i8 >= i6) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i7 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition - i5));
                    }
                    childViewHolderInt.offsetPosition(-i5, z4);
                    this.mState.mStructureChanged = true;
                } else if (i8 >= i4) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i7 + " holder " + childViewHolderInt + " now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i4 - 1, -i5, z4);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i4, i5, z4);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 >= 30.0f) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0014
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.mRecycler
            r1.onAttachedToWindow()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.mLayout
            if (r1 == 0) goto L_0x0023
            r1.dispatchAttachedToWindow(r5)
        L_0x0023:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x0066
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.sGapWorker
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L_0x0061
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = androidx.core.view.ViewCompat.getDisplay(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L_0x0053
            if (r1 == 0) goto L_0x0053
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r1 = 1114636288(0x42700000, float:60.0)
        L_0x0055:
            androidx.recyclerview.widget.GapWorker r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.mFrameIntervalNs = r3
            r0.set(r2)
        L_0x0061:
            androidx.recyclerview.widget.GapWorker r0 = r5.mGapWorker
            r0.add(r5)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        this.mRecycler.onDetachedFromWindow();
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mItemDecorations.get(i4).onDraw(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f4;
        float f5;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.mLayout.canScrollVertically()) {
                    f5 = -motionEvent.getAxisValue(9);
                } else {
                    f5 = 0.0f;
                }
                if (this.mLayout.canScrollHorizontally()) {
                    f4 = motionEvent.getAxisValue(10);
                    if (!(f5 == 0.0f && f4 == 0.0f)) {
                        nestedScrollByInternal((int) (f4 * this.mScaledHorizontalScrollFactor), (int) (f5 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f5 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f4 = axisValue;
                        f5 = 0.0f;
                        nestedScrollByInternal((int) (f4 * this.mScaledHorizontalScrollFactor), (int) (f5 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
                f5 = 0.0f;
            }
            f4 = 0.0f;
            nestedScrollByInternal((int) (f4 * this.mScaledHorizontalScrollFactor), (int) (f5 * this.mScaledVerticalScrollFactor), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x4 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x5 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y5 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i4 = x5 - this.mInitialTouchX;
                int i5 = y5 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i4) <= this.mTouchSlop) {
                    z4 = false;
                } else {
                    this.mLastTouchX = x5;
                    z4 = true;
                }
                if (canScrollVertically && Math.abs(i5) > this.mTouchSlop) {
                    this.mLastTouchY = y5;
                    z4 = true;
                }
                if (z4) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x6 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x6;
            this.mInitialTouchX = x6;
            int y6 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y6;
            this.mInitialTouchY = y6;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i4, i5);
            return;
        }
        boolean z4 = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i4, i5);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z4 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z4;
            if (!z4 && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i4, i5);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i4, i5);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i4, i5);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i4, i5);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                State state = this.mState;
                if (state.mRunPredictiveAnimations) {
                    state.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.mItemCount = adapter.getItemCount();
            } else {
                this.mState.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i4, i5);
            stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
            return savedState;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            savedState.mLayoutState = layoutManager.onSaveInstanceState();
            return savedState;
        }
        savedState.mLayoutState = null;
        return savedState;
    }

    public void onScrollStateChanged(int i4) {
    }

    public void onScrolled(@Px int i4, @Px int i5) {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6 || i5 != i7) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r6 = r17
            boolean r1 = r0.mLayoutSuppressed
            r7 = 0
            if (r1 != 0) goto L_0x01e9
            boolean r1 = r0.mIgnoreMotionEventTillDown
            if (r1 == 0) goto L_0x000f
            goto L_0x01e9
        L_0x000f:
            boolean r1 = r16.dispatchToOnItemTouchListeners(r17)
            r8 = 1
            if (r1 == 0) goto L_0x001a
            r0.cancelScroll()
            return r8
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            if (r1 != 0) goto L_0x001f
            return r7
        L_0x001f:
            boolean r9 = r1.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r0.mLayout
            boolean r10 = r1.canScrollVertically()
            android.view.VelocityTracker r1 = r0.mVelocityTracker
            if (r1 != 0) goto L_0x0033
            android.view.VelocityTracker r1 = android.view.VelocityTracker.obtain()
            r0.mVelocityTracker = r1
        L_0x0033:
            int r1 = r6.getActionMasked()
            int r2 = r6.getActionIndex()
            if (r1 != 0) goto L_0x0043
            int[] r3 = r0.mNestedOffsets
            r3[r8] = r7
            r3[r7] = r7
        L_0x0043:
            android.view.MotionEvent r11 = android.view.MotionEvent.obtain(r6)
            int[] r3 = r0.mNestedOffsets
            r4 = r3[r7]
            float r4 = (float) r4
            r3 = r3[r8]
            float r3 = (float) r3
            r11.offsetLocation(r4, r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            if (r1 == 0) goto L_0x01bf
            if (r1 == r8) goto L_0x017e
            r4 = 2
            if (r1 == r4) goto L_0x008c
            r4 = 3
            if (r1 == r4) goto L_0x0087
            r4 = 5
            if (r1 == r4) goto L_0x006b
            r2 = 6
            if (r1 == r2) goto L_0x0066
            goto L_0x01e0
        L_0x0066:
            r16.onPointerUp(r17)
            goto L_0x01e0
        L_0x006b:
            int r1 = r6.getPointerId(r2)
            r0.mScrollPointerId = r1
            float r1 = r6.getX(r2)
            float r1 = r1 + r3
            int r1 = (int) r1
            r0.mLastTouchX = r1
            r0.mInitialTouchX = r1
            float r1 = r6.getY(r2)
            float r1 = r1 + r3
            int r1 = (int) r1
            r0.mLastTouchY = r1
            r0.mInitialTouchY = r1
            goto L_0x01e0
        L_0x0087:
            r0.cancelScroll()
            goto L_0x01e0
        L_0x008c:
            int r1 = r0.mScrollPointerId
            int r1 = r6.findPointerIndex(r1)
            if (r1 >= 0) goto L_0x00b2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error processing scroll; pointer index for id "
            r1.append(r2)
            int r2 = r0.mScrollPointerId
            r1.append(r2)
            java.lang.String r2 = " not found. Did any MotionEvents get skipped?"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RecyclerView"
            android.util.Log.e(r2, r1)
            return r7
        L_0x00b2:
            float r2 = r6.getX(r1)
            float r2 = r2 + r3
            int r12 = (int) r2
            float r1 = r6.getY(r1)
            float r1 = r1 + r3
            int r13 = (int) r1
            int r1 = r0.mLastTouchX
            int r1 = r1 - r12
            int r2 = r0.mLastTouchY
            int r2 = r2 - r13
            int r3 = r0.mScrollState
            if (r3 == r8) goto L_0x00fb
            if (r9 == 0) goto L_0x00df
            if (r1 <= 0) goto L_0x00d4
            int r3 = r0.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r7, r1)
            goto L_0x00db
        L_0x00d4:
            int r3 = r0.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r7, r1)
        L_0x00db:
            if (r1 == 0) goto L_0x00df
            r3 = 1
            goto L_0x00e0
        L_0x00df:
            r3 = 0
        L_0x00e0:
            if (r10 == 0) goto L_0x00f6
            if (r2 <= 0) goto L_0x00ec
            int r4 = r0.mTouchSlop
            int r2 = r2 - r4
            int r2 = java.lang.Math.max(r7, r2)
            goto L_0x00f3
        L_0x00ec:
            int r4 = r0.mTouchSlop
            int r2 = r2 + r4
            int r2 = java.lang.Math.min(r7, r2)
        L_0x00f3:
            if (r2 == 0) goto L_0x00f6
            r3 = 1
        L_0x00f6:
            if (r3 == 0) goto L_0x00fb
            r0.setScrollState(r8)
        L_0x00fb:
            int r3 = r0.mScrollState
            if (r3 != r8) goto L_0x01e0
            int[] r3 = r0.mReusableIntPair
            r3[r7] = r7
            r3[r8] = r7
            float r3 = r6.getY()
            int r3 = r0.releaseHorizontalGlow(r1, r3)
            int r14 = r1 - r3
            float r1 = r6.getX()
            int r1 = r0.releaseVerticalGlow(r2, r1)
            int r15 = r2 - r1
            if (r9 == 0) goto L_0x011d
            r1 = r14
            goto L_0x011e
        L_0x011d:
            r1 = 0
        L_0x011e:
            if (r10 == 0) goto L_0x0122
            r2 = r15
            goto L_0x0123
        L_0x0122:
            r2 = 0
        L_0x0123:
            int[] r3 = r0.mReusableIntPair
            int[] r4 = r0.mScrollOffset
            r5 = 0
            boolean r1 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L_0x014f
            int[] r1 = r0.mReusableIntPair
            r2 = r1[r7]
            int r14 = r14 - r2
            r1 = r1[r8]
            int r15 = r15 - r1
            int[] r1 = r0.mNestedOffsets
            r2 = r1[r7]
            int[] r3 = r0.mScrollOffset
            r4 = r3[r7]
            int r2 = r2 + r4
            r1[r7] = r2
            r2 = r1[r8]
            r3 = r3[r8]
            int r2 = r2 + r3
            r1[r8] = r2
            android.view.ViewParent r1 = r0.getParent()
            r1.requestDisallowInterceptTouchEvent(r8)
        L_0x014f:
            int[] r1 = r0.mScrollOffset
            r2 = r1[r7]
            int r12 = r12 - r2
            r0.mLastTouchX = r12
            r1 = r1[r8]
            int r13 = r13 - r1
            r0.mLastTouchY = r13
            if (r9 == 0) goto L_0x015f
            r1 = r14
            goto L_0x0160
        L_0x015f:
            r1 = 0
        L_0x0160:
            if (r10 == 0) goto L_0x0164
            r2 = r15
            goto L_0x0165
        L_0x0164:
            r2 = 0
        L_0x0165:
            boolean r1 = r0.scrollByInternal(r1, r2, r6, r7)
            if (r1 == 0) goto L_0x0172
            android.view.ViewParent r1 = r0.getParent()
            r1.requestDisallowInterceptTouchEvent(r8)
        L_0x0172:
            androidx.recyclerview.widget.GapWorker r1 = r0.mGapWorker
            if (r1 == 0) goto L_0x01e0
            if (r14 != 0) goto L_0x017a
            if (r15 == 0) goto L_0x01e0
        L_0x017a:
            r1.postFromTraversal(r0, r14, r15)
            goto L_0x01e0
        L_0x017e:
            android.view.VelocityTracker r1 = r0.mVelocityTracker
            r1.addMovement(r11)
            android.view.VelocityTracker r1 = r0.mVelocityTracker
            int r2 = r0.mMaxFlingVelocity
            float r2 = (float) r2
            r3 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r3, r2)
            r1 = 0
            if (r9 == 0) goto L_0x019a
            android.view.VelocityTracker r2 = r0.mVelocityTracker
            int r3 = r0.mScrollPointerId
            float r2 = r2.getXVelocity(r3)
            float r2 = -r2
            goto L_0x019b
        L_0x019a:
            r2 = 0
        L_0x019b:
            if (r10 == 0) goto L_0x01a7
            android.view.VelocityTracker r3 = r0.mVelocityTracker
            int r4 = r0.mScrollPointerId
            float r3 = r3.getYVelocity(r4)
            float r3 = -r3
            goto L_0x01a8
        L_0x01a7:
            r3 = 0
        L_0x01a8:
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x01b0
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x01b8
        L_0x01b0:
            int r1 = (int) r2
            int r2 = (int) r3
            boolean r1 = r0.fling(r1, r2)
            if (r1 != 0) goto L_0x01bb
        L_0x01b8:
            r0.setScrollState(r7)
        L_0x01bb:
            r0.resetScroll()
            goto L_0x01e5
        L_0x01bf:
            int r1 = r6.getPointerId(r7)
            r0.mScrollPointerId = r1
            float r1 = r6.getX()
            float r1 = r1 + r3
            int r1 = (int) r1
            r0.mLastTouchX = r1
            r0.mInitialTouchX = r1
            float r1 = r6.getY()
            float r1 = r1 + r3
            int r1 = (int) r1
            r0.mLastTouchY = r1
            r0.mInitialTouchY = r1
            if (r10 == 0) goto L_0x01dd
            r9 = r9 | 2
        L_0x01dd:
            r0.startNestedScroll(r9, r7)
        L_0x01e0:
            android.view.VelocityTracker r1 = r0.mVelocityTracker
            r1.addMovement(r11)
        L_0x01e5:
            r11.recycle()
            return r8
        L_0x01e9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z4) {
        this.mDispatchItemsChangedEvent = z4 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    /* access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean removeViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
        if (removeViewIfHidden) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "after removing animated view: " + view + ", " + this);
            }
        }
        stopInterceptRequestLayout(!removeViewIfHidden);
        return removeViewIfHidden;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z4) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        } else if (sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + exceptionLabel());
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z4);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        boolean z4;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            setWillNotDraw(z4);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i4) {
        int itemDecorationCount = getItemDecorationCount();
        if (i4 < 0 || i4 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i4 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i4));
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.mChildHelper.getChildAt(i4);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.mShadowingHolder) == null)) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z4);
    }

    public void requestDisallowInterceptTouchEvent(boolean z4) {
        int size = this.mOnItemTouchListeners.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mOnItemTouchListeners.get(i4).onRequestDisallowInterceptTouchEvent(z4);
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i4 = 0;
        while (i4 < unfilteredChildCount) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (!sDebugAssertionsEnabled || childViewHolderInt.mPosition != -1 || childViewHolderInt.isRemoved()) {
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.saveOldPosition();
                }
                i4++;
            } else {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
            }
        }
    }

    public void scrollBy(int i4, int i5) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i4 = 0;
                }
                if (!canScrollVertically) {
                    i5 = 0;
                }
                scrollByInternal(i4, i5, (MotionEvent) null, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i4, int i5, MotionEvent motionEvent, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z4;
        int i11 = i4;
        int i12 = i5;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i11, i12, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i13 = iArr2[0];
            int i14 = iArr2[1];
            i8 = i11 - i13;
            i7 = i12 - i14;
            int i15 = i13;
            i9 = i14;
            i10 = i15;
        } else {
            i10 = 0;
            i9 = 0;
            i8 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i10, i9, i8, i7, this.mScrollOffset, i6, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i16 = iArr4[0];
        int i17 = i8 - i16;
        int i18 = iArr4[1];
        int i19 = i7 - i18;
        if (i16 == 0 && i18 == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        int i20 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i21 = iArr5[0];
        this.mLastTouchX = i20 - i21;
        int i22 = this.mLastTouchY;
        int i23 = iArr5[1];
        this.mLastTouchY = i22 - i23;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i21;
        iArr6[1] = iArr6[1] + i23;
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !MotionEventCompat.isFromSource(motionEvent2, 8194)) {
                pullGlows(motionEvent2.getX(), (float) i17, motionEvent2.getY(), (float) i19);
            }
            considerReleasingGlowsOnScroll(i4, i5);
        }
        if (!(i10 == 0 && i9 == 0)) {
            dispatchOnScrolled(i10, i9);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z4 && i10 == 0 && i9 == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i4, int i5, @Nullable int[] iArr) {
        int i6;
        int i7;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i4 != 0) {
            i6 = this.mLayout.scrollHorizontallyBy(i4, this.mRecycler, this.mState);
        } else {
            i6 = 0;
        }
        if (i5 != 0) {
            i7 = this.mLayout.scrollVerticallyBy(i5, this.mRecycler, this.mState);
        } else {
            i7 = 0;
        }
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i7;
        }
    }

    public void scrollTo(int i4, int i5) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i4) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i4);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        boolean z4;
        if (childDrawingOrderCallback != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = childDrawingOrderCallback;
            if (childDrawingOrderCallback != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            setChildrenDrawingOrderEnabled(z4);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i4) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i4;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i4);
        return true;
    }

    public void setClipToPadding(boolean z4) {
        if (z4 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z4;
        super.setClipToPadding(z4);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z4) {
        this.mHasFixedSize = z4;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener((ItemAnimator.ItemAnimatorListener) null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i4) {
        this.mRecycler.setViewCacheSize(i4);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z4) {
        suppressLayout(z4);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.clear();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.clear();
            }
            this.mChildHelper.removeAllViewsUnfiltered();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    layoutManager.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.updateViewCacheSize();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z4) {
        getScrollingChildHelper().setNestedScrollingEnabled(z4);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.mPreserveFocusAfterLayout = z4;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i4) {
        if (i4 != this.mScrollState) {
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "setting scroll state to " + i4 + " from " + this.mScrollState, new Exception());
            }
            this.mScrollState = i4;
            if (i4 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i4);
        }
    }

    public void setScrollingTouchSlop(int i4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i4 != 0) {
            if (i4 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i4 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i4;
        int i5 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i4 = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            i5 = i4;
        }
        this.mEatenAccessibilityChangeFlags |= i5;
        return true;
    }

    public void smoothScrollBy(@Px int i4, @Px int i5) {
        smoothScrollBy(i4, i5, (Interpolator) null);
    }

    public void smoothScrollToPosition(int i4) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        int i4 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i4;
        if (i4 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().startNestedScroll(i4);
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z4) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (!sDebugAssertionsEnabled) {
                this.mInterceptRequestLayoutDepth = 1;
            } else {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
            }
        }
        if (!z4 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z4 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public final void suppressLayout(boolean z4) {
        if (z4 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z4) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z4) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z4);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i4, int i5, Object obj) {
        int i6;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i7 = i4 + i5;
        for (int i8 = 0; i8 < unfilteredChildCount; i8++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i8);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i6 = childViewHolderInt.mPosition) >= i4 && i6 < i7) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(i4, i5);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i4, i5, iArr, iArr2, i6);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return getScrollingChildHelper().dispatchNestedScroll(i4, i5, i6, i7, iArr, i8);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ViewHolder findViewHolderForPosition(int i4, boolean z4) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder viewHolder = null;
        for (int i5 = 0; i5 < unfilteredChildCount; i5++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i5));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z4) {
                    if (childViewHolderInt.mPosition != i4) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i4) {
                    continue;
                }
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public boolean hasNestedScrollingParent(int i4) {
        return getScrollingChildHelper().hasNestedScrollingParent(i4);
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z4) {
        int i4 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i4;
        if (i4 >= 1) {
            return;
        }
        if (!sDebugAssertionsEnabled || i4 >= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z4) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
                return;
            }
            return;
        }
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
    }

    public void smoothScrollBy(@Px int i4, @Px int i5, @Nullable Interpolator interpolator) {
        smoothScrollBy(i4, i5, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i4, int i5) {
        return getScrollingChildHelper().startNestedScroll(i4, i5);
    }

    public void stopNestedScroll(int i4) {
        getScrollingChildHelper().stopNestedScroll(i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        Parcelable mLayoutState;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.mIsAttached) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.mLayoutSuppressed) {
                        recyclerView2.mLayoutWasDefered = true;
                    } else {
                        recyclerView2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mDataSetHasChangedAfterLayout) {
                    if (recyclerView.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (recyclerView.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }

            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i4, 0);
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z4;
        if (z4) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i4, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i4, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr2, attributeSet, obtainStyledAttributes2, i4, 0);
        boolean z5 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z5);
        PoolingContainer.setPoolingContainer(this, true);
    }

    public final void dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    public void smoothScrollBy(@Px int i4, @Px int i5, @Nullable Interpolator interpolator, int i6) {
        smoothScrollBy(i4, i5, interpolator, i6, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets = new Rect();
        boolean mInsetsDirty = true;
        boolean mPendingInvalidate = false;
        ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(@Px int i4, @Px int i5, @Nullable Interpolator interpolator, int i6, boolean z4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i7 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i4 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i5 = 0;
            }
            if (i4 != 0 || i5 != 0) {
                if (i6 == Integer.MIN_VALUE || i6 > 0) {
                    if (z4) {
                        if (i4 != 0) {
                            i7 = 1;
                        }
                        if (i5 != 0) {
                            i7 |= 2;
                        }
                        startNestedScroll(i7, 1);
                    }
                    this.mViewFlinger.smoothScrollBy(i4, i5, i6, interpolator);
                    return;
                }
                scrollBy(i4, i5);
            }
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
