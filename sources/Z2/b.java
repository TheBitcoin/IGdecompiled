package z2;

import com.uptodown.workers.GenerateQueueWorker;
import g2.C2048f;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return GenerateQueueWorker.d((C2048f) obj, (C2048f) obj2);
    }
}
