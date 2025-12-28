package DomainLayer;

public class Facility {
    private String id;
    private String name;
    private String type;
    private String location;
    private int capacity;
    private double price;
    private String status;      // "Active" or "Inactive"
    private String description;
    private String amenities;   // stored as "WiFi;Projector;Parking"
    private String imageURL;

    public Facility(String id, String name, String type, String location, int capacity, 
                    double price, String status, String description, String amenities, String imageURL) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
        this.description = description;
        this.amenities = amenities;
        this.imageURL = imageURL;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public String getAmenities() { return amenities; }
    public String getType() { return type; }

    @Override
    public String toString() {
        // CSV Format: id,name,type,location,capacity,price,status,description,amenities,imageURL
        return id + "," + name + "," + type + "," + location + "," + capacity + "," + 
               price + "," + status + "," + description + "," + amenities + "," + imageURL;
    }
}