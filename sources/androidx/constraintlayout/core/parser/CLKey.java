package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import java.util.ArrayList;

public class CLKey extends CLContainer {
    private static ArrayList<String> sSections;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sSections = arrayList;
        arrayList.add("ConstraintSets");
        sSections.add("Variables");
        sSections.add("Generate");
        sSections.add(TypedValues.TransitionType.NAME);
        sSections.add("KeyFrames");
        sSections.add(TypedValues.AttributesType.NAME);
        sSections.add("KeyPositions");
        sSections.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLKey) || Objects.equals(getName(), ((CLKey) obj).getName())) {
            return super.equals(obj);
        }
        return false;
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) {
            return this.mElements.get(0);
        }
        return null;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void set(CLElement cLElement) {
        if (this.mElements.size() > 0) {
            this.mElements.set(0, cLElement);
        } else {
            this.mElements.add(cLElement);
        }
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i4, int i5) {
        StringBuilder sb = new StringBuilder(getDebugName());
        addIndent(sb, i4);
        String content = content();
        if (this.mElements.size() > 0) {
            sb.append(content);
            sb.append(": ");
            if (sSections.contains(content)) {
                i5 = 3;
            }
            if (i5 > 0) {
                sb.append(this.mElements.get(0).toFormattedJSON(i4, i5 - 1));
            } else {
                String json = this.mElements.get(0).toJSON();
                if (json.length() + i4 < CLElement.sMaxLine) {
                    sb.append(json);
                } else {
                    sb.append(this.mElements.get(0).toFormattedJSON(i4, i5 - 1));
                }
            }
            return sb.toString();
        }
        return content + ": <> ";
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        if (this.mElements.size() > 0) {
            return getDebugName() + content() + ": " + this.mElements.get(0).toJSON();
        }
        return getDebugName() + content() + ": <> ";
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0);
        cLKey.setEnd((long) (str.length() - 1));
        cLKey.set(cLElement);
        return cLKey;
    }
}
