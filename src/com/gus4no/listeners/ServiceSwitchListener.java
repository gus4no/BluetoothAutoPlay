package com.gus4no.listeners;

import android.bluetooth.BluetoothAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import com.gus4no.bluetoothautoplay.MainActivity;

public class ServiceSwitchListener implements OnCheckedChangeListener {

  int ENABLE_BT_REQUEST_CODE = 1;
  
  @Override
  public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    MainActivity activity = (MainActivity) buttonView.getContext();

    if(isChecked){
      BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
      if (adapter == null) {
        Toast.makeText(activity, "Your device does not support bluetooth", Toast.LENGTH_SHORT).show();
        } else {
         activity.checkBlueTooth(); 
      }
    }else{
    }
    // TODO Auto-generated method stub
    
  }

}
