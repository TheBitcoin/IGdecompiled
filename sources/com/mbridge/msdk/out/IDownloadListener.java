package com.mbridge.msdk.out;

public interface IDownloadListener {
    void onEnd(int i4, int i5, String str);

    void onProgressUpdate(int i4);

    void onStart();

    void onStatus(int i4);
}
