package J;

import M.C0335p;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* renamed from: J.o  reason: case insensitive filesystem */
public class C0316o extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f350a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f351b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f352c;

    public static C0316o g(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0316o oVar = new C0316o();
        Dialog dialog2 = (Dialog) C0335p.m(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        oVar.f350a = dialog2;
        if (onCancelListener != null) {
            oVar.f351b = onCancelListener;
        }
        return oVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f351b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f350a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f352c == null) {
            this.f352c = new AlertDialog.Builder((Context) C0335p.l(getContext())).create();
        }
        return this.f352c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
