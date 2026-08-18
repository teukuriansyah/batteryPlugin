package com.testing.plugin.battery;

import com.getcapacitor.Logger;

public class battery {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }
}
