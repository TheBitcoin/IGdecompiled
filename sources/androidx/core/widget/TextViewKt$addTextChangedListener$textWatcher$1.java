package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import d3.l;
import d3.r;

public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ l $afterTextChanged;
    final /* synthetic */ r $beforeTextChanged;
    final /* synthetic */ r $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(l lVar, r rVar, r rVar2) {
        this.$afterTextChanged = lVar;
        this.$beforeTextChanged = rVar;
        this.$onTextChanged = rVar2;
    }

    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }
}
