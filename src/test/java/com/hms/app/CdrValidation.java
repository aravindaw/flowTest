package com.hms.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static java.lang.System.in;

/**
 * Created by aravinda on 11/2/16.
 */
class CdrValidation {

    void smscCdrValidation(String OA, String DA) {
        try {
            FileInputStream cdrLogFileStream = new FileInputStream("/hms/logs/smsc/cdr/HS_06_SMSC_FULL_CDR_OPEN");
            BufferedReader br = new BufferedReader(new InputStreamReader(cdrLogFileStream));
            String strLine;
            Thread.sleep(10000);
            System.out.println("====================================SMSC CDR====================================");
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains(OA) && strLine.contains(DA)) {
                    String firstChar = strLine.substring(0, 2);
                    switch (firstChar) {
                        case "3,":
                            System.out.println(strLine);
                            System.out.println("===============Got the Status Report===============");
                            break;
                        case "8,":
                            System.out.println(strLine);
                            System.out.println("================SM Accepted by SMSC================");
                            break;
                        case "5,":
                            System.out.println(strLine);
                            System.out.println("===================SM Delivered====================");
                            break;
                        case "6,":
                            System.out.println(strLine);
                            System.out.println("============SM Delivery temporary failed============");
                            break;
                        case "9,":
                            System.out.println(strLine);
                            System.out.println("================SM Rejected by SMSC=================");
                            break;
                        case "34":
                            System.out.println(strLine);
                            System.out.println("================InitialDP_SMS fired=================");
                            break;
                        case "37":
                            System.out.println(strLine);
                            System.out.println("================Continue SMS Failed=================");
                            break;
                        case "2,":
                            System.out.println(strLine);
                            System.out.println("================SM Deleted or expired================");
                            break;

                    }
                }
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    void smppCdrValidation(String OA, String DA) {
        try {
            FileInputStream cdrLogFileStream = new FileInputStream("/hms/logs/smpp-gw/cdr/HS_06_SMPP_FULL_CDR_OPEN");
            BufferedReader br = new BufferedReader(new InputStreamReader(cdrLogFileStream));
            String strLine;
            Thread.sleep(10000);
            System.out.println("==================================SMPP-GW CDR==================================");
            while ((strLine = br.readLine()) != null) {
                if ((strLine.contains(OA) && strLine.contains(DA))) {
                    String firstChar = strLine.substring(0, 2);
                    switch (firstChar) {
                        case "3,":
                            System.out.println(strLine);
                            System.out.println("===============Got the Status Report===============");
                            break;
                        case "8,":
                            System.out.println(strLine);
                            System.out.println("==============Short Message Accepted===============");
                            break;
                        case "5,":
                            System.out.println(strLine);
                            System.out.println("==============Short Message Delivered==============");
                            break;
                        case "6,":
                            System.out.println(strLine);
                            System.out.println("=====Short Message Delivery Temporary Failure=====");
                            break;
                        case "9,":
                            System.out.println(strLine);
                            System.out.println("==============Short Message Rejected==============");
                            break;
                        case "2,":
                            System.out.println(strLine);
                            System.out.println("==============Short Message Expired==============");
                            break;
                        case "29":
                            System.out.println(strLine);
                            System.out.println("==================Cancel Request=================");
                            break;
                        case "30":
                            System.out.println(strLine);
                            System.out.println("===================Cancel Fail===================");
                            break;
                        case "31":
                            System.out.println(strLine);
                            System.out.println("=================Replace Request=================");
                            break;
                        case "32":
                            System.out.println(strLine);
                            System.out.println("===================Replace Fail==================");
                            break;
                    }
                }
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
