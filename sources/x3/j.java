package X3;

import R2.n;
import R2.s;
import T3.C2585m;
import V2.d;
import c.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.data.storage.SharedStorage;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0988l0;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public final SharedStorage f24266a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceCmpCallback f24267b;

    public static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f24268a;

        public a(d dVar) {
            super(2, dVar);
        }

        public final d create(Object obj, d dVar) {
            return new a(dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new a((d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f24268a;
            if (i4 == 0) {
                n.b(obj);
                C2585m mVar = C2585m.f24018a;
                this.f24268a = 1;
                if (mVar.d(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }
    }

    public static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f24269a;

        public b(d dVar) {
            super(2, dVar);
        }

        public final d create(Object obj, d dVar) {
            return new b(dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new b((d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f24269a;
            if (i4 == 0) {
                n.b(obj);
                C2585m mVar = C2585m.f24018a;
                this.f24269a = 1;
                if (mVar.d(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }
    }

    public j(SharedStorage sharedStorage, ChoiceCmpCallback choiceCmpCallback) {
        m.e(sharedStorage, "sharedStorage");
        this.f24266a = sharedStorage;
        this.f24267b = choiceCmpCallback;
    }

    public void a() {
        i iVar = i.f1157a;
        if (i.f1158b) {
            i.f1159c.setAllOwnedItems();
            SharedStorage sharedStorage = this.f24266a;
            a4.a aVar = a4.a.GBC_CONSENT_STRING;
            sharedStorage.d(aVar, iVar.a(sharedStorage.k(aVar), i.f1159c));
            ChoiceCmpCallback choiceCmpCallback = this.f24267b;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onGoogleBasicConsentChange(iVar.b());
            }
            C1001s0 unused = C0981i.d(C0988l0.f3711a, Y.b(), (L) null, new a((d) null), 2, (Object) null);
        }
    }

    public void b() {
        i iVar = i.f1157a;
        if (i.f1158b) {
            i.f1159c.unsetAllOwnedItems();
            SharedStorage sharedStorage = this.f24266a;
            a4.a aVar = a4.a.GBC_CONSENT_STRING;
            sharedStorage.d(aVar, iVar.a(sharedStorage.k(aVar), i.f1159c));
            ChoiceCmpCallback choiceCmpCallback = this.f24267b;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onGoogleBasicConsentChange(iVar.b());
            }
            C1001s0 unused = C0981i.d(C0988l0.f3711a, Y.b(), (L) null, new b((d) null), 2, (Object) null);
        }
    }
}
