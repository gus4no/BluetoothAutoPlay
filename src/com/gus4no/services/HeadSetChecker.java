package com.gus4no.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class HeadSetChecker extends Service {

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
    
    Toast.makeText(getApplicationContext(), "Service Started", Toast.LENGTH_LONG).show();
    super.onCreate();
  }
  
  @Override
  public void onDestroy() {
    Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_LONG).show();
    super.onDestroy();
  }

}
