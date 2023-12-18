package com.big0soft.possample.redesign;

import android.content.Context;

import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.DeviceInfo;
import com.nexgo.oaf.apiv3.OnAppOperatListener;
import com.nexgo.oaf.apiv3.card.cpu.CPUCardHandler;
import com.nexgo.oaf.apiv3.card.memory.MemoryCardHandler;
import com.nexgo.oaf.apiv3.card.mifare.DesfireHandler;
import com.nexgo.oaf.apiv3.card.mifare.M1CardHandler;
import com.nexgo.oaf.apiv3.card.mifare.M1PlusCardHandler;
import com.nexgo.oaf.apiv3.card.ntag.NTAGCardHandler;
import com.nexgo.oaf.apiv3.card.rf15693.Rf15693CardHandler;
import com.nexgo.oaf.apiv3.card.ultralight.UltralightCCardHandler;
import com.nexgo.oaf.apiv3.card.ultralight.UltralightEV1CardHandler;
import com.nexgo.oaf.apiv3.device.beeper.Beeper;
import com.nexgo.oaf.apiv3.device.led.LEDDriver;
import com.nexgo.oaf.apiv3.device.mdb.led.MdbLEDDriver;
import com.nexgo.oaf.apiv3.device.mdb.serialport.MdbSerialPortDriver;
import com.nexgo.oaf.apiv3.device.numberkeyborad.NumberKeyborad;
import com.nexgo.oaf.apiv3.device.pinpad.PinPad;
import com.nexgo.oaf.apiv3.device.printer.Printer;
import com.nexgo.oaf.apiv3.device.printer.QueuePrinter;
import com.nexgo.oaf.apiv3.device.reader.CardReader;
import com.nexgo.oaf.apiv3.device.reader.CardSlotTypeEnum;
import com.nexgo.oaf.apiv3.device.scanner.Scanner;
import com.nexgo.oaf.apiv3.device.scanner.Scanner2;
import com.nexgo.oaf.apiv3.device.serialport.SerialPortDriver;
import com.nexgo.oaf.apiv3.device.usbserial.UsbSerial;
import com.nexgo.oaf.apiv3.emv.EmvHandler;
import com.nexgo.oaf.apiv3.emv.EmvHandler2;
import com.nexgo.oaf.apiv3.facedetect.FaceDevice;
import com.nexgo.oaf.apiv3.hsm.HSMDevice;
import com.nexgo.oaf.apiv3.platform.Platform;

public class CustomDeviceEngine implements DeviceEngine {
    private final Context context;
    private final DeviceEngine deviceEngine;

    public CustomDeviceEngine(Context context, DeviceEngine deviceEngine) {
        this.context = context;
        this.deviceEngine = deviceEngine;
    }

    @Override
    public Beeper getBeeper() {
        return deviceEngine.getBeeper();
    }

    @Override
    public LEDDriver getLEDDriver() {
        return deviceEngine.getLEDDriver();
    }

    @Override
    public Printer getPrinter() {
        return deviceEngine.getPrinter();
    }

    @Override
    public SerialPortDriver getSerialPortDriver(int i) {
        return new CustomSerialPortDriver(context, i);
    }

    @Override
    public CardReader getCardReader() {
        return deviceEngine.getCardReader();
    }

    @Override
    public CPUCardHandler getCPUCardHandler(CardSlotTypeEnum cardSlotTypeEnum) {
        return deviceEngine.getCPUCardHandler(cardSlotTypeEnum);
    }

    @Override
    public M1CardHandler getM1CardHandler() {
        return deviceEngine.getM1CardHandler();
    }

    @Override
    public MemoryCardHandler getMemoryCardHandler(CardSlotTypeEnum cardSlotTypeEnum) {
        return deviceEngine.getMemoryCardHandler(cardSlotTypeEnum);
    }

    @Override
    public DesfireHandler getDesfireHandler() {
        return deviceEngine.getDesfireHandler();
    }

    @Override
    public PinPad getPinPad() {
        return deviceEngine.getPinPad();
    }

    @Override
    public NumberKeyborad getNumberKeyborad() {
        return deviceEngine.getNumberKeyborad();
    }

    @Override
    public EmvHandler getEmvHandler(String s) {
        return deviceEngine.getEmvHandler(s);
    }

    @Override
    public EmvHandler2 getEmvHandler2(String s) {
        return deviceEngine.getEmvHandler2(s);
    }

    @Override
    public Scanner getScanner() {
        return deviceEngine.getScanner();
    }

    @Override
    public Scanner2 getScanner2() {
        return deviceEngine.getScanner2();
    }

    @Override
    public FaceDevice getFaceDevice() {
        return deviceEngine.getFaceDevice();
    }

    @Override
    public HSMDevice getHSMDevice() {
        return deviceEngine.getHSMDevice();
    }

    @Override
    public void setSystemClock(String s) {
        deviceEngine.setSystemClock(s);
    }

    @Override
    public int installApp(String s, OnAppOperatListener onAppOperatListener) {
        return deviceEngine.installApp(s, onAppOperatListener);
    }

    @Override
    public int uninstallApp(String s, OnAppOperatListener onAppOperatListener) {
        return deviceEngine.uninstallApp(s, onAppOperatListener);
    }

    @Override
    public DeviceInfo getDeviceInfo() {
        return deviceEngine.getDeviceInfo();
    }

    @Override
    public UltralightCCardHandler getUltralightCCardHandler() {
        return deviceEngine.getUltralightCCardHandler();
    }

    @Override
    public Rf15693CardHandler getRf15693CardHandler() {
        return deviceEngine.getRf15693CardHandler();
    }

    @Override
    public Platform getPlatform() {
        return deviceEngine.getPlatform();
    }

    @Override
    public UsbSerial getUsbSerial() {
        return deviceEngine.getUsbSerial();
    }

    @Override
    public UltralightEV1CardHandler getUltralightEV1CardHandler() {
        return deviceEngine.getUltralightEV1CardHandler();
    }

    @Override
    public NTAGCardHandler getNTAGCardHandler() {
        return deviceEngine.getNTAGCardHandler();
    }

    @Override
    public MdbLEDDriver getMdbLEDDriver() {
        return deviceEngine.getMdbLEDDriver();
    }

    @Override
    public MdbSerialPortDriver getMdbSerialPortDriver() {
        return deviceEngine.getMdbSerialPortDriver();
    }

    @Override
    public QueuePrinter getQueuePrinter() {
        return deviceEngine.getQueuePrinter();
    }

    @Override
    public M1PlusCardHandler getM1PlusCardHandler() {
        return deviceEngine.getM1PlusCardHandler();
    }
}
