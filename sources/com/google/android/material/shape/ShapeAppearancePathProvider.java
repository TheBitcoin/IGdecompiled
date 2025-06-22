package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider {
    private final Path boundsPath = new Path();
    private final Path cornerPath = new Path();
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private boolean edgeIntersectionCheckEnabled = true;
    private final Path edgePath = new Path();
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final Path overlappedEdgePath = new Path();
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    private static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i4);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i4);
    }

    static final class ShapeAppearancePathSpec {
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel2, float f4, RectF rectF, @Nullable PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f4;
            this.bounds = rectF;
            this.path = path2;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.cornerPaths[i4] = new ShapePath();
            this.cornerTransforms[i4] = new Matrix();
            this.edgeTransforms[i4] = new Matrix();
        }
    }

    private float angleOfEdge(int i4) {
        return (float) (((i4 + 1) % 4) * 90);
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        this.scratch[0] = this.cornerPaths[i4].getStartX();
        this.scratch[1] = this.cornerPaths[i4].getStartY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        if (i4 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i4].applyToPath(this.cornerTransforms[i4], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i4], this.cornerTransforms[i4], i4);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        int i5 = (i4 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i4].getEndX();
        this.scratch[1] = this.cornerPaths[i4].getEndY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i5].getStartX();
        this.scratch2[1] = this.cornerPaths[i5].getStartY();
        this.cornerTransforms[i5].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f4 = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f4 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i4);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i4], this.edgePath);
        if (!this.edgeIntersectionCheckEnabled || (!edgeTreatmentForIndex.forceIntersection() && !pathOverlapsCorner(this.edgePath, i4) && !pathOverlapsCorner(this.edgePath, i5))) {
            this.shapePath.applyToPath(this.edgeTransforms[i4], shapeAppearancePathSpec.path);
        } else {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i4].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i4], this.overlappedEdgePath);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i4], i4);
        }
    }

    private void getCoordinatesOfCorner(int i4, @NonNull RectF rectF, @NonNull PointF pointF2) {
        if (i4 == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i4 == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i4 != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i4 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i4 != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i4 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i4 != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i4) {
        float[] fArr = this.scratch;
        ShapePath shapePath2 = this.cornerPaths[i4];
        fArr[0] = shapePath2.endX;
        fArr[1] = shapePath2.endY;
        this.cornerTransforms[i4].mapPoints(fArr);
        if (i4 == 1 || i4 == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i4 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i4 != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    @UiThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i4) {
        this.cornerPath.reset();
        this.cornerPaths[i4].applyToPath(this.cornerTransforms[i4], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f)) {
            return true;
        }
        return false;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        getCornerTreatmentForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i4], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i4, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i4);
        this.cornerTransforms[i4].reset();
        getCoordinatesOfCorner(i4, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i4];
        PointF pointF2 = this.pointF;
        matrix.setTranslate(pointF2.x, pointF2.y);
        this.cornerTransforms[i4].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i4) {
        this.scratch[0] = this.cornerPaths[i4].getEndX();
        this.scratch[1] = this.cornerPaths[i4].getEndY();
        this.cornerTransforms[i4].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i4);
        this.edgeTransforms[i4].reset();
        Matrix matrix = this.edgeTransforms[i4];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i4].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f4, rectF, (PathListener) null, path);
    }

    /* access modifiers changed from: package-private */
    public void setEdgeIntersectionCheckEnable(boolean z4) {
        this.edgeIntersectionCheckEnabled = z4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        Path path2 = path;
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f4, rectF, pathListener, path2);
        for (int i4 = 0; i4 < 4; i4++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i4);
            setEdgePathAndTransform(i4);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            appendCornerPath(shapeAppearancePathSpec, i5);
            appendEdgePath(shapeAppearancePathSpec, i5);
        }
        path2.close();
        this.overlappedEdgePath.close();
        if (!this.overlappedEdgePath.isEmpty()) {
            path2.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}
