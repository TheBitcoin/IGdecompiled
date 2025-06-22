package O1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.util.ArrayList;

/* renamed from: O1.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C1564h0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7905a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f7906b;

    public /* synthetic */ C1564h0(InstallerActivity installerActivity, ArrayList arrayList) {
        this.f7905a = installerActivity;
        this.f7906b = arrayList;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        InstallerActivity.p1(this.f7905a, this.f7906b, dialogInterface, i4);
    }
}
