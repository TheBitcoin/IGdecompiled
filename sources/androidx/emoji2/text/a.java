package androidx.emoji2.text;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f937a;

    public /* synthetic */ a(Handler handler) {
        this.f937a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f937a.post(runnable);
    }
}
