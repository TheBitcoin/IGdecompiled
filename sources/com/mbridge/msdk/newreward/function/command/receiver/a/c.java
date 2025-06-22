package com.mbridge.msdk.newreward.function.command.receiver.a;

import com.mbridge.msdk.newreward.a.b.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.a.a f14707a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f14708b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f14709c;

    /* renamed from: d  reason: collision with root package name */
    private d f14710d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f14711e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f14712f = false;

    private class a implements b {

        /* renamed from: b  reason: collision with root package name */
        private final c f14716b;

        /* renamed from: c  reason: collision with root package name */
        private final b f14717c;

        public a(c cVar, b bVar) {
            this.f14716b = cVar;
            this.f14717c = bVar;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            if (bVar.a() == 1) {
                if (c.this.f14708b.a() && c.this.f14709c.a() && !this.f14716b.f14712f) {
                    boolean unused = this.f14716b.f14712f = true;
                } else {
                    return;
                }
            }
            this.f14717c.reqFailed(bVar);
        }

        public final void reqSuccessful(Object obj) {
            if (!this.f14716b.f14711e) {
                boolean unused = this.f14716b.f14711e = true;
                this.f14717c.reqSuccessful(obj);
            }
        }
    }

    public c(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f14707a = aVar;
    }

    public final void a(e eVar, final b bVar) {
        int c5 = eVar.c();
        if (c5 == 1) {
            if (this.f14708b == null) {
                a();
            }
            this.f14708b.a(eVar, (b) new a(this, bVar));
        } else if (c5 == 2) {
            if (this.f14710d == null) {
                this.f14710d = new d();
            }
            this.f14710d.a(eVar, new b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.reqFailed(bVar);
                    }
                }

                public final void reqSuccessful(Object obj) {
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.reqSuccessful(obj);
                    }
                }
            });
        } else if (c5 == 3) {
            if (this.f14709c == null) {
                this.f14709c = new b(this.f14707a);
            }
            this.f14709c.a(eVar, (b) new a(this, bVar));
        }
    }

    private void a() {
        this.f14708b = new a(this.f14707a);
    }

    public final boolean a(e eVar) {
        if (eVar.c() == 1) {
            if (this.f14708b == null) {
                a();
            }
            return this.f14708b.a(eVar.a(), eVar, eVar.b());
        } else if (eVar.c() == 2) {
            if (this.f14710d == null) {
                this.f14710d = new d();
            }
            return this.f14710d.a(eVar);
        } else if (eVar.c() != 3) {
            return false;
        } else {
            if (this.f14709c == null) {
                this.f14709c = new b(this.f14707a);
            }
            return true;
        }
    }
}
