package androidx.work.impl;

import S2.C1601o;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class StartStopTokens {
    private final Object lock = new Object();
    private final Map<WorkGenerationalId, StartStopToken> runs = new LinkedHashMap();

    public final boolean contains(WorkGenerationalId workGenerationalId) {
        boolean containsKey;
        m.e(workGenerationalId, "id");
        synchronized (this.lock) {
            containsKey = this.runs.containsKey(workGenerationalId);
        }
        return containsKey;
    }

    public final StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken remove;
        m.e(workGenerationalId, "id");
        synchronized (this.lock) {
            remove = this.runs.remove(workGenerationalId);
        }
        return remove;
    }

    public final StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        m.e(workGenerationalId, "id");
        synchronized (this.lock) {
            try {
                Map<WorkGenerationalId, StartStopToken> map = this.runs;
                StartStopToken startStopToken2 = map.get(workGenerationalId);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(workGenerationalId);
                    map.put(workGenerationalId, startStopToken2);
                }
                startStopToken = startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final List<StartStopToken> remove(String str) {
        List<StartStopToken> Z4;
        m.e(str, "workSpecId");
        synchronized (this.lock) {
            try {
                Map<WorkGenerationalId, StartStopToken> map = this.runs;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry next : map.entrySet()) {
                    if (m.a(((WorkGenerationalId) next.getKey()).getWorkSpecId(), str)) {
                        linkedHashMap.put(next.getKey(), next.getValue());
                    }
                }
                for (WorkGenerationalId remove : linkedHashMap.keySet()) {
                    this.runs.remove(remove);
                }
                Z4 = C1601o.Z(linkedHashMap.values());
            } finally {
            }
        }
        return Z4;
    }

    public final StartStopToken tokenFor(WorkSpec workSpec) {
        m.e(workSpec, "spec");
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    public final StartStopToken remove(WorkSpec workSpec) {
        m.e(workSpec, "spec");
        return remove(WorkSpecKt.generationalId(workSpec));
    }
}
