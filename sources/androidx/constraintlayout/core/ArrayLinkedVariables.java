package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    protected final Cache mCache;
    private SolverVariable mCandidate = null;
    int mCurrentSize = 0;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;
    private int mRowSize = 8;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public void add(SolverVariable solverVariable, float f4, boolean z4) {
        float f5 = sEpsilon;
        if (f4 <= (-f5) || f4 >= f5) {
            int i4 = this.mHead;
            if (i4 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f4;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (!this.mDidFillOnce) {
                    int i5 = this.mLast + 1;
                    this.mLast = i5;
                    int[] iArr = this.mArrayIndices;
                    if (i5 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i6 = 0;
            int i7 = -1;
            while (i4 != -1 && i6 < this.mCurrentSize) {
                int i8 = this.mArrayIndices[i4];
                int i9 = solverVariable.id;
                if (i8 == i9) {
                    float[] fArr = this.mArrayValues;
                    float f6 = fArr[i4] + f4;
                    float f7 = sEpsilon;
                    if (f6 > (-f7) && f6 < f7) {
                        f6 = 0.0f;
                    }
                    fArr[i4] = f6;
                    if (f6 == 0.0f) {
                        if (i4 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i4];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i7] = iArr2[i4];
                        }
                        if (z4) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i4;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i8 < i9) {
                    i7 = i4;
                }
                i4 = this.mArrayNextIndices[i4];
                i6++;
            }
            int i10 = this.mLast;
            int i11 = i10 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i10] != -1) {
                    i10 = iArr3.length;
                }
            } else {
                i10 = i11;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i10 >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i12 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i12 >= iArr5.length) {
                        break;
                    } else if (iArr5[i12] == -1) {
                        i10 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i10 >= iArr6.length) {
                i10 = iArr6.length;
                int i13 = this.mRowSize * 2;
                this.mRowSize = i13;
                this.mDidFillOnce = false;
                this.mLast = i10 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[i10] = solverVariable.id;
            this.mArrayValues[i10] = f4;
            if (i7 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i10] = iArr7[i7];
                iArr7[i7] = i10;
            } else {
                this.mArrayNextIndices[i10] = this.mHead;
                this.mHead = i10;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i14 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i14 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    public final void clear() {
        int i4 = this.mHead;
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i4]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    public boolean contains(SolverVariable solverVariable) {
        int i4 = this.mHead;
        if (i4 == -1) {
            return false;
        }
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayIndices[i4] == solverVariable.id) {
                return true;
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return false;
    }

    public void display() {
        int i4 = this.mCurrentSize;
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
        int i4 = this.mHead;
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i4] = fArr[i4] / f4;
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i4 = this.mHead;
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayIndices[i4] == solverVariable.id) {
                return this.mArrayValues[i4];
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i4) {
        return this.mArrayIndices[i4];
    }

    public final int getNextIndice(int i4) {
        return this.mArrayNextIndices[i4];
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i4 = this.mHead;
        int i5 = 0;
        SolverVariable solverVariable2 = null;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayValues[i4] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i4]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return solverVariable2;
    }

    public final float getValue(int i4) {
        return this.mArrayValues[i4];
    }

    public SolverVariable getVariable(int i4) {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (i6 == i4) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return null;
    }

    public float getVariableValue(int i4) {
        int i5 = this.mHead;
        int i6 = 0;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (i6 == i4) {
                return this.mArrayValues[i5];
            }
            i5 = this.mArrayNextIndices[i5];
            i6++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAtLeastOnePositiveVariable() {
        int i4 = this.mHead;
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayValues[i4] > 0.0f) {
                return true;
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return false;
    }

    public int indexOf(SolverVariable solverVariable) {
        int i4 = this.mHead;
        if (i4 == -1) {
            return -1;
        }
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayIndices[i4] == solverVariable.id) {
                return i4;
            }
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return -1;
    }

    public void invert() {
        int i4 = this.mHead;
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i4] = fArr[i4] * -1.0f;
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
    }

    public final void put(SolverVariable solverVariable, float f4) {
        if (f4 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i4 = this.mHead;
        if (i4 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f4;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                int i5 = this.mLast + 1;
                this.mLast = i5;
                int[] iArr = this.mArrayIndices;
                if (i5 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i6 = 0;
        int i7 = -1;
        while (i4 != -1 && i6 < this.mCurrentSize) {
            int i8 = this.mArrayIndices[i4];
            int i9 = solverVariable.id;
            if (i8 == i9) {
                this.mArrayValues[i4] = f4;
                return;
            }
            if (i8 < i9) {
                i7 = i4;
            }
            i4 = this.mArrayNextIndices[i4];
            i6++;
        }
        int i10 = this.mLast;
        int i11 = i10 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i10] != -1) {
                i10 = iArr2.length;
            }
        } else {
            i10 = i11;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i10 >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i12 >= iArr4.length) {
                    break;
                } else if (iArr4[i12] == -1) {
                    i10 = i12;
                    break;
                } else {
                    i12++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i10 >= iArr5.length) {
            i10 = iArr5.length;
            int i13 = this.mRowSize * 2;
            this.mRowSize = i13;
            this.mDidFillOnce = false;
            this.mLast = i10 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[i10] = solverVariable.id;
        this.mArrayValues[i10] = f4;
        if (i7 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i10] = iArr6[i7];
            iArr6[i7] = i10;
        } else {
            this.mArrayNextIndices[i10] = this.mHead;
            this.mHead = i10;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i14 = this.mCurrentSize + 1;
        this.mCurrentSize = i14;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i14 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z4) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i4 = this.mHead;
        if (i4 == -1) {
            return 0.0f;
        }
        int i5 = 0;
        int i6 = -1;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            if (this.mArrayIndices[i4] == solverVariable.id) {
                if (i4 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i4];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i6] = iArr[i4];
                }
                if (z4) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i4] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i4;
                }
                return this.mArrayValues[i4];
            }
            i5++;
            i6 = i4;
            i4 = this.mArrayNextIndices[i4];
        }
        return 0.0f;
    }

    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i4 = this.mHead;
        String str = "";
        int i5 = 0;
        while (i4 != -1 && i5 < this.mCurrentSize) {
            str = ((str + " -> ") + this.mArrayValues[i4] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i4]];
            i4 = this.mArrayNextIndices[i4];
            i5++;
        }
        return str;
    }

    public float use(ArrayRow arrayRow, boolean z4) {
        float f4 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z4);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i4 = 0; i4 < currentSize; i4++) {
            SolverVariable variable = arrayRowVariables.getVariable(i4);
            add(variable, arrayRowVariables.get(variable) * f4, z4);
        }
        return f4;
    }
}
