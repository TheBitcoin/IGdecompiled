package androidx.lifecycle;

import V2.d;
import V2.h;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.a;
import kotlin.jvm.internal.l;
import o3.C0991n;
import o3.E0;
import o3.G;
import o3.Y;

public final class WithLifecycleStateKt {
    public static final <R> Object suspendWithStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, boolean z4, G g4, a aVar, d dVar) {
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(state, lifecycle, nVar, aVar);
        if (z4) {
            g4.dispatch(h.f8445a, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$lambda$2$$inlined$Runnable$1(lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
        }
        nVar.q(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(g4, lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return v4;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, a aVar, d dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, a aVar, d dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            E0 D4 = Y.c().D();
            boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, a aVar, d dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Y.c().D();
            l.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, a aVar, d dVar) {
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, a aVar, d dVar) {
        Y.c().D();
        l.c(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Y.c().D();
        l.c(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, a aVar, d dVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            Y.c().D();
            l.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, a aVar, d dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        E0 D4 = Y.c().D();
        boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, a aVar, d dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            E0 D4 = Y.c().D();
            boolean isDispatchNeeded = D4.isDispatchNeeded(dVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, D4, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), dVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
