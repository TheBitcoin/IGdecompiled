package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13698a = "z";

    /* renamed from: b  reason: collision with root package name */
    private static Map<Character, Character> f13699b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f13700c;

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f13701d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* renamed from: e  reason: collision with root package name */
    private static char[] f13702e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap hashMap = new HashMap();
        f13699b = hashMap;
        hashMap.put('v', 'A');
        f13699b.put('S', 'B');
        f13699b.put('o', 'C');
        f13699b.put('a', 'D');
        f13699b.put('j', 'E');
        f13699b.put('c', 'F');
        f13699b.put('7', 'G');
        f13699b.put('d', 'H');
        f13699b.put('R', 'I');
        f13699b.put('z', 'J');
        f13699b.put('p', 'K');
        f13699b.put('W', 'L');
        f13699b.put('i', 'M');
        f13699b.put('f', 'N');
        f13699b.put('G', 'O');
        f13699b.put('y', 'P');
        f13699b.put('N', 'Q');
        f13699b.put('x', 'R');
        f13699b.put('Z', 'S');
        f13699b.put('n', 'T');
        f13699b.put('V', 'U');
        f13699b.put('5', 'V');
        f13699b.put('k', 'W');
        f13699b.put('+', 'X');
        f13699b.put('D', 'Y');
        f13699b.put('H', 'Z');
        f13699b.put('L', 'a');
        f13699b.put('Y', 'b');
        f13699b.put('h', 'c');
        f13699b.put('J', 'd');
        f13699b.put('4', 'e');
        f13699b.put('6', 'f');
        f13699b.put('l', 'g');
        f13699b.put('t', 'h');
        f13699b.put('0', 'i');
        f13699b.put('U', 'j');
        f13699b.put('3', 'k');
        f13699b.put('Q', 'l');
        f13699b.put('r', 'm');
        f13699b.put('g', 'n');
        f13699b.put('E', 'o');
        f13699b.put('u', 'p');
        f13699b.put('q', 'q');
        f13699b.put('8', 'r');
        f13699b.put('s', 's');
        f13699b.put('w', 't');
        f13699b.put('/', 'u');
        f13699b.put('X', 'v');
        f13699b.put('M', 'w');
        f13699b.put('e', 'x');
        f13699b.put('B', 'y');
        f13699b.put('A', 'z');
        f13699b.put('T', '0');
        f13699b.put('2', '1');
        f13699b.put('F', '2');
        f13699b.put('b', '3');
        f13699b.put('9', '4');
        f13699b.put('P', '5');
        f13699b.put('1', '6');
        f13699b.put('O', 55);
        f13699b.put('I', '8');
        f13699b.put('K', '9');
        f13699b.put('m', '+');
        f13699b.put(67, '/');
        HashMap hashMap2 = new HashMap();
        f13700c = hashMap2;
        hashMap2.put('A', 'v');
        f13700c.put('B', 'S');
        f13700c.put(67, 'o');
        f13700c.put('D', 'a');
        f13700c.put('E', 'j');
        f13700c.put('F', 'c');
        f13700c.put('G', 55);
        f13700c.put('H', 100);
        f13700c.put('I', 'R');
        f13700c.put('J', 'z');
        f13700c.put('K', 'p');
        f13700c.put('L', 'W');
        f13700c.put('M', 'i');
        f13700c.put('N', 'f');
        f13700c.put('O', 'G');
        f13700c.put('P', 'y');
        f13700c.put('Q', 'N');
        f13700c.put('R', 'x');
        f13700c.put('S', 'Z');
        f13700c.put('T', 'n');
        f13700c.put('U', 'V');
        f13700c.put('V', '5');
        f13700c.put('W', 'k');
        f13700c.put('X', '+');
        f13700c.put('Y', 'D');
        f13700c.put('Z', 'H');
        f13700c.put('a', 'L');
        f13700c.put('b', 'Y');
        f13700c.put('c', 'h');
        f13700c.put(100, 'J');
        f13700c.put('e', '4');
        f13700c.put('f', '6');
        f13700c.put('g', 'l');
        f13700c.put('h', 't');
        f13700c.put('i', '0');
        f13700c.put('j', 'U');
        f13700c.put('k', '3');
        f13700c.put('l', 'Q');
        f13700c.put('m', 'r');
        f13700c.put('n', 'g');
        f13700c.put('o', 'E');
        f13700c.put('p', 'u');
        f13700c.put('q', 'q');
        f13700c.put('r', '8');
        f13700c.put('s', 's');
        f13700c.put('t', 'w');
        f13700c.put('u', '/');
        f13700c.put('v', 'X');
        f13700c.put('w', 'M');
        f13700c.put('x', 'e');
        f13700c.put('y', 'B');
        f13700c.put('z', 'A');
        f13700c.put('0', 'T');
        f13700c.put('1', '2');
        f13700c.put('2', 'F');
        f13700c.put('3', 'b');
        f13700c.put('4', '9');
        f13700c.put('5', 'P');
        f13700c.put('6', '1');
        f13700c.put(55, 'O');
        f13700c.put('8', 'I');
        f13700c.put('9', 'K');
        f13700c.put('+', 'm');
        f13700c.put('/', 67);
    }

    private z() {
    }

    public static String a(String str) {
        return ag.a(str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return ag.b(str);
    }
}
