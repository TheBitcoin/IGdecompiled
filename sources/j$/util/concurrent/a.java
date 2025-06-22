package j$.util.concurrent;

public abstract class a extends p {

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentHashMap f5140i;

    /* renamed from: j  reason: collision with root package name */
    public l f5141j;

    public a(l[] lVarArr, int i4, int i5, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i4, 0, i5);
        this.f5140i = concurrentHashMap;
        a();
    }

    public final boolean hasNext() {
        return this.f5161b != null;
    }

    public final boolean hasMoreElements() {
        return this.f5161b != null;
    }

    public final void remove() {
        l lVar = this.f5141j;
        if (lVar != null) {
            this.f5141j = null;
            this.f5140i.g(lVar.f5153b, (Object) null, (Object) null);
            return;
        }
        throw new IllegalStateException();
    }
}
