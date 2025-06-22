package L;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b0.e;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class C extends Fragment implements e {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap f389d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map f390a = DesugarCollections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f391b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f392c;

    public static C i(FragmentActivity fragmentActivity) {
        C c5;
        WeakHashMap weakHashMap = f389d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (c5 = (C) weakReference.get()) != null) {
            return c5;
        }
        try {
            C c6 = (C) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (c6 == null || c6.isRemoving()) {
                c6 = new C();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) c6, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(c6));
            return c6;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f390a.containsKey(str)) {
            this.f390a.put(str, lifecycleCallback);
            if (this.f391b > 0) {
                new e(Looper.getMainLooper()).post(new B(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final LifecycleCallback b(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f390a.get(str));
    }

    public final /* synthetic */ Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a5 : this.f390a.values()) {
            a5.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        for (LifecycleCallback e5 : this.f390a.values()) {
            e5.e(i4, i5, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        this.f391b = 1;
        this.f392c = bundle;
        for (Map.Entry entry : this.f390a.entrySet()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f391b = 5;
        for (LifecycleCallback g4 : this.f390a.values()) {
            g4.g();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f391b = 3;
        for (LifecycleCallback h4 : this.f390a.values()) {
            h4.h();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f390a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f391b = 2;
        for (LifecycleCallback j4 : this.f390a.values()) {
            j4.j();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f391b = 4;
        for (LifecycleCallback k4 : this.f390a.values()) {
            k4.k();
        }
    }
}
