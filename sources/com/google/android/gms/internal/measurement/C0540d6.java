package com.google.android.gms.internal.measurement;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* renamed from: com.google.android.gms.internal.measurement.d6  reason: case insensitive filesystem */
public final class C0540d6 implements C0549e6 {

    /* renamed from: A  reason: collision with root package name */
    private static final C0591j3 f1808A;

    /* renamed from: B  reason: collision with root package name */
    private static final C0591j3 f1809B;

    /* renamed from: C  reason: collision with root package name */
    private static final C0591j3 f1810C;

    /* renamed from: D  reason: collision with root package name */
    private static final C0591j3 f1811D;

    /* renamed from: E  reason: collision with root package name */
    private static final C0591j3 f1812E;

    /* renamed from: F  reason: collision with root package name */
    private static final C0591j3 f1813F;

    /* renamed from: G  reason: collision with root package name */
    private static final C0591j3 f1814G;

    /* renamed from: H  reason: collision with root package name */
    private static final C0591j3 f1815H;

    /* renamed from: I  reason: collision with root package name */
    private static final C0591j3 f1816I;

    /* renamed from: J  reason: collision with root package name */
    private static final C0591j3 f1817J;

    /* renamed from: K  reason: collision with root package name */
    private static final C0591j3 f1818K;

    /* renamed from: L  reason: collision with root package name */
    private static final C0591j3 f1819L;

    /* renamed from: M  reason: collision with root package name */
    private static final C0591j3 f1820M;

    /* renamed from: N  reason: collision with root package name */
    private static final C0591j3 f1821N;

    /* renamed from: O  reason: collision with root package name */
    private static final C0591j3 f1822O;

    /* renamed from: P  reason: collision with root package name */
    private static final C0591j3 f1823P;

    /* renamed from: Q  reason: collision with root package name */
    private static final C0591j3 f1824Q;

    /* renamed from: R  reason: collision with root package name */
    private static final C0591j3 f1825R;

    /* renamed from: S  reason: collision with root package name */
    private static final C0591j3 f1826S;

    /* renamed from: T  reason: collision with root package name */
    private static final C0591j3 f1827T;

    /* renamed from: U  reason: collision with root package name */
    private static final C0591j3 f1828U;

    /* renamed from: V  reason: collision with root package name */
    private static final C0591j3 f1829V;

    /* renamed from: W  reason: collision with root package name */
    private static final C0591j3 f1830W;

    /* renamed from: X  reason: collision with root package name */
    private static final C0591j3 f1831X;

    /* renamed from: Y  reason: collision with root package name */
    private static final C0591j3 f1832Y;

    /* renamed from: Z  reason: collision with root package name */
    private static final C0591j3 f1833Z;

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1834a;

    /* renamed from: a0  reason: collision with root package name */
    private static final C0591j3 f1835a0;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1836b;

    /* renamed from: b0  reason: collision with root package name */
    private static final C0591j3 f1837b0;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f1838c;

    /* renamed from: c0  reason: collision with root package name */
    private static final C0591j3 f1839c0;

    /* renamed from: d  reason: collision with root package name */
    private static final C0591j3 f1840d;

    /* renamed from: d0  reason: collision with root package name */
    private static final C0591j3 f1841d0;

    /* renamed from: e  reason: collision with root package name */
    private static final C0591j3 f1842e;

    /* renamed from: e0  reason: collision with root package name */
    private static final C0591j3 f1843e0;

    /* renamed from: f  reason: collision with root package name */
    private static final C0591j3 f1844f;

    /* renamed from: g  reason: collision with root package name */
    private static final C0591j3 f1845g;

    /* renamed from: h  reason: collision with root package name */
    private static final C0591j3 f1846h;

    /* renamed from: i  reason: collision with root package name */
    private static final C0591j3 f1847i;

    /* renamed from: j  reason: collision with root package name */
    private static final C0591j3 f1848j;

    /* renamed from: k  reason: collision with root package name */
    private static final C0591j3 f1849k;

    /* renamed from: l  reason: collision with root package name */
    private static final C0591j3 f1850l;

    /* renamed from: m  reason: collision with root package name */
    private static final C0591j3 f1851m;

    /* renamed from: n  reason: collision with root package name */
    private static final C0591j3 f1852n;

    /* renamed from: o  reason: collision with root package name */
    private static final C0591j3 f1853o;

    /* renamed from: p  reason: collision with root package name */
    private static final C0591j3 f1854p;

    /* renamed from: q  reason: collision with root package name */
    private static final C0591j3 f1855q;

    /* renamed from: r  reason: collision with root package name */
    private static final C0591j3 f1856r;

    /* renamed from: s  reason: collision with root package name */
    private static final C0591j3 f1857s;

    /* renamed from: t  reason: collision with root package name */
    private static final C0591j3 f1858t;

    /* renamed from: u  reason: collision with root package name */
    private static final C0591j3 f1859u;

    /* renamed from: v  reason: collision with root package name */
    private static final C0591j3 f1860v;

