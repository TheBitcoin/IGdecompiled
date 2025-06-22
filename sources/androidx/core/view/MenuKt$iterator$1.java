package androidx.core.view;

import R2.s;
import android.view.Menu;
import android.view.MenuItem;
import e3.a;
import java.util.Iterator;

public final class MenuKt$iterator$1 implements Iterator<MenuItem>, a {
    final /* synthetic */ Menu $this_iterator;
    private int index;

    MenuKt$iterator$1(Menu menu) {
        this.$this_iterator = menu;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.size()) {
            return true;
        }
        return false;
    }

    public void remove() {
        s sVar;
        Menu menu = this.$this_iterator;
        int i4 = this.index - 1;
        this.index = i4;
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

    public MenuItem next() {
        Menu menu = this.$this_iterator;
        int i4 = this.index;
        this.index = i4 + 1;
        MenuItem item = menu.getItem(i4);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }
}
