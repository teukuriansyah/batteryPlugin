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

  // Battery Level
    @PluginMethod
    public void getBatteryLevel(PluginCall call) {
       Context context = getContext();
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
       Intent batteryStatus = context.registerReceiver(null, ifilter);
      
       int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
       int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
       float batteryPct = level * 100 / (float)scale;
      
      JSObject ret = new JSObject();
      ret.put("level",batteryPct);
      call.resolve(ret);
    }

  // Is Charging
    @PluginMethod
    public void isBatteryCharging(PluginCall call) {
       Context context = getContext();
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
       Intent batteryStatus = context.registerReceiver(null, ifilter);
      
       int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                     status == BatteryManager.BATTERY_STATUS_FULL;
      
      JSObject ret = new JSObject();
      ret.put("isCharging",isCharging);
      call.resolve(ret);
    }

  // Charge type
    @PluginMethod
    public void getChargeType(PluginCall call) {
       Context context = getContext();
    IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
       Intent batteryStatus = context.registerReceiver(null, ifilter);
      
       int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
       boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
       boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
      
      JSObject ret = new JSObject();
      ret.put("chargeType",usbCharge ? "usb" : acCharge ? "ac" : "none");
      call.resolve(ret);
    }
  
}
