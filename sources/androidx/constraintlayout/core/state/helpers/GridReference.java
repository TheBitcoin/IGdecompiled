package androidx.constraintlayout.core.state.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.utils.GridCore;
import androidx.constraintlayout.core.widgets.HelperWidget;

public class GridReference extends HelperReference {
    private static final String SPANS_RESPECT_WIDGET_ORDER_STRING = "spansrespectwidgetorder";
    private static final String SUB_GRID_BY_COL_ROW_STRING = "subgridbycolrow";
    private String mColumnWeights;
    private int mColumnsSet;
    private int mFlags;
    private GridCore mGrid;
    private float mHorizontalGaps;
    private int mOrientation;
    private int mPaddingBottom = 0;
    private int mPaddingEnd = 0;
    private int mPaddingStart = 0;
    private int mPaddingTop = 0;
    private String mRowWeights;
    private int mRowsSet;
    private String mSkips;
    private String mSpans;
    private float mVerticalGaps;

    public GridReference(@NonNull State state, @NonNull State.Helper helper) {
        super(state, helper);
        if (helper == State.Helper.ROW) {
            this.mRowsSet = 1;
        } else if (helper == State.Helper.COLUMN) {
            this.mColumnsSet = 1;
        }
    }

    public void apply() {
        getHelperWidget();
        this.mGrid.setOrientation(this.mOrientation);
        int i4 = this.mRowsSet;
        if (i4 != 0) {
            this.mGrid.setRows(i4);
        }
        int i5 = this.mColumnsSet;
        if (i5 != 0) {
            this.mGrid.setColumns(i5);
        }
        float f4 = this.mHorizontalGaps;
        if (f4 != 0.0f) {
            this.mGrid.setHorizontalGaps(f4);
        }
        float f5 = this.mVerticalGaps;
        if (f5 != 0.0f) {
            this.mGrid.setVerticalGaps(f5);
        }
        String str = this.mRowWeights;
        if (str != null && !str.isEmpty()) {
            this.mGrid.setRowWeights(this.mRowWeights);
        }
        String str2 = this.mColumnWeights;
        if (str2 != null && !str2.isEmpty()) {
            this.mGrid.setColumnWeights(this.mColumnWeights);
        }
        String str3 = this.mSpans;
        if (str3 != null && !str3.isEmpty()) {
            this.mGrid.setSpans(this.mSpans);
        }
        String str4 = this.mSkips;
        if (str4 != null && !str4.isEmpty()) {
            this.mGrid.setSkips(this.mSkips);
        }
        this.mGrid.setFlags(this.mFlags);
        this.mGrid.setPaddingStart(this.mPaddingStart);
        this.mGrid.setPaddingEnd(this.mPaddingEnd);
        this.mGrid.setPaddingTop(this.mPaddingTop);
        this.mGrid.setPaddingBottom(this.mPaddingBottom);
        applyBase();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    public int getColumnsSet() {
        return this.mColumnsSet;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @NonNull
    public HelperWidget getHelperWidget() {
        if (this.mGrid == null) {
            this.mGrid = new GridCore();
        }
        return this.mGrid;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingEnd() {
        return this.mPaddingEnd;
    }

    public int getPaddingStart() {
        return this.mPaddingStart;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public int getRowsSet() {
        return this.mRowsSet;
    }

    @Nullable
    public String getSkips() {
        return this.mSkips;
    }

    @Nullable
    public String getSpans() {
        return this.mSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void setColumnWeights(@NonNull String str) {
        this.mColumnWeights = str;
    }

    public void setColumnsSet(int i4) {
        if (super.getType() != State.Helper.ROW) {
            this.mColumnsSet = i4;
        }
    }

    public void setFlags(int i4) {
        this.mFlags = i4;
    }

    public void setHelperWidget(@Nullable HelperWidget helperWidget) {
        if (helperWidget instanceof GridCore) {
            this.mGrid = (GridCore) helperWidget;
        } else {
            this.mGrid = null;
        }
    }

    public void setHorizontalGaps(float f4) {
        this.mHorizontalGaps = f4;
    }

    public void setOrientation(int i4) {
        this.mOrientation = i4;
    }

    public void setPaddingBottom(int i4) {
        this.mPaddingBottom = i4;
    }

    public void setPaddingEnd(int i4) {
        this.mPaddingEnd = i4;
    }

    public void setPaddingStart(int i4) {
        this.mPaddingStart = i4;
    }

    public void setPaddingTop(int i4) {
        this.mPaddingTop = i4;
    }

    public void setRowWeights(@NonNull String str) {
        this.mRowWeights = str;
    }

    public void setRowsSet(int i4) {
        if (super.getType() != State.Helper.COLUMN) {
            this.mRowsSet = i4;
        }
    }

    public void setSkips(@NonNull String str) {
        this.mSkips = str;
    }

    public void setSpans(@NonNull String str) {
        this.mSpans = str;
    }

    public void setVerticalGaps(float f4) {
        this.mVerticalGaps = f4;
    }

    public void setFlags(@NonNull String str) {
        if (!str.isEmpty()) {
            String[] split = str.split("\\|");
            this.mFlags = 0;
            for (String lowerCase : split) {
                String lowerCase2 = lowerCase.toLowerCase();
                lowerCase2.getClass();
                if (lowerCase2.equals(SUB_GRID_BY_COL_ROW_STRING)) {
                    this.mFlags |= 1;
                } else if (lowerCase2.equals(SPANS_RESPECT_WIDGET_ORDER_STRING)) {
                    this.mFlags |= 2;
                }
            }
        }
    }
}
