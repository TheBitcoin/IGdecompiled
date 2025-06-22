package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import o0.C2172d;

public interface ProgressUpdater {
    @NonNull
    C2172d updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}
