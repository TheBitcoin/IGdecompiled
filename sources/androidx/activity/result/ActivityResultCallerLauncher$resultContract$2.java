package androidx.activity.result;

import R2.s;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import d3.a;
import kotlin.jvm.internal.n;

final class ActivityResultCallerLauncher$resultContract$2 extends n implements a {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher<I, O> activityResultCallerLauncher = this.this$0;
        return new ActivityResultContract<s, O>() {
            public O parseResult(int i4, Intent intent) {
                return activityResultCallerLauncher.getCallerContract().parseResult(i4, intent);
            }

            public Intent createIntent(Context context, s sVar) {
                return activityResultCallerLauncher.getCallerContract().createIntent(context, activityResultCallerLauncher.getCallerInput());
            }
        };
    }
}
