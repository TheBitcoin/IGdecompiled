package androidx.leanback.widget;

import android.graphics.drawable.Drawable;

public interface MultiActionsProvider {

    public static class MultiAction {
        private Drawable[] mDrawables;
        private long mId;
        private int mIndex = 0;

        public MultiAction(long j4) {
            this.mId = j4;
        }

        public Drawable getCurrentDrawable() {
            return this.mDrawables[this.mIndex];
        }

        public Drawable[] getDrawables() {
            return this.mDrawables;
        }

        public long getId() {
            return this.mId;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void incrementIndex() {
            int i4;
            int i5 = this.mIndex;
            if (i5 < this.mDrawables.length - 1) {
                i4 = i5 + 1;
            } else {
                i4 = 0;
            }
            setIndex(i4);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.mDrawables = drawableArr;
            if (this.mIndex > drawableArr.length - 1) {
                this.mIndex = drawableArr.length - 1;
            }
        }

        public void setIndex(int i4) {
            this.mIndex = i4;
        }
    }

    MultiAction[] getActions();
}
