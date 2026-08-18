package com.testing.plugin.battery;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "battery")
public class batteryPlugin extends Plugin {

    Context context = getContext();
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
    Intent batteryStatus = context.registerReceiver(null, ifilter);
  
    @PluginMethod
    public void getBatteryLevel(PluginCall call) {
       int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
       int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
       float batteryPct = level * 100 / (float)scale;
      
      JSObject ret = new JSObject();
      ret.put("level",batteryPct);
      call.resolve(ret);
    }
  
}
