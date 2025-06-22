package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.room.IMultiInstanceInvalidationService;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;

public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$serviceConnection$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m.e(componentName, RewardPlus.NAME);
        m.e(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.this$0.setService(IMultiInstanceInvalidationService.Stub.asInterface(iBinder));
        this.this$0.getExecutor().execute(this.this$0.getSetUpRunnable());
    }

    public void onServiceDisconnected(ComponentName componentName) {
        m.e(componentName, RewardPlus.NAME);
        this.this$0.getExecutor().execute(this.this$0.getRemoveObserverRunnable());
        this.this$0.setService((IMultiInstanceInvalidationService) null);
    }
}
