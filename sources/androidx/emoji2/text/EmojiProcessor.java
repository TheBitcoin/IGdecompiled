package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;
import java.util.Set;

@RequiresApi(19)
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    @Nullable
    private final int[] mEmojiAsDefaultStyleExceptions;
    @NonNull
    private EmojiCompat.GlyphChecker mGlyphChecker;
    @NonNull
    private final MetadataRepo mMetadataRepo;
    @NonNull
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    @RequiresApi(19)
    private static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
        }

        static int findIndexBackward(CharSequence charSequence, int i4, int i5) {
            int length = charSequence.length();
            if (i4 < 0 || length < i4 || i5 < 0) {
                return -1;
            }
            while (true) {
                boolean z4 = false;
                while (i5 != 0) {
                    i4--;
                    if (i4 >= 0) {
                        char charAt = charSequence.charAt(i4);
                        if (z4) {
                            if (!Character.isHighSurrogate(charAt)) {
                                return -1;
                            }
                            i5--;
                        } else if (!Character.isSurrogate(charAt)) {
                            i5--;
                        } else if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        } else {
                            z4 = true;
                        }
                    } else if (z4) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                return i4;
            }
        }

        static int findIndexForward(CharSequence charSequence, int i4, int i5) {
            int length = charSequence.length();
            if (i4 < 0 || length < i4 || i5 < 0) {
                return -1;
            }
            while (true) {
                boolean z4 = false;
                while (i5 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z4) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i5--;
                            i4 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i5--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z4 = true;
                        }
                    } else if (z4) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    private static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        private final EmojiCompat.SpanFactory mSpanFactory;
        @Nullable
        public UnprecomputeTextOnModificationSpannable spannable;

        EmojiProcessAddSpanCallback(@Nullable UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.spannable = unprecomputeTextOnModificationSpannable;
            this.mSpanFactory = spanFactory;
        }

        public boolean handleEmoji(@NonNull CharSequence charSequence, int i4, int i5, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            Spannable spannable2;
            if (typefaceEmojiRasterizer.isPreferredSystemRender()) {
                return true;
            }
            if (this.spannable == null) {
                if (charSequence instanceof Spannable) {
                    spannable2 = (Spannable) charSequence;
                } else {
                    spannable2 = new SpannableString(charSequence);
                }
                this.spannable = new UnprecomputeTextOnModificationSpannable(spannable2);
            }
            this.spannable.setSpan(this.mSpanFactory.createSpan(typefaceEmojiRasterizer), i4, i5, 33);
            return true;
        }

        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }
    }

    private interface EmojiProcessCallback<T> {
        T getResult();

        boolean handleEmoji(@NonNull CharSequence charSequence, int i4, int i5, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    private static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        public int end = -1;
        private final int mOffset;
        public int start = -1;

        EmojiProcessLookupCallback(int i4) {
            this.mOffset = i4;
        }

        public EmojiProcessLookupCallback getResult() {
            return this;
        }

        public boolean handleEmoji(@NonNull CharSequence charSequence, int i4, int i5, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int i6 = this.mOffset;
            if (i4 <= i6 && i6 < i5) {
                this.start = i4;
                this.end = i5;
                return false;
            } else if (i5 <= i6) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {
        private final String mExclusion;

        MarkExclusionCallback(String str) {
            this.mExclusion = str;
        }

        public MarkExclusionCallback getResult() {
            return this;
        }

        public boolean handleEmoji(@NonNull CharSequence charSequence, int i4, int i5, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i4, i5), this.mExclusion)) {
                return true;
            }
            typefaceEmojiRasterizer.setExclusion(true);
            return false;
        }
    }

    static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(MetadataRepo.Node node, boolean z4, int[] iArr) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z4;
            this.mEmojiAsDefaultStyleExceptions = iArr;
        }

        private static boolean isEmojiStyle(int i4) {
            return i4 == 65039;
        }

        private static boolean isTextStyle(int i4) {
            return i4 == 65038;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int check(int i4) {
            MetadataRepo.Node node = this.mCurrentNode.get(i4);
            int i5 = 2;
            if (this.mState != 2) {
                if (node == null) {
                    i5 = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = node;
                    this.mCurrentDepth = 1;
                }
            } else if (node != null) {
                this.mCurrentNode = node;
                this.mCurrentDepth++;
            } else if (isTextStyle(i4)) {
                i5 = reset();
            } else if (!isEmojiStyle(i4)) {
                if (this.mCurrentNode.getData() != null) {
                    i5 = 3;
                    if (this.mCurrentDepth != 1) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else {
                        i5 = reset();
                    }
                } else {
                    i5 = reset();
                }
            }
            this.mLastCodepoint = i4;
            return i5;
        }

        /* access modifiers changed from: package-private */
        public TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        /* access modifiers changed from: package-private */
        public TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        /* access modifiers changed from: package-private */
        public boolean isInFlushableState() {
            if (this.mState != 2 || this.mCurrentNode.getData() == null) {
                return false;
            }
            if (this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                return true;
            }
            return false;
        }
    }

    EmojiProcessor(@NonNull MetadataRepo metadataRepo, @NonNull EmojiCompat.SpanFactory spanFactory, @NonNull EmojiCompat.GlyphChecker glyphChecker, boolean z4, @Nullable int[] iArr, @NonNull Set<int[]> set) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = z4;
        this.mEmojiAsDefaultStyleExceptions = iArr;
        initExclusions(set);
    }

    private static boolean delete(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z4) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i4 = 0;
            while (i4 < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i4];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z4 || spanStart != selectionStart) && ((z4 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i4++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5, boolean z4) {
        int i6;
        int i7;
        if (editable != null && inputConnection != null && i4 >= 0 && i5 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (hasInvalidSelection(selectionStart, selectionEnd)) {
                return false;
            }
            if (z4) {
                i7 = CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(i4, 0));
                i6 = CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(i5, 0));
                if (i7 == -1 || i6 == -1) {
                    return false;
                }
            } else {
                i7 = Math.max(selectionStart - i4, 0);
                i6 = Math.min(selectionEnd + i5, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i7, i6, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i7 = Math.min(spanStart, i7);
                    i6 = Math.max(spanEnd, i6);
                }
                int max = Math.max(i7, 0);
                int min = Math.min(i6, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean handleOnKeyDown(@NonNull Editable editable, int i4, @NonNull KeyEvent keyEvent) {
        boolean z4;
        if (i4 == 67) {
            z4 = delete(editable, keyEvent, false);
        } else if (i4 != 112) {
            z4 = false;
        } else {
            z4 = delete(editable, keyEvent, true);
        }
        if (!z4) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean hasGlyph(CharSequence charSequence, int i4, int i5, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.getHasGlyph() == 0) {
            typefaceEmojiRasterizer.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, i4, i5, typefaceEmojiRasterizer.getSdkAdded()));
        }
        if (typefaceEmojiRasterizer.getHasGlyph() == 2) {
            return true;
        }
        return false;
    }

    private static boolean hasInvalidSelection(int i4, int i5) {
        return i4 == -1 || i5 == -1 || i4 != i5;
    }

    private static boolean hasModifiers(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void initExclusions(@NonNull Set<int[]> set) {
        if (!set.isEmpty()) {
            for (int[] next : set) {
                String str = new String(next, 0, next.length);
                process(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getEmojiEnd(@NonNull CharSequence charSequence, @IntRange(from = 0) int i4) {
        if (i4 < 0 || i4 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i4, i4 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanEnd(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i4 - 16), Math.min(charSequence.length(), i4 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i4))).end;
    }

    /* access modifiers changed from: package-private */
    public int getEmojiMatch(@NonNull CharSequence charSequence) {
        return getEmojiMatch(charSequence, this.mMetadataRepo.getMetadataVersion());
    }

    /* access modifiers changed from: package-private */
    public int getEmojiStart(@NonNull CharSequence charSequence, @IntRange(from = 0) int i4) {
        if (i4 < 0 || i4 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i4, i4 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanStart(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i4 - 16), Math.min(charSequence.length(), i4 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i4))).start;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a7, code lost:
        if (r1 != false) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[SYNTHETIC, Splitter:B:21:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069 A[SYNTHETIC, Splitter:B:35:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence process(@androidx.annotation.NonNull java.lang.CharSequence r11, @androidx.annotation.IntRange(from = 0) int r12, @androidx.annotation.IntRange(from = 0) int r13, @androidx.annotation.IntRange(from = 0) int r14, boolean r15) {
        /*
            r10 = this;
            boolean r1 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r1 == 0) goto L_0x000a
            r0 = r11
            androidx.emoji2.text.SpannableBuilder r0 = (androidx.emoji2.text.SpannableBuilder) r0
            r0.beginBatchEdit()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r0 = androidx.emoji2.text.EmojiSpan.class
            if (r1 != 0) goto L_0x0031
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002f
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x002a }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r0)     // Catch:{ all -> 0x002a }
            if (r2 > r13) goto L_0x002f
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x002a }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
            goto L_0x0039
        L_0x002a:
            r0 = move-exception
            r12 = r0
            r3 = r11
            goto L_0x00b7
        L_0x002f:
            r2 = 0
            goto L_0x0039
        L_0x0031:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x00b0 }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x00b0 }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x00b0 }
        L_0x0039:
            r3 = 0
            if (r2 == 0) goto L_0x0065
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r0)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0065
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            if (r5 <= 0) goto L_0x0065
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            r6 = 0
        L_0x0049:
            if (r6 >= r5) goto L_0x0065
            r7 = r4[r6]     // Catch:{ all -> 0x002a }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x002a }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x002a }
            if (r8 == r13) goto L_0x005a
            r2.removeSpan(r7)     // Catch:{ all -> 0x002a }
        L_0x005a:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x002a }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x002a }
            int r6 = r6 + 1
            goto L_0x0049
        L_0x0065:
            r4 = r12
            r5 = r13
            if (r4 == r5) goto L_0x006f
            int r12 = r11.length()     // Catch:{ all -> 0x00b0 }
            if (r4 < r12) goto L_0x0071
        L_0x006f:
            r3 = r11
            goto L_0x00b3
        L_0x0071:
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r12) goto L_0x0084
            if (r2 == 0) goto L_0x0084
            int r12 = r2.length()     // Catch:{ all -> 0x002a }
            java.lang.Object[] r12 = r2.getSpans(r3, r12, r0)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r12 = (androidx.emoji2.text.EmojiSpan[]) r12     // Catch:{ all -> 0x002a }
            int r12 = r12.length     // Catch:{ all -> 0x002a }
            int r14 = r14 - r12
        L_0x0084:
            r6 = r14
            androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback r8 = new androidx.emoji2.text.EmojiProcessor$EmojiProcessAddSpanCallback     // Catch:{ all -> 0x00b0 }
            androidx.emoji2.text.EmojiCompat$SpanFactory r12 = r10.mSpanFactory     // Catch:{ all -> 0x00b0 }
            r8.<init>(r2, r12)     // Catch:{ all -> 0x00b0 }
            r2 = r10
            r3 = r11
            r7 = r15
            java.lang.Object r11 = r2.process(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00a4 }
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r11 = (androidx.emoji2.text.UnprecomputeTextOnModificationSpannable) r11     // Catch:{ all -> 0x00a4 }
            if (r11 == 0) goto L_0x00a7
            android.text.Spannable r11 = r11.getUnwrappedSpannable()     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x00a3
            r12 = r3
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.endBatchEdit()
        L_0x00a3:
            return r11
        L_0x00a4:
            r0 = move-exception
        L_0x00a5:
            r12 = r0
            goto L_0x00b7
        L_0x00a7:
            if (r1 == 0) goto L_0x00af
        L_0x00a9:
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x00af:
            return r3
        L_0x00b0:
            r0 = move-exception
            r3 = r11
            goto L_0x00a5
        L_0x00b3:
            if (r1 == 0) goto L_0x00b6
            goto L_0x00a9
        L_0x00b6:
            return r3
        L_0x00b7:
            if (r1 == 0) goto L_0x00bf
            r11 = r3
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x00bf:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.process(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    /* access modifiers changed from: package-private */
    public int getEmojiMatch(@NonNull CharSequence charSequence, int i4) {
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int length = charSequence.length();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int codePointAt = Character.codePointAt(charSequence, i5);
            int check = processorSm.check(codePointAt);
            TypefaceEmojiRasterizer currentMetadata = processorSm.getCurrentMetadata();
            if (check == 1) {
                i5 += Character.charCount(codePointAt);
                i7 = 0;
            } else if (check == 2) {
                i5 += Character.charCount(codePointAt);
            } else if (check == 3) {
                currentMetadata = processorSm.getFlushMetadata();
                if (currentMetadata.getCompatAdded() <= i4) {
                    i6++;
                }
            }
            if (currentMetadata != null && currentMetadata.getCompatAdded() <= i4) {
                i7++;
            }
        }
        if (i6 != 0) {
            return 2;
        }
        if (!processorSm.isInFlushableState() || processorSm.getCurrentMetadata().getCompatAdded() > i4) {
            return i7 == 0 ? 0 : 2;
        }
        return 1;
    }

    private <T> T process(@NonNull CharSequence charSequence, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5, @IntRange(from = 0) int i6, boolean z4, EmojiProcessCallback<T> emojiProcessCallback) {
        int i7;
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int codePointAt = Character.codePointAt(charSequence, i4);
        int i8 = 0;
        boolean z5 = true;
        loop0:
        while (true) {
            i7 = i4;
            while (i4 < i5 && i8 < i6 && z5) {
                int check = processorSm.check(codePointAt);
                if (check == 1) {
                    i7 += Character.charCount(Character.codePointAt(charSequence, i7));
                    if (i7 < i5) {
                        codePointAt = Character.codePointAt(charSequence, i7);
                    }
                    i4 = i7;
                } else if (check == 2) {
                    i4 += Character.charCount(codePointAt);
                    if (i4 < i5) {
                        codePointAt = Character.codePointAt(charSequence, i4);
                    }
                } else if (check == 3) {
                    if (z4 || !hasGlyph(charSequence, i7, i4, processorSm.getFlushMetadata())) {
                        z5 = emojiProcessCallback.handleEmoji(charSequence, i7, i4, processorSm.getFlushMetadata());
                        i8++;
                    }
                }
            }
        }
        if (processorSm.isInFlushableState() && i8 < i6 && z5 && (z4 || !hasGlyph(charSequence, i7, i4, processorSm.getCurrentMetadata()))) {
            emojiProcessCallback.handleEmoji(charSequence, i7, i4, processorSm.getCurrentMetadata());
        }
        return emojiProcessCallback.getResult();
    }
}
