package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    public boolean graphOptimizer = false;
    public boolean hasSimpleDefinition = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns = 32;
    private int mMaxRows = 32;
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mPoolSize = 1000;
    private SolverVariable[] mPoolVariables = new SolverVariable[1000];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];
    private int mTableSize = 32;
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables = null;
    int mVariablesID = 0;
    public boolean newgraphOptimizer = false;

    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z4);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z4);

        void updateFromSystem(LinearSystem linearSystem);
    }

    static class ValuesRow extends ArrayRow {
        ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.mSolverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i4 = this.mPoolVariablesCount;
        int i5 = this.mPoolSize;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.mPoolSize = i6;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i6);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i7 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i7 + 1;
        solverVariableArr[i7] = acquire;
        return acquire;
    }

    private void addRow(ArrayRow arrayRow) {
        int i4;
        if (!SIMPLIFY_SYNONYMS || !arrayRow.mIsSimpleDefinition) {
            ArrayRow[] arrayRowArr = this.mRows;
            int i5 = this.mNumRows;
            arrayRowArr[i5] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i5;
            this.mNumRows = i5 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        } else {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i6 = 0;
            while (i6 < this.mNumRows) {
                if (this.mRows[i6] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i6];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i6] = null;
                    int i7 = i6 + 1;
                    int i8 = i7;
                    while (true) {
                        i4 = this.mNumRows;
                        if (i7 >= i4) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i9 = i7 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i7];
                        arrayRowArr2[i9] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i7) {
                            solverVariable2.mDefinitionId = i9;
                        }
                        i8 = i7;
                        i7++;
                    }
                    if (i8 < i4) {
                        this.mRows[i8] = null;
                    }
                    this.mNumRows = i4 - 1;
                    i6--;
                }
                i6++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            ArrayRow arrayRow = this.mRows[i4];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f4) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f4);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, (String) null);
        acquireSolverVariable.setName(str);
        int i4 = this.mVariablesID + 1;
        this.mVariablesID = i4;
        this.mNumColumns++;
        acquireSolverVariable.id = i4;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            str = (str + this.mRows[i4]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(Row row) throws Exception {
        long j4;
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            ArrayRow arrayRow = this.mRows[i4];
            if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f4 = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z4 = false;
                    int i5 = 0;
                    while (!z4) {
                        Metrics metrics = sMetrics;
                        long j5 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i5++;
                        float f5 = Float.MAX_VALUE;
                        int i6 = 0;
                        int i7 = -1;
                        int i8 = -1;
                        int i9 = 0;
                        while (true) {
                            if (i6 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i6];
                            if (arrayRow2.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.mIsSimpleDefinition && arrayRow2.mConstantValue < f4) {
                                if (SKIP_COLUMNS) {
                                    int currentSize = arrayRow2.variables.getCurrentSize();
                                    int i10 = 0;
                                    while (i10 < currentSize) {
                                        SolverVariable variable = arrayRow2.variables.getVariable(i10);
                                        long j6 = j5;
                                        float f6 = arrayRow2.variables.get(variable);
                                        if (f6 > 0.0f) {
                                            for (int i11 = 0; i11 < 9; i11++) {
                                                float f7 = variable.mStrengthVector[i11] / f6;
                                                if ((f7 < f5 && i11 == i9) || i11 > i9) {
                                                    i9 = i11;
                                                    i8 = variable.id;
                                                    i7 = i6;
                                                    f5 = f7;
                                                }
                                            }
                                        }
                                        i10++;
                                        j5 = j6;
                                    }
                                } else {
                                    j4 = j5;
                                    for (int i12 = 1; i12 < this.mNumColumns; i12++) {
                                        SolverVariable solverVariable = this.mCache.mIndexedVariables[i12];
                                        float f8 = arrayRow2.variables.get(solverVariable);
                                        if (f8 > 0.0f) {
                                            for (int i13 = 0; i13 < 9; i13++) {
                                                float f9 = solverVariable.mStrengthVector[i13] / f8;
                                                if ((f9 < f5 && i13 == i9) || i13 > i9) {
                                                    i9 = i13;
                                                    f5 = f9;
                                                    i7 = i6;
                                                    i8 = i12;
                                                }
                                            }
                                        }
                                    }
                                    i6++;
                                    j5 = j4;
                                    f4 = 0.0f;
                                }
                            }
                            j4 = j5;
                            i6++;
                            j5 = j4;
                            f4 = 0.0f;
                        }
                        long j7 = j5;
                        if (i7 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i7];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j7;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i8]);
                            SolverVariable solverVariable2 = arrayRow3.mVariable;
                            solverVariable2.mDefinitionId = i7;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z4 = true;
                        }
                        if (i5 > this.mNumColumns / 2) {
                            z4 = true;
                        }
                        f4 = 0.0f;
                    }
                    return i5;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i4) {
        int i5 = i4 * 4;
        int i6 = i5 / 1024;
        int i7 = i6 / 1024;
        if (i7 > 0) {
            return "" + i7 + " Mb";
        } else if (i6 > 0) {
            return "" + i6 + " Kb";
        } else {
            return "" + i5 + " bytes";
        }
    }

    private String getDisplayStrength(int i4) {
        if (i4 == 1) {
            return "LOW";
        }
        if (i4 == 2) {
            return "MEDIUM";
        }
        if (i4 == 3) {
            return "HIGH";
        }
        if (i4 == 4) {
            return "HIGHEST";
        }
        if (i4 == 5) {
            return "EQUALITY";
        }
        if (i4 == 8) {
            return "FIXED";
        }
        if (i4 == 6) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i4 = this.mTableSize * 2;
        this.mTableSize = i4;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i4);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.mTableSize);
        int i5 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i5];
        this.mMaxColumns = i5;
        this.mMaxRows = i5;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, (long) i5);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z4) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i4 = 0; i4 < this.mNumColumns; i4++) {
            this.mAlreadyTestedCandidates[i4] = false;
        }
        boolean z5 = false;
        int i5 = 0;
        while (!z5) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i5++;
            if (i5 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i6 = pivotCandidate.id;
                    if (!zArr[i6]) {
                        zArr[i6] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f4 = Float.MAX_VALUE;
                    int i7 = -1;
                    for (int i8 = 0; i8 < this.mNumRows; i8++) {
                        ArrayRow arrayRow = this.mRows[i8];
                        if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f5 = arrayRow.variables.get(pivotCandidate);
                            if (f5 < 0.0f) {
                                float f6 = (-arrayRow.mConstantValue) / f5;
                                if (f6 < f4) {
                                    i7 = i8;
                                    f4 = f6;
                                }
                            }
                        }
                    }
                    if (i7 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i7];
                        arrayRow2.mVariable.mDefinitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.mVariable;
                        solverVariable.mDefinitionId = i7;
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z5 = true;
                }
            }
            return i5;
        }
        return i5;
    }

    private void releaseRows() {
        int i4 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i4 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i4];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i4] = null;
                i4++;
            }
            return;
        }
        while (i4 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i4];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i4] = null;
            i4++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f4, int i4) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget3.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget3.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget3.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget3.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget4.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget4.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget4.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget4.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d5 = (double) f4;
        SolverVariable solverVariable = createObjectVariable5;
        double d6 = (double) i4;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d5) * d6));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        SolverVariable solverVariable2 = createObjectVariable3;
        createRow2.createRowWithAngle(createObjectVariable, solverVariable2, solverVariable, createObjectVariable7, (float) (Math.cos(d5) * d6));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, float f4, SolverVariable solverVariable3, SolverVariable solverVariable4, int i5, int i6) {
        int i7 = i6;
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i4, f4, solverVariable3, solverVariable4, i5);
        if (i7 != 8) {
            createRow.addError(this, i7);
        }
        addConstraint(createRow);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0004
            goto L_0x00a8
        L_0x0004:
            androidx.constraintlayout.core.Metrics r0 = sMetrics
            r1 = 1
            if (r0 == 0) goto L_0x0018
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r3 = r8.mIsSimpleDefinition
            if (r3 == 0) goto L_0x0018
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L_0x0018:
            int r0 = r7.mNumRows
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L_0x0027
            int r0 = r7.mNumColumns
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L_0x002a
        L_0x0027:
            r7.increaseTableSize()
        L_0x002a:
            boolean r0 = r8.mIsSimpleDefinition
            r4 = 0
            if (r0 != 0) goto L_0x00a3
            r8.updateFromSystem(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L_0x003a
            goto L_0x00a8
        L_0x003a:
            r8.ensurePositiveConstant()
            boolean r0 = r8.chooseSubject(r7)
            if (r0 == 0) goto L_0x009a
            androidx.constraintlayout.core.SolverVariable r0 = r7.createExtraVariable()
            r8.mVariable = r0
            int r5 = r7.mNumRows
            r7.addRow(r8)
            int r6 = r7.mNumRows
            int r5 = r5 + r3
            if (r6 != r5) goto L_0x009a
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r4.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r7.optimize(r4, r3)
            int r4 = r0.mDefinitionId
            r5 = -1
            if (r4 != r5) goto L_0x009b
            androidx.constraintlayout.core.SolverVariable r4 = r8.mVariable
            if (r4 != r0) goto L_0x0078
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r0)
            if (r0 == 0) goto L_0x0078
            androidx.constraintlayout.core.Metrics r4 = sMetrics
            if (r4 == 0) goto L_0x0075
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L_0x0075:
            r8.pivot(r0)
        L_0x0078:
            boolean r0 = r8.mIsSimpleDefinition
            if (r0 != 0) goto L_0x0081
            androidx.constraintlayout.core.SolverVariable r0 = r8.mVariable
            r0.updateReferencesWithNewDefinition(r7, r8)
        L_0x0081:
            boolean r0 = OPTIMIZED_ENGINE
            if (r0 == 0) goto L_0x008d
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.mOptimizedArrayRowPool
            r0.release(r8)
            goto L_0x0094
        L_0x008d:
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.mArrayRowPool
            r0.release(r8)
        L_0x0094:
            int r0 = r7.mNumRows
            int r0 = r0 - r3
            r7.mNumRows = r0
            goto L_0x009b
        L_0x009a:
            r3 = 0
        L_0x009b:
            boolean r0 = r8.hasKeyVariable()
            if (r0 != 0) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r4 = r3
        L_0x00a3:
            if (r4 != 0) goto L_0x00a8
            r7.addRow(r8)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, int i5) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (!USE_BASIC_SYNONYMS || i5 != 8 || !solverVariable2.isFinalValue || solverVariable.mDefinitionId != -1) {
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, solverVariable2, i4);
            if (i5 != 8) {
                createRow.addError(this, i5);
            }
            addConstraint(createRow);
            return createRow;
        }
        solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i4));
        return null;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, boolean z4) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i4);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, int i5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i4);
        if (i5 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i5);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, boolean z4) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i4);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i4, int i5) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i4);
        if (i5 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i5);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f4, int i4) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f4);
        if (i4 != 8) {
            createRow.addError(this, i4);
        }
        addConstraint(createRow);
    }

    /* access modifiers changed from: package-private */
    public void addSingleError(ArrayRow arrayRow, int i4, int i5) {
        arrayRow.addSingleError(createErrorVariable(i5, (String) null), i4);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i4) {
        if (solverVariable.mDefinitionId == -1 && i4 == 0) {
            if (solverVariable2.mIsSynonym) {
                solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
            }
            if (solverVariable.mIsSynonym) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
            } else {
                solverVariable.setSynonym(this, solverVariable2, 0.0f);
            }
        } else {
            addEquality(solverVariable, solverVariable2, i4, 8);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cleanupRows() {
        int i4;
        int i5 = 0;
        while (i5 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.mVariable;
                solverVariable.computedValue = arrayRow.mConstantValue;
                solverVariable.removeFromRow(arrayRow);
                int i6 = i5;
                while (true) {
                    i4 = this.mNumRows;
                    if (i6 >= i4 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i7 = i6 + 1;
                    arrayRowArr[i6] = arrayRowArr[i7];
                    i6 = i7;
                }
                this.mRows[i4 - 1] = null;
                this.mNumRows = i4 - 1;
                i5--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.mArrayRowPool.release(arrayRow);
                }
            }
            i5++;
        }
    }

    public SolverVariable createErrorVariable(int i4, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i5 = this.mVariablesID + 1;
        this.mVariablesID = i5;
        this.mNumColumns++;
        acquireSolverVariable.id = i5;
        acquireSolverVariable.strength = i4;
        this.mCache.mIndexedVariables[i5] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i4 = this.mVariablesID + 1;
        this.mVariablesID = i4;
        this.mNumColumns++;
        acquireSolverVariable.id = i4;
        this.mCache.mIndexedVariables[i4] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i4 = solverVariable.id;
            if (i4 != -1 && i4 <= this.mVariablesID && this.mCache.mIndexedVariables[i4] != null) {
                return solverVariable;
            }
            if (i4 != -1) {
                solverVariable.reset();
            }
            int i5 = this.mVariablesID + 1;
            this.mVariablesID = i5;
            this.mNumColumns++;
            solverVariable.id = i5;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i5] = solverVariable;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = this.mCache.mOptimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = this.mCache.mArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i4 = this.mVariablesID + 1;
        this.mVariablesID = i4;
        this.mNumColumns++;
        acquireSolverVariable.id = i4;
        this.mCache.mIndexedVariables[i4] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = " num vars " + this.mVariablesID + "\n";
        for (int i4 = 0; i4 < this.mVariablesID + 1; i4++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i4];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i4 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i5 = 0; i5 < this.mVariablesID + 1; i5++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i5];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                str2 = str2 + " ~[" + i5 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.mSynonym] + " + " + solverVariable2.mSynonymDelta + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            str3 = (str3 + this.mRows[i6].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str3 = str3 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str3);
    }

    /* access modifiers changed from: package-private */
    public void displaySystemInformation() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.mTableSize; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                i4 += arrayRow.sizeInBytes();
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            ArrayRow arrayRow2 = this.mRows[i7];
            if (arrayRow2 != null) {
                i6 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.mTableSize);
        sb.append(" (");
        int i8 = this.mTableSize;
        sb.append(getDisplaySize(i8 * i8));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(i4));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(i6));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i4 = 0; i4 < this.mNumRows; i4++) {
            if (this.mRows[i4].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i4].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    /* access modifiers changed from: package-private */
    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                i4 += arrayRow.sizeInBytes();
            }
        }
        return i4;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow getRow(int i4) {
        return this.mRows[i4];
    }

    /* access modifiers changed from: package-private */
    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        if (solverVariable == null) {
            return createVariable(str, type);
        }
        return solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
        } else if (this.graphOptimizer || this.newgraphOptimizer) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.graphOptimizer++;
            }
            for (int i4 = 0; i4 < this.mNumRows; i4++) {
                if (!this.mRows[i4].mIsSimpleDefinition) {
                    minimizeGoal(this.mGoal);
                    return;
                }
            }
            Metrics metrics3 = sMetrics;
            if (metrics3 != null) {
                metrics3.fullySolved++;
            }
            computeValues();
        } else {
            minimizeGoal(this.mGoal);
        }
    }

    /* access modifiers changed from: package-private */
    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long) this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, (long) this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i4;
        if (arrayRow.mIsSimpleDefinition && (solverVariable = arrayRow.mVariable) != null) {
            int i5 = solverVariable.mDefinitionId;
            if (i5 != -1) {
                while (true) {
                    i4 = this.mNumRows;
                    if (i5 >= i4 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i6 = i5 + 1;
                    ArrayRow arrayRow2 = arrayRowArr[i6];
                    SolverVariable solverVariable2 = arrayRow2.mVariable;
                    if (solverVariable2.mDefinitionId == i6) {
                        solverVariable2.mDefinitionId = i5;
                    }
                    arrayRowArr[i5] = arrayRow2;
                    i5 = i6;
                }
                this.mNumRows = i4 - 1;
            }
            SolverVariable solverVariable3 = arrayRow.mVariable;
            if (!solverVariable3.isFinalValue) {
                solverVariable3.setFinalValue(this, arrayRow.mConstantValue);
            }
            if (OPTIMIZED_ENGINE) {
                this.mCache.mOptimizedArrayRowPool.release(arrayRow);
            } else {
                this.mCache.mArrayRowPool.release(arrayRow);
            }
        }
    }

    public void reset() {
        Cache cache;
        int i4 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i4 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i4];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i4++;
        }
        cache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                arrayRow.mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i4) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (!USE_BASIC_SYNONYMS || solverVariable.mDefinitionId != -1) {
            int i5 = solverVariable.mDefinitionId;
            if (i5 != -1) {
                ArrayRow arrayRow = this.mRows[i5];
                if (arrayRow.mIsSimpleDefinition) {
                    arrayRow.mConstantValue = (float) i4;
                } else if (arrayRow.variables.getCurrentSize() == 0) {
                    arrayRow.mIsSimpleDefinition = true;
                    arrayRow.mConstantValue = (float) i4;
                } else {
                    ArrayRow createRow = createRow();
                    createRow.createRowEquals(solverVariable, i4);
                    addConstraint(createRow);
                }
            } else {
                ArrayRow createRow2 = createRow();
                createRow2.createRowDefinition(solverVariable, i4);
                addConstraint(createRow2);
            }
        } else {
            float f4 = (float) i4;
            solverVariable.setFinalValue(this, f4);
            for (int i6 = 0; i6 < this.mVariablesID + 1; i6++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i6];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.mSynonymDelta + f4);
                }
            }
        }
    }
}
