import { registerPlugin } from '@capacitor/core';

import type { batteryPlugin } from './definitions';

const battery = registerPlugin<batteryPlugin>('battery');

export * from './definitions';
export { battery };
