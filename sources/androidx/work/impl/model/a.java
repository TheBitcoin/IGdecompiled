package androidx.work.impl.model;

import kotlin.jvm.internal.m;

public abstract /* synthetic */ class a {
    public static SystemIdInfo a(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
        m.e(workGenerationalId, "id");
        return systemIdInfoDao.getSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }

    public static void b(SystemIdInfoDao systemIdInfoDao, WorkGenerationalId workGenerationalId) {
        m.e(workGenerationalId, "id");
        systemIdInfoDao.removeSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }
}
