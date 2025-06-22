package androidx.leanback.widget;

public final class ItemAlignmentFacet {
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private ItemAlignmentDef[] mAlignmentDefs = {new ItemAlignmentDef()};

    public static class ItemAlignmentDef {
        private boolean mAlignToBaseline;
        int mFocusViewId = -1;
        int mOffset = 0;
        float mOffsetPercent = 50.0f;
        boolean mOffsetWithPadding = false;
        int mViewId = -1;

        public final int getItemAlignmentFocusViewId() {
            int i4 = this.mFocusViewId;
            if (i4 != -1) {
                return i4;
            }
            return this.mViewId;
        }

        public final int getItemAlignmentOffset() {
            return this.mOffset;
        }

        public final float getItemAlignmentOffsetPercent() {
            return this.mOffsetPercent;
        }

        public final int getItemAlignmentViewId() {
            return this.mViewId;
        }

        public boolean isAlignedToTextViewBaseLine() {
            return this.mAlignToBaseline;
        }

        public final boolean isItemAlignmentOffsetWithPadding() {
            return this.mOffsetWithPadding;
        }

        public final void setAlignedToTextViewBaseline(boolean z4) {
            this.mAlignToBaseline = z4;
        }

        public final void setItemAlignmentFocusViewId(int i4) {
            this.mFocusViewId = i4;
        }

        public final void setItemAlignmentOffset(int i4) {
            this.mOffset = i4;
        }

        public final void setItemAlignmentOffsetPercent(float f4) {
            if ((f4 < 0.0f || f4 > 100.0f) && f4 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.mOffsetPercent = f4;
        }

        public final void setItemAlignmentOffsetWithPadding(boolean z4) {
            this.mOffsetWithPadding = z4;
        }

        public final void setItemAlignmentViewId(int i4) {
            this.mViewId = i4;
        }
    }

    public ItemAlignmentDef[] getAlignmentDefs() {
        return this.mAlignmentDefs;
    }

    public boolean isMultiAlignment() {
        if (this.mAlignmentDefs.length > 1) {
            return true;
        }
        return false;
    }

    public void setAlignmentDefs(ItemAlignmentDef[] itemAlignmentDefArr) {
        if (itemAlignmentDefArr == null || itemAlignmentDefArr.length < 1) {
            throw new IllegalArgumentException();
        }
        this.mAlignmentDefs = itemAlignmentDefArr;
    }
}
