package M;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: M.d  reason: case insensitive filesystem */
public final class C0323d {

    /* renamed from: a  reason: collision with root package name */
    private final Account f488a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f489b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f490c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f491d;

    /* renamed from: e  reason: collision with root package name */
    private final int f492e;

    /* renamed from: f  reason: collision with root package name */
    private final View f493f;

    /* renamed from: g  reason: collision with root package name */
    private final String f494g;

    /* renamed from: h  reason: collision with root package name */
    private final String f495h;

    /* renamed from: i  reason: collision with root package name */
    private final h0.a f496i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f497j;

    /* renamed from: M.d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f498a;

        /* renamed from: b  reason: collision with root package name */
        private ArraySet f499b;

        /* renamed from: c  reason: collision with root package name */
        private String f500c;

        /* renamed from: d  reason: collision with root package name */
        private String f501d;

        /* renamed from: e  reason: collision with root package name */
        private final h0.a f502e = h0.a.f3398j;

        public C0323d a() {
            return new C0323d(this.f498a, this.f499b, (Map) null, 0, (View) null, this.f500c, this.f501d, this.f502e, false);
        }

        public a b(String str) {
            this.f500c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f499b == null) {
                this.f499b = new ArraySet();
            }
            this.f499b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f498a = account;
            return this;
        }

        public final a e(String str) {
            this.f501d = str;
            return this;
        }
    }

    public C0323d(Account account, Set set, Map map, int i4, View view, String str, String str2, h0.a aVar, boolean z4) {
        Set set2;
        this.f488a = account;
        if (set == null) {
            set2 = Collections.EMPTY_SET;
        } else {
            set2 = DesugarCollections.unmodifiableSet(set);
        }
        this.f489b = set2;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f491d = map;
        this.f493f = view;
        this.f492e = i4;
        this.f494g = str;
        this.f495h = str2;
        this.f496i = aVar == null ? h0.a.f3398j : aVar;
        HashSet hashSet = new HashSet(set2);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.f490c = DesugarCollections.unmodifiableSet(hashSet);
        } else {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    public Account a() {
        return this.f488a;
    }

    public String b() {
        Account account = this.f488a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account c() {
        Account account = this.f488a;
        if (account != null) {
            return account;
        }
        return new Account("<<default account>>", "com.google");
    }

    public Set d() {
        return this.f490c;
    }

    public Set e(K.a aVar) {
        android.support.v4.media.a.a(this.f491d.get(aVar));
        return this.f489b;
    }

    public String f() {
        return this.f494g;
    }

    public Set g() {
        return this.f489b;
    }

    public final h0.a h() {
        return this.f496i;
    }

    public final Integer i() {
        return this.f497j;
    }

    public final String j() {
        return this.f495h;
    }

    public final void k(Integer num) {
        this.f497j = num;
    }
}
