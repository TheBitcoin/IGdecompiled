package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.tools.af;

public abstract class MBBaseActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Display f11803a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OrientationEventListener f11804b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f11805c = -1;

    static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        AnonymousClass2 r02 = new OrientationEventListener(mBBaseActivity, 1) {
            public final void onOrientationChanged(int i4) {
                int i5;
                if (MBBaseActivity.this.f11803a != null) {
                    i5 = MBBaseActivity.this.f11803a.getRotation();
                } else {
                    i5 = 0;
                }
                if (i5 == 1 && MBBaseActivity.this.f11805c != 1) {
                    int unused = MBBaseActivity.this.f11805c = 1;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Left");
                } else if (i5 == 3 && MBBaseActivity.this.f11805c != 2) {
                    int unused2 = MBBaseActivity.this.f11805c = 2;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Right");
                } else if (i5 == 0 && MBBaseActivity.this.f11805c != 3) {
                    int unused3 = MBBaseActivity.this.f11805c = 3;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Top");
                } else if (i5 == 2 && MBBaseActivity.this.f11805c != 4) {
                    int unused4 = MBBaseActivity.this.f11805c = 4;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f11804b = r02;
        if (r02.canDetectOrientation()) {
            mBBaseActivity.f11804b.enable();
            return;
        }
        mBBaseActivity.f11804b.disable();
        mBBaseActivity.f11804b = null;
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            public final void run() {
                int i4;
                int i5;
                int i6;
                DisplayCutout a5;
                int i7;
                int i8;
                try {
                    int i9 = Build.VERSION.SDK_INT;
                    if (i9 >= 23) {
                        WindowInsets a6 = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                        int i10 = -1;
                        int i11 = 0;
                        if (a6 == null || i9 < 28 || (a5 = a6.getDisplayCutout()) == null) {
                            i6 = 0;
                            i5 = 0;
                            i4 = 0;
                        } else {
                            int a7 = a5.getSafeInsetLeft();
                            i6 = a5.getSafeInsetRight();
                            i5 = a5.getSafeInsetTop();
                            int a8 = a5.getSafeInsetBottom();
                            af.b("MBBaseActivity", "NOTCH Left:" + a7 + " Right:" + i6 + " Top:" + i5 + " Bottom:" + a8);
                            if (MBBaseActivity.this.f11803a != null) {
                                i7 = MBBaseActivity.this.f11803a.getRotation();
                            } else {
                                i7 = MBBaseActivity.this.b();
                            }
                            if (MBBaseActivity.this.f11805c == -1) {
                                MBBaseActivity mBBaseActivity = MBBaseActivity.this;
                                if (i7 == 0) {
                                    i8 = 3;
                                } else if (i7 == 1) {
                                    i8 = 1;
                                } else if (i7 == 2) {
                                    i8 = 4;
                                } else if (i7 == 3) {
                                    i8 = 2;
                                } else {
                                    i8 = -1;
                                }
                                int unused = mBBaseActivity.f11805c = i8;
                                af.b("MBBaseActivity", MBBaseActivity.this.f11805c + "");
                            }
                            if (i7 != 0) {
                                if (i7 == 1) {
                                    i10 = 90;
                                } else if (i7 == 2) {
                                    i10 = SubsamplingScaleImageView.ORIENTATION_180;
                                } else if (i7 == 3) {
                                    i10 = SubsamplingScaleImageView.ORIENTATION_270;
                                }
                                i4 = a8;
                                i11 = a7;
                            } else {
                                i4 = a8;
                                i11 = a7;
                                i10 = 0;
                            }
                        }
                        MBBaseActivity.this.setTopControllerPadding(i10, i11, i6, i5, i4);
                        if (MBBaseActivity.this.f11804b == null) {
                            MBBaseActivity.e(MBBaseActivity.this);
                        }
                    }
                } catch (Exception e5) {
                    af.b("MBBaseActivity", e5.getMessage());
                }
            }
        }, 500);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            a();
            b();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e5) {
            af.b("MBBaseActivity", e5.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f11804b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f11804b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!b.f12876c) {
            getNotchParams();
            a();
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        a();
    }

    public abstract void setTopControllerPadding(int i4, int i5, int i6, int i7, int i8);

    /* access modifiers changed from: private */
    public int b() {
        if (this.f11803a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f11803a = getDisplay();
            } else {
                this.f11803a = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f11803a;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    private void a() {
        try {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            af.b("MBBaseActivity", th.getMessage());
        }
    }
}
