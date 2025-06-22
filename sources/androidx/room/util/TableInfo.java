package androidx.room.util;

import S2.N;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion((C2103g) null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            m.e(supportSQLiteDatabase, "database");
            m.e(str, "tableName");
            return TableInfoKt.readTableInfo(supportSQLiteDatabase, str);
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            m.e(str, "referenceTable");
            m.e(str2, "onDelete");
            m.e(str3, "onUpdate");
            m.e(list, "columnNames");
            m.e(list2, "referenceColumnNames");
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (m.a(this.referenceTable, foreignKey.referenceTable) && m.a(this.onDelete, foreignKey.onDelete) && m.a(this.onUpdate, foreignKey.onUpdate) && m.a(this.columnNames, foreignKey.columnNames)) {
                return m.a(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int i4, int i5, String str, String str2) {
            m.e(str, TypedValues.TransitionType.S_FROM);
            m.e(str2, TypedValues.TransitionType.S_TO);
            this.id = i4;
            this.sequence = i5;
            this.from = str;
            this.to = str2;
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }

        public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            m.e(foreignKeyWithSequence, "other");
            int i4 = this.id - foreignKeyWithSequence.id;
            return i4 == 0 ? this.sequence - foreignKeyWithSequence.sequence : i4;
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        m.e(str, RewardPlus.NAME);
        m.e(map, "columns");
        m.e(set, "foreignKeys");
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!m.a(this.name, tableInfo.name) || !m.a(this.columns, tableInfo.columns) || !m.a(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return m.a(set2, set);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i4, C2103g gVar) {
        this(str, map, set, (i4 & 8) != 0 ? null : set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, N.d());
        m.e(str, RewardPlus.NAME);
        m.e(map, "columns");
        m.e(set, "foreignKeys");
    }

    public static final class Column {
        public static final Companion Companion = new Companion((C2103g) null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < str.length()) {
                    char charAt = str.charAt(i4);
                    int i7 = i6 + 1;
                    if (i6 == 0 && charAt != '(') {
                        return false;
                    }
                    if (charAt == '(') {
                        i5++;
                    } else if (charAt == ')' && i5 - 1 == 0 && i6 != str.length() - 1) {
                        return false;
                    }
                    i4++;
                    i6 = i7;
                }
                if (i5 == 0) {
                    return true;
                }
                return false;
            }

            @VisibleForTesting
            @SuppressLint({"SyntheticAccessor"})
            public final boolean defaultValueEquals(String str, String str2) {
                m.e(str, "current");
                if (m.a(str, str2)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(str)) {
                    return false;
                }
                String substring = str.substring(1, str.length() - 1);
                m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return m.a(m3.m.u0(substring).toString(), str2);
            }

            private Companion() {
            }
        }

        public Column(String str, String str2, boolean z4, int i4, String str3, int i5) {
            m.e(str, RewardPlus.NAME);
            m.e(str2, "type");
            this.name = str;
            this.type = str2;
            this.notNull = z4;
            this.primaryKeyPosition = i4;
            this.defaultValue = str3;
            this.createdFrom = i5;
            this.affinity = findAffinity(str2);
        }

        @VisibleForTesting
        @SuppressLint({"SyntheticAccessor"})
        public static final boolean defaultValueEquals(String str, String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            m.d(locale, "US");
            String upperCase = str.toUpperCase(locale);
            m.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (m3.m.D(upperCase, "INT", false, 2, (Object) null)) {
                return 3;
            }
            if (m3.m.D(upperCase, "CHAR", false, 2, (Object) null) || m3.m.D(upperCase, "CLOB", false, 2, (Object) null) || m3.m.D(upperCase, "TEXT", false, 2, (Object) null)) {
                return 2;
            }
            if (m3.m.D(upperCase, "BLOB", false, 2, (Object) null)) {
                return 5;
            }
            if (m3.m.D(upperCase, "REAL", false, 2, (Object) null) || m3.m.D(upperCase, "FLOA", false, 2, (Object) null) || m3.m.D(upperCase, "DOUB", false, 2, (Object) null)) {
                return 4;
            }
            return 1;
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column) || this.primaryKeyPosition != ((Column) obj).primaryKeyPosition) {
                return false;
            }
            Column column = (Column) obj;
            if (!m.a(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2 && (str3 = this.defaultValue) != null && !Companion.defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && column.createdFrom == 1 && (str2 = column.defaultValue) != null && !Companion.defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i4 = this.createdFrom;
            if ((i4 == 0 || i4 != column.createdFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : Companion.defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int hashCode = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull) {
                i4 = 1231;
            } else {
                i4 = 1237;
            }
            return ((hashCode + i4) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Column(String str, String str2, boolean z4, int i4) {
            this(str, str2, z4, i4, (String) null, 0);
            m.e(str, RewardPlus.NAME);
            m.e(str2, "type");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final Companion Companion = new Companion((C2103g) null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            private Companion() {
            }
        }

        public Index(String str, boolean z4, List<String> list, List<String> list2) {
            m.e(str, RewardPlus.NAME);
            m.e(list, "columns");
            m.e(list2, "orders");
            this.name = str;
            this.unique = z4;
            this.columns = list;
            this.orders = list2;
            Collection collection = list2;
            boolean isEmpty = collection.isEmpty();
            ArrayList arrayList = collection;
            if (isEmpty) {
                int size = list.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList2.add(Index.Order.ASC.name());
                }
                arrayList = arrayList2;
            }
            this.orders = (List) arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !m.a(this.columns, index.columns) || !m.a(this.orders, index.orders)) {
                return false;
            }
            if (m3.m.y(this.name, DEFAULT_PREFIX, false, 2, (Object) null)) {
                return m3.m.y(index.name, DEFAULT_PREFIX, false, 2, (Object) null);
            }
            return m.a(this.name, index.name);
        }

        public int hashCode() {
            int i4;
            if (m3.m.y(this.name, DEFAULT_PREFIX, false, 2, (Object) null)) {
                i4 = -1184239155;
            } else {
                i4 = this.name.hashCode();
            }
            return (((((i4 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Index(java.lang.String r5, boolean r6, java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.m.e(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.m.e(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L_0x0014:
                if (r2 >= r0) goto L_0x0022
                androidx.room.Index$Order r3 = androidx.room.Index.Order.ASC
                java.lang.String r3 = r3.name()
                r1.add(r3)
                int r2 = r2 + 1
                goto L_0x0014
            L_0x0022:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }
}
