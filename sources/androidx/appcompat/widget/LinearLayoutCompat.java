package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", 16843046);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", 16843047);
            this.mGravityId = propertyMapper.mapGravity("gravity", 16842927);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", 16842948, new IntFunction<String>() {
                public String apply(int i4) {
                    if (i4 == 0) {
                        return "horizontal";
                    }
                    if (i4 != 1) {
                        return String.valueOf(i4);
                    }
                    return "vertical";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", 16843048);
            this.mDividerId = propertyMapper.mapObject("divider", R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", R.attr.showDividers, new IntFunction<Set<String>>() {
                public Set<String> apply(int i4) {
                    HashSet hashSet = new HashSet();
                    if (i4 == 0) {
                        hashSet.add("none");
                    }
                    if (i4 == 1) {
                        hashSet.add("beginning");
                    }
                    if (i4 == 2) {
                        hashSet.add("middle");
                    }
                    if (i4 == 4) {
                        hashSet.add(TtmlNode.END);
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (this.mPropertiesMapped) {
                propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
                propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
                propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
                propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
                propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
                propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
                propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
                propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
                propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
                return;
            }
            throw C0352e.a();
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
        }

        public LayoutParams(int i4, int i5, float f4) {
            super(i4, i5, f4);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void forceUniformHeight(int i4, int i5) {
        int i6;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i7 = 0;
        while (i7 < i4) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i8 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    i6 = i5;
                    measureChildWithMargins(virtualChildAt, i6, 0, makeMeasureSpec, 0);
                    layoutParams.width = i8;
                    i7++;
                    i5 = i6;
                }
            }
            i6 = i5;
            i7++;
            i5 = i6;
        }
    }

    private void forceUniformWidth(int i4, int i5) {
        int i6;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i7 = 0;
        while (i7 < i4) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i8 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    i6 = i5;
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i6, 0);
                    layoutParams.height = i8;
                    i7++;
                    i5 = i6;
                }
            }
            i6 = i5;
            i7++;
            i5 = i6;
        }
    }

    private void setChildFrame(View view, int i4, int i5, int i6, int i7) {
        view.layout(i4, i5, i6 + i4, i7 + i5);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i4;
        int left;
        int i5;
        int i6;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i7 = 0; i7 < virtualChildCount; i7++) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i7))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    i6 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    i6 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i6);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i5 = this.mDividerWidth;
                } else {
                    i4 = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                    drawVerticalDivider(canvas, i4);
                }
            } else if (isLayoutRtl) {
                i4 = getPaddingLeft();
                drawVerticalDivider(canvas, i4);
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.mDividerWidth;
            }
            i4 = left - i5;
            drawVerticalDivider(canvas, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int i4;
        int virtualChildCount = getVirtualChildCount();
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i5))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i4 = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i4 = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i4) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i4, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i4);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i4) {
        this.mDivider.setBounds(i4, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i4, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public int getBaseline() {
        int i4;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.mBaselineAlignedChildIndex;
        if (childCount > i5) {
            View childAt = getChildAt(i5);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i6 = this.mBaselineChildTop;
                if (this.mOrientation == 1 && (i4 = this.mGravity & 112) != 48) {
                    if (i4 == 16) {
                        i6 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i4 == 80) {
                        i6 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
                return i6 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i4) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i4) {
        return getChildAt(i4);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i4) {
        if (i4 == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (i4 != getChildCount()) {
            if ((this.mShowDividers & 2) != 0) {
                for (int i5 = i4 - 1; i5 >= 0; i5--) {
                    if (getChildAt(i5).getVisibility() != 8) {
                        return true;
                    }
                }
            }
            return false;
        } else if ((this.mShowDividers & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layoutHorizontal(int r22, int r23, int r24, int r25) {
        /*
            r21 = this;
            r0 = r21
            boolean r1 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r0)
            int r6 = r0.getPaddingTop()
            int r2 = r25 - r23
            int r3 = r0.getPaddingBottom()
            int r7 = r2 - r3
            int r2 = r2 - r6
            int r3 = r0.getPaddingBottom()
            int r8 = r2 - r3
            int r9 = r0.getVirtualChildCount()
            int r2 = r0.mGravity
            r3 = 8388615(0x800007, float:1.1754953E-38)
            r3 = r3 & r2
            r10 = r2 & 112(0x70, float:1.57E-43)
            boolean r11 = r0.mBaselineAligned
            int[] r12 = r0.mMaxAscent
            int[] r13 = r0.mMaxDescent
            int r2 = r0.getLayoutDirection()
            int r2 = androidx.core.view.GravityCompat.getAbsoluteGravity(r3, r2)
            r14 = 2
            r15 = 1
            if (r2 == r15) goto L_0x004b
            r3 = 5
            if (r2 == r3) goto L_0x003f
            int r2 = r0.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r2 = r0.getPaddingLeft()
            int r2 = r2 + r24
            int r2 = r2 - r22
            int r3 = r0.mTotalLength
            int r2 = r2 - r3
            goto L_0x0056
        L_0x004b:
            int r2 = r0.getPaddingLeft()
            int r3 = r24 - r22
            int r4 = r0.mTotalLength
            int r3 = r3 - r4
            int r3 = r3 / r14
            int r2 = r2 + r3
        L_0x0056:
            r3 = 0
            if (r1 == 0) goto L_0x0060
            int r1 = r9 + -1
            r16 = r1
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = 0
            r17 = 1
        L_0x0064:
            r1 = 0
        L_0x0065:
            if (r1 >= r9) goto L_0x0138
            int r3 = r17 * r1
            int r3 = r16 + r3
            r5 = r1
            android.view.View r1 = r0.getVirtualChildAt(r3)
            if (r1 != 0) goto L_0x0080
            int r1 = r0.measureNullChild(r3)
            int r2 = r2 + r1
            r1 = r5
            r19 = r6
            r23 = 2
            r25 = 1
            goto L_0x0130
        L_0x0080:
            r23 = 2
            int r14 = r1.getVisibility()
            r25 = 1
            r15 = 8
            if (r14 == r15) goto L_0x012a
            int r14 = r1.getMeasuredWidth()
            r15 = r5
            int r5 = r1.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r1.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r24 = r2
            if (r11 == 0) goto L_0x00ad
            int r2 = r4.height
            r18 = r5
            r5 = -1
            if (r2 == r5) goto L_0x00af
            int r5 = r1.getBaseline()
            goto L_0x00b0
        L_0x00ad:
            r18 = r5
        L_0x00af:
            r5 = -1
        L_0x00b0:
            int r2 = r4.gravity
            if (r2 >= 0) goto L_0x00b5
            r2 = r10
        L_0x00b5:
            r2 = r2 & 112(0x70, float:1.57E-43)
            r19 = r6
            r6 = 16
            if (r2 == r6) goto L_0x00eb
            r6 = 48
            if (r2 == r6) goto L_0x00dd
            r6 = 80
            if (r2 == r6) goto L_0x00c9
            r2 = r19
            r6 = -1
            goto L_0x00f8
        L_0x00c9:
            int r2 = r7 - r18
            int r6 = r4.bottomMargin
            int r2 = r2 - r6
            r6 = -1
            if (r5 == r6) goto L_0x00f8
            int r20 = r1.getMeasuredHeight()
            int r20 = r20 - r5
            r5 = r13[r23]
            int r5 = r5 - r20
        L_0x00db:
            int r2 = r2 - r5
            goto L_0x00f8
        L_0x00dd:
            r6 = -1
            int r2 = r4.topMargin
            int r2 = r19 + r2
            if (r5 == r6) goto L_0x00f8
            r20 = r12[r25]
            int r20 = r20 - r5
            int r2 = r2 + r20
            goto L_0x00f8
        L_0x00eb:
            r6 = -1
            int r2 = r8 - r18
            int r2 = r2 / 2
            int r2 = r19 + r2
            int r5 = r4.topMargin
            int r2 = r2 + r5
            int r5 = r4.bottomMargin
            goto L_0x00db
        L_0x00f8:
            boolean r5 = r0.hasDividerBeforeChildAt(r3)
            if (r5 == 0) goto L_0x0103
            int r5 = r0.mDividerWidth
            int r5 = r24 + r5
            goto L_0x0105
        L_0x0103:
            r5 = r24
        L_0x0105:
            int r6 = r4.leftMargin
            int r6 = r6 + r5
            int r5 = r0.getLocationOffset(r1)
            int r5 = r5 + r6
            r24 = r6
            r6 = r4
            r4 = r14
            r14 = r3
            r3 = r2
            r2 = r5
            r5 = r18
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r2 = r6.rightMargin
            int r2 = r2 + r4
            int r3 = r0.getNextLocationOffset(r1)
            int r2 = r2 + r3
            int r6 = r24 + r2
            int r1 = r0.getChildrenSkipCount(r1, r14)
            int r1 = r1 + r15
            r2 = r6
            goto L_0x0130
        L_0x012a:
            r24 = r2
            r15 = r5
            r19 = r6
            r1 = r15
        L_0x0130:
            int r1 = r1 + 1
            r6 = r19
            r14 = 2
            r15 = 1
            goto L_0x0065
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int paddingLeft = getPaddingLeft();
        int i12 = i6 - i4;
        int paddingRight = i12 - getPaddingRight();
        int paddingRight2 = (i12 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.mGravity;
        int i14 = i13 & 112;
        int i15 = i13 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i14 == 16) {
            i8 = getPaddingTop() + (((i7 - i5) - this.mTotalLength) / 2);
        } else if (i14 != 80) {
            i8 = getPaddingTop();
        } else {
            i8 = ((getPaddingTop() + i7) - i5) - this.mTotalLength;
        }
        int i16 = 0;
        while (i16 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt == null) {
                i8 += measureNullChild(i16);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i17 = layoutParams.gravity;
                if (i17 < 0) {
                    i17 = i15;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i17, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i9 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i10 = layoutParams.rightMargin;
                    i11 = i9 - i10;
                } else if (absoluteGravity != 5) {
                    i11 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i9 = paddingRight - measuredWidth;
                    i10 = layoutParams.rightMargin;
                    i11 = i9 - i10;
                }
                int i18 = i11;
                if (hasDividerBeforeChildAt(i16)) {
                    i8 += this.mDividerHeight;
                }
                int i19 = i8 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i18, i19 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i8 = i19 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                i16 += getChildrenSkipCount(virtualChildAt, i16);
                i16++;
            }
            i16++;
        }
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i4, int i5, int i6, int i7, int i8) {
        measureChildWithMargins(view, i5, i6, i7, i8);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureHorizontal(int r39, int r40) {
        /*
            r38 = this;
            r0 = r38
            r7 = 0
            r0.mTotalLength = r7
            int r8 = r0.getVirtualChildCount()
            int r9 = android.view.View.MeasureSpec.getMode(r39)
            int r10 = android.view.View.MeasureSpec.getMode(r40)
            int[] r1 = r0.mMaxAscent
            r11 = 4
            if (r1 == 0) goto L_0x001a
            int[] r1 = r0.mMaxDescent
            if (r1 != 0) goto L_0x0022
        L_0x001a:
            int[] r1 = new int[r11]
            r0.mMaxAscent = r1
            int[] r1 = new int[r11]
            r0.mMaxDescent = r1
        L_0x0022:
            int[] r12 = r0.mMaxAscent
            int[] r13 = r0.mMaxDescent
            r14 = 3
            r15 = -1
            r12[r14] = r15
            r16 = 2
            r12[r16] = r15
            r17 = 1
            r12[r17] = r15
            r12[r7] = r15
            r13[r14] = r15
            r13[r16] = r15
            r13[r17] = r15
            r13[r7] = r15
            boolean r1 = r0.mBaselineAligned
            boolean r2 = r0.mUseLargestChild
            r3 = 1073741824(0x40000000, float:2.0)
            if (r9 != r3) goto L_0x0047
            r18 = 1
            goto L_0x0049
        L_0x0047:
            r18 = 0
        L_0x0049:
            r19 = 0
            r4 = r2
            r2 = 0
            r5 = 0
            r6 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r20 = 4
            r21 = 3
            r22 = 0
            r24 = 0
            r25 = 1
            r26 = 0
        L_0x005e:
            r27 = r6
            r6 = 8
            if (r2 >= r8) goto L_0x0202
            r30 = r1
            android.view.View r1 = r0.getVirtualChildAt(r2)
            if (r1 != 0) goto L_0x0085
            int r1 = r0.mTotalLength
            int r6 = r0.measureNullChild(r2)
            int r1 = r1 + r6
            r0.mTotalLength = r1
        L_0x0075:
            r3 = r39
            r1 = r40
            r34 = r9
            r33 = r12
            r28 = r13
            r6 = r27
            r27 = r4
            goto L_0x01f1
        L_0x0085:
            int r7 = r1.getVisibility()
            if (r7 != r6) goto L_0x0091
            int r1 = r0.getChildrenSkipCount(r1, r2)
            int r2 = r2 + r1
            goto L_0x0075
        L_0x0091:
            boolean r6 = r0.hasDividerBeforeChildAt(r2)
            if (r6 == 0) goto L_0x009e
            int r6 = r0.mTotalLength
            int r7 = r0.mDividerWidth
            int r6 = r6 + r7
            r0.mTotalLength = r6
        L_0x009e:
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            r7 = r6
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r7 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r7
            float r6 = r7.weight
            float r32 = r5 + r6
            if (r9 != r3) goto L_0x0102
            int r5 = r7.width
            if (r5 != 0) goto L_0x0102
            int r5 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x0102
            if (r18 == 0) goto L_0x00c0
            int r5 = r0.mTotalLength
            int r6 = r7.leftMargin
            int r3 = r7.rightMargin
            int r6 = r6 + r3
            int r5 = r5 + r6
            r0.mTotalLength = r5
            goto L_0x00ce
        L_0x00c0:
            int r3 = r0.mTotalLength
            int r5 = r7.leftMargin
            int r5 = r5 + r3
            int r6 = r7.rightMargin
            int r5 = r5 + r6
            int r3 = java.lang.Math.max(r3, r5)
            r0.mTotalLength = r3
        L_0x00ce:
            if (r30 == 0) goto L_0x00eb
            r3 = 0
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            r1.measure(r5, r5)
            r3 = r39
            r34 = r9
            r33 = r12
            r28 = r13
            r12 = r27
            r29 = -2
            r27 = r4
            r4 = r1
            r1 = r40
            goto L_0x0171
        L_0x00eb:
            r3 = r39
            r34 = r9
            r33 = r12
            r28 = r13
            r12 = r27
            r5 = 1073741824(0x40000000, float:2.0)
            r22 = 1
            r29 = -2
            r27 = r4
            r4 = r1
            r1 = r40
            goto L_0x0173
        L_0x0102:
            int r3 = r7.width
            if (r3 != 0) goto L_0x010f
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x010f
            r3 = -2
            r7.width = r3
            r5 = 0
            goto L_0x0112
        L_0x010f:
            r3 = -2
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0112:
            int r6 = (r32 > r19 ? 1 : (r32 == r19 ? 0 : -1))
            if (r6 != 0) goto L_0x011e
            int r6 = r0.mTotalLength
            r37 = r6
            r6 = r4
            r4 = r37
            goto L_0x0120
        L_0x011e:
            r6 = r4
            r4 = 0
        L_0x0120:
            r28 = 0
            r3 = r39
            r34 = r9
            r33 = r12
            r28 = r13
            r12 = r27
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = -2
            r9 = r5
            r27 = r6
            r6 = 0
            r5 = r40
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = r5
            if (r9 == r13) goto L_0x013f
            r7.width = r9
        L_0x013f:
            int r5 = r4.getMeasuredWidth()
            if (r18 == 0) goto L_0x0156
            int r6 = r0.mTotalLength
            int r9 = r7.leftMargin
            int r9 = r9 + r5
            int r13 = r7.rightMargin
            int r9 = r9 + r13
            int r13 = r0.getNextLocationOffset(r4)
            int r9 = r9 + r13
            int r6 = r6 + r9
            r0.mTotalLength = r6
            goto L_0x016b
        L_0x0156:
            int r6 = r0.mTotalLength
            int r9 = r6 + r5
            int r13 = r7.leftMargin
            int r9 = r9 + r13
            int r13 = r7.rightMargin
            int r9 = r9 + r13
            int r13 = r0.getNextLocationOffset(r4)
            int r9 = r9 + r13
            int r6 = java.lang.Math.max(r6, r9)
            r0.mTotalLength = r6
        L_0x016b:
            if (r27 == 0) goto L_0x0171
            int r15 = java.lang.Math.max(r5, r15)
        L_0x0171:
            r5 = 1073741824(0x40000000, float:2.0)
        L_0x0173:
            if (r10 == r5) goto L_0x017e
            int r5 = r7.height
            r6 = -1
            if (r5 != r6) goto L_0x017e
            r5 = 1
            r26 = 1
            goto L_0x017f
        L_0x017e:
            r5 = 0
        L_0x017f:
            int r6 = r7.topMargin
            int r9 = r7.bottomMargin
            int r6 = r6 + r9
            int r9 = r4.getMeasuredHeight()
            int r9 = r9 + r6
            int r13 = r4.getMeasuredState()
            r35 = r6
            r6 = r24
            int r24 = android.view.View.combineMeasuredStates(r6, r13)
            if (r30 == 0) goto L_0x01c1
            int r6 = r4.getBaseline()
            r13 = -1
            if (r6 == r13) goto L_0x01c1
            int r13 = r7.gravity
            if (r13 >= 0) goto L_0x01a4
            int r13 = r0.mGravity
        L_0x01a4:
            r13 = r13 & 112(0x70, float:1.57E-43)
            int r13 = r13 >> 4
            r13 = r13 & -2
            int r13 = r13 >> 1
            r36 = r5
            r5 = r33[r13]
            int r5 = java.lang.Math.max(r5, r6)
            r33[r13] = r5
            r5 = r28[r13]
            int r6 = r9 - r6
            int r5 = java.lang.Math.max(r5, r6)
            r28[r13] = r5
            goto L_0x01c3
        L_0x01c1:
            r36 = r5
        L_0x01c3:
            int r6 = java.lang.Math.max(r12, r9)
            if (r25 == 0) goto L_0x01d1
            int r5 = r7.height
            r13 = -1
            if (r5 != r13) goto L_0x01d1
            r25 = 1
            goto L_0x01d3
        L_0x01d1:
            r25 = 0
        L_0x01d3:
            float r5 = r7.weight
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x01e2
            if (r36 == 0) goto L_0x01dd
            r9 = r35
        L_0x01dd:
            int r14 = java.lang.Math.max(r14, r9)
            goto L_0x01ea
        L_0x01e2:
            if (r36 == 0) goto L_0x01e6
            r9 = r35
        L_0x01e6:
            int r11 = java.lang.Math.max(r11, r9)
        L_0x01ea:
            int r4 = r0.getChildrenSkipCount(r4, r2)
            int r2 = r2 + r4
            r5 = r32
        L_0x01f1:
            int r2 = r2 + 1
            r4 = r27
            r13 = r28
            r1 = r30
            r12 = r33
            r9 = r34
            r3 = 1073741824(0x40000000, float:2.0)
            r7 = 0
            goto L_0x005e
        L_0x0202:
            r3 = r39
            r30 = r1
            r34 = r9
            r33 = r12
            r28 = r13
            r6 = r24
            r12 = r27
            r2 = 8
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = -2
            r1 = r40
            r27 = r4
            int r4 = r0.mTotalLength
            if (r4 <= 0) goto L_0x022b
            boolean r4 = r0.hasDividerBeforeChildAt(r8)
            if (r4 == 0) goto L_0x022b
            int r4 = r0.mTotalLength
            int r7 = r0.mDividerWidth
            int r4 = r4 + r7
            r0.mTotalLength = r4
        L_0x022b:
            r4 = r33[r17]
            r7 = -1
            if (r4 != r7) goto L_0x0241
            r31 = 0
            r9 = r33[r31]
            if (r9 != r7) goto L_0x0241
            r9 = r33[r16]
            if (r9 != r7) goto L_0x0241
            r9 = r33[r21]
            if (r9 == r7) goto L_0x023f
            goto L_0x0241
        L_0x023f:
            r2 = r12
            goto L_0x026e
        L_0x0241:
            r7 = r33[r21]
            r31 = 0
            r9 = r33[r31]
            r2 = r33[r16]
            int r2 = java.lang.Math.max(r4, r2)
            int r2 = java.lang.Math.max(r9, r2)
            int r2 = java.lang.Math.max(r7, r2)
            r4 = r28[r21]
            r7 = r28[r31]
            r9 = r28[r17]
            r13 = r28[r16]
            int r9 = java.lang.Math.max(r9, r13)
            int r7 = java.lang.Math.max(r7, r9)
            int r4 = java.lang.Math.max(r4, r7)
            int r2 = r2 + r4
            int r2 = java.lang.Math.max(r12, r2)
        L_0x026e:
            if (r27 == 0) goto L_0x02e2
            r4 = r34
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == r13) goto L_0x0278
            if (r4 != 0) goto L_0x027a
        L_0x0278:
            r7 = 0
            goto L_0x0280
        L_0x027a:
            r32 = r2
        L_0x027c:
            r34 = r5
            goto L_0x02e7
        L_0x0280:
            r0.mTotalLength = r7
            r7 = 0
        L_0x0283:
            if (r7 >= r8) goto L_0x027a
            android.view.View r9 = r0.getVirtualChildAt(r7)
            if (r9 != 0) goto L_0x0295
            int r9 = r0.mTotalLength
            int r12 = r0.measureNullChild(r7)
            int r9 = r9 + r12
            r0.mTotalLength = r9
            goto L_0x02a2
        L_0x0295:
            int r12 = r9.getVisibility()
            r13 = 8
            if (r12 != r13) goto L_0x02a7
            int r9 = r0.getChildrenSkipCount(r9, r7)
            int r7 = r7 + r9
        L_0x02a2:
            r32 = r2
        L_0x02a4:
            r34 = r5
            goto L_0x02db
        L_0x02a7:
            android.view.ViewGroup$LayoutParams r12 = r9.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r12 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r12
            if (r18 == 0) goto L_0x02c2
            int r13 = r0.mTotalLength
            r32 = r2
            int r2 = r12.leftMargin
            int r2 = r2 + r15
            int r12 = r12.rightMargin
            int r2 = r2 + r12
            int r9 = r0.getNextLocationOffset(r9)
            int r2 = r2 + r9
            int r13 = r13 + r2
            r0.mTotalLength = r13
            goto L_0x02a4
        L_0x02c2:
            r32 = r2
            int r2 = r0.mTotalLength
            int r13 = r2 + r15
            r34 = r5
            int r5 = r12.leftMargin
            int r13 = r13 + r5
            int r5 = r12.rightMargin
            int r13 = r13 + r5
            int r5 = r0.getNextLocationOffset(r9)
            int r13 = r13 + r5
            int r2 = java.lang.Math.max(r2, r13)
            r0.mTotalLength = r2
        L_0x02db:
            int r7 = r7 + 1
            r2 = r32
            r5 = r34
            goto L_0x0283
        L_0x02e2:
            r32 = r2
            r4 = r34
            goto L_0x027c
        L_0x02e7:
            int r2 = r0.mTotalLength
            int r5 = r0.getPaddingLeft()
            int r7 = r0.getPaddingRight()
            int r5 = r5 + r7
            int r2 = r2 + r5
            r0.mTotalLength = r2
            int r5 = r0.getSuggestedMinimumWidth()
            int r2 = java.lang.Math.max(r2, r5)
            r7 = 0
            int r2 = android.view.View.resolveSizeAndState(r2, r3, r7)
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r2
            int r7 = r0.mTotalLength
            int r5 = r5 - r7
            if (r22 != 0) goto L_0x0358
            if (r5 == 0) goto L_0x0312
            int r9 = (r34 > r19 ? 1 : (r34 == r19 ? 0 : -1))
            if (r9 <= 0) goto L_0x0312
            goto L_0x0358
        L_0x0312:
            int r5 = java.lang.Math.max(r11, r14)
            if (r27 == 0) goto L_0x034e
            r9 = 1073741824(0x40000000, float:2.0)
            if (r4 == r9) goto L_0x034e
            r4 = 0
        L_0x031d:
            if (r4 >= r8) goto L_0x034e
            android.view.View r9 = r0.getVirtualChildAt(r4)
            if (r9 == 0) goto L_0x034b
            int r11 = r9.getVisibility()
            r13 = 8
            if (r11 != r13) goto L_0x032e
            goto L_0x034b
        L_0x032e:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            float r11 = r11.weight
            int r11 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r11 <= 0) goto L_0x034b
            r11 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r11)
            int r13 = r9.getMeasuredHeight()
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r11)
            r9.measure(r12, r13)
        L_0x034b:
            int r4 = r4 + 1
            goto L_0x031d
        L_0x034e:
            r27 = r2
            r24 = r6
            r2 = r32
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x04d6
        L_0x0358:
            float r9 = r0.mWeightSum
            int r12 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r12 <= 0) goto L_0x0360
            r34 = r9
        L_0x0360:
            r23 = -1
            r33[r21] = r23
            r33[r16] = r23
            r33[r17] = r23
            r9 = 0
            r33[r9] = r23
            r28[r21] = r23
            r28[r16] = r23
            r28[r17] = r23
            r28[r9] = r23
            r0.mTotalLength = r9
            r9 = r6
            r6 = -1
            r12 = 0
        L_0x0378:
            if (r12 >= r8) goto L_0x047e
            android.view.View r13 = r0.getVirtualChildAt(r12)
            if (r13 == 0) goto L_0x0388
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x038e
        L_0x0388:
            r27 = r2
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0478
        L_0x038e:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            float r7 = r14.weight
            int r24 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r24 <= 0) goto L_0x03ef
            float r15 = (float) r5
            float r15 = r15 * r7
            float r15 = r15 / r34
            int r15 = (int) r15
            float r34 = r34 - r7
            int r5 = r5 - r15
            int r7 = r0.getPaddingTop()
            int r27 = r0.getPaddingBottom()
            int r7 = r7 + r27
            r27 = r2
            int r2 = r14.topMargin
            int r7 = r7 + r2
            int r2 = r14.bottomMargin
            int r7 = r7 + r2
            int r2 = r14.height
            int r2 = android.view.ViewGroup.getChildMeasureSpec(r1, r7, r2)
            int r7 = r14.width
            if (r7 != 0) goto L_0x03d2
            r7 = 1073741824(0x40000000, float:2.0)
            if (r4 == r7) goto L_0x03c6
            goto L_0x03d4
        L_0x03c6:
            if (r15 <= 0) goto L_0x03c9
            goto L_0x03ca
        L_0x03c9:
            r15 = 0
        L_0x03ca:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r7)
            r13.measure(r15, r2)
            goto L_0x03e4
        L_0x03d2:
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x03d4:
            int r32 = r13.getMeasuredWidth()
            int r15 = r32 + r15
            if (r15 >= 0) goto L_0x03dd
            r15 = 0
        L_0x03dd:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r7)
            r13.measure(r15, r2)
        L_0x03e4:
            int r2 = r13.getMeasuredState()
            r2 = r2 & r22
            int r9 = android.view.View.combineMeasuredStates(r9, r2)
            goto L_0x03f1
        L_0x03ef:
            r27 = r2
        L_0x03f1:
            if (r18 == 0) goto L_0x040a
            int r2 = r0.mTotalLength
            int r7 = r13.getMeasuredWidth()
            int r15 = r14.leftMargin
            int r7 = r7 + r15
            int r15 = r14.rightMargin
            int r7 = r7 + r15
            int r15 = r0.getNextLocationOffset(r13)
            int r7 = r7 + r15
            int r2 = r2 + r7
            r0.mTotalLength = r2
        L_0x0407:
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0423
        L_0x040a:
            int r2 = r0.mTotalLength
            int r7 = r13.getMeasuredWidth()
            int r7 = r7 + r2
            int r15 = r14.leftMargin
            int r7 = r7 + r15
            int r15 = r14.rightMargin
            int r7 = r7 + r15
            int r15 = r0.getNextLocationOffset(r13)
            int r7 = r7 + r15
            int r2 = java.lang.Math.max(r2, r7)
            r0.mTotalLength = r2
            goto L_0x0407
        L_0x0423:
            if (r10 == r7) goto L_0x042c
            int r2 = r14.height
            r7 = -1
            if (r2 != r7) goto L_0x042c
            r2 = 1
            goto L_0x042d
        L_0x042c:
            r2 = 0
        L_0x042d:
            int r7 = r14.topMargin
            int r15 = r14.bottomMargin
            int r7 = r7 + r15
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r7
            int r6 = java.lang.Math.max(r6, r15)
            if (r2 == 0) goto L_0x043e
            goto L_0x043f
        L_0x043e:
            r7 = r15
        L_0x043f:
            int r2 = java.lang.Math.max(r11, r7)
            if (r25 == 0) goto L_0x044c
            int r7 = r14.height
            r11 = -1
            if (r7 != r11) goto L_0x044d
            r7 = 1
            goto L_0x044e
        L_0x044c:
            r11 = -1
        L_0x044d:
            r7 = 0
        L_0x044e:
            if (r30 == 0) goto L_0x0475
            int r13 = r13.getBaseline()
            if (r13 == r11) goto L_0x0475
            int r11 = r14.gravity
            if (r11 >= 0) goto L_0x045c
            int r11 = r0.mGravity
        L_0x045c:
            r11 = r11 & 112(0x70, float:1.57E-43)
            int r11 = r11 >> 4
            r11 = r11 & -2
            int r11 = r11 >> 1
            r14 = r33[r11]
            int r14 = java.lang.Math.max(r14, r13)
            r33[r11] = r14
            r14 = r28[r11]
            int r15 = r15 - r13
            int r13 = java.lang.Math.max(r14, r15)
            r28[r11] = r13
        L_0x0475:
            r11 = r2
            r25 = r7
        L_0x0478:
            int r12 = r12 + 1
            r2 = r27
            goto L_0x0378
        L_0x047e:
            r27 = r2
            r22 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r2 = r0.mTotalLength
            int r4 = r0.getPaddingLeft()
            int r5 = r0.getPaddingRight()
            int r4 = r4 + r5
            int r2 = r2 + r4
            r0.mTotalLength = r2
            r2 = r33[r17]
            r13 = -1
            if (r2 != r13) goto L_0x04a6
            r31 = 0
            r4 = r33[r31]
            if (r4 != r13) goto L_0x04a6
            r4 = r33[r16]
            if (r4 != r13) goto L_0x04a6
            r4 = r33[r21]
            if (r4 == r13) goto L_0x04a4
            goto L_0x04a6
        L_0x04a4:
            r2 = r6
            goto L_0x04d3
        L_0x04a6:
            r4 = r33[r21]
            r31 = 0
            r5 = r33[r31]
            r7 = r33[r16]
            int r2 = java.lang.Math.max(r2, r7)
            int r2 = java.lang.Math.max(r5, r2)
            int r2 = java.lang.Math.max(r4, r2)
            r4 = r28[r21]
            r5 = r28[r31]
            r7 = r28[r17]
            r12 = r28[r16]
            int r7 = java.lang.Math.max(r7, r12)
            int r5 = java.lang.Math.max(r5, r7)
            int r4 = java.lang.Math.max(r4, r5)
            int r2 = r2 + r4
            int r2 = java.lang.Math.max(r6, r2)
        L_0x04d3:
            r24 = r9
            r5 = r11
        L_0x04d6:
            if (r25 != 0) goto L_0x04dd
            r7 = 1073741824(0x40000000, float:2.0)
            if (r10 == r7) goto L_0x04dd
            r2 = r5
        L_0x04dd:
            int r4 = r0.getPaddingTop()
            int r5 = r0.getPaddingBottom()
            int r4 = r4 + r5
            int r2 = r2 + r4
            int r4 = r0.getSuggestedMinimumHeight()
            int r2 = java.lang.Math.max(r2, r4)
            r4 = r24 & r22
            r4 = r27 | r4
            int r5 = r24 << 16
            int r1 = android.view.View.resolveSizeAndState(r2, r1, r5)
            r0.setMeasuredDimension(r4, r1)
            if (r26 == 0) goto L_0x0501
            r0.forceUniformHeight(r8, r3)
        L_0x0501:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i4) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measureVertical(int r28, int r29) {
        /*
            r27 = this;
            r0 = r27
            r7 = 0
            r0.mTotalLength = r7
            int r8 = r0.getVirtualChildCount()
            int r9 = android.view.View.MeasureSpec.getMode(r28)
            int r10 = android.view.View.MeasureSpec.getMode(r29)
            int r11 = r0.mBaselineAlignedChildIndex
            boolean r12 = r0.mUseLargestChild
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
            r19 = 1
        L_0x0024:
            r20 = 0
            r7 = 8
            r14 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r8) goto L_0x0181
            r21 = r1
            android.view.View r1 = r0.getVirtualChildAt(r2)
            if (r1 != 0) goto L_0x004d
            int r1 = r0.mTotalLength
            int r7 = r0.measureNullChild(r2)
            int r1 = r1 + r7
            r0.mTotalLength = r1
        L_0x003d:
            r14 = r3
            r26 = r8
            r25 = r10
            r24 = r12
            r1 = r21
            r3 = r28
            r10 = r5
            r5 = r29
            goto L_0x0174
        L_0x004d:
            int r13 = r1.getVisibility()
            if (r13 != r7) goto L_0x0059
            int r1 = r0.getChildrenSkipCount(r1, r2)
            int r2 = r2 + r1
            goto L_0x003d
        L_0x0059:
            boolean r7 = r0.hasDividerBeforeChildAt(r2)
            if (r7 == 0) goto L_0x0066
            int r7 = r0.mTotalLength
            int r13 = r0.mDividerHeight
            int r7 = r7 + r13
            r0.mTotalLength = r7
        L_0x0066:
            android.view.ViewGroup$LayoutParams r7 = r1.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r7 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r7
            float r13 = r7.weight
            float r21 = r21 + r13
            if (r10 != r14) goto L_0x009e
            int r14 = r7.height
            if (r14 != 0) goto L_0x009e
            int r14 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r14 <= 0) goto L_0x009e
            int r13 = r0.mTotalLength
            int r14 = r7.topMargin
            int r14 = r14 + r13
            r24 = r1
            int r1 = r7.bottomMargin
            int r14 = r14 + r1
            int r1 = java.lang.Math.max(r13, r14)
            r0.mTotalLength = r1
            r14 = r3
            r1 = r4
            r26 = r8
            r25 = r10
            r4 = r24
            r16 = 1
            r3 = r28
            r10 = r5
            r8 = r6
            r24 = r12
            r5 = r29
            goto L_0x0100
        L_0x009e:
            r24 = r1
            int r1 = r7.height
            if (r1 != 0) goto L_0x00ad
            int r1 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ad
            r1 = -2
            r7.height = r1
            r13 = 0
            goto L_0x00af
        L_0x00ad:
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00af:
            int r1 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1))
            if (r1 != 0) goto L_0x00ba
            int r1 = r0.mTotalLength
            r14 = r6
            r6 = r1
            r1 = r14
        L_0x00b8:
            r14 = r4
            goto L_0x00bd
        L_0x00ba:
            r1 = r6
            r6 = 0
            goto L_0x00b8
        L_0x00bd:
            r4 = 0
            r26 = r8
            r25 = r10
            r8 = r1
            r10 = r5
            r1 = r24
            r5 = r29
            r24 = r12
            r12 = r14
            r14 = r3
            r3 = r28
            r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == r1) goto L_0x00d8
            r7.height = r13
        L_0x00d8:
            int r1 = r4.getMeasuredHeight()
            int r6 = r0.mTotalLength
            int r13 = r6 + r1
            r22 = r13
            int r13 = r7.topMargin
            int r13 = r22 + r13
            r22 = r13
            int r13 = r7.bottomMargin
            int r13 = r22 + r13
            int r22 = r0.getNextLocationOffset(r4)
            int r13 = r13 + r22
            int r6 = java.lang.Math.max(r6, r13)
            r0.mTotalLength = r6
            if (r24 == 0) goto L_0x00ff
            int r1 = java.lang.Math.max(r1, r12)
            goto L_0x0100
        L_0x00ff:
            r1 = r12
        L_0x0100:
            if (r11 < 0) goto L_0x010a
            int r6 = r2 + 1
            if (r11 != r6) goto L_0x010a
            int r6 = r0.mTotalLength
            r0.mBaselineChildTop = r6
        L_0x010a:
            if (r2 >= r11) goto L_0x0112
            float r6 = r7.weight
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 > 0) goto L_0x0115
        L_0x0112:
            r6 = 1073741824(0x40000000, float:2.0)
            goto L_0x011d
        L_0x0115:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r1.<init>(r2)
            throw r1
        L_0x011d:
            if (r9 == r6) goto L_0x0128
            int r6 = r7.width
            r12 = -1
            if (r6 != r12) goto L_0x0128
            r6 = 1
            r18 = 1
            goto L_0x0129
        L_0x0128:
            r6 = 0
        L_0x0129:
            int r12 = r7.leftMargin
            int r13 = r7.rightMargin
            int r12 = r12 + r13
            int r13 = r4.getMeasuredWidth()
            int r13 = r13 + r12
            int r10 = java.lang.Math.max(r10, r13)
            r22 = r1
            int r1 = r4.getMeasuredState()
            int r1 = android.view.View.combineMeasuredStates(r8, r1)
            if (r17 == 0) goto L_0x014d
            int r8 = r7.width
            r23 = r1
            r1 = -1
            if (r8 != r1) goto L_0x014f
            r17 = 1
            goto L_0x0151
        L_0x014d:
            r23 = r1
        L_0x014f:
            r17 = 0
        L_0x0151:
            float r1 = r7.weight
            int r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x0161
            if (r6 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r12 = r13
        L_0x015b:
            int r1 = java.lang.Math.max(r14, r12)
            r14 = r1
            goto L_0x0169
        L_0x0161:
            if (r6 == 0) goto L_0x0164
            goto L_0x0165
        L_0x0164:
            r12 = r13
        L_0x0165:
            int r15 = java.lang.Math.max(r15, r12)
        L_0x0169:
            int r1 = r0.getChildrenSkipCount(r4, r2)
            int r2 = r2 + r1
            r1 = r21
            r4 = r22
            r6 = r23
        L_0x0174:
            int r2 = r2 + 1
            r5 = r10
            r3 = r14
            r12 = r24
            r10 = r25
            r8 = r26
            r7 = 0
            goto L_0x0024
        L_0x0181:
            r21 = r1
            r14 = r3
            r26 = r8
            r25 = r10
            r24 = r12
            r3 = r28
            r12 = r4
            r10 = r5
            r8 = r6
            r5 = r29
            int r1 = r0.mTotalLength
            if (r1 <= 0) goto L_0x01a5
            r1 = r26
            boolean r2 = r0.hasDividerBeforeChildAt(r1)
            if (r2 == 0) goto L_0x01a7
            int r2 = r0.mTotalLength
            int r4 = r0.mDividerHeight
            int r2 = r2 + r4
            r0.mTotalLength = r2
            goto L_0x01a7
        L_0x01a5:
            r1 = r26
        L_0x01a7:
            r2 = r25
            if (r24 == 0) goto L_0x01f6
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == r4) goto L_0x01b1
            if (r2 != 0) goto L_0x01f6
        L_0x01b1:
            r4 = 0
            r0.mTotalLength = r4
            r4 = 0
        L_0x01b5:
            if (r4 >= r1) goto L_0x01f6
            android.view.View r6 = r0.getVirtualChildAt(r4)
            if (r6 != 0) goto L_0x01c7
            int r6 = r0.mTotalLength
            int r11 = r0.measureNullChild(r4)
            int r6 = r6 + r11
            r0.mTotalLength = r6
            goto L_0x01f1
        L_0x01c7:
            int r11 = r6.getVisibility()
            if (r11 != r7) goto L_0x01d3
            int r6 = r0.getChildrenSkipCount(r6, r4)
            int r4 = r4 + r6
            goto L_0x01f1
        L_0x01d3:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r13 = r0.mTotalLength
            int r22 = r13 + r12
            int r7 = r11.topMargin
            int r22 = r22 + r7
            int r7 = r11.bottomMargin
            int r22 = r22 + r7
            int r6 = r0.getNextLocationOffset(r6)
            int r6 = r22 + r6
            int r6 = java.lang.Math.max(r13, r6)
            r0.mTotalLength = r6
        L_0x01f1:
            int r4 = r4 + 1
            r7 = 8
            goto L_0x01b5
        L_0x01f6:
            int r4 = r0.mTotalLength
            int r6 = r0.getPaddingTop()
            int r7 = r0.getPaddingBottom()
            int r6 = r6 + r7
            int r4 = r4 + r6
            r0.mTotalLength = r4
            int r6 = r0.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r5, r6)
            r6 = 16777215(0xffffff, float:2.3509886E-38)
            r6 = r6 & r4
            int r7 = r0.mTotalLength
            int r6 = r6 - r7
            if (r16 != 0) goto L_0x025d
            if (r6 == 0) goto L_0x0221
            int r7 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1))
            if (r7 <= 0) goto L_0x0221
            goto L_0x025d
        L_0x0221:
            int r6 = java.lang.Math.max(r15, r14)
            if (r24 == 0) goto L_0x034a
            r7 = 1073741824(0x40000000, float:2.0)
            if (r2 == r7) goto L_0x034a
            r7 = 0
        L_0x022c:
            if (r7 >= r1) goto L_0x034a
            android.view.View r2 = r0.getVirtualChildAt(r7)
            if (r2 == 0) goto L_0x025a
            int r11 = r2.getVisibility()
            r13 = 8
            if (r11 != r13) goto L_0x023d
            goto L_0x025a
        L_0x023d:
            android.view.ViewGroup$LayoutParams r11 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            float r11 = r11.weight
            int r11 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x025a
            int r11 = r2.getMeasuredWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r13)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
            r2.measure(r11, r14)
        L_0x025a:
            int r7 = r7 + 1
            goto L_0x022c
        L_0x025d:
            float r7 = r0.mWeightSum
            int r11 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0265
        L_0x0263:
            r11 = 0
            goto L_0x0268
        L_0x0265:
            r7 = r21
            goto L_0x0263
        L_0x0268:
            r0.mTotalLength = r11
            r12 = r7
            r7 = r6
            r6 = 0
        L_0x026d:
            if (r6 >= r1) goto L_0x033b
            android.view.View r13 = r0.getVirtualChildAt(r6)
            int r14 = r13.getVisibility()
            r11 = 8
            if (r14 != r11) goto L_0x0281
            r22 = r2
            r16 = r6
            goto L_0x0334
        L_0x0281:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r11 = r14.weight
            int r16 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r16 <= 0) goto L_0x02e7
            r16 = r6
            float r6 = (float) r7
            float r6 = r6 * r11
            float r6 = r6 / r12
            int r6 = (int) r6
            float r12 = r12 - r11
            int r7 = r7 - r6
            int r11 = r0.getPaddingLeft()
            int r21 = r0.getPaddingRight()
            int r11 = r11 + r21
            r21 = r6
            int r6 = r14.leftMargin
            int r11 = r11 + r6
            int r6 = r14.rightMargin
            int r11 = r11 + r6
            int r6 = r14.width
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r3, r11, r6)
            int r11 = r14.height
            if (r11 != 0) goto L_0x02c9
            r11 = 1073741824(0x40000000, float:2.0)
            if (r2 == r11) goto L_0x02b9
        L_0x02b6:
            r22 = r2
            goto L_0x02cc
        L_0x02b9:
            r22 = r2
            if (r21 <= 0) goto L_0x02c0
            r2 = r21
            goto L_0x02c1
        L_0x02c0:
            r2 = 0
        L_0x02c1:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r11)
            r13.measure(r6, r2)
            goto L_0x02dc
        L_0x02c9:
            r11 = 1073741824(0x40000000, float:2.0)
            goto L_0x02b6
        L_0x02cc:
            int r2 = r13.getMeasuredHeight()
            int r2 = r2 + r21
            if (r2 >= 0) goto L_0x02d5
            r2 = 0
        L_0x02d5:
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r11)
            r13.measure(r6, r2)
        L_0x02dc:
            int r2 = r13.getMeasuredState()
            r2 = r2 & -256(0xffffffffffffff00, float:NaN)
            int r8 = android.view.View.combineMeasuredStates(r8, r2)
            goto L_0x02eb
        L_0x02e7:
            r22 = r2
            r16 = r6
        L_0x02eb:
            int r2 = r14.leftMargin
            int r6 = r14.rightMargin
            int r2 = r2 + r6
            int r6 = r13.getMeasuredWidth()
            int r6 = r6 + r2
            int r10 = java.lang.Math.max(r10, r6)
            r11 = 1073741824(0x40000000, float:2.0)
            if (r9 == r11) goto L_0x0307
            int r11 = r14.width
            r21 = r2
            r2 = -1
            if (r11 != r2) goto L_0x0308
            r6 = r21
            goto L_0x0308
        L_0x0307:
            r2 = -1
        L_0x0308:
            int r6 = java.lang.Math.max(r15, r6)
            if (r17 == 0) goto L_0x0314
            int r11 = r14.width
            if (r11 != r2) goto L_0x0314
            r11 = 1
            goto L_0x0315
        L_0x0314:
            r11 = 0
        L_0x0315:
            int r15 = r0.mTotalLength
            int r17 = r13.getMeasuredHeight()
            int r17 = r15 + r17
            int r2 = r14.topMargin
            int r17 = r17 + r2
            int r2 = r14.bottomMargin
            int r17 = r17 + r2
            int r2 = r0.getNextLocationOffset(r13)
            int r2 = r17 + r2
            int r2 = java.lang.Math.max(r15, r2)
            r0.mTotalLength = r2
            r15 = r6
            r17 = r11
        L_0x0334:
            int r6 = r16 + 1
            r2 = r22
            r11 = 0
            goto L_0x026d
        L_0x033b:
            int r2 = r0.mTotalLength
            int r6 = r0.getPaddingTop()
            int r7 = r0.getPaddingBottom()
            int r6 = r6 + r7
            int r2 = r2 + r6
            r0.mTotalLength = r2
            r6 = r15
        L_0x034a:
            if (r17 != 0) goto L_0x0351
            r11 = 1073741824(0x40000000, float:2.0)
            if (r9 == r11) goto L_0x0351
            r10 = r6
        L_0x0351:
            int r2 = r0.getPaddingLeft()
            int r6 = r0.getPaddingRight()
            int r2 = r2 + r6
            int r10 = r10 + r2
            int r2 = r0.getSuggestedMinimumWidth()
            int r2 = java.lang.Math.max(r10, r2)
            int r2 = android.view.View.resolveSizeAndState(r2, r3, r8)
            r0.setMeasuredDimension(r2, r4)
            if (r18 == 0) goto L_0x036f
            r0.forceUniformWidth(r1, r5)
        L_0x036f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        if (this.mOrientation == 1) {
            layoutVertical(i4, i5, i6, i7);
        } else {
            layoutHorizontal(i4, i5, i6, i7);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        if (this.mOrientation == 1) {
            measureVertical(i4, i5);
        } else {
            measureHorizontal(i4, i5);
        }
    }

    public void setBaselineAligned(boolean z4) {
        this.mBaselineAligned = z4;
    }

    public void setBaselineAlignedChildIndex(int i4) {
        if (i4 < 0 || i4 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i4;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z4 = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z4 = true;
            }
            setWillNotDraw(z4);
            requestLayout();
        }
    }

    public void setDividerPadding(int i4) {
        this.mDividerPadding = i4;
    }

    public void setGravity(@GravityInt int i4) {
        if (this.mGravity != i4) {
            if ((8388615 & i4) == 0) {
                i4 |= GravityCompat.START;
            }
            if ((i4 & 112) == 0) {
                i4 |= 48;
            }
            this.mGravity = i4;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i4) {
        int i5 = i4 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i6 = this.mGravity;
        if ((8388615 & i6) != i5) {
            this.mGravity = i5 | (-8388616 & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z4) {
        this.mUseLargestChild = z4;
    }

    public void setOrientation(int i4) {
        if (this.mOrientation != i4) {
            this.mOrientation = i4;
            requestLayout();
        }
    }

    public void setShowDividers(int i4) {
        if (i4 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i4;
    }

    public void setVerticalGravity(int i4) {
        int i5 = i4 & 112;
        int i6 = this.mGravity;
        if ((i6 & 112) != i5) {
            this.mGravity = i5 | (i6 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.mWeightSum = Math.max(0.0f, f4);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        int i4 = this.mOrientation;
        if (i4 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i4 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i4, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i4, 0);
        int i5 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i5 >= 0) {
            setOrientation(i5);
        }
        int i6 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i6 >= 0) {
            setGravity(i6);
        }
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z4) {
            setBaselineAligned(z4);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) (LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
