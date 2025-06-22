package O1;

import android.view.View;
import android.widget.EditText;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: O1.w  reason: case insensitive filesystem */
public final /* synthetic */ class C1583w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f7959a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f7960b;

    public /* synthetic */ C1583w(EditText editText, FileExplorerActivity fileExplorerActivity) {
        this.f7959a = editText;
        this.f7960b = fileExplorerActivity;
    }

    public final void onClick(View view) {
        FileExplorerActivity.J3(this.f7959a, this.f7960b, view);
    }
}
