package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.player.view.Template102;
import com.mbridge.msdk.newreward.player.view.Template202;
import com.mbridge.msdk.newreward.player.view.Template302;
import com.mbridge.msdk.newreward.player.view.Template5002010;
import com.mbridge.msdk.newreward.player.view.Template802;
import com.mbridge.msdk.newreward.player.view.Template902;
import com.mbridge.msdk.newreward.player.view.Template904;
import com.mbridge.msdk.newreward.player.view.bigtemplate.Template201;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC1302;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC404;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC704;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateHalfEC;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateVastEC;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateEndCover;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateHalf;
import java.util.Map;

public final class b implements com.mbridge.msdk.newreward.function.command.receiver.b {
    public final void a(Object obj) {
        char c5;
        String str;
        Map map = (Map) obj;
        String valueOf = String.valueOf(map.get("add_temple"));
        ViewGroup viewGroup = (ViewGroup) map.get("parent_temple");
        e eVar = (e) map.get("adapter_model");
        c b5 = d.a().b();
        String str2 = "";
        char c6 = 65535;
        switch (valueOf.hashCode()) {
            case -1738448503:
                c5 = 1;
                if (valueOf.equals("WEB_EC")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1623688923:
                c5 = 1;
                if (valueOf.equals("WEB_TEMPLATE")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1517363552:
                c5 = 1;
                if (valueOf.equals("HALF_END_CARD")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1207348799:
                c5 = 1;
                if (valueOf.equals("ONLY_PLAYABLE")) {
                    c6 = 3;
                    break;
                }
                break;
            case -298533114:
                c5 = 1;
                if (valueOf.equals("HALF_TEMPLATE")) {
                    c6 = 4;
                    break;
                }
                break;
            case 48627:
                c5 = 1;
                if (valueOf.equals(MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE)) {
                    c6 = 5;
                    break;
                }
                break;
            case 49587:
                c5 = 1;
                if (valueOf.equals("201")) {
                    c6 = 6;
                    break;
                }
                break;
            case 49588:
                c5 = 1;
                if (valueOf.equals("202")) {
                    c6 = 7;
                    break;
                }
                break;
            case 50549:
                c5 = 1;
                if (valueOf.equals("302")) {
                    c6 = 8;
                    break;
                }
                break;
            case 51512:
                c5 = 1;
                if (valueOf.equals("404")) {
                    c6 = 9;
                    break;
                }
                break;
            case 54395:
                c5 = 1;
                if (valueOf.equals("704")) {
                    c6 = 10;
                    break;
                }
                break;
            case 55354:
                c5 = 1;
                if (valueOf.equals("802")) {
                    c6 = 11;
                    break;
                }
                break;
            case 56315:
                c5 = 1;
                if (valueOf.equals("902")) {
                    c6 = 12;
                    break;
                }
                break;
            case 56317:
                c5 = 1;
                if (valueOf.equals("904")) {
                    c6 = 13;
                    break;
                }
                break;
            case 1510308:
                c5 = 1;
                if (valueOf.equals("1302")) {
                    c6 = 14;
                    break;
                }
                break;
            case 2627148:
                c5 = 1;
                if (valueOf.equals("VAST")) {
                    c6 = 15;
                    break;
                }
                break;
            case 563693366:
                c5 = 1;
                if (valueOf.equals("SHOW_CLICK_URL")) {
                    c6 = 16;
                    break;
                }
                break;
            case 1213120338:
                c5 = 1;
                if (valueOf.equals("5002010")) {
                    c6 = 17;
                    break;
                }
                break;
            case 1277364343:
                c5 = 1;
                if (valueOf.equals("HALF_TEMPLATE_EC")) {
                    c6 = 18;
                    break;
                }
                break;
            default:
                c5 = 1;
                break;
        }
        switch (c6) {
            case 0:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                Object[] objArr = new Object[10];
                objArr[0] = "web_resource_action";
                objArr[c5] = 2;
                objArr[2] = "parent_temple";
                objArr[3] = viewGroup;
                objArr[4] = "adapter_model";
                objArr[5] = eVar;
                objArr[6] = "command_manager";
                objArr[7] = b5;
                objArr[8] = "bridge_ids";
                objArr[9] = str2;
                b5.i(b5.a(objArr), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 1:
                if (eVar != null) {
                    str = eVar.G();
                } else {
                    str = str2;
                }
                if (eVar != null) {
                    str2 = eVar.V();
                }
                Object[] objArr2 = new Object[12];
                objArr2[0] = "web_resource_action";
                objArr2[c5] = 2;
                objArr2[2] = "parent_temple";
                objArr2[3] = viewGroup;
                objArr2[4] = "adapter_model";
                objArr2[5] = eVar;
                objArr2[6] = "command_manager";
                objArr2[7] = b5;
                objArr2[8] = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
                objArr2[9] = str;
                objArr2[10] = "bridge_ids";
                objArr2[11] = str2;
                b5.i(b5.a(objArr2), f.SHOW_OR_PRELOAD_WEB_TEMPLATE);
                return;
            case 2:
                new TemplateHalfEC(viewGroup.getContext()).show(viewGroup);
                return;
            case 3:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                Object[] objArr3 = new Object[10];
                objArr3[0] = "web_resource_action";
                objArr3[c5] = 3;
                objArr3[2] = "parent_temple";
                objArr3[3] = viewGroup;
                objArr3[4] = "adapter_model";
                objArr3[5] = eVar;
                objArr3[6] = "command_manager";
                objArr3[7] = b5;
                objArr3[8] = "bridge_ids";
                objArr3[9] = str2;
                b5.i(b5.a(objArr3), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 4:
                new TemplateHalf(viewGroup.getContext()).show(viewGroup);
                return;
            case 5:
                new Template102(viewGroup.getContext()).show(viewGroup);
                return;
            case 6:
                new Template201(viewGroup.getContext()).show(viewGroup);
                return;
            case 7:
                new Template202(viewGroup.getContext()).show(viewGroup);
                return;
            case 8:
                new Template302(viewGroup.getContext()).show(viewGroup);
                return;
            case 9:
                new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                return;
            case 10:
                new TemplateEC704(viewGroup.getContext()).show(viewGroup);
                return;
            case 11:
                new Template802(viewGroup.getContext()).show(viewGroup);
                return;
            case 12:
                new Template902(viewGroup.getContext()).show(viewGroup);
                return;
            case 13:
                new Template904(viewGroup.getContext()).show(viewGroup);
                return;
            case 14:
                new TemplateEC1302(viewGroup.getContext()).show(viewGroup);
                return;
            case 15:
                new TemplateVastEC(viewGroup.getContext()).show(viewGroup);
                return;
            case 16:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                Object[] objArr4 = new Object[10];
                objArr4[0] = "web_resource_action";
                objArr4[c5] = 4;
                objArr4[2] = "parent_temple";
                objArr4[3] = viewGroup;
                objArr4[4] = "adapter_model";
                objArr4[5] = eVar;
                objArr4[6] = "command_manager";
                objArr4[7] = b5;
                objArr4[8] = "bridge_ids";
                objArr4[9] = str2;
                b5.i(b5.a(objArr4), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 17:
                new Template5002010(viewGroup.getContext()).show(viewGroup);
                return;
            case 18:
                new TemplateEndCover(viewGroup.getContext()).show(viewGroup);
                return;
            default:
                Object obj2 = map.get("template_type");
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    if (intValue == 17) {
                        new Template904(viewGroup.getContext()).show(viewGroup);
                        return;
                    } else if (intValue == 18) {
                        new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
        }
    }
}
