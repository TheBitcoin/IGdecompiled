package com.mbridge.msdk.playercommon.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements ShuffleOrder {
        private final int[] indexInShuffled;
        private final Random random;
        private final int[] shuffled;

        public DefaultShuffleOrder(int i4) {
            this(i4, new Random());
        }

        private static int[] createShuffledList(int i4, Random random2) {
            int[] iArr = new int[i4];
            int i5 = 0;
            while (i5 < i4) {
                int i6 = i5 + 1;
                int nextInt = random2.nextInt(i6);
                iArr[i5] = iArr[nextInt];
                iArr[nextInt] = i5;
                i5 = i6;
            }
            return iArr;
        }

        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.random.nextLong()));
        }

        public ShuffleOrder cloneAndInsert(int i4, int i5) {
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int i6 = 0;
            int i7 = 0;
            while (i7 < i5) {
                iArr[i7] = this.random.nextInt(this.shuffled.length + 1);
                int i8 = i7 + 1;
                int nextInt = this.random.nextInt(i8);
                iArr2[i7] = iArr2[nextInt];
                iArr2[nextInt] = i7 + i4;
                i7 = i8;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[(this.shuffled.length + i5)];
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int[] iArr4 = this.shuffled;
                if (i6 >= iArr4.length + i5) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.random.nextLong()));
                }
                if (i9 >= i5 || i10 != iArr[i9]) {
                    int i11 = i10 + 1;
                    int i12 = iArr4[i10];
                    iArr3[i6] = i12;
                    if (i12 >= i4) {
                        iArr3[i6] = i12 + i5;
                    }
                    i10 = i11;
                } else {
                    iArr3[i6] = iArr2[i9];
                    i9++;
                }
                i6++;
            }
        }

        public ShuffleOrder cloneAndRemove(int i4) {
            int i5;
            int[] iArr = new int[(this.shuffled.length - 1)];
            int i6 = 0;
            boolean z4 = false;
            while (true) {
                int[] iArr2 = this.shuffled;
                if (i6 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.random.nextLong()));
                }
                int i7 = iArr2[i6];
                if (i7 == i4) {
                    z4 = true;
                } else {
                    if (z4) {
                        i5 = i6 - 1;
                    } else {
                        i5 = i6;
                    }
                    if (i7 > i4) {
                        i7--;
                    }
                    iArr[i5] = i7;
                }
                i6++;
            }
        }

        public int getFirstIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        public int getLastIndex() {
            int[] iArr = this.shuffled;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        public int getLength() {
            return this.shuffled.length;
        }

        public int getNextIndex(int i4) {
            int i5 = this.indexInShuffled[i4] + 1;
            int[] iArr = this.shuffled;
            if (i5 < iArr.length) {
                return iArr[i5];
            }
            return -1;
        }

        public int getPreviousIndex(int i4) {
            int i5 = this.indexInShuffled[i4] - 1;
            if (i5 >= 0) {
                return this.shuffled[i5];
            }
            return -1;
        }

        public DefaultShuffleOrder(int i4, long j4) {
            this(i4, new Random(j4));
        }

        private DefaultShuffleOrder(int i4, Random random2) {
            this(createShuffledList(i4, random2), random2);
        }

        private DefaultShuffleOrder(int[] iArr, Random random2) {
            this.shuffled = iArr;
            this.random = random2;
            this.indexInShuffled = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                this.indexInShuffled[iArr[i4]] = i4;
            }
        }
    }

    public static final class UnshuffledShuffleOrder implements ShuffleOrder {
        private final int length;

        public UnshuffledShuffleOrder(int i4) {
            this.length = i4;
        }

        public final ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        public final ShuffleOrder cloneAndInsert(int i4, int i5) {
            return new UnshuffledShuffleOrder(this.length + i5);
        }

        public final ShuffleOrder cloneAndRemove(int i4) {
            return new UnshuffledShuffleOrder(this.length - 1);
        }

        public final int getFirstIndex() {
            if (this.length > 0) {
                return 0;
            }
            return -1;
        }

        public final int getLastIndex() {
            int i4 = this.length;
            if (i4 > 0) {
                return i4 - 1;
            }
            return -1;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getNextIndex(int i4) {
            int i5 = i4 + 1;
            if (i5 < this.length) {
                return i5;
            }
            return -1;
        }

        public final int getPreviousIndex(int i4) {
            int i5 = i4 - 1;
            if (i5 >= 0) {
                return i5;
            }
            return -1;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int i4, int i5);

    ShuffleOrder cloneAndRemove(int i4);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i4);

    int getPreviousIndex(int i4);
}
