package androidx.datastore.preferences;

import android.content.Context;
import d3.a;
import java.io.File;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends n implements a {
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    public final File invoke() {
        Context context = this.$applicationContext;
        m.d(context, "applicationContext");
        return PreferenceDataStoreFile.preferencesDataStoreFile(context, this.this$0.name);
    }
}
