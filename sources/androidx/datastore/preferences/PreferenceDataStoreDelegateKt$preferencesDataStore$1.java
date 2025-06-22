package androidx.datastore.preferences;

import S2.C1601o;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import d3.l;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class PreferenceDataStoreDelegateKt$preferencesDataStore$1 extends n implements l {
    public static final PreferenceDataStoreDelegateKt$preferencesDataStore$1 INSTANCE = new PreferenceDataStoreDelegateKt$preferencesDataStore$1();

    PreferenceDataStoreDelegateKt$preferencesDataStore$1() {
        super(1);
    }

    public final List<DataMigration<Preferences>> invoke(Context context) {
        m.e(context, "it");
        return C1601o.h();
    }
}
