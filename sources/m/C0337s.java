package M;

import J.C0315n;
import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: M.s  reason: case insensitive filesystem */
public class C0337s {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f588a;

    /* renamed from: b  reason: collision with root package name */
    private final String f589b;

    public C0337s(Context context) {
        C0335p.l(context);
        Resources resources = context.getResources();
        this.f588a = resources;
        this.f589b = resources.getResourcePackageName(C0315n.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.f588a.getIdentifier(str, TypedValues.Custom.S_STRING, this.f589b);
        if (identifier == 0) {
            return null;
        }
        return this.f588a.getString(identifier);
    }
}
