package androidx.leanback.widget;

import android.database.Observable;
import androidx.annotation.RestrictTo;

public abstract class ObjectAdapter {
    public static final int NO_ID = -1;
    private boolean mHasStableIds;
    private final DataObservable mObservable = new DataObservable();
    private PresenterSelector mPresenterSelector;

    public static abstract class DataObserver {
        public void onChanged() {
        }

        public void onItemMoved(int i4, int i5) {
            onChanged();
        }

        public void onItemRangeChanged(int i4, int i5) {
            onChanged();
        }

        public void onItemRangeInserted(int i4, int i5) {
            onChanged();
        }

        public void onItemRangeRemoved(int i4, int i5) {
            onChanged();
        }

        public void onItemRangeChanged(int i4, int i5, Object obj) {
            onChanged();
        }
    }

    public ObjectAdapter(PresenterSelector presenterSelector) {
        setPresenterSelector(presenterSelector);
    }

    public abstract Object get(int i4);

    public long getId(int i4) {
        return -1;
    }

    public final Presenter getPresenter(Object obj) {
        PresenterSelector presenterSelector = this.mPresenterSelector;
        if (presenterSelector != null) {
            return presenterSelector.getPresenter(obj);
        }
        throw new IllegalStateException("Presenter selector must not be null");
    }

    public final PresenterSelector getPresenterSelector() {
        return this.mPresenterSelector;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasObserver() {
        return this.mObservable.hasObserver();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public boolean isImmediateNotifySupported() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void notifyChanged() {
        this.mObservable.notifyChanged();
    }

    /* access modifiers changed from: protected */
    public final void notifyItemMoved(int i4, int i5) {
        this.mObservable.notifyItemMoved(i4, i5);
    }

    public final void notifyItemRangeChanged(int i4, int i5) {
        this.mObservable.notifyItemRangeChanged(i4, i5);
    }

    /* access modifiers changed from: protected */
    public final void notifyItemRangeInserted(int i4, int i5) {
        this.mObservable.notifyItemRangeInserted(i4, i5);
    }

    /* access modifiers changed from: protected */
    public final void notifyItemRangeRemoved(int i4, int i5) {
        this.mObservable.notifyItemRangeRemoved(i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onHasStableIdsChanged() {
    }

    /* access modifiers changed from: protected */
    public void onPresenterSelectorChanged() {
    }

    public final void registerObserver(DataObserver dataObserver) {
        this.mObservable.registerObserver(dataObserver);
    }

    public final void setHasStableIds(boolean z4) {
        boolean z5;
        if (this.mHasStableIds != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mHasStableIds = z4;
        if (z5) {
            onHasStableIdsChanged();
        }
    }

    public final void setPresenterSelector(PresenterSelector presenterSelector) {
        boolean z4;
        if (presenterSelector != null) {
            PresenterSelector presenterSelector2 = this.mPresenterSelector;
            boolean z5 = false;
            if (presenterSelector2 != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 && presenterSelector2 != presenterSelector) {
                z5 = true;
            }
            this.mPresenterSelector = presenterSelector;
            if (z5) {
                onPresenterSelectorChanged();
            }
            if (z4) {
                notifyChanged();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Presenter selector must not be null");
    }

    public abstract int size();

    public final void unregisterAllObservers() {
        this.mObservable.unregisterAll();
    }

    public final void unregisterObserver(DataObserver dataObserver) {
        this.mObservable.unregisterObserver(dataObserver);
    }

    private static final class DataObservable extends Observable<DataObserver> {
        DataObservable() {
        }

        /* access modifiers changed from: package-private */
        public boolean hasObserver() {
            if (this.mObservers.size() > 0) {
                return true;
            }
            return false;
        }

        public void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onItemMoved(i4, i5);
            }
        }

        public void notifyItemRangeChanged(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onItemRangeChanged(i4, i5);
            }
        }

        public void notifyItemRangeInserted(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onItemRangeInserted(i4, i5);
            }
        }

        public void notifyItemRangeRemoved(int i4, int i5) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onItemRangeRemoved(i4, i5);
            }
        }

        public void notifyItemRangeChanged(int i4, int i5, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onItemRangeChanged(i4, i5, obj);
            }
        }
    }

    public final void notifyItemRangeChanged(int i4, int i5, Object obj) {
        this.mObservable.notifyItemRangeChanged(i4, i5, obj);
    }

    public ObjectAdapter(Presenter presenter) {
        setPresenterSelector(new SinglePresenterSelector(presenter));
    }

    public ObjectAdapter() {
    }
}
