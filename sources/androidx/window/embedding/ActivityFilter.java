package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.m;

@ExperimentalWindowApi
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName componentName2, String str) {
        m.e(componentName2, "componentName");
        this.componentName = componentName2;
        this.intentAction = str;
        String packageName = componentName2.getPackageName();
        m.d(packageName, "componentName.packageName");
        String className = componentName2.getClassName();
        m.d(className, "componentName.className");
        if (packageName.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        } else if (className.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        } else if (m3.m.D(packageName, "*", false, 2, (Object) null) && m3.m.L(packageName, "*", 0, false, 6, (Object) null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        } else if (m3.m.D(className, "*", false, 2, (Object) null)) {
            String str2 = className;
            if (m3.m.L(str2, "*", 0, false, 6, (Object) null) != str2.length() - 1) {
                throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        if (m.a(this.componentName, activityFilter.componentName) && m.a(this.intentAction, activityFilter.intentAction)) {
            return true;
        }
        return false;
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        return hashCode + i4;
    }

    public final boolean matchesActivity(Activity activity) {
        String str;
        m.e(activity, "activity");
        if (!MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            return false;
        }
        String str2 = this.intentAction;
        if (str2 == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            str = null;
        } else {
            str = intent.getAction();
        }
        if (m.a(str2, str)) {
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(Intent intent) {
        m.e(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        if (str == null || m.a(str, intent.getAction())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }
}
