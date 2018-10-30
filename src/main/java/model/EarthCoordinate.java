package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

public class EarthCoordinate {

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lon")
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }
    public EarthCoordinate(String longitude, String latitude) {
        if(StringUtils.isEmpty(longitude)) {
            throw new IllegalArgumentException("Longitude cannot be empty");
        }
        if(StringUtils.isEmpty(latitude)) {
            throw new IllegalArgumentException("Latitude cannot be empty");
        }
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }
    public EarthCoordinate(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public EarthCoordinate() {

    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonIgnore
    public double getLongitudeDouble() {
        return this.longitude;
    }
    @JsonIgnore
    public double getLatitudeDouble(){
        return this.latitude;
    }
    @Override
    public String toString() {
        return "EarthCoordinate{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

}
