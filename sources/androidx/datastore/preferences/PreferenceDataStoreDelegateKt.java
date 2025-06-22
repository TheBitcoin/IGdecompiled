package androidx.datastore.preferences;

import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.l;
import g3.a;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.P0;
import o3.Y;

public final class PreferenceDataStoreDelegateKt {
    public static final a preferencesDataStore(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, J j4) {
        m.e(str, RewardPlus.NAME);
        m.e(lVar, "produceMigrations");
        m.e(j4, "scope");
        return new PreferenceDataStoreSingletonDelegate(str, replaceFileCorruptionHandler, lVar, j4);
    }

    public static /* synthetic */ a preferencesDataStore$default(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, J j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 4) != 0) {
            lVar = PreferenceDataStoreDelegateKt$preferencesDataStore$1.INSTANCE;
        }
        if ((i4 & 8) != 0) {
            j4 = K.a(Y.b().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return preferencesDataStore(str, replaceFileCorruptionHandler, lVar, j4);
    }
}
