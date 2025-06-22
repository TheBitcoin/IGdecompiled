package androidx.work;

import kotlin.jvm.internal.m;

public final class NoOpInputMergerFactory extends InputMergerFactory {
    public static final NoOpInputMergerFactory INSTANCE = new NoOpInputMergerFactory();

    private NoOpInputMergerFactory() {
    }

    public Void createInputMerger(String str) {
        m.e(str, "className");
        return null;
    }
}
