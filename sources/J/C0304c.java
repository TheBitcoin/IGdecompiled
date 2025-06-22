package J;

import M.C0335p;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: J.c  reason: case insensitive filesystem */
public class C0304c extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f327a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f328b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f329c;

    public static C0304c a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0304c cVar = new C0304c();
        Dialog dialog2 = (Dialog) C0335p.m(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener((DialogInterface.OnCancelListener) null);
        dialog2.setOnDismissListener((DialogInterface.OnDismissListener) null);
        cVar.f327a = dialog2;
        if (onCancelListener != null) {
            cVar.f328b = onCancelListener;
        }
        return cVar;
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f328b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f327a;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f329c == null) {
            this.f329c = new AlertDialog.Builder((Context) C0335p.l(getActivity())).create();
        }
        return this.f329c;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
