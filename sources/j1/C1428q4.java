package J1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: J1.q4  reason: case insensitive filesystem */
public final /* synthetic */ class C1428q4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f7112a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f7113b;

    public /* synthetic */ C1428q4(ReviewsActivity reviewsActivity, Drawable drawable) {
        this.f7112a = reviewsActivity;
        this.f7113b = drawable;
    }

    public final void onClick(View view) {
        ReviewsActivity.G3(this.f7112a, this.f7113b, view);
    }
}
