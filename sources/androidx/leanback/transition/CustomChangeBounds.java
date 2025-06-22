package androidx.leanback.transition;

import android.animation.Animator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import java.util.HashMap;

@RequiresApi(19)
class CustomChangeBounds extends ChangeBounds {
    final HashMap<String, Integer> mClassStartDelays = new HashMap<>();
    int mDefaultStartDelay;
    final SparseIntArray mIdStartDelays = new SparseIntArray();
    final HashMap<View, Integer> mViewStartDelays = new HashMap<>();

    CustomChangeBounds() {
    }

    private int getDelay(View view) {
        Integer num = this.mViewStartDelays.get(view);
        if (num != null) {
            return num.intValue();
        }
        int i4 = this.mIdStartDelays.get(view.getId(), -1);
        if (i4 != -1) {
            return i4;
        }
        Integer num2 = this.mClassStartDelays.get(view.getClass().getName());
        if (num2 != null) {
            return num2.intValue();
        }
        return this.mDefaultStartDelay;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (!(createAnimator == null || transitionValues2 == null || (view = transitionValues2.view) == null)) {
            createAnimator.setStartDelay((long) getDelay(view));
        }
        return createAnimator;
    }

    public void setDefaultStartDelay(int i4) {
        this.mDefaultStartDelay = i4;
    }

    public void setStartDelay(View view, int i4) {
        this.mViewStartDelays.put(view, Integer.valueOf(i4));
    }

    public void setStartDelay(int i4, int i5) {
        this.mIdStartDelays.put(i4, i5);
    }

    public void setStartDelay(String str, int i4) {
        this.mClassStartDelays.put(str, Integer.valueOf(i4));
    }
}
