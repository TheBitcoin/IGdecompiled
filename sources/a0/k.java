package A0;

import java.util.List;
import java.util.Map;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f5733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f5735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f5736d;

    public /* synthetic */ k(m mVar, String str, Map map, List list) {
        this.f5733a = mVar;
        this.f5734b = str;
        this.f5735c = map;
        this.f5736d = list;
    }

    public final void run() {
        m.a(this.f5733a, this.f5734b, this.f5735c, this.f5736d);
    }
}
