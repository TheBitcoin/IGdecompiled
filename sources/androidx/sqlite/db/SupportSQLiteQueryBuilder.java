package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = new Companion((C2103g) null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final SupportSQLiteQueryBuilder builder(String str) {
            m.e(str, "tableName");
            return new SupportSQLiteQueryBuilder(str, (C2103g) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, C2103g gVar) {
        this(str);
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr[i4];
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static final SupportSQLiteQueryBuilder builder(String str) {
        return Companion.builder(str);
    }

    public final SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.columns = strArr;
        return this;
    }

    public final SupportSQLiteQuery create() {
        String str;
        String str2 = this.groupBy;
        if ((str2 != null && str2.length() != 0) || (str = this.having) == null || str.length() == 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.distinct) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.columns;
            if (strArr == null || strArr.length == 0) {
                sb.append("* ");
            } else {
                m.b(strArr);
                appendColumns(sb, strArr);
            }
            sb.append("FROM ");
            sb.append(this.table);
            appendClause(sb, " WHERE ", this.selection);
            appendClause(sb, " GROUP BY ", this.groupBy);
            appendClause(sb, " HAVING ", this.having);
            appendClause(sb, " ORDER BY ", this.orderBy);
            appendClause(sb, " LIMIT ", this.limit);
            String sb2 = sb.toString();
            m.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
            return new SimpleSQLiteQuery(sb2, this.bindArgs);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String str) {
        this.groupBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String str) {
        this.having = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String str) {
        m.e(str, "limit");
        boolean matches = limitPattern.matcher(str).matches();
        if (str.length() != 0 && !matches) {
            throw new IllegalArgumentException(("invalid LIMIT clauses:" + str).toString());
        }
        this.limit = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder orderBy(String str) {
        this.orderBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }
}
