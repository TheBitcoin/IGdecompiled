package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
    private int mBackgroundResId = -1;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    @NonNull
    private final View mView;

    AppCompatBackgroundHelper(@NonNull View view) {
        this.mView = view;
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = backgroundTintMode;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 21) {
            if (this.mInternalBackgroundTint != null) {
                return true;
            }
            return false;
        } else if (i4 == 21) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void applySupportBackgroundTint() {
        Drawable background = this.mView.getBackground();
        if (background == null) {
            return;
        }
        if (!shouldApplyFrameworkTintUsingColorFilter() || !applyFrameworkTintUsingColorFilter(background)) {
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo, this.mView.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.mInternalBackgroundTint;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.tintDrawable(background, tintInfo2, this.mView.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i4) {
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i4, 0);
        View view = this.mView;
        ViewCompat.saveAttributeDataForStyleable(view, view.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i4, 0);
        try {
            int i5 = R.styleable.ViewBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i5)) {
                this.mBackgroundResId = obtainStyledAttributes.getResourceId(i5, -1);
                ColorStateList tintList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            int i6 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (obtainStyledAttributes.hasValue(i6)) {
                ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(i6));
            }
            int i7 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (obtainStyledAttributes.hasValue(i7)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i7, -1), (PorterDuff.Mode) null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            Throwable th2 = th;
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetBackgroundDrawable(Drawable drawable) {
        this.mBackgroundResId = -1;
        setInternalBackgroundTint((ColorStateList) null);
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: package-private */
    public void onSetBackgroundResource(int i4) {
        ColorStateList colorStateList;
        this.mBackgroundResId = i4;
        AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        if (appCompatDrawableManager != null) {
            colorStateList = appCompatDrawableManager.getTintList(this.mView.getContext(), i4);
        } else {
            colorStateList = null;
        }
        setInternalBackgroundTint(colorStateList);
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalBackgroundTint == null) {
                this.mInternalBackgroundTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalBackgroundTint = null;
        }
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportBackgroundTint();
    }

    /* access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.mBackgroundTint == null) {
            this.mBackgroundTint = new TintInfo();
        }
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportBackgroundTint();
    }
}
