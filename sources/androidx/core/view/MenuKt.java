package androidx.core.view;

import R2.s;
import android.view.Menu;
import android.view.MenuItem;
import d3.l;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import l3.e;

public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (m.a(menu.getItem(i4), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, l lVar) {
        int size = menu.size();
        for (int i4 = 0; i4 < size; i4++) {
            lVar.invoke(menu.getItem(i4));
        }
    }

    public static final void forEachIndexed(Menu menu, p pVar) {
        int size = menu.size();
        for (int i4 = 0; i4 < size; i4++) {
            pVar.invoke(Integer.valueOf(i4), menu.getItem(i4));
        }
    }

    public static final MenuItem get(Menu menu, int i4) {
        return menu.getItem(i4);
    }

    public static final e getChildren(Menu menu) {
        return new MenuKt$children$1(menu);
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        if (menu.size() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(Menu menu) {
        if (menu.size() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i4) {
        s sVar;
        MenuItem item = menu.getItem(i4);
        if (item != null) {
            menu.removeItem(item.getItemId());
            sVar = s.f8222a;
        } else {
            sVar = null;
        }
        if (sVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
