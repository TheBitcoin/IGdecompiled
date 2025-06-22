package androidx.leanback.widget.picker;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.R;
import androidx.leanback.widget.OnChildViewHolderSelectedListener;
import androidx.leanback.widget.VerticalGridView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Picker extends FrameLayout {
    private Interpolator mAccelerateInterpolator;
    private int mAlphaAnimDuration;
    private final OnChildViewHolderSelectedListener mColumnChangeListener = new OnChildViewHolderSelectedListener() {
        public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
            PickerScrollArrayAdapter pickerScrollArrayAdapter = (PickerScrollArrayAdapter) recyclerView.getAdapter();
            int indexOf = Picker.this.mColumnViews.indexOf(recyclerView);
            Picker.this.updateColumnAlpha(indexOf, true);
            if (viewHolder != null) {
                Picker.this.onColumnValueChanged(indexOf, Picker.this.mColumns.get(indexOf).getMinValue() + i4);
            }
        }
    };
    final List<VerticalGridView> mColumnViews = new ArrayList();
    ArrayList<PickerColumn> mColumns;
    private Interpolator mDecelerateInterpolator;
    private float mFocusedAlpha;
    private float mInvisibleColumnAlpha;
    private ArrayList<PickerValueListener> mListeners;
    private int mPickerItemLayoutId = R.layout.lb_picker_item;
    private int mPickerItemTextViewId = 0;
    private ViewGroup mPickerView;
    private ViewGroup mRootView;
    private int mSelectedColumn = 0;
    private List<CharSequence> mSeparators = new ArrayList();
    private float mUnfocusedAlpha;
    private float mVisibleColumnAlpha;
    private float mVisibleItems = 1.0f;
    private float mVisibleItemsActivated = 3.0f;

    class PickerScrollArrayAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final int mColIndex;
        private PickerColumn mData;
        private final int mResource;
        private final int mTextViewResourceId;

        PickerScrollArrayAdapter(Context context, int i4, int i5, int i6) {
            this.mResource = i4;
            this.mColIndex = i6;
            this.mTextViewResourceId = i5;
            this.mData = Picker.this.mColumns.get(i6);
        }

        public int getItemCount() {
            PickerColumn pickerColumn = this.mData;
            if (pickerColumn == null) {
                return 0;
            }
            return pickerColumn.getCount();
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i4) {
            PickerColumn pickerColumn;
            TextView textView = viewHolder.textView;
            if (!(textView == null || (pickerColumn = this.mData) == null)) {
                textView.setText(pickerColumn.getLabelFor(pickerColumn.getMinValue() + i4));
            }
            Picker picker = Picker.this;
            picker.setOrAnimateAlpha(viewHolder.itemView, picker.mColumnViews.get(this.mColIndex).getSelectedPosition() == i4, this.mColIndex, false);
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
            TextView textView;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.mResource, viewGroup, false);
            int i5 = this.mTextViewResourceId;
            if (i5 != 0) {
                textView = (TextView) inflate.findViewById(i5);
            } else {
                textView = (TextView) inflate;
            }
            return new ViewHolder(inflate, textView);
        }

        public void onViewAttachedToWindow(ViewHolder viewHolder) {
            viewHolder.itemView.setFocusable(Picker.this.isActivated());
        }
    }

    public interface PickerValueListener {
        void onValueChanged(Picker picker, int i4);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(View view, TextView textView2) {
            super(view);
            this.textView = textView2;
        }
    }

    public Picker(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        setEnabled(true);
        setDescendantFocusability(262144);
        this.mFocusedAlpha = 1.0f;
        this.mUnfocusedAlpha = 1.0f;
        this.mVisibleColumnAlpha = 0.5f;
        this.mInvisibleColumnAlpha = 0.0f;
        this.mAlphaAnimDuration = 200;
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.5f);
        this.mAccelerateInterpolator = new AccelerateInterpolator(2.5f);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, this, true);
        this.mRootView = viewGroup;
        this.mPickerView = (ViewGroup) viewGroup.findViewById(R.id.picker);
    }

    private float getFloat(int i4) {
        TypedValue typedValue = new TypedValue();
        getContext().getResources().getValue(i4, typedValue, true);
        return typedValue.getFloat();
    }

    private void notifyValueChanged(int i4) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onValueChanged(this, i4);
            }
        }
    }

    private void updateColumnSize() {
        for (int i4 = 0; i4 < getColumnsCount(); i4++) {
            updateColumnSize(this.mColumnViews.get(i4));
        }
    }

    private void updateItemFocusable() {
        boolean isActivated = isActivated();
        for (int i4 = 0; i4 < getColumnsCount(); i4++) {
            VerticalGridView verticalGridView = this.mColumnViews.get(i4);
            for (int i5 = 0; i5 < verticalGridView.getChildCount(); i5++) {
                verticalGridView.getChildAt(i5).setFocusable(isActivated);
            }
        }
    }

    public void addOnValueChangedListener(PickerValueListener pickerValueListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(pickerValueListener);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public float getActivatedVisibleItemCount() {
        return this.mVisibleItemsActivated;
    }

    public PickerColumn getColumnAt(int i4) {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i4);
    }

    public int getColumnsCount() {
        ArrayList<PickerColumn> arrayList = this.mColumns;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* access modifiers changed from: protected */
    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    public final int getPickerItemLayoutId() {
        return this.mPickerItemLayoutId;
    }

    public final int getPickerItemTextViewId() {
        return this.mPickerItemTextViewId;
    }

    public int getSelectedColumn() {
        return this.mSelectedColumn;
    }

    public final CharSequence getSeparator() {
        return this.mSeparators.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.mSeparators;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    public void onColumnValueChanged(int i4, int i5) {
        PickerColumn pickerColumn = this.mColumns.get(i4);
        if (pickerColumn.getCurrentValue() != i5) {
            pickerColumn.setCurrentValue(i5);
            notifyValueChanged(i4);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        int selectedColumn = getSelectedColumn();
        if (selectedColumn < this.mColumnViews.size()) {
            return this.mColumnViews.get(selectedColumn).requestFocus(i4, rect);
        }
        return false;
    }

    public void removeOnValueChangedListener(PickerValueListener pickerValueListener) {
        ArrayList<PickerValueListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(pickerValueListener);
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        for (int i4 = 0; i4 < this.mColumnViews.size(); i4++) {
            if (this.mColumnViews.get(i4).hasFocus()) {
                setSelectedColumn(i4);
            }
        }
    }

    public void setActivated(boolean z4) {
        if (z4 == isActivated()) {
            super.setActivated(z4);
            return;
        }
        super.setActivated(z4);
        boolean hasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z4 && hasFocus && isFocusable()) {
            requestFocus();
        }
        for (int i4 = 0; i4 < getColumnsCount(); i4++) {
            this.mColumnViews.get(i4).setFocusable(z4);
        }
        updateColumnSize();
        updateItemFocusable();
        if (z4 && hasFocus && selectedColumn >= 0) {
            this.mColumnViews.get(selectedColumn).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException();
        } else if (this.mVisibleItemsActivated != f4) {
            this.mVisibleItemsActivated = f4;
            if (isActivated()) {
                updateColumnSize();
            }
        }
    }

    public void setColumnAt(int i4, PickerColumn pickerColumn) {
        this.mColumns.set(i4, pickerColumn);
        VerticalGridView verticalGridView = this.mColumnViews.get(i4);
        PickerScrollArrayAdapter pickerScrollArrayAdapter = (PickerScrollArrayAdapter) verticalGridView.getAdapter();
        if (pickerScrollArrayAdapter != null) {
            pickerScrollArrayAdapter.notifyDataSetChanged();
        }
        verticalGridView.setSelectedPosition(pickerColumn.getCurrentValue() - pickerColumn.getMinValue());
    }

    public void setColumnValue(int i4, int i5, boolean z4) {
        PickerColumn pickerColumn = this.mColumns.get(i4);
        if (pickerColumn.getCurrentValue() != i5) {
            pickerColumn.setCurrentValue(i5);
            notifyValueChanged(i4);
            VerticalGridView verticalGridView = this.mColumnViews.get(i4);
            if (verticalGridView != null) {
                int minValue = i5 - this.mColumns.get(i4).getMinValue();
                if (z4) {
                    verticalGridView.setSelectedPositionSmooth(minValue);
                } else {
                    verticalGridView.setSelectedPosition(minValue);
                }
            }
        }
    }

    public void setColumns(List<PickerColumn> list) {
        if (this.mSeparators.size() != 0) {
            if (this.mSeparators.size() == 1) {
                CharSequence charSequence = this.mSeparators.get(0);
                this.mSeparators.clear();
                this.mSeparators.add("");
                for (int i4 = 0; i4 < list.size() - 1; i4++) {
                    this.mSeparators.add(charSequence);
                }
                this.mSeparators.add("");
            } else if (this.mSeparators.size() != list.size() + 1) {
                throw new IllegalStateException("Separators size: " + this.mSeparators.size() + " must" + "equal the size of columns: " + list.size() + " + 1");
            }
            this.mColumnViews.clear();
            this.mPickerView.removeAllViews();
            ArrayList<PickerColumn> arrayList = new ArrayList<>(list);
            this.mColumns = arrayList;
            if (this.mSelectedColumn > arrayList.size() - 1) {
                this.mSelectedColumn = this.mColumns.size() - 1;
            }
            LayoutInflater from = LayoutInflater.from(getContext());
            int columnsCount = getColumnsCount();
            if (!TextUtils.isEmpty(this.mSeparators.get(0))) {
                TextView textView = (TextView) from.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
                textView.setText(this.mSeparators.get(0));
                this.mPickerView.addView(textView);
            }
            int i5 = 0;
            while (i5 < columnsCount) {
                VerticalGridView verticalGridView = (VerticalGridView) from.inflate(R.layout.lb_picker_column, this.mPickerView, false);
                updateColumnSize(verticalGridView);
                verticalGridView.setWindowAlignment(0);
                verticalGridView.setHasFixedSize(false);
                verticalGridView.setFocusable(isActivated());
                verticalGridView.setItemViewCacheSize(0);
                this.mColumnViews.add(verticalGridView);
                this.mPickerView.addView(verticalGridView);
                int i6 = i5 + 1;
                if (!TextUtils.isEmpty(this.mSeparators.get(i6))) {
                    TextView textView2 = (TextView) from.inflate(R.layout.lb_picker_separator, this.mPickerView, false);
                    textView2.setText(this.mSeparators.get(i6));
                    this.mPickerView.addView(textView2);
                }
                verticalGridView.setAdapter(new PickerScrollArrayAdapter(getContext(), getPickerItemLayoutId(), getPickerItemTextViewId(), i5));
                verticalGridView.setOnChildViewHolderSelectedListener(this.mColumnChangeListener);
                i5 = i6;
            }
            return;
        }
        throw new IllegalStateException("Separators size is: " + this.mSeparators.size() + ". At least one separator must be provided");
    }

    /* access modifiers changed from: package-private */
    public void setOrAnimateAlpha(View view, boolean z4, int i4, boolean z5) {
        boolean z6 = i4 == this.mSelectedColumn || !hasFocus();
        if (z4) {
            if (z6) {
                setOrAnimateAlpha(view, z5, this.mFocusedAlpha, -1.0f, this.mDecelerateInterpolator);
            } else {
                setOrAnimateAlpha(view, z5, this.mUnfocusedAlpha, -1.0f, this.mDecelerateInterpolator);
            }
        } else if (z6) {
            setOrAnimateAlpha(view, z5, this.mVisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        } else {
            setOrAnimateAlpha(view, z5, this.mInvisibleColumnAlpha, -1.0f, this.mDecelerateInterpolator);
        }
    }

    public final void setPickerItemTextViewId(int i4) {
        this.mPickerItemTextViewId = i4;
    }

    public void setSelectedColumn(int i4) {
        if (this.mSelectedColumn != i4) {
            this.mSelectedColumn = i4;
            for (int i5 = 0; i5 < this.mColumnViews.size(); i5++) {
                updateColumnAlpha(i5, true);
            }
        }
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(new CharSequence[]{charSequence}));
    }

    public final void setSeparators(List<CharSequence> list) {
        this.mSeparators.clear();
        this.mSeparators.addAll(list);
    }

    public void setVisibleItemCount(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException();
        } else if (this.mVisibleItems != f4) {
            this.mVisibleItems = f4;
            if (!isActivated()) {
                updateColumnSize();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateColumnAlpha(int i4, boolean z4) {
        boolean z5;
        VerticalGridView verticalGridView = this.mColumnViews.get(i4);
        int selectedPosition = verticalGridView.getSelectedPosition();
        for (int i5 = 0; i5 < verticalGridView.getAdapter().getItemCount(); i5++) {
            View findViewByPosition = verticalGridView.getLayoutManager().findViewByPosition(i5);
            if (findViewByPosition != null) {
                if (selectedPosition == i5) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                setOrAnimateAlpha(findViewByPosition, z5, i4, z4);
            }
        }
    }

    private void updateColumnSize(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) ((((float) getPickerItemHeightPixels()) * activatedVisibleItemCount) + (((float) verticalGridView.getVerticalSpacing()) * (activatedVisibleItemCount - 1.0f)));
        verticalGridView.setLayoutParams(layoutParams);
    }

    private void setOrAnimateAlpha(View view, boolean z4, float f4, float f5, Interpolator interpolator) {
        view.animate().cancel();
        if (!z4) {
            view.setAlpha(f4);
            return;
        }
        if (f5 >= 0.0f) {
            view.setAlpha(f5);
        }
        view.animate().alpha(f4).setDuration((long) this.mAlphaAnimDuration).setInterpolator(interpolator).start();
    }
}
