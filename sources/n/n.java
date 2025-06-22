package n;

import R2.s;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;

public final class n extends kotlin.jvm.internal.n implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f3610a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(m mVar) {
        super(1);
        this.f3610a = mVar;
    }

    public Object invoke(Object obj) {
        s sVar;
        ChoiceCmpCallback choiceCmpCallback;
        ChoiceCmpCallback choiceCmpCallback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        if (uSRegulationData == null || (choiceCmpCallback2 = this.f3610a.f3607c) == null) {
            sVar = null;
        } else {
            choiceCmpCallback2.onReceiveUSRegulationsConsent(uSRegulationData);
            sVar = s.f8222a;
        }
        if (sVar == null && (choiceCmpCallback = this.f3610a.f3607c) != null) {
            choiceCmpCallback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return s.f8222a;
    }
}
