package com.gus4no.services;

import com.gus4no.receivers.BluetoothReceiver;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class HeadSetChecker extends Service {
  
  BluetoothAdapter adapter;
  BluetoothHeadset headset;
  

  @Override
  public IBinder onBind(Intent intent) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    // TODO Auto-generated method stub
    return Service.START_STICKY;
  }
  
  @Override
  public void onCreate() {
    Toast.makeText(getApplicationContext(), "Auto Play Service Started", Toast.LENGTH_LONG).show();
    BluetoothReceiver receiver = new BluetoothReceiver(getApplicationContext());
    getApplicationContext().registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED));
    getApplicationContext().registerReceiver(receiver, new IntentFilter(BluetoothDevice.ACTION_ACL_DISCONNECTED));
    super.onCreate();
  }
  
  @Override
  public void onDestroy() {
    Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_LONG).show();
    super.onDestroy();
  }

}
