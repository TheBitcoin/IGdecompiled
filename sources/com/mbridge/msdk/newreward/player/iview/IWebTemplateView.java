package com.mbridge.msdk.newreward.player.iview;

import org.json.JSONObject;

public interface IWebTemplateView extends IBaseWebView, IPlayTempleView {
    void changeVideoViewPosition(JSONObject jSONObject);

    void playOrPauseVideo(int i4);

    void seekToPlay(int i4);

    void setMuteState(int i4, int i5);
}
