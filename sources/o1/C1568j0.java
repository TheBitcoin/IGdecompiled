package O1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;

/* renamed from: O1.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C1568j0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f7912b;

    public /* synthetic */ C1568j0(InstallerActivity installerActivity, File file) {
        this.f7911a = installerActivity;
        this.f7912b = file;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        InstallerActivity.n1(this.f7911a, this.f7912b, dialogInterface, i4);
    }
}
