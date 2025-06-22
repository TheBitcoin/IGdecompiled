package androidx.room.util;

import S2.C1601o;
import S2.H;
import S2.N;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import b3.C1642b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.m;

public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        boolean z4;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (query.getColumnCount() <= 0) {
                Map<String, TableInfo.Column> g4 = H.g();
                C1642b.a(query, (Throwable) null);
                return g4;
            }
            int columnIndex = query.getColumnIndex(RewardPlus.NAME);
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("notnull");
            int columnIndex4 = query.getColumnIndex("pk");
            int columnIndex5 = query.getColumnIndex("dflt_value");
            Map c5 = H.c();
            while (query.moveToNext()) {
                String string = query.getString(columnIndex);
                String string2 = query.getString(columnIndex2);
                if (query.getInt(columnIndex3) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int i4 = query.getInt(columnIndex4);
                String string3 = query.getString(columnIndex5);
                m.d(string, RewardPlus.NAME);
                m.d(string2, "type");
                c5.put(string, new TableInfo.Column(string, string2, z4, i4, string3, 2));
            }
            Map<String, TableInfo.Column> b5 = H.b(c5);
            C1642b.a(query, (Throwable) null);
            return b5;
        } catch (Throwable th2) {
            C1642b.a(query, th);
            throw th2;
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(TypedValues.TransitionType.S_FROM);
        int columnIndex4 = cursor.getColumnIndex(TypedValues.TransitionType.S_TO);
        List c5 = C1601o.c();
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(columnIndex);
            int i5 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            m.d(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            m.d(string2, "cursor.getString(toColumnIndex)");
            c5.add(new TableInfo.ForeignKeyWithSequence(i4, i5, string, string2));
        }
        return C1601o.V(C1601o.a(c5));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Throwable th;
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("id");
            int columnIndex2 = query.getColumnIndex("seq");
            int columnIndex3 = query.getColumnIndex("table");
            int columnIndex4 = query.getColumnIndex("on_delete");
            int columnIndex5 = query.getColumnIndex("on_update");
            List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
            query.moveToPosition(-1);
            Set b5 = N.b();
            while (query.moveToNext()) {
                if (query.getInt(columnIndex2) == 0) {
                    int i4 = query.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object next : readForeignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) next).getId() == i4) {
                            arrayList3.add(next);
                        }
                    }
                    int size = arrayList3.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList3.get(i5);
                        i5++;
                        TableInfo.ForeignKeyWithSequence foreignKeyWithSequence = (TableInfo.ForeignKeyWithSequence) obj;
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = query.getString(columnIndex3);
                    m.d(string, "cursor.getString(tableColumnIndex)");
                    String string2 = query.getString(columnIndex4);
                    m.d(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = query.getString(columnIndex5);
                    m.d(string3, "cursor.getString(onUpdateColumnIndex)");
                    b5.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set<TableInfo.ForeignKey> a5 = N.a(b5);
            C1642b.a(query, (Throwable) null);
            return a5;
        } catch (Throwable th2) {
            C1642b.a(query, th);
            throw th2;
        }
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z4) {
        String str2;
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex(RewardPlus.NAME);
            int columnIndex4 = query.getColumnIndex(CampaignEx.JSON_KEY_DESC);
            if (!(columnIndex == -1 || columnIndex2 == -1 || columnIndex3 == -1)) {
                if (columnIndex4 != -1) {
                    TreeMap treeMap = new TreeMap();
                    TreeMap treeMap2 = new TreeMap();
                    while (query.moveToNext()) {
                        if (query.getInt(columnIndex2) >= 0) {
                            int i4 = query.getInt(columnIndex);
                            String string = query.getString(columnIndex3);
                            if (query.getInt(columnIndex4) > 0) {
                                str2 = "DESC";
                            } else {
                                str2 = "ASC";
                            }
                            Integer valueOf = Integer.valueOf(i4);
                            m.d(string, "columnName");
                            treeMap.put(valueOf, string);
                            treeMap2.put(Integer.valueOf(i4), str2);
                        }
                    }
                    Collection values = treeMap.values();
                    m.d(values, "columnsMap.values");
                    List Z4 = C1601o.Z(values);
                    Collection values2 = treeMap2.values();
                    m.d(values2, "ordersMap.values");
                    TableInfo.Index index = new TableInfo.Index(str, z4, Z4, C1601o.Z(values2));
                    C1642b.a(query, (Throwable) null);
                    return index;
                }
            }
            C1642b.a(query, (Throwable) null);
            return null;
        } catch (Throwable th) {
            C1642b.a(query, th);
            throw th;
        }
    }

    private static final Set<TableInfo.Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex(RewardPlus.NAME);
            int columnIndex2 = query.getColumnIndex(TtmlNode.ATTR_TTS_ORIGIN);
            int columnIndex3 = query.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    Set b5 = N.b();
                    while (query.moveToNext()) {
                        if (m.a("c", query.getString(columnIndex2))) {
                            String string = query.getString(columnIndex);
                            boolean z4 = true;
                            if (query.getInt(columnIndex3) != 1) {
                                z4 = false;
                            }
                            m.d(string, RewardPlus.NAME);
                            TableInfo.Index readIndex = readIndex(supportSQLiteDatabase, string, z4);
                            if (readIndex == null) {
                                C1642b.a(query, (Throwable) null);
                                return null;
                            }
                            b5.add(readIndex);
                        }
                    }
                    Set<TableInfo.Index> a5 = N.a(b5);
                    C1642b.a(query, (Throwable) null);
                    return a5;
                }
            }
            C1642b.a(query, (Throwable) null);
            return null;
        } catch (Throwable th) {
            C1642b.a(query, th);
            throw th;
        }
    }

    public static final TableInfo readTableInfo(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        m.e(supportSQLiteDatabase, "database");
        m.e(str, "tableName");
        return new TableInfo(str, readColumns(supportSQLiteDatabase, str), readForeignKeys(supportSQLiteDatabase, str), readIndices(supportSQLiteDatabase, str));
    }
}
