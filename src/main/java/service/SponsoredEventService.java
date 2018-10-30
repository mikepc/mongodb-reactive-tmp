package service;

import model.SponsoredEvent;
import model.SponsoredEventRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/

public interface SponsoredEventService {
    Mono<SponsoredEvent> createSponsoredEvent(Mono<SponsoredEventRequest> eventRequest);
}
