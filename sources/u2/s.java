package u2;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.preferences.a;
import g2.L;
import g2.U;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class s extends AbstractAccountAuthenticator {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21926a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context);
        m.e(context, "mContext");
        this.f21926a = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        Intent intent = new Intent(this.f21926a, LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("intent", intent);
        return bundle2;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        m.e(accountAuthenticatorResponse, "response");
        m.e(account, "account");
        m.e(bundle, "options");
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        m.e(accountAuthenticatorResponse, "response");
        m.e(str, "accountType");
        return null;
    }

    public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account) {
        m.e(accountAuthenticatorResponse, "response");
        m.e(account, "account");
        Bundle accountRemovalAllowed = super.getAccountRemovalAllowed(accountAuthenticatorResponse, account);
        if (accountRemovalAllowed != null && accountRemovalAllowed.containsKey("booleanResult") && !accountRemovalAllowed.containsKey("intent") && accountRemovalAllowed.getBoolean("booleanResult")) {
            U.f20468m.b(this.f21926a);
        }
        m.b(accountRemovalAllowed);
        return accountRemovalAllowed;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        String password;
        m.e(accountAuthenticatorResponse, "response");
        m.e(account, "account");
        m.e(str, "authTokenType");
        m.e(bundle, "options");
        AccountManager accountManager = AccountManager.get(this.f21926a);
        String peekAuthToken = accountManager.peekAuthToken(account, str);
        if (TextUtils.isEmpty(peekAuthToken) && (password = accountManager.getPassword(account)) != null) {
            String str2 = account.name;
            L l4 = new L(this.f21926a);
            m.b(str2);
            L K02 = l4.K0(str2, password);
            if (!K02.b() && K02.e() != null) {
                JSONObject e5 = K02.e();
                m.b(e5);
                JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                if (optJSONObject != null) {
                    U u4 = new U();
                    u4.e(this.f21926a, optJSONObject);
                    if (u4.g() != null) {
                        String g4 = u4.g();
                        m.b(g4);
                        if (g4.length() > 0) {
                            u4.p(this.f21926a);
                        }
                    }
                    String J4 = a.f18818a.J(this.f21926a);
                    if (J4 == null || J4.length() == 0) {
                        U.f20468m.b(this.f21926a);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(peekAuthToken)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("authAccount", account.name);
            bundle2.putString("accountType", account.type);
            bundle2.putString("authtoken", peekAuthToken);
            return bundle2;
        }
        Intent intent = new Intent(this.f21926a, LoginActivity.class);
        intent.putExtra("accountAuthenticatorResponse", accountAuthenticatorResponse);
        Bundle bundle3 = new Bundle();
        bundle3.putParcelable("intent", intent);
        return bundle3;
    }

    public String getAuthTokenLabel(String str) {
        m.e(str, "authTokenType");
        return "Uptodown login";
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        m.e(accountAuthenticatorResponse, "response");
        m.e(account, "account");
        m.e(strArr, "features");
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        m.e(accountAuthenticatorResponse, "response");
        m.e(account, "account");
        m.e(str, "authTokenType");
        m.e(bundle, "options");
        return null;
    }
}
