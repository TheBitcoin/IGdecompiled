package androidx.work.impl.background.greedy;

import androidx.work.impl.StartStopToken;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeLimiter f1049a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartStopToken f1050b;

    public /* synthetic */ a(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        this.f1049a = timeLimiter;
        this.f1050b = startStopToken;
    }

    public final void run() {
        TimeLimiter.track$lambda$0(this.f1049a, this.f1050b);
    }
}
