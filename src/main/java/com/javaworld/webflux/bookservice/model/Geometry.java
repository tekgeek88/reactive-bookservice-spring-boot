package com.javaworld.webflux.bookservice.model;

import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.CoordinateReferenceSystemType;

public class Geometry {

    public CoordinateReferenceSystemType type;

    public CoordinateReferenceSystemType getType() {
        return type;
    }

    public void setType(CoordinateReferenceSystemType type) {
        this.type = type;
    }

    public CoordinateReferenceSystem getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinateReferenceSystem coordinates) {
        this.coordinates = coordinates;
    }

    public CoordinateReferenceSystem coordinates;

}
