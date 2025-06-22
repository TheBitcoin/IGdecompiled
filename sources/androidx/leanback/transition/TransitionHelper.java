package androidx.leanback.transition;

import android.animation.TimeInterpolator;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Rect;
import android.transition.AutoTransition;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransitionHelper {
    public static final int FADE_IN = 1;
    public static final int FADE_OUT = 2;

    private static class TransitionStub {
        ArrayList<TransitionListener> mTransitionListeners;

        TransitionStub() {
        }
    }

    private TransitionHelper() {
    }

    public static void addSharedElement(FragmentTransaction fragmentTransaction, View view, String str) {
        fragmentTransaction.addSharedElement(view, str);
    }

    public static void addTarget(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void addTransition(Object obj, Object obj2) {
        ((TransitionSet) obj).addTransition((Transition) obj2);
    }

    public static void addTransitionListener(Object obj, final TransitionListener transitionListener) {
        if (transitionListener != null) {
            AnonymousClass1 r02 = new Transition.TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                    transitionListener.onTransitionCancel(transition);
                }

                public void onTransitionEnd(Transition transition) {
                    transitionListener.onTransitionEnd(transition);
                }

                public void onTransitionPause(Transition transition) {
                    transitionListener.onTransitionPause(transition);
                }

                public void onTransitionResume(Transition transition) {
                    transitionListener.onTransitionResume(transition);
                }

                public void onTransitionStart(Transition transition) {
                    transitionListener.onTransitionStart(transition);
                }
            };
            transitionListener.mImpl = r02;
            ((Transition) obj).addListener(r02);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static Object createAutoTransition() {
        return new AutoTransition();
    }

    public static Object createChangeBounds(boolean z4) {
        CustomChangeBounds customChangeBounds = new CustomChangeBounds();
        customChangeBounds.setReparent(z4);
        return customChangeBounds;
    }

    public static Object createChangeTransform() {
        return new ChangeTransform();
    }

    public static Object createDefaultInterpolator(Context context) {
        return AnimationUtils.loadInterpolator(context, AndroidResources.FAST_OUT_LINEAR_IN);
    }

    public static Object createFadeAndShortSlide(int i4) {
        return new FadeAndShortSlide(i4);
    }

    public static Object createFadeTransition(int i4) {
        return new Fade(i4);
    }

    public static Object createScale() {
        return new ChangeTransform();
    }

    public static Object createScene(ViewGroup viewGroup, Runnable runnable) {
        Scene scene = new Scene(viewGroup);
        scene.setEnterAction(runnable);
        return scene;
    }

    public static Object createSlide(int i4) {
        SlideKitkat slideKitkat = new SlideKitkat();
        slideKitkat.setSlideEdge(i4);
        return slideKitkat;
    }

    public static Object createTransitionSet(boolean z4) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(z4 ? 1 : 0);
        return transitionSet;
    }

    public static void exclude(Object obj, int i4, boolean z4) {
        ((Transition) obj).excludeTarget(i4, z4);
    }

    public static void excludeChildren(Object obj, int i4, boolean z4) {
        ((Transition) obj).excludeChildren(i4, z4);
    }

    public static Object getEnterTransition(Window window) {
        return window.getEnterTransition();
    }

    public static Object getExitTransition(Window window) {
        return window.getExitTransition();
    }

    public static Object getReenterTransition(Window window) {
        return window.getReenterTransition();
    }

    public static Object getReturnTransition(Window window) {
        return window.getReturnTransition();
    }

    public static Object getSharedElementEnterTransition(Window window) {
        return window.getSharedElementEnterTransition();
    }

    public static Object getSharedElementExitTransition(Window window) {
        return window.getSharedElementExitTransition();
    }

    public static Object getSharedElementReenterTransition(Window window) {
        return window.getSharedElementReenterTransition();
    }

    public static Object getSharedElementReturnTransition(Window window) {
        return window.getSharedElementReturnTransition();
    }

    public static void include(Object obj, int i4) {
        ((Transition) obj).addTarget(i4);
    }

    public static Object loadTransition(Context context, int i4) {
        return TransitionInflater.from(context).inflateTransition(i4);
    }

    public static void removeTransitionListener(Object obj, TransitionListener transitionListener) {
        Object obj2;
        if (transitionListener != null && (obj2 = transitionListener.mImpl) != null) {
            ((Transition) obj).removeListener((Transition.TransitionListener) obj2);
            transitionListener.mImpl = null;
        }
    }

    public static void runTransition(Object obj, Object obj2) {
        TransitionManager.go((Scene) obj, (Transition) obj2);
    }

    public static void setChangeBoundsDefaultStartDelay(Object obj, int i4) {
        ((CustomChangeBounds) obj).setDefaultStartDelay(i4);
    }

    public static void setChangeBoundsStartDelay(Object obj, View view, int i4) {
        ((CustomChangeBounds) obj).setStartDelay(view, i4);
    }

    public static void setDuration(Object obj, long j4) {
        ((Transition) obj).setDuration(j4);
    }

    public static void setEnterTransition(Window window, Object obj) {
        window.setEnterTransition((Transition) obj);
    }

    public static void setEpicenterCallback(Object obj, final TransitionEpicenterCallback transitionEpicenterCallback) {
        if (transitionEpicenterCallback == null) {
            ((Transition) obj).setEpicenterCallback((Transition.EpicenterCallback) null);
        } else {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(Transition transition) {
                    return transitionEpicenterCallback.onGetEpicenter(transition);
                }
            });
        }
    }

    public static void setExitTransition(Fragment fragment, Object obj) {
        fragment.setExitTransition((Transition) obj);
    }

    public static void setInterpolator(Object obj, Object obj2) {
        ((Transition) obj).setInterpolator((TimeInterpolator) obj2);
    }

    public static void setReturnTransition(Window window, Object obj) {
        window.setReturnTransition((Transition) obj);
    }

    public static void setSharedElementEnterTransition(Window window, Object obj) {
        window.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setSharedElementReturnTransition(Window window, Object obj) {
        window.setSharedElementReturnTransition((Transition) obj);
    }

    public static void setStartDelay(Object obj, long j4) {
        ((Transition) obj).setStartDelay(j4);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z4) {
        viewGroup.setTransitionGroup(z4);
    }

    public static boolean systemSupportsEntranceTransitions() {
        return true;
    }

    public static Object createFadeAndShortSlide(int i4, float f4) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(i4);
        fadeAndShortSlide.setDistance(f4);
        return fadeAndShortSlide;
    }

    public static void exclude(Object obj, View view, boolean z4) {
        ((Transition) obj).excludeTarget(view, z4);
    }

    public static void excludeChildren(Object obj, View view, boolean z4) {
        ((Transition) obj).excludeChildren(view, z4);
    }

    public static void include(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void setChangeBoundsStartDelay(Object obj, int i4, int i5) {
        ((CustomChangeBounds) obj).setStartDelay(i4, i5);
    }

    public static void setEnterTransition(Fragment fragment, Object obj) {
        fragment.setEnterTransition((Transition) obj);
    }

    public static void setSharedElementEnterTransition(Fragment fragment, Object obj) {
        fragment.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setChangeBoundsStartDelay(Object obj, String str, int i4) {
        ((CustomChangeBounds) obj).setStartDelay(str, i4);
    }
}
