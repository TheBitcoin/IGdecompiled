package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        EMPTY_LIST = floatArrayList;
        floatArrayList.makeImmutable();
    }

    FloatArrayList() {
        this(new float[10], 0);
    }

    public static FloatArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i4 = floatArrayList.size;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.size;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            float[] fArr = this.array;
            if (i6 > fArr.length) {
                this.array = Arrays.copyOf(fArr, i6);
            }
            System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
            this.size = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f4) {
        ensureIsMutable();
        int i4 = this.size;
        float[] fArr = this.array;
        if (i4 == fArr.length) {
            float[] fArr2 = new float[(((i4 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        fArr3[i5] = f4;
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i4 = 0; i4 < this.size; i4++) {
            if (Float.floatToIntBits(this.array[i4]) != Float.floatToIntBits(fArr[i4])) {
                return false;
            }
        }
        return true;
    }

    public float getFloat(int i4) {
        ensureIndexInRange(i4);
        return this.array[i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.size; i5++) {
            i4 = (i4 * 31) + Float.floatToIntBits(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i4 = 0; i4 < size2; i4++) {
            if (this.array[i4] == floatValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        ensureIsMutable();
        if (i5 >= i4) {
            float[] fArr = this.array;
            System.arraycopy(fArr, i5, fArr, i4, this.size - i5);
            this.size -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i4, float f4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        float[] fArr = this.array;
        float f5 = fArr[i4];
        fArr[i4] = f4;
        return f5;
    }

    public int size() {
        return this.size;
    }

    private FloatArrayList(float[] fArr, int i4) {
        this.array = fArr;
        this.size = i4;
    }

    public Float get(int i4) {
        return Float.valueOf(getFloat(i4));
    }

    public Internal.FloatList mutableCopyWithCapacity(int i4) {
        if (i4 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i4), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Float remove(int i4) {
        ensureIsMutable();
        ensureIndexInRange(i4);
        float[] fArr = this.array;
        float f4 = fArr[i4];
        int i5 = this.size;
        if (i4 < i5 - 1) {
            System.arraycopy(fArr, i4 + 1, fArr, i4, (i5 - i4) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f4);
    }

    public Float set(int i4, Float f4) {
        return Float.valueOf(setFloat(i4, f4.floatValue()));
    }

    public boolean add(Float f4) {
        addFloat(f4.floatValue());
        return true;
    }

    public void add(int i4, Float f4) {
        addFloat(i4, f4.floatValue());
    }

    private void addFloat(int i4, float f4) {
        int i5;
        ensureIsMutable();
        if (i4 < 0 || i4 > (i5 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i4));
        }
        float[] fArr = this.array;
        if (i5 < fArr.length) {
            System.arraycopy(fArr, i4, fArr, i4 + 1, i5 - i4);
        } else {
            float[] fArr2 = new float[(((i5 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i4);
            System.arraycopy(this.array, i4, fArr2, i4 + 1, this.size - i4);
            this.array = fArr2;
        }
        this.array[i4] = f4;
        this.size++;
        this.modCount++;
    }
}
