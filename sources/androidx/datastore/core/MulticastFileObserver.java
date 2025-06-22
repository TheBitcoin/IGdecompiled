package androidx.datastore.core;

import R2.s;
import V2.d;
import android.os.FileObserver;
import androidx.annotation.CheckResult;
import androidx.annotation.VisibleForTesting;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.l;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.Z;
import r3.C1035e;
import r3.C1037g;

public final class MulticastFileObserver extends FileObserver {
    public static final Companion Companion = new Companion((C2103g) null);
    /* access modifiers changed from: private */
    public static final Object LOCK = new Object();
    /* access modifiers changed from: private */
    public static final Map<String, MulticastFileObserver> fileObservers = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<l> delegates;
    private final String path;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getFileObservers$datastore_core_release$annotations() {
        }

        /* access modifiers changed from: private */
        public static final void observe$lambda$4(String str, l lVar) {
            m.e(lVar, "$observer");
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Companion companion = MulticastFileObserver.Companion;
                    MulticastFileObserver multicastFileObserver = companion.getFileObservers$datastore_core_release().get(str);
                    if (multicastFileObserver != null) {
                        multicastFileObserver.delegates.remove(lVar);
                        if (multicastFileObserver.delegates.isEmpty()) {
                            companion.getFileObservers$datastore_core_release().remove(str);
                            multicastFileObserver.stopWatching();
                        }
                    }
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Map<String, MulticastFileObserver> getFileObservers$datastore_core_release() {
            return MulticastFileObserver.fileObservers;
        }

        @CheckResult
        public final C1035e observe(File file) {
            m.e(file, "file");
            return C1037g.g(new MulticastFileObserver$Companion$observe$1(file, (d) null));
        }

        @VisibleForTesting
        public final void removeAllObservers$datastore_core_release() {
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    for (MulticastFileObserver stopWatching : MulticastFileObserver.Companion.getFileObservers$datastore_core_release().values()) {
                        stopWatching.stopWatching();
                    }
                    MulticastFileObserver.Companion.getFileObservers$datastore_core_release().clear();
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        @CheckResult
        public final Z observe(File file, l lVar) {
            String path = file.getCanonicalFile().getPath();
            synchronized (MulticastFileObserver.LOCK) {
                try {
                    Map<String, MulticastFileObserver> fileObservers$datastore_core_release = MulticastFileObserver.Companion.getFileObservers$datastore_core_release();
                    m.d(path, LeanbackPreferenceDialogFragment.ARG_KEY);
                    MulticastFileObserver multicastFileObserver = fileObservers$datastore_core_release.get(path);
                    if (multicastFileObserver == null) {
                        multicastFileObserver = new MulticastFileObserver(path, (C2103g) null);
                        fileObservers$datastore_core_release.put(path, multicastFileObserver);
                    }
                    MulticastFileObserver multicastFileObserver2 = multicastFileObserver;
                    multicastFileObserver2.delegates.add(lVar);
                    if (multicastFileObserver2.delegates.size() == 1) {
                        multicastFileObserver2.startWatching();
                    }
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a(path, lVar);
        }
    }

    public /* synthetic */ MulticastFileObserver(String str, C2103g gVar) {
        this(str);
    }

    public final String getPath() {
        return this.path;
    }

    public void onEvent(int i4, String str) {
        for (l invoke : this.delegates) {
            invoke.invoke(str);
        }
    }

    private MulticastFileObserver(String str) {
        super(str, 128);
        this.path = str;
        this.delegates = new CopyOnWriteArrayList<>();
    }
}
