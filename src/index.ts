import { registerPlugin } from '@capacitor/core';

import type { batteryPlugin } from './definitions';

const battery = registerPlugin<batteryPlugin>('battery', {
  web: () => import('./web').then((m) => new m.batteryWeb()),
});

export * from './definitions';
export { battery };
