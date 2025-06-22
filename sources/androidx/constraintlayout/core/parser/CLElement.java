package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import j$.util.Objects;
import java.io.PrintStream;
import java.util.Arrays;

public class CLElement implements Cloneable {
    protected static int sBaseIndent = 2;
    protected static int sMaxLine = 80;
    protected CLContainer mContainer;
    private final char[] mContent;
    protected long mEnd = Long.MAX_VALUE;
    private int mLine;
    protected long mStart = -1;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    /* access modifiers changed from: protected */
    public void addIndent(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append(' ');
        }
    }

    public String content() {
        String str = new String(this.mContent);
        if (str.length() < 1) {
            return "";
        }
        long j4 = this.mEnd;
        if (j4 != Long.MAX_VALUE) {
            long j5 = this.mStart;
            if (j4 >= j5) {
                return str.substring((int) j5, ((int) j4) + 1);
            }
        }
        long j6 = this.mStart;
        return str.substring((int) j6, ((int) j6) + 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        if (this.mStart == cLElement.mStart && this.mEnd == cLElement.mEnd && this.mLine == cLElement.mLine && Arrays.equals(this.mContent, cLElement.mContent)) {
            return Objects.equals(this.mContainer, cLElement.mContainer);
        }
        return false;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: protected */
    public String getDebugName() {
        if (!CLParser.sDebug) {
            return "";
        }
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.mEnd;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.mLine;
    }

    public long getStart() {
        return this.mStart;
    }

    /* access modifiers changed from: protected */
    public String getStrClass() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public boolean hasContent() {
        char[] cArr = this.mContent;
        if (cArr == null || cArr.length < 1) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i4;
        long j4 = this.mStart;
        long j5 = this.mEnd;
        int hashCode = ((((Arrays.hashCode(this.mContent) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            i4 = cLContainer.hashCode();
        } else {
            i4 = 0;
        }
        return ((hashCode + i4) * 31) + this.mLine;
    }

    public boolean isDone() {
        if (this.mEnd != Long.MAX_VALUE) {
            return true;
        }
        return false;
    }

    public boolean isStarted() {
        if (this.mStart > -1) {
            return true;
        }
        return false;
    }

    public boolean notStarted() {
        if (this.mStart == -1) {
            return true;
        }
        return false;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j4) {
        if (this.mEnd == Long.MAX_VALUE) {
            this.mEnd = j4;
            if (CLParser.sDebug) {
                PrintStream printStream = System.out;
                printStream.println("closing " + hashCode() + " -> " + this);
            }
            CLContainer cLContainer = this.mContainer;
            if (cLContainer != null) {
                cLContainer.add(this);
            }
        }
    }

    public void setLine(int i4) {
        this.mLine = i4;
    }

    public void setStart(long j4) {
        this.mStart = j4;
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i4, int i5) {
        return "";
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        return "";
    }

    public String toString() {
        long j4 = this.mStart;
        long j5 = this.mEnd;
        if (j4 > j5 || j5 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.mStart + "-" + this.mEnd + ")";
        }
        String substring = new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1);
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + substring + ">>";
    }

    @NonNull
    public CLElement clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
