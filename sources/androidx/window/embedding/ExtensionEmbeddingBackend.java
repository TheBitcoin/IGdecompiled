package androidx.window.embedding;

import R2.s;
import S2.C1601o;
import android.app.Activity;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@ExperimentalWindowApi
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {
    public static final Companion Companion = new Companion((C2103g) null);
    private static final String TAG = "EmbeddingBackend";
    /* access modifiers changed from: private */
    public static volatile ExtensionEmbeddingBackend globalInstance;
    /* access modifiers changed from: private */
    public static final ReentrantLock globalLock = new ReentrantLock();
    @VisibleForTesting
    @GuardedBy("globalLock")
    private EmbeddingInterfaceCompat embeddingExtension;
    private final CopyOnWriteArrayList<SplitListenerWrapper> splitChangeCallbacks = new CopyOnWriteArrayList<>();
    private final EmbeddingCallbackImpl splitInfoEmbeddingCallback;
    private final CopyOnWriteArraySet<EmbeddingRule> splitRules;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private final EmbeddingInterfaceCompat initAndVerifyEmbeddingExtension() {
            EmbeddingCompat embeddingCompat = null;
            try {
                EmbeddingCompat.Companion companion = EmbeddingCompat.Companion;
                if (isExtensionVersionSupported(companion.getExtensionApiLevel()) && companion.isEmbeddingAvailable()) {
                    embeddingCompat = new EmbeddingCompat();
                }
            } catch (Throwable th) {
                Log.d(ExtensionEmbeddingBackend.TAG, m.m("Failed to load embedding extension: ", th));
            }
            if (embeddingCompat == null) {
                Log.d(ExtensionEmbeddingBackend.TAG, "No supported embedding extension found");
            }
            return embeddingCompat;
        }

        public final ExtensionEmbeddingBackend getInstance() {
            if (ExtensionEmbeddingBackend.globalInstance == null) {
                ReentrantLock access$getGlobalLock$cp = ExtensionEmbeddingBackend.globalLock;
                access$getGlobalLock$cp.lock();
                try {
                    if (ExtensionEmbeddingBackend.globalInstance == null) {
                        ExtensionEmbeddingBackend.globalInstance = new ExtensionEmbeddingBackend(ExtensionEmbeddingBackend.Companion.initAndVerifyEmbeddingExtension());
                    }
                    s sVar = s.f8222a;
                    access$getGlobalLock$cp.unlock();
                } catch (Throwable th) {
                    access$getGlobalLock$cp.unlock();
                    throw th;
                }
            }
            ExtensionEmbeddingBackend access$getGlobalInstance$cp = ExtensionEmbeddingBackend.globalInstance;
            m.b(access$getGlobalInstance$cp);
            return access$getGlobalInstance$cp;
        }

        @VisibleForTesting
        public final boolean isExtensionVersionSupported(Integer num) {
            if (num != null && num.intValue() >= 1) {
                return true;
            }
            return false;
        }

        private Companion() {
        }
    }

    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {
        private List<SplitInfo> lastInfo;
        final /* synthetic */ ExtensionEmbeddingBackend this$0;

        public EmbeddingCallbackImpl(ExtensionEmbeddingBackend extensionEmbeddingBackend) {
            m.e(extensionEmbeddingBackend, "this$0");
            this.this$0 = extensionEmbeddingBackend;
        }

        public final List<SplitInfo> getLastInfo() {
            return this.lastInfo;
        }

        public void onSplitInfoChanged(List<SplitInfo> list) {
            m.e(list, "splitInfo");
            this.lastInfo = list;
            Iterator<SplitListenerWrapper> it = this.this$0.getSplitChangeCallbacks().iterator();
            while (it.hasNext()) {
                it.next().accept(list);
            }
        }

        public final void setLastInfo(List<SplitInfo> list) {
            this.lastInfo = list;
        }
    }

    public static final class SplitListenerWrapper {
        private final Activity activity;
        private final Consumer<List<SplitInfo>> callback;
        private final Executor executor;
        private List<SplitInfo> lastValue;

        public SplitListenerWrapper(Activity activity2, Executor executor2, Consumer<List<SplitInfo>> consumer) {
            m.e(activity2, "activity");
            m.e(executor2, "executor");
            m.e(consumer, "callback");
            this.activity = activity2;
            this.executor = executor2;
            this.callback = consumer;
        }

        /* access modifiers changed from: private */
        /* renamed from: accept$lambda-1  reason: not valid java name */
        public static final void m10accept$lambda1(SplitListenerWrapper splitListenerWrapper, List list) {
            m.e(splitListenerWrapper, "this$0");
            m.e(list, "$splitsWithActivity");
            splitListenerWrapper.callback.accept(list);
        }

        public final void accept(List<SplitInfo> list) {
            m.e(list, "splitInfoList");
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (((SplitInfo) next).contains(this.activity)) {
                    arrayList.add(next);
                }
            }
            if (!m.a(arrayList, this.lastValue)) {
                this.lastValue = arrayList;
                this.executor.execute(new f(this, arrayList));
            }
        }

        public final Consumer<List<SplitInfo>> getCallback() {
            return this.callback;
        }
    }

    @VisibleForTesting
    public ExtensionEmbeddingBackend(EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.embeddingExtension = embeddingInterfaceCompat;
        EmbeddingCallbackImpl embeddingCallbackImpl = new EmbeddingCallbackImpl(this);
        this.splitInfoEmbeddingCallback = embeddingCallbackImpl;
        EmbeddingInterfaceCompat embeddingInterfaceCompat2 = this.embeddingExtension;
        if (embeddingInterfaceCompat2 != null) {
            embeddingInterfaceCompat2.setEmbeddingCallback(embeddingCallbackImpl);
        }
        this.splitRules = new CopyOnWriteArraySet<>();
    }

    @VisibleForTesting
    public static /* synthetic */ void getSplitChangeCallbacks$annotations() {
    }

    public final EmbeddingInterfaceCompat getEmbeddingExtension() {
        return this.embeddingExtension;
    }

    public final CopyOnWriteArrayList<SplitListenerWrapper> getSplitChangeCallbacks() {
        return this.splitChangeCallbacks;
    }

    public Set<EmbeddingRule> getSplitRules() {
        return this.splitRules;
    }

    public boolean isSplitSupported() {
        if (this.embeddingExtension != null) {
            return true;
        }
        return false;
    }

    public void registerRule(EmbeddingRule embeddingRule) {
        m.e(embeddingRule, "rule");
        if (!this.splitRules.contains(embeddingRule)) {
            this.splitRules.add(embeddingRule);
            EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
            if (embeddingInterfaceCompat != null) {
                embeddingInterfaceCompat.setSplitRules(this.splitRules);
            }
        }
    }

    public void registerSplitListenerForActivity(Activity activity, Executor executor, Consumer<List<SplitInfo>> consumer) {
        m.e(activity, "activity");
        m.e(executor, "executor");
        m.e(consumer, "callback");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            if (getEmbeddingExtension() == null) {
                Log.v(TAG, "Extension not loaded, skipping callback registration.");
                consumer.accept(C1601o.h());
                return;
            }
            SplitListenerWrapper splitListenerWrapper = new SplitListenerWrapper(activity, executor, consumer);
            getSplitChangeCallbacks().add(splitListenerWrapper);
            if (this.splitInfoEmbeddingCallback.getLastInfo() != null) {
                List<SplitInfo> lastInfo = this.splitInfoEmbeddingCallback.getLastInfo();
                m.b(lastInfo);
                splitListenerWrapper.accept(lastInfo);
            } else {
                splitListenerWrapper.accept(C1601o.h());
            }
            s sVar = s.f8222a;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setEmbeddingExtension(EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.embeddingExtension = embeddingInterfaceCompat;
    }

    public void setSplitRules(Set<? extends EmbeddingRule> set) {
        m.e(set, "rules");
        this.splitRules.clear();
        this.splitRules.addAll(set);
        EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
        if (embeddingInterfaceCompat != null) {
            embeddingInterfaceCompat.setSplitRules(this.splitRules);
        }
    }

    public void unregisterRule(EmbeddingRule embeddingRule) {
        m.e(embeddingRule, "rule");
        if (this.splitRules.contains(embeddingRule)) {
            this.splitRules.remove(embeddingRule);
            EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
            if (embeddingInterfaceCompat != null) {
                embeddingInterfaceCompat.setSplitRules(this.splitRules);
            }
        }
    }

    public void unregisterSplitListenerForActivity(Consumer<List<SplitInfo>> consumer) {
        m.e(consumer, "consumer");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            Iterator<SplitListenerWrapper> it = getSplitChangeCallbacks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SplitListenerWrapper next = it.next();
                if (m.a(next.getCallback(), consumer)) {
                    getSplitChangeCallbacks().remove(next);
                    break;
                }
            }
            s sVar = s.f8222a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
