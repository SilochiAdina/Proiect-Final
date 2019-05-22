package ro.siit.Proiect.Final.Service;

import ro.siit.Proiect.Final.Model.Trip;

import java.util.List;

public interface TripService {
    Trip createTrip (Trip trip);
    Trip getTrip (Long id);
    Trip editTrip(Trip trip);
    void deleteTrip(Long id);
    List<Trip> getAllTrips();
}