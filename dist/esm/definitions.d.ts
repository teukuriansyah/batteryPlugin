export interface batteryPlugin {
    getBatteryLevel(): Promise<{
        level: number;
    }>;
}
