package com.big0soft.possample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nexgo.common.LogUtils;
import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.OnAppOperatListener;
import com.nexgo.oaf.apiv3.platform.Platform;

public class PlatformActivity extends AppCompatActivity {

    private DeviceEngine deviceEngine;
    private Platform platform;
    private boolean homeButtonFlag = true;
    private boolean taskButtonFlag = true;
    private boolean powerButtonFlag = true;
    private boolean controlBarFlag = true;
    private boolean bottomBarFlag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);
        deviceEngine = ((NexgoApplication) getApplication()).deviceEngine;
        platform = deviceEngine.getPlatform();
    }


    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.installAPK) {//silent install apk, pass the path of the apk
            platform.installApp("/sdcard/app-debug.apk", new OnAppOperatListener() {
                @Override
                public void onOperatResult(int i) {
                    LogUtils.debug("installApp ret :{}", i);

                }
            });
        } else if (id == R.id.uninstall) {//silent uninstall apk,pass the package name of the apk
            platform.uninstallApp("com.example.demo", new OnAppOperatListener() {
                @Override
                public void onOperatResult(int i) {
                    LogUtils.debug("uninstallApp ret :{}", i);
                }
            });
        } else if (id == R.id.updateOS) {
            platform.updateFirmware("/sdcard/update_new.zip");
        } else if (id == R.id.shutdown) {
            platform.shutDownDevice();
        } else if (id == R.id.reboot) {
            platform.rebootDevice();
        } else if (id == R.id.home) {
            if (homeButtonFlag) {
                platform.enableHomeButton();
            } else {
                platform.disableHomeButton();
            }
            homeButtonFlag = !homeButtonFlag;
        } else if (id == R.id.task) {
            if (taskButtonFlag) {
                platform.enableTaskButton();
            } else {
                platform.disableTaskButton();
            }
            taskButtonFlag = !taskButtonFlag;
        } else if (id == R.id.power) {
            if (powerButtonFlag) {
                platform.enablePowerButton();
            } else {
                platform.disablePowerButton();
            }
            powerButtonFlag = !powerButtonFlag;
        } else if (id == R.id.controlBar) {
            if (controlBarFlag) {
                platform.enableControlBar();
            } else {
                platform.disableControlBar();
            }
            controlBarFlag = !controlBarFlag;
        } else if (id == R.id.bottomBar) {
            if (bottomBarFlag) {
                platform.showNavigationBar();
            } else {
                platform.hideNavigationBar();
            }
            bottomBarFlag = !bottomBarFlag;
        }
    }


}
