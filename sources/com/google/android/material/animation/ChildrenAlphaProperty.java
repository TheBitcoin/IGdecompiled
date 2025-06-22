package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f4 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f4 != null) {
            return f4;
        }
        return Float.valueOf(1.0f);
    }

    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f4) {
        float floatValue = f4.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f4);
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            viewGroup.getChildAt(i4).setAlpha(floatValue);
        }
    }
}
