package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId = 0;

        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            WrapperStableIdLookup() {
            }

            public long localToGlobal(long j4) {
                Long l4 = this.mLocalToGlobalLookup.get(j4);
                if (l4 == null) {
                    l4 = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j4, l4);
                }
                return l4.longValue();
            }
        }

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        /* access modifiers changed from: package-private */
        public long obtainId() {
            long j4 = this.mNextStableId;
            this.mNextStableId = 1 + j4;
            return j4;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() {
            public long localToGlobal(long j4) {
                return -1;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() {
            public long localToGlobal(long j4) {
                return j4;
            }
        };

        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j4);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
