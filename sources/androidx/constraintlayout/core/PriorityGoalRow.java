package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor = new GoalVariableAccessor(this);
    private SolverVariable[] mArrayGoals = new SolverVariable[128];
    Cache mCache;
    private int mNumGoals = 0;
    private SolverVariable[] mSortArray = new SolverVariable[128];
    private int mTableSize = 128;

    class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f4 = fArr[i4] + solverVariable.mGoalStrengthVector[i4];
                fArr[i4] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i4] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f4) {
            boolean z4 = true;
            if (this.mVariable.inGoal) {
                for (int i4 = 0; i4 < 9; i4++) {
                    float[] fArr = this.mVariable.mGoalStrengthVector;
                    float f5 = fArr[i4] + (solverVariable.mGoalStrengthVector[i4] * f4);
                    fArr[i4] = f5;
                    if (Math.abs(f5) < 1.0E-4f) {
                        this.mVariable.mGoalStrengthVector[i4] = 0.0f;
                    } else {
                        z4 = false;
                    }
                }
                if (z4) {
                    PriorityGoalRow.this.removeGoal(this.mVariable);
                }
                return false;
            }
            for (int i5 = 0; i5 < 9; i5++) {
                float f6 = solverVariable.mGoalStrengthVector[i5];
                if (f6 != 0.0f) {
                    float f7 = f6 * f4;
                    if (Math.abs(f7) < 1.0E-4f) {
                        f7 = 0.0f;
                    }
                    this.mVariable.mGoalStrengthVector[i5] = f7;
                } else {
                    this.mVariable.mGoalStrengthVector[i5] = 0.0f;
                }
            }
            return true;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i4 = 8; i4 >= 0; i4--) {
                float f4 = this.mVariable.mGoalStrengthVector[i4];
                if (f4 > 0.0f) {
                    return false;
                }
                if (f4 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i4 = 0; i4 < 9; i4++) {
                if (this.mVariable.mGoalStrengthVector[i4] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i4 = 8;
            while (true) {
                if (i4 < 0) {
                    break;
                }
                float f4 = solverVariable.mGoalStrengthVector[i4];
                float f5 = this.mVariable.mGoalStrengthVector[i4];
                if (f5 == f4) {
                    i4--;
                } else if (f5 < f4) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.mVariable != null) {
                for (int i4 = 0; i4 < 9; i4++) {
                    str = str + this.mVariable.mGoalStrengthVector[i4] + " ";
                }
            }
            return str + "] " + this.mVariable;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i4;
        int i5 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i5 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i6 = this.mNumGoals;
        solverVariableArr3[i6] = solverVariable;
        int i7 = i6 + 1;
        this.mNumGoals = i7;
        if (i7 > 1 && solverVariableArr3[i6].id > solverVariable.id) {
            int i8 = 0;
            while (true) {
                i4 = this.mNumGoals;
                if (i8 >= i4) {
                    break;
                }
                this.mSortArray[i8] = this.mArrayGoals[i8];
                i8++;
            }
            Arrays.sort(this.mSortArray, 0, i4, new Comparator<SolverVariable>() {
                public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
                    return solverVariable.id - solverVariable2.id;
                }
            });
            for (int i9 = 0; i9 < this.mNumGoals; i9++) {
                this.mArrayGoals[i9] = this.mSortArray[i9];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i4 = 0;
        while (i4 < this.mNumGoals) {
            if (this.mArrayGoals[i4] == solverVariable) {
                while (true) {
                    int i5 = this.mNumGoals;
                    if (i4 < i5 - 1) {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i6 = i4 + 1;
                        solverVariableArr[i4] = solverVariableArr[i6];
                        i4 = i6;
                    } else {
                        this.mNumGoals = i5 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i4++;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i4 = -1;
        for (int i5 = 0; i5 < this.mNumGoals; i5++) {
            SolverVariable solverVariable = this.mArrayGoals[i5];
            if (!zArr[solverVariable.id]) {
                this.mAccessor.init(solverVariable);
                if (i4 == -1) {
                    if (!this.mAccessor.isNegative()) {
                    }
                } else if (!this.mAccessor.isSmallerThan(this.mArrayGoals[i4])) {
                }
                i4 = i5;
            }
        }
        if (i4 == -1) {
            return null;
        }
        return this.mArrayGoals[i4];
    }

    public boolean isEmpty() {
        if (this.mNumGoals == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.mConstantValue + ") : ";
        for (int i4 = 0; i4 < this.mNumGoals; i4++) {
            this.mAccessor.init(this.mArrayGoals[i4]);
            str = str + this.mAccessor + " ";
        }
        return str;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z4) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i4 = 0; i4 < currentSize; i4++) {
                SolverVariable variable = arrayRowVariables.getVariable(i4);
                float variableValue = arrayRowVariables.getVariableValue(i4);
                this.mAccessor.init(variable);
                if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                    addToGoal(variable);
                }
                this.mConstantValue += arrayRow.mConstantValue * variableValue;
            }
            removeGoal(solverVariable);
        }
    }
}
