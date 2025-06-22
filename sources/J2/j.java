package J2;

import C2.b;
import C2.c;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public final class j extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f7262a;

    public j(f fVar) {
        this.f7262a = fVar;
    }

    public void onClick(View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        try {
            l lVar = this.f7262a.f7251h;
            l lVar2 = null;
            if (lVar == null) {
                m.u("viewModel");
                lVar = null;
            }
            if (lVar.f7274h.f24141g.length() > 0) {
                f fVar = this.f7262a;
                Intent intent = new Intent("android.intent.action.VIEW");
                l lVar3 = this.f7262a.f7251h;
                if (lVar3 == null) {
                    m.u("viewModel");
                } else {
                    lVar2 = lVar3;
                }
                intent.setData(Uri.parse(lVar2.f7274h.f24141g));
                fVar.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_URL, (String) null, (String) null, (c) null, (Throwable) null, 30);
        }
    }
}
