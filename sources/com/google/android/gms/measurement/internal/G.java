package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C0600k3;
import com.google.android.gms.internal.measurement.U2;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.C0916e;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class G {

    /* renamed from: A  reason: collision with root package name */
    public static final C0737b2 f2404A = F("measurement.upload.stale_data_deletion_interval", 86400000L, new F0());

    /* renamed from: A0  reason: collision with root package name */
    public static final C0737b2 f2405A0;

    /* renamed from: B  reason: collision with root package name */
    public static final C0737b2 f2406B = F("measurement.upload.refresh_blacklisted_config_interval", 604800000L, new I0());

    /* renamed from: B0  reason: collision with root package name */
    public static final C0737b2 f2407B0 = b("measurement.sgtm.app_allowlist", "de.zalando.mobile.internal,de.zalando.mobile.internal.debug,de.zalando.lounge.dev,grit.storytel.app,com.rbc.mobile.android,com.rbc.mobile.android,com.dylvian.mango.activities,com.home24.android,com.home24.android.staging,se.lf.mobile.android,se.lf.mobile.android.beta,se.lf.mobile.android.rc,se.lf.mobile.android.test,se.lf.mobile.android.test.debug,com.boots.flagship.android,com.boots.flagshiproi.android,de.zalando.mobile,com.trivago,com.getyourguide.android,es.mobail.meliarewards,se.nansen.coop.debug,se.nansen.coop,se.coop.coop.qa,com.booking,com.google.firebaseengage,com.mse.mseapp.dev,com.mse.mseapp,pl.eobuwie.eobuwieapp,br.com.eventim.mobile.app.Android,ch.ticketcorner.mobile.app.Android,de.eventim.mobile.app.Android,dk.billetlugen.mobile.app.Android,nl.eventim.mobile.app.Android,com.asos.app,com.blueshieldca.prod,dk.magnetix.tivoliapp,matas.matas.internal,nl.omoda,com.thetrainline,com.simo.androidtest,de.aboutyou.mobile.app,com.hometogo,de.casamundo.casamundomobile,it.casevacanz,eu.coolblue.shop,com.stihl.app,com.indeed.android.jobsearch,com.homeretailgroup.argos.android,com.dylvian.mango.activities.pre,se.nansen.coop.qa", new R1());

    /* renamed from: C  reason: collision with root package name */
    public static final C0737b2 f2408C = F("measurement.upload.initial_upload_delay_time", 15000L, new H0());

    /* renamed from: C0  reason: collision with root package name */
    public static final C0737b2 f2409C0;

    /* renamed from: D  reason: collision with root package name */
    public static final C0737b2 f2410D = F("measurement.upload.retry_time", 1800000L, new K0());

    /* renamed from: D0  reason: collision with root package name */
    public static final C0737b2 f2411D0;

    /* renamed from: E  reason: collision with root package name */
    public static final C0737b2 f2412E = F("measurement.upload.retry_count", 6, new M0());

    /* renamed from: E0  reason: collision with root package name */
    public static final C0737b2 f2413E0;

    /* renamed from: F  reason: collision with root package name */
    public static final C0737b2 f2414F = F("measurement.upload.max_queue_time", 518400000L, new O0());

    /* renamed from: F0  reason: collision with root package name */
    public static final C0737b2 f2415F0;

    /* renamed from: G  reason: collision with root package name */
    public static final C0737b2 f2416G = F("measurement.upload.google_signal_max_queue_time", Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS), new N0());

    /* renamed from: G0  reason: collision with root package name */
    public static final C0737b2 f2417G0;

    /* renamed from: H  reason: collision with root package name */
    public static final C0737b2 f2418H = F("measurement.lifetimevalue.max_currency_tracked", 4, new Q0());

    /* renamed from: H0  reason: collision with root package name */
    public static final C0737b2 f2419H0;

    /* renamed from: I  reason: collision with root package name */
    public static final C0737b2 f2420I = F("measurement.audience.filter_result_max_count", 200, new P0());

    /* renamed from: I0  reason: collision with root package name */
    public static final C0737b2 f2421I0;

    /* renamed from: J  reason: collision with root package name */
    public static final C0737b2 f2422J = a("measurement.upload.max_public_user_properties", 100);

    /* renamed from: J0  reason: collision with root package name */
    public static final C0737b2 f2423J0;

    /* renamed from: K  reason: collision with root package name */
    public static final C0737b2 f2424K = a("measurement.upload.max_event_name_cardinality", 2000);

    /* renamed from: K0  reason: collision with root package name */
    public static final C0737b2 f2425K0;

    /* renamed from: L  reason: collision with root package name */
    public static final C0737b2 f2426L = a("measurement.upload.max_public_event_params", 100);

    /* renamed from: L0  reason: collision with root package name */
    public static final C0737b2 f2427L0;

    /* renamed from: M  reason: collision with root package name */
    public static final C0737b2 f2428M = F("measurement.service_client.idle_disconnect_millis", 5000L, new S0());

    /* renamed from: M0  reason: collision with root package name */
    public static final C0737b2 f2429M0;

    /* renamed from: N  reason: collision with root package name */
    public static final C0737b2 f2430N;

    /* renamed from: N0  reason: collision with root package name */
    public static final C0737b2 f2431N0;

    /* renamed from: O  reason: collision with root package name */
    public static final C0737b2 f2432O = F("measurement.test.string_flag", "---", new U0());

    /* renamed from: O0  reason: collision with root package name */
    public static final C0737b2 f2433O0;

    /* renamed from: P  reason: collision with root package name */
    public static final C0737b2 f2434P = F("measurement.test.long_flag", -1L, new T0());

    /* renamed from: P0  reason: collision with root package name */
    public static final C0737b2 f2435P0;

    /* renamed from: Q  reason: collision with root package name */
    public static final C0737b2 f2436Q = F("measurement.test.int_flag", -2, new Y0());

    /* renamed from: Q0  reason: collision with root package name */
    public static final C0737b2 f2437Q0;

    /* renamed from: R  reason: collision with root package name */
    public static final C0737b2 f2438R = F("measurement.test.double_flag", Double.valueOf(-3.0d), new C0736b1());

    /* renamed from: R0  reason: collision with root package name */
    public static final C0737b2 f2439R0;

    /* renamed from: S  reason: collision with root package name */
    public static final C0737b2 f2440S = F("measurement.experiment.max_ids", 50, new Z0());

    /* renamed from: S0  reason: collision with root package name */
    public static final C0737b2 f2441S0;

    /* renamed from: T  reason: collision with root package name */
    public static final C0737b2 f2442T = F("measurement.upload.max_item_scoped_custom_parameters", 27, new C0750d1());

    /* renamed from: T0  reason: collision with root package name */
    public static final C0737b2 f2443T0;

    /* renamed from: U  reason: collision with root package name */
    public static final C0737b2 f2444U = b("measurement.upload.max_event_parameter_value_length", 500, new C0743c1());

    /* renamed from: U0  reason: collision with root package name */
    public static final C0737b2 f2445U0;

    /* renamed from: V  reason: collision with root package name */
    public static final C0737b2 f2446V = F("measurement.max_bundles_per_iteration", 100, new C0764f1());

    /* renamed from: V0  reason: collision with root package name */
    public static final C0737b2 f2447V0;

    /* renamed from: W  reason: collision with root package name */
    public static final C0737b2 f2448W = F("measurement.sdk.attribution.cache.ttl", 604800000L, new C0757e1());

    /* renamed from: W0  reason: collision with root package name */
    public static final C0737b2 f2449W0;

    /* renamed from: X  reason: collision with root package name */
    public static final C0737b2 f2450X = F("measurement.redaction.app_instance_id.ttl", 7200000L, new C0778h1());

    /* renamed from: X0  reason: collision with root package name */
    public static final C0737b2 f2451X0;

    /* renamed from: Y  reason: collision with root package name */
    public static final C0737b2 f2452Y = F("measurement.rb.attribution.client.min_ad_services_version", 7, new C0792j1());

    /* renamed from: Y0  reason: collision with root package name */
    public static final C0737b2 f2453Y0;

    /* renamed from: Z  reason: collision with root package name */
    public static final C0737b2 f2454Z = F("measurement.dma_consent.max_daily_dcu_realtime_events", 1, new C0785i1());

    /* renamed from: Z0  reason: collision with root package name */
    public static final C0737b2 f2455Z0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List f2456a = DesugarCollections.synchronizedList(new ArrayList());

    /* renamed from: a0  reason: collision with root package name */
    public static final C0737b2 f2457a0 = F("measurement.rb.attribution.uri_scheme", "https", new C0806l1());

    /* renamed from: a1  reason: collision with root package name */
    public static final C0737b2 f2458a1;

    /* renamed from: b  reason: collision with root package name */
    public static final C0737b2 f2459b;

    /* renamed from: b0  reason: collision with root package name */
    public static final C0737b2 f2460b0 = F("measurement.rb.attribution.uri_authority", "google-analytics.com", new C0820n1());

    /* renamed from: b1  reason: collision with root package name */
    public static final C0737b2 f2461b1;

    /* renamed from: c  reason: collision with root package name */
    public static final C0737b2 f2462c = F("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, new C0895y0());

    /* renamed from: c0  reason: collision with root package name */
    public static final C0737b2 f2463c0 = F("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", new C0813m1());

    /* renamed from: c1  reason: collision with root package name */
    public static final C0737b2 f2464c1;

    /* renamed from: d  reason: collision with root package name */
    public static final C0737b2 f2465d = F("measurement.monitoring.sample_period_millis", 86400000L, new L0());

    /* renamed from: d0  reason: collision with root package name */
    public static final C0737b2 f2466d0 = F("measurement.session.engagement_interval", 3600000L, new C0834p1());

    /* renamed from: d1  reason: collision with root package name */
    public static final C0737b2 f2467d1;

    /* renamed from: e  reason: collision with root package name */
    public static final C0737b2 f2468e = c("measurement.config.cache_time", 86400000L, 3600000L, new X0(), false);

    /* renamed from: e0  reason: collision with root package name */
    public static final C0737b2 f2469e0 = F("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword", new C0827o1());

    /* renamed from: e1  reason: collision with root package name */
    public static final C0737b2 f2470e1;

    /* renamed from: f  reason: collision with root package name */
    public static final C0737b2 f2471f = F("measurement.config.url_scheme", "https", new C0799k1());

    /* renamed from: f0  reason: collision with root package name */
    public static final C0737b2 f2472f0 = F("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", new C0847r1());

    /* renamed from: f1  reason: collision with root package name */
    public static final C0737b2 f2473f1;

    /* renamed from: g  reason: collision with root package name */
    public static final C0737b2 f2474g = F("measurement.config.url_authority", "app-measurement.com", new C0882w1());

    /* renamed from: g0  reason: collision with root package name */
    public static final C0737b2 f2475g0 = F("measurement.rb.attribution.event_params", "value|currency", new C0841q1());

    /* renamed from: g1  reason: collision with root package name */
    public static final C0737b2 f2476g1;

    /* renamed from: h  reason: collision with root package name */
    public static final C0737b2 f2477h = F("measurement.upload.max_bundles", 100, new J1());

    /* renamed from: h0  reason: collision with root package name */
    public static final C0737b2 f2478h0 = F("measurement.rb.attribution.query_parameters_to_remove", "", new C0854s1());

    /* renamed from: h1  reason: collision with root package name */
    public static final C0737b2 f2479h1;

    /* renamed from: i  reason: collision with root package name */
    public static final C0737b2 f2480i = F("measurement.upload.max_batch_size", 65536, new V1());

    /* renamed from: i0  reason: collision with root package name */
    public static final C0737b2 f2481i0 = F("measurement.rb.attribution.max_queue_time", 1209600000L, new C0875v1());

    /* renamed from: i1  reason: collision with root package name */
    public static final C0737b2 f2482i1;

    /* renamed from: j  reason: collision with root package name */
    public static final C0737b2 f2483j = F("measurement.upload.max_bundle_size", 65536, new S());

    /* renamed from: j0  reason: collision with root package name */
    public static final C0737b2 f2484j0 = F("measurement.rb.max_trigger_registrations_per_day", 0, new C0889x1());

    /* renamed from: j1  reason: collision with root package name */
    public static final C0737b2 f2485j1;

    /* renamed from: k  reason: collision with root package name */
    public static final C0737b2 f2486k = F("measurement.upload.max_events_per_bundle", 1000, new C0763f0());

    /* renamed from: k0  reason: collision with root package name */
    public static final C0737b2 f2487k0;

    /* renamed from: k1  reason: collision with root package name */
    public static final C0737b2 f2488k1;

    /* renamed from: l  reason: collision with root package name */
    public static final C0737b2 f2489l;

    /* renamed from: l0  reason: collision with root package name */
    public static final C0737b2 f2490l0;

    /* renamed from: l1  reason: collision with root package name */
    public static final C0737b2 f2491l1;

    /* renamed from: m  reason: collision with root package name */
    public static final C0737b2 f2492m = F("measurement.upload.max_error_events_per_day", 1000, new C0826o0());

    /* renamed from: m0  reason: collision with root package name */
    public static final C0737b2 f2493m0;

    /* renamed from: m1  reason: collision with root package name */
    public static final C0737b2 f2494m1;

    /* renamed from: n  reason: collision with root package name */
    public static final C0737b2 f2495n = F("measurement.upload.max_public_events_per_day", Integer.valueOf(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS), new C0846r0());

    /* renamed from: n0  reason: collision with root package name */
    public static final C0737b2 f2496n0;

    /* renamed from: o  reason: collision with root package name */
    public static final C0737b2 f2497o = F("measurement.upload.max_conversions_per_day", 10000, new C0840q0());

    /* renamed from: o0  reason: collision with root package name */
    public static final C0737b2 f2498o0;

    /* renamed from: p  reason: collision with root package name */
    public static final C0737b2 f2499p = F("measurement.upload.max_realtime_events_per_day", 10, new C0860t0());

    /* renamed from: p0  reason: collision with root package name */
    public static final C0737b2 f2500p0;

    /* renamed from: q  reason: collision with root package name */
    public static final C0737b2 f2501q;

    /* renamed from: q0  reason: collision with root package name */
    public static final C0737b2 f2502q0;

    /* renamed from: r  reason: collision with root package name */
    public static final C0737b2 f2503r = F("measurement.upload.url", "https://app-measurement.com/a", new C0874v0());

    /* renamed from: r0  reason: collision with root package name */
    public static final C0737b2 f2504r0;

    /* renamed from: s  reason: collision with root package name */
    public static final C0737b2 f2505s = F("measurement.sgtm.google_signal.url", "https://app-measurement.com/s", new C0867u0());

    /* renamed from: s0  reason: collision with root package name */
    public static final C0737b2 f2506s0;

    /* renamed from: t  reason: collision with root package name */
    public static final C0737b2 f2507t = F("measurement.upload.backoff_period", 43200000L, new C0888x0());

    /* renamed from: t0  reason: collision with root package name */
    public static final C0737b2 f2508t0;

    /* renamed from: u  reason: collision with root package name */
    public static final C0737b2 f2509u = F("measurement.upload.window_interval", 3600000L, new C0881w0());

    /* renamed from: u0  reason: collision with root package name */
    public static final C0737b2 f2510u0 = F("measurement.service.storage_consent_support_version", 203600, new K1());

    /* renamed from: v  reason: collision with root package name */
    public static final C0737b2 f2511v = F("measurement.upload.interval", 3600000L, new C0());

    /* renamed from: v0  reason: collision with root package name */
    public static final C0737b2 f2512v0;

    /* renamed from: w  reason: collision with root package name */
    public static final C0737b2 f2513w;

    /* renamed from: w0  reason: collision with root package name */
    public static final C0737b2 f2514w0;

    /* renamed from: x  reason: collision with root package name */
    public static final C0737b2 f2515x = F("measurement.upload.debug_upload_interval", 1000L, new E0());

    /* renamed from: x0  reason: collision with root package name */
    public static final C0737b2 f2516x0;

    /* renamed from: y  reason: collision with root package name */
    public static final C0737b2 f2517y = F("measurement.upload.minimum_delay", 500L, new D0());

    /* renamed from: y0  reason: collision with root package name */
    public static final C0737b2 f2518y0;

    /* renamed from: z  reason: collision with root package name */
    public static final C0737b2 f2519z = F("measurement.alarm_manager.minimum_interval", Long.valueOf(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS), new G0());

    /* renamed from: z0  reason: collision with root package name */
    public static final C0737b2 f2520z0;

    static {
        DesugarCollections.synchronizedSet(new HashSet());
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        f2459b = F("measurement.ad_id_cache_time", valueOf, new H());
        Integer valueOf2 = Integer.valueOf(DefaultOggSeeker.MATCH_BYTE_RANGE);
        f2489l = F("measurement.upload.max_events_per_day", valueOf2, new C0756e0());
        f2501q = F("measurement.store.max_stored_events_per_app", valueOf2, new C0853s0());
        f2513w = F("measurement.upload.realtime_upload_interval", valueOf, new B0());
        Boolean bool = Boolean.FALSE;
        f2430N = F("measurement.test.boolean_flag", bool, new R0());
        b("measurement.test.cached_long_flag", -1L, new V0());
        F("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, new C0868u1());
        Boolean bool2 = Boolean.TRUE;
        f2487k0 = F("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, new C0903z1());
        f2490l0 = F("measurement.config.notify_trigger_uris_on_backgrounded", bool2, new C0896y1());
        f2493m0 = F("measurement.collection.log_event_and_bundle_v2", bool2, new C1());
        f2496n0 = a("measurement.quality.checksum", bool);
        f2498o0 = F("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, new A1());
        f2500p0 = F("measurement.audience.refresh_event_count_filters_timestamp", bool, new E1());
        f2502q0 = b("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, new G1());
        f2504r0 = F("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, new F1());
        f2506s0 = F("measurement.integration.disable_firebase_instance_id", bool, new I1());
        f2508t0 = F("measurement.collection.service.update_with_analytics_fix", bool, new H1());
        f2512v0 = F("measurement.service.store_null_safelist", bool2, new M1());
        f2514w0 = F("measurement.service.store_safelist", bool2, new L1());
        f2516x0 = F("measurement.session_stitching_token_enabled", bool, new O1());
        f2518y0 = b("measurement.sgtm.service", bool2, new N1());
        f2520z0 = b("measurement.sgtm.preview_mode_enabled", bool2, new P1());
        f2405A0 = b("measurement.sgtm.rollout_percentage_fix", bool, new S1());
        f2409C0 = F("measurement.sgtm.upload_queue", bool, new U1());
        f2411D0 = F("measurement.sgtm.google_signal.enable", bool, new T1());
        f2413E0 = F("measurement.gmscore_feature_tracking", bool2, new W1());
        f2415F0 = F("measurement.gmscore_client_telemetry", bool, new Y1());
        f2417G0 = F("measurement.gmscore_network_migration", bool, new X1());
        f2419H0 = b("measurement.fix_health_monitor_stack_trace", bool2, new C0730a2());
        f2421I0 = b("measurement.rb.attribution.service", bool2, new I());
        f2423J0 = b("measurement.rb.attribution.client2", bool2, new L());
        f2425K0 = F("measurement.rb.attribution.uuid_generation", bool2, new K());
        f2427L0 = F("measurement.rb.attribution.enable_trigger_redaction", bool2, new N());
        F("measurement.rb.attribution.followup1.service", bool, new M());
        f2429M0 = F("measurement.rb.attribution.retry_disposition", bool, new P());
        f2431N0 = F("measurement.rb.attribution.ad_campaign_info", bool, new O());
        f2433O0 = b("measurement.rb.attribution.improved_retry", bool2, new Q());
        f2435P0 = F("measurement.client.sessions.enable_fix_background_engagement", bool, new U());
        f2437Q0 = F("measurement.client.sessions.enable_pause_engagement_in_background", bool2, new W());
        f2439R0 = F("measurement.dma_consent.service_dcu_event2", bool2, new V());
        f2441S0 = F("measurement.dma_consent.services_database_update_fix", bool2, new Z());
        f2443T0 = F("measurement.dma_consent.setting_npa_inline_fix", bool2, new X());
        f2445U0 = b("measurement.gbraid_campaign.gbraid.client", bool2, new C0735b0());
        f2447V0 = b("measurement.gbraid_campaign.gbraid.service", bool2, new C0728a0());
        f2449W0 = F("measurement.service.consent.pfo_on_fx", bool2, new C0749d0());
        f2451X0 = F("measurement.service.consent.params_on_fx", bool2, new C0742c0());
        f2453Y0 = b("measurement.consent.stop_reset_on_storage_denied.client", bool2, new C0812m0());
        f2455Z0 = b("measurement.consent.stop_reset_on_storage_denied.service", bool2, new A0());
        f2458a1 = F("measurement.consent.scrub_audience_data_analytics_consent", bool2, new J0());
        f2461b1 = F("measurement.consent.fix_first_open_count_from_snapshot", bool2, new W0());
        f2464c1 = F("measurement.fix_engagement_on_reset_analytics_data", bool2, new C0771g1());
        f2467d1 = F("measurement.rb.attribution.service.bundle_on_backgrounded", bool2, new C0861t1());
        f2470e1 = F("measurement.rb.attribution.client.bundle_on_backgrounded", bool2, new D1());
        f2473f1 = F("measurement.set_default_event_parameters_propagate_clear.service.dev", bool, new Q1());
        f2476g1 = F("measurement.set_default_event_parameters_propagate_clear.client.dev", bool, new J());
        f2479h1 = F("measurement.set_default_event_parameters_with_backfill.service", bool, new T());
        F("measurement.set_default_event_parameters_with_backfill.client.dev", bool, new C0777h0());
        f2482i1 = F("measurement.defensively_copy_bundles_validate_default_params", bool2, new C0770g0());
        f2485j1 = F("measurement.fix_origin_in_upload_utils.service", bool2, new C0791j0());
        F("measurement.chimera.parameter.service", bool2, new C0784i0());
        f2488k1 = F("measurement.service.ad_impression.convert_value_to_double", bool2, new C0805l0());
        f2491l1 = F("measurement.persisted_config_defensive_copies", bool, new C0798k0());
        F("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, new C0819n0());
        f2494m1 = F("measurement.currency.escape_underscore_fix", bool2, new C0833p0());
    }

    private static C0737b2 F(String str, Object obj, Z1 z12) {
        return c(str, obj, obj, z12, false);
    }

    private static C0737b2 a(String str, Object obj) {
        return c(str, obj, obj, (Z1) null, false);
    }

    private static C0737b2 b(String str, Object obj, Z1 z12) {
        return c(str, obj, obj, z12, true);
    }

    private static C0737b2 c(String str, Object obj, Object obj2, Z1 z12, boolean z4) {
        C0737b2 b2Var = new C0737b2(str, obj, obj2, z12);
        if (z4) {
            f2456a.add(b2Var);
        }
        return b2Var;
    }

    public static Map e(Context context) {
        U2 a5 = U2.a(context.getContentResolver(), C0600k3.a("com.google.android.gms.measurement"), new C0916e());
        if (a5 == null) {
            return Collections.EMPTY_MAP;
        }
        return a5.b();
    }
}
