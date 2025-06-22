package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import o0.C2172d;

public interface ForegroundUpdater {
    @NonNull
    C2172d setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}
