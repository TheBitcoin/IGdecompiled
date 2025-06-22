package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags = new BoundFlags();
    final Callback mCallback;

    static class BoundFlags {
        int mBoundFlags = 0;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        BoundFlags() {
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i4) {
            this.mBoundFlags = i4 | this.mBoundFlags;
        }

        /* access modifiers changed from: package-private */
        public boolean boundsMatch() {
            int i4 = this.mBoundFlags;
            if ((i4 & 7) != 0 && (i4 & compare(this.mChildStart, this.mRvStart)) == 0) {
                return false;
            }
            int i5 = this.mBoundFlags;
            if ((i5 & 112) != 0 && (i5 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            int i6 = this.mBoundFlags;
            if ((i6 & 1792) != 0 && (i6 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            int i7 = this.mBoundFlags;
            if ((i7 & 28672) == 0 || (i7 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int compare(int i4, int i5) {
            if (i4 > i5) {
                return 1;
            }
            return i4 == i5 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        /* access modifiers changed from: package-private */
        public void setBounds(int i4, int i5, int i6, int i7) {
            this.mRvStart = i4;
            this.mRvEnd = i5;
            this.mChildStart = i6;
            this.mChildEnd = i7;
        }
    }

    interface Callback {
        View getChildAt(int i4);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    /* access modifiers changed from: package-private */
    public View findOneViewWithinBoundFlags(int i4, int i5, int i6, int i7) {
        int i8;
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        if (i5 > i4) {
            i8 = 1;
        } else {
            i8 = -1;
        }
        View view = null;
        while (i4 != i5) {
            View childAt = this.mCallback.getChildAt(i4);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i6 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i6);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i7 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i7);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i4 += i8;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean isViewWithinBoundFlags(View view, int i4) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i4 == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(i4);
        return this.mBoundFlags.boundsMatch();
    }
}
