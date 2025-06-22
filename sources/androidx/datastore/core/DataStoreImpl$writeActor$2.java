package androidx.datastore.core;

import R2.s;
import androidx.core.app.NotificationCompat;
import androidx.datastore.core.Message;
import d3.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.C1006v;

final class DataStoreImpl$writeActor$2 extends n implements p {
    public static final DataStoreImpl$writeActor$2 INSTANCE = new DataStoreImpl$writeActor$2();

    DataStoreImpl$writeActor$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Message.Update) obj, (Throwable) obj2);
        return s.f8222a;
    }

    public final void invoke(Message.Update<T> update, Throwable th) {
        m.e(update, NotificationCompat.CATEGORY_MESSAGE);
        C1006v ack = update.getAck();
        if (th == null) {
            th = new CancellationException("DataStore scope was cancelled before updateData could complete");
        }
        ack.u(th);
    }
}
