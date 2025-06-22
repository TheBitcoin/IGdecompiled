package androidx.window.layout;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;

@ExperimentalWindowApi
@RestrictTo({RestrictTo.Scope.TESTS})
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    WindowMetricsCalculator decorate(WindowMetricsCalculator windowMetricsCalculator);
}
