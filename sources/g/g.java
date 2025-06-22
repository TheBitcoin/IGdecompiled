package G;

import K.f;
import L.j;
import android.content.Context;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class g extends AsyncTaskLoader implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Semaphore f214a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private final Set f215b;

    public g(Context context, Set set) {
        super(context);
        this.f215b = set;
    }

    public final /* bridge */ /* synthetic */ Object loadInBackground() {
        int i4 = 0;
        for (f d5 : this.f215b) {
            if (d5.d(this)) {
                i4++;
            }
        }
        try {
            this.f214a.tryAcquire(i4, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e5) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e5);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void onStartLoading() {
        this.f214a.drainPermits();
        forceLoad();
    }
}
