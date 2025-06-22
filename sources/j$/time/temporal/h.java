package j$.time.temporal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import j$.time.d;
import j$.time.g;

public enum h implements q {
    ;
    

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5018a = null;

    public final boolean t() {
        return true;
    }

    static {
        f5018a = new int[]{0, 90, 181, FloatWebTemplateView.FLOAT_MINI_CARD, 0, 91, 182, 274};
    }

    public static int D(int i4) {
        g K4 = g.K(i4, 1, 1);
        if (K4.G() != d.THURSDAY) {
            return (K4.G() != d.WEDNESDAY || !K4.I()) ? 52 : 53;
        }
        return 53;
    }

    public static int w(g gVar) {
        int ordinal = gVar.G().ordinal();
        int H4 = gVar.H() - 1;
        int i4 = (3 - ordinal) + H4;
        int i5 = i4 - ((i4 / 7) * 7);
        int i6 = i5 - 3;
        if (i6 < -3) {
            i6 = i5 + 4;
        }
        if (H4 < i6) {
            return (int) u.e(1, (long) D(C(gVar.T(SubsamplingScaleImageView.ORIENTATION_180).P(-1)))).f5042d;
        }
        int i7 = ((H4 - i6) / 7) + 1;
        if (i7 != 53 || i6 == -3 || (i6 == -2 && gVar.I())) {
            return i7;
        }
        return 1;
    }

    public static int C(g gVar) {
        int i4 = gVar.f4977a;
        int H4 = gVar.H();
        if (H4 <= 3) {
            if (H4 - gVar.G().ordinal() < -2) {
                return i4 - 1;
            }
            return i4;
        } else if (H4 < 363) {
            return i4;
        } else {
            return ((H4 - 363) - (gVar.I() ? 1 : 0)) - gVar.G().ordinal() >= 0 ? i4 + 1 : i4;
        }
    }
}
