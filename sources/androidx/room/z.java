package androidx.room;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f1019a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransactionExecutor f1020b;

    public /* synthetic */ z(Runnable runnable, TransactionExecutor transactionExecutor) {
        this.f1019a = runnable;
        this.f1020b = transactionExecutor;
    }

    public final void run() {
        TransactionExecutor.execute$lambda$1$lambda$0(this.f1019a, this.f1020b);
    }
}
