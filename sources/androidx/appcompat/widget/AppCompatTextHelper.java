package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight = -1;
    private int mStyle = 0;
    @NonNull
    private final TextView mView;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        @DoNotInline
        static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i4, int i5, int i6, int i7) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i4) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
        }

        @DoNotInline
        static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Typeface create(Typeface typeface, int i4, boolean z4) {
            return Typeface.create(typeface, i4, z4);
        }
    }

    AppCompatTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i4) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i4);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.mView;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                TextView textView2 = this.mView;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.mView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
        }
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i4, float f4) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i4, f4);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        boolean z4;
        boolean z5;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            int i5 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i5;
            if (i5 != -1) {
                this.mStyle &= 2;
            }
        }
        int i6 = R.styleable.TextAppearance_android_fontFamily;
        boolean z6 = true;
        if (tintTypedArray.hasValue(i6) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.mFontTypeface = null;
            int i7 = R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i7)) {
                i6 = i7;
            }
            final int i8 = this.mFontWeight;
            final int i9 = this.mStyle;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.mView);
                try {
                    Typeface font = tintTypedArray.getFont(i6, this.mStyle, new ResourcesCompat.FontCallback() {
                        public void onFontRetrievalFailed(int i4) {
                        }

                        public void onFontRetrieved(@NonNull Typeface typeface) {
                            int i4;
                            boolean z4;
                            if (Build.VERSION.SDK_INT >= 28 && (i4 = i8) != -1) {
                                if ((i9 & 2) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                typeface = Api28Impl.create(typeface, i4, z4);
                            }
                            AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
                        }
                    });
                    if (font != null) {
                        if (i4 < 28 || this.mFontWeight == -1) {
                            this.mFontTypeface = font;
                        } else {
                            Typeface create = Typeface.create(font, 0);
                            int i10 = this.mFontWeight;
                            if ((this.mStyle & 2) != 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            this.mFontTypeface = Api28Impl.create(create, i10, z5);
                        }
                    }
                    if (this.mFontTypeface == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.mAsyncFontPending = z4;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.mFontTypeface == null && (string = tintTypedArray.getString(i6)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
                    this.mFontTypeface = Typeface.create(string, this.mStyle);
                    return;
                }
                Typeface create2 = Typeface.create(string, 0);
                int i11 = this.mFontWeight;
                if ((this.mStyle & 2) == 0) {
                    z6 = false;
                }
                this.mFontTypeface = Api28Impl.create(create2, i11, z6);
                return;
            }
            return;
        }
        int i12 = R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i12)) {
            this.mAsyncFontPending = false;
            int i13 = tintTypedArray.getInt(i12, 1);
            if (i13 == 1) {
                this.mFontTypeface = Typeface.SANS_SERIF;
            } else if (i13 == 2) {
                this.mFontTypeface = Typeface.SERIF;
            } else if (i13 == 3) {
                this.mFontTypeface = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        if (!(this.mDrawableLeftTint == null && this.mDrawableTopTint == null && this.mDrawableRightTint == null && this.mDrawableBottomTint == null)) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    /* access modifiers changed from: package-private */
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    /* access modifiers changed from: package-private */
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c5  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r4 = r24
            r6 = r25
            android.widget.TextView r1 = r0.mView
            android.content.Context r8 = r1.getContext()
            androidx.appcompat.widget.AppCompatDrawableManager r9 = androidx.appcompat.widget.AppCompatDrawableManager.get()
            int[] r3 = androidx.appcompat.R.styleable.AppCompatTextHelper
            r10 = 0
            androidx.appcompat.widget.TintTypedArray r11 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r8, r4, r3, r6, r10)
            android.widget.TextView r1 = r0.mView
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r11.getWrappedTypeArray()
            r7 = 0
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance
            r7 = -1
            int r1 = r11.getResourceId(r1, r7)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x003e
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableLeftTint = r2
        L_0x003e:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0050
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableTopTint = r2
        L_0x0050:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0062
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableRightTint = r2
        L_0x0062:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0074
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableBottomTint = r2
        L_0x0074:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0086
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableStartTint = r2
        L_0x0086:
            int r2 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r3 = r11.hasValue(r2)
            if (r3 == 0) goto L_0x0098
            int r2 = r11.getResourceId(r2, r10)
            androidx.appcompat.widget.TintInfo r2 = createTintInfo(r8, r9, r2)
            r0.mDrawableEndTint = r2
        L_0x0098:
            r11.recycle()
            android.widget.TextView r2 = r0.mView
            android.text.method.TransformationMethod r2 = r2.getTransformationMethod()
            boolean r2 = r2 instanceof android.text.method.PasswordTransformationMethod
            r3 = 26
            r5 = 23
            if (r1 == r7) goto L_0x0118
            int[] r13 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r8, (int) r1, (int[]) r13)
            if (r2 != 0) goto L_0x00bf
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r14 = r1.hasValue(r13)
            if (r14 == 0) goto L_0x00bf
            boolean r13 = r1.getBoolean(r13, r10)
            r14 = 1
            goto L_0x00c1
        L_0x00bf:
            r13 = 0
            r14 = 0
        L_0x00c1:
            r0.updateTypefaceAndStyle(r8, r1)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r5) goto L_0x00f3
            int r11 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r17 = r1.hasValue(r11)
            if (r17 == 0) goto L_0x00d5
            android.content.res.ColorStateList r11 = r1.getColorStateList(r11)
            goto L_0x00d6
        L_0x00d5:
            r11 = 0
        L_0x00d6:
            int r12 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r18 = r1.hasValue(r12)
            if (r18 == 0) goto L_0x00e3
            android.content.res.ColorStateList r12 = r1.getColorStateList(r12)
            goto L_0x00e4
        L_0x00e3:
            r12 = 0
        L_0x00e4:
            int r7 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r19 = r1.hasValue(r7)
            if (r19 == 0) goto L_0x00f1
            android.content.res.ColorStateList r7 = r1.getColorStateList(r7)
            goto L_0x00f6
        L_0x00f1:
            r7 = 0
            goto L_0x00f6
        L_0x00f3:
            r7 = 0
            r11 = 0
            r12 = 0
        L_0x00f6:
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r20 = r1.hasValue(r5)
            if (r20 == 0) goto L_0x0103
            java.lang.String r5 = r1.getString(r5)
            goto L_0x0104
        L_0x0103:
            r5 = 0
        L_0x0104:
            if (r15 < r3) goto L_0x0113
            int r15 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r20 = r1.hasValue(r15)
            if (r20 == 0) goto L_0x0113
            java.lang.String r15 = r1.getString(r15)
            goto L_0x0114
        L_0x0113:
            r15 = 0
        L_0x0114:
            r1.recycle()
            goto L_0x011f
        L_0x0118:
            r5 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x011f:
            int[] r1 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r8, r4, r1, r6, r10)
            if (r2 != 0) goto L_0x0134
            int r3 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r21 = r1.hasValue(r3)
            if (r21 == 0) goto L_0x0134
            boolean r13 = r1.getBoolean(r3, r10)
            r14 = 1
        L_0x0134:
            int r3 = android.os.Build.VERSION.SDK_INT
            r10 = 23
            if (r3 >= r10) goto L_0x015e
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x0146
            android.content.res.ColorStateList r11 = r1.getColorStateList(r10)
        L_0x0146:
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x0152
            android.content.res.ColorStateList r12 = r1.getColorStateList(r10)
        L_0x0152:
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x015e
            android.content.res.ColorStateList r7 = r1.getColorStateList(r10)
        L_0x015e:
            int r10 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x016a
            java.lang.String r5 = r1.getString(r10)
        L_0x016a:
            r10 = 26
            if (r3 < r10) goto L_0x017a
            int r10 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x017a
            java.lang.String r15 = r1.getString(r10)
        L_0x017a:
            r10 = 28
            if (r3 < r10) goto L_0x019c
            int r10 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r19 = r1.hasValue(r10)
            if (r19 == 0) goto L_0x019c
            r19 = r2
            r2 = -1
            int r10 = r1.getDimensionPixelSize(r10, r2)
            if (r10 != 0) goto L_0x0199
            android.widget.TextView r2 = r0.mView
            r10 = 0
            r20 = r14
            r14 = 0
            r2.setTextSize(r14, r10)
            goto L_0x019f
        L_0x0199:
            r20 = r14
            goto L_0x019f
        L_0x019c:
            r19 = r2
            goto L_0x0199
        L_0x019f:
            r0.updateTypefaceAndStyle(r8, r1)
            r1.recycle()
            if (r11 == 0) goto L_0x01ac
            android.widget.TextView r1 = r0.mView
            r1.setTextColor(r11)
        L_0x01ac:
            if (r12 == 0) goto L_0x01b3
            android.widget.TextView r1 = r0.mView
            r1.setHintTextColor(r12)
        L_0x01b3:
            if (r7 == 0) goto L_0x01ba
            android.widget.TextView r1 = r0.mView
            r1.setLinkTextColor(r7)
        L_0x01ba:
            if (r19 != 0) goto L_0x01c1
            if (r20 == 0) goto L_0x01c1
            r0.setAllCaps(r13)
        L_0x01c1:
            android.graphics.Typeface r1 = r0.mFontTypeface
            if (r1 == 0) goto L_0x01d7
            int r2 = r0.mFontWeight
            r7 = -1
            if (r2 != r7) goto L_0x01d2
            android.widget.TextView r2 = r0.mView
            int r7 = r0.mStyle
            r2.setTypeface(r1, r7)
            goto L_0x01d7
        L_0x01d2:
            android.widget.TextView r2 = r0.mView
            r2.setTypeface(r1)
        L_0x01d7:
            if (r15 == 0) goto L_0x01de
            android.widget.TextView r1 = r0.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setFontVariationSettings(r1, r15)
        L_0x01de:
            if (r5 == 0) goto L_0x0201
            r1 = 24
            if (r3 < r1) goto L_0x01ee
            android.widget.TextView r1 = r0.mView
            android.os.LocaleList r2 = androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.forLanguageTags(r5)
            androidx.appcompat.widget.AppCompatTextHelper.Api24Impl.setTextLocales(r1, r2)
            goto L_0x0201
        L_0x01ee:
            java.lang.String r1 = ","
            java.lang.String[] r1 = r5.split(r1)
            r16 = 0
            r1 = r1[r16]
            android.widget.TextView r2 = r0.mView
            java.util.Locale r1 = androidx.appcompat.widget.AppCompatTextHelper.Api21Impl.forLanguageTag(r1)
            r2.setTextLocale(r1)
        L_0x0201:
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            r1.loadFromAttributes(r4, r6)
            boolean r1 = androidx.appcompat.widget.ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 == 0) goto L_0x0247
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            int r1 = r1.getAutoSizeTextType()
            if (r1 == 0) goto L_0x0247
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r1 = r0.mAutoSizeTextHelper
            int[] r1 = r1.getAutoSizeTextAvailableSizes()
            int r2 = r1.length
            if (r2 <= 0) goto L_0x0247
            android.widget.TextView r2 = r0.mView
            int r2 = androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.getAutoSizeStepGranularity(r2)
            float r2 = (float) r2
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0241
            android.widget.TextView r1 = r0.mView
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r2 = r0.mAutoSizeTextHelper
            int r2 = r2.getAutoSizeMinTextSize()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r3 = r0.mAutoSizeTextHelper
            int r3 = r3.getAutoSizeMaxTextSize()
            androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper r5 = r0.mAutoSizeTextHelper
            int r5 = r5.getAutoSizeStepGranularity()
            r14 = 0
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r5, r14)
            goto L_0x0247
        L_0x0241:
            r14 = 0
            android.widget.TextView r2 = r0.mView
            androidx.appcompat.widget.AppCompatTextHelper.Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r2, r1, r14)
        L_0x0247:
            int[] r1 = androidx.appcompat.R.styleable.AppCompatTextView
            androidx.appcompat.widget.TintTypedArray r10 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes((android.content.Context) r8, (android.util.AttributeSet) r4, (int[]) r1)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat
            r2 = -1
            int r1 = r10.getResourceId(r1, r2)
            if (r1 == r2) goto L_0x025b
            android.graphics.drawable.Drawable r1 = r9.getDrawable(r8, r1)
            goto L_0x025c
        L_0x025b:
            r1 = 0
        L_0x025c:
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat
            int r3 = r10.getResourceId(r3, r2)
            if (r3 == r2) goto L_0x0269
            android.graphics.drawable.Drawable r3 = r9.getDrawable(r8, r3)
            goto L_0x026a
        L_0x0269:
            r3 = 0
        L_0x026a:
            int r4 = androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat
            int r4 = r10.getResourceId(r4, r2)
            if (r4 == r2) goto L_0x0277
            android.graphics.drawable.Drawable r4 = r9.getDrawable(r8, r4)
            goto L_0x0278
        L_0x0277:
            r4 = 0
        L_0x0278:
            int r5 = androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat
            int r5 = r10.getResourceId(r5, r2)
            if (r5 == r2) goto L_0x0285
            android.graphics.drawable.Drawable r5 = r9.getDrawable(r8, r5)
            goto L_0x0286
        L_0x0285:
            r5 = 0
        L_0x0286:
            int r6 = androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat
            int r6 = r10.getResourceId(r6, r2)
            if (r6 == r2) goto L_0x0293
            android.graphics.drawable.Drawable r6 = r9.getDrawable(r8, r6)
            goto L_0x0294
        L_0x0293:
            r6 = 0
        L_0x0294:
            int r11 = androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat
            int r11 = r10.getResourceId(r11, r2)
            if (r11 == r2) goto L_0x02a9
            android.graphics.drawable.Drawable r2 = r9.getDrawable(r8, r11)
            r22 = r6
            r6 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r22
            goto L_0x02ae
        L_0x02a9:
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = 0
        L_0x02ae:
            r0.setCompoundDrawables(r1, r2, r3, r4, r5, r6)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            boolean r2 = r10.hasValue(r1)
            if (r2 == 0) goto L_0x02c2
            android.content.res.ColorStateList r1 = r10.getColorStateList(r1)
            android.widget.TextView r2 = r0.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintList(r2, r1)
        L_0x02c2:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            boolean r2 = r10.hasValue(r1)
            if (r2 == 0) goto L_0x02da
            r2 = -1
            int r1 = r10.getInt(r1, r2)
            r3 = 0
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r1, r3)
            android.widget.TextView r3 = r0.mView
            androidx.core.widget.TextViewCompat.setCompoundDrawableTintMode(r3, r1)
            goto L_0x02db
        L_0x02da:
            r2 = -1
        L_0x02db:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r1 = r10.getDimensionPixelSize(r1, r2)
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r3 = r10.getDimensionPixelSize(r3, r2)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_lineHeight
            boolean r4 = r10.hasValue(r2)
            if (r4 == 0) goto L_0x0312
            android.util.TypedValue r4 = r10.peekValue(r2)
            if (r4 == 0) goto L_0x0309
            int r5 = r4.type
            r6 = 5
            if (r5 != r6) goto L_0x0309
            int r2 = r4.data
            int r2 = androidx.core.util.TypedValueCompat.getUnitFromComplexDimension(r2)
            int r4 = r4.data
            float r4 = android.util.TypedValue.complexToFloat(r4)
            r5 = r4
            r4 = -1
            goto L_0x0316
        L_0x0309:
            r4 = -1
            int r2 = r10.getDimensionPixelSize(r2, r4)
            float r2 = (float) r2
            r5 = r2
            r2 = -1
            goto L_0x0316
        L_0x0312:
            r4 = -1
            r2 = -1
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0316:
            r10.recycle()
            if (r1 == r4) goto L_0x0320
            android.widget.TextView r6 = r0.mView
            androidx.core.widget.TextViewCompat.setFirstBaselineToTopHeight(r6, r1)
        L_0x0320:
            if (r3 == r4) goto L_0x0327
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.TextViewCompat.setLastBaselineToBottomHeight(r1, r3)
        L_0x0327:
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0339
            if (r2 != r4) goto L_0x0334
            android.widget.TextView r1 = r0.mView
            int r2 = (int) r5
            androidx.core.widget.TextViewCompat.setLineHeight(r1, r2)
            return
        L_0x0334:
            android.widget.TextView r1 = r0.mView
            androidx.core.widget.TextViewCompat.setLineHeight(r1, r2, r5)
        L_0x0339:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView == null) {
                return;
            }
            if (textView.isAttachedToWindow()) {
                final int i4 = this.mStyle;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i4);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    /* access modifiers changed from: package-private */
    public void onSetTextAppearance(Context context, int i4) {
        String string;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i4, R.styleable.TextAppearance);
        int i5 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i5)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i5, false));
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 23) {
            int i7 = R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i7) && (colorStateList3 = obtainStyledAttributes.getColorStateList(i7)) != null) {
                this.mView.setTextColor(colorStateList3);
            }
            int i8 = R.styleable.TextAppearance_android_textColorLink;
            if (obtainStyledAttributes.hasValue(i8) && (colorStateList2 = obtainStyledAttributes.getColorStateList(i8)) != null) {
                this.mView.setLinkTextColor(colorStateList2);
            }
            int i9 = R.styleable.TextAppearance_android_textColorHint;
            if (obtainStyledAttributes.hasValue(i9) && (colorStateList = obtainStyledAttributes.getColorStateList(i9)) != null) {
                this.mView.setHintTextColor(colorStateList);
            }
        }
        int i10 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i10) && obtainStyledAttributes.getDimensionPixelSize(i10, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i6 >= 26) {
            int i11 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i11) && (string = obtainStyledAttributes.getString(i11)) != null) {
                Api26Impl.setFontVariationSettings(this.mView, string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    /* access modifiers changed from: package-private */
    public void populateSurroundingTextIfNeeded(@NonNull TextView textView, @Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllCaps(boolean z4) {
        this.mView.setAllCaps(z4);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
    }

    /* access modifiers changed from: package-private */
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i4);
    }

    /* access modifiers changed from: package-private */
    public void setCompoundDrawableTintList(@Nullable ColorStateList colorStateList) {
        boolean z4;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        tintInfo.mHasTintList = z4;
        setCompoundTints();
    }

    /* access modifiers changed from: package-private */
    public void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode mode) {
        boolean z4;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        tintInfo.mHasTintMode = z4;
        setCompoundTints();
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int i4, float f4) {
        if (!ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i4, f4);
        }
    }
}
