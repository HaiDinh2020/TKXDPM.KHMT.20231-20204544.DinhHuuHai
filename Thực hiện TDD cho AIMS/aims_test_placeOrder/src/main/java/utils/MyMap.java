//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyMap extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static int offset = 0;

    public MyMap() {
    }

    public String toJSON() {
        int max = this.size() - 1;
        if (max == -1) {
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<Map.Entry<String, Object>> it = this.entrySet().iterator();
            sb.append('{');
            int i = 0;

            while(true) {
                Map.Entry<String, Object> e = (Map.Entry)it.next();
                String key = (String)e.getKey();
                Object value = e.getValue();
                sb.append('"' + key.toString() + '"');
                sb.append(':');
                sb.append(value instanceof MyMap ? ((MyMap)value).toJSON() : '"' + value.toString() + '"');
                if (i == max) {
                    return sb.append('}').toString();
                }

                sb.append(",");
                ++i;
            }
        }
    }

    public static Map<String, Object> toMyMap(Object obj) throws IllegalArgumentException, IllegalAccessException {
        Map<String, Object> map = new MyMap();
        Field[] var5;
        int var4 = (var5 = obj.getClass().getDeclaredFields()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Field field = var5[var3];
            field.setAccessible(true);
            Object value = field.get(obj);

            try {
                if (!value.getClass().getPackage().getName().startsWith("java")) {
                    value = toMyMap(value).toString();
                }
            } catch (Exception var8) {
            }

            map.put(field.getName(), value);
            field.setAccessible(false);
        }

        return map;
    }

    private static String getNextTerm(String str, int idx) {
        if (str != null && idx < str.length() && str.charAt(idx) == '"') {
            if (str.charAt(idx + 1) == '"') {
                return new String();
            } else {
                int i = idx + 1;
                StringBuilder sb = new StringBuilder();

                do {
                    sb.append(str.charAt(i));
                    ++i;
                    if (i == str.length()) {
                        throw new IllegalArgumentException("Cannot resolve the input.");
                    }
                } while(str.charAt(i) != '"');

                String result = sb.toString();
                offset = result.length() + 2;
                return sb.toString();
            }
        } else {
            throw new IllegalArgumentException("Cannot resolve the input.");
        }
    }

    public static MyMap toMyMap(String str, int idx) throws IllegalArgumentException {
        if (str != null && str.length() >= 2 && str.charAt(idx) == '{') {
            if (idx >= str.length()) {
                return null;
            } else {
                MyMap root = new MyMap();
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(idx));
                int i = idx + 1;

                try {
                    while(str.charAt(i) == '"') {
                        String key;
                        try {
                            key = getNextTerm(str, i);
                        } catch (Exception var8) {
                            throw new IllegalArgumentException("Cannot resolve the input.");
                        }

                        if (key == null) {
                            throw new IllegalArgumentException("Cannot resolve the input.");
                        }

                        sb.append(str.subSequence(i, i + offset));
                        i += offset;
                        offset = 0;
                        sb.append(str.charAt(i));
                        if (str.charAt(i) != ':') {
                            throw new IllegalArgumentException("Cannot resolve the input.");
                        }

                        ++i;
                        Object value;
                        if (str.charAt(i) == '{') {
                            value = toMyMap(str, i);
                            sb.append(str.subSequence(i, i + offset));
                            i += offset;
                            offset = 0;
                        } else {
                            if (str.charAt(i) != '"') {
                                throw new IllegalArgumentException("Cannot resolve the input.");
                            }

                            try {
                                value = getNextTerm(str, i);
                            } catch (Exception var9) {
                                throw new IllegalArgumentException("Cannot resolve the input.");
                            }

                            if (value == null) {
                                throw new IllegalArgumentException("Cannot resolve the input.");
                            }

                            sb.append(str.subSequence(i, i + offset));
                            i += offset;
                            offset = 0;
                        }

                        root.put(key, value);
                        if (str.charAt(i) != ',') {
                            if (str.charAt(i) == '}') {
                                sb.append(str.charAt(i));
                                offset = sb.toString().length();
                                return root;
                            }

                            throw new IllegalArgumentException("Cannot resolve the input.");
                        }

                        sb.append(str.charAt(i));
                        ++i;
                    }

                    throw new IllegalArgumentException("Cannot resolve the input.");
                } catch (Exception var10) {
                    var10.printStackTrace();
                    throw new IllegalArgumentException("Cannot resolve the input.");
                }
            }
        } else {
            throw new IllegalArgumentException("Cannot resolve the input.");
        }
    }
}
