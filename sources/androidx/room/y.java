package androidx.room;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomTrackingLiveData f1018a;

    public /* synthetic */ y(RoomTrackingLiveData roomTrackingLiveData) {
        this.f1018a = roomTrackingLiveData;
    }

    public final void run() {
        RoomTrackingLiveData.invalidationRunnable$lambda$1(this.f1018a);
    }
}
