package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i4) {
        if (i4 < 0 || i4 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i4) {
        return "Index:" + i4 + ", Size:" + this.size;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i4 = longArrayList.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            long[] jArr = this.array;
            if (i6 > jArr.length) {
                this.array = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
            this.size = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j4) {
        ensureIsMutable();
        int i4 = this.size;
        long[] jArr = this.array;
        if (i4 == jArr.length) {
            long[] jArr2 = new long[(((i4 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        jArr3[i5] = j4;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.array[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    public long getLong(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + Internal.hashLong(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.array[i4] == longValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        ensureIsMutable();
        if (i5 >= i4) {
            long[] jArr = this.array;
            System.arraycopy(jArr, i5, jArr, i4, this.size - i5);
            this.size -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i4, long j4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        long[] jArr = this.array;
        long j5 = jArr[i4];
        jArr[i4] = j4;
        return j5;
    }

    public int size() {
        return this.size;
    }

    private LongArrayList(long[] jArr, int i4) {
        this.array = jArr;
        this.size = i4;
    }

    public Long get(int i4) {
        return Long.valueOf(getLong(i4));
    }

    public Internal.LongList mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Long remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        long[] jArr = this.array;
        long j4 = jArr[i4];
        int i5 = this.size;
        if (i4 < i5 - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j4);
    }

    public Long set(int i4, Long l4) {
        return Long.valueOf(setLong(i4, l4.longValue()));
    }

    public boolean add(Long l4) {
        addLong(l4.longValue());
        return true;
    }

    public void add(int i4, Long l4) {
        addLong(i4, l4.longValue());
    }

    private void addLong(int i4, long j4) {
        int i5;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        long[] jArr = this.array;
        if (i5 < jArr.length) {
            System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
        } else {
            long[] jArr2 = new long[(((i5 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            System.arraycopy(this.array, i4, jArr2, i4 + 1, this.size - i4);
            this.array = jArr2;
        }
        this.array[i4] = j4;
        this.size++;
        this.modCount++;
    }
}
