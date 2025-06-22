package com.mbridge.msdk.scheme.applet;

import java.io.Serializable;

interface IAppletSchemeCallBack extends Serializable {
    void onAppletSchemeRequestFailed(int i4, String str, String str2);

    void onAppletSchemeRequestStart();

    void onAppletSchemeRequestSuccess(String str);

    void onNetworkError(int i4, String str, String str2);
}
