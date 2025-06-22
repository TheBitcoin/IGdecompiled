package W1;

import android.content.Context;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

public final class i {
    public final boolean a(File file) {
        File[] listFiles;
        m.e(file, "f");
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                m.d(file2, "childFile");
                a(file2);
            }
        }
        return file.delete();
    }

    public final String b(long j4) {
        if (j4 < 1000) {
            return String.valueOf(j4);
        }
        if (j4 < 1000000) {
            StringBuilder sb = new StringBuilder();
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) j4) / ((double) 1000))}, 1));
            m.d(format, "format(locale, format, *args)");
            sb.append(format);
            sb.append('K');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        F f5 = F.f20971a;
        String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) j4) / ((double) 1000000))}, 1));
        m.d(format2, "format(locale, format, *args)");
        sb2.append(format2);
        sb2.append('M');
        return sb2.toString();
    }

    public final String c(long j4) {
        double d5 = ((double) j4) / 1024.0d;
        if (d5 < 1024.0d) {
            StringBuilder sb = new StringBuilder();
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            m.d(format, "format(locale, format, *args)");
            sb.append(format);
            sb.append(" KB");
            return sb.toString();
        }
        double d6 = (double) 1024;
        double d7 = d5 / d6;
        if (d7 < 1024.0d) {
            StringBuilder sb2 = new StringBuilder();
            F f5 = F.f20971a;
            String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7)}, 1));
            m.d(format2, "format(locale, format, *args)");
            sb2.append(format2);
            sb2.append(" MB");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        F f6 = F.f20971a;
        String format3 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7 / d6)}, 1));
        m.d(format3, "format(locale, format, *args)");
        sb3.append(format3);
        sb3.append(" GB");
        return sb3.toString();
    }

    public final String d(long j4, Context context) {
        String str;
        m.e(context, "context");
        double d5 = ((double) j4) / 1024.0d;
        if (d5 < 1024.0d) {
            int i4 = N1.i.kb_placeholder;
            F f4 = F.f20971a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            m.d(format, "format(locale, format, *args)");
            String string = context.getString(i4, new Object[]{format});
            m.d(string, "{\n            context.ge…), \"%.2f\", kb))\n        }");
            return string;
        }
        double d6 = (double) 1024;
        double d7 = d5 / d6;
        if (d7 < 1024.0d) {
            int i5 = N1.i.mb_placeholder;
            F f5 = F.f20971a;
            String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7)}, 1));
            m.d(format2, "format(locale, format, *args)");
            str = context.getString(i5, new Object[]{format2});
        } else {
            int i6 = N1.i.gb_placeholder;
            F f6 = F.f20971a;
            String format3 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7 / d6)}, 1));
            m.d(format3, "format(locale, format, *args)");
            str = context.getString(i6, new Object[]{format3});
        }
        m.d(str, "{\n            val mb = k…)\n            }\n        }");
        return str;
    }
}
