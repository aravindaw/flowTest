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
public class A2PFlowTest {

    private String OA = "7777";
    private String DA = "";
    private String clientId = "0";
    private Random random = new Random();

    @Before
    public void makeDa() {
        String daLastChars = Integer.toString(100000 + random.nextInt(900000));
        DA = "94772" + daLastChars;
    }

    @Test
    public void a2pWithDrShortMsg() throws IOException {

        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("a2p With Dr Short Msg");
        String DR = "true";
        String message = "testMessage";
        URL url = new URL("http://127.0.0.1:3402/client/sendOnce?clientId=" + clientId + "&to=" + DA + "&message=" + message + "&deliveryFlag=" + DR);
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smppCdrValidation(OA, DA);
        cdrValidation.smscCdrValidation(OA, DA);
    }

    @Test
    public void a2pWithDrLongMsg() throws IOException {

        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("a2p With Dr Long Msg");
        String DR = "true";
        URL url = new URL("http://127.0.0.1:3402/client/sendOnce?clientId=" + clientId + "&to=" + DA + "&deliveryFlag=" + DR + "&isLongMsg=true");
        //LongMsg character count can changed from smpp-simulator.properties
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smppCdrValidation(OA, DA);
        cdrValidation.smscCdrValidation(OA, DA);
    }

    @Test
    public void a2pWithoutDrShortMsg() throws IOException {

        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("a2p With Dr Short Msg");
        String DR = "false";
        String message = "testMessage";
        URL url = new URL("http://127.0.0.1:3402/client/sendOnce?clientId=" + clientId + "&to=" + DA + "&message=" + message + "&deliveryFlag=" + DA);
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smppCdrValidation(OA, DA);
        cdrValidation.smscCdrValidation(OA, DA);
    }

    @Test
    public void a2pWithoutDrLongMsg() throws IOException {

        System.out.println("OA :" + OA + "\n" + "DA :" + DA);
        System.out.println("a2p With Dr Long Msg");
        String DR = "false";
        URL url = new URL("http://127.0.0.1:3402/client/sendOnce?clientId=" + clientId + "&to=" + DA + "&deliveryFlag=" + DR + "&isLongMsg=true");
        //LongMsg character count can changed from smpp-simulator.properties
        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Accept", "application/json");

        if (connect.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + connect.getResponseCode());
        }
        CdrValidation cdrValidation = new CdrValidation();
        cdrValidation.smppCdrValidation(OA, DA);
        cdrValidation.smscCdrValidation(OA, DA);
    }
}
