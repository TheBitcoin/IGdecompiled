package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] createArray(int i4) {
        return new Object[i4];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
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

    public boolean add(E e5) {
        ensureIsMutable();
        int i4 = this.size;
        E[] eArr = this.array;
        if (i4 == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i4 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        eArr2[i5] = e5;
        this.modCount++;
        return true;
    }

    public E get(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public E remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        E[] eArr = this.array;
        E e5 = eArr[i4];
        int i5 = this.size;
        if (i4 < i5 - 1) {
            System.arraycopy(eArr, i4 + 1, eArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return e5;
    }

    public E set(int i4, E e5) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        E[] eArr = this.array;
        E e6 = eArr[i4];
        eArr[i4] = e5;
        this.modCount++;
        return e6;
    }

    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i4) {
        this.array = eArr;
        this.size = i4;
    }

    public ProtobufArrayList<E> mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public void add(int i4, E e5) {
        int i5;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        E[] eArr = this.array;
        if (i5 < eArr.length) {
            System.arraycopy(eArr, i4, eArr, i4 + 1, i5 - i4);
        } else {
            E[] createArray = createArray(((i5 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, createArray, 0, i4);
            System.arraycopy(this.array, i4, createArray, i4 + 1, this.size - i4);
            this.array = createArray;
        }
        this.array[i4] = e5;
        this.size++;
        this.modCount++;
    }
}
