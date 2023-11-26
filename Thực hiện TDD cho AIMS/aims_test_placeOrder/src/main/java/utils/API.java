//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class API {
    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Logger LOGGER = Utils.getLogger(Utils.class.getName());
    int var;

    public API() {
    }

    public static String get(String url, String token) throws Exception {
        LOGGER.info("Request URL: " + url + "\n");
        URL line_api_url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)line_api_url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + token);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder respone = new StringBuilder();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }

        respone.append(inputLine + "\n");
        in.close();
        LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
        return respone.substring(0, respone.length() - 1).toString();
    }

    public static String post(String url, String data) throws IOException {
        allowMethods("PATCH");
        URL line_api_url = new URL(url);
        LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + data + "\n");
        HttpURLConnection conn = (HttpURLConnection)line_api_url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("PATCH");
        conn.setRequestProperty("Content-Type", "application/json");
        Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        writer.write(data);
        writer.close();
        BufferedReader in;
        if (conn.getResponseCode() / 100 == 2) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder response = new StringBuilder();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        LOGGER.info("Respone Info: " + response.toString());
        return response.toString();
    }

    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
            methodsField.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & -17);
            String[] oldMethods = (String[])methodsField.get((Object)null);
            Set<String> methodsSet = new LinkedHashSet(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = (String[])methodsSet.toArray(new String[0]);
            methodsField.set((Object)null, newMethods);
        } catch (IllegalAccessException | NoSuchFieldException var6) {
            throw new IllegalStateException(var6);
        }
    }
}
