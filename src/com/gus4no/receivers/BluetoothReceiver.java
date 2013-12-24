package com.gus4no.receivers;

import android.app.SearchManager;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
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
        if(isHeadset){
          Toast.makeText(mContext, "Connected to " + device.getName(), Toast.LENGTH_SHORT).show();
          try {
            final Intent i = new Intent(Intent.ACTION_MAIN);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setAction(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
            i.setComponent(new ComponentName("com.spotify.mobile.android.ui", "com.spotify.mobile.android.ui.Launcher"));
            context.startActivity(i);
          } catch ( ActivityNotFoundException e ) {
            final Intent i = new Intent(Intent.ACTION_MAIN);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setAction(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
            i.setComponent(new ComponentName("com.spotify.mobile.android.ui", "com.spotify.mobile.android.ui.activity.MainActivity"));
            context.startActivity(i);
        }
        }
      }
      else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action))
      {
          Log.e("DISConnected", "DISConnected");
      }
  }

}
