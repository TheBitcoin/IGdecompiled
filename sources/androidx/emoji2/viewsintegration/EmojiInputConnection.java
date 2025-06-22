package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiInputConnection extends InputConnectionWrapper {
    private final EmojiCompatDeleteHelper mEmojiCompatDeleteHelper;
    private final TextView mTextView;

    public static class EmojiCompatDeleteHelper {
        public boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5, boolean z4) {
            return EmojiCompat.handleDeleteSurroundingText(inputConnection, editable, i4, i5, z4);
        }

        public void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().updateEditorInfo(editorInfo);
            }
        }
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    private Editable getEditable() {
        return this.mTextView.getEditableText();
    }

    public boolean deleteSurroundingText(int i4, int i5) {
        int i6 = i4;
        int i7 = i5;
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i6, i7, false) || super.deleteSurroundingText(i6, i7)) {
            return true;
        }
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i4, int i5) {
        int i6 = i4;
        int i7 = i5;
        if (this.mEmojiCompatDeleteHelper.handleDeleteSurroundingText(this, getEditable(), i6, i7, true) || super.deleteSurroundingTextInCodePoints(i6, i7)) {
            return true;
        }
        return false;
    }

    EmojiInputConnection(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.mTextView = textView;
        this.mEmojiCompatDeleteHelper = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.updateEditorInfoAttrs(editorInfo);
    }
}
