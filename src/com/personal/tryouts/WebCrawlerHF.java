package com.personal.tryouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerHF {

    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = getAllWebLinks("https://www.w3schools.com/", 2);
        System.out.println(map.keySet());
    }

    public static Map<String, Integer> getAllWebLinks(String url, int maxDepth) throws IOException {
        Map<String, Integer> mapUrls = new HashMap<>();

        if (maxDepth <= 0) {
            return Map.of(url, 1);
        } else {
            try {
                URL urlObj = new URL(url);
                InputStream is = urlObj.openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String inputLineStr = bufferedReader.readLine();
                while (inputLineStr != null) {
                    String urlPattern = "(www|http:|https:)+[^\\s]+[\\w]";
                    Pattern pattern = Pattern.compile(urlPattern);
                    Matcher matcher = pattern.matcher(inputLineStr);
                    maxDepth = getMaxDepthPoint(mapUrls, maxDepth, matcher);
                    if(maxDepth == 0){
                        break;
                    }
                    inputLineStr = bufferedReader.readLine();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return mapUrls;
    }

    private static boolean isInValidUrl(String urlInternal) {
        try {
            // URL validation
            URL urlInternalObj = new URL(urlInternal);
            urlInternalObj.toURI();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return true;
        }
        return false;
    }

    private static int getMaxDepthPoint(Map<String, Integer> mapUrls , int maxDepth, Matcher matcher) {
        while (matcher.find()) {
            String urlInternal = matcher.group();
            if (isInValidUrl(urlInternal)) continue;
            System.out.println(" some URL found " + urlInternal);
            if (mapUrls.containsKey(urlInternal)) {
                mapUrls.put(urlInternal, mapUrls.get(urlInternal) + 1);
            } else {
                mapUrls.put(urlInternal, 1);
            }
            // exit the loop if it reaches the maxDepth.
            if(maxDepth == 0){
                break;
            }
            maxDepth--;
        }
        return maxDepth;
    }
}
