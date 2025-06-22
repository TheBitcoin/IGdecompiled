package C2;

import android.util.Log;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6277a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final ChoiceCmpCallback f6278b = ChoiceCmp.INSTANCE.getCallback();

    public static /* synthetic */ void a(b bVar, ChoiceError choiceError, String str, String str2, c cVar, Throwable th, int i4) {
        String str3;
        String str4;
        Throwable th2;
        if ((i4 & 2) != 0) {
            str3 = "ChoiceCmp";
        } else {
            str3 = null;
        }
        if ((i4 & 4) != 0) {
            str4 = "";
        } else {
            str4 = null;
        }
        if ((i4 & 8) != 0) {
            cVar = c.CALLBACK;
        }
        c cVar2 = cVar;
        if ((i4 & 16) != 0) {
            th2 = null;
        } else {
            th2 = th;
        }
        bVar.b(choiceError, str3, str4, cVar2, th2);
    }

    public final void b(ChoiceError choiceError, String str, String str2, c cVar, Throwable th) {
        m.e(choiceError, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        m.e(str, "tag");
        m.e(str2, "message");
        m.e(cVar, "level");
        if (str2.length() == 0) {
            str2 = choiceError.getMessage();
        }
        int ordinal = cVar.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                ChoiceCmpCallback choiceCmpCallback = f6278b;
                if (choiceCmpCallback != null) {
                    choiceCmpCallback.onCmpError(choiceError);
                }
            } else if (ordinal == 2) {
                if (str2.length() > 0 && str.length() > 0) {
                    Log.e(str, str2, th);
                }
                ChoiceCmpCallback choiceCmpCallback2 = f6278b;
                if (choiceCmpCallback2 != null) {
                    choiceCmpCallback2.onCmpError(choiceError);
                }
            }
        } else if (str2.length() > 0 && str.length() > 0) {
            Log.e(str, str2, th);
        }
    }
}
