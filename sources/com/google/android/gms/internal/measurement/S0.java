package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class S0 extends C0516b0 implements P0 {
    public S0() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static P0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof P0) {
            return (P0) queryLocalInterface;
        }
        return new R0(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v3, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v19, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v25, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v29, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v33, types: [com.google.android.gms.internal.measurement.a1] */
    /* JADX WARNING: type inference failed for: r4v37, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v41, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v45, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v49, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v53, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v58, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v65, types: [com.google.android.gms.internal.measurement.V0] */
    /* JADX WARNING: type inference failed for: r4v70, types: [com.google.android.gms.internal.measurement.V0] */
    /* JADX WARNING: type inference failed for: r4v75, types: [com.google.android.gms.internal.measurement.V0] */
    /* JADX WARNING: type inference failed for: r4v80, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v85, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v90, types: [com.google.android.gms.internal.measurement.U0] */
    /* JADX WARNING: type inference failed for: r4v95 */
    /* JADX WARNING: type inference failed for: r4v96 */
    /* JADX WARNING: type inference failed for: r4v97 */
    /* JADX WARNING: type inference failed for: r4v98 */
    /* JADX WARNING: type inference failed for: r4v99 */
    /* JADX WARNING: type inference failed for: r4v100 */
    /* JADX WARNING: type inference failed for: r4v101 */
    /* JADX WARNING: type inference failed for: r4v102 */
    /* JADX WARNING: type inference failed for: r4v103 */
    /* JADX WARNING: type inference failed for: r4v104 */
    /* JADX WARNING: type inference failed for: r4v105 */
    /* JADX WARNING: type inference failed for: r4v106 */
    /* JADX WARNING: type inference failed for: r4v107 */
    /* JADX WARNING: type inference failed for: r4v108 */
    /* JADX WARNING: type inference failed for: r4v109 */
    /* JADX WARNING: type inference failed for: r4v110 */
    /* JADX WARNING: type inference failed for: r4v111 */
    /* JADX WARNING: type inference failed for: r4v112 */
    /* JADX WARNING: type inference failed for: r4v113 */
    /* JADX WARNING: type inference failed for: r4v114 */
    /* JADX WARNING: type inference failed for: r4v115 */
    /* JADX WARNING: type inference failed for: r4v116 */
    /* JADX WARNING: type inference failed for: r4v117 */
    /* JADX WARNING: type inference failed for: r4v118 */
    /* JADX WARNING: type inference failed for: r4v119 */
    /* JADX WARNING: type inference failed for: r4v120 */
    /* JADX WARNING: type inference failed for: r4v121 */
    /* JADX WARNING: type inference failed for: r4v122 */
    /* JADX WARNING: type inference failed for: r4v123 */
    /* JADX WARNING: type inference failed for: r4v124 */
    /* JADX WARNING: type inference failed for: r4v125 */
    /* JADX WARNING: type inference failed for: r4v126 */
    /* JADX WARNING: type inference failed for: r4v127 */
    /* JADX WARNING: type inference failed for: r4v128 */
    /* JADX WARNING: type inference failed for: r4v129 */
    /* JADX WARNING: type inference failed for: r4v130 */
    /* JADX WARNING: type inference failed for: r4v131 */
    /* JADX WARNING: type inference failed for: r4v132 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
            r8 = this;
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r3 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r4 = 0
            switch(r9) {
                case 1: goto L_0x04be;
                case 2: goto L_0x0499;
                case 3: goto L_0x0464;
                case 4: goto L_0x0443;
                case 5: goto L_0x0417;
                case 6: goto L_0x03f3;
                case 7: goto L_0x03e3;
                case 8: goto L_0x03cf;
                case 9: goto L_0x03b7;
                case 10: goto L_0x038f;
                case 11: goto L_0x037f;
                case 12: goto L_0x0373;
                case 13: goto L_0x0367;
                case 14: goto L_0x035b;
                case 15: goto L_0x033e;
                case 16: goto L_0x031e;
                case 17: goto L_0x02fe;
                case 18: goto L_0x02dc;
                case 19: goto L_0x02bc;
                case 20: goto L_0x029c;
                case 21: goto L_0x027c;
                case 22: goto L_0x025c;
                case 23: goto L_0x024c;
                case 24: goto L_0x023c;
                case 25: goto L_0x0228;
                case 26: goto L_0x0214;
                case 27: goto L_0x01f8;
                case 28: goto L_0x01e4;
                case 29: goto L_0x01d0;
                case 30: goto L_0x01bc;
                case 31: goto L_0x0190;
                case 32: goto L_0x0164;
                case 33: goto L_0x013a;
                case 34: goto L_0x011a;
                case 35: goto L_0x00fa;
                case 36: goto L_0x00da;
                case 37: goto L_0x00ce;
                case 38: goto L_0x00aa;
                case 39: goto L_0x009e;
                case 40: goto L_0x007e;
                case 41: goto L_0x0008;
                case 42: goto L_0x006e;
                case 43: goto L_0x0062;
                case 44: goto L_0x004e;
                case 45: goto L_0x003a;
                case 46: goto L_0x001a;
                case 47: goto L_0x0008;
                case 48: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r1 = 0
            return r1
        L_0x000a:
            android.os.Parcelable$Creator r2 = android.content.Intent.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r2)
            android.content.Intent r2 = (android.content.Intent) r2
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setSgtmDebugInfo(r2)
            goto L_0x04d8
        L_0x001a:
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x0021
            goto L_0x0032
        L_0x0021:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x002d
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0032
        L_0x002d:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x0032:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getSessionId(r4)
            goto L_0x04d8
        L_0x003a:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setConsentThirdParty(r2, r3)
            goto L_0x04d8
        L_0x004e:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setConsent(r2, r3)
            goto L_0x04d8
        L_0x0062:
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.clearMeasurementEnabled(r2)
            goto L_0x04d8
        L_0x006e:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setDefaultEventParameters(r2)
            goto L_0x04d8
        L_0x007e:
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x0085
            goto L_0x0096
        L_0x0085:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x0091
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0096
        L_0x0091:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x0096:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.isDataCollectionEnabled(r4)
            goto L_0x04d8
        L_0x009e:
            boolean r2 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setDataCollectionEnabled(r2)
            goto L_0x04d8
        L_0x00aa:
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x00b1
            goto L_0x00c2
        L_0x00b1:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x00bd
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x00c2
        L_0x00bd:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x00c2:
            int r2 = r10.readInt()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getTestFlag(r4, r2)
            goto L_0x04d8
        L_0x00ce:
            java.util.HashMap r2 = com.google.android.gms.internal.measurement.C0507a0.b(r10)
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.initForTests(r2)
            goto L_0x04d8
        L_0x00da:
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x00e1
            goto L_0x00f2
        L_0x00e1:
            android.os.IInterface r2 = r3.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.V0
            if (r4 == 0) goto L_0x00ed
            r4 = r2
            com.google.android.gms.internal.measurement.V0 r4 = (com.google.android.gms.internal.measurement.V0) r4
            goto L_0x00f2
        L_0x00ed:
            com.google.android.gms.internal.measurement.X0 r4 = new com.google.android.gms.internal.measurement.X0
            r4.<init>(r3)
        L_0x00f2:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.unregisterOnMeasurementEventListener(r4)
            goto L_0x04d8
        L_0x00fa:
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x0101
            goto L_0x0112
        L_0x0101:
            android.os.IInterface r2 = r3.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.V0
            if (r4 == 0) goto L_0x010d
            r4 = r2
            com.google.android.gms.internal.measurement.V0 r4 = (com.google.android.gms.internal.measurement.V0) r4
            goto L_0x0112
        L_0x010d:
            com.google.android.gms.internal.measurement.X0 r4 = new com.google.android.gms.internal.measurement.X0
            r4.<init>(r3)
        L_0x0112:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.registerOnMeasurementEventListener(r4)
            goto L_0x04d8
        L_0x011a:
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x0121
            goto L_0x0132
        L_0x0121:
            android.os.IInterface r2 = r3.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.V0
            if (r4 == 0) goto L_0x012d
            r4 = r2
            com.google.android.gms.internal.measurement.V0 r4 = (com.google.android.gms.internal.measurement.V0) r4
            goto L_0x0132
        L_0x012d:
            com.google.android.gms.internal.measurement.X0 r4 = new com.google.android.gms.internal.measurement.X0
            r4.<init>(r3)
        L_0x0132:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setEventInterceptor(r4)
            goto L_0x04d8
        L_0x013a:
            int r1 = r10.readInt()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            U.a r3 = U.a.C0004a.i(r3)
            android.os.IBinder r4 = r10.readStrongBinder()
            U.a r4 = U.a.C0004a.i(r4)
            android.os.IBinder r6 = r10.readStrongBinder()
            U.a r6 = U.a.C0004a.i(r6)
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r0 = r8
            r5 = r6
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x04d8
        L_0x0164:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x0173
            goto L_0x0184
        L_0x0173:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x017f
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0184
        L_0x017f:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x0184:
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.performAction(r1, r4, r2)
            goto L_0x04d8
        L_0x0190:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x019f
            goto L_0x01b0
        L_0x019f:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x01ab
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x01b0
        L_0x01ab:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x01b0:
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivitySaveInstanceState(r1, r4, r2)
            goto L_0x04d8
        L_0x01bc:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityResumed(r1, r2)
            goto L_0x04d8
        L_0x01d0:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityPaused(r1, r2)
            goto L_0x04d8
        L_0x01e4:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityDestroyed(r1, r2)
            goto L_0x04d8
        L_0x01f8:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityCreated(r1, r2, r3)
            goto L_0x04d8
        L_0x0214:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityStopped(r1, r2)
            goto L_0x04d8
        L_0x0228:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.onActivityStarted(r1, r2)
            goto L_0x04d8
        L_0x023c:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.endAdUnitExposure(r1, r2)
            goto L_0x04d8
        L_0x024c:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.beginAdUnitExposure(r1, r2)
            goto L_0x04d8
        L_0x025c:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0263
            goto L_0x0274
        L_0x0263:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x026f
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0274
        L_0x026f:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x0274:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.generateEventId(r4)
            goto L_0x04d8
        L_0x027c:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0283
            goto L_0x0294
        L_0x0283:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x028f
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0294
        L_0x028f:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x0294:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getGmpAppId(r4)
            goto L_0x04d8
        L_0x029c:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x02a3
            goto L_0x02b4
        L_0x02a3:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x02af
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x02b4
        L_0x02af:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x02b4:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getAppInstanceId(r4)
            goto L_0x04d8
        L_0x02bc:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x02c3
            goto L_0x02d4
        L_0x02c3:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x02cf
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x02d4
        L_0x02cf:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x02d4:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getCachedAppInstanceId(r4)
            goto L_0x04d8
        L_0x02dc:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x02e3
            goto L_0x02f6
        L_0x02e3:
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C0508a1
            if (r3 == 0) goto L_0x02f1
            r4 = r2
            com.google.android.gms.internal.measurement.a1 r4 = (com.google.android.gms.internal.measurement.C0508a1) r4
            goto L_0x02f6
        L_0x02f1:
            com.google.android.gms.internal.measurement.Z0 r4 = new com.google.android.gms.internal.measurement.Z0
            r4.<init>(r1)
        L_0x02f6:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setInstanceIdProvider(r4)
            goto L_0x04d8
        L_0x02fe:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0305
            goto L_0x0316
        L_0x0305:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x0311
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0316
        L_0x0311:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x0316:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getCurrentScreenClass(r4)
            goto L_0x04d8
        L_0x031e:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0325
            goto L_0x0336
        L_0x0325:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.U0
            if (r3 == 0) goto L_0x0331
            r4 = r2
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x0336
        L_0x0331:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r1)
        L_0x0336:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getCurrentScreenName(r4)
            goto L_0x04d8
        L_0x033e:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0004a.i(r1)
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r0 = r8
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x04d8
        L_0x035b:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setSessionTimeoutDuration(r1)
            goto L_0x04d8
        L_0x0367:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setMinimumSessionDuration(r1)
            goto L_0x04d8
        L_0x0373:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.resetAnalyticsData(r1)
            goto L_0x04d8
        L_0x037f:
            boolean r1 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setMeasurementEnabled(r1, r2)
            goto L_0x04d8
        L_0x038f:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x039e
            goto L_0x03af
        L_0x039e:
            android.os.IInterface r3 = r5.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x03aa
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x03af
        L_0x03aa:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r5)
        L_0x03af:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getConditionalUserProperties(r1, r2, r4)
            goto L_0x04d8
        L_0x03b7:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.clearConditionalUserProperty(r1, r2, r3)
            goto L_0x04d8
        L_0x03cf:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setConditionalUserProperty(r1, r2)
            goto L_0x04d8
        L_0x03e3:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.setUserId(r1, r2)
            goto L_0x04d8
        L_0x03f3:
            java.lang.String r1 = r10.readString()
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x03fe
            goto L_0x040f
        L_0x03fe:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x040a
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x040f
        L_0x040a:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r2)
        L_0x040f:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getMaxUserProperties(r1, r4)
            goto L_0x04d8
        L_0x0417:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            boolean r5 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            android.os.IBinder r7 = r10.readStrongBinder()
            if (r7 != 0) goto L_0x042a
            goto L_0x043b
        L_0x042a:
            android.os.IInterface r3 = r7.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x0436
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x043b
        L_0x0436:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r7)
        L_0x043b:
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.getUserProperties(r1, r2, r5, r4)
            goto L_0x04d8
        L_0x0443:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            U.a r3 = U.a.C0004a.i(r3)
            boolean r4 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            long r5 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r0 = r8
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x04d8
        L_0x0464:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r0)
            android.os.Bundle r0 = (android.os.Bundle) r0
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x047b
            goto L_0x048c
        L_0x047b:
            android.os.IInterface r3 = r5.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.U0
            if (r4 == 0) goto L_0x0487
            r4 = r3
            com.google.android.gms.internal.measurement.U0 r4 = (com.google.android.gms.internal.measurement.U0) r4
            goto L_0x048c
        L_0x0487:
            com.google.android.gms.internal.measurement.W0 r4 = new com.google.android.gms.internal.measurement.W0
            r4.<init>(r5)
        L_0x048c:
            long r5 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r3 = r0
            r0 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x04d8
        L_0x0499:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r0)
            r3 = r0
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            boolean r5 = com.google.android.gms.internal.measurement.C0507a0.h(r10)
            long r6 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r0 = r8
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x04d8
        L_0x04be:
            android.os.IBinder r2 = r10.readStrongBinder()
            U.a r2 = U.a.C0004a.i(r2)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.c1> r3 = com.google.android.gms.internal.measurement.C0526c1.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.C0507a0.a(r10, r3)
            com.google.android.gms.internal.measurement.c1 r3 = (com.google.android.gms.internal.measurement.C0526c1) r3
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.C0507a0.f(r10)
            r8.initialize(r2, r3, r4)
        L_0x04d8:
            r11.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.S0.h(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
