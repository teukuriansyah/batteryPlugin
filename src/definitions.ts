export interface batteryPlugin {
  getBatteryLevel():Promise<{ level:number }>;
  isBatteryCharging():Promise<{ isCharging:boolean }>;
}
