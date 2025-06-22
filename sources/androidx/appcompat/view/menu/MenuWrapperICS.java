package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    public int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        MenuItem[] menuItemArr4 = menuItemArr2;
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr4);
        if (menuItemArr4 != null) {
            int length = menuItemArr4.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr3[i8] = getMenuItemWrapper(menuItemArr4[i8]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int i4) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i4));
    }

    public MenuItem getItem(int i4) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i4));
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i4, keyEvent);
    }

    public boolean performIdentifierAction(int i4, int i5) {
        return this.mWrappedObject.performIdentifierAction(i4, i5);
    }

    public boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return this.mWrappedObject.performShortcut(i4, keyEvent, i5);
    }

    public void removeGroup(int i4) {
        internalRemoveGroup(i4);
        this.mWrappedObject.removeGroup(i4);
    }

    public void removeItem(int i4) {
        internalRemoveItem(i4);
        this.mWrappedObject.removeItem(i4);
    }

    public void setGroupCheckable(int i4, boolean z4, boolean z5) {
        this.mWrappedObject.setGroupCheckable(i4, z4, z5);
    }

    public void setGroupEnabled(int i4, boolean z4) {
        this.mWrappedObject.setGroupEnabled(i4, z4);
    }

    public void setGroupVisible(int i4, boolean z4) {
        this.mWrappedObject.setGroupVisible(i4, z4);
    }

    public void setQwertyMode(boolean z4) {
        this.mWrappedObject.setQwertyMode(z4);
    }

    public int size() {
        return this.mWrappedObject.size();
    }

    public MenuItem add(int i4) {
        return getMenuItemWrapper(this.mWrappedObject.add(i4));
    }

    public SubMenu addSubMenu(int i4) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i4));
    }

    public MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i4, i5, i6, charSequence));
    }

    public SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i4, i5, i6, charSequence));
    }

    public MenuItem add(int i4, int i5, int i6, int i7) {
        return getMenuItemWrapper(this.mWrappedObject.add(i4, i5, i6, i7));
    }

    public SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i4, i5, i6, i7));
    }
}
