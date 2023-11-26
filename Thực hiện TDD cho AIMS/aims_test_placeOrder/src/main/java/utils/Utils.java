//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

public class Utils {
    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Logger LOGGER = getLogger(Utils.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-4s] [%1$tF %1$tT] [%2$-7s] %5$s %n");
    }

    public Utils() {
    }

    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }

    public static String getCurrencyFormat(int num) {
        Locale vietname = new Locale("vi", "VN");
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(vietname);
        return defaultFormat.format((long)num);
    }

    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String md5(String message) {
        String digest = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            byte[] var8 = hash;
            int var7 = hash.length;

            for(int var6 = 0; var6 < var7; ++var6) {
                byte b = var8[var6];
                sb.append(String.format("%02x", b & 255));
            }

            digest = sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException var9) {
            getLogger(Utils.class.getName());
            digest = "";
        }

        return digest;
    }
}
