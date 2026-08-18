package com.testing.plugin.battery;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "battery")
public class batteryPlugin extends Plugin {

    private battery implementation = new battery();

    @PluginMethod
    public void getBatteryLevel(PluginCall call) {
      JSObject ret = new JSObject();
      ret.put("level",100)
      call.resolve(ret);
    }
  
}
