package m3;

import j3.d;
import j3.e;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public abstract class k {
    /* access modifiers changed from: private */
    public static final h d(Matcher matcher, int i4, CharSequence charSequence) {
        if (!matcher.find(i4)) {
            return null;
        }
        return new i(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final d e(MatchResult matchResult) {
        return e.i(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    public static final d f(MatchResult matchResult, int i4) {
        return e.i(matchResult.start(i4), matchResult.end(i4));
    }
}
