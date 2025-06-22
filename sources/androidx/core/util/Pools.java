package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.m;

public final class Pools {

    public interface Pool<T> {
        T acquire();

        boolean release(T t4);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i4) {
            if (i4 > 0) {
                this.pool = new Object[i4];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private final boolean isInPool(T t4) {
            int i4 = this.poolSize;
            for (int i5 = 0; i5 < i4; i5++) {
                if (this.pool[i5] == t4) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i4 = this.poolSize;
            if (i4 <= 0) {
                return null;
            }
            int i5 = i4 - 1;
            T t4 = this.pool[i5];
            m.c(t4, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i5] = null;
            this.poolSize--;
            return t4;
        }

        public boolean release(T t4) {
            m.e(t4, "instance");
            if (!isInPool(t4)) {
                int i4 = this.poolSize;
                Object[] objArr = this.pool;
                if (i4 >= objArr.length) {
                    return false;
                }
                objArr[i4] = t4;
                this.poolSize = i4 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock = new Object();

        public SynchronizedPool(int i4) {
            super(i4);
        }

        public T acquire() {
            T acquire;
            synchronized (this.lock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t4) {
            boolean release;
            m.e(t4, "instance");
            synchronized (this.lock) {
                release = super.release(t4);
            }
            return release;
        }
    }

    private Pools() {
    }
}
