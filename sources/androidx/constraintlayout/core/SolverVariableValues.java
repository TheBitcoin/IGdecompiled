package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    int mCount = 0;
    private int mHashSize = 16;
    int mHead = -1;
    int[] mKeys = new int[16];
    int[] mNext = new int[16];
    int[] mNextKeys = new int[16];
    private final int mNone = -1;
    int[] mPrevious = new int[16];
    private final ArrayRow mRow;
    private int mSize = 16;
    float[] mValues = new float[16];
    int[] mVariables = new int[16];

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i4) {
        int[] iArr;
        int i5 = solverVariable.id % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            iArr2[i5] = i4;
        } else {
            while (true) {
                iArr = this.mNextKeys;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                i6 = i7;
            }
            iArr[i6] = i4;
        }
        this.mNextKeys[i4] = -1;
    }

    private void addVariable(int i4, SolverVariable solverVariable, float f4) {
        this.mVariables[i4] = solverVariable.id;
        this.mValues[i4] = f4;
        this.mPrevious[i4] = -1;
        this.mNext[i4] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i4 = 0; i4 < this.mHashSize; i4++) {
            if (this.mKeys[i4] != -1) {
                String str = hashCode() + " hash [" + i4 + "] => ";
                int i5 = this.mKeys[i4];
                boolean z4 = false;
                while (!z4) {
                    str = str + " " + this.mVariables[i5];
                    int i6 = this.mNextKeys[i5];
                    if (i6 != -1) {
                        i5 = i6;
                    } else {
                        z4 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i4 = 0; i4 < this.mSize; i4++) {
            if (this.mVariables[i4] == -1) {
                return i4;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i4 = this.mSize * 2;
        this.mVariables = Arrays.copyOf(this.mVariables, i4);
        this.mValues = Arrays.copyOf(this.mValues, i4);
        this.mPrevious = Arrays.copyOf(this.mPrevious, i4);
        this.mNext = Arrays.copyOf(this.mNext, i4);
        this.mNextKeys = Arrays.copyOf(this.mNextKeys, i4);
        for (int i5 = this.mSize; i5 < i4; i5++) {
            this.mVariables[i5] = -1;
            this.mNextKeys[i5] = -1;
        }
        this.mSize = i4;
    }

    private void insertVariable(int i4, SolverVariable solverVariable, float f4) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f4);
        if (i4 != -1) {
            this.mPrevious[findEmptySlot] = i4;
            int[] iArr = this.mNext;
            iArr[findEmptySlot] = iArr[i4];
            iArr[i4] = findEmptySlot;
        } else {
            this.mPrevious[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.mNext[findEmptySlot] = this.mHead;
                this.mHead = findEmptySlot;
            } else {
                this.mNext[findEmptySlot] = -1;
            }
        }
        int i5 = this.mNext[findEmptySlot];
        if (i5 != -1) {
            this.mPrevious[i5] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFromHashMap(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.id
            int r0 = r5.mHashSize
            int r0 = r6 % r0
            int[] r1 = r5.mKeys
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            goto L_0x0039
        L_0x000e:
            int[] r4 = r5.mVariables
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.mNextKeys
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            return
        L_0x001d:
            int[] r0 = r5.mNextKeys
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.mVariables
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.removeFromHashMap(androidx.constraintlayout.core.SolverVariable):void");
    }

    public void add(SolverVariable solverVariable, float f4, boolean z4) {
        float f5 = sEpsilon;
        if (f4 <= (-f5) || f4 >= f5) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f4);
                return;
            }
            float[] fArr = this.mValues;
            float f6 = fArr[indexOf] + f4;
            fArr[indexOf] = f6;
            float f7 = sEpsilon;
            if (f6 > (-f7) && f6 < f7) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z4);
            }
        }
    }

    public void clear() {
        int i4 = this.mCount;
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i6 = 0; i6 < this.mSize; i6++) {
            this.mVariables[i6] = -1;
            this.mNextKeys[i6] = -1;
        }
        for (int i7 = 0; i7 < this.mHashSize; i7++) {
            this.mKeys[i7] = -1;
        }
        this.mCount = 0;
        this.mHead = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    public void display() {
        int i4 = this.mCount;
        System.out.print("{ ");
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i5) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f4) {
        int i4 = this.mCount;
        int i5 = this.mHead;
        int i6 = 0;
        while (i6 < i4) {
            float[] fArr = this.mValues;
            fArr[i5] = fArr[i5] / f4;
            i5 = this.mNext[i5];
            if (i5 != -1) {
                i6++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.mValues[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int i4) {
        int i5 = this.mCount;
        if (i5 == 0) {
            return null;
        }
        int i6 = this.mHead;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4 && i6 != -1) {
                return this.mCache.mIndexedVariables[this.mVariables[i6]];
            }
            i6 = this.mNext[i6];
            if (i6 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i4) {
        int i5 = this.mCount;
        int i6 = this.mHead;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4) {
                return this.mValues[i6];
            }
            i6 = this.mNext[i6];
            if (i6 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.mCount
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.id
            int r0 = r3.mHashSize
            int r0 = r4 % r0
            int[] r2 = r3.mKeys
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.mNextKeys
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.mVariables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.SolverVariableValues.indexOf(androidx.constraintlayout.core.SolverVariable):int");
    }

    public void invert() {
        int i4 = this.mCount;
        int i5 = this.mHead;
        int i6 = 0;
        while (i6 < i4) {
            float[] fArr = this.mValues;
            fArr[i5] = fArr[i5] * -1.0f;
            i5 = this.mNext[i5];
            if (i5 != -1) {
                i6++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f4) {
        float f5 = sEpsilon;
        if (f4 <= (-f5) || f4 >= f5) {
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f4);
                addToHashMap(solverVariable, 0);
                this.mHead = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.mValues[indexOf] = f4;
                return;
            }
            if (this.mCount + 1 >= this.mSize) {
                increaseSize();
            }
            int i4 = this.mCount;
            int i5 = this.mHead;
            int i6 = -1;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = this.mVariables[i5];
                int i9 = solverVariable.id;
                if (i8 == i9) {
                    this.mValues[i5] = f4;
                    return;
                }
                if (i8 < i9) {
                    i6 = i5;
                }
                i5 = this.mNext[i5];
                if (i5 == -1) {
                    break;
                }
            }
            insertVariable(i6, solverVariable, f4);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z4) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f4 = this.mValues[indexOf];
        if (this.mHead == indexOf) {
            this.mHead = this.mNext[indexOf];
        }
        this.mVariables[indexOf] = -1;
        int[] iArr = this.mPrevious;
        int i4 = iArr[indexOf];
        if (i4 != -1) {
            int[] iArr2 = this.mNext;
            iArr2[i4] = iArr2[indexOf];
        }
        int i5 = this.mNext[indexOf];
        if (i5 != -1) {
            iArr[i5] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z4) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f4;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i4 = this.mCount;
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i5) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.mPrevious[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.mVariables[this.mPrevious[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.mNext[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.mVariables[this.mNext[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z4) {
        float f4 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z4);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i4 = 0;
        int i5 = 0;
        while (i4 < currentSize) {
            int i6 = solverVariableValues.mVariables[i5];
            if (i6 != -1) {
                add(this.mCache.mIndexedVariables[i6], solverVariableValues.mValues[i5] * f4, z4);
                i4++;
            }
            i5++;
        }
        return f4;
    }
}
