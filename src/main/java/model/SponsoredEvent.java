package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.mongodb.client.model.geojson.Point;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 *
 type Seed struct {
 Title                   string `json:"title"`
 Description             string `json:"description"`
 PostedBy                string `json:"postedBy"`
 StartDate               int64  `json:"startDate""`
 CreatedDate             int64  `json:"created"`
 ModifiedDate            int64  `json:"modified"`
 ExpiresDate             int64  `json:"expires"`
 Longitude               string `json:"longitude"`
 Latitude                string `json:"latitude"`
 LogoUrl                 string `json:"logoUrl"`
 EventbriteId            string `json:"eventbriteId"`
 EventbriteUpdatedAtDate int64  `json:"eventbriteUpdatedAt"`
 EventStartUtc           int64  `json:"eventStartUtc"`
 EventEndUtc             int64  `json:"eventEndUtc"`
 Location                EarthCoordinate `json:"coords"`
 Distance                float64 `json:"distance"`
 URL                     string `json:"url"`
 }

 **/
@Document
@Data
public class SponsoredEvent {

    @Id
    private String id;
    private String title;
    private String description;
    private String postedBy;

    private Date startDate;
    private String longitude;
    private String latitude;

    @JsonProperty("created")
    private Date createdDate;
    @JsonProperty("modified")
    private Date modifiedDate;
    @JsonProperty("expires")
    private Date expiresDate;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    @JsonProperty("coords")
    Point coords;

    private String logoUrl;
    private Date eventStartUtc;
    private Date eventEndUtc;

    private String url;

    public SponsoredEvent(SponsoredEventRequest eventRequest){
        this.setTitle(eventRequest.getTitle());
        this.setDescription(eventRequest.getDescription());

    }

}
