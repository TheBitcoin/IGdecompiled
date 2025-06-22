package com.mbridge.msdk.video.dynview.i;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;

public final class a {
    public static String a(Context context, int i4) {
        String str;
        if (i4 == 1) {
            str = "_por";
        } else {
            str = "_land";
        }
        String t4 = ab.t(context);
        if (t4.startsWith("zh")) {
            if (t4.contains("TW") || t4.contains("HK")) {
                return "mbridge_reward_two_title_zh_trad";
            }
            return "mbridge_reward_two_title_zh";
        } else if (t4.startsWith("ja")) {
            return "mbridge_reward_two_title_japan" + str;
        } else if (t4.startsWith(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR)) {
            return "mbridge_reward_two_title_germany" + str;
        } else if (t4.startsWith("ko")) {
            return "mbridge_reward_two_title_korea" + str;
        } else if (t4.startsWith("fr")) {
            return "mbridge_reward_two_title_france" + str;
        } else if (t4.startsWith("ar")) {
            return "mbridge_reward_two_title_arabia" + str;
        } else if (t4.startsWith("ru")) {
            return "mbridge_reward_two_title_russian" + str;
        } else {
            return "mbridge_reward_two_title_en" + str;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("alecfc");
                if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                    return false;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter;
                }
            }
            return "";
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return "";
        }
    }

    public static int a(CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return 100;
        }
        int f4 = campaignEx.getRewardTemplateMode().f();
        if (!(f4 == 302 || f4 == 802 || f4 == 902)) {
            if (f4 != 904) {
                return 100;
            }
            if (!a(campaignEx.getRewardTemplateMode().e())) {
                return -1;
            }
        }
        return -3;
    }
}
