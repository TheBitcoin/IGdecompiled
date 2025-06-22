package J2;

import J2.f;
import R2.n;
import R2.s;
import V2.d;
import W2.b;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.C0977g;
import o3.E0;
import o3.J;
import o3.Y;

public final class g extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f7255a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f7256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f7257c;

    public static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f7258a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f7259b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, f fVar, d dVar) {
            super(2, dVar);
            this.f7258a = bitmap;
            this.f7259b = fVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f7258a, this.f7259b, dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new a(this.f7258a, this.f7259b, (d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            n.b(obj);
            Bitmap bitmap = this.f7258a;
            if (bitmap != null) {
                f fVar = this.f7259b;
                ImageView imageView = fVar.f7245b;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
                ImageView imageView2 = fVar.f7245b;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            }
            f fVar2 = this.f7259b;
            f.a aVar = f.f7242l;
            fVar2.getClass();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(fVar2.f7244a);
            ImageView imageView3 = fVar2.f7245b;
            if (imageView3 != null && imageView3.getVisibility() == 0) {
                ImageView imageView4 = fVar2.f7245b;
                if (imageView4 != null) {
                    Button button = fVar2.f7246c;
                    if (button != null) {
                        constraintSet.connect(button.getId(), 4, imageView4.getId(), 4);
                    }
                    constraintSet.applyTo(fVar2.f7244a);
                }
            } else {
                TextView textView = fVar2.f7250g;
                if (textView != null) {
                    Button button2 = fVar2.f7246c;
                    if (button2 != null) {
                        constraintSet.connect(button2.getId(), 4, textView.getId(), 4);
                    }
                    constraintSet.applyTo(fVar2.f7244a);
                }
            }
            return s.f8222a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Bitmap bitmap, f fVar, d dVar) {
        super(2, dVar);
        this.f7256b = bitmap;
        this.f7257c = fVar;
    }

    public final d create(Object obj, d dVar) {
        return new g(this.f7256b, this.f7257c, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new g(this.f7256b, this.f7257c, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f7255a;
        if (i4 == 0) {
            n.b(obj);
            E0 D4 = Y.c().D();
            a aVar = new a(this.f7256b, this.f7257c, (d) null);
            this.f7255a = 1;
            if (C0977g.g(D4, aVar, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s.f8222a;
    }
}
