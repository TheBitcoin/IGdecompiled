package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i4, @NonNull Canvas canvas) {
            float access$800 = this.operation.getStartAngle();
            float access$900 = this.operation.getSweepAngle();
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            Canvas canvas2 = canvas;
            shadowRenderer2.drawCornerShadow(canvas2, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i4, access$800, access$900);
        }
    }

    static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f4, float f5) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f4;
            this.startY = f5;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i4, Canvas canvas) {
            int i5;
            Matrix matrix2 = matrix;
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            int i6 = i4;
            Canvas canvas2 = canvas;
            float sweepAngle = getSweepAngle();
            if (sweepAngle <= 0.0f) {
                double hypot = Math.hypot((double) (this.operation1.f11056x - this.startX), (double) (this.operation1.f11057y - this.startY));
                double hypot2 = Math.hypot((double) (this.operation2.f11056x - this.operation1.f11056x), (double) (this.operation2.f11057y - this.operation1.f11057y));
                float min = (float) Math.min((double) i6, Math.min(hypot, hypot2));
                double d5 = (double) min;
                double tan = Math.tan(Math.toRadians((double) ((-sweepAngle) / 2.0f))) * d5;
                if (hypot > tan) {
                    RectF rectF = new RectF(0.0f, 0.0f, (float) (hypot - tan), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.startX, this.startY);
                    this.renderMatrix.preRotate(getStartAngle());
                    i5 = i4;
                    shadowRenderer2.drawEdgeShadow(canvas2, this.renderMatrix, rectF, i5);
                } else {
                    i5 = i4;
                }
                float f4 = min * 2.0f;
                RectF rectF2 = new RectF(0.0f, 0.0f, f4, f4);
                this.renderMatrix.set(matrix2);
                this.renderMatrix.preTranslate(this.operation1.f11056x, this.operation1.f11057y);
                this.renderMatrix.preRotate(getStartAngle());
                this.renderMatrix.preTranslate((float) ((-tan) - d5), -2.0f * min);
                float[] fArr = {(float) (d5 + tan), f4};
                ShadowRenderer shadowRenderer3 = shadowRenderer;
                double d6 = tan;
                float[] fArr2 = fArr;
                Canvas canvas3 = canvas;
                shadowRenderer3.drawInnerCornerShadow(canvas3, this.renderMatrix, rectF2, (int) min, 450.0f, sweepAngle, fArr2);
                if (hypot2 > d6) {
                    RectF rectF3 = new RectF(0.0f, 0.0f, (float) (hypot2 - d6), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.operation1.f11056x, this.operation1.f11057y);
                    this.renderMatrix.preRotate(getEndAngle());
                    this.renderMatrix.preTranslate((float) d6, 0.0f);
                    shadowRenderer3.drawEdgeShadow(canvas3, this.renderMatrix, rectF3, i5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation2.f11057y - this.operation1.f11057y) / (this.operation2.f11056x - this.operation1.f11056x))));
        }

        /* access modifiers changed from: package-private */
        public float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation1.f11057y - this.startY) / (this.operation1.f11056x - this.startX))));
        }

        /* access modifiers changed from: package-private */
        public float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            if (endAngle <= ShapePath.ANGLE_LEFT) {
                return endAngle;
            }
            return endAngle - 360.0f;
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f4, float f5) {
            this.operation = pathLineOperation;
            this.startX = f4;
            this.startY = f5;
        }

        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i4, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.operation.f11057y - this.startY), (double) (this.operation.f11056x - this.startX)), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i4);
        }

        /* access modifiers changed from: package-private */
        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation.f11057y - this.startY) / (this.operation.f11056x - this.startX))));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f4, float f5, float f6, float f7) {
            setLeft(f4);
            setTop(f5);
            setRight(f6);
            setBottom(f7);
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f4) {
            this.bottom = f4;
        }

        private void setLeft(float f4) {
            this.left = f4;
        }

        private void setRight(float f4) {
            this.right = f4;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f4) {
            this.startAngle = f4;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f4) {
            this.sweepAngle = f4;
        }

        private void setTop(float f4) {
            this.top = f4;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f4, float f5, float f6, float f7, float f8, float f9) {
            setControlX1(f4);
            setControlY1(f5);
            setControlX2(f6);
            setControlY2(f7);
            setEndX(f8);
            setEndY(f9);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f4) {
            this.controlX1 = f4;
        }

        private void setControlX2(float f4) {
            this.controlX2 = f4;
        }

        private void setControlY1(float f4) {
            this.controlY1 = f4;
        }

        private void setControlY2(float f4) {
            this.controlY2 = f4;
        }

        private void setEndX(float f4) {
            this.endX = f4;
        }

        private void setEndY(float f4) {
            this.endY = f4;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            Path path2 = path;
            path2.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path2.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public float f11056x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public float f11057y;

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f11056x, this.f11057y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f4) {
            this.controlX = f4;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f4) {
            this.controlY = f4;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f4) {
            this.endX = f4;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f4) {
            this.endY = f4;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i4, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i4, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i4, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f4) {
        if (getCurrentShadowAngle() != f4) {
            float currentShadowAngle2 = ((f4 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= ANGLE_LEFT) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                setCurrentShadowAngle(f4);
            }
        }
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f4, float f5) {
        addConnectingShadowIfNecessary(f4);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f5);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f4) {
        this.currentShadowAngle = f4;
    }

    private void setEndShadowAngle(float f4) {
        this.endShadowAngle = f4;
    }

    private void setEndX(float f4) {
        this.endX = f4;
    }

    private void setEndY(float f4) {
        this.endY = f4;
    }

    private void setStartX(float f4) {
        this.startX = f4;
    }

    private void setStartY(float f4) {
        this.startY = f4;
    }

    public void addArc(float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean z4;
        float f10;
        PathArcOperation pathArcOperation = new PathArcOperation(f4, f5, f6, f7);
        pathArcOperation.setStartAngle(f8);
        pathArcOperation.setSweepAngle(f9);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f11 = f8 + f9;
        if (f9 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            f8 = (f8 + ANGLE_LEFT) % 360.0f;
        }
        if (z4) {
            f10 = (ANGLE_LEFT + f11) % 360.0f;
        } else {
            f10 = f11;
        }
        addShadowCompatOperation(arcShadowOperation, f8, f10);
        double d5 = (double) f11;
        setEndX(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.cos(Math.toRadians(d5)))));
        setEndY(((f5 + f7) * 0.5f) + (((f7 - f5) / 2.0f) * ((float) Math.sin(Math.toRadians(d5)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.operations.get(i4).applyToPath(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() {
            public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i4, Canvas canvas) {
                for (ShadowCompatOperation draw : arrayList) {
                    draw.draw(matrix2, shadowRenderer, i4, canvas);
                }
            }
        };
    }

    @RequiresApi(21)
    public void cubicToPoint(float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f8;
        float f11 = f9;
        this.operations.add(new PathCubicOperation(f4, f5, f6, f7, f10, f11));
        this.containsIncompatibleShadowOp = true;
        setEndX(f10);
        setEndY(f11);
    }

    /* access modifiers changed from: package-private */
    public float getEndX() {
        return this.endX;
    }

    /* access modifiers changed from: package-private */
    public float getEndY() {
        return this.endY;
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.startX;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f4, float f5) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f11056x = f4;
        float unused2 = pathLineOperation.f11057y = f5;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f4);
        setEndY(f5);
    }

    @RequiresApi(21)
    public void quadToPoint(float f4, float f5, float f6, float f7) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f4);
        pathQuadOperation.setControlY(f5);
        pathQuadOperation.setEndX(f6);
        pathQuadOperation.setEndY(f7);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f6);
        setEndY(f7);
    }

    public void reset(float f4, float f5) {
        reset(f4, f5, ANGLE_UP, 0.0f);
    }

    public void reset(float f4, float f5, float f6, float f7) {
        setStartX(f4);
        setStartY(f5);
        setEndX(f4);
        setEndY(f5);
        setCurrentShadowAngle(f6);
        setEndShadowAngle((f6 + f7) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f4, float f5) {
        reset(f4, f5);
    }

    public void lineTo(float f4, float f5, float f6, float f7) {
        if ((Math.abs(f4 - getEndX()) >= 0.001f || Math.abs(f5 - getEndY()) >= 0.001f) && (Math.abs(f4 - f6) >= 0.001f || Math.abs(f5 - f7) >= 0.001f)) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            float unused = pathLineOperation.f11056x = f4;
            float unused2 = pathLineOperation.f11057y = f5;
            this.operations.add(pathLineOperation);
            PathLineOperation pathLineOperation2 = new PathLineOperation();
            float unused3 = pathLineOperation2.f11056x = f6;
            float unused4 = pathLineOperation2.f11057y = f7;
            this.operations.add(pathLineOperation2);
            InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
            if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
                lineTo(f4, f5);
                lineTo(f6, f7);
                return;
            }
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f6);
            setEndY(f7);
            return;
        }
        lineTo(f6, f7);
    }
}
