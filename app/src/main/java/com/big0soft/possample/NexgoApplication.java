package com.big0soft.possample;

import android.app.Application;

import com.big0soft.possample.redesign.CustomDeviceEngine;
import com.nexgo.oaf.apiv3.APIProxy;
import com.nexgo.oaf.apiv3.DeviceEngine;

/**
 * Created by xiaox on 16/4/28.
 */
public class NexgoApplication extends Application {

    static {
//        System.loadLibrary("libxgd_ddi_jni.so");
//        System.loadLibrary("liblibxgd_ddi_jni.so.so");
//        System.loadLibrary("liblibxgd_ddi_jni");
//        System.loadLibrary("libxgd_ddi_jni");
//        System.loadLibrary("native-lib");
    }

    public DeviceEngine deviceEngine;

    private CustomDeviceEngine customDeviceEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        deviceEngine = APIProxy.getDeviceEngine(this);
        customDeviceEngine = new CustomDeviceEngine(this, deviceEngine);
        deviceEngine.getEmvHandler2("app2");
    }

    public CustomDeviceEngine getCustomDeviceEngine() {
        return customDeviceEngine;
    }
}
