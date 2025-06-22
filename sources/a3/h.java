package A3;

import R2.s;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import d3.l;
import kotlin.jvm.internal.n;

public final class h extends n implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final h f80a = new h();

    public h() {
        super(1);
    }

    public Object invoke(Object obj) {
        s sVar;
        ChoiceCmpCallback callback;
        ChoiceCmpCallback callback2;
        USRegulationData uSRegulationData = (USRegulationData) obj;
        if (uSRegulationData == null || (callback2 = ChoiceCmp.INSTANCE.getCallback()) == null) {
            sVar = null;
        } else {
            callback2.onReceiveUSRegulationsConsent(uSRegulationData);
            sVar = s.f8222a;
        }
        if (sVar == null && (callback = ChoiceCmp.INSTANCE.getCallback()) != null) {
            callback.onCmpError(ChoiceError.ERROR_WHILE_SAVING_CONSENT);
        }
        return s.f8222a;
    }
}
