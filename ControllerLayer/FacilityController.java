package ControllerLayer;

import DataLayer.FacilityDAO;
import DomainLayer.Facility;
import java.util.List;
import java.util.UUID;

public class FacilityController {
    private FacilityDAO facilityDAO;

    public FacilityController() {
        this.facilityDAO = new FacilityDAO();
    }

    public List<Facility> getAllFacilities() {
        return facilityDAO.findAll();
    }


    public void addNewFacility(String name, String type, String location, int capacity, 
                               double price, String description, String status, 
                               String amenities, String imageURL) {
        
        // Auto-generate ID 
        String id = "FAC-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        
        Facility f = new Facility(id, name, type, location, capacity, price, status, description, amenities, imageURL);
        facilityDAO.insert(f);
    }
}