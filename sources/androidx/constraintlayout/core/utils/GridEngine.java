package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine() {
    }

    private void addAllConstraintPositions() {
        for (int i4 = 0; i4 < this.mNumWidgets; i4++) {
            if (leftOfWidget(i4) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition != -1) {
                    addConstraintPosition(i4, rowByIndex, colByIndex, 1, 1);
                } else {
                    return;
                }
            }
        }
    }

    private void addConstraintPosition(int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.mConstraintMatrix[i4];
        iArr[0] = i6;
        iArr[1] = i5;
        iArr[2] = (i6 + i8) - 1;
        iArr[3] = (i5 + i7) - 1;
    }

    private void fillConstraintMatrix(boolean z4) {
        int[][] parseSpans;
        int[][] parseSpans2;
        if (z4) {
            for (int i4 = 0; i4 < this.mPositionMatrix.length; i4++) {
                int i5 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i5 >= zArr[0].length) {
                        break;
                    }
                    zArr[i4][i5] = true;
                    i5++;
                }
            }
            for (int i6 = 0; i6 < this.mConstraintMatrix.length; i6++) {
                int i7 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i7 >= iArr[0].length) {
                        break;
                    }
                    iArr[i6][i7] = -1;
                    i7++;
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mStrSkips;
        if (!(str == null || str.trim().isEmpty() || (parseSpans2 = parseSpans(this.mStrSkips)) == null)) {
            handleSkips(parseSpans2);
        }
        String str2 = this.mStrSpans;
        if (!(str2 == null || str2.trim().isEmpty() || (parseSpans = parseSpans(this.mStrSpans)) == null)) {
            handleSpans(parseSpans);
        }
        addAllConstraintPositions();
    }

    private int getColByIndex(int i4) {
        if (this.mOrientation == 1) {
            return i4 / this.mRows;
        }
        return i4 % this.mColumns;
    }

    private int getNextPosition() {
        boolean z4 = false;
        int i4 = 0;
        while (!z4) {
            i4 = this.mNextAvailableIndex;
            if (i4 >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i4);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z4 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i4;
    }

    private int getRowByIndex(int i4) {
        if (this.mOrientation == 1) {
            return i4 % this.mRows;
        }
        return i4 / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        int i4 = 0;
        while (i4 < iArr.length) {
            int rowByIndex = getRowByIndex(iArr[i4][0]);
            int colByIndex = getColByIndex(iArr[i4][0]);
            int[] iArr2 = iArr[i4];
            if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                i4++;
            } else {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        int i4 = 0;
        while (i4 < iArr.length) {
            int rowByIndex = getRowByIndex(iArr[i4][0]);
            int colByIndex = getColByIndex(iArr[i4][0]);
            int[] iArr2 = iArr[i4];
            if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                int[] iArr3 = iArr[i4];
                addConstraintPosition(i4, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                i4++;
            } else {
                return;
            }
        }
    }

    private void initVariables() {
        int i4 = this.mRows;
        int[] iArr = new int[2];
        iArr[1] = this.mColumns;
        iArr[0] = i4;
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, iArr);
        this.mPositionMatrix = zArr;
        for (boolean[] fill : zArr) {
            Arrays.fill(fill, true);
        }
        int i5 = this.mNumWidgets;
        if (i5 > 0) {
            int[] iArr2 = new int[2];
            iArr2[1] = 4;
            iArr2[0] = i5;
            int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, iArr2);
            this.mConstraintMatrix = iArr3;
            for (int[] fill2 : iArr3) {
                Arrays.fill(fill2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i4, int i5, int i6, int i7) {
        for (int i8 = i4; i8 < i4 + i6; i8++) {
            int i9 = i5;
            while (i9 < i5 + i7) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i8 < zArr.length && i9 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i8];
                    if (zArr2[i9]) {
                        zArr2[i9] = false;
                        i9++;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] split = str.split(",");
        int length = split.length;
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = length;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i4 = 0; i4 < split.length; i4++) {
            String[] split2 = split[i4].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr2[i4][0] = Integer.parseInt(split2[0]);
            iArr2[i4][1] = Integer.parseInt(split3[0]);
            iArr2[i4][2] = Integer.parseInt(split3[1]);
        }
        return iArr2;
    }

    private void updateActualRowsAndColumns() {
        int i4;
        int i5 = this.mRowsSet;
        if (i5 == 0 || (i4 = this.mColumnsSet) == 0) {
            int i6 = this.mColumnsSet;
            if (i6 > 0) {
                this.mColumns = i6;
                this.mRows = ((this.mNumWidgets + i6) - 1) / i6;
            } else if (i5 > 0) {
                this.mRows = i5;
                this.mColumns = ((this.mNumWidgets + i5) - 1) / i5;
            } else {
                int sqrt = (int) (Math.sqrt((double) this.mNumWidgets) + 1.5d);
                this.mRows = sqrt;
                this.mColumns = ((this.mNumWidgets + sqrt) - 1) / sqrt;
            }
        } else {
            this.mRows = i5;
            this.mColumns = i4;
        }
    }

    public int bottomOfWidget(int i4) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i4 >= iArr.length) {
            return 0;
        }
        return iArr[i4][3];
    }

    public int leftOfWidget(int i4) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i4 >= iArr.length) {
            return 0;
        }
        return iArr[i4][0];
    }

    public int rightOfWidget(int i4) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i4 >= iArr.length) {
            return 0;
        }
        return iArr[i4][2];
    }

    public void setColumns(int i4) {
        if (i4 <= 50 && this.mColumnsSet != i4) {
            this.mColumnsSet = i4;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i4) {
        if (i4 <= this.mRows * this.mColumns) {
            this.mNumWidgets = i4;
        }
    }

    public void setOrientation(int i4) {
        if ((i4 == 0 || i4 == 1) && this.mOrientation != i4) {
            this.mOrientation = i4;
        }
    }

    public void setRows(int i4) {
        if (i4 <= 50 && this.mRowsSet != i4) {
            this.mRowsSet = i4;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z4 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z4 = true;
        }
        if (!z4) {
            initVariables();
        }
        fillConstraintMatrix(z4);
    }

    public int topOfWidget(int i4) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i4 >= iArr.length) {
            return 0;
        }
        return iArr[i4][1];
    }

    public GridEngine(int i4, int i5) {
        this.mRowsSet = i4;
        this.mColumnsSet = i5;
        if (i4 > 50) {
            this.mRowsSet = 3;
        }
        if (i5 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int i4, int i5, int i6) {
        this.mRowsSet = i4;
        this.mColumnsSet = i5;
        this.mNumWidgets = i6;
        if (i4 > 50) {
            this.mRowsSet = 3;
        }
        if (i5 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i7 = this.mRows;
        int i8 = this.mColumns;
        if (i6 > i7 * i8 || i6 < 1) {
            this.mNumWidgets = i7 * i8;
        }
        initVariables();
        fillConstraintMatrix(false);
    }
}
