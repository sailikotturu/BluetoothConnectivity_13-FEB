package com.example.sailik.bluetooth_13_feb;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.List;


/**
 * Created by saili.k on 13-02-2017.
 */

public class StatusReciver extends BroadcastReceiver {



        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
                    -1);
            Intent i = new Intent(context, MainActivity.class);

            switch(state){
                case BluetoothAdapter.STATE_OFF:
                    context.startActivity(i);
                    break;
                case BluetoothAdapter.STATE_ON:
                    context.startActivity(i);
                    break;

            }
        }


}
