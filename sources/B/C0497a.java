package b;

import com.inmobi.cmp.ChoiceCmp;
import kotlin.coroutines.jvm.internal.d;

/* renamed from: b.a  reason: case insensitive filesystem */
public final class C0497a extends d {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Object f1094a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f1095b;

    /* renamed from: c  reason: collision with root package name */
    public int f1096c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0497a(ChoiceCmp choiceCmp, V2.d dVar) {
        super(dVar);
        this.f1095b = choiceCmp;
    }

    public final Object invokeSuspend(Object obj) {
        this.f1094a = obj;
        this.f1096c |= Integer.MIN_VALUE;
        return ChoiceCmp.access$loadCmpInfo(this.f1095b, this);
    }
}
