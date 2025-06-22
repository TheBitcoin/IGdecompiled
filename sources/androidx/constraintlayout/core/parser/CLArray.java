package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i5 > 0 || json.length() + i4 >= CLElement.sMaxLine) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            boolean z4 = true;
            int i6 = 0;
            while (i6 < size) {
                CLElement cLElement = arrayList.get(i6);
                i6++;
                CLElement cLElement2 = cLElement;
                if (!z4) {
                    sb.append(",\n");
                } else {
                    z4 = false;
                }
                addIndent(sb, CLElement.sBaseIndent + i4);
                sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i4, i5 - 1));
            }
            sb.append("\n");
            addIndent(sb, i4);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z4 = true;
        for (int i4 = 0; i4 < this.mElements.size(); i4++) {
            if (!z4) {
                sb.append(", ");
            } else {
                z4 = false;
            }
            sb.append(this.mElements.get(i4).toJSON());
        }
        return sb + "]";
    }
}
