export interface batteryPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
