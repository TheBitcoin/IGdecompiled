package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;

public class MBridgeVastEndCardView extends MBridgeBaseView {

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f16410m;

    /* renamed from: n  reason: collision with root package name */
    private View f16411n;

    /* renamed from: o  reason: collision with root package name */
    private View f16412o;

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f16242e) {
            this.f16411n.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeVastEndCardView.this.notifyListener.a(104, "");
                }
            });
            this.f16412o.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    MBridgeVastEndCardView mBridgeVastEndCardView = MBridgeVastEndCardView.this;
                    mBridgeVastEndCardView.notifyListener.a(108, mBridgeVastEndCardView.d());
                }
            });
        }
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_vast");
        if (findLayout >= 0) {
            this.f16240c.inflate(findLayout, this);
            this.f16410m = (ViewGroup) findViewById(findID("mbridge_rl_content"));
            this.f16411n = findViewById(findID("mbridge_iv_vastclose"));
            View findViewById = findViewById(findID("mbridge_iv_vastok"));
            this.f16412o = findViewById;
            this.f16242e = isNotNULL(this.f16410m, this.f16411n, findViewById);
            c();
            if (this.f16242e) {
                setMatchParent();
                setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.f16410m.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.notifyListener.a(111, "");
    }

    public void preLoadData(b bVar) {
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
