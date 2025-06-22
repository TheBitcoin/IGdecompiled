package com.google.android.gms.common.api.internal;

import J.C0305d;
import L.C0318b;
import M.C0333n;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;

final class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C0318b f1342a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0305d f1343b;

    /* synthetic */ o(C0318b bVar, C0305d dVar, L.o oVar) {
        this.f1342a = bVar;
        this.f1343b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof o)) {
            o oVar = (o) obj;
            if (!C0333n.a(this.f1342a, oVar.f1342a) || !C0333n.a(this.f1343b, oVar.f1343b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C0333n.b(this.f1342a, this.f1343b);
    }

    public final String toString() {
        return C0333n.c(this).a(LeanbackPreferenceDialogFragment.ARG_KEY, this.f1342a).a("feature", this.f1343b).toString();
    }
}
