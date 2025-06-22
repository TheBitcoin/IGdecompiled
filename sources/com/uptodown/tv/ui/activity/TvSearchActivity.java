package com.uptodown.tv.ui.activity;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import com.uptodown.R;
import kotlin.jvm.internal.m;
import q2.C2209b;

public final class TvSearchActivity extends C2209b {

    /* renamed from: b  reason: collision with root package name */
    private SpeechRecognizer f19299b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_search_activity);
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            this.f19299b = SpeechRecognizer.createSpeechRecognizer(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.f19299b != null && SpeechRecognizer.isRecognitionAvailable(this)) {
            SpeechRecognizer speechRecognizer = this.f19299b;
            m.b(speechRecognizer);
            speechRecognizer.stopListening();
            SpeechRecognizer speechRecognizer2 = this.f19299b;
            m.b(speechRecognizer2);
            speechRecognizer2.cancel();
            SpeechRecognizer speechRecognizer3 = this.f19299b;
            m.b(speechRecognizer3);
            speechRecognizer3.destroy();
        }
        this.f19299b = null;
        super.onPause();
    }
}
