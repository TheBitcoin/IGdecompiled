package e4;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.m;
import z3.f;

public final class a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public List f24593a;

    /* renamed from: b  reason: collision with root package name */
    public b f24594b;

    /* renamed from: c  reason: collision with root package name */
    public String f24595c;

    /* renamed from: d  reason: collision with root package name */
    public String f24596d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f24597e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f24598f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f24599g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f24600h;

    /* renamed from: i  reason: collision with root package name */
    public Typeface f24601i;

    /* renamed from: j  reason: collision with root package name */
    public Typeface f24602j;

    /* renamed from: e4.a$a  reason: collision with other inner class name */
    public static final class C0293a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f24603a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f24604b;

        /* renamed from: c  reason: collision with root package name */
        public final Typeface f24605c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f24606d;

        /* renamed from: e  reason: collision with root package name */
        public final View f24607e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0293a(View view, Integer num, Integer num2, Typeface typeface) {
            super(view);
            m.e(view, "rootView");
            this.f24603a = num;
            this.f24604b = num2;
            this.f24605c = typeface;
            View findViewById = view.findViewById(A1.b.tv_non_switch_label);
            m.d(findViewById, "rootView.findViewById(R.id.tv_non_switch_label)");
            this.f24606d = (TextView) findViewById;
            View findViewById2 = view.findViewById(A1.b.item_divider);
            m.d(findViewById2, "rootView.findViewById(R.id.item_divider)");
            this.f24607e = findViewById2;
        }
    }

    public interface b {
        void d(d dVar);

        void f(d dVar);
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f24608a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f24609b;

        /* renamed from: c  reason: collision with root package name */
        public final Typeface f24610c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f24611d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view, Integer num, Integer num2, Typeface typeface) {
            super(view);
            m.e(view, "rootView");
            this.f24608a = num;
            this.f24609b = num2;
            this.f24610c = typeface;
            View findViewById = view.findViewById(A1.b.tv_switch_description);
            m.d(findViewById, "rootView.findViewById(R.id.tv_switch_description)");
            this.f24611d = (TextView) findViewById;
        }
    }

    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f24612a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f24613b;

        /* renamed from: c  reason: collision with root package name */
        public final Typeface f24614c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f24615d;

        /* renamed from: e  reason: collision with root package name */
        public final View f24616e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(View view, Integer num, Integer num2, Typeface typeface) {
            super(view);
            m.e(view, "rootView");
            this.f24612a = num;
            this.f24613b = num2;
            this.f24614c = typeface;
            View findViewById = view.findViewById(A1.b.tv_switch_label);
            m.d(findViewById, "rootView.findViewById(R.id.tv_switch_label)");
            this.f24615d = (TextView) findViewById;
            View findViewById2 = view.findViewById(A1.b.item_divider);
            m.d(findViewById2, "rootView.findViewById(R.id.item_divider)");
            this.f24616e = findViewById2;
        }
    }

    public static final class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final b f24617a;

        /* renamed from: b  reason: collision with root package name */
        public final Integer f24618b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f24619c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f24620d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f24621e;

        /* renamed from: f  reason: collision with root package name */
        public final Typeface f24622f;

        /* renamed from: g  reason: collision with root package name */
        public final TextView f24623g;

        /* renamed from: h  reason: collision with root package name */
        public final SwitchCompat f24624h;

        /* renamed from: i  reason: collision with root package name */
        public final View f24625i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(View view, b bVar, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface) {
            super(view);
            m.e(view, "rootView");
            m.e(bVar, "listener");
            this.f24617a = bVar;
            this.f24618b = num;
            this.f24619c = num2;
            this.f24620d = num3;
            this.f24621e = num4;
            this.f24622f = typeface;
            View findViewById = view.findViewById(A1.b.tv_switch_name);
            m.d(findViewById, "rootView.findViewById(R.id.tv_switch_name)");
            this.f24623g = (TextView) findViewById;
            View findViewById2 = view.findViewById(A1.b.switch_item);
            m.d(findViewById2, "rootView.findViewById(R.id.switch_item)");
            this.f24624h = (SwitchCompat) findViewById2;
            View findViewById3 = view.findViewById(A1.b.line_item);
            m.d(findViewById3, "rootView.findViewById(R.id.line_item)");
            this.f24625i = findViewById3;
        }

        public static final void a(e eVar, d dVar, View view) {
            m.e(eVar, "this$0");
            m.e(dVar, "$switchItem");
            eVar.f24617a.f(dVar);
        }

        public static final void b(d dVar, e eVar, String str, CompoundButton compoundButton, boolean z4) {
            m.e(dVar, "$switchItem");
            m.e(eVar, "this$0");
            m.e(str, "$tag");
            dVar.f24632b = Boolean.valueOf(z4);
            eVar.f24617a.d(dVar);
            boolean z5 = dVar.f24635e;
            SwitchCompat switchCompat = eVar.f24624h;
            if (switchCompat.isChecked() || !z5) {
                str = "";
            }
            switchCompat.setText(str);
        }

        public final void c(d dVar, String str) {
            String str2;
            boolean z4;
            m.e(dVar, "switchItem");
            m.e(str, "tag");
            TextView textView = this.f24623g;
            String str3 = dVar.f24631a.f4813b;
            Integer num = dVar.f24637g;
            String str4 = dVar.f24636f;
            m.e(str3, RewardPlus.NAME);
            m.e(str4, "noun");
            if (num != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(" (");
                sb.append(num);
                sb.append(' ');
                String lowerCase = str4.toLowerCase(Locale.ROOT);
                m.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                sb.append(lowerCase);
                sb.append(')');
                str3 = sb.toString();
            }
            textView.setText(str3);
            Integer num2 = this.f24618b;
            if (num2 != null) {
                textView.setTextColor(num2.intValue());
            }
            textView.setOnClickListener(new b(this, dVar));
            Typeface typeface = this.f24622f;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            SwitchCompat switchCompat = this.f24624h;
            if (dVar.f24632b == null) {
                switchCompat.setVisibility(8);
            } else {
                switchCompat.setVisibility(0);
                Boolean bool = dVar.f24632b;
                if (bool == null) {
                    z4 = false;
                } else {
                    z4 = bool.booleanValue();
                }
                switchCompat.setChecked(z4);
            }
            switchCompat.setContentDescription(dVar.f24631a.f4813b);
            boolean z5 = dVar.f24635e;
            SwitchCompat switchCompat2 = this.f24624h;
            if (switchCompat2.isChecked() || !z5) {
                str2 = "";
            } else {
                str2 = str;
            }
            switchCompat2.setText(str2);
            switchCompat.setOnCheckedChangeListener(new c(dVar, this, str));
            Integer num3 = this.f24619c;
            if (num3 != null) {
                int intValue = num3.intValue();
                Integer num4 = this.f24620d;
                if (num4 != null) {
                    int intValue2 = num4.intValue();
                    switchCompat.setThumbTintList(new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{intValue, intValue2}));
                    switchCompat.setTrackTintList(new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{ColorUtils.setAlphaComponent(intValue, 128), ColorUtils.setAlphaComponent(intValue2, 128)}));
                }
            }
            Integer num5 = this.f24618b;
            if (num5 != null) {
                switchCompat.setTextColor(num5.intValue());
            }
            Typeface typeface2 = this.f24622f;
            if (typeface2 != null) {
                switchCompat.setTypeface(typeface2);
            }
            Integer num6 = this.f24621e;
            if (num6 != null) {
                this.f24625i.setBackgroundColor(num6.intValue());
            }
        }
    }

    public /* synthetic */ a(List list, b bVar, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface, Typeface typeface2, int i4) {
        Typeface typeface3;
        b bVar2;
        List list2;
        a aVar;
        int i5 = i4;
        String str3 = (i5 & 4) != 0 ? "" : str;
        String str4 = (i5 & 8) != 0 ? "" : null;
        Integer num5 = (i5 & 16) != 0 ? null : num;
        Integer num6 = (i5 & 32) != 0 ? null : num2;
        Integer num7 = (i5 & 64) != 0 ? null : num3;
        Integer num8 = (i5 & 128) != 0 ? null : num4;
        Typeface typeface4 = (i5 & 256) != 0 ? null : typeface;
        if ((i5 & 512) != 0) {
            typeface3 = null;
            list2 = list;
            bVar2 = bVar;
            aVar = this;
        } else {
            typeface3 = typeface2;
            aVar = this;
            list2 = list;
            bVar2 = bVar;
        }
        new a(list2, bVar2, str3, str4, num5, num6, num7, num8, typeface4, typeface3);
    }

    public final void a() {
        this.f24593a.add(0, new d(new f(0, (String) null, 3), (Boolean) null, f.DESCRIPTION, (e) null, false, (String) null, (Integer) null, 122));
    }

    public final void b(List list, boolean z4) {
        m.e(list, "switchItems");
        this.f24593a = list;
        if (!z4) {
            a();
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f24593a.size();
    }

    public int getItemViewType(int i4) {
        return ((d) this.f24593a.get(i4)).f24633c.f24658a;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        m.e(viewHolder, "holder");
        if (viewHolder instanceof e) {
            ((e) viewHolder).c((d) this.f24593a.get(i4), this.f24596d);
        } else if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            String str = this.f24595c;
            cVar.getClass();
            m.e(str, "descriptionText");
            TextView textView = cVar.f24611d;
            textView.setText(str);
            Integer num = cVar.f24608a;
            if (num != null) {
                textView.setTextColor(num.intValue());
            }
            Typeface typeface = cVar.f24610c;
            if (typeface != null) {
                textView.setTypeface(typeface);
            }
            Integer num2 = cVar.f24609b;
            if (num2 != null) {
                int intValue = num2.intValue();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(2.0f);
                gradientDrawable.setStroke(4, intValue);
                textView.setBackground(gradientDrawable);
            }
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            String str2 = ((d) this.f24593a.get(i4)).f24636f;
            dVar.getClass();
            m.e(str2, "labelText");
            TextView textView2 = dVar.f24615d;
            textView2.setText(str2);
            Integer num3 = dVar.f24612a;
            if (num3 != null) {
                textView2.setTextColor(num3.intValue());
            }
            Typeface typeface2 = dVar.f24614c;
            if (typeface2 != null) {
                textView2.setTypeface(typeface2);
            }
            Integer num4 = dVar.f24613b;
            if (num4 != null) {
                dVar.f24616e.setBackgroundColor(num4.intValue());
            }
        } else if (viewHolder instanceof C0293a) {
            C0293a aVar = (C0293a) viewHolder;
            String str3 = ((d) this.f24593a.get(i4)).f24636f;
            aVar.getClass();
            m.e(str3, "labelText");
            TextView textView3 = aVar.f24606d;
            textView3.setText(str3);
            Integer num5 = aVar.f24603a;
            if (num5 != null) {
                textView3.setTextColor(num5.intValue());
            }
            Typeface typeface3 = aVar.f24605c;
            if (typeface3 != null) {
                textView3.setTypeface(typeface3);
            }
            Integer num6 = aVar.f24604b;
            if (num6 != null) {
                aVar.f24607e.setBackgroundColor(num6.intValue());
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        if (i4 == 1) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(A1.c.list_item_switch_description, viewGroup, false);
            m.d(inflate, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new c(inflate, this.f24597e, this.f24600h, this.f24602j);
        } else if (i4 == 2) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(A1.c.list_item_switch_label, viewGroup, false);
            m.d(inflate2, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new d(inflate2, this.f24597e, this.f24600h, this.f24601i);
        } else if (i4 == 3) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(A1.c.list_item_non_switch, viewGroup, false);
            m.d(inflate3, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new C0293a(inflate3, this.f24597e, this.f24600h, this.f24602j);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(A1.c.list_item_switch, viewGroup, false);
            m.d(inflate4, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            return new e(inflate4, this.f24594b, this.f24597e, this.f24598f, this.f24599g, this.f24600h, this.f24602j);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        m.e(viewHolder, "holder");
        if (viewHolder instanceof e) {
            ((e) viewHolder).f24624h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
        super.onViewRecycled(viewHolder);
    }

    public a(List list, b bVar, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Typeface typeface, Typeface typeface2) {
        m.e(list, "switchItems");
        m.e(bVar, "listener");
        m.e(str, "descriptionItemText");
        m.e(str2, "switchTagText");
        this.f24593a = list;
        this.f24594b = bVar;
        this.f24595c = str;
        this.f24596d = str2;
        this.f24597e = num;
        this.f24598f = num2;
        this.f24599g = num3;
        this.f24600h = num4;
        this.f24601i = typeface;
        this.f24602j = typeface2;
        if (str.length() > 0) {
            a();
        }
    }
}
