package com.google.android.material.color;

import android.os.Build;

public abstract /* synthetic */ class i {
    public static ColorResourcesOverride a() {
        int i4 = Build.VERSION.SDK_INT;
        if (30 <= i4 && i4 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i4 >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
