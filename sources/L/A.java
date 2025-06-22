package L;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import b0.e;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class A extends Fragment implements e {

    /* renamed from: d  reason: collision with root package name */
    private static final WeakHashMap f382d = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Map f383a = DesugarCollections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f384b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f385c;

    public static A f(Activity activity) {
        A a5;
        WeakHashMap weakHashMap = f382d;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (a5 = (A) weakReference.get()) != null) {
            return a5;
        }
        try {
            A a6 = (A) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (a6 == null || a6.isRemoving()) {
                a6 = new A();
                activity.getFragmentManager().beginTransaction().add(a6, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(a6));
            return a6;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f383a.containsKey(str)) {
            this.f383a.put(str, lifecycleCallback);
            if (this.f384b > 0) {
                new e(Looper.getMainLooper()).post(new z(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final LifecycleCallback b(String str, Class cls) {
        return (LifecycleCallback) cls.cast(this.f383a.get(str));
    }

    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a5 : this.f383a.values()) {
            a5.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        for (LifecycleCallback e5 : this.f383a.values()) {
            e5.e(i4, i5, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        this.f384b = 1;
        this.f385c = bundle;
        for (Map.Entry entry : this.f383a.entrySet()) {
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
        this.f384b = 5;
        for (LifecycleCallback g4 : this.f383a.values()) {
            g4.g();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f384b = 3;
        for (LifecycleCallback h4 : this.f383a.values()) {
            h4.h();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.f383a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f384b = 2;
        for (LifecycleCallback j4 : this.f383a.values()) {
            j4.j();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f384b = 4;
        for (LifecycleCallback k4 : this.f383a.values()) {
            k4.k();
        }
    }
}
