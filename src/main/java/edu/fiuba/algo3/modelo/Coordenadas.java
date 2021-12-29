package edu.fiuba.algo3.modelo;

public class Coordenadas {

    private final double latitud;
    private final double longitud;

    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }


    /**
     * This is the implementation Haversine Distance Algorithm between two places
     * @author ananth -> https://gist.github.com/vananth22/888ed9a22105670e7a4092bdcf0d72e4
     * R = earth’s radius (mean radius = 6,371km)
    Δlat = lat2− lat1
    Δlong = long2− long1
    a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
    c = 2.atan2(√a, √(1−a))
    d = R.c
     *
     */
    public int distanciaA(Coordenadas coordenadasDestino) {

        final int R = 6371; // Radius of the earth

        double latDistance = toRad(coordenadasDestino.latitud - this.latitud);
        double lonDistance = toRad(coordenadasDestino.longitud - this.longitud);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(this.latitud)) * Math.cos(toRad(coordenadasDestino.latitud)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;

        return Double.valueOf(distance).intValue();
    }

    private double toRad(double value) {
        return value * Math.PI / 180;
    }

}
