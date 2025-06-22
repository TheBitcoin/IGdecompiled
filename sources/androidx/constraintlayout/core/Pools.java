package androidx.constraintlayout.core;

final class Pools {
    private static final boolean DEBUG = false;

    interface Pool<T> {
        T acquire();

        boolean release(T t4);

        void releaseAll(T[] tArr, int i4);
    }

    static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int i4) {
            if (i4 > 0) {
                this.mPool = new Object[i4];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t4) {
            for (int i4 = 0; i4 < this.mPoolSize; i4++) {
                if (this.mPool[i4] == t4) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i4 = this.mPoolSize;
            if (i4 <= 0) {
                return null;
            }
            int i5 = i4 - 1;
            T[] tArr = this.mPool;
            T t4 = tArr[i5];
            tArr[i5] = null;
            this.mPoolSize = i4 - 1;
            return t4;
        }

        public boolean release(T t4) {
            int i4 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i4 >= objArr.length) {
                return false;
            }
            objArr[i4] = t4;
            this.mPoolSize = i4 + 1;
            return true;
        }

        public void releaseAll(T[] tArr, int i4) {
            if (i4 > tArr.length) {
                i4 = tArr.length;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                T t4 = tArr[i5];
                int i6 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i6 < objArr.length) {
                    objArr[i6] = t4;
                    this.mPoolSize = i6 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
