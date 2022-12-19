package ru.mfc.mfcreference.dto;

public class OfficeNameDto {

    private String email;
    private Long id;
    private Double latitude;
    private String legalAddressDescription;
    private Double longitude;
    private String name;
    private String phone;
    private String shortName;
    private String workingHours;

    public OfficeNameDto(Long id,  String name, String email, String phone, Double latitude, Double longitude,
                         String shortName, String workingHours, String legalAddressDescription) {
        this.id = id;
        this.email = email;
        this.latitude = latitude;
        this.legalAddressDescription = legalAddressDescription;
        this.longitude = longitude;
        this.name = name;
        this.phone = phone;
        this.shortName = shortName;
        this.workingHours = workingHours;
    }

    public OfficeNameDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLegalAddressDescription() {
        return legalAddressDescription;
    }

    public void setLegalAddressDescription(String legalAddressDescription) {
        this.legalAddressDescription = legalAddressDescription;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
}
