package q;

import java.util.concurrent.Executor;
import u.C1068a;

class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f4015a;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f4016a;

        a(Runnable runnable) {
            this.f4016a = runnable;
        }

        public void run() {
            try {
                this.f4016a.run();
            } catch (Exception e5) {
                C1068a.d("Executor", "Background execution failure.", e5);
            }
        }
    }

    n(Executor executor) {
        this.f4015a = executor;
    }

    public void execute(Runnable runnable) {
        this.f4015a.execute(new a(runnable));
    }
}
