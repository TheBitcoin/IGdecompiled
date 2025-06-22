package r1;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* renamed from: r1.a  reason: case insensitive filesystem */
public enum C2215a {
    CLICK(CampaignEx.JSON_NATIVE_VIDEO_CLICK),
    INVITATION_ACCEPTED("invitationAccept");
    

    /* renamed from: a  reason: collision with root package name */
    String f21585a;

    private C2215a(String str) {
        this.f21585a = str;
    }

    public String toString() {
        return this.f21585a;
    }
}
