package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        EMPTY_LIST = booleanArrayList;
        booleanArrayList.makeImmutable();
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    public static BooleanArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i4 = booleanArrayList.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            boolean[] zArr = this.array;
            if (i6 > zArr.length) {
                this.array = Arrays.copyOf(zArr, i6);
            }
            System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
            this.size = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z4) {
        ensureIsMutable();
        int i4 = this.size;
        boolean[] zArr = this.array;
        if (i4 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i4 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        zArr3[i5] = z4;
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
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.array[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + Internal.hashBoolean(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.array[i4] == booleanValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        ensureIsMutable();
        if (i5 >= i4) {
            boolean[] zArr = this.array;
            System.arraycopy(zArr, i5, zArr, i4, this.size - i5);
            this.size -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i4, boolean z4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        boolean[] zArr = this.array;
        boolean z5 = zArr[i4];
        zArr[i4] = z4;
        return z5;
    }

    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i4) {
        this.array = zArr;
        this.size = i4;
    }

    public Boolean get(int i4) {
        return Boolean.valueOf(getBoolean(i4));
    }

    public Internal.BooleanList mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Boolean remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        boolean[] zArr = this.array;
        boolean z4 = zArr[i4];
        int i5 = this.size;
        if (i4 < i5 - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z4);
    }

    public Boolean set(int i4, Boolean bool) {
        return Boolean.valueOf(setBoolean(i4, bool.booleanValue()));
    }

    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public void add(int i4, Boolean bool) {
        addBoolean(i4, bool.booleanValue());
    }

    private void addBoolean(int i4, boolean z4) {
        int i5;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        boolean[] zArr = this.array;
        if (i5 < zArr.length) {
            System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
        } else {
            boolean[] zArr2 = new boolean[(((i5 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            System.arraycopy(this.array, i4, zArr2, i4 + 1, this.size - i4);
            this.array = zArr2;
        }
        this.array[i4] = z4;
        this.size++;
        this.modCount++;
    }
}
