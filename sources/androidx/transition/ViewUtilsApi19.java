package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi19";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched = false;
    private static Method sSetFrameMethod = null;
    private static boolean sTryHiddenTransitionAlpha = true;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float getTransitionAlpha(View view) {
            return view.getTransitionAlpha();
        }

        @DoNotInline
        static void setTransitionAlpha(View view, float f4) {
            view.setTransitionAlpha(f4);
        }
    }

    ViewUtilsApi19() {
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    private void fetchSetFrame() {
        if (!sSetFrameFetched) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                Log.i(TAG, "Failed to retrieve setFrame method", e5);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
    }

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(@NonNull View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                return Api29Impl.getTransitionAlpha(view);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        int i4;
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.mMatrixValues;
        if (fArr == null) {
            fArr = new float[9];
            this.mMatrixValues = fArr;
        }
        matrix.getValues(fArr);
        float f4 = fArr[3];
        float sqrt = (float) Math.sqrt((double) (1.0f - (f4 * f4)));
        if (fArr[0] < 0.0f) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        float f5 = sqrt * ((float) i4);
        float degrees = (float) Math.toDegrees(Math.atan2((double) f4, (double) f5));
        float f6 = fArr[0] / f5;
        float f7 = fArr[4] / f5;
        float f8 = fArr[2];
        float f9 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f8);
        view.setTranslationY(f9);
        view.setRotation(degrees);
        view.setScaleX(f6);
        view.setScaleY(f7);
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void setLeftTopRightBottom(@NonNull View view, int i4, int i5, int i6, int i7) {
        fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5.getCause());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(@NonNull View view, float f4) {
        if (sTryHiddenTransitionAlpha) {
            try {
                Api29Impl.setTransitionAlpha(view, f4);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f4);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void setTransitionVisibility(@NonNull View view, int i4) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i4 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToGlobal(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToLocal(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
