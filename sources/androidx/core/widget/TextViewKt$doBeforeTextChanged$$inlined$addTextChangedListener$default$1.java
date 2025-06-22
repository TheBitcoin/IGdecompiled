package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import d3.r;

public final class TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ r $beforeTextChanged;

    public TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r rVar) {
        this.$beforeTextChanged = rVar;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
