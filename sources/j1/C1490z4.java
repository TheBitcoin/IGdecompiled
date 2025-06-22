package J1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: J1.z4  reason: case insensitive filesystem */
public final /* synthetic */ class C1490z4 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f7232a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f7233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f7234c;

    public /* synthetic */ C1490z4(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f7232a = reviewsActivity;
        this.f7233b = drawable;
        this.f7234c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.C3(this.f7232a, this.f7233b, this.f7234c, view);
    }
}
