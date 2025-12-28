package DomainLayer;

public class Booking {
    private String id;
    private String facilityName;
    private String memberName;
    private String status;
    private String date;
    private String time;
    
    // New fields from Screenshot
    private String memberEmail;
    private String memberPhone;
    private String bookedOn;      // e.g., "December 10, 2025"
    private String paymentMethod; // e.g., "Visa **** 4242"
    private double serviceFee;

    public Booking(String id, String facilityName, String memberName, String status, 
                   String date, String time, String memberEmail, String memberPhone, 
                   String bookedOn, String paymentMethod, double serviceFee) {
        this.id = id;
        this.facilityName = facilityName;
        this.memberName = memberName;
        this.status = status;
        this.date = date;
        this.time = time;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.bookedOn = bookedOn;
        this.paymentMethod = paymentMethod;
        this.serviceFee = serviceFee;
    }

    public String getId() { return id; }
    public String getFacilityName() { return facilityName; }
    public String getMemberName() { return memberName; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    
    // New Getters
    public String getMemberEmail() { return memberEmail; }
    public String getMemberPhone() { return memberPhone; }
    public String getBookedOn() { return bookedOn; }
    public String getPaymentMethod() { return paymentMethod; }
    public double getServiceFee() { return serviceFee; }
}