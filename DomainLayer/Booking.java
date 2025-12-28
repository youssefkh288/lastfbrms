package DomainLayer;

public class Booking {
    private String id;
    private String facilityName;
    private String memberName;
    private String date;
    private String time;

    public Booking(String id, String facilityName, String memberName, String date, String time) {
        this.id = id;
        this.facilityName = facilityName;
        this.memberName = memberName;
        this.date = date;
        this.time = time;
    }

    public String getId() { return id; }
    public String getFacilityName() { return facilityName; }
    public String getMemberName() { return memberName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}