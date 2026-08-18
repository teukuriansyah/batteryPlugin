import { WebPlugin } from '@capacitor/core';

import type { batteryPlugin } from './definitions';

export class batteryWeb extends WebPlugin implements batteryPlugin {
  async getBatteryLevel():Promise<{ level:number}> {
    throw new Error("This plugin not compatible for web")
  }
  async isBatteryCharging():Promise<{ isCharging:boolean}> {
    throw new Error("This plugin not compatible for web")
  }
  async getChargeType():Promise<{ chargeType:string}> {
    throw new Error("This plugin not compatible for web")
  }
  async getBatteryTemperature():Promise<{ chargeType:string}> {
    throw new Error("This plugin not compatible for web")
  }
  async getBatteryCurrent():Promise<{ batteryCurrent:string}> {
    throw new Error("This plugin not compatible for web")
  }
  async getBatteryHealth():Promise<{ batteryHealth:string}> {
    throw new Error("This plugin not compatible for web")
  }
}
