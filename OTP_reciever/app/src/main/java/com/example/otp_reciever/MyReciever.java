package com.example.otp_reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class MyReciever extends BroadcastReceiver {

    private static EditText editText_otp;

    public void setEditText_otp(EditText editText) {
        MyReciever.editText_otp = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage smsMessage : smsMessages) {
            String message_body = smsMessage.getMessageBody();
            String getOTP = message_body.split(":")[1];
            editText_otp.setText("hello"+getOTP);

        }
    }
}
