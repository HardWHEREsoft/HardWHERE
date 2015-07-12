package com.sms.sample;

import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.sms.MoSmsListener;
import hms.kite.samples.api.sms.SmsRequestSender;
import hms.kite.samples.api.sms.messages.MoSmsReq;
import hms.kite.samples.api.sms.messages.MtSmsReq;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Created by Ehelepola on 05/07/2015.
*/
public class MoSender implements MoSmsListener {

    private static final Logger LOGGER = Logger.getLogger(MoSender.class.getName());
    private SmsRequestSender requestSender;

    @Override
    public void init() {

    }

    @Override
    public void onReceivedSms(MoSmsReq moSmsReq) {

    }

    public void SentSms(String responseMessage,String address,String applicationID) {

        MtSmsReq mtSmsReq = new MtSmsReq();
        mtSmsReq.setMessage(responseMessage);
        mtSmsReq.setApplicationId(applicationID);
//        mtSmsReq.setPassword("027963e9b53d3e9297b99f7a66fb6d2f");
        mtSmsReq.setPassword("password");
        mtSmsReq.setDestinationAddresses(Arrays.asList(address));

        try
        {
//            requestSender = new SmsRequestSender(new URL("https://api.dialog.lk/sms/send"));
            requestSender = new SmsRequestSender(new URL("http://localhost:7000/sms/send"));
            requestSender.sendSmsRequest(mtSmsReq);
            System.out.println("sent");
        }
        catch (SdpException e)
        {
            LOGGER.log(Level.ALL, "MT message sending error " + e);
        }
        catch (MalformedURLException e)
        {
            LOGGER.log(Level.ALL, "URL error " + e);
        }
    }
}
