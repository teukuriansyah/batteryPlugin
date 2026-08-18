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

    // Battery Temperature
    @PluginMethod
    public void getBatteryTemperature(PluginCall call) {
       Context context = getContext();
       IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
Intent batteryStatus = context.registerReceiver(null, ifilter);
      
      int rawTemp = batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
      float celsius = (float) rawTemp / 10.0f;
    
      JSObject ret = new JSObject();
      ret.put("batteryTemperature",celsius);
      call.resolve(ret);
    }
  
    // Battery Voltage
    @PluginMethod
    public void getBatteryVoltage(PluginCall call) {
       Context context = getContext();
       IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
Intent batteryStatus = context.registerReceiver(null, ifilter);
      
      int rawVoltage = batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
      float voltageInVolts = rawVoltage > 1000 ? rawVoltage / 1000f : rawVoltage;
    
      JSObject ret = new JSObject();
      ret.put("batteryVoltage",voltageInVolts);
      call.resolve(ret);
    }
  
    // Battery Current
    @PluginMethod
    public void getBatteryCurrent(PluginCall call) {
       Context context = getContext();
       BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);

      long currentNow = batteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW);
    
      JSObject ret = new JSObject();
      ret.put("batteryCurrent",currentNow);
      call.resolve(ret);
    }
  
    // Battery Health
    @PluginMethod
    public void getBatteryHealth(PluginCall call) {
       Context context = getContext();
       IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
      Intent batteryStatus = context.registerReceiver(null, ifilter);

      int health = batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);

      JSObject ret = new JSObject();
      if(health == 1) {
        ret.put("batteryHealth","Unknown");
      } else if(health == 2) {
        ret.put("batteryHealth","Good");
      } else if(health == 3) {
        ret.put("batteryHealth","Overheat");
      } else if(health == 4) {
        ret.put("batteryHealth","Dead");
      } else if(health == 5) {
        ret.put("batteryHealth","Over voltage");
      }
      call.resolve(ret);
    }
  
}
