package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';
    @GuardedBy("sLock")
    @NonNull
    private static Executor sExecutor;
    private static final Object sLock = new Object();
    @NonNull
    private final int[] mParagraphEnds;
    @NonNull
    private final Params mParams;
    @NonNull
    private final Spannable mText;
    @Nullable
    private final PrecomputedText mWrapped;

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Spannable castToSpannable(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(@NonNull Params params, @NonNull CharSequence charSequence) {
                this.mParams = params;
                this.mText = charSequence;
            }

            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }
        }

        PrecomputedTextFutureTask(@NonNull Params params, @NonNull CharSequence charSequence) {
            super(new PrecomputedTextCallback(params, charSequence));
        }
    }

    private PrecomputedTextCompat(@NonNull CharSequence charSequence, @NonNull Params params, @NonNull int[] iArr) {
        this.mText = new SpannableString(charSequence);
        this.mParams = params;
        this.mParagraphEnds = iArr;
        this.mWrapped = null;
    }

    @SuppressLint({"WrongConstant"})
    public static PrecomputedTextCompat create(@NonNull CharSequence charSequence, @NonNull Params params) {
        CharSequence charSequence2;
        PrecomputedText.Params params2;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(params);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT < 29 || (params2 = params.mWrapped) == null) {
                ArrayList arrayList = new ArrayList();
                int length = charSequence.length();
                int i4 = 0;
                while (i4 < length) {
                    int indexOf = TextUtils.indexOf(charSequence, LINE_FEED, i4, length);
                    if (indexOf < 0) {
                        i4 = length;
                    } else {
                        i4 = indexOf + 1;
                    }
                    arrayList.add(Integer.valueOf(i4));
                }
                int[] iArr = new int[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    StaticLayout unused = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = charSequence;
                    new StaticLayout(charSequence2, params.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
                PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence2, params, iArr);
                Trace.endSection();
                return precomputedTextCompat;
            }
            PrecomputedTextCompat precomputedTextCompat2 = new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            Trace.endSection();
            return precomputedTextCompat2;
        } catch (Throwable th) {
            Throwable th2 = th;
            Trace.endSection();
            throw th2;
        }
    }

    @UiThread
    public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence charSequence, @NonNull Params params, @Nullable Executor executor) {
        PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextFutureTask(params, charSequence);
        if (executor == null) {
            synchronized (sLock) {
                try {
                    if (sExecutor == null) {
                        sExecutor = Executors.newFixedThreadPool(1);
                    }
                    executor = sExecutor;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        executor.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    public char charAt(int i4) {
        return this.mText.charAt(i4);
    }

    @IntRange(from = 0)
    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphCount();
        }
        return this.mParagraphEnds.length;
    }

    @IntRange(from = 0)
    public int getParagraphEnd(@IntRange(from = 0) int i4) {
        Preconditions.checkArgumentInRange(i4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphEnd(i4);
        }
        return this.mParagraphEnds[i4];
    }

    @IntRange(from = 0)
    public int getParagraphStart(@IntRange(from = 0) int i4) {
        Preconditions.checkArgumentInRange(i4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(i4);
        }
        if (i4 == 0) {
            return 0;
        }
        return this.mParagraphEnds[i4 - 1];
    }

    @NonNull
    public Params getParams() {
        return this.mParams;
    }

    @RequiresApi(28)
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PrecomputedText getPrecomputedText() {
        if (i.a(this.mText)) {
            return j.a(this.mText);
        }
        return null;
    }

    public int getSpanEnd(Object obj) {
        return this.mText.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.mText.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.mText.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i4, int i5, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mWrapped.getSpans(i4, i5, cls);
        }
        return this.mText.getSpans(i4, i5, cls);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int i4, int i5, Class cls) {
        return this.mText.nextSpanTransition(i4, i5, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.removeSpan(obj);
        } else {
            this.mText.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i4, int i5, int i6) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.mWrapped.setSpan(obj, i4, i5, i6);
        } else {
            this.mText.setSpan(obj, i4, i5, i6);
        }
    }

    public CharSequence subSequence(int i4, int i5) {
        return this.mText.subSequence(i4, i5);
    }

    @NonNull
    public String toString() {
        return this.mText.toString();
    }

    @RequiresApi(28)
    private PrecomputedTextCompat(@NonNull PrecomputedText precomputedText, @NonNull Params params) {
        this.mText = Api28Impl.castToSpannable(precomputedText);
        this.mParams = params;
        this.mParagraphEnds = null;
        this.mWrapped = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        @NonNull
        private final TextPaint mPaint;
        @Nullable
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;
            @NonNull
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(@NonNull TextPaint textPaint) {
                this.mPaint = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.mBreakStrategy = 1;
                    this.mHyphenationFrequency = 1;
                } else {
                    this.mHyphenationFrequency = 0;
                    this.mBreakStrategy = 0;
                }
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            @NonNull
            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            @RequiresApi(23)
            public Builder setBreakStrategy(int i4) {
                this.mBreakStrategy = i4;
                return this;
            }

            @RequiresApi(23)
            public Builder setHyphenationFrequency(int i4) {
                this.mHyphenationFrequency = i4;
                return this;
            }

            public Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
                this.mTextDir = textDirectionHeuristic;
                return this;
            }
        }

        Params(@NonNull TextPaint textPaint, @NonNull TextDirectionHeuristic textDirectionHeuristic, int i4, int i5) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mWrapped = o.a(textPaint).setBreakStrategy(i4).setHyphenationFrequency(i5).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.mWrapped = null;
            }
            this.mPaint = textPaint;
            this.mTextDir = textDirectionHeuristic;
            this.mBreakStrategy = i4;
            this.mHyphenationFrequency = i5;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (equalsWithoutTextDirection(params) && this.mTextDir == params.getTextDirection()) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean equalsWithoutTextDirection(@NonNull Params params) {
            int i4 = Build.VERSION.SDK_INT;
            if ((i4 >= 23 && (this.mBreakStrategy != params.getBreakStrategy() || this.mHyphenationFrequency != params.getHyphenationFrequency())) || this.mPaint.getTextSize() != params.getTextPaint().getTextSize() || this.mPaint.getTextScaleX() != params.getTextPaint().getTextScaleX() || this.mPaint.getTextSkewX() != params.getTextPaint().getTextSkewX() || this.mPaint.getLetterSpacing() != params.getTextPaint().getLetterSpacing() || !TextUtils.equals(this.mPaint.getFontFeatureSettings(), params.getTextPaint().getFontFeatureSettings()) || this.mPaint.getFlags() != params.getTextPaint().getFlags()) {
                return false;
            }
            if (i4 >= 24) {
                if (!this.mPaint.getTextLocales().equals(params.getTextPaint().getTextLocales())) {
                    return false;
                }
            } else if (!this.mPaint.getTextLocale().equals(params.getTextPaint().getTextLocale())) {
                return false;
            }
            if (this.mPaint.getTypeface() == null) {
                if (params.getTextPaint().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.mPaint.getTypeface().equals(params.getTextPaint().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        @RequiresApi(23)
        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        @RequiresApi(23)
        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        @Nullable
        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        @NonNull
        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
            }
            return ObjectsCompat.hash(Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.mPaint.getTextSize());
            sb.append(", textScaleX=" + this.mPaint.getTextScaleX());
            sb.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int i4 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (i4 >= 24) {
                sb.append(", textLocale=" + this.mPaint.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.mPaint.getTextLocale());
            }
            sb.append(", typeface=" + this.mPaint.getTypeface());
            if (i4 >= 26) {
                sb.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.mTextDir);
            sb.append(", breakStrategy=" + this.mBreakStrategy);
            sb.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            sb.append("}");
            return sb.toString();
        }

        @RequiresApi(28)
        public Params(@NonNull PrecomputedText.Params params) {
            this.mPaint = params.getTextPaint();
            this.mTextDir = params.getTextDirection();
            this.mBreakStrategy = params.getBreakStrategy();
            this.mHyphenationFrequency = params.getHyphenationFrequency();
            this.mWrapped = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
