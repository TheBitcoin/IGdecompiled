package androidx.room;

import R2.s;
import androidx.room.InvalidationTracker;
import java.util.Set;
import kotlin.jvm.internal.m;
import q3.d;

public final class CoroutinesRoom$Companion$createFlow$1$1$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ d $observerChannel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$createFlow$1$1$observer$1(String[] strArr, d dVar) {
        super(strArr);
        this.$observerChannel = dVar;
    }

    public void onInvalidated(Set<String> set) {
        m.e(set, "tables");
        this.$observerChannel.B(s.f8222a);
    }
}
