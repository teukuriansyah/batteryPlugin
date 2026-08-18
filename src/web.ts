import { WebPlugin } from '@capacitor/core';

import type { batteryPlugin } from './definitions';

export class batteryWeb extends WebPlugin implements batteryPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
