package com.example.sailik.bluetooth_13_feb;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    AlertDialog alert;

    private final BroadcastReceiver mybroadcast = new StatusReciver();

    private BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(mybroadcast, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Bluetooth is OFF!!");
        alert = builder.create();


        if (BA.isEnabled()) {
            if(alert.isShowing()){
                alert.dismiss();
            }
            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();
        }
        else{
            alert.show();}

    }
    @Override
    protected void onResume(){
        super.onResume();
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Bluetooth is OFF!!");
        alert = builder.create();
        if (BA.isEnabled()) {
            if(alert.isShowing()){
                alert.dismiss();
                Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Bluetooth is ON", Toast.LENGTH_SHORT);
        }
        else if(!BA.isEnabled()){
            alert.show();}
        else{
            Toast.makeText(this,"something is wrong",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(mybroadcast);

    }
}



