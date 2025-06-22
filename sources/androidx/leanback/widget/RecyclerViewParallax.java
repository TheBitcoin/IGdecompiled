package androidx.leanback.widget;

import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewParallax extends Parallax<ChildPositionProperty> {
    boolean mIsVertical;
    View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            RecyclerViewParallax.this.updateValues();
        }
    };
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
            RecyclerViewParallax.this.updateValues();
        }
    };
    RecyclerView mRecylerView;

    public static final class ChildPositionProperty extends Parallax.IntProperty {
        int mAdapterPosition;
        float mFraction;
        int mOffset;
        int mViewId;

        ChildPositionProperty(String str, int i4) {
            super(str, i4);
        }

        public ChildPositionProperty adapterPosition(int i4) {
            this.mAdapterPosition = i4;
            return this;
        }

        public ChildPositionProperty fraction(float f4) {
            this.mFraction = f4;
            return this;
        }

        public int getAdapterPosition() {
            return this.mAdapterPosition;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int getViewId() {
            return this.mViewId;
        }

        public ChildPositionProperty offset(int i4) {
            this.mOffset = i4;
            return this;
        }

        /* access modifiers changed from: package-private */
        public void updateValue(RecyclerViewParallax recyclerViewParallax) {
            RecyclerView.ViewHolder viewHolder;
            RecyclerView recyclerView = recyclerViewParallax.mRecylerView;
            if (recyclerView == null) {
                viewHolder = null;
            } else {
                viewHolder = recyclerView.findViewHolderForAdapterPosition(this.mAdapterPosition);
            }
            if (viewHolder != null) {
                View findViewById = viewHolder.itemView.findViewById(this.mViewId);
                if (findViewById != null) {
                    Rect rect = new Rect(0, 0, findViewById.getWidth(), findViewById.getHeight());
                    recyclerView.offsetDescendantRectToMyCoords(findViewById, rect);
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    while (findViewById != recyclerView && findViewById != null) {
                        if (findViewById.getParent() != recyclerView || !recyclerView.isAnimating()) {
                            f4 += findViewById.getTranslationX();
                            f5 += findViewById.getTranslationY();
                        }
                        findViewById = (View) findViewById.getParent();
                    }
                    rect.offset((int) f4, (int) f5);
                    if (recyclerViewParallax.mIsVertical) {
                        recyclerViewParallax.setIntPropertyValue(getIndex(), rect.top + this.mOffset + ((int) (this.mFraction * ((float) rect.height()))));
                    } else {
                        recyclerViewParallax.setIntPropertyValue(getIndex(), rect.left + this.mOffset + ((int) (this.mFraction * ((float) rect.width()))));
                    }
                }
            } else if (recyclerView == null || recyclerView.getLayoutManager().getChildCount() == 0) {
                recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MAX_VALUE);
            } else if (recyclerView.findContainingViewHolder(recyclerView.getLayoutManager().getChildAt(0)).getAdapterPosition() < this.mAdapterPosition) {
                recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MAX_VALUE);
            } else {
                recyclerViewParallax.setIntPropertyValue(getIndex(), Integer.MIN_VALUE);
            }
        }

        public ChildPositionProperty viewId(int i4) {
            this.mViewId = i4;
            return this;
        }
    }

    public float getMaxValue() {
        int width;
        RecyclerView recyclerView = this.mRecylerView;
        if (recyclerView == null) {
            return 0.0f;
        }
        if (this.mIsVertical) {
            width = recyclerView.getHeight();
        } else {
            width = recyclerView.getWidth();
        }
        return (float) width;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecylerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecylerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(this.mOnScrollListener);
                this.mRecylerView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
            }
            this.mRecylerView = recyclerView;
            if (recyclerView != null) {
                recyclerView.getLayoutManager();
                boolean z4 = false;
                if (RecyclerView.LayoutManager.getProperties(this.mRecylerView.getContext(), (AttributeSet) null, 0, 0).orientation == 1) {
                    z4 = true;
                }
                this.mIsVertical = z4;
                this.mRecylerView.addOnScrollListener(this.mOnScrollListener);
                this.mRecylerView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
            }
        }
    }

    public void updateValues() {
        for (Property property : getProperties()) {
            ((ChildPositionProperty) property).updateValue(this);
        }
        super.updateValues();
    }

    public ChildPositionProperty createProperty(String str, int i4) {
        return new ChildPositionProperty(str, i4);
    }
}
