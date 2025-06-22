package androidx.datastore.preferences;

import R2.n;
import R2.s;
import S2.C1601o;
import V2.d;
import W2.b;
import androidx.datastore.preferences.core.Preferences;
import d3.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;

@f(c = "androidx.datastore.preferences.SharedPreferencesMigrationKt$getShouldRunMigration$1", f = "SharedPreferencesMigration.android.kt", l = {}, m = "invokeSuspend")
final class SharedPreferencesMigrationKt$getShouldRunMigration$1 extends l implements p {
    final /* synthetic */ Set<String> $keysToMigrate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesMigrationKt$getShouldRunMigration$1(Set<String> set, d dVar) {
        super(2, dVar);
        this.$keysToMigrate = set;
    }

    public final d create(Object obj, d dVar) {
        SharedPreferencesMigrationKt$getShouldRunMigration$1 sharedPreferencesMigrationKt$getShouldRunMigration$1 = new SharedPreferencesMigrationKt$getShouldRunMigration$1(this.$keysToMigrate, dVar);
        sharedPreferencesMigrationKt$getShouldRunMigration$1.L$0 = obj;
        return sharedPreferencesMigrationKt$getShouldRunMigration$1;
    }

    public final Object invoke(Preferences preferences, d dVar) {
        return ((SharedPreferencesMigrationKt$getShouldRunMigration$1) create(preferences, dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            n.b(obj);
            Set<Preferences.Key<?>> keySet = ((Preferences) this.L$0).asMap().keySet();
            ArrayList arrayList = new ArrayList(C1601o.p(keySet, 10));
            for (Preferences.Key name : keySet) {
                arrayList.add(name.getName());
            }
            boolean z4 = true;
            if (this.$keysToMigrate != SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS()) {
                Set<String> set = this.$keysToMigrate;
                if (!b.l.a(set) || !set.isEmpty()) {
                    Iterator<T> it = set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!arrayList.contains((String) it.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z4 = false;
            }
            return kotlin.coroutines.jvm.internal.b.a(z4);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
