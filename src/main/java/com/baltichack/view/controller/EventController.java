package com.baltichack.view.controller;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import com.baltichack.view.service.EventService;
import com.baltichack.view.service.QRcodeService;
import com.baltichack.view.utils.MyFileUtils;
import com.google.zxing.WriterException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventRepo;

    @Autowired
    private QRcodeService qRcodeService;
    @Autowired
    private ServletContext servletContext;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Event> listEvents() {
        return eventRepo.listEvent();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) throws IOException {
        eventRepo.addEvent(event);
    }

    @RequestMapping(value = "/uploadLogo/{eventId}", method = RequestMethod.POST, consumes = "multipart/form-data")
    public void uploadLogoToEvent(@PathVariable("eventId") Long eventId, @RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        File resultFile = new File("/eventLogo/" + eventId, "logo");
        MyFileUtils.createFileWithDirs(resultFile);
        try (OutputStream fop = new FileOutputStream(resultFile)) {
            IOUtils.copy(file.getInputStream(), fop);
        }
        log.info("File was saved for " + eventId  +" by path " + resultFile.getAbsolutePath());
        response.setStatus(HttpStatus.OK.value());
    }

    @RequestMapping(value = "/delete/{eventId}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        eventRepo.removeEvent(eventId);
    }

    @RequestMapping(value = "/checkIn/{eventId}", method = RequestMethod.POST)
    public RedirectView checkIn(@PathVariable("eventId") Long eventId,
                                @RequestBody User user) {

        //todo add checin user


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(eventRepo.findById(eventId).getRedirectUrl());
        return redirectView;
    }

    @ResponseBody
    @RequestMapping(value = "/getQRcode/{id}", method = RequestMethod.GET)
    public void getQRcode(@PathVariable("id") Long eventId, HttpServletResponse response) throws WriterException, IOException {
        Event event = eventRepo.findById(eventId);
        try (InputStream inputStream = qRcodeService.getQRcode(eventId, event.getRedirectUrl()).getInputStream()) {
            IOUtils.copy(inputStream, response.getOutputStream());
        }
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    }
}
