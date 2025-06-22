package com.google.gson.internal;

import com.google.gson.f;
import com.google.gson.internal.bind.TypeAdapters;
import i1.C2081c;
import j$.util.Objects;
import java.io.Writer;

public abstract class l {
    public static void a(f fVar, C2081c cVar) {
        TypeAdapters.f11610V.d(cVar, fVar);
    }

    public static Writer b(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new b(appendable);
    }

    private static final class b extends Writer implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f11711a;

        /* renamed from: b  reason: collision with root package name */
        private final a f11712b = new a();

        private static class a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            private char[] f11713a;

            /* renamed from: b  reason: collision with root package name */
            private String f11714b;

            private a() {
            }

            /* access modifiers changed from: package-private */
            public void a(char[] cArr) {
                this.f11713a = cArr;
                this.f11714b = null;
            }

            public char charAt(int i4) {
                return this.f11713a[i4];
            }

            public int length() {
                return this.f11713a.length;
            }

            public CharSequence subSequence(int i4, int i5) {
                return new String(this.f11713a, i4, i5 - i4);
            }

            public String toString() {
                if (this.f11714b == null) {
                    this.f11714b = new String(this.f11713a);
                }
                return this.f11714b;
            }
        }

        b(Appendable appendable) {
            this.f11711a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(char[] cArr, int i4, int i5) {
            this.f11712b.a(cArr);
            this.f11711a.append(this.f11712b, i4, i5 + i4);
        }

        public Writer append(CharSequence charSequence) {
            this.f11711a.append(charSequence);
            return this;
        }

        public void write(int i4) {
            this.f11711a.append((char) i4);
        }

        public Writer append(CharSequence charSequence, int i4, int i5) {
            this.f11711a.append(charSequence, i4, i5);
            return this;
        }

        public void write(String str, int i4, int i5) {
            Objects.requireNonNull(str);
            this.f11711a.append(str, i4, i5 + i4);
        }
    }
}
