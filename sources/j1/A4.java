package J1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

public final /* synthetic */ class A4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f6707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f6708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f6709c;

    public /* synthetic */ A4(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f6707a = reviewsActivity;
        this.f6708b = drawable;
        this.f6709c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.D3(this.f6707a, this.f6708b, this.f6709c, view);
    }
}
