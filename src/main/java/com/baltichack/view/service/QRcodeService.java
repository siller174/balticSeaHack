package com.baltichack.view.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class QRcodeService {


    @Value("${event.widthQR}")
    private int widthQR = 250;

    @Value("${event.heightQR}")
    private int heightQR = 250;

    /**
     * Generate QR code, if file is not exist
     */
    public FileSystemResource getQRcode(Long eventId, String url) throws WriterException, IOException {

        File file = new File("/tmp", "qr" + eventId + ".png");
        if (file.exists()) {
            return new FileSystemResource(file);
        }
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, widthQR, heightQR);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", file.toPath());
        return new FileSystemResource(file);
    }
}
