package web;



import lombok.extern.slf4j.Slf4j;
import model.SponsoredEvent;
import model.SponsoredEventRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import service.SponsoredEventService;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/
@Slf4j
@Component
public class SponsoredEventHandler {
    private final SponsoredEventService sponsoredEventService;

    public SponsoredEventHandler(SponsoredEventService sponsoredEventService) {
        this.sponsoredEventService = sponsoredEventService;
    }

    public Mono<ServerResponse> createSponsoredEvent(ServerRequest req) {
        Mono<SponsoredEventRequest> newEventRequest = req.bodyToMono(SponsoredEventRequest.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.sponsoredEventService.createSponsoredEvent(newEventRequest), SponsoredEvent.class);


    }
}
