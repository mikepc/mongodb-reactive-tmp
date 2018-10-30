package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Author: Michael Draper
 * Date: 2018-10-26
 **/
@Data
public class SponsoredEventRequest {
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

    @JsonProperty("coords")
    EarthCoordinate coords;

    private String logoUrl;
    private Date eventStartUtc;
    private Date eventEndUtc;

    private String url;
}
