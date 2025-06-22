package i2;

import j2.C2092a;
import kotlin.coroutines.jvm.internal.d;
import l2.C2124d;

/* renamed from: i2.c  reason: case insensitive filesystem */
public final class C2085c extends d {

    /* renamed from: a  reason: collision with root package name */
    public C2092a f20906a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ Object f20907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2083a f20908c;

    /* renamed from: d  reason: collision with root package name */
    public int f20909d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2085c(C2083a aVar, V2.d dVar) {
        super(dVar);
        this.f20908c = aVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f20907b = obj;
        this.f20909d |= Integer.MIN_VALUE;
        return C2083a.b(this.f20908c, (C2124d) null, (C2092a) null, this);
    }
}
