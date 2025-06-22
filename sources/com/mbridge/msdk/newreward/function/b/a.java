package com.mbridge.msdk.newreward.function.b;

import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.a.a;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f14475a = "RewardCandidateController";

    /* renamed from: b  reason: collision with root package name */
    private final c f14476b;

    /* renamed from: c  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.a.c f14477c;

    public a(String str, boolean z4, c cVar) {
        this.f14476b = cVar;
        try {
            com.mbridge.msdk.newreward.function.a.c a5 = com.mbridge.msdk.newreward.function.a.a.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, z4).G());
            this.f14477c = a5;
            a5.a(cVar);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> b(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> u4;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list.get(i4);
            if (!(bVar2 == null || (u4 = bVar2.u()) == null || u4.size() == 0)) {
                arrayList.add(bVar2);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083 A[SYNTHETIC, Splitter:B:22:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A[Catch:{ Exception -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af A[Catch:{ Exception -> 0x0103 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.newreward.function.a.b a(com.mbridge.msdk.foundation.same.report.d.c r21, com.mbridge.msdk.foundation.c.b r22, com.mbridge.msdk.newreward.a.e r23, int r24) {
        /*
            r20 = this;
            r0 = r20
            r6 = r23
            com.mbridge.msdk.newreward.function.a.b r10 = new com.mbridge.msdk.newreward.function.a.b
            r10.<init>()
            r1 = 0
            java.lang.String r2 = ""
            r3 = 0
            r4 = 94
            if (r6 == 0) goto L_0x007b
            java.lang.String r5 = r6.J()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.e.a r7 = r6.D()     // Catch:{ Exception -> 0x010e }
            if (r7 == 0) goto L_0x0058
            com.mbridge.msdk.newreward.function.e.a r7 = r6.D()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.c.a.b r7 = r7.b()     // Catch:{ Exception -> 0x010e }
            if (r7 == 0) goto L_0x0058
            com.mbridge.msdk.newreward.function.e.a r7 = r6.D()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.c.a.b r7 = r7.b()     // Catch:{ Exception -> 0x010e }
            java.util.List r7 = r7.E()     // Catch:{ Exception -> 0x010e }
            if (r7 == 0) goto L_0x0058
            com.mbridge.msdk.newreward.function.e.a r7 = r6.D()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.c.a.b r7 = r7.b()     // Catch:{ Exception -> 0x010e }
            java.util.List r7 = r7.E()     // Catch:{ Exception -> 0x010e }
            int r7 = r7.size()     // Catch:{ Exception -> 0x010e }
            if (r7 <= 0) goto L_0x0058
            com.mbridge.msdk.newreward.function.e.a r7 = r6.D()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.c.a.b r7 = r7.b()     // Catch:{ Exception -> 0x010e }
            java.util.List r7 = r7.E()     // Catch:{ Exception -> 0x010e }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x010e }
            goto L_0x0059
        L_0x0058:
            r7 = r3
        L_0x0059:
            com.mbridge.msdk.newreward.function.a.c r8 = r0.f14477c     // Catch:{ Exception -> 0x010e }
            if (r8 == 0) goto L_0x0077
            int r4 = r6.h()     // Catch:{ Exception -> 0x010e }
            java.lang.String r8 = r6.C()     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.a.c r9 = r0.f14477c     // Catch:{ Exception -> 0x010e }
            r9.a((int) r4)     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.a.c r9 = r0.f14477c     // Catch:{ Exception -> 0x010e }
            r9.f(r8)     // Catch:{ Exception -> 0x010e }
            com.mbridge.msdk.newreward.function.a.c r9 = r0.f14477c     // Catch:{ Exception -> 0x010e }
            r9.a((com.mbridge.msdk.newreward.a.e) r6)     // Catch:{ Exception -> 0x010e }
            r9 = r8
            r8 = r4
            goto L_0x007f
        L_0x0077:
            r9 = r2
        L_0x0078:
            r8 = 94
            goto L_0x007f
        L_0x007b:
            r9 = r2
            r5 = r3
            r7 = r5
            goto L_0x0078
        L_0x007f:
            if (r7 != 0) goto L_0x0083
            r14 = r2
            goto L_0x0088
        L_0x0083:
            java.lang.String r4 = r7.getRequestId()     // Catch:{ Exception -> 0x0103 }
            r14 = r4
        L_0x0088:
            if (r22 == 0) goto L_0x0096
            int r3 = r22.e()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = r22.b()     // Catch:{ Exception -> 0x0103 }
            r15 = r3
            r16 = r4
            goto L_0x0099
        L_0x0096:
            r16 = r3
            r15 = 0
        L_0x0099:
            com.mbridge.msdk.newreward.function.a.c r3 = r0.f14477c     // Catch:{ Exception -> 0x0103 }
            if (r3 != 0) goto L_0x00af
            com.mbridge.msdk.newreward.function.a.b r1 = new com.mbridge.msdk.newreward.function.a.b     // Catch:{ Exception -> 0x0103 }
            r1.<init>()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r2 = "can not get manager"
            r1.d(r2)     // Catch:{ Exception -> 0x0103 }
            int r2 = com.mbridge.msdk.foundation.b.c.f12737c     // Catch:{ Exception -> 0x0103 }
            r1.a((int) r2)     // Catch:{ Exception -> 0x0103 }
            r10 = r1
            goto L_0x0118
        L_0x00af:
            com.mbridge.msdk.newreward.function.a.b r3 = r3.c(r5)     // Catch:{ Exception -> 0x0103 }
            int r4 = r3.h()     // Catch:{ Exception -> 0x0103 }
            int r7 = com.mbridge.msdk.foundation.b.c.f12736b     // Catch:{ Exception -> 0x0103 }
            if (r4 <= r7) goto L_0x00bd
        L_0x00bb:
            r10 = r3
            goto L_0x0118
        L_0x00bd:
            java.lang.String r3 = "_"
            java.lang.String[] r3 = r5.split(r3)     // Catch:{ Exception -> 0x0103 }
            r4 = 3
            r3 = r3[r4]     // Catch:{ Exception -> 0x0103 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.a(r3)     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = "\\|"
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ Exception -> 0x0103 }
            r1 = r3[r1]     // Catch:{ Exception -> 0x0103 }
            double r18 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x0103 }
            int r1 = r3.length     // Catch:{ Exception -> 0x0103 }
            r4 = 1
            if (r1 <= r4) goto L_0x00dc
            r2 = r3[r4]     // Catch:{ Exception -> 0x0103 }
        L_0x00dc:
            r4 = r21
            r7 = r24
            r3 = r2
            r1 = r18
            com.mbridge.msdk.newreward.function.a.b r3 = r0.a(r1, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0103 }
            if (r3 == 0) goto L_0x00bb
            com.mbridge.msdk.newreward.function.c.a.b r4 = r3.a()     // Catch:{ Exception -> 0x0103 }
            if (r4 == 0) goto L_0x00bb
            com.mbridge.msdk.newreward.function.a.c r11 = r0.f14477c     // Catch:{ Exception -> 0x0103 }
            com.mbridge.msdk.newreward.function.c.a.b r4 = r3.a()     // Catch:{ Exception -> 0x0103 }
            java.util.List r12 = r4.u()     // Catch:{ Exception -> 0x0103 }
            r13 = r21
            r17 = r24
            r18 = r1
            r11.a(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0103 }
            goto L_0x00bb
        L_0x0103:
            java.lang.String r1 = "getRewardCandidateCampaignList result exception"
            r10.d(r1)     // Catch:{ Exception -> 0x010e }
            int r1 = com.mbridge.msdk.foundation.b.c.f12737c     // Catch:{ Exception -> 0x010e }
            r10.a((int) r1)     // Catch:{ Exception -> 0x010e }
            goto L_0x0118
        L_0x010e:
            java.lang.String r1 = "getCandidateCampaignList result exception"
            r10.d(r1)
            int r1 = com.mbridge.msdk.foundation.b.c.f12737c
            r10.a((int) r1)
        L_0x0118:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.b.a.a(com.mbridge.msdk.foundation.same.report.d.c, com.mbridge.msdk.foundation.c.b, com.mbridge.msdk.newreward.a.e, int):com.mbridge.msdk.newreward.function.a.b");
    }

    private com.mbridge.msdk.newreward.function.a.b a(double d5, String str, com.mbridge.msdk.foundation.same.report.d.c cVar, String str2, e eVar, int i4, int i5, String str3) {
        com.mbridge.msdk.newreward.function.a.b bVar;
        int i6;
        e eVar2;
        String str4;
        com.mbridge.msdk.foundation.same.report.d.c cVar2;
        a aVar;
        int i7;
        List<com.mbridge.msdk.newreward.function.c.a.b> list;
        com.mbridge.msdk.newreward.function.a.b a5 = this.f14477c.a();
        try {
            if (a5.h() > 0) {
                return a5;
            }
            JSONObject a6 = this.f14477c.a(str);
            if (a6 != null) {
                int optInt = a6.optInt("max_usage_limit", 10);
                if (a6.optInt("max_cache_num", 20) > 0) {
                    List<com.mbridge.msdk.newreward.function.c.a.b> a7 = this.f14477c.a(optInt, i5, str3);
                    if (a7 == null || a7.size() <= 0) {
                        a5.d("no cache");
                        a5.a(com.mbridge.msdk.foundation.b.c.f12737c);
                        bVar = a5;
                        try {
                            a(cVar, str2, bVar, (List<a.C0193a>) null, a6, eVar, 2);
                            return bVar;
                        } catch (Exception unused) {
                            bVar.d("getHighestCampaigns exception");
                            bVar.a(com.mbridge.msdk.foundation.b.c.f12737c);
                            return bVar;
                        }
                    } else {
                        com.mbridge.msdk.newreward.function.a.b bVar2 = new com.mbridge.msdk.newreward.function.a.b();
                        if (a7.size() == 0) {
                            bVar2.d("candidate is null");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f12737c);
                            return bVar2;
                        }
                        for (int i8 = 0; i8 < a7.size(); i8++) {
                            com.mbridge.msdk.newreward.function.c.a.b bVar3 = a7.get(i8);
                            if (bVar3 != null) {
                                bVar2.a(bVar3.f());
                            }
                        }
                        if (a7.size() > 0) {
                            if (a7.size() != 0) {
                                ArrayList arrayList = new ArrayList();
                                for (int i9 = 0; i9 < a7.size(); i9++) {
                                    com.mbridge.msdk.newreward.function.c.a.b bVar4 = a7.get(i9);
                                    if (bVar4 != null) {
                                        List<com.mbridge.msdk.newreward.function.c.a.a> u4 = bVar4.u();
                                        if (u4 != null) {
                                            if (u4.size() != 0) {
                                                int i10 = 0;
                                                boolean z4 = false;
                                                while (true) {
                                                    if (i10 >= u4.size()) {
                                                        break;
                                                    }
                                                    com.mbridge.msdk.newreward.function.c.a.a aVar2 = u4.get(i10);
                                                    boolean c5 = ak.c(com.mbridge.msdk.foundation.controller.c.m().c(), aVar2.h().getPackageName());
                                                    if (c5) {
                                                        bVar2.c(bVar4.f());
                                                        com.mbridge.msdk.newreward.function.a.c cVar3 = this.f14477c;
                                                        if (cVar3 != null) {
                                                            cVar3.a(bVar4.g(), bVar4.f(), 2, aVar2.i().s());
                                                        }
                                                        z4 = c5;
                                                    } else {
                                                        i10++;
                                                        z4 = c5;
                                                    }
                                                }
                                                if (!z4) {
                                                    arrayList.add(bVar4);
                                                }
                                            }
                                        }
                                    }
                                }
                                a7 = arrayList;
                            }
                            if (a7.size() == 0) {
                                bVar2.d("existed");
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f12737c);
                            }
                        }
                        if (a7.size() > 0 && ((a7 = a(a7, bVar2)) == null || a7.size() == 0)) {
                            bVar2.d("not ready");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f12737c);
                        }
                        if (a7.size() > 0 && ((a7 = b(a7, bVar2)) == null || a7.size() == 0)) {
                            bVar2.d("had in cache");
                            bVar2.a(com.mbridge.msdk.foundation.b.c.f12737c);
                        }
                        ArrayList arrayList2 = null;
                        if (a7 == null || a7.size() <= 0) {
                            aVar = this;
                            cVar2 = cVar;
                            str4 = str2;
                            eVar2 = eVar;
                            i6 = i4;
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            double optDouble = a6.optDouble("t_disc", 0.8d);
                            double optDouble2 = a6.optDouble("u_disc", 0.95d);
                            double optDouble3 = a6.optDouble("max_ecppv_diff", 0.0d);
                            int optInt2 = a6.optInt("time_interval", 1800);
                            int size = a7.size();
                            double d6 = 0.0d;
                            com.mbridge.msdk.newreward.function.c.a.b bVar5 = null;
                            int i11 = 0;
                            while (i11 < size) {
                                com.mbridge.msdk.newreward.function.c.a.b bVar6 = a7.get(i11);
                                if (bVar6 != null) {
                                    list = a7;
                                    double pow = Math.pow(optDouble2, (double) bVar6.t()) * bVar6.s() * Math.pow(optDouble, ((double) (System.currentTimeMillis() - bVar6.I())) / (((double) optInt2) * 1000.0d));
                                    i7 = optInt2;
                                    arrayList3.add(new a.C0193a(pow, bVar6));
                                    if (pow >= d5 - optDouble3 && pow > d6) {
                                        d6 = pow;
                                        bVar5 = bVar6;
                                    }
                                } else {
                                    list = a7;
                                    i7 = optInt2;
                                }
                                i11++;
                                a7 = list;
                                optInt2 = i7;
                            }
                            if (bVar5 != null) {
                                bVar2.a(bVar5);
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f12738d);
                            } else {
                                bVar2.d("no match campaign");
                                bVar2.a(com.mbridge.msdk.foundation.b.c.f12737c);
                            }
                            arrayList2 = arrayList3;
                            aVar = this;
                            cVar2 = cVar;
                            str4 = str2;
                            i6 = i4;
                            eVar2 = eVar;
                        }
                        aVar.a(cVar2, str4, bVar2, arrayList2, a6, eVar2, i6);
                        return bVar2;
                    }
                } else {
                    com.mbridge.msdk.newreward.function.a.b bVar7 = a5;
                    bVar7.d("max cache num error");
                    bVar7.a(com.mbridge.msdk.foundation.b.c.f12737c);
                    return bVar7;
                }
            } else {
                com.mbridge.msdk.newreward.function.a.b bVar8 = a5;
                bVar8.d("setting config not mapping");
                bVar8.a(com.mbridge.msdk.foundation.b.c.f12737c);
                return bVar8;
            }
        } catch (Exception unused2) {
            bVar = a5;
            bVar.d("getHighestCampaigns exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12737c);
            return bVar;
        }
    }

    private List<com.mbridge.msdk.newreward.function.c.a.b> a(List<com.mbridge.msdk.newreward.function.c.a.b> list, com.mbridge.msdk.newreward.function.a.b bVar) {
        List<com.mbridge.msdk.newreward.function.c.a.a> u4;
        List<com.mbridge.msdk.newreward.function.c.a.b> list2 = list;
        if (list2 == null || list2.size() == 0) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list2.size(); i4++) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = list2.get(i4);
            if (bVar2 == null || (u4 = bVar2.u()) == null || u4.size() == 0) {
                com.mbridge.msdk.newreward.function.a.b bVar3 = bVar;
            } else {
                int i5 = 0;
                boolean z4 = false;
                while (true) {
                    if (i5 >= u4.size()) {
                        com.mbridge.msdk.newreward.function.a.b bVar4 = bVar;
                        break;
                    }
                    com.mbridge.msdk.newreward.function.c.a.a aVar = u4.get(i5);
                    boolean z5 = aVar.i().z();
                    if (!z5) {
                        bVar.b(bVar2.f());
                        com.mbridge.msdk.newreward.function.a.c cVar = this.f14477c;
                        if (cVar != null) {
                            cVar.a(bVar2.g(), bVar2.f(), 2, aVar.i().s());
                        }
                        z4 = z5;
                    } else {
                        com.mbridge.msdk.newreward.function.a.b bVar5 = bVar;
                        i5++;
                        z4 = z5;
                    }
                }
                if (z4) {
                    arrayList.add(bVar2);
                }
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        JSONObject a5;
        try {
            com.mbridge.msdk.newreward.function.a.c cVar = this.f14477c;
            if (cVar == null || (a5 = cVar.a(cVar.b(str))) == null || a5.optInt("c_cb", 0) != 1) {
                return false;
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, com.mbridge.msdk.newreward.function.a.b bVar, List<a.C0193a> list, JSONObject jSONObject, e eVar, int i4) {
        String str2;
        char c5;
        com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
        String str3 = str;
        List<a.C0193a> list2 = list;
        e eVar2 = eVar;
        int i5 = i4;
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar3 = new com.mbridge.msdk.foundation.same.report.d.e();
            if (i5 == 1) {
                str2 = "cb";
            } else if (i5 == 2) {
                str2 = "candidate";
            } else if (i5 != 3) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            } else {
                str2 = "track";
            }
            eVar3.a("scene", str2);
            com.mbridge.msdk.newreward.function.a.c cVar3 = this.f14477c;
            if (cVar3 != null) {
                double d5 = cVar3.d(str3);
                if (d5 >= 0.0d) {
                    eVar3.a("bp", z.b(d5 + ""));
                }
                eVar3.a("cb_state", a(str3) ? "open" : CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                try {
                    com.mbridge.msdk.newreward.function.a.c cVar4 = this.f14477c;
                    JSONObject a5 = cVar4.a(cVar4.b(str3));
                    if (a5 != null) {
                        eVar3.a("config", a5.toString());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (bVar != null) {
                if (bVar.h() == com.mbridge.msdk.foundation.b.c.f12738d) {
                    eVar3.a("result", 1);
                } else {
                    eVar3.a("result", 2);
                    eVar3.a("reason", bVar.b());
                }
                eVar3.a("acr", bVar.c());
                eVar3.a("her", bVar.e());
                eVar3.a("nrr", bVar.d());
                eVar3.a("cer", bVar.f());
            } else {
                eVar3.a("result", 2);
                eVar3.a("reason", "candidate result is null");
            }
            if (list2 == null || list2.size() <= 0) {
                c5 = 0;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    com.mbridge.msdk.newreward.function.c.a.b a6 = list2.get(i6).a();
                    if (a6 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", z.b(a6.s() + ""));
                        jSONObject2.put("showCount", a6.t());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a6.I());
                        jSONArray.put(jSONObject2);
                    }
                }
                c5 = 0;
                eVar3.a(DataSchemeDataSource.SCHEME_DATA, jSONArray.toString());
            }
            if (cVar2 != null) {
                cVar2.a("m_candidate_data");
                cVar2.k("m_candidate_data");
                cVar2.a("m_candidate_data", eVar3);
                if (!(bVar == null || bVar.a() == null || eVar2 == null)) {
                    cVar2.b(eVar2.D().a());
                }
            }
            c cVar5 = this.f14476b;
            f fVar = f.METRICS_KEY_M_CANDIDATE_DATE;
            Object[] objArr = new Object[2];
            objArr[c5] = "metrics_data";
            objArr[1] = eVar3;
            cVar5.a((Object) eVar2, fVar, (Object) cVar5.a(objArr));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
