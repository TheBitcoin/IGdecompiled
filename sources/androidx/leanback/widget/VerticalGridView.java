package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.leanback.R;

public class VerticalGridView extends BaseGridView {
    public VerticalGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void initAttributes(Context context, AttributeSet attributeSet) {
        initBaseGridViewAttributes(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbVerticalGridView);
        setColumnWidth(obtainStyledAttributes);
        setNumColumns(obtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public void setColumnWidth(TypedArray typedArray) {
        int i4 = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i4) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i4, 0));
        }
    }

    public void setNumColumns(int i4) {
        this.mLayoutManager.setNumRows(i4);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mLayoutManager.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    public void setColumnWidth(int i4) {
        this.mLayoutManager.setRowHeight(i4);
        requestLayout();
    }
}
