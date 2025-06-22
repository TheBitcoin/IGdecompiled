package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;

public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback = new MultiInstanceInvalidationClient$callback$1(this);
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped = new AtomicBoolean(false);

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, InvalidationTracker invalidationTracker2, Executor executor2) {
        m.e(context, "context");
        m.e(str, RewardPlus.NAME);
        m.e(intent, "serviceIntent");
        m.e(invalidationTracker2, "invalidationTracker");
        m.e(executor2, "executor");
        this.name = str;
        this.invalidationTracker = invalidationTracker2;
        this.executor = executor2;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        MultiInstanceInvalidationClient$serviceConnection$1 multiInstanceInvalidationClient$serviceConnection$1 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.serviceConnection = multiInstanceInvalidationClient$serviceConnection$1;
        this.setUpRunnable = new d(this);
        this.removeObserverRunnable = new e(this);
        Object[] array = invalidationTracker2.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0]);
        m.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setObserver(new InvalidationTracker.Observer(this, (String[]) array) {
            final /* synthetic */ MultiInstanceInvalidationClient this$0;

            {
                this.this$0 = r1;
            }

            public boolean isRemote$room_runtime_release() {
                return true;
            }

            public void onInvalidated(Set<String> set) {
                m.e(set, "tables");
                if (!this.this$0.getStopped().get()) {
                    try {
                        IMultiInstanceInvalidationService service = this.this$0.getService();
                        if (service != null) {
                            int clientId = this.this$0.getClientId();
                            Object[] array = set.toArray(new String[0]);
                            m.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            service.broadcastInvalidation(clientId, (String[]) array);
                        }
                    } catch (RemoteException e5) {
                        Log.w(Room.LOG_TAG, "Cannot broadcast invalidation", e5);
                    }
                }
            }
        });
        applicationContext.bindService(intent, multiInstanceInvalidationClient$serviceConnection$1, 1);
    }

    /* access modifiers changed from: private */
    public static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        m.e(multiInstanceInvalidationClient, "this$0");
        multiInstanceInvalidationClient.invalidationTracker.removeObserver(multiInstanceInvalidationClient.getObserver());
    }

    /* access modifiers changed from: private */
    public static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        m.e(multiInstanceInvalidationClient, "this$0");
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.service;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.clientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.callback, multiInstanceInvalidationClient.name);
                multiInstanceInvalidationClient.invalidationTracker.addObserver(multiInstanceInvalidationClient.getObserver());
            }
        } catch (RemoteException e5) {
            Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e5);
        }
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer observer2 = this.observer;
        if (observer2 != null) {
            return observer2;
        }
        m.u("observer");
        return null;
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int i4) {
        this.clientId = i4;
    }

    public final void setObserver(InvalidationTracker.Observer observer2) {
        m.e(observer2, "<set-?>");
        this.observer = observer2;
    }

    public final void setService(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        this.service = iMultiInstanceInvalidationService;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true)) {
            this.invalidationTracker.removeObserver(getObserver());
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.service;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(this.callback, this.clientId);
                }
            } catch (RemoteException e5) {
                Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e5);
            }
            this.appContext.unbindService(this.serviceConnection);
        }
    }
}
