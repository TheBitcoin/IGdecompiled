package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;

public final class ShadowOverlayHelper {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    float mFocusedZ;
    boolean mNeedsOverlay;
    boolean mNeedsRoundedCorner;
    boolean mNeedsShadow;
    boolean mNeedsWrapper;
    int mRoundedCornerRadius;
    int mShadowType = 1;
    float mUnfocusedZ;

    public static final class Builder {
        private boolean keepForegroundDrawable;
        private boolean needsOverlay;
        private boolean needsRoundedCorner;
        private boolean needsShadow;
        private Options options = Options.DEFAULT;
        private boolean preferZOrder = true;

        public ShadowOverlayHelper build(Context context) {
            boolean z4;
            boolean z5;
            ShadowOverlayHelper shadowOverlayHelper = new ShadowOverlayHelper();
            shadowOverlayHelper.mNeedsOverlay = this.needsOverlay;
            boolean z6 = false;
            if (!this.needsRoundedCorner || !ShadowOverlayHelper.supportsRoundedCorner()) {
                z4 = false;
            } else {
                z4 = true;
            }
            shadowOverlayHelper.mNeedsRoundedCorner = z4;
            if (!this.needsShadow || !ShadowOverlayHelper.supportsShadow()) {
                z5 = false;
            } else {
                z5 = true;
            }
            shadowOverlayHelper.mNeedsShadow = z5;
            if (shadowOverlayHelper.mNeedsRoundedCorner) {
                shadowOverlayHelper.setupRoundedCornerRadius(this.options, context);
            }
            if (!shadowOverlayHelper.mNeedsShadow) {
                shadowOverlayHelper.mShadowType = 1;
                if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                    z6 = true;
                }
                shadowOverlayHelper.mNeedsWrapper = z6;
                return shadowOverlayHelper;
            } else if (!this.preferZOrder || !ShadowOverlayHelper.supportsDynamicShadow()) {
                shadowOverlayHelper.mShadowType = 2;
                shadowOverlayHelper.mNeedsWrapper = true;
                return shadowOverlayHelper;
            } else {
                shadowOverlayHelper.mShadowType = 3;
                shadowOverlayHelper.setupDynamicShadowZ(this.options, context);
                if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                    z6 = true;
                }
                shadowOverlayHelper.mNeedsWrapper = z6;
                return shadowOverlayHelper;
            }
        }

        public Builder keepForegroundDrawable(boolean z4) {
            this.keepForegroundDrawable = z4;
            return this;
        }

        public Builder needsOverlay(boolean z4) {
            this.needsOverlay = z4;
            return this;
        }

        public Builder needsRoundedCorner(boolean z4) {
            this.needsRoundedCorner = z4;
            return this;
        }

        public Builder needsShadow(boolean z4) {
            this.needsShadow = z4;
            return this;
        }

        public Builder options(Options options2) {
            this.options = options2;
            return this;
        }

        public Builder preferZOrder(boolean z4) {
            this.preferZOrder = z4;
            return this;
        }
    }

    public static final class Options {
        public static final Options DEFAULT = new Options();
        private float dynamicShadowFocusedZ = -1.0f;
        private float dynamicShadowUnfocusedZ = -1.0f;
        private int roundedCornerRadius = 0;

        public Options dynamicShadowZ(float f4, float f5) {
            this.dynamicShadowUnfocusedZ = f4;
            this.dynamicShadowFocusedZ = f5;
            return this;
        }

        public final float getDynamicShadowFocusedZ() {
            return this.dynamicShadowFocusedZ;
        }

        public final float getDynamicShadowUnfocusedZ() {
            return this.dynamicShadowUnfocusedZ;
        }

        public final int getRoundedCornerRadius() {
            return this.roundedCornerRadius;
        }

        public Options roundedCornerRadius(int i4) {
            this.roundedCornerRadius = i4;
            return this;
        }
    }

    ShadowOverlayHelper() {
    }

    static Object getNoneWrapperDynamicShadowImpl(View view) {
        return view.getTag(R.id.lb_shadow_impl);
    }

    public static void setNoneWrapperOverlayColor(View view, int i4) {
        Drawable foreground = ForegroundHelper.getForeground(view);
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i4);
        } else {
            ForegroundHelper.setForeground(view, new ColorDrawable(i4));
        }
    }

    public static void setNoneWrapperShadowFocusLevel(View view, float f4) {
        setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f4);
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsForeground() {
        return ForegroundHelper.supportsForeground();
    }

    public static boolean supportsRoundedCorner() {
        return RoundedRectHelper.supportsRoundedCorner();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    public ShadowOverlayContainer createShadowOverlayContainer(Context context) {
        if (needsWrapper()) {
            return new ShadowOverlayContainer(context, this.mShadowType, this.mNeedsOverlay, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius);
        }
        throw new IllegalArgumentException();
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public boolean needsOverlay() {
        return this.mNeedsOverlay;
    }

    public boolean needsRoundedCorner() {
        return this.mNeedsRoundedCorner;
    }

    public boolean needsWrapper() {
        return this.mNeedsWrapper;
    }

    public void onViewCreated(View view) {
        if (needsWrapper()) {
            return;
        }
        if (!this.mNeedsShadow) {
            if (this.mNeedsRoundedCorner) {
                RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
            }
        } else if (this.mShadowType == 3) {
            view.setTag(R.id.lb_shadow_impl, ShadowHelper.addDynamicShadow(view, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius));
        } else if (this.mNeedsRoundedCorner) {
            RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
        }
    }

    public void prepareParentForShadow(ViewGroup viewGroup) {
        if (this.mShadowType == 2) {
            StaticShadowHelper.prepareParent(viewGroup);
        }
    }

    public void setOverlayColor(View view, int i4) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setOverlayColor(i4);
        } else {
            setNoneWrapperOverlayColor(view, i4);
        }
    }

    public void setShadowFocusLevel(View view, float f4) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setShadowFocusLevel(f4);
        } else {
            setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setupDynamicShadowZ(Options options, Context context) {
        if (options.getDynamicShadowUnfocusedZ() < 0.0f) {
            Resources resources = context.getResources();
            this.mFocusedZ = resources.getDimension(R.dimen.lb_material_shadow_focused_z);
            this.mUnfocusedZ = resources.getDimension(R.dimen.lb_material_shadow_normal_z);
            return;
        }
        this.mFocusedZ = options.getDynamicShadowFocusedZ();
        this.mUnfocusedZ = options.getDynamicShadowUnfocusedZ();
    }

    /* access modifiers changed from: package-private */
    public void setupRoundedCornerRadius(Options options, Context context) {
        if (options.getRoundedCornerRadius() == 0) {
            this.mRoundedCornerRadius = context.getResources().getDimensionPixelSize(R.dimen.lb_rounded_rect_corner_radius);
        } else {
            this.mRoundedCornerRadius = options.getRoundedCornerRadius();
        }
    }

    static void setShadowFocusLevel(Object obj, int i4, float f4) {
        if (obj != null) {
            if (f4 < 0.0f) {
                f4 = 0.0f;
            } else if (f4 > 1.0f) {
                f4 = 1.0f;
            }
            if (i4 == 2) {
                StaticShadowHelper.setShadowFocusLevel(obj, f4);
            } else if (i4 == 3) {
                ShadowHelper.setShadowFocusLevel(obj, f4);
            }
        }
    }
}
