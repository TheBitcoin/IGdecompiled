package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.g;

public class f implements g {
    public void a(int i4) {
        af.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i4);
    }

    public void a(int i4, String str) {
        af.a("DefaultJSNotifyProxy", "onClick:" + i4 + ",pt:" + str);
    }

    public void a(MBridgeVideoView.b bVar) {
        af.a("DefaultJSNotifyProxy", "onProgressNotify:" + bVar.toString());
    }

    public void a(Object obj) {
        af.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    public void a(int i4, int i5, int i6, int i7) {
        af.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
