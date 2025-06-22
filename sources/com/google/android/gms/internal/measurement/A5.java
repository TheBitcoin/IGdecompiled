package com.google.android.gms.internal.measurement;

abstract class A5 {
    static String a(K3 k32) {
        C0725z5 z5Var = new C0725z5(k32);
        StringBuilder sb = new StringBuilder(z5Var.A());
        for (int i4 = 0; i4 < z5Var.A(); i4++) {
            byte a5 = z5Var.a(i4);
            if (a5 == 34) {
                sb.append("\\\"");
            } else if (a5 == 39) {
                sb.append("\\'");
            } else if (a5 != 92) {
                switch (a5) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a5 >= 32 && a5 <= 126) {
                            sb.append((char) a5);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a5 >>> 6) & 3) + 48));
                            sb.append((char) (((a5 >>> 3) & 7) + 48));
                            sb.append((char) ((a5 & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
