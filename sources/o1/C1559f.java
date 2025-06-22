package O1;

import android.widget.RadioGroup;

/* renamed from: O1.f  reason: case insensitive filesystem */
public final /* synthetic */ class C1559f implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7893c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f7894d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f7895e;

    public /* synthetic */ C1559f(r rVar, String str, String str2, long j4, boolean z4) {
        this.f7891a = rVar;
        this.f7892b = str;
        this.f7893c = str2;
        this.f7894d = j4;
        this.f7895e = z4;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i4) {
        r.B(this.f7891a, this.f7892b, this.f7893c, this.f7894d, this.f7895e, radioGroup, i4);
    }
}
