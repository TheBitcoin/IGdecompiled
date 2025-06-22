package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.dycreator.a.b;
import java.io.File;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f12638a;

    /* renamed from: b  reason: collision with root package name */
    private b f12639b = null;

    private f(Context context) {
        b a5 = b.a();
        this.f12639b = a5;
        a5.a(context, "");
    }

    public static f a(Context context) {
        if (f12638a == null) {
            synchronized (f.class) {
                try {
                    if (f12638a == null) {
                        f12638a = new f(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12638a;
    }

    public final View a(String str) {
        if (new File(str).exists()) {
            return this.f12639b.f(str);
        }
        return null;
    }

    public final View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = viewGroup.getChildAt(i4);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }
}
