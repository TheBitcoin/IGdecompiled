package androidx.datastore.preferences.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {358}, m = "invokeSuspend")
final class PreferencesKt$edit$2 extends l implements p {
    final /* synthetic */ p $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferencesKt$edit$2(p pVar, d dVar) {
        super(2, dVar);
        this.$transform = pVar;
    }

    public final d create(Object obj, d dVar) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.$transform, dVar);
        preferencesKt$edit$2.L$0 = obj;
        return preferencesKt$edit$2;
    }

    public final Object invoke(Preferences preferences, d dVar) {
        return ((PreferencesKt$edit$2) create(preferences, dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            MutablePreferences mutablePreferences = ((Preferences) this.L$0).toMutablePreferences();
            p pVar = this.$transform;
            this.L$0 = mutablePreferences;
            this.label = 1;
            if (pVar.invoke(mutablePreferences, this) == c5) {
                return c5;
            }
            return mutablePreferences;
        } else if (i4 == 1) {
            MutablePreferences mutablePreferences2 = (MutablePreferences) this.L$0;
            n.b(obj);
            return mutablePreferences2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
