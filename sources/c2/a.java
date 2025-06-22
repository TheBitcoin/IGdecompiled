package C2;

import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

public final class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final ChoiceError f6276a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ChoiceError choiceError) {
        super(choiceError.getMessage());
        m.e(choiceError, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        this.f6276a = choiceError;
    }
}
