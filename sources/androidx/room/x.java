package androidx.room;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f1017a;

    public /* synthetic */ x(RoomTrackingLiveData roomTrackingLiveData) {
        this.f1017a = roomTrackingLiveData;
    }

    public final void run() {
        RoomTrackingLiveData.refreshRunnable$lambda$0(this.f1017a);
    }
}
