package com.gus4no.receivers;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BluetoothReceiver extends BroadcastReceiver {
  Context mContext;
  public BluetoothReceiver(Context applicationContext) {
    mContext = applicationContext;
  }

  @Override
  public void onReceive(Context context, Intent intent)
  {
      String action = intent.getAction();
      if (BluetoothDevice.ACTION_ACL_CONNECTED.equals(action))
      {
        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        boolean isHeadset = device.getBluetoothClass().getDeviceClass() == BluetoothClass.Device.AUDIO_VIDEO_WEARABLE_HEADSET ? true : false;
        if(isHeadset)
          Toast.makeText(mContext, "Connected to " + device.getName(), Toast.LENGTH_SHORT).show();

      }
      else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action))
      {
          Log.e("DISConnected", "DISConnected");
      }
  }

}
