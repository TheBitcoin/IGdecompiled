package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import c3.C1704a;
import k3.c;
import kotlin.jvm.internal.m;

public final class OneTimeWorkRequestKt {
    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull c cVar) {
        m.e(builder, "<this>");
        m.e(cVar, "inputMerger");
        return builder.setInputMerger(C1704a.a(cVar));
    }
}
