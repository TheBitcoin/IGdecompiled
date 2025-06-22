package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;

public final class ColorFilterCache {
    private static final SparseArray<ColorFilterCache> sColorToFiltersMap = new SparseArray<>();
    private final PorterDuffColorFilter[] mFilters = new PorterDuffColorFilter[256];

    private ColorFilterCache(int i4, int i5, int i6) {
        for (int i7 = 0; i7 <= 255; i7++) {
            this.mFilters[i7] = new PorterDuffColorFilter(Color.argb(i7, i4, i5, i6), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i4) {
        int red = Color.red(i4);
        int green = Color.green(i4);
        int blue = Color.blue(i4);
        int rgb = Color.rgb(red, green, blue);
        SparseArray<ColorFilterCache> sparseArray = sColorToFiltersMap;
        ColorFilterCache colorFilterCache = sparseArray.get(rgb);
        if (colorFilterCache != null) {
            return colorFilterCache;
        }
        ColorFilterCache colorFilterCache2 = new ColorFilterCache(red, green, blue);
        sparseArray.put(rgb, colorFilterCache2);
        return colorFilterCache2;
    }

    public ColorFilter getFilterForLevel(float f4) {
        if (f4 < 0.0f || ((double) f4) > 1.0d) {
            return null;
        }
        return this.mFilters[(int) (f4 * 255.0f)];
    }
}
