package J1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

public final /* synthetic */ class B4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f6721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f6722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f6723c;

    public /* synthetic */ B4(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f6721a = reviewsActivity;
        this.f6722b = drawable;
        this.f6723c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.E3(this.f6721a, this.f6722b, this.f6723c, view);
    }
}
