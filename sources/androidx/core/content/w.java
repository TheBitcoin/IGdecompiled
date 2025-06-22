package androidx.core.content;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f852a;

    public /* synthetic */ w(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f852a = unusedAppRestrictionsBackportServiceConnection;
    }

    public final void run() {
        this.f852a.disconnectFromService();
    }
}
