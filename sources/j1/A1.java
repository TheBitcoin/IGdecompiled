package J1;

import android.widget.ImageView;
import com.uptodown.activities.MainActivity;
import g2.C2052j;

public final /* synthetic */ class A1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f6702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2052j f6703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6704c;

    public /* synthetic */ A1(ImageView imageView, C2052j jVar, MainActivity mainActivity) {
        this.f6702a = imageView;
        this.f6703b = jVar;
        this.f6704c = mainActivity;
    }

    public final void run() {
        MainActivity.n.d(this.f6702a, this.f6703b, this.f6704c);
    }
}
