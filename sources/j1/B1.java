package J1;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class B1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f6714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Animation f6715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f6716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Animation f6717d;

    public /* synthetic */ B1(ImageView imageView, Animation animation, ImageView imageView2, Animation animation2) {
        this.f6714a = imageView;
        this.f6715b = animation;
        this.f6716c = imageView2;
        this.f6717d = animation2;
    }

    public final void run() {
        MainActivity.B.b(this.f6714a, this.f6715b, this.f6716c, this.f6717d);
    }
}
