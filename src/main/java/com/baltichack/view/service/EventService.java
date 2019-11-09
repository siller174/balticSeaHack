package com.baltichack.view.service;

import com.baltichack.view.entity.Event;
import com.baltichack.view.repos.EventRepo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EventService {

    @Value("${event.widthQR}")
    private int widthQR = 250;

    @Value("${event.heightQR}")
    private int heightQR = 250;

    @Autowired
    private EventRepo eventRepo;

    public void addEvent(Event event) {
//        eventRepo.save(event);
    }

    public Iterable<Event> listEvent() {
        return eventRepo.findAll();
    }

    public void removeEvent(Long id) {
//        eventRepo.deleteById(id);
    }

    public File generateQR(File file) throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("test", BarcodeFormat.QR_CODE, widthQR, heightQR);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", file.toPath());
        return file;
    }
}
