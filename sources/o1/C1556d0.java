package O1;

import android.view.View;
import android.widget.CheckBox;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: O1.d0  reason: case insensitive filesystem */
public final /* synthetic */ class C1556d0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f7883b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7884c;

    public /* synthetic */ C1556d0(InstallerActivity installerActivity, CheckBox checkBox, ArrayList arrayList) {
        this.f7882a = installerActivity;
        this.f7883b = checkBox;
        this.f7884c = arrayList;
    }

    public final void onClick(View view) {
        InstallerActivity.b2(this.f7882a, this.f7883b, this.f7884c, view);
    }
}
