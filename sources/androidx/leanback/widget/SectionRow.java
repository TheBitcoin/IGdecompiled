package androidx.leanback.widget;

public class SectionRow extends Row {
    public SectionRow(HeaderItem headerItem) {
        super(headerItem);
    }

    public final boolean isRenderedAsRowView() {
        return false;
    }

    public SectionRow(long j4, String str) {
        super(new HeaderItem(j4, str));
    }

    public SectionRow(String str) {
        super(new HeaderItem(str));
    }
}