    /* renamed from: w  reason: collision with root package name */
    private static final C0591j3 f1861w;

    /* renamed from: x  reason: collision with root package name */
    private static final C0591j3 f1862x;

    /* renamed from: y  reason: collision with root package name */
    private static final C0591j3 f1863y;

    /* renamed from: z  reason: collision with root package name */
    private static final C0591j3 f1864z;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1834a = e5.b("measurement.ad_id_cache_time", WorkRequest.MIN_BACKOFF_MILLIS);
        f1836b = e5.b("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000);
        f1838c = e5.d("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f1840d = e5.b("measurement.max_bundles_per_iteration", 100);
        f1842e = e5.b("measurement.config.cache_time", 86400000);
        e5.c("measurement.log_tag", "FA");
        f1844f = e5.c("measurement.config.url_authority", "app-measurement.com");
        f1845g = e5.c("measurement.config.url_scheme", "https");
        f1846h = e5.b("measurement.upload.debug_upload_interval", 1000);
        f1847i = e5.b("measurement.session.engagement_interval", 3600000);
        f1848j = e5.c("measurement.rb.attribution.event_params", "value|currency");
        e5.b("measurement.id.rb.attribution.app_allowlist", 0);
        f1849k = e5.b("measurement.upload.google_signal_max_queue_time", 605000);
        f1850l = e5.c("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        f1851m = e5.b("measurement.lifetimevalue.max_currency_tracked", 4);
        f1852n = e5.b("measurement.dma_consent.max_daily_dcu_realtime_events", 1);
        f1853o = e5.b("measurement.upload.max_event_parameter_value_length", 500);
        f1854p = e5.b("measurement.store.max_stored_events_per_app", 100000);
        f1855q = e5.b("measurement.experiment.max_ids", 50);
        f1856r = e5.b("measurement.audience.filter_result_max_count", 200);
        f1857s = e5.b("measurement.upload.max_item_scoped_custom_parameters", 27);
        f1858t = e5.b("measurement.rb.max_trigger_registrations_per_day", 0);
        f1859u = e5.b("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0);
        f1860v = e5.b("measurement.rb.attribution.client.min_ad_services_version", 7);
        f1861w = e5.b("measurement.alarm_manager.minimum_interval", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        f1862x = e5.b("measurement.upload.minimum_delay", 500);
        f1863y = e5.b("measurement.monitoring.sample_period_millis", 86400000);
        f1864z = e5.d("measurement.config.notify_trigger_uris_on_backgrounded", true);
        f1808A = e5.c("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword");
        f1809B = e5.b("measurement.upload.realtime_upload_interval", WorkRequest.MIN_BACKOFF_MILLIS);
        f1810C = e5.b("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        e5.b("measurement.config.cache_time.service", 3600000);
        f1811D = e5.b("measurement.service_client.idle_disconnect_millis", 5000);
        e5.c("measurement.log_tag.service", "FA-SVC");
        f1812E = e5.c("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa,com.booking,com.google.firebaseengage,com.mse.mseapp.dev,com.mse.mseapp,pl.eobuwie.eobuwieapp,br.com.eventim.mobile.app.Android,ch.ticketcorner.mobile.app.Android,de.eventim.mobile.app.Android,dk.billetlugen.mobile.app.Android,nl.eventim.mobile.app.Android,com.asos.app,com.blueshieldca.prod,dk.magnetix.tivoliapp,matas.matas.internal,nl.omoda,com.thetrainline,com.simo.androidtest,de.aboutyou.mobile.app,com.hometogo,de.casamundo.casamundomobile,it.casevacanz,eu.coolblue.shop,com.stihl.app,com.indeed.android.jobsearch,com.homeretailgroup.argos.android,com.dylvian.mango.activities.pre,se.nansen.coop.qa");
        f1813F = e5.b("measurement.upload.stale_data_deletion_interval", 86400000);
        f1814G = e5.c("measurement.rb.attribution.uri_authority", "google-analytics.com");
        f1815H = e5.b("measurement.rb.attribution.max_queue_time", 1209600000);
        f1816I = e5.c("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        f1817J = e5.c("measurement.rb.attribution.query_parameters_to_remove", "");
        f1818K = e5.c("measurement.rb.attribution.uri_scheme", "https");
        f1819L = e5.b("measurement.sdk.attribution.cache.ttl", 604800000);
        f1820M = e5.b("measurement.redaction.app_instance_id.ttl", 7200000);
        f1821N = e5.b("measurement.upload.backoff_period", 43200000);
        f1822O = e5.b("measurement.upload.initial_upload_delay_time", 15000);
        f1823P = e5.b("measurement.upload.interval", 3600000);
        f1824Q = e5.b("measurement.upload.max_bundle_size", 65536);
        f1825R = e5.b("measurement.upload.max_bundles", 100);
        f1826S = e5.b("measurement.upload.max_conversions_per_day", 500);
        f1827T = e5.b("measurement.upload.max_error_events_per_day", 1000);
        f1828U = e5.b("measurement.upload.max_events_per_bundle", 1000);
        f1829V = e5.b("measurement.upload.max_events_per_day", 100000);
        f1830W = e5.b("measurement.upload.max_public_events_per_day", 50000);
        f1831X = e5.b("measurement.upload.max_queue_time", 518400000);
        f1832Y = e5.b("measurement.upload.max_realtime_events_per_day", 10);
        f1833Z = e5.b("measurement.upload.max_batch_size", 65536);
        f1835a0 = e5.b("measurement.upload.retry_count", 6);
        f1837b0 = e5.b("measurement.upload.retry_time", 1800000);
        f1839c0 = e5.c("measurement.upload.url", "https://app-measurement.com/a");
        f1841d0 = e5.b("measurement.upload.window_interval", 3600000);
        f1843e0 = e5.c("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    public final long A() {
        return ((Long) f1834a.e()).longValue();
    }

    public final long B() {
        return ((Long) f1836b.e()).longValue();
    }

    public final long C() {
        return ((Long) f1842e.e()).longValue();
    }

    public final long D() {
        return ((Long) f1846h.e()).longValue();
    }

    public final long E() {
        return ((Long) f1847i.e()).longValue();
    }

    public final long F() {
        return ((Long) f1851m.e()).longValue();
    }

    public final String G() {
        return (String) f1808A.e();
    }

    public final long H() {
        return ((Long) f1858t.e()).longValue();
    }

    public final long I() {
        return ((Long) f1835a0.e()).longValue();
    }

    public final String J() {
        return (String) f1818K.e();
    }

    public final long K() {
        return ((Long) f1813F.e()).longValue();
    }

    public final long L() {
        return ((Long) f1825R.e()).longValue();
    }

    public final String M() {
        return (String) f1812E.e();
    }

    public final long N() {
        return ((Long) f1831X.e()).longValue();
    }

    public final long O() {
        return ((Long) f1822O.e()).longValue();
    }

    public final String P() {
        return (String) f1848j.e();
    }

    public final long Q() {
        return ((Long) f1809B.e()).longValue();
    }

    public final long R() {
        return ((Long) f1832Y.e()).longValue();
    }

    public final long S() {
        return ((Long) f1856r.e()).longValue();
    }

    public final long T() {
        return ((Long) f1810C.e()).longValue();
    }

    public final long U() {
        return ((Long) f1823P.e()).longValue();
    }

    public final String V() {
        return (String) f1850l.e();
    }

    public final long W() {
        return ((Long) f1820M.e()).longValue();
    }

    public final String X() {
        return (String) f1844f.e();
    }

    public final boolean Y() {
        return ((Boolean) f1838c.e()).booleanValue();
    }

    public final long Z() {
        return ((Long) f1862x.e()).longValue();
    }

    public final long a() {
        return ((Long) f1853o.e()).longValue();
    }

    public final long a0() {
        return ((Long) f1828U.e()).longValue();
    }

    public final long b() {
        return ((Long) f1840d.e()).longValue();
    }

    public final long b0() {
        return ((Long) f1830W.e()).longValue();
    }

    public final long c0() {
        return ((Long) f1821N.e()).longValue();
    }

    public final long d() {
        return ((Long) f1852n.e()).longValue();
    }

    public final String d0() {
        return (String) f1845g.e();
    }

    public final long e() {
        return ((Long) f1849k.e()).longValue();
    }

    public final boolean e0() {
        return ((Boolean) f1864z.e()).booleanValue();
    }

    public final long f() {
        return ((Long) f1855q.e()).longValue();
    }

    public final long f0() {
        return ((Long) f1863y.e()).longValue();
    }

    public final long g() {
        return ((Long) f1854p.e()).longValue();
    }

    public final long h() {
        return ((Long) f1859u.e()).longValue();
    }

    public final long i() {
        return ((Long) f1837b0.e()).longValue();
    }

    public final String j() {
        return (String) f1839c0.e();
    }

    public final long k() {
        return ((Long) f1815H.e()).longValue();
    }

    public final long l() {
        return ((Long) f1826S.e()).longValue();
    }

    public final String m() {
        return (String) f1814G.e();
    }

    public final String n() {
        return (String) f1817J.e();
    }

    public final long o() {
        return ((Long) f1860v.e()).longValue();
    }

    public final long p() {
        return ((Long) f1819L.e()).longValue();
    }

    public final long q() {
        return ((Long) f1841d0.e()).longValue();
    }

    public final String r() {
        return (String) f1843e0.e();
    }

    public final long s() {
        return ((Long) f1861w.e()).longValue();
    }

    public final long t() {
        return ((Long) f1827T.e()).longValue();
    }

    public final long u() {
        return ((Long) f1829V.e()).longValue();
    }

    public final String v() {
        return (String) f1816I.e();
    }

    public final long w() {
        return ((Long) f1857s.e()).longValue();
    }

    public final long x() {
        return ((Long) f1833Z.e()).longValue();
    }

    public final long y() {
        return ((Long) f1811D.e()).longValue();
    }

    public final long z() {
        return ((Long) f1824Q.e()).longValue();
    }
}
