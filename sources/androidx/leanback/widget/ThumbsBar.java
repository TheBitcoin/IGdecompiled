package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ThumbsBar extends LinearLayout {
    final SparseArray<Bitmap> mBitmaps;
    int mHeroThumbHeightInPixel;
    int mHeroThumbWidthInPixel;
    private boolean mIsUserSets;
    int mMeasuredMarginInPixel;
    int mNumOfThumbs;
    int mThumbHeightInPixel;
    int mThumbWidthInPixel;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int calculateNumOfThumbs(int i4) {
        int roundUp = roundUp(i4 - this.mHeroThumbWidthInPixel, this.mThumbWidthInPixel + this.mMeasuredMarginInPixel);
        if (roundUp < 2) {
            roundUp = 2;
        } else if ((roundUp & 1) != 0) {
            roundUp++;
        }
        return roundUp + 1;
    }

    private static int roundUp(int i4, int i5) {
        return ((i4 + i5) - 1) / i5;
    }

    private void setNumberOfThumbsInternal() {
        while (getChildCount() > this.mNumOfThumbs) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.mNumOfThumbs) {
            addView(createThumbView(this), new LinearLayout.LayoutParams(this.mThumbWidthInPixel, this.mThumbHeightInPixel));
        }
        int heroIndex = getHeroIndex();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i4) {
                layoutParams.width = this.mHeroThumbWidthInPixel;
                layoutParams.height = this.mHeroThumbHeightInPixel;
            } else {
                layoutParams.width = this.mThumbWidthInPixel;
                layoutParams.height = this.mThumbHeightInPixel;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void clearThumbBitmaps() {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            setThumbBitmap(i4, (Bitmap) null);
        }
        this.mBitmaps.clear();
    }

    /* access modifiers changed from: protected */
    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public Bitmap getThumbBitmap(int i4) {
        return this.mBitmaps.get(i4);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int width2 = (getWidth() / 2) + (childAt.getMeasuredWidth() / 2);
        childAt.layout(width, getPaddingTop(), width2, getPaddingTop() + childAt.getMeasuredHeight());
        int paddingTop = getPaddingTop() + (childAt.getMeasuredHeight() / 2);
        for (int i8 = heroIndex - 1; i8 >= 0; i8--) {
            int i9 = width - this.mMeasuredMarginInPixel;
            View childAt2 = getChildAt(i8);
            childAt2.layout(i9 - childAt2.getMeasuredWidth(), paddingTop - (childAt2.getMeasuredHeight() / 2), i9, (childAt2.getMeasuredHeight() / 2) + paddingTop);
            width = i9 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex < this.mNumOfThumbs) {
                int i10 = width2 + this.mMeasuredMarginInPixel;
                View childAt3 = getChildAt(heroIndex);
                childAt3.layout(i10, paddingTop - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i10, (childAt3.getMeasuredHeight() / 2) + paddingTop);
                width2 = i10 + childAt3.getMeasuredWidth();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        int calculateNumOfThumbs;
        super.onMeasure(i4, i5);
        int measuredWidth = getMeasuredWidth();
        if (!this.mIsUserSets && this.mNumOfThumbs != (calculateNumOfThumbs = calculateNumOfThumbs(measuredWidth))) {
            this.mNumOfThumbs = calculateNumOfThumbs;
            setNumberOfThumbsInternal();
        }
    }

    public void setHeroThumbSize(int i4, int i5) {
        boolean z4;
        this.mHeroThumbHeightInPixel = i5;
        this.mHeroThumbWidthInPixel = i4;
        int heroIndex = getHeroIndex();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (heroIndex == i6) {
                View childAt = getChildAt(i6);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z5 = true;
                if (layoutParams.height != i5) {
                    layoutParams.height = i5;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (layoutParams.width != i4) {
                    layoutParams.width = i4;
                } else {
                    z5 = z4;
                }
                if (z5) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setNumberOfThumbs(int i4) {
        this.mIsUserSets = true;
        this.mNumOfThumbs = i4;
        setNumberOfThumbsInternal();
    }

    public void setThumbBitmap(int i4, Bitmap bitmap) {
        this.mBitmaps.put(i4, bitmap);
        ((ImageView) getChildAt(i4)).setImageBitmap(bitmap);
    }

    public void setThumbSize(int i4, int i5) {
        boolean z4;
        this.mThumbHeightInPixel = i5;
        this.mThumbWidthInPixel = i4;
        int heroIndex = getHeroIndex();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (heroIndex != i6) {
                View childAt = getChildAt(i6);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z5 = true;
                if (layoutParams.height != i5) {
                    layoutParams.height = i5;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (layoutParams.width != i4) {
                    layoutParams.width = i4;
                } else {
                    z5 = z4;
                }
                if (z5) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setThumbSpace(int i4) {
        this.mMeasuredMarginInPixel = i4;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mNumOfThumbs = -1;
        this.mBitmaps = new SparseArray<>();
        this.mIsUserSets = false;
        this.mThumbWidthInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_width);
        this.mThumbHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_height);
        this.mHeroThumbHeightInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_width);
        this.mHeroThumbWidthInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_hero_thumbs_height);
        this.mMeasuredMarginInPixel = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_thumbs_margin);
    }
}
