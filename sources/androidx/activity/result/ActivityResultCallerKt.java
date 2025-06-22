package androidx.activity.result;

import R2.s;
import androidx.activity.result.contract.ActivityResultContract;
import d3.l;

public final class ActivityResultCallerKt {
    public static final <I, O> ActivityResultLauncher<s> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i4, ActivityResultRegistry activityResultRegistry, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new a(lVar)), activityResultContract, i4);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$0(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void registerForActivityResult$lambda$1(l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public static final <I, O> ActivityResultLauncher<s> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i4, l lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new b(lVar)), activityResultContract, i4);
    }
}
