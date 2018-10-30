package service;

import lombok.extern.slf4j.Slf4j;
import model.SponsoredEvent;
import model.SponsoredEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/
@Service
@Slf4j
public class SponsoredEventServiceImpl implements SponsoredEventService {

    @Autowired
    MongoTemplate mongoTemplate;

    private Mono<SponsoredEventRequest> validateSponsoredEventRequest(SponsoredEventRequest eventRequest){
        return Mono.just(eventRequest);
    }

    private Mono<SponsoredEvent> saveSponsoredEvent(SponsoredEventRequest ser) {
        // Pivots the request into an actual event
        SponsoredEvent newSponsoredEvent = new SponsoredEvent(ser);
        //Stores the event in Mongo
        mongoTemplate.save(newSponsoredEvent);
        // Outputs the saved object.
        log.info("sponsored event: {} [{}] created", newSponsoredEvent.getId(), newSponsoredEvent.getTitle());
        return Mono.just(newSponsoredEvent);

    }

    @Override
    public Mono<SponsoredEvent> createSponsoredEvent(Mono<SponsoredEventRequest> se) {
        return se.flatMap( ser ->  validateSponsoredEventRequest(ser) )
                .doOnSuccess((ser) -> log.info("sponsored event request passed validation"))
                .doOnError((err) -> log.error("sponsored event FAILED validation"))
                .flatMap( (ser) -> saveSponsoredEvent(ser));


    }
}
