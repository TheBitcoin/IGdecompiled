package r2;

import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.app.ErrorSupportFragment;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvMainActivity;
import kotlin.jvm.internal.m;
import u2.x;

/* renamed from: r2.p  reason: case insensitive filesystem */
public final class C2252p extends ErrorSupportFragment {
    /* access modifiers changed from: private */
    public static final void h(C2252p pVar, View view) {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentActivity activity;
        FragmentManager supportFragmentManager3;
        FragmentTransaction beginTransaction2;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        if (pVar.getActivity() instanceof TvMainActivity) {
            FragmentActivity activity2 = pVar.getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.tv.ui.activity.TvMainActivity");
            fragment = ((TvMainActivity) activity2).x();
        } else {
            fragment = null;
        }
        if (!(fragment == null || (activity = pVar.getActivity()) == null || (supportFragmentManager3 = activity.getSupportFragmentManager()) == null || (beginTransaction2 = supportFragmentManager3.beginTransaction()) == null || (replace = beginTransaction2.replace(R.id.fragmentContainer, fragment)) == null || (addToBackStack = replace.addToBackStack((String) null)) == null)) {
            addToBackStack.commit();
        }
        FragmentActivity activity3 = pVar.getActivity();
        if (!(activity3 == null || (supportFragmentManager2 = activity3.getSupportFragmentManager()) == null || (beginTransaction = supportFragmentManager2.beginTransaction()) == null || (remove = beginTransaction.remove(pVar)) == null)) {
            remove.commit();
        }
        FragmentActivity activity4 = pVar.getActivity();
        if (activity4 != null && (supportFragmentManager = activity4.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x xVar = new x(getContext());
        String simpleName = C2252p.class.getSimpleName();
        m.d(simpleName, "getSimpleName(...)");
        xVar.e(simpleName);
    }

    public void onStart() {
        super.onStart();
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_uptodown_app_store_white));
        setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.lb_ic_sad_cloud));
        setMessage(getString(R.string.error_no_connection));
        setButtonText(getString(R.string.refresh_enc));
        setButtonClickListener(new C2251o(this));
    }
}
