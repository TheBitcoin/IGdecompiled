package com.mbridge.msdk.out;

public interface WebLoadListener {
    void onFailed(String str, int i4, int i5, int i6, String str2, String str3);

    void onProgress(String str, int i4, int i5, int i6, String str2, String str3);

    void onSucess(String str, int i4, int i5, int i6, String str2, String str3);
}
