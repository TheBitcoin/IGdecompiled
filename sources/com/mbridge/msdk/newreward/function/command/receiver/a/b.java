package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.a.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private a f14699a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f14700b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f14701c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f14702d = 0;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.b$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14706a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14706a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14706a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.b.AnonymousClass2.<clinit>():void");
        }
    }

    public b(a aVar) {
        this.f14699a = aVar;
    }

    public final boolean a() {
        return this.f14700b;
    }

    public final void a(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        a(f.REPORT_V3_RETRY_START, eVar, (String) null, false);
        if (eVar != null) {
            com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
            bVar2.a(f.REQ_CAMPAIGN);
            HashMap hashMap = new HashMap();
            e b5 = eVar.b();
            hashMap.put("adapter_model", b5);
            hashMap.put("command_manager", eVar.d());
            bVar2.a((Object) hashMap);
            b5.l();
            this.f14699a.a(bVar2, new com.mbridge.msdk.newreward.a.b.b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    String str;
                    b bVar2 = b.this;
                    f fVar = f.REPORT_V3_RETRY_END;
                    e eVar = eVar;
                    if (bVar != null) {
                        str = bVar.b();
                    } else {
                        str = "";
                    }
                    bVar2.a(fVar, eVar, str, false);
                    boolean unused = b.this.f14700b = true;
                    bVar.reqFailed(bVar);
                }

                public final void reqSuccessful(Object obj) {
                    b.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                    bVar.reqSuccessful(obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(f fVar, e eVar, String str, boolean z4) {
        int i4 = 2;
        if (eVar != null) {
            if (this.f14702d == 0) {
                this.f14702d = System.currentTimeMillis();
            }
            c d5 = eVar.d();
            e b5 = eVar.b();
            if (d5 != null && b5 != null) {
                try {
                    Map a5 = d5.a("retry_count", 1, "type", 2);
                    int i5 = AnonymousClass2.f14706a[fVar.ordinal()];
                    if (i5 == 1) {
                        d5.a((Object) b5, f.REPORT_V3_RETRY_START, (Object) a5);
                    } else if (i5 == 2) {
                        a5.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.f14702d));
                        if (!z4) {
                            a5.put("reason", str);
                        }
                        if (z4) {
                            i4 = 1;
                        }
                        a5.put("result", Integer.valueOf(i4));
                        d5.a((Object) b5, f.REPORT_V3_RETRY_END, (Object) a5);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
