package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: J1.u4  reason: case insensitive filesystem */
public final /* synthetic */ class C1455u4 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f7168a;

    public /* synthetic */ C1455u4(ReviewsActivity reviewsActivity) {
        this.f7168a = reviewsActivity;
    }

    public final void onActivityResult(Object obj) {
        ReviewsActivity.J3(this.f7168a, (ActivityResult) obj);
    }
}
