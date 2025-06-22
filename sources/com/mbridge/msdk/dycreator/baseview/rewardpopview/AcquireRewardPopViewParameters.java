package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;

public class AcquireRewardPopViewParameters {
    public int autoDismissTime = 5;
    public AcquireRewardPopViewBehaviourListener behaviourListener;
    public int buttonBackgroundDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_33EF7601;
    public int buttonBackgroundLightColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF8B00;
    public int buttonTextDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_D26700;
    public int buttonTextLightColor = -1;
    public boolean canClickMaskArea = true;
    public int containerBackgroundColor = AcquireRewardPopViewConst.DEFAULT_COLOR_50000000;
    public String failTip;
    public int failTipTextColor = -1;
    public String failTitle;
    public int failTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_8B6B45;
    public int failTitleGradientStartColor = -1;
    public int failTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_3B3127;
    public float failTitleShadowDx = 1.5f;
    public float failTitleShadowDy = 1.8f;
    public float failTitleShadowRadius = 3.0f;
    public int failTitleTextSize = 40;
    public String language;
    public String placementId;
    public int reduceTime = 0;
    public List<String> rightAnswerList;
    public String slideSuccessTitle;
    public String slideTip;
    public String slideTitle;
    public String successTip;
    public int successTipTextColor = -1;
    public String successTitle;
    public int successTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
    public int successTitleGradientStartColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
    public int successTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
    public float successTitleShadowDx = 1.5f;
    public float successTitleShadowDy = 1.8f;
    public float successTitleShadowRadius = 3.0f;
    public int successTitleTextSize = 40;
    public int tipTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_89664C;
    public String tips;
    public String title;
    public int titleTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_E56F19;
    public String unitId;
    public int viewBackLayerBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF932B;
    public int viewBackLayerTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFC27A;
    public int viewForegroundBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFE0B5;
    public int viewForegroundTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBE2;
    public int viewType;
    public List<String> wrongAnswerList;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private AcquireRewardPopViewParameters f12492a;

