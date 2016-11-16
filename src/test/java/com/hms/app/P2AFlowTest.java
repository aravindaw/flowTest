package com.hms.app;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * Created by aravinda on 11/9/16.
 */
public class P2AFlowTest {
    private String OA = "";
    private String DA = "7777";
    private Random random = new Random();

    @Before
    public void makeOaAndDa() {
        String oaLastChars = Integer.toString(100000 + random.nextInt(900000));
        OA = "94771" + oaLastChars;
    }

    @Test
    public void p2aWithDrShortMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2a With Dr Short Msg");
        String DR = "1"; //1=DR requested ,0=DR not requested
        String message = "shortMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
        cdrValidation.smppCdrValidation(OA, DA);
    }

    @Test
    public void p2aWithoutDrShortMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2a Without Dr Short Msg");
        String DR = "0"; //1=DR requested ,0=DR not requested
        String message = "shortMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
        cdrValidation.smppCdrValidation(OA, DA);
    }

    @Test
    public void p2aWithDrLongMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2a With Dr Long Msg");
        String DR = "1"; //1=DR requested ,0=DR not requested
        String message = "longMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
        cdrValidation.smppCdrValidation(OA, DA);
    }

    @Test
    public void p2aWithoutDrLongMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2a Without Dr Long Msg");
        String DR = "0"; //1=DR requested ,0=DR not requested
        String message = "longMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
        cdrValidation.smppCdrValidation(OA, DA);
    }
}
