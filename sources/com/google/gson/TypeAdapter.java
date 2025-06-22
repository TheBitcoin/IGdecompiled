package com.google.gson;

import com.google.gson.internal.bind.a;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.io.IOException;

public abstract class TypeAdapter {
    public final TypeAdapter a() {
        return new TypeAdapter() {
            public Object b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return TypeAdapter.this.b(aVar);
                }
                aVar.H();
                return null;
            }

            public void d(C2081c cVar, Object obj) {
                if (obj == null) {
                    cVar.x();
                } else {
                    TypeAdapter.this.d(cVar, obj);
                }
            }
        };
    }

    public abstract Object b(C2079a aVar);

    public final f c(Object obj) {
        try {
            a aVar = new a();
            d(aVar, obj);
            return aVar.R();
        } catch (IOException e5) {
            throw new g((Throwable) e5);
        }
    }

    public abstract void d(C2081c cVar, Object obj);
}
