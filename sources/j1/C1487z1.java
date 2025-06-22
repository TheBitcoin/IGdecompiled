package J1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.uptodown.activities.MainActivity;

/* renamed from: J1.z1  reason: case insensitive filesystem */
public final /* synthetic */ class C1487z1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f7226a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f7227b;

    public /* synthetic */ C1487z1(TextView textView, ImageView imageView) {
        this.f7226a = textView;
        this.f7227b = imageView;
    }

    public final void onClick(View view) {
        MainActivity.r7(this.f7226a, this.f7227b, view);
    }
}
