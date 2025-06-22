package androidx.tracing;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i4) {
        Trace.beginAsyncSection(str, i4);
    }

    public static void endAsyncSection(@NonNull String str, int i4) {
        Trace.endAsyncSection(str, i4);
    }

    public static void setCounter(@NonNull String str, int i4) {
        Trace.setCounter(str, (long) i4);
    }
}
