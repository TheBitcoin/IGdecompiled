package androidx.window.layout;

import S2.C1601o;
import androidx.annotation.RestrictTo;
import d3.l;
import java.util.List;
import kotlin.jvm.internal.m;

public final class WindowLayoutInfo {
    private final List<DisplayFeature> displayFeatures;

    @RestrictTo({RestrictTo.Scope.TESTS})
    public WindowLayoutInfo(List<? extends DisplayFeature> list) {
        m.e(list, "displayFeatures");
        this.displayFeatures = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!m.a(WindowLayoutInfo.class, obj.getClass())) {
            return false;
        }
        return m.a(this.displayFeatures, ((WindowLayoutInfo) obj).displayFeatures);
    }

    public final List<DisplayFeature> getDisplayFeatures() {
        return this.displayFeatures;
    }

    public int hashCode() {
        return this.displayFeatures.hashCode();
    }

    public String toString() {
        return C1601o.O(this.displayFeatures, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
