package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        EMPTY_LIST = doubleArrayList;
        doubleArrayList.makeImmutable();
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    public static DoubleArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i4 = doubleArrayList.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            double[] dArr = this.array;
            if (i6 > dArr.length) {
                this.array = Arrays.copyOf(dArr, i6);
            }
            System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
            this.size = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addDouble(double d5) {
        ensureIsMutable();
        int i4 = this.size;
        double[] dArr = this.array;
        if (i4 == dArr.length) {
            double[] dArr2 = new double[(((i4 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        dArr3[i5] = d5;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (Double.doubleToLongBits(this.array[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    public double getDouble(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i5]));
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size2 = size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.array[i4] == doubleValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        ensureIsMutable();
        if (i5 >= i4) {
            double[] dArr = this.array;
            System.arraycopy(dArr, i5, dArr, i4, this.size - i5);
            this.size -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double setDouble(int i4, double d5) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        double[] dArr = this.array;
        double d6 = dArr[i4];
        dArr[i4] = d5;
        return d6;
    }

    public int size() {
        return this.size;
    }

    private DoubleArrayList(double[] dArr, int i4) {
        this.array = dArr;
        this.size = i4;
    }

    public Double get(int i4) {
        return Double.valueOf(getDouble(i4));
    }

    public Internal.DoubleList mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Double remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        double[] dArr = this.array;
        double d5 = dArr[i4];
        int i5 = this.size;
        if (i4 < i5 - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d5);
    }

    public Double set(int i4, Double d5) {
        return Double.valueOf(setDouble(i4, d5.doubleValue()));
    }

    public boolean add(Double d5) {
        addDouble(d5.doubleValue());
        return true;
    }

    public void add(int i4, Double d5) {
        addDouble(i4, d5.doubleValue());
    }

    private void addDouble(int i4, double d5) {
        int i5;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        double[] dArr = this.array;
        if (i5 < dArr.length) {
            System.arraycopy(dArr, i4, dArr, i4 + 1, i5 - i4);
        } else {
            double[] dArr2 = new double[(((i5 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            System.arraycopy(this.array, i4, dArr2, i4 + 1, this.size - i4);
            this.array = dArr2;
        }
        this.array[i4] = d5;
        this.size++;
        this.modCount++;
    }
}
