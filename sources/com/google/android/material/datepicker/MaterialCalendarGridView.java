package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void gainFocus(int i4, Rect rect) {
        if (i4 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i4 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i4, rect);
        }
    }

    private View getChildAtPosition(int i4) {
        return getChildAt(i4 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(@Nullable Long l4, @Nullable Long l5, @Nullable Long l6, @Nullable Long l7) {
        if (l4 == null || l5 == null || l6 == null || l7 == null || l6.longValue() > l5.longValue() || l7.longValue() < l4.longValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(@NonNull Canvas canvas) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int min = Math.min(adapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<Pair<Long, Long>> it = dateSelector.getSelectedRanges().iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            F f4 = next.first;
            if (f4 == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                Long l4 = (Long) f4;
                long longValue = l4.longValue();
                Long l5 = (Long) next.second;
                long longValue2 = l5.longValue();
                if (!skipMonth(item, item2, l4, l5)) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    if (longValue < item.longValue()) {
                        if (adapter.isFirstInRow(max)) {
                            i13 = 0;
                        } else if (!isLayoutRtl) {
                            i13 = materialCalendarGridView.getChildAtPosition(max - 1).getRight();
                        } else {
                            i13 = materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                        }
                        i4 = i13;
                        i5 = max;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        i5 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i4 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i5));
                    }
                    if (longValue2 > item2.longValue()) {
                        if (adapter.isLastInRow(min)) {
                            i12 = materialCalendarGridView.getWidth();
                        } else if (!isLayoutRtl) {
                            i12 = materialCalendarGridView.getChildAtPosition(min).getRight();
                        } else {
                            i12 = materialCalendarGridView.getChildAtPosition(min).getLeft();
                        }
                        i6 = i12;
                        i7 = min;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        i7 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i6 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i7));
                    }
                    int itemId = (int) adapter.getItemId(i5);
                    int i14 = max;
                    int i15 = min;
                    int itemId2 = (int) adapter.getItemId(i7);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        MonthAdapter monthAdapter = adapter;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        Iterator<Pair<Long, Long>> it2 = it;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (!isLayoutRtl) {
                            if (numColumns > i5) {
                                i8 = 0;
                            } else {
                                i8 = i4;
                            }
                            if (i7 > numColumns2) {
                                i9 = getWidth();
                            } else {
                                i9 = i6;
                            }
                        } else {
                            if (i7 > numColumns2) {
                                i10 = 0;
                            } else {
                                i10 = i6;
                            }
                            if (numColumns > i5) {
                                i11 = getWidth();
                            } else {
                                i11 = i4;
                            }
                            int i16 = i11;
                            i8 = i10;
                            i9 = i16;
                        }
                        canvas.drawRect((float) i8, (float) top, (float) i9, (float) bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                        it = it2;
                    }
                    materialCalendarGridView = this;
                    max = i14;
                    min = i15;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i4, Rect rect) {
        if (z4) {
            gainFocus(i4, rect);
        } else {
            super.onFocusChanged(false, i4, rect);
        }
    }

    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (!super.onKeyDown(i4, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i4) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public void onMeasure(int i4, int i5) {
        if (this.nestedScrollable) {
            super.onMeasure(i4, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i4, i5);
    }

    public void setSelection(int i4) {
        if (i4 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i4);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
            }
        });
    }

    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
