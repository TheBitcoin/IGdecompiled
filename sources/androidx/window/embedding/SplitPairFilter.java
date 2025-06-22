package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.m;

@ExperimentalWindowApi
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName componentName, ComponentName componentName2, String str) {
        String str2;
        boolean z4;
        Object obj;
        int i4;
        ComponentName componentName3 = componentName;
        ComponentName componentName4 = componentName2;
        m.e(componentName3, "primaryActivityName");
        m.e(componentName4, "secondaryActivityName");
        this.primaryActivityName = componentName3;
        this.secondaryActivityName = componentName4;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName.getPackageName();
        m.d(packageName, "primaryActivityName.packageName");
        String className = componentName.getClassName();
        m.d(className, "primaryActivityName.className");
        String packageName2 = componentName4.getPackageName();
        m.d(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName4.getClassName();
        m.d(className2, "secondaryActivityName.className");
        if (packageName.length() == 0 || packageName2.length() == 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        } else if (className.length() == 0 || className2.length() == 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        } else if (!m3.m.D(packageName, "*", false, 2, (Object) null) || m3.m.L(packageName, "*", 0, false, 6, (Object) null) == packageName.length() - 1) {
            if (m3.m.D(className, "*", false, 2, (Object) null)) {
                str2 = "Wildcard in package name is only allowed at the end.";
                String str3 = className;
                if (m3.m.L(str3, "*", 0, false, 6, (Object) null) != str3.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
                }
            } else {
                str2 = "Wildcard in package name is only allowed at the end.";
            }
            if (m3.m.D(packageName2, "*", false, 2, (Object) null)) {
                i4 = 2;
                obj = null;
                String str4 = packageName2;
                z4 = false;
                if (m3.m.L(str4, "*", 0, false, 6, (Object) null) != str4.length() - 1) {
                    throw new IllegalArgumentException(str2);
                }
            } else {
                obj = null;
                i4 = 2;
                z4 = false;
            }
            if (m3.m.D(className2, "*", z4, i4, obj)) {
                String str5 = className2;
                if (m3.m.L(str5, "*", 0, false, 6, (Object) null) != str5.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
                }
            }
        } else {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        if (m.a(this.primaryActivityName, splitPairFilter.primaryActivityName) && m.a(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && m.a(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction)) {
            return true;
        }
        return false;
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int i4;
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        return hashCode + i4;
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        m.e(activity, "primaryActivity");
        m.e(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        if (str == null || m.a(str, intent.getAction())) {
            return true;
        }
        return false;
    }

    public final boolean matchesActivityPair(Activity activity, Activity activity2) {
        boolean z4;
        m.e(activity, "primaryActivity");
        m.e(activity2, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (activity2.getIntent() == null) {
            return z4;
        }
        if (z4) {
            Intent intent = activity2.getIntent();
            m.d(intent, "secondaryActivity.intent");
            if (matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
