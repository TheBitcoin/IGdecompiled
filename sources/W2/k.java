package w2;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class k implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22035a = new a((C2103g) null);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(TextView textView) {
            m.e(textView, "<this>");
            textView.setOnTouchListener(new k());
        }

        private a() {
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action;
        boolean z4;
        m.e(view, "v");
        m.e(motionEvent, NotificationCompat.CATEGORY_EVENT);
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        m.d(text, "getText(...)");
        if ((text instanceof Spanned) && ((action = motionEvent.getAction()) == 0 || action == 1)) {
            int x4 = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y4 = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x4 + textView.getScrollX();
            int scrollY = y4 + textView.getScrollY();
            Layout layout = textView.getLayout();
            m.d(layout, "getLayout(...)");
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), (float) scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            m.b(clickableSpanArr);
            if (clickableSpanArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            }
        }
        return false;
    }
}
