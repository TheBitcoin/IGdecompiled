package S;

import M.C0335p;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f632a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f633b = Executors.defaultThreadFactory();

    public a(String str) {
        C0335p.m(str, "Name must not be null");
        this.f632a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f633b.newThread(new b(runnable, 0));
        newThread.setName(this.f632a);
        return newThread;
    }
}
