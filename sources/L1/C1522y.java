package L1;

import N1.k;
import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.uptodown.R;
import kotlin.jvm.internal.m;

/* renamed from: L1.y  reason: case insensitive filesystem */
public abstract class C1522y extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (context != null) {
            context = k.f7778g.a(context);
        }
        super.attachBaseContext(context);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.right_to_left_out);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        m.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
