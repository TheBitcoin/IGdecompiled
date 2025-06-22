package androidx.work.impl.model;

import R2.s;
import V2.d;
import W2.b;
import r3.C1035e;
import r3.C1036f;

public final class WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1 implements C1035e {
    final /* synthetic */ C1035e $this_unsafeTransform$inlined;

    public WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1(C1035e eVar) {
        this.$this_unsafeTransform$inlined = eVar;
    }

    public Object collect(final C1036f fVar, d dVar) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new C1036f() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, V2.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    R2.n.b(r6)
                    goto L_0x004f
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    R2.n.b(r6)
                    r3.f r6 = r3
                    java.util.List r5 = (java.util.List) r5
                    java.lang.Object r5 = S2.C1601o.I(r5)
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r5
                    if (r5 == 0) goto L_0x0045
                    androidx.work.WorkInfo r5 = r5.toWorkInfo()
                    goto L_0x0046
                L_0x0045:
                    r5 = 0
                L_0x0046:
                    r0.label = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x004f
                    return r1
                L_0x004f:
                    R2.s r5 = R2.s.f8222a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, V2.d):java.lang.Object");
            }
        }, dVar);
        if (collect == b.c()) {
            return collect;
        }
        return s.f8222a;
    }
}
