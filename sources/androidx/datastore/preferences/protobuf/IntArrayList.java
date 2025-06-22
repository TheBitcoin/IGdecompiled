package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.makeImmutable();
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    public static IntArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i4 = intArrayList.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            int[] iArr = this.array;
            if (i6 > iArr.length) {
                this.array = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
            this.size = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i4) {
        ensureIsMutable();
        int i5 = this.size;
        int[] iArr = this.array;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[(((i5 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        iArr3[i6] = i4;
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
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (this.array[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    public int getInt(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + this.array[i5];
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.array[i4] == intValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        ensureIsMutable();
        if (i5 >= i4) {
            int[] iArr = this.array;
            System.arraycopy(iArr, i5, iArr, i4, this.size - i5);
            this.size -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int setInt(int i4, int i5) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        int[] iArr = this.array;
        int i6 = iArr[i4];
        iArr[i4] = i5;
        return i6;
    }

    public int size() {
        return this.size;
    }

    private IntArrayList(int[] iArr, int i4) {
        this.array = iArr;
        this.size = i4;
    }

    public Integer get(int i4) {
        return Integer.valueOf(getInt(i4));
    }

    public Internal.IntList mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Integer remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        int[] iArr = this.array;
        int i5 = iArr[i4];
        int i6 = this.size;
        if (i4 < i6 - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i6 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i5);
    }

    public Integer set(int i4, Integer num) {
        return Integer.valueOf(setInt(i4, num.intValue()));
    }

    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    public void add(int i4, Integer num) {
        addInt(i4, num.intValue());
    }

    private void addInt(int i4, int i5) {
        int i6;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        int[] iArr = this.array;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i4, iArr, i4 + 1, i6 - i4);
        } else {
            int[] iArr2 = new int[(((i6 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            System.arraycopy(this.array, i4, iArr2, i4 + 1, this.size - i4);
            this.array = iArr2;
        }
        this.array[i4] = i5;
        this.size++;
        this.modCount++;
    }
}
