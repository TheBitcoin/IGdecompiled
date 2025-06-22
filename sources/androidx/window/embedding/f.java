package androidx.window.embedding;

import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionEmbeddingBackend.SplitListenerWrapper f1037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f1038b;

    public /* synthetic */ f(ExtensionEmbeddingBackend.SplitListenerWrapper splitListenerWrapper, List list) {
        this.f1037a = splitListenerWrapper;
        this.f1038b = list;
    }

    public final void run() {
        ExtensionEmbeddingBackend.SplitListenerWrapper.m10accept$lambda1(this.f1037a, this.f1038b);
    }
}
