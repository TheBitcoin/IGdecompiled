package Q2;

import android.text.Editable;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;

public final class e extends c {
    public Object[] b(Editable editable, int i4) {
        int i5 = 10;
        if (i4 > 1) {
            i5 = 10 - this.f8002b.getLeadingMargin(true);
            if (i4 > 2) {
                i5 -= (i4 - 2) * this.f8001a;
            }
        }
        return new Object[]{new LeadingMarginSpan.Standard((i4 - 1) * this.f8001a), new BulletSpan(i5)};
    }
}
