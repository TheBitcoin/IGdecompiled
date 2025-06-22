package com.mbridge.msdk.newreward.player.iview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public interface IECTempleView extends IBaseView {
    void addShakeView(View view);

    View getBaitClickView();

    ImageView getNoticeIV();

    IECTempleView getParentObject();

    void setBlurBackGround(Bitmap bitmap);

    void setCTAText(String str);

    void setCloseViewBtnDelayShow(int i4);

    void setHeatCount(int i4);

    void setImageBitMap(int i4, Bitmap bitmap);

    void setNLogo(int i4, String str, Drawable drawable);

    void setRatingAndUser(double d5, int i4);

    void setTextByID(int i4, String str);
}
