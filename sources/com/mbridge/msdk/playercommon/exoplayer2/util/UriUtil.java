package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil() {
    }

    private static int[] getUriIndices(String str) {
        int i4;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i5 = indexOf4 + 2;
        if (i5 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i5) == '/') {
            i4 = str.indexOf(47, indexOf4 + 3);
            if (i4 == -1 || i4 > indexOf2) {
                i4 = indexOf2;
            }
        } else {
            i4 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i4;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    private static String removeDotSegments(StringBuilder sb, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        if (i4 >= i5) {
            return sb.toString();
        }
        if (sb.charAt(i4) == '/') {
            i4++;
        }
        int i9 = i4;
        int i10 = i9;
        while (i9 <= i5) {
            if (i9 == i5) {
                i6 = i9;
            } else if (sb.charAt(i9) == '/') {
                i6 = i9 + 1;
            } else {
                i9++;
            }
            int i11 = i10 + 1;
            if (i9 == i11 && sb.charAt(i10) == '.') {
                sb.delete(i10, i6);
                i5 -= i6 - i10;
            } else {
                if (i9 == i10 + 2 && sb.charAt(i10) == '.' && sb.charAt(i11) == '.') {
                    i7 = sb.lastIndexOf("/", i10 - 2) + 1;
                    if (i7 > i4) {
                        i8 = i7;
                    } else {
                        i8 = i4;
                    }
                    sb.delete(i8, i6);
                    i5 -= i6 - i8;
                } else {
                    i7 = i9 + 1;
                }
                i10 = i7;
            }
            i9 = i10;
        }
        return sb.toString();
    }

    public static Uri removeQueryParameter(Uri uri, String str) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        for (String next : uri.getQueryParameterNames()) {
            if (!next.equals(str)) {
                for (String appendQueryParameter : uri.getQueryParameters(next)) {
                    buildUpon.appendQueryParameter(next, appendQueryParameter);
                }
            }
        }
        return buildUpon.build();
    }

    public static String resolve(String str, String str2) {
        int i4;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] uriIndices = getUriIndices(str2);
        if (uriIndices[0] != -1) {
            sb.append(str2);
            removeDotSegments(sb, uriIndices[1], uriIndices[2]);
            return sb.toString();
        }
        int[] uriIndices2 = getUriIndices(str);
        if (uriIndices[3] == 0) {
            sb.append(str, 0, uriIndices2[3]);
            sb.append(str2);
            return sb.toString();
        } else if (uriIndices[2] == 0) {
            sb.append(str, 0, uriIndices2[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i5 = uriIndices[1];
            if (i5 != 0) {
                int i6 = uriIndices2[0] + 1;
                sb.append(str, 0, i6);
                sb.append(str2);
                return removeDotSegments(sb, uriIndices[1] + i6, i6 + uriIndices[2]);
            } else if (str2.charAt(i5) == '/') {
                sb.append(str, 0, uriIndices2[1]);
                sb.append(str2);
                int i7 = uriIndices2[1];
                return removeDotSegments(sb, i7, uriIndices[2] + i7);
            } else {
                int i8 = uriIndices2[0] + 2;
                int i9 = uriIndices2[1];
                if (i8 >= i9 || i9 != uriIndices2[2]) {
                    int lastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
                    if (lastIndexOf == -1) {
                        i4 = uriIndices2[1];
                    } else {
                        i4 = lastIndexOf + 1;
                    }
                    sb.append(str, 0, i4);
                    sb.append(str2);
                    return removeDotSegments(sb, uriIndices2[1], i4 + uriIndices[2]);
                }
                sb.append(str, 0, i9);
                sb.append('/');
                sb.append(str2);
                int i10 = uriIndices2[1];
                return removeDotSegments(sb, i10, uriIndices[2] + i10 + 1);
            }
        }
    }

    public static Uri resolveToUri(String str, String str2) {
        return Uri.parse(resolve(str, str2));
    }
}
