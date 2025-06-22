package O1;

import android.content.DialogInterface;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;

/* renamed from: O1.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C1570k0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7914a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f7915b;

    public /* synthetic */ C1570k0(InstallerActivity installerActivity, File file) {
        this.f7914a = installerActivity;
        this.f7915b = file;
    }

    public final void onClick(DialogInterface dialogInterface, int i4) {
        InstallerActivity.o1(this.f7914a, this.f7915b, dialogInterface, i4);
    }
}
