package androidx.work;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.m;

public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String str);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final InputMerger createInputMergerWithDefaultFallback(String str) {
        m.e(str, "className");
        InputMerger createInputMerger = createInputMerger(str);
        if (createInputMerger == null) {
            return InputMergerKt.fromClassName(str);
        }
        return createInputMerger;
    }
}
