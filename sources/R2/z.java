package r2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import g2.S;
import kotlin.jvm.internal.m;
import n2.b;
import p2.l;
import u2.t;
import u2.x;

public final class z extends RowsSupportFragment {

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f21681a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityResultLauncher f21682b;

    public z() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(4);
        listRowPresenter.setShadowEnabled(false);
        this.f21681a = new ArrayObjectAdapter((Presenter) listRowPresenter);
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new w(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f21682b = registerForActivityResult;
    }

    private final void j(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new y());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void l(z zVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof b) {
            int b5 = ((b) obj).b();
            Class<TvMyAppsActivity> cls = TvMyAppsActivity.class;
            if (b5 == 0) {
                Intent intent = new Intent(zVar.getContext(), cls);
                intent.putExtra("updates", true);
                zVar.startActivity(intent);
            } else if (b5 == 1) {
                zVar.startActivity(new Intent(zVar.getContext(), cls));
            } else if (b5 == 2) {
                Intent intent2 = new Intent(zVar.getContext(), cls);
                intent2.putExtra("rollback", true);
                zVar.startActivity(intent2);
            } else if (b5 == 3) {
                zVar.startActivity(new Intent(zVar.getContext(), TvMyDownloadsActivity.class));
            } else if (b5 == 4) {
                zVar.f21682b.launch(new Intent(zVar.getContext(), PreferencesActivity.class));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void m(z zVar, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            t.a aVar = t.f21927u;
            Context requireContext = zVar.requireContext();
            m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            a5.r();
            a5.i();
            String string = zVar.getString(R.string.restart_for_changes_take_effect);
            m.d(string, "getString(...)");
            zVar.j(string);
        } else if (resultCode == 1004) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            Context requireContext2 = zVar.requireContext();
            m.d(requireContext2, "requireContext(...)");
            aVar2.e(requireContext2);
            String string2 = zVar.getString(R.string.restart_for_changes_take_effect);
            m.d(string2, "getString(...)");
            zVar.j(string2);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        BrowseSupportFragment.FragmentHost fragmentHost;
        super.onCreate(bundle);
        if (getContext() != null) {
            x xVar = new x(getContext());
            String simpleName = z.class.getSimpleName();
            m.d(simpleName, "getSimpleName(...)");
            xVar.e(simpleName);
            HeaderItem headerItem = new HeaderItem(getString(R.string.manage_apps));
            S.b bVar = S.f20455j;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            int a5 = bVar.a(requireContext);
            if (a5 > 0) {
                str = " (" + a5 + ')';
            } else {
                str = "";
            }
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new l());
            b bVar2 = new b();
            bVar2.e(0);
            bVar2.f(getString(R.string.updates) + str);
            bVar2.d(R.drawable.vector_tv_updates);
            arrayObjectAdapter.add(bVar2);
            b bVar3 = new b();
            bVar3.e(1);
            bVar3.f(getString(R.string.installed));
            bVar3.d(R.drawable.vector_tv_installed);
            arrayObjectAdapter.add(bVar3);
            b bVar4 = new b();
            bVar4.e(2);
            bVar4.f(getString(R.string.rollback_title));
            bVar4.d(R.drawable.vector_tv_rollback);
            arrayObjectAdapter.add(bVar4);
            b bVar5 = new b();
            bVar5.e(3);
            bVar5.f(getString(R.string.downloads_title));
            bVar5.d(R.drawable.vector_tv_downloads);
            arrayObjectAdapter.add(bVar5);
            b bVar6 = new b();
            bVar6.e(4);
            bVar6.f(getString(R.string.settings));
            bVar6.d(R.drawable.vector_tv_settings);
            arrayObjectAdapter.add(bVar6);
            this.f21681a.add(new ListRow(headerItem, arrayObjectAdapter));
            setAdapter(this.f21681a);
            BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = getMainFragmentAdapter();
            if (mainFragmentAdapter != null && (fragmentHost = mainFragmentAdapter.getFragmentHost()) != null) {
                fragmentHost.notifyDataReady(getMainFragmentAdapter());
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new x(this));
    }
}
