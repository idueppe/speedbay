package io.crowdcode.speedbay.product.controller;

import io.crowdcode.speedbay.product.model.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RestController
@RequestMapping(value = "/messages")
public class MessageController {


    private List<Message> messages = Arrays.asList(new Message().withAuthor("ingo").withText("hi!"));

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getMessages() {
        return messages;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createMessage(Message message, UriComponentsBuilder uriBuilder) throws MalformedURLException, URISyntaxException {
        messages.add(message);
        message.setUuid(UUID.randomUUID().toString());

        URI uri = uriBuilder.path("/messages/{messageId}").buildAndExpand("messageId", message.getUuid()).toUri();

        return ResponseEntity.created(uri).body(message);
    }

}