package models;

public class AddressData {
    private String fullName;
    private String mobileNumber;
    private String streetName;
    private String buildingNumber;
    private String citytxt;
    private String districttxt;


    //Constructor
    public AddressData(String fullName,String mobileNumber,String streetName,String buildingNumber,String citytxt,String districttxt){
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.citytxt = citytxt;
        this.districttxt = districttxt;

    }
    //Getters
    public  String getFullName()
    {
        return fullName;
    }
    public  String getMobileNumber()
    {
        return mobileNumber;
    }
    public  String getStreetName()
    {
        return streetName;
    }
    public  String getBuildingNumber()
    {
        return buildingNumber;
    }
    public  String getCityTxt()
    {
        return citytxt;
    }
    public  String getDistrictTxt()
    {
        return districttxt;
    }
}
