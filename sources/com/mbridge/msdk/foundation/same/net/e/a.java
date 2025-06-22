package com.mbridge.msdk.foundation.same.net.e;

public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        int i4;
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i5 = aVar.f13249a;
            com.mbridge.msdk.foundation.same.net.d.a aVar2 = aVar.f13251c;
            if (aVar2 != null) {
                i4 = aVar2.f13260d;
            } else {
                i4 = 0;
            }
            if (i5 == -2) {
                return "Network is canceled";
            }
            if (i5 == 15) {
                return "Network error,I/O exception contents null";
            }
            if (i5 == 880023) {
                return "timeout";
            }
            if (i5 == 880041) {
                return "Network error,UnknownHostException";
            }
            switch (i5) {
                case 1:
                    return "Network error,Load failed";
                case 2:
                    return "Network error,I/O exception";
                case 3:
                    return "Network error,timeout exception";
                case 4:
                    return "Network unknown error";
                case 5:
                    return "Network error，https is not work,please check your phone time";
                case 6:
                    if (i4 == 0) {
                        return "Network error,please check ";
                    }
                    return "Network error,please check state code " + i4;
                case 7:
                    if (i4 == 0) {
                        return "The server returns an exception ";
                    }
                    return "The server returns an exception state code " + i4;
                case 8:
                    return "Cast exception, return data can not be casted correctly";
                default:
                    switch (i5) {
                        case 10:
                            return "Network error,socket timeout exception";
                        case 11:
                            return "Network error，sslp exception";
                        case 12:
                            return "Network error,ConnectException";
                        case 13:
                            if (aVar2 == null) {
                                return "Unknown socket exception";
                            }
                            byte[] bArr = aVar2.f13257a;
                            if (bArr != null) {
                                return new String(bArr);
                            }
                            return "Socket exception message is NULL";
                        default:
                            return "Network error,unknown";
                    }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
