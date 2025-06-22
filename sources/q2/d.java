package Q2;

import android.text.Editable;
import android.text.style.LeadingMarginSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.m;

public final class d extends c {

    /* renamed from: c  reason: collision with root package name */
    public int f8003c = 1;

    public Object[] b(Editable editable, int i4) {
        int i5 = this.f8001a;
        int i6 = (i4 - 1) * i5;
        if (i4 > 2) {
            i6 -= (i4 - 2) * i5;
        }
        return new Object[]{new LeadingMarginSpan.Standard(i6)};
    }

    public void c(Editable editable) {
        m.e(editable, MimeTypes.BASE_TYPE_TEXT);
        m.e(editable, MimeTypes.BASE_TYPE_TEXT);
        a(editable);
        editable.setSpan(this, editable.length(), editable.length(), 17);
        int i4 = this.f8003c;
        this.f8003c = i4 + 1;
        editable.append(String.valueOf(i4)).append(". ");
    }
}
