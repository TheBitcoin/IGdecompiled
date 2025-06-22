package J3;

/* renamed from: J3.b  reason: case insensitive filesystem */
public enum C2487b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f23438a;

    private C2487b(int i4) {
        this.f23438a = i4;
    }

    public static C2487b a(int i4) {
        for (C2487b bVar : values()) {
            if (bVar.f23438a == i4) {
                return bVar;
            }
        }
        return null;
    }
}
