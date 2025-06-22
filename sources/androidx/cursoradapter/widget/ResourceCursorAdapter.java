package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i4, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = i4;
        this.mLayout = i4;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i4) {
        this.mDropDownLayout = i4;
    }

    public void setViewResource(int i4) {
        this.mLayout = i4;
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int i4, Cursor cursor, boolean z4) {
        super(context, cursor, z4);
        this.mDropDownLayout = i4;
        this.mLayout = i4;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i4, Cursor cursor, int i5) {
        super(context, cursor, i5);
        this.mDropDownLayout = i4;
        this.mLayout = i4;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
