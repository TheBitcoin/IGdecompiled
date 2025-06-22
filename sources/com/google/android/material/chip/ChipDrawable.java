package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = {16842910};
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    private int alpha = 255;
    private boolean checkable;
    @Nullable
    private Drawable checkedIcon;
    @Nullable
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    @Nullable
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius = -1.0f;
    private float chipEndPadding;
    @Nullable
    private Drawable chipIcon;
    private float chipIconSize;
    @Nullable
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint = new Paint(1);
    private float chipStartPadding;
    @Nullable
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    @Nullable
    private ColorStateList chipSurfaceColor;
    @Nullable
    private Drawable closeIcon;
    @Nullable
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    @Nullable
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    @Nullable
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    @Nullable
    private ColorFilter colorFilter;
    @Nullable
    private ColorStateList compatRippleColor;
    @NonNull
    private final Context context;
    private boolean currentChecked;
    @ColorInt
    private int currentChipBackgroundColor;
    @ColorInt
    private int currentChipStrokeColor;
    @ColorInt
    private int currentChipSurfaceColor;
    @ColorInt
    private int currentCompatRippleColor;
    @ColorInt
    private int currentCompositeSurfaceBackgroundColor;
    @ColorInt
    private int currentTextColor;
    @ColorInt
    private int currentTint;
    @Nullable
    private final Paint debugPaint;
    @NonNull
    private WeakReference<Delegate> delegate = new WeakReference<>((Object) null);
    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private boolean hasChipIconTint;
    @Nullable
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF = new PointF();
    private final RectF rectF = new RectF();
    @Nullable
    private ColorStateList rippleColor;
    private final Path shapePath = new Path();
    private boolean shouldDrawText;
    @Nullable
    private MotionSpec showMotionSpec;
    @Nullable
    private CharSequence text;
    @NonNull
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    @Nullable
    private ColorStateList tint;
    @Nullable
    private PorterDuffColorFilter tintFilter;
    @Nullable
    private PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(@NonNull Context context2, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        super(context2, attributeSet, i4, i5);
        initializeElevationOverlay(context2);
        this.context = context2;
        TextDrawableHelper textDrawableHelper2 = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper2;
        this.text = "";
        textDrawableHelper2.getTextPaint().density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        setCloseIconState(iArr);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(getCloseIconState());
                }
                DrawableCompat.setTintList(drawable, this.closeIconTint);
                return;
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                DrawableCompat.setTintList(drawable2, this.chipIconTint);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private void calculateChipIconBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f4 = this.chipStartPadding + this.iconStartPadding;
            float currentChipIconWidth = getCurrentChipIconWidth();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = ((float) rect.left) + f4;
                rectF2.left = f5;
                rectF2.right = f5 + currentChipIconWidth;
            } else {
                float f6 = ((float) rect.right) - f4;
                rectF2.right = f6;
                rectF2.left = f6 - currentChipIconWidth;
            }
            float currentChipIconHeight = getCurrentChipIconHeight();
            float exactCenterY = rect.exactCenterY() - (currentChipIconHeight / 2.0f);
            rectF2.top = exactCenterY;
            rectF2.bottom = exactCenterY + currentChipIconHeight;
        }
    }

    private void calculateChipTouchBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.set(rect);
        if (showsCloseIcon()) {
            float f4 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.right = ((float) rect.right) - f4;
            } else {
                rectF2.left = ((float) rect.left) + f4;
            }
        }
    }

    private void calculateCloseIconBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f4 = this.chipEndPadding + this.closeIconEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = ((float) rect.right) - f4;
                rectF2.right = f5;
                rectF2.left = f5 - this.closeIconSize;
            } else {
                float f6 = ((float) rect.left) + f4;
                rectF2.left = f6;
                rectF2.right = f6 + this.closeIconSize;
            }
            float exactCenterY = rect.exactCenterY();
            float f7 = this.closeIconSize;
            float f8 = exactCenterY - (f7 / 2.0f);
            rectF2.top = f8;
            rectF2.bottom = f8 + f7;
        }
    }

    private void calculateCloseIconTouchBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f4 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f5 = (float) rect.right;
                rectF2.right = f5;
                rectF2.left = f5 - f4;
            } else {
                int i4 = rect.left;
                rectF2.left = (float) i4;
                rectF2.right = ((float) i4) + f4;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private void calculateTextBounds(@NonNull Rect rect, @NonNull RectF rectF2) {
        rectF2.setEmpty();
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.left = ((float) rect.left) + calculateChipIconWidth;
                rectF2.right = ((float) rect.right) - calculateCloseIconWidth;
            } else {
                rectF2.left = ((float) rect.left) + calculateCloseIconWidth;
                rectF2.right = ((float) rect.right) - calculateChipIconWidth;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        Paint.FontMetrics fontMetrics2 = this.fontMetrics;
        return (fontMetrics2.descent + fontMetrics2.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        if (!this.checkedIconVisible || this.checkedIcon == null || !this.checkable) {
            return false;
        }
        return true;
    }

    @NonNull
    public static ChipDrawable createFromAttributes(@NonNull Context context2, @Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i4, i5);
        chipDrawable.loadFromAttributes(attributeSet, i4, i5);
        return chipDrawable;
    }

    @NonNull
    public static ChipDrawable createFromResource(@NonNull Context context2, @XmlRes int i4) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context2, i4, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context2, parseDrawableXml, R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void drawCheckedIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f4 = rectF2.left;
            float f5 = rectF2.top;
            canvas.translate(f4, f5);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void drawChipBackground(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.chipPaint.setColorFilter(getTintColorFilter());
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawChipIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f4 = rectF2.left;
            float f5 = rectF2.top;
            canvas.translate(f4, f5);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f4, -f5);
        }
    }

    private void drawChipStroke(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Paint.Style.STROKE);
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColorFilter(getTintColorFilter());
            }
            RectF rectF2 = this.rectF;
            float f4 = this.chipStrokeWidth;
            rectF2.set(((float) rect.left) + (f4 / 2.0f), ((float) rect.top) + (f4 / 2.0f), ((float) rect.right) - (f4 / 2.0f), ((float) rect.bottom) - (f4 / 2.0f));
            float f5 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas.drawRoundRect(this.rectF, f5, f5, this.chipPaint);
        }
    }

    private void drawChipSurface(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipSurfaceColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawCloseIcon(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            RectF rectF2 = this.rectF;
            float f4 = rectF2.left;
            float f5 = rectF2.top;
            canvas.translate(f4, f5);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f4, -f5);
        }
    }

    private void drawCompatRipple(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            return;
        }
        calculatePathForSize(new RectF(rect), this.shapePath);
        super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(@NonNull Canvas canvas, @NonNull Rect rect) {
        Canvas canvas2;
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, ModuleDescriptor.MODULE_VERSION));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas2 = canvas;
                canvas2.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.debugPaint);
            } else {
                canvas2 = canvas;
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas2.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, ModuleDescriptor.MODULE_VERSION));
            calculateChipTouchBounds(rect, this.rectF);
            canvas2.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, ModuleDescriptor.MODULE_VERSION));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas2.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z4;
        if (this.text != null) {
            Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i4 = 0;
            if (Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width())) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                i4 = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.text;
            if (z4 && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.pointF;
            Canvas canvas2 = canvas;
            canvas2.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.textDrawableHelper.getTextPaint());
            if (z4) {
                canvas2.restoreToCount(i4);
            }
        }
    }

    private float getCurrentChipIconHeight() {
        Drawable drawable;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f4 = this.chipIconSize;
        if (f4 <= 0.0f && drawable != null) {
            f4 = (float) Math.ceil((double) ViewUtils.dpToPx(this.context, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f4) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f4;
    }

    private float getCurrentChipIconWidth() {
        Drawable drawable;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f4 = this.chipIconSize;
        if (f4 > 0.0f || drawable == null) {
            return f4;
        }
        return (float) drawable.getIntrinsicWidth();
    }

    @Nullable
    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter2 = this.colorFilter;
        if (colorFilter2 != null) {
            return colorFilter2;
        }
        return this.tintFilter;
    }

    private static boolean hasState(@Nullable int[] iArr, @AttrRes int i4) {
        if (iArr == null) {
            return false;
        }
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    private void loadFromAttributes(@Nullable AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet2, R.styleable.Chip, i4, i5, new int[0]);
        this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i6 = R.styleable.Chip_chipCornerRadius;
        if (obtainStyledAttributes.hasValue(i6)) {
            setChipCornerRadius(obtainStyledAttributes.getDimension(i6, 0.0f));
        }
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(R.styleable.Chip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, R.styleable.Chip_android_textAppearance);
        textAppearance.setTextSize(obtainStyledAttributes.getDimension(R.styleable.Chip_android_textSize, textAppearance.getTextSize()));
        if (Build.VERSION.SDK_INT < 23) {
            textAppearance.setTextColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_android_textColor));
        }
        setTextAppearance(textAppearance);
        int i7 = obtainStyledAttributes.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i7 == 1) {
            setEllipsize(TextUtils.TruncateAt.START);
        } else if (i7 == 2) {
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i7 == 3) {
            setEllipsize(TextUtils.TruncateAt.END);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (!(attributeSet2 == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "chipIconVisible") != null)) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_chipIcon));
        int i8 = R.styleable.Chip_chipIconTint;
        if (obtainStyledAttributes.hasValue(i8)) {
            setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i8));
        }
        setChipIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (!(attributeSet2 == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "closeIconVisible") != null)) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet2 == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") == null || attributeSet2.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") != null)) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, R.styleable.Chip_checkedIcon));
        int i9 = R.styleable.Chip_checkedIconTint;
        if (obtainStyledAttributes.hasValue(i9)) {
            setCheckedIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, i9));
        }
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    private void setChipSurfaceColor(@Nullable ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean showsCheckedIcon() {
        if (!this.checkedIconVisible || this.checkedIcon == null || !this.currentChecked) {
            return false;
        }
        return true;
    }

    private boolean showsChipIcon() {
        if (!this.chipIconVisible || this.chipIcon == null) {
            return false;
        }
        return true;
    }

    private boolean showsCloseIcon() {
        if (!this.closeIconVisible || this.closeIcon == null) {
            return false;
        }
        return true;
    }

    private void unapplyChildDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void updateCompatRippleColor() {
        ColorStateList colorStateList;
        if (this.useCompatRipple) {
            colorStateList = RippleUtils.sanitizeRippleDrawableColor(this.rippleColor);
        } else {
            colorStateList = null;
        }
        this.compatRippleColor = colorStateList;
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    /* access modifiers changed from: package-private */
    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + getCurrentChipIconWidth() + this.iconEndPadding;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Paint.Align calculateTextOriginAndAlignment(@NonNull Rect rect, @NonNull PointF pointF2) {
        pointF2.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF2.x = ((float) rect.left) + calculateChipIconWidth;
            } else {
                pointF2.x = ((float) rect.right) - calculateChipIconWidth;
                align = Paint.Align.RIGHT;
            }
            pointF2.y = ((float) rect.centerY()) - calculateTextCenterFromBaseline();
        }
        return align;
    }

    public void draw(@NonNull Canvas canvas) {
        int i4;
        Canvas canvas2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i5 = this.alpha;
            if (i5 < 255) {
                canvas2 = canvas;
                i4 = CanvasCompat.saveLayerAlpha(canvas2, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i5);
            } else {
                canvas2 = canvas;
                i4 = 0;
            }
            drawChipSurface(canvas2, bounds);
            drawChipBackground(canvas2, bounds);
            if (this.isShapeThemingEnabled) {
                super.draw(canvas2);
            }
            drawChipStroke(canvas2, bounds);
            drawCompatRipple(canvas2, bounds);
            drawChipIcon(canvas2, bounds);
            drawCheckedIcon(canvas2, bounds);
            if (this.shouldDrawText) {
                drawText(canvas2, bounds);
            }
            drawCloseIcon(canvas2, bounds);
            drawDebug(canvas2, bounds);
            if (this.alpha < 255) {
                canvas2.restoreToCount(i4);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        if (this.isShapeThemingEnabled) {
            return getTopLeftCornerResolvedSize();
        }
        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    @Nullable
    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(@NonNull RectF rectF2) {
        calculateChipTouchBounds(getBounds(), rectF2);
    }

    @Nullable
    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    @NonNull
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(@NonNull RectF rectF2) {
        calculateCloseIconTouchBounds(getBounds(), rectF2);
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        Outline outline2;
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
            outline2 = outline;
        } else {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline2.setAlpha(((float) getAlpha()) / 255.0f);
    }

    @Nullable
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    /* access modifiers changed from: package-private */
    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    public boolean isStateful() {
        if (isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor)) {
            return true;
        }
        return (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    public boolean onLayoutDirectionChanged(int i4) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i4);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.chipIcon, i4);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.checkedIcon, i4);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.closeIcon, i4);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i4) {
        boolean onLevelChange = super.onLevelChange(i4);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i4);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i4);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i4);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    /* access modifiers changed from: protected */
    public void onSizeChange() {
        Delegate delegate2 = this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    public void setAlpha(int i4) {
        if (this.alpha != i4) {
            this.alpha = i4;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z4) {
        if (this.checkable != z4) {
            this.checkable = z4;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z4 && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(@BoolRes int i4) {
        setCheckable(this.context.getResources().getBoolean(i4));
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z4) {
        setCheckedIconVisible(z4);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i4) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i4));
    }

    public void setCheckedIconResource(@DrawableRes int i4) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, i4));
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                DrawableCompat.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i4) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, i4));
    }

    public void setCheckedIconVisible(@BoolRes int i4) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i4));
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i4) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i4));
    }

    @Deprecated
    public void setChipCornerRadius(float f4) {
        if (this.chipCornerRadius != f4) {
            this.chipCornerRadius = f4;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f4));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i4) {
        setChipCornerRadius(this.context.getResources().getDimension(i4));
    }

    public void setChipEndPadding(float f4) {
        if (this.chipEndPadding != f4) {
            this.chipEndPadding = f4;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i4) {
        setChipEndPadding(this.context.getResources().getDimension(i4));
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable chipIcon2 = getChipIcon();
        if (chipIcon2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.chipIcon = drawable2;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z4) {
        setChipIconVisible(z4);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i4) {
        setChipIconVisible(i4);
    }

    public void setChipIconResource(@DrawableRes int i4) {
        setChipIcon(AppCompatResources.getDrawable(this.context, i4));
    }

    public void setChipIconSize(float f4) {
        if (this.chipIconSize != f4) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f4;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(@DimenRes int i4) {
        setChipIconSize(this.context.getResources().getDimension(i4));
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(@ColorRes int i4) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, i4));
    }

    public void setChipIconVisible(@BoolRes int i4) {
        setChipIconVisible(this.context.getResources().getBoolean(i4));
    }

    public void setChipMinHeight(float f4) {
        if (this.chipMinHeight != f4) {
            this.chipMinHeight = f4;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(@DimenRes int i4) {
        setChipMinHeight(this.context.getResources().getDimension(i4));
    }

    public void setChipStartPadding(float f4) {
        if (this.chipStartPadding != f4) {
            this.chipStartPadding = f4;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i4) {
        setChipStartPadding(this.context.getResources().getDimension(i4));
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i4) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i4));
    }

    public void setChipStrokeWidth(float f4) {
        if (this.chipStrokeWidth != f4) {
            this.chipStrokeWidth = f4;
            this.chipPaint.setStrokeWidth(f4);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f4);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i4) {
        setChipStrokeWidth(this.context.getResources().getDimension(i4));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            if (drawable != null) {
                drawable2 = DrawableCompat.wrap(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.closeIcon = drawable2;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z4) {
        setCloseIconVisible(z4);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i4) {
        setCloseIconVisible(i4);
    }

    public void setCloseIconEndPadding(float f4) {
        if (this.closeIconEndPadding != f4) {
            this.closeIconEndPadding = f4;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i4) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i4));
    }

    public void setCloseIconResource(@DrawableRes int i4) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, i4));
    }

    public void setCloseIconSize(float f4) {
        if (this.closeIconSize != f4) {
            this.closeIconSize = f4;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i4) {
        setCloseIconSize(this.context.getResources().getDimension(i4));
    }

    public void setCloseIconStartPadding(float f4) {
        if (this.closeIconStartPadding != f4) {
            this.closeIconStartPadding = f4;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i4) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i4));
    }

    public boolean setCloseIconState(@NonNull int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(@ColorRes int i4) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, i4));
    }

    public void setCloseIconVisible(@BoolRes int i4) {
        setCloseIconVisible(this.context.getResources().getBoolean(i4));
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setDelegate(@Nullable Delegate delegate2) {
        this.delegate = new WeakReference<>(delegate2);
    }

    public void setEllipsize(@Nullable TextUtils.TruncateAt truncateAt2) {
        this.truncateAt = truncateAt2;
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i4) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, i4));
    }

    public void setIconEndPadding(float f4) {
        if (this.iconEndPadding != f4) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f4;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i4) {
        setIconEndPadding(this.context.getResources().getDimension(i4));
    }

    public void setIconStartPadding(float f4) {
        if (this.iconStartPadding != f4) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f4;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i4) {
        setIconStartPadding(this.context.getResources().getDimension(i4));
    }

    public void setMaxWidth(@Px int i4) {
        this.maxWidth = i4;
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(@ColorRes int i4) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, i4));
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawText(boolean z4) {
        this.shouldDrawText = z4;
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i4) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, i4));
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.setTextWidthDirty(true);
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(@Nullable TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public void setTextAppearanceResource(@StyleRes int i4) {
        setTextAppearance(new TextAppearance(this.context, i4));
    }

    public void setTextColor(@ColorInt int i4) {
        setTextColor(ColorStateList.valueOf(i4));
    }

    public void setTextEndPadding(float f4) {
        if (this.textEndPadding != f4) {
            this.textEndPadding = f4;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i4) {
        setTextEndPadding(this.context.getResources().getDimension(i4));
    }

    public void setTextResource(@StringRes int i4) {
        setText(this.context.getResources().getString(i4));
    }

    public void setTextSize(@Dimension float f4) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextSize(f4);
            this.textDrawableHelper.getTextPaint().setTextSize(f4);
            onTextSizeChange();
        }
    }

    public void setTextStartPadding(float f4) {
        if (this.textStartPadding != f4) {
            this.textStartPadding = f4;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i4) {
        setTextStartPadding(this.context.getResources().getDimension(i4));
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z4) {
        if (this.useCompatRipple != z4) {
            this.useCompatRipple = z4;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z4, z5);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z4, z5);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void setCheckedIconVisible(boolean z4) {
        if (this.checkedIconVisible != z4) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z4;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipIconVisible(boolean z4) {
        if (this.chipIconVisible != z4) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z4;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setCloseIconVisible(boolean z4) {
        if (this.closeIconVisible != z4) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z4;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextColor(colorStateList);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onStateChange(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            r6 = this;
            boolean r0 = super.onStateChange(r7)
            android.content.res.ColorStateList r1 = r6.chipSurfaceColor
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r6.currentChipSurfaceColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r1 = r6.compositeElevationOverlayIfNeeded(r1)
            int r3 = r6.currentChipSurfaceColor
            r4 = 1
            if (r3 == r1) goto L_0x001d
            r6.currentChipSurfaceColor = r1
            r0 = 1
        L_0x001d:
            android.content.res.ColorStateList r3 = r6.chipBackgroundColor
            if (r3 == 0) goto L_0x0028
            int r5 = r6.currentChipBackgroundColor
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            int r3 = r6.compositeElevationOverlayIfNeeded(r3)
            int r5 = r6.currentChipBackgroundColor
            if (r5 == r3) goto L_0x0034
            r6.currentChipBackgroundColor = r3
            r0 = 1
        L_0x0034:
            int r1 = com.google.android.material.color.MaterialColors.layer(r1, r3)
            int r3 = r6.currentCompositeSurfaceBackgroundColor
            if (r3 == r1) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            android.content.res.ColorStateList r5 = r6.getFillColor()
            if (r5 != 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x0055
            r6.currentCompositeSurfaceBackgroundColor = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r6.setFillColor(r0)
            r0 = 1
        L_0x0055:
            android.content.res.ColorStateList r1 = r6.chipStrokeColor
            if (r1 == 0) goto L_0x0060
            int r3 = r6.currentChipStrokeColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            int r3 = r6.currentChipStrokeColor
            if (r3 == r1) goto L_0x0068
            r6.currentChipStrokeColor = r1
            r0 = 1
        L_0x0068:
            android.content.res.ColorStateList r1 = r6.compatRippleColor
            if (r1 == 0) goto L_0x007b
            boolean r1 = com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(r7)
            if (r1 == 0) goto L_0x007b
            android.content.res.ColorStateList r1 = r6.compatRippleColor
            int r3 = r6.currentCompatRippleColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            int r3 = r6.currentCompatRippleColor
            if (r3 == r1) goto L_0x0087
            r6.currentCompatRippleColor = r1
            boolean r1 = r6.useCompatRipple
            if (r1 == 0) goto L_0x0087
            r0 = 1
        L_0x0087:
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            if (r1 == 0) goto L_0x00ac
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            android.content.res.ColorStateList r1 = r1.getTextColor()
            if (r1 == 0) goto L_0x00ac
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            android.content.res.ColorStateList r1 = r1.getTextColor()
            int r3 = r6.currentTextColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            int r3 = r6.currentTextColor
            if (r3 == r1) goto L_0x00b4
            r6.currentTextColor = r1
            r0 = 1
        L_0x00b4:
            int[] r1 = r6.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = hasState(r1, r3)
            if (r1 == 0) goto L_0x00c7
            boolean r1 = r6.checkable
            if (r1 == 0) goto L_0x00c7
            r1 = 1
            goto L_0x00c8
        L_0x00c7:
            r1 = 0
        L_0x00c8:
            boolean r3 = r6.currentChecked
            if (r3 == r1) goto L_0x00e2
            android.graphics.drawable.Drawable r3 = r6.checkedIcon
            if (r3 == 0) goto L_0x00e2
            float r0 = r6.calculateChipIconWidth()
            r6.currentChecked = r1
            float r1 = r6.calculateChipIconWidth()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00e1
            r0 = 1
            r1 = 1
            goto L_0x00e3
        L_0x00e1:
            r0 = 1
        L_0x00e2:
            r1 = 0
        L_0x00e3:
            android.content.res.ColorStateList r3 = r6.tint
            if (r3 == 0) goto L_0x00ee
            int r5 = r6.currentTint
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x00ef
        L_0x00ee:
            r3 = 0
        L_0x00ef:
            int r5 = r6.currentTint
            if (r5 == r3) goto L_0x0100
            r6.currentTint = r3
            android.content.res.ColorStateList r0 = r6.tint
            android.graphics.PorterDuff$Mode r3 = r6.tintMode
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.drawable.DrawableUtils.updateTintFilter(r6, r0, r3)
            r6.tintFilter = r0
            goto L_0x0101
        L_0x0100:
            r4 = r0
        L_0x0101:
            android.graphics.drawable.Drawable r0 = r6.chipIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x0110
            android.graphics.drawable.Drawable r0 = r6.chipIcon
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x0110:
            android.graphics.drawable.Drawable r0 = r6.checkedIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x011f
            android.graphics.drawable.Drawable r0 = r6.checkedIcon
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x011f:
            android.graphics.drawable.Drawable r0 = r6.closeIcon
            boolean r0 = isStateful((android.graphics.drawable.Drawable) r0)
            if (r0 == 0) goto L_0x013c
            int r0 = r7.length
            int r3 = r8.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r7.length
            java.lang.System.arraycopy(r7, r2, r0, r2, r3)
            int r7 = r7.length
            int r3 = r8.length
            java.lang.System.arraycopy(r8, r2, r0, r7, r3)
            android.graphics.drawable.Drawable r7 = r6.closeIcon
            boolean r7 = r7.setState(r0)
            r4 = r4 | r7
        L_0x013c:
            boolean r7 = com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE
            if (r7 == 0) goto L_0x014f
            android.graphics.drawable.Drawable r7 = r6.closeIconRipple
            boolean r7 = isStateful((android.graphics.drawable.Drawable) r7)
            if (r7 == 0) goto L_0x014f
            android.graphics.drawable.Drawable r7 = r6.closeIconRipple
            boolean r7 = r7.setState(r8)
            r4 = r4 | r7
        L_0x014f:
            if (r4 == 0) goto L_0x0154
            r6.invalidateSelf()
        L_0x0154:
            if (r1 == 0) goto L_0x0159
            r6.onSizeChange()
        L_0x0159:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.onStateChange(int[], int[]):boolean");
    }

    private static boolean isStateful(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(@Nullable TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.getTextColor() == null || !textAppearance.getTextColor().isStateful()) ? false : true;
    }
}
