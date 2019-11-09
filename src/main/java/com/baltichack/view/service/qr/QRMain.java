package com.baltichack.view.service.qr;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class QRMain implements IFile {
    public static void main(String[] args) {
        Client client = new Client(1);
        File file = generateQR(client, null);
        System.out.println(file.getPath());
        readQR();
    }

    private static File generateQR(Client client, URL url) {
        String clientID = String.valueOf(client.getId());
        try {
            QRCodeGenerator.generateQRCodeImage("QR code for " + clientID, 350, 350);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        return FILE_QR;
    }

    private static void readQR() {
        try {
            String decodedText = QRCodeReader.decodeQRCode();
            if (decodedText == null) {
                System.out.println("No QR Code found in the image");
            } else {
                System.out.println("Decoded text = " + decodedText);
            }
        } catch (IOException e) {
            System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
        }
    }
}

