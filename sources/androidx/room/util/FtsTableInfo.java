package androidx.room.util;

import R2.s;
import S2.C1601o;
import S2.N;
import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import b3.C1642b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    public static final Companion Companion = new Companion((C2103g) null);
    /* access modifiers changed from: private */
    public static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Set b5 = N.b();
            Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                if (query.getColumnCount() > 0) {
                    int columnIndex = query.getColumnIndex(RewardPlus.NAME);
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndex);
                        m.d(string, "cursor.getString(nameIndex)");
                        b5.add(string);
                    }
                }
                s sVar = s.f8222a;
                C1642b.a(query, (Throwable) null);
                return N.a(b5);
            } catch (Throwable th) {
                C1642b.a(query, th);
                throw th;
            }
        }

        private final Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            String str2;
            Cursor query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndexOrThrow("sql"));
                } else {
                    str2 = "";
                }
                C1642b.a(query, (Throwable) null);
                m.d(str2, "sql");
                return parseOptions(str2);
            } catch (Throwable th) {
                C1642b.a(query, th);
                throw th;
            }
        }

        @VisibleForTesting
        public final Set<String> parseOptions(String str) {
            int i4;
            boolean z4;
            Character ch;
            m.e(str, "createStatement");
            if (str.length() == 0) {
                return N.d();
            }
            String str2 = str;
            String substring = str2.substring(m3.m.K(str2, '(', 0, false, 6, (Object) null) + 1, m3.m.Q(str2, ')', 0, false, 6, (Object) null));
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i5 = -1;
            int i6 = 0;
            int i7 = 0;
            while (i6 < substring.length()) {
                char charAt = substring.charAt(i6);
                int i8 = i7 + 1;
                if (charAt == '\'' || charAt == '\"' || charAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == charAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (charAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    }
                } else if (charAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (charAt == ',' && arrayDeque.isEmpty()) {
                    String substring2 = substring.substring(i5 + 1, i7);
                    m.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = substring2.length() - 1;
                    int i9 = 0;
                    boolean z5 = false;
                    while (i9 <= length) {
                        if (!z5) {
                            i4 = i9;
                        } else {
                            i4 = length;
                        }
                        if (m.g(substring2.charAt(i4), 32) <= 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z5) {
                            if (!z4) {
                                z5 = true;
                            } else {
                                i9++;
                            }
                        } else if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    arrayList.add(substring2.subSequence(i9, length + 1).toString());
                    i5 = i7;
                }
                i6++;
                i7 = i8;
            }
            String substring3 = substring.substring(i5 + 1);
            m.d(substring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(m3.m.u0(substring3).toString());
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                String str3 = (String) obj;
                String[] access$getFTS_OPTIONS$cp = FtsTableInfo.FTS_OPTIONS;
                int length2 = access$getFTS_OPTIONS$cp.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        break;
                    } else if (m3.m.y(str3, access$getFTS_OPTIONS$cp[i11], false, 2, (Object) null)) {
                        arrayList2.add(obj);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            return C1601o.d0(arrayList2);
        }

        @SuppressLint({"SyntheticAccessor"})
        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            m.e(supportSQLiteDatabase, "database");
            m.e(str, "tableName");
            return new FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
        }

        private Companion() {
        }
    }

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        m.e(str, RewardPlus.NAME);
        m.e(set, "columns");
        m.e(set2, "options");
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    @VisibleForTesting
    public static final Set<String> parseOptions(String str) {
        return Companion.parseOptions(str);
    }

    @SuppressLint({"SyntheticAccessor"})
    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (m.a(this.name, ftsTableInfo.name) && m.a(this.columns, ftsTableInfo.columns)) {
            return m.a(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, Companion.parseOptions(str2));
        m.e(str, RewardPlus.NAME);
        m.e(set, "columns");
        m.e(str2, "createSql");
    }
}
