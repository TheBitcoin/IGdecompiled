package Q2;

import S2.C1601o;
import android.text.Editable;
import android.text.Html;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.xml.sax.XMLReader;

public final class b implements Html.TagHandler {

    /* renamed from: a  reason: collision with root package name */
    public final List f8000a = new ArrayList();

    public void handleTag(boolean z4, String str, Editable editable, XMLReader xMLReader) {
        c cVar;
        m.e(editable, "output");
        int i4 = 0;
        if (m.a("customUl", str) && z4) {
            this.f8000a.add(0, new e());
        } else if (m.a("customOl", str) && z4) {
            this.f8000a.add(0, new d());
        } else if ((m.a("customUl", str) || m.a("customOl", str)) && !z4) {
            C1601o.w(this.f8000a);
        } else if (m.a("customLi", str) && z4) {
            ((c) C1601o.H(this.f8000a)).c(editable);
        } else if (m.a("customLi", str) && !z4) {
            c cVar2 = (c) C1601o.H(this.f8000a);
            int size = this.f8000a.size();
            cVar2.getClass();
            m.e(editable, MimeTypes.BASE_TYPE_TEXT);
            cVar2.a(editable);
            c[] cVarArr = (c[]) editable.getSpans(0, editable.length(), c.class);
            m.d(cVarArr, "listTags");
            if (cVarArr.length == 0) {
                cVar = null;
            } else {
                cVar = cVarArr[cVarArr.length - 1];
            }
            int spanStart = editable.getSpanStart(cVar);
            editable.removeSpan(cVar);
            if (spanStart != editable.length()) {
                Object[] b5 = cVar2.b(editable, size);
                int length = b5.length;
                while (i4 < length) {
                    Object obj = b5[i4];
                    i4++;
                    editable.setSpan(obj, spanStart, editable.length(), 33);
                }
            }
        }
    }
}
