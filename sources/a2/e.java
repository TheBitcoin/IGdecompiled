package a2;

import N1.f;
import N1.i;
import N1.k;
import S1.g;
import W1.C1611g;
import W1.D;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import kotlin.jvm.internal.m;

public final class e extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final g f8907a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f8908b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f8909c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f8910d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f8911e;

    /* renamed from: f  reason: collision with root package name */
    private final CheckBox f8912f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, g gVar) {
        super(view);
        m.e(view, "itemView");
        m.e(gVar, "listener");
        this.f8907a = gVar;
        View findViewById = view.findViewById(f.iv_icon_file_item);
        m.d(findViewById, "itemView.findViewById(R.id.iv_icon_file_item)");
        this.f8908b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(f.tv_name_file_item);
        m.d(findViewById2, "itemView.findViewById(R.id.tv_name_file_item)");
        TextView textView = (TextView) findViewById2;
        this.f8909c = textView;
        View findViewById3 = view.findViewById(f.tv_date_file_item);
        m.d(findViewById3, "itemView.findViewById(R.id.tv_date_file_item)");
        TextView textView2 = (TextView) findViewById3;
        this.f8910d = textView2;
        View findViewById4 = view.findViewById(f.tv_size_file_item);
        m.d(findViewById4, "itemView.findViewById(R.id.tv_size_file_item)");
        TextView textView3 = (TextView) findViewById4;
        this.f8911e = textView3;
        View findViewById5 = view.findViewById(f.cb_checked_file_item);
        m.d(findViewById5, "itemView.findViewById(R.id.cb_checked_file_item)");
        this.f8912f = (CheckBox) findViewById5;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void d(e eVar, Object obj, View view) {
        m.e(eVar, "this$0");
        m.e(obj, "$file");
        int absoluteAdapterPosition = eVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            eVar.f8907a.a(obj, absoluteAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean e(e eVar, Object obj, View view) {
        m.e(eVar, "this$0");
        m.e(obj, "$file");
        int absoluteAdapterPosition = eVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition == -1) {
            return true;
        }
        eVar.f8907a.b(obj, absoluteAdapterPosition);
        return true;
    }

    public final void c(Object obj, boolean z4, boolean z5) {
        long j4;
        boolean z6;
        String str;
        String str2;
        Drawable drawable;
        m.e(obj, "file");
        this.itemView.setOnClickListener(new c(this, obj));
        this.itemView.setOnLongClickListener(new d(this, obj));
        if (obj instanceof File) {
            File file = (File) obj;
            str2 = file.getName();
            str = new C1611g().g(file.lastModified());
            z6 = file.isDirectory();
            j4 = file.length();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            str2 = documentFile.getName();
            str = new C1611g().g(documentFile.lastModified());
            z6 = documentFile.isDirectory();
            j4 = documentFile.length();
        } else {
            j4 = 0;
            str2 = null;
            str = null;
            z6 = false;
        }
        if (str2 != null) {
            this.f8909c.setText(str2);
            if (z6) {
                this.f8911e.setText(k.f7778g.h().getString(i.core_directory_elementes_count, new Object[]{new C1611g().b(obj)}));
                drawable = AppCompatResources.getDrawable(this.f8909c.getContext(), N1.e.core_vector_folder);
            } else {
                TextView textView = this.f8911e;
                W1.i iVar = new W1.i();
                Context context = this.itemView.getContext();
                m.d(context, "itemView.context");
                textView.setText(iVar.d(j4, context));
                if (m3.m.o(str2, ".apk", false, 2, (Object) null)) {
                    D d5 = D.f8459a;
                    if (d5.a().get(str2) != null) {
                        drawable = (Drawable) d5.a().get(str2);
                    } else {
                        drawable = AppCompatResources.getDrawable(this.f8909c.getContext(), N1.e.core_vector_apk);
                    }
                } else if (m3.m.o(str2, ".xapk", false, 2, (Object) null) || m3.m.o(str2, ".apks", false, 2, (Object) null)) {
                    drawable = AppCompatResources.getDrawable(this.f8909c.getContext(), N1.e.core_vector_xapk);
                } else if (m3.m.o(str2, ".zip", false, 2, (Object) null)) {
                    drawable = AppCompatResources.getDrawable(this.f8909c.getContext(), N1.e.core_vector_zip);
                } else {
                    drawable = AppCompatResources.getDrawable(this.f8909c.getContext(), N1.e.core_vector_file);
                }
            }
            this.f8908b.setImageDrawable(drawable);
        }
        if (str != null) {
            this.f8910d.setText(str);
        }
        if (z4) {
            this.f8912f.setVisibility(0);
            this.f8911e.setVisibility(4);
            this.f8912f.setChecked(z5);
            return;
        }
        this.f8912f.setVisibility(8);
        this.f8911e.setVisibility(0);
    }
}
