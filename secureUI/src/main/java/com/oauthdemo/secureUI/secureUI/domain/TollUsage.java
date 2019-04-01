package com.oauthdemo.secureUI.secureUI.domain;

public class TollUsage {
    private String id;
    private String stationId;
    private String licencePlate;
    private String timestamp;

    public TollUsage(String id, String stationId, String licencePlate, String timestamp) {
        this.id = id;
        this.stationId = stationId;
        this.licencePlate = licencePlate;
        this.timestamp = timestamp;
    }

    public TollUsage() {
    }

    public String getId() {
        return id;
    }

    public String getStationId() {
        return stationId;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
