package p3;

import android.os.Looper;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import o3.E0;
import t3.t;

public final class a implements t {
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public E0 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper, true), (String) null, 2, (C2103g) null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public int c() {
        return 1073741823;
    }
}
