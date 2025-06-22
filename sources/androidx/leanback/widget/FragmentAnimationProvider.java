package androidx.leanback.widget;

import android.animation.Animator;
import androidx.annotation.NonNull;
import java.util.List;

public interface FragmentAnimationProvider {
    void onImeAppearing(@NonNull List<Animator> list);

    void onImeDisappearing(@NonNull List<Animator> list);
}
