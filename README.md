# battery

-

## Install

To use npm

```bash
npm install battery
````

To use yarn

```bash
yarn add battery
```

Sync native files

```bash
npx cap sync
```

## API

<docgen-index>

* [`getBatteryLevel()`](#getbatterylevel)
* [`isBatteryCharging()`](#isbatterycharging)
* [`getChargeType()`](#getchargetype)
* [`getBatteryTemperature()`](#getbatterytemperature)
* [`getBatteryVoltage()`](#getbatteryvoltage)
* [`getBatteryCurrent()`](#getbatterycurrent)
* [`getBatteryHealth()`](#getbatteryhealth)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getBatteryLevel()

```typescript
getBatteryLevel() => Promise<{ level: number; }>
```

**Returns:** <code>Promise&lt;{ level: number; }&gt;</code>

--------------------


### isBatteryCharging()

```typescript
isBatteryCharging() => Promise<{ isCharging: boolean; }>
```

**Returns:** <code>Promise&lt;{ isCharging: boolean; }&gt;</code>

--------------------


### getChargeType()

```typescript
getChargeType() => Promise<{ chargeType: string; }>
```

**Returns:** <code>Promise&lt;{ chargeType: string; }&gt;</code>

--------------------


### getBatteryTemperature()

```typescript
getBatteryTemperature() => Promise<{ batteryTemperature: number; }>
```

**Returns:** <code>Promise&lt;{ batteryTemperature: number; }&gt;</code>

--------------------


### getBatteryVoltage()

```typescript
getBatteryVoltage() => Promise<{ batteryVoltage: number; }>
```

**Returns:** <code>Promise&lt;{ batteryVoltage: number; }&gt;</code>

--------------------


### getBatteryCurrent()

```typescript
getBatteryCurrent() => Promise<{ batteryCurrent: number; }>
```

**Returns:** <code>Promise&lt;{ batteryCurrent: number; }&gt;</code>

--------------------


### getBatteryHealth()

```typescript
getBatteryHealth() => Promise<{ batteryHealth: string; }>
```

**Returns:** <code>Promise&lt;{ batteryHealth: string; }&gt;</code>

--------------------

</docgen-api>
