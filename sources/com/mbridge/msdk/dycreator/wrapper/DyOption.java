package com.mbridge.msdk.dycreator.wrapper;

import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.List;

public class DyOption {

    /* renamed from: a  reason: collision with root package name */
    private List<String> f12665a;

    /* renamed from: b  reason: collision with root package name */
    private File f12666b;

    /* renamed from: c  reason: collision with root package name */
    private CampaignEx f12667c;

    /* renamed from: d  reason: collision with root package name */
    private DyAdType f12668d;

    /* renamed from: e  reason: collision with root package name */
    private String f12669e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12670f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12671g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12672h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12673i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12674j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12675k;

    /* renamed from: l  reason: collision with root package name */
    private int f12676l;

    /* renamed from: m  reason: collision with root package name */
    private int f12677m;

    /* renamed from: n  reason: collision with root package name */
    private int f12678n;

    /* renamed from: o  reason: collision with root package name */
    private int f12679o;

    /* renamed from: p  reason: collision with root package name */
    private int f12680p;

    /* renamed from: q  reason: collision with root package name */
    private int f12681q;

    /* renamed from: r  reason: collision with root package name */
    private DyCountDownListenerWrapper f12682r;

    public static class Builder implements IViewOptionBuilder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<String> f12683a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public File f12684b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CampaignEx f12685c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public DyAdType f12686d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f12687e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f12688f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f12689g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f12690h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f12691i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public boolean f12692j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f12693k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f12694l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f12695m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f12696n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f12697o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f12698p;

        public IViewOptionBuilder adChoiceLink(String str) {
            this.f12688f = str;
            return this;
        }

        public DyOption build() {
            return new DyOption(this);
        }

        public IViewOptionBuilder campaignEx(CampaignEx campaignEx) {
            this.f12685c = campaignEx;
            return this;
        }

        public IViewOptionBuilder canSkip(boolean z4) {
            this.f12687e = z4;
            return this;
        }

        public IViewOptionBuilder countDownTime(int i4) {
            this.f12697o = i4;
            return this;
        }

        public IViewOptionBuilder dyAdType(DyAdType dyAdType) {
            this.f12686d = dyAdType;
            return this;
        }

        public IViewOptionBuilder file(File file) {
            this.f12684b = file;
            return this;
        }

        public IViewOptionBuilder fileDirs(List<String> list) {
            this.f12683a = list;
            return this;
        }

        public IViewOptionBuilder isApkInfoVisible(boolean z4) {
            this.f12692j = z4;
            return this;
        }

        public IViewOptionBuilder isClickButtonVisible(boolean z4) {
            this.f12690h = z4;
            return this;
        }

        public IViewOptionBuilder isLogoVisible(boolean z4) {
            this.f12693k = z4;
            return this;
        }

        public IViewOptionBuilder isScreenClick(boolean z4) {
            this.f12689g = z4;
            return this;
        }

        public IViewOptionBuilder isShakeVisible(boolean z4) {
            this.f12691i = z4;
            return this;
        }

        public IViewOptionBuilder orientation(int i4) {
            this.f12696n = i4;
            return this;
        }

        public IViewOptionBuilder shakeStrenght(int i4) {
            this.f12694l = i4;
            return this;
        }

        public IViewOptionBuilder shakeTime(int i4) {
            this.f12695m = i4;
            return this;
        }

        public IViewOptionBuilder templateType(int i4) {
            this.f12698p = i4;
            return this;
        }
    }

    public interface IViewOptionBuilder {
        IViewOptionBuilder adChoiceLink(String str);

        DyOption build();

        IViewOptionBuilder campaignEx(CampaignEx campaignEx);

        IViewOptionBuilder canSkip(boolean z4);

        IViewOptionBuilder countDownTime(int i4);

        IViewOptionBuilder dyAdType(DyAdType dyAdType);

        IViewOptionBuilder file(File file);

        IViewOptionBuilder fileDirs(List<String> list);

        IViewOptionBuilder isApkInfoVisible(boolean z4);

        IViewOptionBuilder isClickButtonVisible(boolean z4);

        IViewOptionBuilder isLogoVisible(boolean z4);

        IViewOptionBuilder isScreenClick(boolean z4);

        IViewOptionBuilder isShakeVisible(boolean z4);

        IViewOptionBuilder orientation(int i4);

        IViewOptionBuilder shakeStrenght(int i4);

        IViewOptionBuilder shakeTime(int i4);

        IViewOptionBuilder templateType(int i4);
    }

    public DyOption(Builder builder) {
        this.f12665a = builder.f12683a;
        this.f12666b = builder.f12684b;
        this.f12667c = builder.f12685c;
        this.f12668d = builder.f12686d;
        this.f12671g = builder.f12687e;
        this.f12669e = builder.f12688f;
        this.f12670f = builder.f12689g;
        this.f12672h = builder.f12690h;
        this.f12674j = builder.f12692j;
        this.f12673i = builder.f12691i;
        this.f12675k = builder.f12693k;
        this.f12676l = builder.f12694l;
        this.f12677m = builder.f12695m;
        this.f12678n = builder.f12696n;
        this.f12679o = builder.f12697o;
        this.f12681q = builder.f12698p;
    }

    public String getAdChoiceLink() {
        return this.f12669e;
    }

    public CampaignEx getCampaignEx() {
        return this.f12667c;
    }

    public int getCountDownTime() {
        return this.f12679o;
    }

    public int getCurrentCountDown() {
        return this.f12680p;
    }

    public DyAdType getDyAdType() {
        return this.f12668d;
    }

    public File getFile() {
        return this.f12666b;
    }

    public List<String> getFileDirs() {
        return this.f12665a;
    }

    public int getOrientation() {
        return this.f12678n;
    }

    public int getShakeStrenght() {
        return this.f12676l;
    }

    public int getShakeTime() {
        return this.f12677m;
    }

    public int getTemplateType() {
        return this.f12681q;
    }

    public boolean isApkInfoVisible() {
        return this.f12674j;
    }

    public boolean isCanSkip() {
        return this.f12671g;
    }

    public boolean isClickButtonVisible() {
        return this.f12672h;
    }

    public boolean isClickScreen() {
        return this.f12670f;
    }

    public boolean isLogoVisible() {
        return this.f12675k;
    }

    public boolean isShakeVisible() {
        return this.f12673i;
    }

    public void setDyCountDownListener(int i4) {
        DyCountDownListenerWrapper dyCountDownListenerWrapper = this.f12682r;
        if (dyCountDownListenerWrapper != null) {
            dyCountDownListenerWrapper.getCountDownValue(i4);
        }
        this.f12680p = i4;
    }

    public void setDyCountDownListenerWrapper(DyCountDownListenerWrapper dyCountDownListenerWrapper) {
        this.f12682r = dyCountDownListenerWrapper;
    }
}
