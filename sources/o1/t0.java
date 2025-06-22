package O1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;
import kotlin.jvm.internal.z;

public final /* synthetic */ class t0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f7950a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f7951b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f7952c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f7953d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f7954e;

    public /* synthetic */ t0(z zVar, TextView textView, InstallerActivity installerActivity, ImageView imageView, TextView textView2) {
        this.f7950a = zVar;
        this.f7951b = textView;
        this.f7952c = installerActivity;
        this.f7953d = imageView;
        this.f7954e = textView2;
    }

    public final void onClick(View view) {
        InstallerActivity.y1(this.f7950a, this.f7951b, this.f7952c, this.f7953d, this.f7954e, view);
    }
}