        /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(java.lang.String r3, java.lang.String r4, int r5, java.lang.String r6) {
            /*
                r2 = this;
                r2.<init>()
                com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters r0 = new com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters
                r0.<init>()
                r2.f12492a = r0
                r0.placementId = r3
                r0.unitId = r4
                r0.viewType = r5
                r0.language = r6
                boolean r3 = android.text.TextUtils.isEmpty(r6)
                java.lang.String r4 = "EN"
                java.lang.String r5 = "KO"
                java.lang.String r0 = "JA"
                java.lang.String r1 = "ZH"
                if (r3 == 0) goto L_0x0021
                goto L_0x0048
            L_0x0021:
                java.lang.String r3 = "CN"
                boolean r3 = r6.equalsIgnoreCase(r3)
                if (r3 == 0) goto L_0x002b
                r3 = r1
                goto L_0x0049
            L_0x002b:
                java.lang.String r3 = "UK"
                boolean r3 = r6.equalsIgnoreCase(r3)
                if (r3 == 0) goto L_0x0034
                goto L_0x0048
            L_0x0034:
                java.lang.String r3 = "JP"
                boolean r3 = r6.equalsIgnoreCase(r3)
                if (r3 == 0) goto L_0x003e
                r3 = r0
                goto L_0x0049
            L_0x003e:
                java.lang.String r3 = "KR"
                boolean r3 = r6.equalsIgnoreCase(r3)
                if (r3 == 0) goto L_0x0048
                r3 = r5
                goto L_0x0049
            L_0x0048:
                r3 = r4
            L_0x0049:
                boolean r6 = r3.equalsIgnoreCase(r1)
                if (r6 == 0) goto L_0x007e
                com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters r3 = r2.f12492a
                java.lang.String r4 = "现在播放的是以下何广告?"
                r3.title = r4
                java.lang.String r4 = "答对问题即可提前%1$s秒跳过视频播放并获得奖励"
                r3.tips = r4
                java.lang.String r4 = "回答正确!"
                r3.successTitle = r4
                java.lang.String r4 = "恭喜您可提前%1$s秒跳过视频并获得奖励"
                r3.successTip = r4
                java.lang.String r4 = "回答错误!"
                r3.failTitle = r4
                java.lang.String r4 = "下次再接再厉"
                r3.failTip = r4
                java.lang.String r4 = "滑动视频 获得奖励"
                r3.slideTitle = r4
                java.lang.String r4 = "完成滑动即可提前%1$s秒跳过视频播放"
                r3.slideTip = r4
                java.lang.String r4 = "完成滑动!"
                r3.slideSuccessTitle = r4
                java.lang.String[] r4 = com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_CN
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.wrongAnswerList = r4
                return
            L_0x007e:
                boolean r4 = r3.equalsIgnoreCase(r4)
                if (r4 == 0) goto L_0x00b3
                com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters r3 = r2.f12492a
                java.lang.String r4 = "Which of the following ads is currently playing?"
                r3.title = r4
                java.lang.String r4 = "Answer the question correctly to skip the video %1$ss early and get reward."
                r3.tips = r4
                java.lang.String r4 = "Correct!"
                r3.successTitle = r4
                java.lang.String r4 = "Congrats!You can skip the video %1$ss earlier and get the reward"
                r3.successTip = r4
                java.lang.String r4 = "Wrong answer!"
                r3.failTitle = r4
                java.lang.String r4 = "Try again next time"
                r3.failTip = r4
                java.lang.String r4 = "Scroll the video to get reward"
                r3.slideTitle = r4
                java.lang.String r4 = "Scroll the video to skip the video %1$ss early."
                r3.slideTip = r4
                java.lang.String r4 = "Finish scrolling!"
                r3.slideSuccessTitle = r4
                java.lang.String[] r4 = com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_EN
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.wrongAnswerList = r4
                return
            L_0x00b3:
                boolean r4 = r3.equalsIgnoreCase(r0)
                if (r4 == 0) goto L_0x00e8
                com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters r3 = r2.f12492a
                java.lang.String r4 = "現在流れている広告はどれですか?"
                r3.title = r4
                java.lang.String r4 = "質問に正しく答えますとビデオを%1$s秒早めにスキップできます。"
                r3.tips = r4
                java.lang.String r4 = "正解です!"
                r3.successTitle = r4
                java.lang.String r4 = "おめでとう！ビデオ%1$s秒を早くスキップしてリワードを得ることができます。"
                r3.successTip = r4
                java.lang.String r4 = "間違えました！"
                r3.failTitle = r4
                java.lang.String r4 = "今度また挑戦してみてください"
                r3.failTip = r4
                java.lang.String r4 = "動画をスクロールしてリワードを獲得しましょう"
                r3.slideTitle = r4
                java.lang.String r4 = "スクロールしますとビデオを%1$s秒早めにスキップできます。"
                r3.slideTip = r4
                java.lang.String r4 = "スクロールㅈ完了！"
                r3.slideSuccessTitle = r4
                java.lang.String[] r4 = com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_JP
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.wrongAnswerList = r4
                return
            L_0x00e8:
                boolean r3 = r3.equalsIgnoreCase(r5)
                if (r3 == 0) goto L_0x011c
                com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters r3 = r2.f12492a
                java.lang.String r4 = "지금  재생 중인 광고는 어느것입니까?"
                r3.title = r4
                java.lang.String r4 = "정답을 올리면 비디오를 %1$s초 일찍 건너뛸 수 있습니다."
                r3.tips = r4
                java.lang.String r4 = "정답입니다！"
                r3.successTitle = r4
                java.lang.String r4 = "축하합니다! 비디오 %1$s초를  일찍 건너뛰고 보상을 받을 수 있습니다."
                r3.successTip = r4
                java.lang.String r4 = "틀렸습니다！"
                r3.failTitle = r4
                java.lang.String r4 = "다음에 다시 도전해보세요"
                r3.failTip = r4
                java.lang.String r4 = "비디오를 스크롤해서 보상을 받으세요"
                r3.slideTitle = r4
                java.lang.String r4 = "스크롤하시면 비디오를 %1$s초 일찍 건너뛸 수 있습니다."
                r3.slideTip = r4
                java.lang.String r4 = "스크롤 완성!"
                r3.slideSuccessTitle = r4
                java.lang.String[] r4 = com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_KR
                java.util.List r4 = java.util.Arrays.asList(r4)
                r3.wrongAnswerList = r4
            L_0x011c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters.Builder.<init>(java.lang.String, java.lang.String, int, java.lang.String):void");
        }

        public AcquireRewardPopViewParameters build() {
            return this.f12492a;
        }

        public Builder setAutoDismissTime(int i4) {
            this.f12492a.autoDismissTime = i4;
            return this;
        }

        public Builder setBehaviourListener(AcquireRewardPopViewBehaviourListener acquireRewardPopViewBehaviourListener) {
            this.f12492a.behaviourListener = acquireRewardPopViewBehaviourListener;
            return this;
        }

        public Builder setButtonBackgroundDarkColor(int i4) {
            this.f12492a.buttonBackgroundDarkColor = i4;
            return this;
        }

        public Builder setButtonBackgroundLightColor(int i4) {
            this.f12492a.buttonBackgroundLightColor = i4;
            return this;
        }

        public Builder setButtonTextDarkColor(int i4) {
            this.f12492a.buttonTextDarkColor = i4;
            return this;
        }

        public Builder setButtonTextLightColor(int i4) {
            this.f12492a.buttonTextLightColor = i4;
            return this;
        }

        public Builder setCanClickMaskArea(boolean z4) {
            this.f12492a.canClickMaskArea = z4;
            return this;
        }

        public Builder setContainerBackgroundColor(int i4) {
            this.f12492a.containerBackgroundColor = i4;
            return this;
        }

        public Builder setFailTip(String str) {
            this.f12492a.failTip = str;
            return this;
        }

        public Builder setFailTipTextColor(int i4) {
            this.f12492a.failTipTextColor = i4;
            return this;
        }

        public Builder setFailTitle(String str) {
            this.f12492a.failTitle = str;
            return this;
        }

        public Builder setFailTitleGradientEndColor(int i4) {
            this.f12492a.failTitleGradientEndColor = i4;
            return this;
        }

        public Builder setFailTitleGradientStartColor(int i4) {
            this.f12492a.failTitleGradientStartColor = i4;
            return this;
        }

        public Builder setFailTitleShadowColor(int i4) {
            this.f12492a.failTitleShadowColor = i4;
            return this;
        }

        public Builder setFailTitleShadowDx(float f4) {
            this.f12492a.failTitleShadowDx = f4;
            return this;
        }

        public Builder setFailTitleShadowDy(float f4) {
            this.f12492a.failTitleShadowDy = f4;
            return this;
        }

        public Builder setFailTitleShadowRadius(float f4) {
            this.f12492a.failTitleShadowRadius = f4;
            return this;
        }

        public Builder setFailTitleTextSize(int i4) {
            this.f12492a.failTitleTextSize = i4;
            return this;
        }

        public Builder setReduceTime(int i4) {
            this.f12492a.reduceTime = i4;
            return this;
        }

        public Builder setRightAnswerList(ArrayList<String> arrayList) {
            this.f12492a.rightAnswerList = arrayList;
            return this;
        }

        public Builder setSlideSuccessTitle(String str) {
            this.f12492a.slideSuccessTitle = str;
            return this;
        }

        public Builder setSlideTip(String str) {
            this.f12492a.slideTip = str;
            return this;
        }

        public Builder setSlideTitle(String str) {
            this.f12492a.slideTitle = str;
            return this;
        }

        public Builder setSuccessTip(String str) {
            this.f12492a.successTip = str;
            return this;
        }

        public Builder setSuccessTipTextColor(int i4) {
            this.f12492a.successTipTextColor = i4;
            return this;
        }

        public Builder setSuccessTitle(String str) {
            this.f12492a.successTitle = str;
            return this;
        }

        public Builder setSuccessTitleGradientEndColor(int i4) {
            this.f12492a.successTitleGradientEndColor = i4;
            return this;
        }

        public Builder setSuccessTitleGradientStartColor(int i4) {
            this.f12492a.successTitleGradientStartColor = i4;
            return this;
        }

        public Builder setSuccessTitleShadowColor(int i4) {
            this.f12492a.successTitleShadowColor = i4;
            return this;
        }

        public Builder setSuccessTitleShadowDx(float f4) {
            this.f12492a.successTitleShadowDx = f4;
            return this;
        }

        public Builder setSuccessTitleShadowDy(float f4) {
            this.f12492a.successTitleShadowDy = f4;
            return this;
        }

        public Builder setSuccessTitleShadowRadius(float f4) {
            this.f12492a.successTitleShadowRadius = f4;
            return this;
        }

        public Builder setSuccessTitleTextSize(int i4) {
            this.f12492a.successTitleTextSize = i4;
            return this;
        }

        public Builder setTipTextColor(int i4) {
            this.f12492a.tipTextColor = i4;
            return this;
        }

        public Builder setTips(String str) {
            this.f12492a.tips = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.f12492a.title = str;
            return this;
        }

        public Builder setTitleTextColor(int i4) {
            this.f12492a.titleTextColor = i4;
            return this;
        }

        public Builder setViewBackLayerBottomColor(int i4) {
            this.f12492a.viewBackLayerBottomColor = i4;
            return this;
        }

        public Builder setViewBackLayerTopColor(int i4) {
            this.f12492a.viewBackLayerTopColor = i4;
            return this;
        }

        public Builder setViewForegroundBottomColor(int i4) {
            this.f12492a.viewForegroundBottomColor = i4;
            return this;
        }

        public Builder setViewForegroundTopColor(int i4) {
            this.f12492a.viewForegroundTopColor = i4;
            return this;
        }

        public Builder setWrongAnswerList(ArrayList<String> arrayList) {
            this.f12492a.wrongAnswerList = arrayList;
            return this;
        }
    }

    public static Builder builder(String str, String str2, int i4, String str3) {
        if (TextUtils.isEmpty(str2)) {
            af.b("AcquireRewardPopViewParameters", "Unit id must not null.");
            return null;
        }
        if (i4 == 0) {
            i4 = 1;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "EN";
        }
        return new Builder(str, str2, i4, str3);
    }
}
