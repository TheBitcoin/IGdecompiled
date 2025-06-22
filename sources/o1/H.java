package O1;

import android.view.View;
import android.widget.EditText;
import com.uptodown.core.activities.FileExplorerActivity;
import java.util.ArrayList;
import kotlin.jvm.internal.C;

public final /* synthetic */ class H implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f7832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f7833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7834c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7835d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ C f7836e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity.C1872x f7837f;

    public /* synthetic */ H(EditText editText, C c5, FileExplorerActivity fileExplorerActivity, ArrayList arrayList, C c6, FileExplorerActivity.C1872x xVar) {
        this.f7832a = editText;
        this.f7833b = c5;
        this.f7834c = fileExplorerActivity;
        this.f7835d = arrayList;
        this.f7836e = c6;
        this.f7837f = xVar;
    }

    public final void onClick(View view) {
        FileExplorerActivity.G3(this.f7832a, this.f7833b, this.f7834c, this.f7835d, this.f7836e, this.f7837f, view);
    }
}
