export interface batteryPlugin {
  getBatteryLevel():Promise<{ level:number }>;
  isBatteryCharging():Promise<{ isCharging:boolean }>;
  getChargeType():Promise<{ chargeType:string }>;
  getBatteryTemperature():Promise<{ batteryTemperature:number }>;
  getBatteryVoltage():Promise<{ batteryVoltage:number }>;
  getBatteryCurrent():Promise<{ batteryCurrent:number }>;
  getBatteryHealth():Promise<{ batteryHealth:string }>;
}
