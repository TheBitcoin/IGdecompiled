package Z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

public abstract class g extends ContextCompat {
    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i4;
        if (!e.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != e.a()) {
            i4 = 0;
        } else {
            i4 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i4);
    }
}
