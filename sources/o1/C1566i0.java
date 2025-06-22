package O1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: O1.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C1566i0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7908a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7909b;

    public /* synthetic */ C1566i0(InstallerActivity installerActivity, ArrayList arrayList) {
        this.f7908a = installerActivity;
        this.f7909b = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        InstallerActivity.q1(this.f7908a, this.f7909b, dialogInterface, i4);
    }
}
