package androidx.room;

import R2.s;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.jvm.internal.m;

public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void broadcastInvalidation(int i4, String[] strArr) {
        m.e(strArr, "tables");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            String str = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(Integer.valueOf(i4));
            if (str == null) {
                Log.w(Room.LOG_TAG, "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = multiInstanceInvalidationService.getCallbackList$room_runtime_release().beginBroadcast();
            int i5 = 0;
            while (i5 < beginBroadcast) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastCookie(i5);
                    m.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int intValue = num.intValue();
                    String str2 = multiInstanceInvalidationService.getClientNames$room_runtime_release().get(num);
                    if (i4 != intValue && m.a(str, str2)) {
                        try {
                            multiInstanceInvalidationService.getCallbackList$room_runtime_release().getBroadcastItem(i5).onInvalidation(strArr);
                        } catch (RemoteException e5) {
                            Log.w(Room.LOG_TAG, "Error invoking a remote callback", e5);
                        }
                    }
                    i5++;
                } catch (Throwable th) {
                    multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
                    throw th;
                }
            }
            multiInstanceInvalidationService.getCallbackList$room_runtime_release().finishBroadcast();
            s sVar = s.f8222a;
        }
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
        m.e(iMultiInstanceInvalidationCallback, "callback");
        int i4 = 0;
        if (str == null) {
            return 0;
        }
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            try {
                multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() + 1);
                int maxClientId$room_runtime_release = multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                if (multiInstanceInvalidationService.getCallbackList$room_runtime_release().register(iMultiInstanceInvalidationCallback, Integer.valueOf(maxClientId$room_runtime_release))) {
                    multiInstanceInvalidationService.getClientNames$room_runtime_release().put(Integer.valueOf(maxClientId$room_runtime_release), str);
                    i4 = maxClientId$room_runtime_release;
                } else {
                    multiInstanceInvalidationService.setMaxClientId$room_runtime_release(multiInstanceInvalidationService.getMaxClientId$room_runtime_release() - 1);
                    multiInstanceInvalidationService.getMaxClientId$room_runtime_release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i4;
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i4) {
        m.e(iMultiInstanceInvalidationCallback, "callback");
        RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList$room_runtime_release = this.this$0.getCallbackList$room_runtime_release();
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (callbackList$room_runtime_release) {
            multiInstanceInvalidationService.getCallbackList$room_runtime_release().unregister(iMultiInstanceInvalidationCallback);
            String remove = multiInstanceInvalidationService.getClientNames$room_runtime_release().remove(Integer.valueOf(i4));
        }
    }
}
