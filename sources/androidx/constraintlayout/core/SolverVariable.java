package androidx.constraintlayout.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean DO_NOT_USE = false;
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int sUniqueConstantId = 1;
    private static int sUniqueErrorId = 1;
    private static int sUniqueId = 1;
    private static int sUniqueSlackId = 1;
    private static int sUniqueUnrestrictedId = 1;
    public float computedValue;
    public int id = -1;
    public boolean inGoal;
    public boolean isFinalValue = false;
    ArrayRow[] mClientEquations = new ArrayRow[16];
    int mClientEquationsCount = 0;
    int mDefinitionId = -1;
    float[] mGoalStrengthVector = new float[9];
    HashSet<ArrayRow> mInRows = null;
    boolean mIsSynonym = false;
    private String mName;
    float[] mStrengthVector = new float[9];
    int mSynonym = -1;
    float mSynonymDelta = 0.0f;
    Type mType;
    public int strength = 0;
    public int usageInRowCount = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + sUniqueErrorId;
        }
        int ordinal = type.ordinal();
        if (ordinal == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("U");
            int i4 = sUniqueUnrestrictedId + 1;
            sUniqueUnrestrictedId = i4;
            sb.append(i4);
            return sb.toString();
        } else if (ordinal == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("C");
            int i5 = sUniqueConstantId + 1;
            sUniqueConstantId = i5;
            sb2.append(i5);
            return sb2.toString();
        } else if (ordinal == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ExifInterface.LATITUDE_SOUTH);
            int i6 = sUniqueSlackId + 1;
            sUniqueSlackId = i6;
            sb3.append(i6);
            return sb3.toString();
        } else if (ordinal == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("e");
            int i7 = sUniqueErrorId + 1;
            sUniqueErrorId = i7;
            sb4.append(i7);
            return sb4.toString();
        } else if (ordinal == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int i8 = sUniqueId + 1;
            sUniqueId = i8;
            sb5.append(i8);
            return sb5.toString();
        } else {
            throw new AssertionError(type.name());
        }
    }

    static void increaseErrorId() {
        sUniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i4 = 0;
        while (true) {
            int i5 = this.mClientEquationsCount;
            if (i4 >= i5) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i5 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i6 = this.mClientEquationsCount;
                arrayRowArr2[i6] = arrayRow;
                this.mClientEquationsCount = i6 + 1;
                return;
            } else if (this.mClientEquations[i4] != arrayRow) {
                i4++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearStrengths() {
        for (int i4 = 0; i4 < 9; i4++) {
            this.mStrengthVector[i4] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i4 = this.mClientEquationsCount;
        int i5 = 0;
        while (i5 < i4) {
            if (this.mClientEquations[i5] == arrayRow) {
                while (i5 < i4 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i6 = i5 + 1;
                    arrayRowArr[i5] = arrayRowArr[i6];
                    i5 = i6;
                }
                this.mClientEquationsCount--;
                return;
            }
            i5++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.mDefinitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i4 = this.mClientEquationsCount;
        for (int i5 = 0; i5 < i4; i5++) {
            this.mClientEquations[i5] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.mGoalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f4) {
        this.computedValue = f4;
        this.isFinalValue = true;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i4 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i5 = 0; i5 < i4; i5++) {
            this.mClientEquations[i5].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f4) {
        this.mIsSynonym = true;
        this.mSynonym = solverVariable.id;
        this.mSynonymDelta = f4;
        int i4 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i5 = 0; i5 < i4; i5++) {
            this.mClientEquations[i5].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public String strengthsToString() {
        String str = this + "[";
        boolean z4 = false;
        boolean z5 = true;
        for (int i4 = 0; i4 < this.mStrengthVector.length; i4++) {
            String str2 = str + this.mStrengthVector[i4];
            float[] fArr = this.mStrengthVector;
            float f4 = fArr[i4];
            if (f4 > 0.0f) {
                z4 = false;
            } else if (f4 < 0.0f) {
                z4 = true;
            }
            if (f4 != 0.0f) {
                z5 = false;
            }
            if (i4 < fArr.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        if (z4) {
            str = str + " (-)";
        }
        if (!z5) {
            return str;
        }
        return str + " (*)";
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i4 = this.mClientEquationsCount;
        for (int i5 = 0; i5 < i4; i5++) {
            this.mClientEquations[i5].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public int compareTo(SolverVariable solverVariable) {
        return this.id - solverVariable.id;
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }
}
