package androidx.datastore.preferences;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PreferencesMapCompat {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final PreferencesProto.PreferenceMap readFrom(InputStream inputStream) {
            m.e(inputStream, "input");
            try {
                PreferencesProto.PreferenceMap parseFrom = PreferencesProto.PreferenceMap.parseFrom(inputStream);
                m.d(parseFrom, "{\n                Prefer…From(input)\n            }");
                return parseFrom;
            } catch (InvalidProtocolBufferException e5) {
                throw new CorruptionException("Unable to parse preferences proto.", e5);
            }
        }

        private Companion() {
        }
    }
}
