package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;

public final /* synthetic */ class d implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f919a;

    public /* synthetic */ d(View view) {
        this.f919a = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i4, Bundle bundle) {
        return InputConnectionCompat.a(this.f919a, inputContentInfoCompat, i4, bundle);
    }
}
