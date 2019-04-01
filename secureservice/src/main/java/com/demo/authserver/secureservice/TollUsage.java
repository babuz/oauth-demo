package com.demo.authserver.secureservice;

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
}
