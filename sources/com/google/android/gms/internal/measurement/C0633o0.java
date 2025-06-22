package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.o0  reason: case insensitive filesystem */
public enum C0633o0 implements C0708x4 {
    UNSPECIFIED_TYPE(0),
    RAW_FILE_IO_TYPE(1),
    MOBSTORE_TYPE(2),
    SQLITE_OPEN_HELPER_TYPE(3),
    LEVEL_DB_TYPE(5),
    ROOM_TYPE(6),
    SHARED_PREFS_TYPE(7),
    PROTO_DATA_STORE_TYPE(8),
    UNRECOGNIZED(-1);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f2083a;

    private C0633o0(int i4) {
        this.f2083a = i4;
    }

    public final int A() {
        if (this != UNRECOGNIZED) {
            return this.f2083a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(C0633o0.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(A());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }
}
