package f0;

import J.C0315n;
import M.C0335p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f3371a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3372b;

    public n(Context context, String str) {
        C0335p.l(context);
        this.f3371a = context.getResources();
        if (!TextUtils.isEmpty(str)) {
            this.f3372b = str;
        } else {
            this.f3372b = a(context);
        }
    }

    public static String a(Context context) {
        try {
            return context.getResources().getResourcePackageName(C0315n.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public final String b(String str) {
        int identifier = this.f3371a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f3372b);
        if (identifier == 0) {
            return null;
        }
        try {
            return this.f3371a.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
