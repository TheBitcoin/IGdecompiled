package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import b3.C1642b;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    public static final Companion Companion = new Companion((C2103g) null);
    public final String name;
    public final String sql;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            ViewInfo viewInfo;
            m.e(supportSQLiteDatabase, "database");
            m.e(str, "viewName");
            Cursor query = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    m.d(string, "cursor.getString(0)");
                    viewInfo = new ViewInfo(string, query.getString(1));
                } else {
                    viewInfo = new ViewInfo(str, (String) null);
                }
                C1642b.a(query, (Throwable) null);
                return viewInfo;
            } catch (Throwable th) {
                C1642b.a(query, th);
                throw th;
            }
        }

        private Companion() {
        }
    }

    public ViewInfo(String str, String str2) {
        m.e(str, RewardPlus.NAME);
        this.name = str;
        this.sql = str2;
    }

    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (m.a(this.name, viewInfo.name)) {
            String str = this.sql;
            String str2 = viewInfo.sql;
            if (str != null) {
                z4 = m.a(str, str2);
            } else if (str2 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.name.hashCode() * 31;
        String str = this.sql;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
