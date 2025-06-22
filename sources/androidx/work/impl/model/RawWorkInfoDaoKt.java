package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;
import o3.G;
import r3.C1035e;

public final class RawWorkInfoDaoKt {
    public static final C1035e getWorkInfoPojosFlow(RawWorkInfoDao rawWorkInfoDao, G g4, SupportSQLiteQuery supportSQLiteQuery) {
        m.e(rawWorkInfoDao, "<this>");
        m.e(g4, "dispatcher");
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(supportSQLiteQuery), g4);
    }
}
