package androidx.room;

import R2.s;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram, AutoCloseable {
    private static final int BLOB = 5;
    public static final Companion Companion = new Companion((C2103g) null);
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    @VisibleForTesting
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }

        public final RoomSQLiteQuery acquire(String str, int i4) {
            m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i4));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(str, i4);
                    m.d(value, "sqliteQuery");
                    return value;
                }
                s sVar = s.f8222a;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i4, (C2103g) null);
                roomSQLiteQuery.init(str, i4);
                return roomSQLiteQuery;
            }
        }

        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            m.e(supportSQLiteQuery, "supportSQLiteQuery");
            RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(acquire));
            return acquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                m.d(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i4 = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i4;
                    } else {
                        return;
                    }
                }
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i4, C2103g gVar) {
        this(i4);
    }

    public static final RoomSQLiteQuery acquire(String str, int i4) {
        return Companion.acquire(str, i4);
    }

    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    public void bindBlob(int i4, byte[] bArr) {
        m.e(bArr, "value");
        this.bindingTypes[i4] = 5;
        this.blobBindings[i4] = bArr;
    }

    public void bindDouble(int i4, double d5) {
        this.bindingTypes[i4] = 3;
        this.doubleBindings[i4] = d5;
    }

    public void bindLong(int i4, long j4) {
        this.bindingTypes[i4] = 2;
        this.longBindings[i4] = j4;
    }

    public void bindNull(int i4) {
        this.bindingTypes[i4] = 1;
    }

    public void bindString(int i4, String str) {
        m.e(str, "value");
        this.bindingTypes[i4] = 4;
        this.stringBindings[i4] = str;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        m.e(supportSQLiteProgram, "statement");
        int argCount2 = getArgCount();
        if (1 <= argCount2) {
            int i4 = 1;
            while (true) {
                int i5 = this.bindingTypes[i4];
                if (i5 == 1) {
                    supportSQLiteProgram.bindNull(i4);
                } else if (i5 == 2) {
                    supportSQLiteProgram.bindLong(i4, this.longBindings[i4]);
                } else if (i5 == 3) {
                    supportSQLiteProgram.bindDouble(i4, this.doubleBindings[i4]);
                } else if (i5 == 4) {
                    String str = this.stringBindings[i4];
                    if (str != null) {
                        supportSQLiteProgram.bindString(i4, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else if (i5 == 5) {
                    byte[] bArr = this.blobBindings[i4];
                    if (bArr != null) {
                        supportSQLiteProgram.bindBlob(i4, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                }
                if (i4 != argCount2) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill(this.blobBindings, (Object) null);
        this.query = null;
    }

    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        m.e(roomSQLiteQuery, "other");
        int argCount2 = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount2);
    }

    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(String str, int i4) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        this.query = str;
        this.argCount = i4;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            s sVar = s.f8222a;
        }
    }

    private RoomSQLiteQuery(int i4) {
        this.capacity = i4;
        int i5 = i4 + 1;
        this.bindingTypes = new int[i5];
        this.longBindings = new long[i5];
        this.doubleBindings = new double[i5];
        this.stringBindings = new String[i5];
        this.blobBindings = new byte[i5][];
    }
}
