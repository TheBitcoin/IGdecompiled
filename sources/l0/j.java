package l0;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class j {
    public static String a(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i4 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i5 = 0; i5 < objArr.length; i5++) {
                objArr[i5] = b(objArr[i5]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i6 = 0;
        while (i4 < objArr.length && (indexOf = valueOf.indexOf("%s", i6)) != -1) {
            sb.append(valueOf, i6, indexOf);
            sb.append(objArr[i4]);
            int i7 = i4 + 1;
            i6 = indexOf + 2;
            i4 = i7;
        }
        sb.append(valueOf, i6, valueOf.length());
        if (i4 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i4]);
            for (int i8 = i4 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String b(Object obj) {
        String str;
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e5) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String sb2 = sb.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String valueOf = String.valueOf(sb2);
            if (valueOf.length() != 0) {
                str = "Exception during lenientFormat for ".concat(valueOf);
            } else {
                str = new String("Exception during lenientFormat for ");
            }
            logger.log(level, str, e5);
            String name2 = e5.getClass().getName();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 9 + name2.length());
            sb3.append("<");
            sb3.append(sb2);
            sb3.append(" threw ");
            sb3.append(name2);
            sb3.append(">");
            return sb3.toString();
        }
    }
}
