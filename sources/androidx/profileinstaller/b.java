package androidx.profileinstaller;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f968a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f969b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f970c;

    public /* synthetic */ b(DeviceProfileWriter deviceProfileWriter, int i4, Object obj) {
        this.f968a = deviceProfileWriter;
        this.f969b = i4;
        this.f970c = obj;
    }

    public final void run() {
        this.f968a.mDiagnostics.onResultReceived(this.f969b, this.f970c);
    }
}
