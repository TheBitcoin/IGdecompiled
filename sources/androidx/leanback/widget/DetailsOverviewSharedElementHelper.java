package androidx.leanback.widget;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import java.lang.ref.WeakReference;
import java.util.List;

final class DetailsOverviewSharedElementHelper extends SharedElementCallback {
    static final boolean DEBUG = false;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    int mRightPanelHeight;
    int mRightPanelWidth;
    private Matrix mSavedMatrix;
    private ImageView.ScaleType mSavedScaleType;
    String mSharedElementName;
    boolean mStartedPostpone;
    DetailsOverviewRowPresenter.ViewHolder mViewHolder;

    static class TransitionTimeOutRunnable implements Runnable {
        WeakReference<DetailsOverviewSharedElementHelper> mHelperRef;

        TransitionTimeOutRunnable(DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(detailsOverviewSharedElementHelper);
        }

        public void run() {
            DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (detailsOverviewSharedElementHelper != null) {
                detailsOverviewSharedElementHelper.startPostponedEnterTransition();
            }
        }
    }

    DetailsOverviewSharedElementHelper() {
    }

    private void changeImageViewScale(View view) {
        ImageView imageView = (ImageView) view;
        ImageView imageView2 = this.mViewHolder.mImageView;
        imageView2.setScaleType(imageView.getScaleType());
        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            imageView2.setImageMatrix(imageView.getImageMatrix());
        }
        updateImageViewAfterScaleTypeChange(imageView2);
    }

    private boolean hasImageViewScaleChange(View view) {
        return view instanceof ImageView;
    }

    private void restoreImageViewScale() {
        ImageView.ScaleType scaleType = this.mSavedScaleType;
        if (scaleType != null) {
            ImageView imageView = this.mViewHolder.mImageView;
            imageView.setScaleType(scaleType);
            if (this.mSavedScaleType == ImageView.ScaleType.MATRIX) {
                imageView.setImageMatrix(this.mSavedMatrix);
            }
            this.mSavedScaleType = null;
            updateImageViewAfterScaleTypeChange(imageView);
        }
    }

    private void saveImageViewScale() {
        Matrix matrix;
        if (this.mSavedScaleType == null) {
            ImageView imageView = this.mViewHolder.mImageView;
            ImageView.ScaleType scaleType = imageView.getScaleType();
            this.mSavedScaleType = scaleType;
            if (scaleType == ImageView.ScaleType.MATRIX) {
                matrix = imageView.getMatrix();
            } else {
                matrix = null;
            }
            this.mSavedMatrix = matrix;
        }
    }

    private static void updateImageViewAfterScaleTypeChange(ImageView imageView) {
        imageView.measure(View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredHeight(), 1073741824));
        imageView.layout(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
    }

    /* access modifiers changed from: package-private */
    public void onBindToDrawable(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.mViewHolder;
        if (viewHolder2 != null) {
            ViewCompat.setTransitionName(viewHolder2.mOverviewFrame, (String) null);
        }
        this.mViewHolder = viewHolder;
        viewHolder.mRightPanel.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                DetailsOverviewSharedElementHelper.this.mViewHolder.mRightPanel.removeOnLayoutChangeListener(this);
                DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = DetailsOverviewSharedElementHelper.this;
                detailsOverviewSharedElementHelper.mRightPanelWidth = detailsOverviewSharedElementHelper.mViewHolder.mRightPanel.getWidth();
                DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper2 = DetailsOverviewSharedElementHelper.this;
                detailsOverviewSharedElementHelper2.mRightPanelHeight = detailsOverviewSharedElementHelper2.mViewHolder.mRightPanel.getHeight();
            }
        });
        this.mViewHolder.mRightPanel.postOnAnimation(new Runnable() {
            public void run() {
                DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = DetailsOverviewSharedElementHelper.this;
                ViewCompat.setTransitionName(detailsOverviewSharedElementHelper.mViewHolder.mOverviewFrame, detailsOverviewSharedElementHelper.mSharedElementName);
                Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(DetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
                if (sharedElementEnterTransition != null) {
                    TransitionHelper.addTransitionListener(sharedElementEnterTransition, new TransitionListener() {
                        public void onTransitionEnd(Object obj) {
                            if (DetailsOverviewSharedElementHelper.this.mViewHolder.mActionsRow.isFocused()) {
                                DetailsOverviewSharedElementHelper.this.mViewHolder.mActionsRow.requestFocus();
                            }
                            TransitionHelper.removeTransitionListener(obj, this);
                        }
                    });
                }
                DetailsOverviewSharedElementHelper.this.startPostponedEnterTransition();
            }
        });
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() >= 1) {
            View view = list2.get(0);
            DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder != null && viewHolder.mOverviewFrame == view) {
                restoreImageViewScale();
                this.mViewHolder.mActionsRow.setDescendantFocusability(131072);
                this.mViewHolder.mActionsRow.setVisibility(0);
                this.mViewHolder.mActionsRow.setDescendantFocusability(262144);
                this.mViewHolder.mActionsRow.requestFocus();
                this.mViewHolder.mDetailsDescriptionFrame.setVisibility(0);
            }
        }
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() >= 1) {
            View view = list2.get(0);
            DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder != null && viewHolder.mOverviewFrame == view) {
                View view2 = list3.get(0);
                if (hasImageViewScaleChange(view2)) {
                    saveImageViewScale();
                    changeImageViewScale(view2);
                }
                ImageView imageView = this.mViewHolder.mImageView;
                int width = view.getWidth();
                int height = view.getHeight();
                imageView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                imageView.layout(0, 0, width, height);
                ViewGroup viewGroup = this.mViewHolder.mRightPanel;
                int i4 = this.mRightPanelWidth;
                if (i4 == 0 || this.mRightPanelHeight == 0) {
                    viewGroup.offsetLeftAndRight(width - viewGroup.getLeft());
                } else {
                    viewGroup.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mRightPanelHeight, 1073741824));
                    viewGroup.layout(width, viewGroup.getTop(), this.mRightPanelWidth + width, viewGroup.getTop() + this.mRightPanelHeight);
                }
                this.mViewHolder.mActionsRow.setVisibility(4);
                this.mViewHolder.mDetailsDescriptionFrame.setVisibility(4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setSharedElementEnterTransition(Activity activity, String str, long j4) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        } else if (activity != this.mActivityToRunTransition || !TextUtils.equals(str, this.mSharedElementName)) {
            Activity activity2 = this.mActivityToRunTransition;
            if (activity2 != null) {
                ActivityCompat.setEnterSharedElementCallback(activity2, (SharedElementCallback) null);
            }
            this.mActivityToRunTransition = activity;
            this.mSharedElementName = str;
            ActivityCompat.setEnterSharedElementCallback(activity, this);
            ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
            if (j4 > 0) {
                new Handler().postDelayed(new TransitionTimeOutRunnable(this), j4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startPostponedEnterTransition() {
        if (!this.mStartedPostpone) {
            ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
            this.mStartedPostpone = true;
        }
    }
}
