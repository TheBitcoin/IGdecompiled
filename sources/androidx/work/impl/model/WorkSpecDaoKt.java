package androidx.work.impl.model;

import S2.C1601o;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.UUID;
import kotlin.jvm.internal.m;
import o3.G;
import r3.C1035e;
import r3.C1037g;

public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final C1035e dedup(C1035e eVar, G g4) {
        m.e(eVar, "<this>");
        m.e(g4, "dispatcher");
        return C1037g.t(C1037g.k(new WorkSpecDaoKt$dedup$$inlined$map$1(eVar)), g4);
    }

    public static final C1035e getWorkStatusPojoFlowDataForIds(WorkSpecDao workSpecDao, UUID uuid) {
        m.e(workSpecDao, "<this>");
        m.e(uuid, "id");
        return C1037g.k(new WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1(workSpecDao.getWorkStatusPojoFlowDataForIds(C1601o.e(String.valueOf(uuid)))));
    }

    public static final C1035e getWorkStatusPojoFlowForName(WorkSpecDao workSpecDao, G g4, String str) {
        m.e(workSpecDao, "<this>");
        m.e(g4, "dispatcher");
        m.e(str, RewardPlus.NAME);
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(str), g4);
    }

    public static final C1035e getWorkStatusPojoFlowForTag(WorkSpecDao workSpecDao, G g4, String str) {
        m.e(workSpecDao, "<this>");
        m.e(g4, "dispatcher");
        m.e(str, "tag");
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(str), g4);
    }
}
