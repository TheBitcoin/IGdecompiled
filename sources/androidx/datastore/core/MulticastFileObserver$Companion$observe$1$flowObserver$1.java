package androidx.datastore.core;

import d3.l;
import java.io.File;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import q3.k;
import q3.s;

final class MulticastFileObserver$Companion$observe$1$flowObserver$1 extends n implements l {
    final /* synthetic */ s $$this$channelFlow;
    final /* synthetic */ File $file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MulticastFileObserver$Companion$observe$1$flowObserver$1(File file, s sVar) {
        super(1);
        this.$file = file;
        this.$$this$channelFlow = sVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return R2.s.f8222a;
    }

    public final void invoke(String str) {
        if (m.a(str, this.$file.getName())) {
            k.b(this.$$this$channelFlow, R2.s.f8222a);
        }
    }
}
