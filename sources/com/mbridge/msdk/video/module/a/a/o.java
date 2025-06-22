package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Map;

public class o extends k {

    /* renamed from: k  reason: collision with root package name */
    protected int f16563k = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16564l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16565m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16566n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16567o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16568p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16569q = false;

    /* renamed from: r  reason: collision with root package name */
    private Map<Integer, String> f16570r;

    /* renamed from: s  reason: collision with root package name */
    private MBridgeVideoView.a f16571s;

    /* renamed from: t  reason: collision with root package name */
    private int f16572t = -1;

    public o(CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i4, z4);
        if (this.f16526a) {
            this.f16570r = campaignEx.getAdvImpList();
        }
        this.f16563k = campaignEx.getVideoCompleteTime();
    }

    public void a(int i4, final Object obj) {
        int i5;
        CampaignEx campaignEx;
        if (i4 != 2) {
            int i6 = 0;
            if (i4 != 20) {
                if (i4 != 130) {
                    if (i4 != 6) {
                        if (i4 != 7) {
                            if (i4 == 15) {
                                g();
                                f();
                                e();
                                if (ah.a().a("i_l_s_t_r_i", false) && !this.f16567o) {
                                    this.f16567o = true;
                                    MBridgeVideoView.a aVar = this.f16571s;
                                    if (aVar != null) {
                                        aVar.a();
                                    }
                                }
                                if (obj == null || !(obj instanceof MBridgeVideoView.b)) {
                                    i5 = 0;
                                } else {
                                    int i7 = ((MBridgeVideoView.b) obj).f16494a;
                                    i6 = ((MBridgeVideoView.b) obj).f16495b;
                                    i5 = i7;
                                }
                                if (i6 == 0 && (campaignEx = this.f16527b) != null) {
                                    i6 = campaignEx.getVideoLength();
                                }
                                b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, i5, i6, this.f16535j);
                                b.a(this.f16527b, this.f16570r, this.f16532g, i5);
                                if (!this.f16568p) {
                                    this.f16568p = true;
                                    b.a(this.f16527b, this.f16532g);
                                }
                                if (!this.f16569q) {
                                    int i8 = this.f16563k;
                                    if (i8 != 0) {
                                        i6 = i8;
                                    }
                                    if (i5 >= i6) {
                                        this.f16569q = true;
                                        i4 = 17;
                                    }
                                }
                                af.b("NotifyListener", "onPlayProgress:" + i5);
                                this.f16572t = i5;
                            } else if (i4 != 16) {
                                switch (i4) {
                                    case 11:
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        d();
                                        break;
                                    case 12:
                                        AnonymousClass1 r12 = new Runnable() {
                                            public final void run() {
                                                Object obj = obj;
                                                if (obj instanceof String) {
                                                    o.this.a((String) obj);
                                                }
                                            }
                                        };
                                        d.a();
                                        com.mbridge.msdk.foundation.same.f.a.b().execute(r12);
                                        d();
                                        b();
                                        c();
                                        k.AnonymousClass4 r13 = new Runnable() {
                                            public final void run(
/*
Method generation error in method: com.mbridge.msdk.video.module.a.a.k.4.run():void, dex: classes3.dex
                                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.mbridge.msdk.video.module.a.a.k.4.run():void, class status: UNLOADED
                                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:298)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                            
*/
                                        };
                                        d.a();
                                        com.mbridge.msdk.foundation.same.f.a.b().execute(r13);
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        break;
                                    case 13:
                                        try {
                                            b();
                                            c();
                                            break;
                                        } catch (Throwable th) {
                                            af.b("NotifyListener", th.getMessage(), th);
                                            return;
                                        }
                                }
                            }
                        } else if (this.f16526a && obj != null && (obj instanceof Integer)) {
                            int intValue = ((Integer) obj).intValue();
                            if (intValue == 2) {
                                if (!this.f16565m) {
                                    this.f16565m = true;
                                    b.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b);
                                }
                            } else if (intValue == 1 && !this.f16564l) {
                                this.f16564l = true;
                                b.c(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b);
                            }
                        }
                    }
                } else if (obj instanceof Integer) {
                    this.f16563k = ((Integer) obj).intValue();
                }
            } else if (ah.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                this.f16571s = (MBridgeVideoView.a) obj;
            }
            this.f16534i.a(i4, obj);
        }
        if (this.f16526a && !this.f16566n) {
            this.f16566n = true;
            d();
            b.e(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b);
        }
        this.f16534i.a(i4, obj);
    }
}
