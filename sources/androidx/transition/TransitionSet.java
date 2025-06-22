package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;

public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags = 0;
    int mCurrentListeners;
    private boolean mPlayTogether = true;
    boolean mStarted = false;
    ArrayList<Transition> mTransitions = new ArrayList<>();

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int i4 = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i4;
            if (i4 == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (!transitionSet.mStarted) {
                transitionSet.start();
                this.mTransitionSet.mStarted = true;
            }
        }
    }

    public TransitionSet() {
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private int indexOfTransition(long j4) {
        for (int i4 = 1; i4 < this.mTransitions.size(); i4++) {
            if (this.mTransitions.get(i4).mSeekOffsetInParent > j4) {
                return i4 - 1;
            }
        }
        return this.mTransitions.size() - 1;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        ArrayList<Transition> arrayList = this.mTransitions;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Transition transition = arrayList.get(i4);
            i4++;
            transition.addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j4 = this.mDuration;
        if (j4 >= 0) {
            transition.setDuration(j4);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).cancel();
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Transition transition = arrayList.get(i4);
                i4++;
                Transition transition2 = transition;
                if (transition2.isValidTarget(transitionValues.view)) {
                    transition2.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).capturePropagationValues(transitionValues);
        }
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            ArrayList<Transition> arrayList = this.mTransitions;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Transition transition = arrayList.get(i4);
                i4++;
                Transition transition2 = transition;
                if (transition2.isValidTarget(transitionValues.view)) {
                    transition2.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void createAnimators(@NonNull ViewGroup viewGroup, @NonNull TransitionValuesMaps transitionValuesMaps, @NonNull TransitionValuesMaps transitionValuesMaps2, @NonNull ArrayList<TransitionValues> arrayList, @NonNull ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            Transition transition = this.mTransitions.get(i4);
            if (startDelay > 0 && (this.mPlayTogether || i4 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z4) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).excludeTarget(view, z4);
        }
        return super.excludeTarget(view, z4);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).forceToEnd(viewGroup);
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ^ true ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i4) {
        if (i4 < 0 || i4 >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i4);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    /* access modifiers changed from: package-private */
    public boolean hasAnimators() {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            if (this.mTransitions.get(i4).hasAnimators()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSeekingSupported() {
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!this.mTransitions.get(i4).isSeekingSupported()) {
                return false;
            }
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(@Nullable View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).pause(view);
        }
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0;
        AnonymousClass2 r02 = new TransitionListenerAdapter() {
            public void onTransitionCancel(@NonNull Transition transition) {
                TransitionSet.this.mTransitions.remove(transition);
                if (!TransitionSet.this.hasAnimators()) {
                    TransitionSet.this.notifyListeners(Transition.TransitionNotification.ON_CANCEL, false);
                    TransitionSet transitionSet = TransitionSet.this;
                    transitionSet.mEnded = true;
                    transitionSet.notifyListeners(Transition.TransitionNotification.ON_END, false);
                }
            }
        };
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            Transition transition = this.mTransitions.get(i4);
            transition.addListener(r02);
            transition.prepareAnimatorsForSeeking();
            long totalDurationMillis = transition.getTotalDurationMillis();
            if (this.mPlayTogether) {
                this.mTotalDuration = Math.max(this.mTotalDuration, totalDurationMillis);
            } else {
                long j4 = this.mTotalDuration;
                transition.mSeekOffsetInParent = j4;
                this.mTotalDuration = j4 + totalDurationMillis;
            }
        }
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(@Nullable View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).resume(view);
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        int i4 = 0;
        if (!this.mPlayTogether) {
            for (int i5 = 1; i5 < this.mTransitions.size(); i5++) {
                final Transition transition = this.mTransitions.get(i5);
                this.mTransitions.get(i5 - 1).addListener(new TransitionListenerAdapter() {
                    public void onTransitionEnd(@NonNull Transition transition) {
                        transition.runAnimators();
                        transition.removeListener(this);
                    }
                });
            }
            Transition transition2 = this.mTransitions.get(0);
            if (transition2 != null) {
                transition2.runAnimators();
                return;
            }
            return;
        }
        ArrayList<Transition> arrayList = this.mTransitions;
        int size = arrayList.size();
        while (i4 < size) {
            Transition transition3 = arrayList.get(i4);
            i4++;
            transition3.runAnimators();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z4) {
        super.setCanRemoveViews(z4);
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).setCanRemoveViews(z4);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RequiresApi(34)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCurrentPlayTimeMillis(long r20, long r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            long r5 = r0.getTotalDurationMillis()
            androidx.transition.TransitionSet r7 = r0.mParent
            r8 = 0
            if (r7 == 0) goto L_0x0022
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0018
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 < 0) goto L_0x00c2
        L_0x0018:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0022
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0022
            goto L_0x00c2
        L_0x0022:
            r7 = 0
            int r11 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0029
            r12 = 1
            goto L_0x002a
        L_0x0029:
            r12 = 0
        L_0x002a:
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 < 0) goto L_0x0032
            int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r14 < 0) goto L_0x003a
        L_0x0032:
            int r14 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r14 > 0) goto L_0x0041
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0041
        L_0x003a:
            r0.mEnded = r7
            androidx.transition.Transition$TransitionNotification r14 = androidx.transition.Transition.TransitionNotification.ON_START
            r0.notifyListeners(r14, r12)
        L_0x0041:
            boolean r14 = r0.mPlayTogether
            if (r14 == 0) goto L_0x005e
        L_0x0045:
            java.util.ArrayList<androidx.transition.Transition> r11 = r0.mTransitions
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x005b
            java.util.ArrayList<androidx.transition.Transition> r11 = r0.mTransitions
            java.lang.Object r11 = r11.get(r7)
            androidx.transition.Transition r11 = (androidx.transition.Transition) r11
            r11.setCurrentPlayTimeMillis(r1, r3)
            int r7 = r7 + 1
            goto L_0x0045
        L_0x005b:
            r16 = r8
            goto L_0x00a6
        L_0x005e:
            int r7 = r0.indexOfTransition(r3)
            if (r11 < 0) goto L_0x0089
        L_0x0064:
            java.util.ArrayList<androidx.transition.Transition> r11 = r0.mTransitions
            int r11 = r11.size()
            if (r7 >= r11) goto L_0x005b
            java.util.ArrayList<androidx.transition.Transition> r11 = r0.mTransitions
            java.lang.Object r11 = r11.get(r7)
            androidx.transition.Transition r11 = (androidx.transition.Transition) r11
            long r14 = r11.mSeekOffsetInParent
            r16 = r8
            long r8 = r1 - r14
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x007f
            goto L_0x00a6
        L_0x007f:
            long r14 = r3 - r14
            r11.setCurrentPlayTimeMillis(r8, r14)
            int r7 = r7 + 1
            r8 = r16
            goto L_0x0064
        L_0x0089:
            r16 = r8
        L_0x008b:
            if (r7 < 0) goto L_0x00a6
            java.util.ArrayList<androidx.transition.Transition> r8 = r0.mTransitions
            java.lang.Object r8 = r8.get(r7)
            androidx.transition.Transition r8 = (androidx.transition.Transition) r8
            long r14 = r8.mSeekOffsetInParent
            long r10 = r1 - r14
            long r14 = r3 - r14
            r8.setCurrentPlayTimeMillis(r10, r14)
            int r8 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r8 < 0) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            int r7 = r7 + -1
            goto L_0x008b
        L_0x00a6:
            androidx.transition.TransitionSet r7 = r0.mParent
            if (r7 == 0) goto L_0x00c2
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00b2
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b8
        L_0x00b2:
            if (r13 >= 0) goto L_0x00c2
            int r1 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r1 < 0) goto L_0x00c2
        L_0x00b8:
            if (r7 <= 0) goto L_0x00bd
            r9 = 1
            r0.mEnded = r9
        L_0x00bd:
            androidx.transition.Transition$TransitionNotification r1 = androidx.transition.Transition.TransitionNotification.ON_END
            r0.notifyListeners(r1, r12)
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.setCurrentPlayTimeMillis(long, long):void");
    }

    public void setEpicenterCallback(@Nullable Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).setEpicenterCallback(epicenterCallback);
        }
    }

    @NonNull
    public TransitionSet setOrdering(int i4) {
        if (i4 == 0) {
            this.mPlayTogether = true;
            return this;
        } else if (i4 == 1) {
            this.mPlayTogether = false;
            return this;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i4);
        }
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
                this.mTransitions.get(i4).setPathMotion(pathMotion);
            }
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTransitions.get(i4).setPropagation(transitionPropagation);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            sb.append(this.mTransitions.get(i4).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }

    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @NonNull
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i4 = 0; i4 < size; i4++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i4).clone());
        }
        return transitionSet;
    }

    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @NonNull
    public TransitionSet setDuration(long j4) {
        ArrayList<Transition> arrayList;
        super.setDuration(j4);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mTransitions.get(i4).setDuration(j4);
            }
        }
        return this;
    }

    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.mTransitions.get(i4).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    @NonNull
    public TransitionSet setStartDelay(long j4) {
        return (TransitionSet) super.setStartDelay(j4);
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z4) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).excludeTarget(str, z4);
        }
        return super.excludeTarget(str, z4);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @NonNull
    public TransitionSet removeTarget(@IdRes int i4) {
        for (int i5 = 0; i5 < this.mTransitions.size(); i5++) {
            this.mTransitions.get(i5).removeTarget(i4);
        }
        return (TransitionSet) super.removeTarget(i4);
    }

    public TransitionSet(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @NonNull
    public Transition excludeTarget(int i4, boolean z4) {
        for (int i5 = 0; i5 < this.mTransitions.size(); i5++) {
            this.mTransitions.get(i5).excludeTarget(i4, z4);
        }
        return super.excludeTarget(i4, z4);
    }

    @NonNull
    public TransitionSet addTarget(@IdRes int i4) {
        for (int i5 = 0; i5 < this.mTransitions.size(); i5++) {
            this.mTransitions.get(i5).addTarget(i4);
        }
        return (TransitionSet) super.addTarget(i4);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z4) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).excludeTarget(cls, z4);
        }
        return super.excludeTarget(cls, z4);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i4 = 0; i4 < this.mTransitions.size(); i4++) {
            this.mTransitions.get(i4).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
