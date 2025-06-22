package androidx.datastore;

import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import d3.l;
import g3.a;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.P0;
import o3.Y;

public final class DataStoreDelegateKt {
    public static final <T> a dataStore(String str, Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, J j4) {
        m.e(str, "fileName");
        m.e(serializer, "serializer");
        m.e(lVar, "produceMigrations");
        m.e(j4, "scope");
        return new DataStoreSingletonDelegate(str, new OkioSerializerWrapper(serializer), replaceFileCorruptionHandler, lVar, j4);
    }

    public static /* synthetic */ a dataStore$default(String str, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, J j4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 8) != 0) {
            lVar = DataStoreDelegateKt$dataStore$1.INSTANCE;
        }
        if ((i4 & 16) != 0) {
            j4 = K.a(Y.b().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return dataStore(str, serializer, replaceFileCorruptionHandler, lVar, j4);
    }
}
