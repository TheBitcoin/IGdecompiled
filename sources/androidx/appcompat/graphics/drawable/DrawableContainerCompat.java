package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        BlockInvalidateCallback() {
        }

        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j4);
            }
        }

        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.mCallback;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.mCallback;
            this.mCallback = null;
            return callback;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.mCallback = callback;
            return this;
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize = false;
        int mConstantWidth;
        int mDensity;
        boolean mDither = true;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration = 0;
        int mExitFadeDuration = 0;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainerCompat mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding = false;

        DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            int i4;
            this.mOwner = drawableContainerCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else if (drawableContainerState != null) {
                resources2 = drawableContainerState.mSourceRes;
            } else {
                resources2 = null;
            }
            this.mSourceRes = resources2;
            if (drawableContainerState != null) {
                i4 = drawableContainerState.mDensity;
            } else {
                i4 = 0;
            }
            int resolveDensity = DrawableContainerCompat.resolveDensity(resources, i4);
            this.mDensity = resolveDensity;
            if (drawableContainerState != null) {
                this.mChangingConfigurations = drawableContainerState.mChangingConfigurations;
                this.mChildrenChangingConfigurations = drawableContainerState.mChildrenChangingConfigurations;
                this.mCheckedConstantState = true;
                this.mCanConstantState = true;
                this.mVariablePadding = drawableContainerState.mVariablePadding;
                this.mConstantSize = drawableContainerState.mConstantSize;
                this.mDither = drawableContainerState.mDither;
                this.mMutated = drawableContainerState.mMutated;
                this.mLayoutDirection = drawableContainerState.mLayoutDirection;
                this.mEnterFadeDuration = drawableContainerState.mEnterFadeDuration;
                this.mExitFadeDuration = drawableContainerState.mExitFadeDuration;
                this.mAutoMirrored = drawableContainerState.mAutoMirrored;
                this.mColorFilter = drawableContainerState.mColorFilter;
                this.mHasColorFilter = drawableContainerState.mHasColorFilter;
                this.mTintList = drawableContainerState.mTintList;
                this.mTintMode = drawableContainerState.mTintMode;
                this.mHasTintList = drawableContainerState.mHasTintList;
                this.mHasTintMode = drawableContainerState.mHasTintMode;
                if (drawableContainerState.mDensity == resolveDensity) {
                    if (drawableContainerState.mCheckedPadding) {
                        this.mConstantPadding = drawableContainerState.mConstantPadding != null ? new Rect(drawableContainerState.mConstantPadding) : rect;
                        this.mCheckedPadding = true;
                    }
                    if (drawableContainerState.mCheckedConstantSize) {
                        this.mConstantWidth = drawableContainerState.mConstantWidth;
                        this.mConstantHeight = drawableContainerState.mConstantHeight;
                        this.mConstantMinimumWidth = drawableContainerState.mConstantMinimumWidth;
                        this.mConstantMinimumHeight = drawableContainerState.mConstantMinimumHeight;
                        this.mCheckedConstantSize = true;
                    }
                }
                if (drawableContainerState.mCheckedOpacity) {
                    this.mOpacity = drawableContainerState.mOpacity;
                    this.mCheckedOpacity = true;
                }
                if (drawableContainerState.mCheckedStateful) {
                    this.mStateful = drawableContainerState.mStateful;
                    this.mCheckedStateful = true;
                }
                Drawable[] drawableArr = drawableContainerState.mDrawables;
                this.mDrawables = new Drawable[drawableArr.length];
                this.mNumChildren = drawableContainerState.mNumChildren;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.mDrawableFutures;
                if (sparseArray != null) {
                    this.mDrawableFutures = sparseArray.clone();
                } else {
                    this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
                }
                int i5 = this.mNumChildren;
                for (int i6 = 0; i6 < i5; i6++) {
                    Drawable drawable = drawableArr[i6];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.mDrawableFutures.put(i6, constantState);
                        } else {
                            this.mDrawables[i6] = drawableArr[i6];
                        }
                    }
                }
                return;
            }
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    this.mDrawables[this.mDrawableFutures.keyAt(i4)] = prepareDrawable(this.mDrawableFutures.valueAt(i4).newDrawable(this.mSourceRes));
                }
                this.mDrawableFutures = null;
            }
        }

        private Drawable prepareDrawable(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.setLayoutDirection(drawable, this.mLayoutDirection);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.mOwner);
            return mutate;
        }

        public final int addChild(Drawable drawable) {
            int i4 = this.mNumChildren;
            if (i4 >= this.mDrawables.length) {
                growArray(i4, i4 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.mOwner);
            this.mDrawables[i4] = drawable;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return i4;
        }

        /* access modifiers changed from: package-private */
        @RequiresApi(21)
        public final void applyTheme(Resources.Theme theme) {
            if (theme != null) {
                createAllFutures();
                int i4 = this.mNumChildren;
                Drawable[] drawableArr = this.mDrawables;
                for (int i5 = 0; i5 < i4; i5++) {
                    Drawable drawable = drawableArr[i5];
                    if (drawable != null && DrawableCompat.canApplyTheme(drawable)) {
                        DrawableCompat.applyTheme(drawableArr[i5], theme);
                        this.mChildrenChangingConfigurations |= drawableArr[i5].getChangingConfigurations();
                    }
                }
                updateDensity(Api21Impl.getResources(theme));
            }
        }

        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.mDrawableFutures.get(i5);
                    if (constantState != null && Api21Impl.canApplyTheme(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState) {
                return this.mCanConstantState;
            }
            createAllFutures();
            this.mCheckedConstantState = true;
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5].getConstantState() == null) {
                    this.mCanConstantState = false;
                    return false;
                }
            }
            this.mCanConstantState = true;
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void clearMutated() {
            this.mMutated = false;
        }

        /* access modifiers changed from: protected */
        public void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.mConstantWidth) {
                    this.mConstantWidth = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.mConstantHeight) {
                    this.mConstantHeight = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.mConstantMinimumWidth) {
                    this.mConstantMinimumWidth = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.mConstantMinimumHeight) {
                    this.mConstantMinimumHeight = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int getCapacity() {
            return this.mDrawables.length;
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final Drawable getChild(int i4) {
            int indexOfKey;
            Drawable drawable = this.mDrawables[i4];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.mDrawableFutures;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i4)) < 0) {
                return null;
            }
            Drawable prepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(indexOfKey).newDrawable(this.mSourceRes));
            this.mDrawables[i4] = prepareDrawable;
            this.mDrawableFutures.removeAt(indexOfKey);
            if (this.mDrawableFutures.size() == 0) {
                this.mDrawableFutures = null;
            }
            return prepareDrawable;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getConstantHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect rect = null;
            if (this.mVariablePadding) {
                return null;
            }
            Rect rect2 = this.mConstantPadding;
            if (rect2 != null || this.mCheckedPadding) {
                return rect2;
            }
            createAllFutures();
            Rect rect3 = new Rect();
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i6 = rect3.left;
                    if (i6 > rect.left) {
                        rect.left = i6;
                    }
                    int i7 = rect3.top;
                    if (i7 > rect.top) {
                        rect.top = i7;
                    }
                    int i8 = rect3.right;
                    if (i8 > rect.right) {
                        rect.right = i8;
                    }
                    int i9 = rect3.bottom;
                    if (i9 > rect.bottom) {
                        rect.bottom = i9;
                    }
                }
            }
            this.mCheckedPadding = true;
            this.mConstantPadding = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.mCheckedConstantSize) {
                computeConstantSize();
            }
            return this.mConstantWidth;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            int i4;
            if (this.mCheckedOpacity) {
                return this.mOpacity;
            }
            createAllFutures();
            int i5 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            if (i5 > 0) {
                i4 = drawableArr[0].getOpacity();
            } else {
                i4 = -2;
            }
            for (int i6 = 1; i6 < i5; i6++) {
                i4 = Drawable.resolveOpacity(i4, drawableArr[i6].getOpacity());
            }
            this.mOpacity = i4;
            this.mCheckedOpacity = true;
            return i4;
        }

        public void growArray(int i4, int i5) {
            Drawable[] drawableArr = new Drawable[i5];
            Drawable[] drawableArr2 = this.mDrawables;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i4);
            }
            this.mDrawables = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful) {
                return this.mStateful;
            }
            createAllFutures();
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            boolean z4 = false;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                } else if (drawableArr[i5].isStateful()) {
                    z4 = true;
                    break;
                } else {
                    i5++;
                }
            }
            this.mStateful = z4;
            this.mCheckedStateful = true;
            return z4;
        }

        /* access modifiers changed from: package-private */
        public void mutate() {
            int i4 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.mMutated = true;
        }

        public final void setConstantSize(boolean z4) {
            this.mConstantSize = z4;
        }

        public final void setEnterFadeDuration(int i4) {
            this.mEnterFadeDuration = i4;
        }

        public final void setExitFadeDuration(int i4) {
            this.mExitFadeDuration = i4;
        }

        /* access modifiers changed from: package-private */
        public final boolean setLayoutDirection(int i4, int i5) {
            boolean z4;
            int i6 = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            boolean z5 = false;
            for (int i7 = 0; i7 < i6; i7++) {
                Drawable drawable = drawableArr[i7];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z4 = DrawableCompat.setLayoutDirection(drawable, i4);
                    } else {
                        z4 = false;
                    }
                    if (i7 == i5) {
                        z5 = z4;
                    }
                }
            }
            this.mLayoutDirection = i4;
            return z5;
        }

        public final void setVariablePadding(boolean z4) {
            this.mVariablePadding = z4;
        }

        /* access modifiers changed from: package-private */
        public final void updateDensity(Resources resources) {
            if (resources != null) {
                this.mSourceRes = resources;
                int resolveDensity = DrawableContainerCompat.resolveDensity(resources, this.mDensity);
                int i4 = this.mDensity;
                this.mDensity = resolveDensity;
                if (i4 != resolveDensity) {
                    this.mCheckedConstantSize = false;
                    this.mCheckedPadding = false;
                }
            }
        }
    }

    private void initializeDrawableForDisplay(Drawable drawable) {
        if (this.mBlockInvalidateCallback == null) {
            this.mBlockInvalidateCallback = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.mBlockInvalidateCallback.wrap(drawable.getCallback()));
        try {
            if (this.mDrawableContainerState.mEnterFadeDuration <= 0 && this.mHasAlpha) {
                drawable.setAlpha(this.mAlpha);
            }
            DrawableContainerState drawableContainerState = this.mDrawableContainerState;
            if (drawableContainerState.mHasColorFilter) {
                drawable.setColorFilter(drawableContainerState.mColorFilter);
            } else {
                if (drawableContainerState.mHasTintList) {
                    DrawableCompat.setTintList(drawable, drawableContainerState.mTintList);
                }
                DrawableContainerState drawableContainerState2 = this.mDrawableContainerState;
                if (drawableContainerState2.mHasTintMode) {
                    DrawableCompat.setTintMode(drawable, drawableContainerState2.mTintMode);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.mDrawableContainerState.mDither);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            }
            DrawableCompat.setAutoMirrored(drawable, this.mDrawableContainerState.mAutoMirrored);
            Rect rect = this.mHotspotBounds;
            if (rect != null) {
                DrawableCompat.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
        } catch (Throwable th) {
            drawable.setCallback(this.mBlockInvalidateCallback.unwrap());
            throw th;
        }
    }

    private boolean needsMirroring() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    static int resolveDensity(@Nullable Resources resources, int i4) {
        if (resources != null) {
            i4 = resources.getDisplayMetrics().densityDpi;
        }
        if (i4 == 0) {
            return 160;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void animate(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.mHasAlpha = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.mCurrDrawable
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.mEnterAnimationEnd
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.mAlpha
            r3.setAlpha(r9)
            r13.mEnterAnimationEnd = r6
            goto L_0x003a
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r9 = r13.mDrawableContainerState
            int r9 = r9.mEnterFadeDuration
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.mAlpha
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.mEnterAnimationEnd = r6
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.mLastDrawable
            if (r9 == 0) goto L_0x0065
            long r10 = r13.mExitAnimationEnd
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0052
            r9.setVisible(r8, r8)
            r0 = 0
            r13.mLastDrawable = r0
            r13.mExitAnimationEnd = r6
            goto L_0x0067
        L_0x0052:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.mDrawableContainerState
            int r4 = r4.mExitFadeDuration
            int r3 = r3 / r4
            int r4 = r13.mAlpha
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.mExitAnimationEnd = r6
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.mAnimationRunnable
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.animate(boolean):void");
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    /* access modifiers changed from: package-private */
    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    /* access modifiers changed from: package-private */
    public DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.mDrawableContainerState.canConstantState()) {
            return null;
        }
        this.mDrawableContainerState.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    /* access modifiers changed from: package-private */
    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize()) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.mDrawableContainerState.getOpacity();
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            Api21Impl.getOutline(drawable, outline);
        }
    }

    public boolean getPadding(@NonNull Rect rect) {
        boolean z4;
        Rect constantPadding = this.mDrawableContainerState.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            if ((constantPadding.right | constantPadding.left | constantPadding.top | constantPadding.bottom) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                z4 = drawable.getPadding(rect);
            } else {
                z4 = super.getPadding(rect);
            }
        }
        if (needsMirroring()) {
            int i4 = rect.left;
            rect.left = rect.right;
            rect.right = i4;
        }
        return z4;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState != null) {
            drawableContainerState.invalidateCache();
        }
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        boolean z4;
        Drawable drawable = this.mLastDrawable;
        boolean z5 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.mLastDrawable = null;
            z4 = true;
        } else {
            z4 = false;
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.mHasAlpha) {
                this.mCurrDrawable.setAlpha(this.mAlpha);
            }
        }
        if (this.mExitAnimationEnd != 0) {
            this.mExitAnimationEnd = 0;
            z4 = true;
        }
        if (this.mEnterAnimationEnd != 0) {
            this.mEnterAnimationEnd = 0;
        } else {
            z5 = z4;
        }
        if (z5) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            DrawableContainerState cloneConstantState = cloneConstantState();
            cloneConstantState.mutate();
            setConstantState(cloneConstantState);
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i4) {
        return this.mDrawableContainerState.setLayoutDirection(i4, getCurrentIndex());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i4) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setLevel(i4);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(i4);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j4);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean selectDrawable(int r10) {
        /*
            r9 = this;
            int r0 = r9.mCurIndex
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r0 = r0.mExitFadeDuration
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.mLastDrawable
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0029
            r9.mLastDrawable = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r0 = r0.mExitFadeDuration
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.mExitAnimationEnd = r0
            goto L_0x0035
        L_0x0029:
            r9.mLastDrawable = r4
            r9.mExitAnimationEnd = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.mCurrDrawable
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.mDrawableContainerState
            int r1 = r0.mNumChildren
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.getChild(r10)
            r9.mCurrDrawable = r0
            r9.mCurIndex = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.mDrawableContainerState
            int r10 = r10.mEnterFadeDuration
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.mEnterAnimationEnd = r2
        L_0x0051:
            r9.initializeDrawableForDisplay(r0)
            goto L_0x005a
        L_0x0055:
            r9.mCurrDrawable = r4
            r10 = -1
            r9.mCurIndex = r10
        L_0x005a:
            long r0 = r9.mEnterAnimationEnd
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.mExitAnimationEnd
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r0 = r9.mAnimationRunnable
            if (r0 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r0 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r0.<init>()
            r9.mAnimationRunnable = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.animate(r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.selectDrawable(int):boolean");
    }

    public void setAlpha(int i4) {
        if (!this.mHasAlpha || this.mAlpha != i4) {
            this.mHasAlpha = true;
            this.mAlpha = i4;
            Drawable drawable = this.mCurrDrawable;
            if (drawable == null) {
                return;
            }
            if (this.mEnterAnimationEnd == 0) {
                drawable.setAlpha(i4);
            } else {
                animate(false);
            }
        }
    }

    public void setAutoMirrored(boolean z4) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mAutoMirrored != z4) {
            drawableContainerState.mAutoMirrored = z4;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z4);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasColorFilter = true;
        if (drawableContainerState.mColorFilter != colorFilter) {
            drawableContainerState.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setConstantState(DrawableContainerState drawableContainerState) {
        this.mDrawableContainerState = drawableContainerState;
        int i4 = this.mCurIndex;
        if (i4 >= 0) {
            Drawable child = drawableContainerState.getChild(i4);
            this.mCurrDrawable = child;
            if (child != null) {
                initializeDrawableForDisplay(child);
            }
        }
        this.mLastDrawable = null;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentIndex(int i4) {
        selectDrawable(i4);
    }

    public void setDither(boolean z4) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        if (drawableContainerState.mDither != z4) {
            drawableContainerState.mDither = z4;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z4);
            }
        }
    }

    public void setEnterFadeDuration(int i4) {
        this.mDrawableContainerState.mEnterFadeDuration = i4;
    }

    public void setExitFadeDuration(int i4) {
        this.mDrawableContainerState.mExitFadeDuration = i4;
    }

    public void setHotspot(float f4, float f5) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f4, f5);
        }
    }

    public void setHotspotBounds(int i4, int i5, int i6, int i7) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = new Rect(i4, i5, i6, i7);
        } else {
            rect.set(i4, i5, i6, i7);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i4, i5, i6, i7);
        }
    }

    public void setTint(@ColorInt int i4) {
        setTintList(ColorStateList.valueOf(i4));
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintList = true;
        if (drawableContainerState.mTintList != colorStateList) {
            drawableContainerState.mTintList = colorStateList;
            DrawableCompat.setTintList(this.mCurrDrawable, colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.mDrawableContainerState;
        drawableContainerState.mHasTintMode = true;
        if (drawableContainerState.mTintMode != mode) {
            drawableContainerState.mTintMode = mode;
            DrawableCompat.setTintMode(this.mCurrDrawable, mode);
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        Drawable drawable = this.mLastDrawable;
        if (drawable != null) {
            drawable.setVisible(z4, z5);
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(z4, z5);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.mCurrDrawable && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateDensity(Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }
}
