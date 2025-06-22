package W1;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: W1.e  reason: case insensitive filesystem */
public final class C1609e extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8671a = new a((C2103g) null);

    /* renamed from: W1.e$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C1609e a(Context context, Locale locale) {
            Context context2;
            m.e(context, "newBase");
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocale(locale);
                C1608d.a();
                LocaleList a5 = C1607c.a(new Locale[]{locale});
                LocaleList.setDefault(a5);
                configuration.setLocales(a5);
                context2 = context.createConfigurationContext(configuration);
                m.d(context2, "newBase.createConfigurationContext(configuration)");
            } else {
                configuration.setLocale(locale);
                context2 = context.createConfigurationContext(configuration);
                m.d(context2, "newBase.createConfigurationContext(configuration)");
            }
            return new C1609e(context2);
        }

        private a() {
        }
    }

    public C1609e(Context context) {
        super(context);
    }
}
