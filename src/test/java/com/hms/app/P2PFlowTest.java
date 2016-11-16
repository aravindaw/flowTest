package com.hms.app;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import static junit.framework.TestCase.fail;


/**
 * Created by aravinda on 11/1/16.
 */
public class P2PFlowTest {

    private String OA = "";
    private String DA = "";
    private Random random = new Random();

    @Before
    public void makeOaAndDa() {
        String oaLastChars = Integer.toString(100000 + random.nextInt(900000));
        OA = "94771" + oaLastChars;
        String daLastChars = Integer.toString(100000 + random.nextInt(900000));
        DA = "94772" + daLastChars;
    }

    @Test
    public void p2pWithDrShortMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Short Msg");
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
    }

    @Test
    public void p2pWithoutDrShortMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Short Msg");
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
    }

    @Test
    public void p2pWithDrLongMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Long Msg");
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
    }

    @Test
    public void p2pWithoutDrLongMsg() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Long Msg");
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
    }

    @Test
    public void p2pWithDrShortMsgInvalidDA() throws IOException {
        String DR = "1"; //1=DR requested ,0=DR not requested
        DA = "94885456585";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Short Msg Invalid DA - Message should failed with invalid DA");
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
    }

    @Test
    public void p2pWithoutDrShortMsgInvalidDA() throws IOException {
        String DR = "0"; //1=DR requested ,0=DR not requested
        DA = "94885456585";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Short Msg Invalid DA - Message should failed with invalid DA");
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
    }

    @Test
    public void p2pWithDrLongMsgInvalidDA() throws IOException {
        String DR = "1"; //1=DR requested ,0=DR not requested
        DA = "94885456585";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Long Msg Invalid DA - Message should failed with invalid DA");
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
    }

    @Test
    public void p2pWithoutDrLongMsgInvalidDA() throws IOException {
        String DR = "0"; //1=DR requested ,0=DR not requested
        DA = "94885456585";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Long Msg Invalid DA - Message should failed with invalid DA");
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
    }

    @Test
    public void p2pWithDrShortMsgInvalidOa() throws IOException {
        String DR = "1"; //1=DR requested ,0=DR not requested
        OA = "94885456595";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Short Msg Invalid OA - Message should failed with invalid OA");
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
    }

    @Test
    public void p2pWithoutDrShortMsgInvalidOa() throws IOException {
        String DR = "0"; //1=DR requested ,0=DR not requested
        OA = "94885456595";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Short Msg Invalid OA - Message should failed with invalid OA");
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
    }

    @Test
    public void p2pWithDrLongMsgInvalidOa() throws IOException {
        String DR = "1"; //1=DR requested ,0=DR not requested
        OA = "94885456595";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr long Msg Invalid OA - Message should failed with invalid OA");
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
    }

    @Test
    public void p2pWithoutDrLongMsgInvalidOa() throws IOException {
        String DR = "0"; //1=DR requested ,0=DR not requested
        OA = "94885456595";
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr long Msg Invalid OA - Message should failed with invalid OA");
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
    }

    @Test
    public void p2pWithDrShortMsgRoamer() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Short Msg Roamer");
        String DR = "1"; //1=DR requested ,0=DR not requested
        String message = "shortMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4=&originGt=94770000047");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
    }

    @Test
    public void p2pWithoutDrShortMsgRoamer() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p Without Dr Short Msg Roamer");
        String DR = "0"; //1=DR requested ,0=DR not requested
        String message = "shortMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4=&originGt=94770000047");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
    }

    @Test
    public void p2pWithDrLongMsgRoamer() throws IOException {
        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("p2p With Dr Long Msg Roamer");
        String DR = "0"; //1=DR requested ,0=DR not requested
        String message = "longMsg";
        URL url = new URL("http://127.0.0.1:1234/send?oa=" + OA + "&da=" + DA + "&msg=" + message + "&mr=1&options=0,10,1,0," + DR + ",0,0,ad,4=&originGt=94770000047");
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smscCdrValidation(OA, DA);
    }
}
