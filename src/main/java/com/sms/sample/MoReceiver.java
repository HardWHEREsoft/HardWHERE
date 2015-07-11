/*
 * FILENAME
 *     MoReceiver.java
 *
 * FILE LOCATION
 *     $Source$
 *
 * VERSION
 *     $Id$
 *         @version       $Revision$
 *         Check-Out Tag: $Name$
 *         Locked By:     $Lockers$
 *
 * FORMATTING NOTES
 *     * Lines should be limited to 78 characters.
 *     * Files should contain no tabs.
 *     * Indent code using four-character increments.
 *
 * COPYRIGHT
 *     Copyright (C) 2007 Genix Ventures Pty. Ltd. All rights reserved.
 *     This software is the confidential and proprietary information of
 *     Genix Ventures ("Confidential Information"). You shall not
 *     disclose such Confidential Information and shall use it only in
 *     accordance with the terms of the licence agreement you entered into
 *     with Genix Ventures.
 */

package com.sms.sample;


import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.sms.MoSmsListener;
import hms.kite.samples.api.sms.SmsRequestSender;
import hms.kite.samples.api.sms.messages.MoSmsReq;
import hms.kite.samples.api.sms.messages.MtSmsReq;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MoReceiver implements MoSmsListener
{
    private static final Logger LOGGER = Logger.getLogger(MoReceiver.class.getName());
    private SmsRequestSender requestSender;

    @Override
    public void init()
    {

    }

    @Override
    public void onReceivedSms(final MoSmsReq moSmsReq)
    {

        String message = moSmsReq.getMessage();
        LOGGER.log(Level.ALL, "New message reviced " + moSmsReq.getMessage());
        String[] messages = message.split(" ");
        System.out.println(messages[0]);


        MtSmsReq mtSmsReq = new MtSmsReq();
        mtSmsReq.setMessage("We'll reply you soon!");
        mtSmsReq.setApplicationId(moSmsReq.getApplicationId());
        mtSmsReq.setPassword("password");
        mtSmsReq.setDestinationAddresses(Arrays.asList(moSmsReq.getSourceAddress()));

        try
        {
            //connect to database
            requestSender = new SmsRequestSender(new URL("http://localhost:7000/sms/send"));
            requestSender.sendSmsRequest(mtSmsReq);
            usersDB users=new usersDB();
            users.UpdateUserCollection(messages[0],moSmsReq.getSourceAddress(),moSmsReq.getApplicationId(),messages[2],messages[1]);

        }
        catch (SdpException e)
        {
            LOGGER.log(Level.ALL, "MT message sending error " + e);
        }
        catch (MalformedURLException e)
        {
            LOGGER.log(Level.ALL, "URL error " + e);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
