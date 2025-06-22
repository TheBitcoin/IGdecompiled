package Q2;

import android.text.Editable;
import android.text.style.BulletSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.m;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f8001a = 20;

    /* renamed from: b  reason: collision with root package name */
    public final BulletSpan f8002b = new BulletSpan(10);

    public final void a(Editable editable) {
        if (editable.length() > 0 && editable.charAt(editable.length() - 1) != 10) {
            editable.append("\n");
        }
    }

    public abstract Object[] b(Editable editable, int i4);

    public void c(Editable editable) {
        m.e(editable, MimeTypes.BASE_TYPE_TEXT);
        a(editable);
        editable.setSpan(this, editable.length(), editable.length(), 17);
    }
}
