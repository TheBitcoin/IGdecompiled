package J1;

import android.view.View;
import com.uptodown.activities.UsernameEditActivity;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;

public final /* synthetic */ class Z5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UsernameEditActivity f6937a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ A f6938b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C f6939c;

    public /* synthetic */ Z5(UsernameEditActivity usernameEditActivity, A a5, C c5) {
        this.f6937a = usernameEditActivity;
        this.f6938b = a5;
        this.f6939c = c5;
    }

    public final void onClick(View view) {
        UsernameEditActivity.z3(this.f6937a, this.f6938b, this.f6939c, view);
    }
}
