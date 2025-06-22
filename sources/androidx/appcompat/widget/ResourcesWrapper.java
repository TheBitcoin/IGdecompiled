package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class ResourcesWrapper extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    public XmlResourceParser getAnimation(int i4) throws Resources.NotFoundException {
        return this.mResources.getAnimation(i4);
    }

    public boolean getBoolean(int i4) throws Resources.NotFoundException {
        return this.mResources.getBoolean(i4);
    }

    public int getColor(int i4) throws Resources.NotFoundException {
        return this.mResources.getColor(i4);
    }

    public ColorStateList getColorStateList(int i4) throws Resources.NotFoundException {
        return this.mResources.getColorStateList(i4);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimension(i4);
    }

    public int getDimensionPixelOffset(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelOffset(i4);
    }

    public int getDimensionPixelSize(int i4) throws Resources.NotFoundException {
        return this.mResources.getDimensionPixelSize(i4);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int i4) throws Resources.NotFoundException {
        return this.mResources.getDrawable(i4);
    }

    /* access modifiers changed from: package-private */
    public final Drawable getDrawableCanonical(int i4) throws Resources.NotFoundException {
        return super.getDrawable(i4);
    }

    public Drawable getDrawableForDensity(int i4, int i5) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i4, i5, (Resources.Theme) null);
    }

    public float getFraction(int i4, int i5, int i6) {
        return this.mResources.getFraction(i4, i5, i6);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getIntArray(i4);
    }

    public int getInteger(int i4) throws Resources.NotFoundException {
        return this.mResources.getInteger(i4);
    }

    public XmlResourceParser getLayout(int i4) throws Resources.NotFoundException {
        return this.mResources.getLayout(i4);
    }

    public Movie getMovie(int i4) throws Resources.NotFoundException {
        return this.mResources.getMovie(i4);
    }

    public String getQuantityString(int i4, int i5, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i4, i5, objArr);
    }

    public CharSequence getQuantityText(int i4, int i5) throws Resources.NotFoundException {
        return this.mResources.getQuantityText(i4, i5);
    }

    public String getResourceEntryName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceEntryName(i4);
    }

    public String getResourceName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceName(i4);
    }

    public String getResourcePackageName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourcePackageName(i4);
    }

    public String getResourceTypeName(int i4) throws Resources.NotFoundException {
        return this.mResources.getResourceTypeName(i4);
    }

    public String getString(int i4) throws Resources.NotFoundException {
        return this.mResources.getString(i4);
    }

    public String[] getStringArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getStringArray(i4);
    }

    public CharSequence getText(int i4) throws Resources.NotFoundException {
        return this.mResources.getText(i4);
    }

    public CharSequence[] getTextArray(int i4) throws Resources.NotFoundException {
        return this.mResources.getTextArray(i4);
    }

    public void getValue(int i4, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValue(i4, typedValue, z4);
    }

    public void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValueForDensity(i4, i5, typedValue, z4);
    }

    public XmlResourceParser getXml(int i4) throws Resources.NotFoundException {
        return this.mResources.getXml(i4);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i4) throws Resources.NotFoundException {
        return this.mResources.obtainTypedArray(i4);
    }

    public InputStream openRawResource(int i4) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i4);
    }

    public AssetFileDescriptor openRawResourceFd(int i4) throws Resources.NotFoundException {
        return this.mResources.openRawResourceFd(i4);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @RequiresApi(21)
    public Drawable getDrawable(int i4, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(this.mResources, i4, theme);
    }

    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i4, int i5, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i4, i5, theme);
    }

    public String getQuantityString(int i4, int i5) throws Resources.NotFoundException {
        return this.mResources.getQuantityString(i4, i5);
    }

    public String getString(int i4, Object... objArr) throws Resources.NotFoundException {
        return this.mResources.getString(i4, objArr);
    }

    public CharSequence getText(int i4, CharSequence charSequence) {
        return this.mResources.getText(i4, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z4) throws Resources.NotFoundException {
        this.mResources.getValue(str, typedValue, z4);
    }

    public InputStream openRawResource(int i4, TypedValue typedValue) throws Resources.NotFoundException {
        return this.mResources.openRawResource(i4, typedValue);
    }
}
