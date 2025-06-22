package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressLint({"ViewConstructor"})
class EndCompoundLayout extends LinearLayout {
    @Nullable
    private final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    public EditText editText;
    /* access modifiers changed from: private */
    public final TextWatcher editTextWatcher = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            EndCompoundLayout.this.getEndIconDelegate().afterEditTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            EndCompoundLayout.this.getEndIconDelegate().beforeEditTextChanged(charSequence, i4, i5, i6);
        }
    };
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> endIconChangedListeners = new LinkedHashSet<>();
    private final EndIconDelegates endIconDelegates;
    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMinSize;
    private int endIconMode = 0;
    private View.OnLongClickListener endIconOnLongClickListener;
    @NonNull
    private ImageView.ScaleType endIconScaleType;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    @NonNull
    private final CheckableImageButton endIconView;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;
    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean hintExpanded;
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    @Nullable
    private CharSequence suffixText;
    @NonNull
    private final TextView suffixTextView;
    final TextInputLayout textInputLayout;
    @Nullable
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    private static class EndIconDelegates {
        /* access modifiers changed from: private */
        public final int customEndIconDrawableId;
        private final SparseArray<EndIconDelegate> delegates = new SparseArray<>();
        private final EndCompoundLayout endLayout;
        private final int passwordIconDrawableId;

        EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.endLayout = endCompoundLayout;
            this.customEndIconDrawableId = tintTypedArray.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.passwordIconDrawableId = tintTypedArray.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        private EndIconDelegate create(int i4) {
            if (i4 == -1) {
                return new CustomEndIconDelegate(this.endLayout);
            }
            if (i4 == 0) {
                return new NoEndIconDelegate(this.endLayout);
            }
            if (i4 == 1) {
                return new PasswordToggleEndIconDelegate(this.endLayout, this.passwordIconDrawableId);
            }
            if (i4 == 2) {
                return new ClearTextEndIconDelegate(this.endLayout);
            }
            if (i4 == 3) {
                return new DropdownMenuEndIconDelegate(this.endLayout);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i4);
        }

        /* access modifiers changed from: package-private */
        public EndIconDelegate get(int i4) {
            EndIconDelegate endIconDelegate = this.delegates.get(i4);
            if (endIconDelegate != null) {
                return endIconDelegate;
            }
            EndIconDelegate create = create(i4);
            this.delegates.append(i4, create);
            return create;
        }
    }

    EndCompoundLayout(TextInputLayout textInputLayout2, TintTypedArray tintTypedArray) {
        super(textInputLayout2.getContext());
        AnonymousClass2 r12 = new TextInputLayout.OnEditTextAttachedListener() {
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
                if (EndCompoundLayout.this.editText != textInputLayout.getEditText()) {
                    if (EndCompoundLayout.this.editText != null) {
                        EndCompoundLayout.this.editText.removeTextChangedListener(EndCompoundLayout.this.editTextWatcher);
                        if (EndCompoundLayout.this.editText.getOnFocusChangeListener() == EndCompoundLayout.this.getEndIconDelegate().getOnEditTextFocusChangeListener()) {
                            EndCompoundLayout.this.editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                        }
                    }
                    EditText unused = EndCompoundLayout.this.editText = textInputLayout.getEditText();
                    if (EndCompoundLayout.this.editText != null) {
                        EndCompoundLayout.this.editText.addTextChangedListener(EndCompoundLayout.this.editTextWatcher);
                    }
                    EndCompoundLayout.this.getEndIconDelegate().onEditTextAttached(EndCompoundLayout.this.editText);
                    EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                    endCompoundLayout.setOnFocusChangeListenersIfNeeded(endCompoundLayout.getEndIconDelegate());
                }
            }
        };
        this.onEditTextAttachedListener = r12;
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.textInputLayout = textInputLayout2;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.endIconFrame = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton createIconView = createIconView(this, from, R.id.text_input_error_icon);
        this.errorIconView = createIconView;
        CheckableImageButton createIconView2 = createIconView(frameLayout, from, R.id.text_input_end_icon);
        this.endIconView = createIconView2;
        this.endIconDelegates = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.suffixTextView = appCompatTextView;
        initErrorIconView(tintTypedArray);
        initEndIconView(tintTypedArray);
        initSuffixTextView(tintTypedArray);
        frameLayout.addView(createIconView2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(createIconView);
        textInputLayout2.addOnEditTextAttachedListener(r12);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                EndCompoundLayout.this.addTouchExplorationStateChangeListenerIfNeeded();
            }

            public void onViewDetachedFromWindow(View view) {
                EndCompoundLayout.this.removeTouchExplorationStateChangeListenerIfNeeded();
            }
        });
    }

    /* access modifiers changed from: private */
    public void addTouchExplorationStateChangeListenerIfNeeded() {
        if (this.touchExplorationStateChangeListener != null && this.accessibilityManager != null && ViewCompat.isAttachedToWindow(this)) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
        }
    }

    private CheckableImageButton createIconView(ViewGroup viewGroup, LayoutInflater layoutInflater, @IdRes int i4) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i4);
        IconHelper.setCompatRippleBackgroundIfNeeded(checkableImageButton);
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void dispatchOnEndIconChanged(int i4) {
        Iterator<TextInputLayout.OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this.textInputLayout, i4);
        }
    }

    private int getIconResId(EndIconDelegate endIconDelegate) {
        int access$500 = this.endIconDelegates.customEndIconDrawableId;
        if (access$500 == 0) {
            return endIconDelegate.getIconDrawableResId();
        }
        return access$500;
    }

    private void initEndIconView(TintTypedArray tintTypedArray) {
        int i4 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (!tintTypedArray.hasValue(i4)) {
            int i5 = R.styleable.TextInputLayout_endIconTint;
            if (tintTypedArray.hasValue(i5)) {
                this.endIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i5);
            }
            int i6 = R.styleable.TextInputLayout_endIconTintMode;
            if (tintTypedArray.hasValue(i6)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i6, -1), (PorterDuff.Mode) null);
            }
        }
        int i7 = R.styleable.TextInputLayout_endIconMode;
        if (tintTypedArray.hasValue(i7)) {
            setEndIconMode(tintTypedArray.getInt(i7, 0));
            int i8 = R.styleable.TextInputLayout_endIconContentDescription;
            if (tintTypedArray.hasValue(i8)) {
                setEndIconContentDescription(tintTypedArray.getText(i8));
            }
            setEndIconCheckable(tintTypedArray.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (tintTypedArray.hasValue(i4)) {
            int i9 = R.styleable.TextInputLayout_passwordToggleTint;
            if (tintTypedArray.hasValue(i9)) {
                this.endIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i9);
            }
            int i10 = R.styleable.TextInputLayout_passwordToggleTintMode;
            if (tintTypedArray.hasValue(i10)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i10, -1), (PorterDuff.Mode) null);
            }
            setEndIconMode(tintTypedArray.getBoolean(i4, false) ? 1 : 0);
            setEndIconContentDescription(tintTypedArray.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        }
        setEndIconMinSize(tintTypedArray.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i11 = R.styleable.TextInputLayout_endIconScaleType;
        if (tintTypedArray.hasValue(i11)) {
            setEndIconScaleType(IconHelper.convertScaleType(tintTypedArray.getInt(i11, -1)));
        }
    }

    private void initErrorIconView(TintTypedArray tintTypedArray) {
        int i4 = R.styleable.TextInputLayout_errorIconTint;
        if (tintTypedArray.hasValue(i4)) {
            this.errorIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i4);
        }
        int i5 = R.styleable.TextInputLayout_errorIconTintMode;
        if (tintTypedArray.hasValue(i5)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i5, -1), (PorterDuff.Mode) null);
        }
        int i6 = R.styleable.TextInputLayout_errorIconDrawable;
        if (tintTypedArray.hasValue(i6)) {
            setErrorIconDrawable(tintTypedArray.getDrawable(i6));
        }
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
    }

    private void initSuffixTextView(TintTypedArray tintTypedArray) {
        this.suffixTextView.setVisibility(8);
        this.suffixTextView.setId(R.id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        setSuffixTextAppearance(tintTypedArray.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        int i4 = R.styleable.TextInputLayout_suffixTextColor;
        if (tintTypedArray.hasValue(i4)) {
            setSuffixTextColor(tintTypedArray.getColorStateList(i4));
        }
        setSuffixText(tintTypedArray.getText(R.styleable.TextInputLayout_suffixText));
    }

    /* access modifiers changed from: private */
    public void removeTouchExplorationStateChangeListenerIfNeeded() {
        AccessibilityManager accessibilityManager2;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener2 = this.touchExplorationStateChangeListener;
        if (touchExplorationStateChangeListener2 != null && (accessibilityManager2 = this.accessibilityManager) != null) {
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager2, touchExplorationStateChangeListener2);
        }
    }

    /* access modifiers changed from: private */
    public void setOnFocusChangeListenersIfNeeded(EndIconDelegate endIconDelegate) {
        if (this.editText != null) {
            if (endIconDelegate.getOnEditTextFocusChangeListener() != null) {
                this.editText.setOnFocusChangeListener(endIconDelegate.getOnEditTextFocusChangeListener());
            }
            if (endIconDelegate.getOnIconViewFocusChangeListener() != null) {
                this.endIconView.setOnFocusChangeListener(endIconDelegate.getOnIconViewFocusChangeListener());
            }
        }
    }

    private void setUpDelegate(@NonNull EndIconDelegate endIconDelegate) {
        endIconDelegate.setUp();
        this.touchExplorationStateChangeListener = endIconDelegate.getTouchExplorationStateChangeListener();
        addTouchExplorationStateChangeListenerIfNeeded();
    }

    private void tearDownDelegate(@NonNull EndIconDelegate endIconDelegate) {
        removeTouchExplorationStateChangeListenerIfNeeded();
        this.touchExplorationStateChangeListener = null;
        endIconDelegate.tearDown();
    }

    private void tintEndIconOnError(boolean z4) {
        if (!z4 || getEndIconDrawable() == null) {
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            return;
        }
        Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(mutate, this.textInputLayout.getErrorCurrentTextColors());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateEndLayoutVisibility() {
        int i4;
        char c5;
        FrameLayout frameLayout = this.endIconFrame;
        int i5 = 8;
        if (this.endIconView.getVisibility() != 0 || isErrorIconVisible()) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        frameLayout.setVisibility(i4);
        if (this.suffixText == null || this.hintExpanded) {
            c5 = 8;
        } else {
            c5 = 0;
        }
        if (isEndIconVisible() || isErrorIconVisible() || c5 == 0) {
            i5 = 0;
        }
        setVisibility(i5);
    }

    private void updateErrorIconVisibility() {
        boolean z4;
        int i4 = 0;
        if (getErrorIconDrawable() == null || !this.textInputLayout.isErrorEnabled() || !this.textInputLayout.shouldShowError()) {
            z4 = false;
        } else {
            z4 = true;
        }
        CheckableImageButton checkableImageButton = this.errorIconView;
        if (!z4) {
            i4 = 8;
        }
        checkableImageButton.setVisibility(i4);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            this.textInputLayout.updateDummyDrawables();
        }
    }

    private void updateSuffixTextVisibility() {
        int i4;
        int visibility = this.suffixTextView.getVisibility();
        boolean z4 = false;
        if (this.suffixText == null || this.hintExpanded) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        if (visibility != i4) {
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            if (i4 == 0) {
                z4 = true;
            }
            endIconDelegate.onSuffixVisibilityChanged(z4);
        }
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(i4);
        this.textInputLayout.updateDummyDrawables();
    }

    /* access modifiers changed from: package-private */
    public void addOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void checkEndIcon() {
        this.endIconView.performClick();
        this.endIconView.jumpDrawablesToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CheckableImageButton getCurrentEndIconView() {
        if (isErrorIconVisible()) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public EndIconDelegate getEndIconDelegate() {
        return this.endIconDelegates.get(this.endIconMode);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public int getEndIconMinSize() {
        return this.endIconMinSize;
    }

    /* access modifiers changed from: package-private */
    public int getEndIconMode() {
        return this.endIconMode;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.endIconScaleType;
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    /* access modifiers changed from: package-private */
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public int getSuffixTextEndOffset() {
        int i4;
        if (isEndIconVisible() || isErrorIconVisible()) {
            i4 = this.endIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams());
        } else {
            i4 = 0;
        }
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.suffixTextView) + i4;
    }

    /* access modifiers changed from: package-private */
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    /* access modifiers changed from: package-private */
    public boolean hasEndIcon() {
        if (this.endIconMode != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    /* access modifiers changed from: package-private */
    public boolean isEndIconChecked() {
        if (!hasEndIcon() || !this.endIconView.isChecked()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isPasswordVisibilityToggleEnabled() {
        if (this.endIconMode == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void onHintStateChanged(boolean z4) {
        this.hintExpanded = z4;
        updateSuffixTextVisibility();
    }

    /* access modifiers changed from: package-private */
    public void onTextInputBoxStateUpdated() {
        updateErrorIconVisibility();
        refreshErrorIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError()) {
            tintEndIconOnError(this.textInputLayout.shouldShowError());
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.endIconView, this.endIconTintList);
    }

    /* access modifiers changed from: package-private */
    public void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.errorIconView, this.errorIconTintList);
    }

    /* access modifiers changed from: package-private */
    public void refreshIconState(boolean z4) {
        boolean z5;
        boolean isActivated;
        boolean isChecked;
        EndIconDelegate endIconDelegate = getEndIconDelegate();
        boolean z6 = true;
        if (!endIconDelegate.isIconCheckable() || (isChecked = this.endIconView.isChecked()) == endIconDelegate.isIconChecked()) {
            z5 = false;
        } else {
            this.endIconView.setChecked(!isChecked);
            z5 = true;
        }
        if (!endIconDelegate.isIconActivable() || (isActivated = this.endIconView.isActivated()) == endIconDelegate.isIconActivated()) {
            z6 = z5;
        } else {
            setEndIconActivated(!isActivated);
        }
        if (z4 || z6) {
            refreshEndIconDrawableState();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconActivated(boolean z4) {
        this.endIconView.setActivated(z4);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconCheckable(boolean z4) {
        this.endIconView.setCheckable(z4);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconContentDescription(@StringRes int i4) {
        setEndIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconDrawable(@DrawableRes int i4) {
        setEndIconDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconMinSize(@Px int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i4 != this.endIconMinSize) {
            this.endIconMinSize = i4;
            IconHelper.setIconMinSize(this.endIconView, i4);
            IconHelper.setIconMinSize(this.errorIconView, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconMode(int i4) {
        boolean z4;
        if (this.endIconMode != i4) {
            tearDownDelegate(getEndIconDelegate());
            int i5 = this.endIconMode;
            this.endIconMode = i4;
            dispatchOnEndIconChanged(i5);
            if (i4 != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            setEndIconVisible(z4);
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            setEndIconDrawable(getIconResId(endIconDelegate));
            setEndIconContentDescription(endIconDelegate.getIconContentDescriptionResId());
            setEndIconCheckable(endIconDelegate.isIconCheckable());
            if (endIconDelegate.isBoxBackgroundModeSupported(this.textInputLayout.getBoxBackgroundMode())) {
                setUpDelegate(endIconDelegate);
                setEndIconOnClickListener(endIconDelegate.getOnIconClickListener());
                EditText editText2 = this.editText;
                if (editText2 != null) {
                    endIconDelegate.onEditTextAttached(editText2);
                    setOnFocusChangeListenersIfNeeded(endIconDelegate);
                }
                IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
                refreshIconState(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.endIconScaleType = scaleType;
        IconHelper.setIconScaleType(this.endIconView, scaleType);
        IconHelper.setIconScaleType(this.errorIconView, scaleType);
    }

    /* access modifiers changed from: package-private */
    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, colorStateList, this.endIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconVisible(boolean z4) {
        int i4;
        if (isEndIconVisible() != z4) {
            CheckableImageButton checkableImageButton = this.endIconView;
            if (z4) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            checkableImageButton.setVisibility(i4);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            this.textInputLayout.updateDummyDrawables();
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconDrawable(@DrawableRes int i4) {
        setErrorIconDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
        refreshErrorIconDrawableState();
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.errorIconTintList != colorStateList) {
            this.errorIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, colorStateList, this.errorIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.errorIconTintMode != mode) {
            this.errorIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, mode);
        }
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i4) {
        setPasswordVisibilityToggleContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i4) {
        setPasswordVisibilityToggleDrawable(i4 != 0 ? AppCompatResources.getDrawable(getContext(), i4) : null);
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        if (z4 && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z4) {
            setEndIconMode(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, colorStateList, this.endIconTintMode);
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, mode);
    }

    /* access modifiers changed from: package-private */
    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.suffixText = charSequence2;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextAppearance(@StyleRes int i4) {
        TextViewCompat.setTextAppearance(this.suffixTextView, i4);
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void togglePasswordVisibilityToggle(boolean z4) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z4) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateSuffixTextViewPadding() {
        int i4;
        if (this.textInputLayout.editText != null) {
            if (isEndIconVisible() || isErrorIconVisible()) {
                i4 = 0;
            } else {
                i4 = ViewCompat.getPaddingEnd(this.textInputLayout.editText);
            }
            ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.textInputLayout.editText.getPaddingTop(), i4, this.textInputLayout.editText.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            refreshEndIconDrawableState();
        }
    }

    /* access modifiers changed from: package-private */
    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }
}
