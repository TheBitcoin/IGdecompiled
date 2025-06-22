package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import q1.C2205a;
import q1.C2206b;
import r1.C2216b;

@ReceiverAction(id = "OMSDKReceiver", type = b.class)
public class OMSDKReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    e f14814a;

    /* renamed from: b  reason: collision with root package name */
    Object f14815b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f14816c;

    /* renamed from: d  reason: collision with root package name */
    C2206b f14817d;

    /* renamed from: e  reason: collision with root package name */
    C2205a f14818e;

    /* renamed from: f  reason: collision with root package name */
    C2216b f14819f;

    /* renamed from: g  reason: collision with root package name */
    float f14820g = 0.0f;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:312:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.String r0 = "args"
            boolean r1 = r15 instanceof java.util.Map     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x0409
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "methodName"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ Exception -> 0x002f }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "target"
            java.lang.Object r2 = r15.get(r2)     // Catch:{ Exception -> 0x002f }
            r14.f14815b = r2     // Catch:{ Exception -> 0x002f }
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            boolean r2 = r2 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r0 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ Exception -> 0x002f }
            r14.f14816c = r0     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r15 = r0
            goto L_0x0402
        L_0x0033:
            java.lang.String r0 = "adapter_model"
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = (com.mbridge.msdk.newreward.a.e) r15     // Catch:{ Exception -> 0x002f }
            r14.f14814a = r15     // Catch:{ Exception -> 0x002f }
            q1.b r15 = r15.ad()     // Catch:{ Exception -> 0x002f }
            r14.f14817d = r15     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = r14.f14814a     // Catch:{ Exception -> 0x002f }
            q1.a r15 = r15.ae()     // Catch:{ Exception -> 0x002f }
            r14.f14818e = r15     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = r14.f14814a     // Catch:{ Exception -> 0x002f }
            r1.b r15 = r15.af()     // Catch:{ Exception -> 0x002f }
            r14.f14819f = r15     // Catch:{ Exception -> 0x002f }
            java.lang.String r15 = r1.getName()     // Catch:{ Exception -> 0x002f }
            int r0 = r15.hashCode()     // Catch:{ Exception -> 0x002f }
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case -1606280266: goto L_0x00bf;
                case -934426579: goto L_0x00b5;
                case -266309826: goto L_0x00ab;
                case 106440182: goto L_0x00a1;
                case 157935686: goto L_0x0097;
                case 538494296: goto L_0x008d;
                case 1308882881: goto L_0x0082;
                case 1853386019: goto L_0x0077;
                case 2110051743: goto L_0x006d;
                case 2147444528: goto L_0x0063;
                default: goto L_0x0061;
            }     // Catch:{ Exception -> 0x002f }
        L_0x0061:
            goto L_0x00c9
        L_0x0063:
            java.lang.String r0 = "skipped"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 7
            goto L_0x00ca
        L_0x006d:
            java.lang.String r0 = "onBufferingStart"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 4
            goto L_0x00ca
        L_0x0077:
            java.lang.String r0 = "activityReport"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 9
            goto L_0x00ca
        L_0x0082:
            java.lang.String r0 = "checkOMSdkProgress"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 8
            goto L_0x00ca
        L_0x008d:
            java.lang.String r0 = "onBufferingEnd"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 5
            goto L_0x00ca
        L_0x0097:
            java.lang.String r0 = "onAdClick"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 6
            goto L_0x00ca
        L_0x00a1:
            java.lang.String r0 = "pause"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 2
            goto L_0x00ca
        L_0x00ab:
            java.lang.String r0 = "initViews"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 0
            goto L_0x00ca
        L_0x00b5:
            java.lang.String r0 = "resume"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 1
            goto L_0x00ca
        L_0x00bf:
            java.lang.String r0 = "setMuteState"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00c9
            r15 = 3
            goto L_0x00ca
        L_0x00c9:
            r15 = -1
        L_0x00ca:
            r4 = 0
            java.lang.String r5 = "OMSDK_TAG"
            switch(r15) {
                case 0: goto L_0x032f;
                case 1: goto L_0x0312;
                case 2: goto L_0x02f5;
                case 3: goto L_0x02b4;
                case 4: goto L_0x0297;
                case 5: goto L_0x027a;
                case 6: goto L_0x025b;
                case 7: goto L_0x01ba;
                case 8: goto L_0x01d3;
                case 9: goto L_0x00d2;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            goto L_0x0409
        L_0x00d2:
            java.lang.Object[] r15 = r14.f14816c     // Catch:{ Exception -> 0x0184 }
            if (r15 == 0) goto L_0x0409
            int r0 = r15.length     // Catch:{ Exception -> 0x0184 }
            if (r0 <= 0) goto L_0x0409
            r15 = r15[r3]     // Catch:{ Exception -> 0x0184 }
            boolean r0 = r15 instanceof java.lang.String     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0409
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0184 }
            java.lang.String r0 = "onCreate"
            boolean r0 = r15.equals(r0)     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0187
            java.lang.String r0 = "onOMSdkCreate"
            com.mbridge.msdk.foundation.tools.af.b(r5, r0)     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0187
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0187
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0164 }
            java.util.List r0 = r0.a()     // Catch:{ all -> 0x0164 }
            if (r0 != 0) goto L_0x0106
            goto L_0x0187
        L_0x0106:
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0164 }
            java.util.List r0 = r0.a()     // Catch:{ all -> 0x0164 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0164 }
            if (r1 != 0) goto L_0x0187
            java.lang.Object r1 = r0.get(r3)     // Catch:{ all -> 0x0164 }
            if (r1 != 0) goto L_0x011d
            goto L_0x0187
        L_0x011d:
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0164 }
            boolean r1 = r0.isActiveOm()     // Catch:{ all -> 0x0164 }
            if (r1 != 0) goto L_0x012a
            goto L_0x0187
        L_0x012a:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0164 }
            android.content.Context r6 = r1.c()     // Catch:{ all -> 0x0164 }
            java.lang.String r8 = r0.getOmid()     // Catch:{ all -> 0x0164 }
            java.lang.String r9 = r0.getRequestId()     // Catch:{ all -> 0x0164 }
            java.lang.String r10 = r0.getId()     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.a.e r1 = r14.f14814a     // Catch:{ all -> 0x0164 }
            java.lang.String r11 = r1.H()     // Catch:{ all -> 0x0164 }
            java.lang.String r12 = r0.getVideoUrlEncode()     // Catch:{ all -> 0x0164 }
            java.lang.String r13 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0164 }
            r7 = 0
            q1.b r0 = com.mbridge.msdk.a.b.a(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0164 }
            r14.f14817d = r0     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0166
            q1.a r0 = q1.C2205a.a(r0)     // Catch:{ all -> 0x0164 }
            r14.f14818e = r0     // Catch:{ all -> 0x0164 }
            q1.b r0 = r14.f14817d     // Catch:{ all -> 0x0164 }
            r1.b r0 = r1.C2216b.g(r0)     // Catch:{ all -> 0x0164 }
            r14.f14819f = r0     // Catch:{ all -> 0x0164 }
            goto L_0x0166
        L_0x0164:
            r0 = move-exception
            goto L_0x017c
        L_0x0166:
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            q1.b r1 = r14.f14817d     // Catch:{ all -> 0x0164 }
            r0.a((q1.C2206b) r1)     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            q1.a r1 = r14.f14818e     // Catch:{ all -> 0x0164 }
            r0.a((q1.C2205a) r1)     // Catch:{ all -> 0x0164 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f14814a     // Catch:{ all -> 0x0164 }
            r1.b r1 = r14.f14819f     // Catch:{ all -> 0x0164 }
            r0.a((r1.C2216b) r1)     // Catch:{ all -> 0x0164 }
            goto L_0x0187
        L_0x017c:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0184 }
            if (r1 == 0) goto L_0x0187
            r0.printStackTrace()     // Catch:{ Exception -> 0x0184 }
            goto L_0x0187
        L_0x0184:
            r0 = move-exception
            r15 = r0
            goto L_0x01b1
        L_0x0187:
            java.lang.String r0 = "onDestroy"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x0184 }
            if (r15 == 0) goto L_0x0409
            q1.b r15 = r14.f14817d     // Catch:{ Exception -> 0x0184 }
            if (r15 == 0) goto L_0x0409
            java.lang.String r15 = "onOMSdkDestory"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x01a6 }
            q1.b r15 = r14.f14817d     // Catch:{ Exception -> 0x01a6 }
            r15.e()     // Catch:{ Exception -> 0x01a6 }
            q1.b r15 = r14.f14817d     // Catch:{ Exception -> 0x01a6 }
            r15.c()     // Catch:{ Exception -> 0x01a6 }
            r14.f14817d = r4     // Catch:{ Exception -> 0x01a6 }
            goto L_0x0409
        L_0x01a6:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x0184 }
            goto L_0x0409
        L_0x01b1:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x01ba:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x01bf
            goto L_0x01d3
        L_0x01bf:
            java.lang.String r15 = "onOMSdkSkipped"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x01ca }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x01ca }
            r15.l()     // Catch:{ Exception -> 0x01ca }
            goto L_0x01d3
        L_0x01ca:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x01d3
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
        L_0x01d3:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x01d9
            goto L_0x0409
        L_0x01d9:
            java.lang.Object[] r15 = r14.f14816c     // Catch:{ Exception -> 0x021c }
            if (r15 == 0) goto L_0x0409
            int r0 = r15.length     // Catch:{ Exception -> 0x021c }
            if (r0 != r1) goto L_0x0409
            r0 = r15[r3]     // Catch:{ Exception -> 0x021c }
            boolean r1 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x021c }
            if (r1 == 0) goto L_0x0409
            r15 = r15[r2]     // Catch:{ Exception -> 0x021c }
            boolean r15 = r15 instanceof java.lang.Integer     // Catch:{ Exception -> 0x021c }
            if (r15 == 0) goto L_0x0409
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x021c }
            int r15 = r0.intValue()     // Catch:{ Exception -> 0x021c }
            java.lang.Object[] r0 = r14.f14816c     // Catch:{ Exception -> 0x021c }
            r0 = r0[r2]     // Catch:{ Exception -> 0x021c }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x021c }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x021c }
            if (r15 == 0) goto L_0x0243
            r0 = 25
            if (r15 == r0) goto L_0x0237
            r0 = 50
            if (r15 == r0) goto L_0x022b
            r0 = 75
            if (r15 == r0) goto L_0x021f
            r0 = 100
            if (r15 == r0) goto L_0x0210
            goto L_0x0409
        L_0x0210:
            java.lang.String r15 = "onOMSdkProgress 100"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x021c }
            r15.d()     // Catch:{ Exception -> 0x021c }
            goto L_0x0409
        L_0x021c:
            r0 = move-exception
            r15 = r0
            goto L_0x0252
        L_0x021f:
            java.lang.String r15 = "onOMSdkProgress 75"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x021c }
            r15.n()     // Catch:{ Exception -> 0x021c }
            goto L_0x0409
        L_0x022b:
            java.lang.String r15 = "onOMSdkProgress 50"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x021c }
            r15.i()     // Catch:{ Exception -> 0x021c }
            goto L_0x0409
        L_0x0237:
            java.lang.String r15 = "onOMSdkProgress 25"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x021c }
            r15.h()     // Catch:{ Exception -> 0x021c }
            goto L_0x0409
        L_0x0243:
            java.lang.String r15 = "onOMSdkProgress 0"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x021c }
            float r0 = (float) r0     // Catch:{ Exception -> 0x021c }
            float r1 = r14.f14820g     // Catch:{ Exception -> 0x021c }
            r15.m(r0, r1)     // Catch:{ Exception -> 0x021c }
            goto L_0x0409
        L_0x0252:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x025b:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0261
            goto L_0x0409
        L_0x0261:
            java.lang.String r15 = "onOMSdkClick"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x026f }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x026f }
            r1.a r0 = r1.C2215a.CLICK     // Catch:{ Exception -> 0x026f }
            r15.a(r0)     // Catch:{ Exception -> 0x026f }
            goto L_0x0409
        L_0x026f:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x027a:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0280
            goto L_0x0409
        L_0x0280:
            java.lang.String r15 = "onOMSdkBuffEnd"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x028c }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x028c }
            r15.b()     // Catch:{ Exception -> 0x028c }
            goto L_0x0409
        L_0x028c:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x0297:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x029d
            goto L_0x0409
        L_0x029d:
            java.lang.String r15 = "onOMSdkBuffStart"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x02a9 }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x02a9 }
            r15.c()     // Catch:{ Exception -> 0x02a9 }
            goto L_0x0409
        L_0x02a9:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x02b4:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x02ba
            goto L_0x0409
        L_0x02ba:
            java.lang.Object[] r15 = r14.f14816c     // Catch:{ Exception -> 0x02e0 }
            if (r15 == 0) goto L_0x0409
            int r0 = r15.length     // Catch:{ Exception -> 0x02e0 }
            if (r0 <= 0) goto L_0x0409
            r15 = r15[r3]     // Catch:{ Exception -> 0x02e0 }
            boolean r15 = r15 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x02e0 }
            if (r15 == 0) goto L_0x0409
            java.lang.String r15 = "onOMSdkChangeVolume"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x02e0 }
            java.lang.Object[] r15 = r14.f14816c     // Catch:{ Exception -> 0x02e0 }
            r15 = r15[r3]     // Catch:{ Exception -> 0x02e0 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ Exception -> 0x02e0 }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x02e0 }
            if (r15 == 0) goto L_0x02e3
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x02e0 }
            r0 = 0
            r15.o(r0)     // Catch:{ Exception -> 0x02e0 }
            goto L_0x0409
        L_0x02e0:
            r0 = move-exception
            r15 = r0
            goto L_0x02ec
        L_0x02e3:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x02e0 }
            r0 = 1065353216(0x3f800000, float:1.0)
            r15.o(r0)     // Catch:{ Exception -> 0x02e0 }
            goto L_0x0409
        L_0x02ec:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x02f5:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x02fb
            goto L_0x0409
        L_0x02fb:
            java.lang.String r15 = "onOMSdkPause"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0307 }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x0307 }
            r15.j()     // Catch:{ Exception -> 0x0307 }
            goto L_0x0409
        L_0x0307:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x0312:
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0318
            goto L_0x0409
        L_0x0318:
            java.lang.String r15 = "onOMSDKResume"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0324 }
            r1.b r15 = r14.f14819f     // Catch:{ Exception -> 0x0324 }
            r15.k()     // Catch:{ Exception -> 0x0324 }
            goto L_0x0409
        L_0x0324:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x032f:
            com.mbridge.msdk.newreward.a.e r15 = r14.f14814a     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0335
            goto L_0x0409
        L_0x0335:
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            boolean r15 = r15.ag()     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0409
            java.lang.String r15 = "onOMSdkStart"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0363 }
            q1.b r15 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            r15.g()     // Catch:{ Exception -> 0x0363 }
            com.mbridge.msdk.newreward.a.e r15 = r14.f14814a     // Catch:{ Exception -> 0x0363 }
            r15.o(r2)     // Catch:{ Exception -> 0x0363 }
            q1.a r15 = r14.f14818e     // Catch:{ Exception -> 0x0363 }
            if (r15 == 0) goto L_0x0367
            r1.c r15 = r1.C2217c.STANDALONE     // Catch:{ Exception -> 0x0363 }
            r1.d r15 = r1.C2218d.b(r2, r15)     // Catch:{ Exception -> 0x0363 }
            q1.a r0 = r14.f14818e     // Catch:{ Exception -> 0x0363 }
            r0.d(r15)     // Catch:{ Exception -> 0x0363 }
            q1.a r15 = r14.f14818e     // Catch:{ Exception -> 0x0363 }
            r15.b()     // Catch:{ Exception -> 0x0363 }
            goto L_0x0367
        L_0x0363:
            r0 = move-exception
            r15 = r0
            goto L_0x03fa
        L_0x0367:
            java.lang.Object r15 = r14.f14815b     // Catch:{ Exception -> 0x0363 }
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.view.BaseTemplate     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x03bc
            com.mbridge.msdk.newreward.player.view.BaseTemplate r15 = (com.mbridge.msdk.newreward.player.view.BaseTemplate) r15     // Catch:{ Exception -> 0x0363 }
            com.mbridge.msdk.playercommon.PlayerView r0 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x0388
            com.mbridge.msdk.playercommon.PlayerView r0 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0363 }
            float r0 = r0.getVolume()     // Catch:{ Exception -> 0x0363 }
            r14.f14820g = r0     // Catch:{ Exception -> 0x0363 }
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            com.mbridge.msdk.playercommon.PlayerView r1 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0363 }
            r0.d(r1)     // Catch:{ Exception -> 0x0363 }
        L_0x0388:
            com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView r0 = r15.getmSoundImageView()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x0399
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView r1 = r15.getmSoundImageView()     // Catch:{ Exception -> 0x0363 }
            q1.h r2 = q1.h.OTHER     // Catch:{ Exception -> 0x0363 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0363 }
        L_0x0399:
            android.widget.TextView r0 = r15.getmTvCountDown()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x03aa
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            android.widget.TextView r1 = r15.getmTvCountDown()     // Catch:{ Exception -> 0x0363 }
            q1.h r2 = q1.h.OTHER     // Catch:{ Exception -> 0x0363 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0363 }
        L_0x03aa:
            android.view.View r0 = r15.getmViewPlayingClose()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x0409
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            android.view.View r15 = r15.getmViewPlayingClose()     // Catch:{ Exception -> 0x0363 }
            q1.h r1 = q1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0363 }
            r0.a(r15, r1, r4)     // Catch:{ Exception -> 0x0363 }
            goto L_0x0409
        L_0x03bc:
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x03ea
            com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate r15 = (com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate) r15     // Catch:{ Exception -> 0x0363 }
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            r0.d(r15)     // Catch:{ Exception -> 0x0363 }
            android.view.View r0 = r15.getCloseView()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x03d8
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            android.view.View r1 = r15.getCloseView()     // Catch:{ Exception -> 0x0363 }
            q1.h r2 = q1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0363 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0363 }
        L_0x03d8:
            android.widget.ImageView r0 = r15.getNoticeIV()     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x0409
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            android.widget.ImageView r15 = r15.getNoticeIV()     // Catch:{ Exception -> 0x0363 }
            q1.h r1 = q1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0363 }
            r0.a(r15, r1, r4)     // Catch:{ Exception -> 0x0363 }
            goto L_0x0409
        L_0x03ea:
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.iview.IBaseWebView     // Catch:{ Exception -> 0x0363 }
            if (r0 == 0) goto L_0x0409
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r15 = (com.mbridge.msdk.newreward.player.iview.IBaseWebView) r15     // Catch:{ Exception -> 0x0363 }
            q1.b r0 = r14.f14817d     // Catch:{ Exception -> 0x0363 }
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r15 = r15.getWebView()     // Catch:{ Exception -> 0x0363 }
            r0.d(r15)     // Catch:{ Exception -> 0x0363 }
            goto L_0x0409
        L_0x03fa:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x0409
        L_0x0402:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0409
            r15.printStackTrace()
        L_0x0409:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.OMSDKReceiver.a(java.lang.Object):void");
    }
}
