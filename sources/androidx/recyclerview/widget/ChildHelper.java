package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket;
    final Callback mCallback;
    final List<View> mHiddenViews;
    private int mRemoveStatus = 0;
    private View mViewInRemoveView;

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(int i4) {
            if (i4 >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i4 - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i4);
        }

        /* access modifiers changed from: package-private */
        public int countOnesBefore(int i4) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i4 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i4) - 1));
            } else if (i4 < 64) {
                return Long.bitCount(this.mData & ((1 << i4) - 1));
            } else {
                return bucket.countOnesBefore(i4 - 64) + Long.bitCount(this.mData);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean get(int i4) {
            if (i4 >= 64) {
                ensureNext();
                return this.mNext.get(i4 - 64);
            } else if ((this.mData & (1 << i4)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void insert(int i4, boolean z4) {
            boolean z5;
            if (i4 >= 64) {
                ensureNext();
                this.mNext.insert(i4 - 64, z4);
                return;
            }
            long j4 = this.mData;
            if ((Long.MIN_VALUE & j4) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            long j5 = (1 << i4) - 1;
            this.mData = ((j4 & (~j5)) << 1) | (j4 & j5);
            if (z4) {
                set(i4);
            } else {
                clear(i4);
            }
            if (z5 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z5);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean remove(int i4) {
            boolean z4;
            if (i4 >= 64) {
                ensureNext();
                return this.mNext.remove(i4 - 64);
            }
            long j4 = 1 << i4;
            long j5 = this.mData;
            if ((j5 & j4) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            long j6 = j5 & (~j4);
            this.mData = j6;
            long j7 = j4 - 1;
            this.mData = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z4;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mData = 0;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        /* access modifiers changed from: package-private */
        public void set(int i4) {
            if (i4 >= 64) {
                ensureNext();
                this.mNext.set(i4 - 64);
                return;
            }
            this.mData |= 1 << i4;
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    interface Callback {
        void addView(View view, int i4);

        void attachViewToParent(View view, int i4, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i4);

        View getChildAt(int i4);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i4);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int i4) {
        if (i4 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i5 = i4;
        while (i5 < childCount) {
            int countOnesBefore = i4 - (i5 - this.mBucket.countOnesBefore(i5));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += countOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addView(View view, boolean z4) {
        addView(view, -1, z4);
    }

    /* access modifiers changed from: package-private */
    public void attachViewToParent(View view, int i4, ViewGroup.LayoutParams layoutParams, boolean z4) {
        int i5;
        if (i4 < 0) {
            i5 = this.mCallback.getChildCount();
        } else {
            i5 = getOffset(i4);
        }
        this.mBucket.insert(i5, z4);
        if (z4) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, i5, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void detachViewFromParent(int i4) {
        int offset = getOffset(i4);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    /* access modifiers changed from: package-private */
    public View findHiddenNonRemovedView(int i4) {
        int size = this.mHiddenViews.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mHiddenViews.get(i5);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i4 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View getChildAt(int i4) {
        return this.mCallback.getChildAt(getOffset(i4));
    }

    /* access modifiers changed from: package-private */
    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    /* access modifiers changed from: package-private */
    public View getUnfilteredChildAt(int i4) {
        return this.mCallback.getChildAt(i4);
    }

    /* access modifiers changed from: package-private */
    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public void hide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.mBucket.set(indexOfChild);
            hideViewInternal(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int indexOfChild(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild != -1 && !this.mBucket.get(indexOfChild)) {
            return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    /* access modifiers changed from: package-private */
    public void removeView(View view) {
        int i4 = this.mRemoveStatus;
        if (i4 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i4 != 2) {
            try {
                this.mRemoveStatus = 1;
                this.mViewInRemoveView = view;
                int indexOfChild = this.mCallback.indexOfChild(view);
                if (indexOfChild >= 0) {
                    if (this.mBucket.remove(indexOfChild)) {
                        unhideViewInternal(view);
                    }
                    this.mCallback.removeViewAt(indexOfChild);
                }
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* access modifiers changed from: package-private */
    public void removeViewAt(int i4) {
        int i5 = this.mRemoveStatus;
        if (i5 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i5 != 2) {
            try {
                int offset = getOffset(i4);
                View childAt = this.mCallback.getChildAt(offset);
                if (childAt != null) {
                    this.mRemoveStatus = 1;
                    this.mViewInRemoveView = childAt;
                    if (this.mBucket.remove(offset)) {
                        unhideViewInternal(childAt);
                    }
                    this.mCallback.removeViewAt(offset);
                }
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                this.mViewInRemoveView = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean removeViewIfHidden(View view) {
        int i4 = this.mRemoveStatus;
        if (i4 == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        } else if (i4 != 2) {
            try {
                this.mRemoveStatus = 2;
                int indexOfChild = this.mCallback.indexOfChild(view);
                if (indexOfChild == -1) {
                    unhideViewInternal(view);
                    this.mRemoveStatus = 0;
                    return true;
                } else if (this.mBucket.get(indexOfChild)) {
                    this.mBucket.remove(indexOfChild);
                    unhideViewInternal(view);
                    this.mCallback.removeViewAt(indexOfChild);
                    this.mRemoveStatus = 0;
                    return true;
                } else {
                    this.mRemoveStatus = 0;
                    return false;
                }
            } catch (Throwable th) {
                this.mRemoveStatus = 0;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    /* access modifiers changed from: package-private */
    public void unhide(View view) {
        int indexOfChild = this.mCallback.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.mBucket.get(indexOfChild)) {
            this.mBucket.clear(indexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    public void addView(View view, int i4, boolean z4) {
        int i5;
        if (i4 < 0) {
            i5 = this.mCallback.getChildCount();
        } else {
            i5 = getOffset(i4);
        }
        this.mBucket.insert(i5, z4);
        if (z4) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, i5);
    }
}
