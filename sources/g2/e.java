package G2;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.m;

public final class e extends Throwable {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str) {
        super(str);
        m.e(str, NotificationCompat.CATEGORY_MESSAGE);
    }
}
