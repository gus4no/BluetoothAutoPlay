package com.gus4no.bluetoothautoplay;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import com.gus4no.bluetoothautoplay.R;
import com.gus4no.listeners.ServiceSwitchListener;

public class MainActivity extends Activity{

  private static final int REQUEST_ENABLE_BT = 10;
  BluetoothAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Switch serviceToggle = (Switch) findViewById(R.id.serviceSwitch);
    serviceToggle.setOnCheckedChangeListener(new ServiceSwitchListener());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  public void checkBlueTooth() {
    adapter = BluetoothAdapter.getDefaultAdapter();

    if (!adapter.isEnabled()) {
      Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
      startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
    }
  }    

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
      case REQUEST_ENABLE_BT:
        if (resultCode == Activity.RESULT_CANCELED) {
          Switch serviceToggle = (Switch) findViewById(R.id.serviceSwitch);
          serviceToggle.toggle();
        }
        break;
  
      default:
        super.onActivityResult(requestCode, resultCode, data);
        break;
    }
  }



}
