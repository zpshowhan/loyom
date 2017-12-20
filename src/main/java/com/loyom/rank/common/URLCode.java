package com.loyom.rank.common;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;

public class URLCode {

    static final BitSet DONT_NEED_ENCODING;
    static final int CASE_DIFF = ('a' - 'A');

    static {
        DONT_NEED_ENCODING = new BitSet(256);
        int i;
        for (i = 'a'; i <= 'z'; i++) {
            DONT_NEED_ENCODING.set(i);
        }
        for (i = 'A'; i <= 'Z'; i++) {
            DONT_NEED_ENCODING.set(i);
        }
        for (i = '0'; i <= '9'; i++) {
            DONT_NEED_ENCODING.set(i);
        }
        DONT_NEED_ENCODING.set('-');
        DONT_NEED_ENCODING.set('_');
        DONT_NEED_ENCODING.set('.');
        DONT_NEED_ENCODING.set('*');
    }

    public static String encode(String s)
            throws UnsupportedEncodingException {
        return encode(s, "UTF-8");
    }

    public static String encode(String s, String enc)
            throws UnsupportedEncodingException {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (enc == null || enc.isEmpty()) {
            enc = "UTF-8";
        }
        boolean needToChange = false;
        StringBuilder out = new StringBuilder(s.length());
        Charset charset;
        CharArrayWriter charArrayWriter = new CharArrayWriter();

        try {
            charset = Charset.forName(enc);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
            throw new UnsupportedEncodingException(enc);
        }

        for (int i = 0; i < s.length();) {
            int c = (int) s.charAt(i);
            if (DONT_NEED_ENCODING.get(c)) {
                if (c == ' ') {
                    c = '+';
                    needToChange = true;
                }
                out.append((char) c);
                i++;
            } else {
                do {
                    charArrayWriter.write(c);
                    if (c >= 0xD800 && c <= 0xDBFF) {
                        if ((i + 1) < s.length()) {
                            int d = (int) s.charAt(i + 1);
                            if (d >= 0xDC00 && d <= 0xDFFF) {
                                charArrayWriter.write(d);
                                i++;
                            }
                        }
                    }
                    i++;
                } while (i < s.length() && !DONT_NEED_ENCODING.get((c = (int) s.charAt(i))));

                charArrayWriter.flush();
                String str = new String(charArrayWriter.toCharArray());
                byte[] ba = str.getBytes(charset);
                for (int j = 0; j < ba.length; j++) {
                    out.append('%');
                    char ch = Character.forDigit((ba[j] >> 4) & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= CASE_DIFF;
                    }
                    out.append(ch);
                    ch = Character.forDigit(ba[j] & 0xF, 16);
                    if (Character.isLetter(ch)) {
                        ch -= CASE_DIFF;
                    }
                    out.append(ch);
                }
                charArrayWriter.reset();
                needToChange = true;
            }
        }

        return (needToChange ? out.toString() : s);
    }

    public static String decode(String s)
            throws UnsupportedEncodingException {
        return decode(s, "UTF-8");
    }

    public static String decode(String s, String enc)
            throws UnsupportedEncodingException {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (enc == null || enc.isEmpty()) {
            enc = "UTF-8";
        }

        boolean needToChange = false;
        int numChars = s.length();
        StringBuilder sb = new StringBuilder(numChars > 500 ? numChars / 2 : numChars);
        int i = 0;

        char c;
        byte[] bytes = null;
        while (i < numChars) {
            c = s.charAt(i);
            switch (c) {
                case '+':
                    sb.append(' ');
                    i++;
                    needToChange = true;
                    break;
                case '%':
                    try {
                        if (bytes == null) {
                            bytes = new byte[(numChars - i) / 3];
                        }
                        int pos = 0;
                        while (((i + 2) < numChars)
                                && (c == '%')) {
                            int v = Integer.parseInt(s.substring(i + 1, i + 3), 16);
                            if (v < 0) {
                                throw new IllegalArgumentException("URLDecoder: Illegal hex characters in escape (%) pattern - negative value");
                            }
                            bytes[pos++] = (byte) v;
                            i += 3;
                            if (i < numChars) {
                                c = s.charAt(i);
                            }
                        }
                        if ((i < numChars) && (c == '%')) {
                            throw new IllegalArgumentException(
                                    "URLDecoder: Incomplete trailing escape (%) pattern");
                        }

                        sb.append(new String(bytes, 0, pos, enc));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(
                                "URLDecoder: Illegal hex characters in escape (%) pattern - "
                                + e.getMessage());
                    }
                    needToChange = true;
                    break;
                default:
                    sb.append(c);
                    i++;
                    break;
            }
        }
        return (needToChange ? sb.toString() : s);
    }
}
