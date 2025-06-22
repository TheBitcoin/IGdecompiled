package X3;

import V2.d;
import V3.C2592c;
import Z3.C2612a;
import com.inmobi.cmp.data.model.ChoiceColor;
import kotlin.jvm.internal.m;

/* renamed from: X3.b  reason: case insensitive filesystem */
public final class C2606b implements C2605a {

    /* renamed from: a  reason: collision with root package name */
    public final ChoiceColor f24242a;

    /* renamed from: b  reason: collision with root package name */
    public final C2612a f24243b;

    public C2606b(ChoiceColor choiceColor, C2612a aVar) {
        m.e(aVar, "resolver");
        this.f24242a = choiceColor;
        this.f24243b = aVar;
    }

    public Object a(d dVar) {
        ChoiceColor choiceColor = this.f24242a;
        if (choiceColor == null) {
            return null;
        }
        this.f24243b.getClass();
        m.e(choiceColor, "colorResources");
        return new C2592c(choiceColor.getDividerColor(), choiceColor.getTabBackgroundColor(), choiceColor.getSearchBarBackgroundColor(), choiceColor.getSearchBarForegroundColor(), choiceColor.getToggleActiveColor(), choiceColor.getToggleInactiveColor(), choiceColor.getGlobalBackgroundColor(), choiceColor.getTitleTextColor(), choiceColor.getBodyTextColor(), choiceColor.getTabTextColor(), choiceColor.getMenuTextColor(), choiceColor.getLinkTextColor(), choiceColor.getButtonTextColor(), choiceColor.getButtonDisabledTextColor(), choiceColor.getButtonBackgroundColor(), choiceColor.getButtonDisabledBackgroundColor());
    }
}
