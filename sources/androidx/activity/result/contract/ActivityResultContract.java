package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t4) {
            this.value = t4;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i4);

    public SynchronousResult<O> getSynchronousResult(Context context, I i4) {
        m.e(context, "context");
        return null;
    }

    public abstract O parseResult(int i4, Intent intent);
}
