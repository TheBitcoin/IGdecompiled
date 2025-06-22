package D2;

import A1.b;
import A1.c;
import V3.C2592c;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import d4.d;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class e extends d4.a {

    /* renamed from: o  reason: collision with root package name */
    public static final a f6291o = new a();

    /* renamed from: p  reason: collision with root package name */
    public static final String f6292p = e.class.getSimpleName();

    /* renamed from: m  reason: collision with root package name */
    public b f6293m;

    /* renamed from: n  reason: collision with root package name */
    public a f6294n;

    public static final class a {
    }

    public static final void j(e eVar, View view) {
        m.e(eVar, "this$0");
        eVar.dismiss();
    }

    public void onCreate(Bundle bundle) {
        a aVar;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            aVar = null;
        } else {
            aVar = (a) arguments.getParcelable("partner_disclosure_args");
        }
        if (aVar == null) {
            aVar = new a(new ArrayList());
        }
        this.f6294n = aVar;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            m.d(viewModelStore, "viewModelStore");
            this.f6293m = (b) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new c()).get(b.class);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_partners_disclosures, viewGroup, false);
        m.d(inflate, "inflater.inflate(R.layou…osures, container, false)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Integer num;
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(b.rv_disclosures);
        b bVar = null;
        if (recyclerView != null) {
            a aVar = this.f6294n;
            if (aVar == null) {
                m.u("args");
                aVar = null;
            }
            recyclerView.setAdapter(new d(aVar.f6288a));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        TextView textView = this.f24518b;
        if (textView != null) {
            b bVar2 = this.f6293m;
            if (bVar2 == null) {
                m.u("viewModel");
                bVar2 = null;
            }
            textView.setText(bVar2.f6289a.f24207a);
        }
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setOnClickListener(new d(this));
            b bVar3 = this.f6293m;
            if (bVar3 == null) {
                m.u("viewModel");
            } else {
                bVar = bVar3;
            }
            imageView.setContentDescription(bVar.f6289a.f24208b);
        }
        C2592c cVar = this.f24526j;
        if (cVar != null && (num = cVar.f24069g) != null) {
            view.setBackgroundColor(num.intValue());
        }
    }
}
