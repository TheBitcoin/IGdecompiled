package J1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

public final /* synthetic */ class C4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f6733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f6734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f6735c;

    public /* synthetic */ C4(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f6733a = reviewsActivity;
        this.f6734b = drawable;
        this.f6735c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.F3(this.f6733a, this.f6734b, this.f6735c, view);
    }
}
