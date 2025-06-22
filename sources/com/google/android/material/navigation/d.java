package com.google.android.material.navigation;

import com.google.android.material.motion.MaterialBackOrchestrator;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackOrchestrator f11023a;

    public /* synthetic */ d(MaterialBackOrchestrator materialBackOrchestrator) {
        this.f11023a = materialBackOrchestrator;
    }

    public final void run() {
        this.f11023a.startListeningForBackCallbacksWithPriorityOverlay();
    }
}
