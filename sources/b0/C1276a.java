package B0;

import B0.F;
import K0.C1494c;
import K0.C1495d;
import K0.C1496e;
import L0.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* renamed from: B0.a  reason: case insensitive filesystem */
public final class C1276a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5774a = new C1276a();

    /* renamed from: B0.a$a  reason: collision with other inner class name */
    private static final class C0077a implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final C0077a f5775a = new C0077a();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5776b = C1494c.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5777c = C1494c.d("libraryName");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5778d = C1494c.d("buildId");

        private C0077a() {
        }

        /* renamed from: b */
        public void a(F.a.C0059a aVar, C1496e eVar) {
            eVar.a(f5776b, aVar.b());
            eVar.a(f5777c, aVar.d());
            eVar.a(f5778d, aVar.c());
        }
    }

    /* renamed from: B0.a$b */
    private static final class b implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final b f5779a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5780b = C1494c.d("pid");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5781c = C1494c.d("processName");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5782d = C1494c.d("reasonCode");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5783e = C1494c.d("importance");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5784f = C1494c.d("pss");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5785g = C1494c.d("rss");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5786h = C1494c.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: i  reason: collision with root package name */
        private static final C1494c f5787i = C1494c.d("traceFile");

        /* renamed from: j  reason: collision with root package name */
        private static final C1494c f5788j = C1494c.d("buildIdMappingForArch");

        private b() {
        }

        /* renamed from: b */
        public void a(F.a aVar, C1496e eVar) {
            eVar.d(f5780b, aVar.d());
            eVar.a(f5781c, aVar.e());
            eVar.d(f5782d, aVar.g());
            eVar.d(f5783e, aVar.c());
            eVar.c(f5784f, aVar.f());
            eVar.c(f5785g, aVar.h());
            eVar.c(f5786h, aVar.i());
            eVar.a(f5787i, aVar.j());
            eVar.a(f5788j, aVar.b());
        }
    }

    /* renamed from: B0.a$c */
    private static final class c implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final c f5789a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5790b = C1494c.d(LeanbackPreferenceDialogFragment.ARG_KEY);

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5791c = C1494c.d("value");

        private c() {
        }

        /* renamed from: b */
        public void a(F.c cVar, C1496e eVar) {
            eVar.a(f5790b, cVar.b());
            eVar.a(f5791c, cVar.c());
        }
    }

    /* renamed from: B0.a$d */
    private static final class d implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final d f5792a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5793b = C1494c.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5794c = C1494c.d("gmpAppId");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5795d = C1494c.d("platform");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5796e = C1494c.d("installationUuid");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5797f = C1494c.d("firebaseInstallationId");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5798g = C1494c.d("firebaseAuthenticationToken");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5799h = C1494c.d("appQualitySessionId");

        /* renamed from: i  reason: collision with root package name */
        private static final C1494c f5800i = C1494c.d("buildVersion");

        /* renamed from: j  reason: collision with root package name */
        private static final C1494c f5801j = C1494c.d("displayVersion");

        /* renamed from: k  reason: collision with root package name */
        private static final C1494c f5802k = C1494c.d("session");

        /* renamed from: l  reason: collision with root package name */
        private static final C1494c f5803l = C1494c.d("ndkPayload");

        /* renamed from: m  reason: collision with root package name */
        private static final C1494c f5804m = C1494c.d("appExitInfo");

        private d() {
        }

        /* renamed from: b */
        public void a(F f4, C1496e eVar) {
            eVar.a(f5793b, f4.m());
            eVar.a(f5794c, f4.i());
            eVar.d(f5795d, f4.l());
            eVar.a(f5796e, f4.j());
            eVar.a(f5797f, f4.h());
            eVar.a(f5798g, f4.g());
            eVar.a(f5799h, f4.d());
            eVar.a(f5800i, f4.e());
            eVar.a(f5801j, f4.f());
            eVar.a(f5802k, f4.n());
            eVar.a(f5803l, f4.k());
            eVar.a(f5804m, f4.c());
        }
    }

    /* renamed from: B0.a$e */
    private static final class e implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final e f5805a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5806b = C1494c.d("files");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5807c = C1494c.d("orgId");

        private e() {
        }

        /* renamed from: b */
        public void a(F.d dVar, C1496e eVar) {
            eVar.a(f5806b, dVar.b());
            eVar.a(f5807c, dVar.c());
        }
    }

    /* renamed from: B0.a$f */
    private static final class f implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final f f5808a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5809b = C1494c.d("filename");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5810c = C1494c.d("contents");

        private f() {
        }

        /* renamed from: b */
        public void a(F.d.b bVar, C1496e eVar) {
            eVar.a(f5809b, bVar.c());
            eVar.a(f5810c, bVar.b());
        }
    }

    /* renamed from: B0.a$g */
    private static final class g implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final g f5811a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5812b = C1494c.d("identifier");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5813c = C1494c.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5814d = C1494c.d("displayVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5815e = C1494c.d("organization");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5816f = C1494c.d("installationUuid");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5817g = C1494c.d("developmentPlatform");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5818h = C1494c.d("developmentPlatformVersion");

        private g() {
        }

        /* renamed from: b */
        public void a(F.e.a aVar, C1496e eVar) {
            eVar.a(f5812b, aVar.e());
            eVar.a(f5813c, aVar.h());
            eVar.a(f5814d, aVar.d());
            C1494c cVar = f5815e;
            aVar.g();
            eVar.a(cVar, (Object) null);
            eVar.a(f5816f, aVar.f());
            eVar.a(f5817g, aVar.b());
            eVar.a(f5818h, aVar.c());
        }
    }

    /* renamed from: B0.a$h */
    private static final class h implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final h f5819a = new h();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5820b = C1494c.d("clsId");

        private h() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((F.e.a.b) null, (C1496e) obj2);
        }

        public void b(F.e.a.b bVar, C1496e eVar) {
            throw null;
        }
    }

    /* renamed from: B0.a$i */
    private static final class i implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final i f5821a = new i();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5822b = C1494c.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5823c = C1494c.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5824d = C1494c.d("cores");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5825e = C1494c.d("ram");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5826f = C1494c.d("diskSpace");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5827g = C1494c.d("simulator");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5828h = C1494c.d(MRAIDCommunicatorUtil.KEY_STATE);

        /* renamed from: i  reason: collision with root package name */
        private static final C1494c f5829i = C1494c.d("manufacturer");

        /* renamed from: j  reason: collision with root package name */
        private static final C1494c f5830j = C1494c.d("modelClass");

        private i() {
        }

        /* renamed from: b */
        public void a(F.e.c cVar, C1496e eVar) {
            eVar.d(f5822b, cVar.b());
            eVar.a(f5823c, cVar.f());
            eVar.d(f5824d, cVar.c());
            eVar.c(f5825e, cVar.h());
            eVar.c(f5826f, cVar.d());
            eVar.g(f5827g, cVar.j());
            eVar.d(f5828h, cVar.i());
            eVar.a(f5829i, cVar.e());
            eVar.a(f5830j, cVar.g());
        }
    }

    /* renamed from: B0.a$j */
    private static final class j implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final j f5831a = new j();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5832b = C1494c.d("generator");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5833c = C1494c.d("identifier");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5834d = C1494c.d("appQualitySessionId");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5835e = C1494c.d("startedAt");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5836f = C1494c.d("endedAt");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5837g = C1494c.d("crashed");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5838h = C1494c.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* renamed from: i  reason: collision with root package name */
        private static final C1494c f5839i = C1494c.d("user");

        /* renamed from: j  reason: collision with root package name */
        private static final C1494c f5840j = C1494c.d("os");

        /* renamed from: k  reason: collision with root package name */
        private static final C1494c f5841k = C1494c.d("device");

        /* renamed from: l  reason: collision with root package name */
        private static final C1494c f5842l = C1494c.d("events");

        /* renamed from: m  reason: collision with root package name */
        private static final C1494c f5843m = C1494c.d("generatorType");

        private j() {
        }

        /* renamed from: b */
        public void a(F.e eVar, C1496e eVar2) {
            eVar2.a(f5832b, eVar.g());
            eVar2.a(f5833c, eVar.j());
            eVar2.a(f5834d, eVar.c());
            eVar2.c(f5835e, eVar.l());
            eVar2.a(f5836f, eVar.e());
            eVar2.g(f5837g, eVar.n());
            eVar2.a(f5838h, eVar.b());
            eVar2.a(f5839i, eVar.m());
            eVar2.a(f5840j, eVar.k());
            eVar2.a(f5841k, eVar.d());
            eVar2.a(f5842l, eVar.f());
            eVar2.d(f5843m, eVar.h());
        }
    }

    /* renamed from: B0.a$k */
    private static final class k implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final k f5844a = new k();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5845b = C1494c.d("execution");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5846c = C1494c.d("customAttributes");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5847d = C1494c.d("internalKeys");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5848e = C1494c.d("background");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5849f = C1494c.d("currentProcessDetails");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5850g = C1494c.d("appProcessDetails");

        /* renamed from: h  reason: collision with root package name */
        private static final C1494c f5851h = C1494c.d("uiOrientation");

        private k() {
        }

        /* renamed from: b */
        public void a(F.e.d.a aVar, C1496e eVar) {
            eVar.a(f5845b, aVar.f());
            eVar.a(f5846c, aVar.e());
            eVar.a(f5847d, aVar.g());
            eVar.a(f5848e, aVar.c());
            eVar.a(f5849f, aVar.d());
            eVar.a(f5850g, aVar.b());
            eVar.d(f5851h, aVar.h());
        }
    }

    /* renamed from: B0.a$l */
    private static final class l implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final l f5852a = new l();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5853b = C1494c.d("baseAddress");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5854c = C1494c.d("size");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5855d = C1494c.d(RewardPlus.NAME);

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5856e = C1494c.d("uuid");

        private l() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0063a aVar, C1496e eVar) {
            eVar.c(f5853b, aVar.b());
            eVar.c(f5854c, aVar.d());
            eVar.a(f5855d, aVar.c());
            eVar.a(f5856e, aVar.f());
        }
    }

    /* renamed from: B0.a$m */
    private static final class m implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final m f5857a = new m();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5858b = C1494c.d("threads");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5859c = C1494c.d("exception");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5860d = C1494c.d("appExitInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5861e = C1494c.d("signal");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5862f = C1494c.d("binaries");

        private m() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b bVar, C1496e eVar) {
            eVar.a(f5858b, bVar.f());
            eVar.a(f5859c, bVar.d());
            eVar.a(f5860d, bVar.b());
            eVar.a(f5861e, bVar.e());
            eVar.a(f5862f, bVar.c());
        }
    }

    /* renamed from: B0.a$n */
    private static final class n implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final n f5863a = new n();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5864b = C1494c.d("type");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5865c = C1494c.d("reason");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5866d = C1494c.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5867e = C1494c.d("causedBy");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5868f = C1494c.d("overflowCount");

        private n() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.c cVar, C1496e eVar) {
            eVar.a(f5864b, cVar.f());
            eVar.a(f5865c, cVar.e());
            eVar.a(f5866d, cVar.c());
            eVar.a(f5867e, cVar.b());
            eVar.d(f5868f, cVar.d());
        }
    }

    /* renamed from: B0.a$o */
    private static final class o implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final o f5869a = new o();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5870b = C1494c.d(RewardPlus.NAME);

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5871c = C1494c.d("code");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5872d = C1494c.d("address");

        private o() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0067d dVar, C1496e eVar) {
            eVar.a(f5870b, dVar.d());
            eVar.a(f5871c, dVar.c());
            eVar.c(f5872d, dVar.b());
        }
    }

    /* renamed from: B0.a$p */
    private static final class p implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final p f5873a = new p();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5874b = C1494c.d(RewardPlus.NAME);

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5875c = C1494c.d("importance");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5876d = C1494c.d(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);

        private p() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0069e eVar, C1496e eVar2) {
            eVar2.a(f5874b, eVar.d());
            eVar2.d(f5875c, eVar.c());
            eVar2.a(f5876d, eVar.b());
        }
    }

    /* renamed from: B0.a$q */
    private static final class q implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final q f5877a = new q();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5878b = C1494c.d("pc");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5879c = C1494c.d("symbol");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5880d = C1494c.d("file");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5881e = C1494c.d(TypedValues.CycleType.S_WAVE_OFFSET);

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5882f = C1494c.d("importance");

        private q() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.b.C0069e.C0071b bVar, C1496e eVar) {
            eVar.c(f5878b, bVar.e());
            eVar.a(f5879c, bVar.f());
            eVar.a(f5880d, bVar.b());
            eVar.c(f5881e, bVar.d());
            eVar.d(f5882f, bVar.c());
        }
    }

    /* renamed from: B0.a$r */
    private static final class r implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final r f5883a = new r();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5884b = C1494c.d("processName");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5885c = C1494c.d("pid");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5886d = C1494c.d("importance");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5887e = C1494c.d("defaultProcess");

        private r() {
        }

        /* renamed from: b */
        public void a(F.e.d.a.c cVar, C1496e eVar) {
            eVar.a(f5884b, cVar.d());
            eVar.d(f5885c, cVar.c());
            eVar.d(f5886d, cVar.b());
            eVar.g(f5887e, cVar.e());
        }
    }

    /* renamed from: B0.a$s */
    private static final class s implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final s f5888a = new s();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5889b = C1494c.d("batteryLevel");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5890c = C1494c.d("batteryVelocity");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5891d = C1494c.d("proximityOn");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5892e = C1494c.d("orientation");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5893f = C1494c.d("ramUsed");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5894g = C1494c.d("diskUsed");

        private s() {
        }

        /* renamed from: b */
        public void a(F.e.d.c cVar, C1496e eVar) {
            eVar.a(f5889b, cVar.b());
            eVar.d(f5890c, cVar.c());
            eVar.g(f5891d, cVar.g());
            eVar.d(f5892e, cVar.e());
            eVar.c(f5893f, cVar.f());
            eVar.c(f5894g, cVar.d());
        }
    }

    /* renamed from: B0.a$t */
    private static final class t implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final t f5895a = new t();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5896b = C1494c.d(CampaignEx.JSON_KEY_TIMESTAMP);

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5897c = C1494c.d("type");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5898d = C1494c.d(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5899e = C1494c.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final C1494c f5900f = C1494c.d("log");

        /* renamed from: g  reason: collision with root package name */
        private static final C1494c f5901g = C1494c.d("rollouts");

        private t() {
        }

        /* renamed from: b */
        public void a(F.e.d dVar, C1496e eVar) {
            eVar.c(f5896b, dVar.f());
            eVar.a(f5897c, dVar.g());
            eVar.a(f5898d, dVar.b());
            eVar.a(f5899e, dVar.c());
            eVar.a(f5900f, dVar.d());
            eVar.a(f5901g, dVar.e());
        }
    }

    /* renamed from: B0.a$u */
    private static final class u implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final u f5902a = new u();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5903b = C1494c.d("content");

        private u() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0074d dVar, C1496e eVar) {
            eVar.a(f5903b, dVar.b());
        }
    }

    /* renamed from: B0.a$v */
    private static final class v implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final v f5904a = new v();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5905b = C1494c.d("rolloutVariant");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5906c = C1494c.d("parameterKey");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5907d = C1494c.d("parameterValue");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5908e = C1494c.d("templateVersion");

        private v() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0075e eVar, C1496e eVar2) {
            eVar2.a(f5905b, eVar.d());
            eVar2.a(f5906c, eVar.b());
            eVar2.a(f5907d, eVar.c());
            eVar2.c(f5908e, eVar.e());
        }
    }

    /* renamed from: B0.a$w */
    private static final class w implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final w f5909a = new w();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5910b = C1494c.d("rolloutId");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5911c = C1494c.d("variantId");

        private w() {
        }

        /* renamed from: b */
        public void a(F.e.d.C0075e.b bVar, C1496e eVar) {
            eVar.a(f5910b, bVar.b());
            eVar.a(f5911c, bVar.c());
        }
    }

    /* renamed from: B0.a$x */
    private static final class x implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final x f5912a = new x();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5913b = C1494c.d("assignments");

        private x() {
        }

        /* renamed from: b */
        public void a(F.e.d.f fVar, C1496e eVar) {
            eVar.a(f5913b, fVar.b());
        }
    }

    /* renamed from: B0.a$y */
    private static final class y implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final y f5914a = new y();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5915b = C1494c.d("platform");

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f5916c = C1494c.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f5917d = C1494c.d("buildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f5918e = C1494c.d("jailbroken");

        private y() {
        }

        /* renamed from: b */
        public void a(F.e.C0076e eVar, C1496e eVar2) {
            eVar2.d(f5915b, eVar.c());
            eVar2.a(f5916c, eVar.d());
            eVar2.a(f5917d, eVar.b());
            eVar2.g(f5918e, eVar.e());
        }
    }

    /* renamed from: B0.a$z */
    private static final class z implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final z f5919a = new z();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f5920b = C1494c.d("identifier");

        private z() {
        }

        /* renamed from: b */
        public void a(F.e.f fVar, C1496e eVar) {
            eVar.a(f5920b, fVar.b());
        }
    }

    private C1276a() {
    }

    public void a(L0.b bVar) {
        d dVar = d.f5792a;
        bVar.a(F.class, dVar);
        bVar.a(C1277b.class, dVar);
        j jVar = j.f5831a;
        bVar.a(F.e.class, jVar);
        bVar.a(h.class, jVar);
        g gVar = g.f5811a;
        bVar.a(F.e.a.class, gVar);
        bVar.a(i.class, gVar);
        h hVar = h.f5819a;
        bVar.a(F.e.a.b.class, hVar);
        bVar.a(j.class, hVar);
        z zVar = z.f5919a;
        bVar.a(F.e.f.class, zVar);
        bVar.a(C1271A.class, zVar);
        y yVar = y.f5914a;
        bVar.a(F.e.C0076e.class, yVar);
        bVar.a(z.class, yVar);
        i iVar = i.f5821a;
        bVar.a(F.e.c.class, iVar);
        bVar.a(k.class, iVar);
        t tVar = t.f5895a;
        bVar.a(F.e.d.class, tVar);
        bVar.a(l.class, tVar);
        k kVar = k.f5844a;
        bVar.a(F.e.d.a.class, kVar);
        bVar.a(m.class, kVar);
        m mVar = m.f5857a;
        bVar.a(F.e.d.a.b.class, mVar);
        bVar.a(n.class, mVar);
        p pVar = p.f5873a;
        bVar.a(F.e.d.a.b.C0069e.class, pVar);
        bVar.a(r.class, pVar);
        q qVar = q.f5877a;
        bVar.a(F.e.d.a.b.C0069e.C0071b.class, qVar);
        bVar.a(s.class, qVar);
        n nVar = n.f5863a;
        bVar.a(F.e.d.a.b.c.class, nVar);
        bVar.a(p.class, nVar);
        b bVar2 = b.f5779a;
        bVar.a(F.a.class, bVar2);
        bVar.a(C1278c.class, bVar2);
        C0077a aVar = C0077a.f5775a;
        bVar.a(F.a.C0059a.class, aVar);
        bVar.a(C1279d.class, aVar);
        o oVar = o.f5869a;
        bVar.a(F.e.d.a.b.C0067d.class, oVar);
        bVar.a(q.class, oVar);
        l lVar = l.f5852a;
        bVar.a(F.e.d.a.b.C0063a.class, lVar);
        bVar.a(o.class, lVar);
        c cVar = c.f5789a;
        bVar.a(F.c.class, cVar);
        bVar.a(C1280e.class, cVar);
        r rVar = r.f5883a;
        bVar.a(F.e.d.a.c.class, rVar);
        bVar.a(t.class, rVar);
        s sVar = s.f5888a;
        bVar.a(F.e.d.c.class, sVar);
        bVar.a(u.class, sVar);
        u uVar = u.f5902a;
        bVar.a(F.e.d.C0074d.class, uVar);
        bVar.a(v.class, uVar);
        x xVar = x.f5912a;
        bVar.a(F.e.d.f.class, xVar);
        bVar.a(y.class, xVar);
        v vVar = v.f5904a;
        bVar.a(F.e.d.C0075e.class, vVar);
        bVar.a(w.class, vVar);
        w wVar = w.f5909a;
        bVar.a(F.e.d.C0075e.b.class, wVar);
        bVar.a(x.class, wVar);
        e eVar = e.f5805a;
        bVar.a(F.d.class, eVar);
        bVar.a(C1281f.class, eVar);
        f fVar = f.f5808a;
        bVar.a(F.d.b.class, fVar);
        bVar.a(C1282g.class, fVar);
    }
}
