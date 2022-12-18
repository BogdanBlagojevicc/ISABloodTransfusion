package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireDTO {

    private Long id;

    private String bloodType;

    private String currentDateTime;

    private Integer previousTransfusions;

    private Integer weight;

    private Boolean isFeelsGood;

    private Boolean isSkinChanged;

    private Integer highBloodPressure;

    private Integer lowBloodPressure;

    private Boolean isPreviousTherapyMoreThanSixDays;

    private Boolean isUnderRegularMonthlyCycle;

    private Boolean isPreviousDentalInterventionMoreThanSixDays;

    private Boolean isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths;
    
    public QuestionnaireDTO() {
        
    }

    public QuestionnaireDTO(Long id, String bloodType, String currentDateTime, Integer previousTransfusions,
            Integer weight, Boolean isFeelsGood, Boolean isSkinChanged, Integer highBloodPressure,
            Integer lowBloodPressure, Boolean isPreviousTherapyMoreThanSixDays, Boolean isUnderRegularMonthlyCycle,
            Boolean isPreviousDentalInterventionMoreThanSixDays,
            Boolean isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths) {
        this.id = id;
        this.bloodType = bloodType;
        this.currentDateTime = currentDateTime;
        this.previousTransfusions = previousTransfusions;
        this.weight = weight;
        this.isFeelsGood = isFeelsGood;
        this.isSkinChanged = isSkinChanged;
        this.highBloodPressure = highBloodPressure;
        this.lowBloodPressure = lowBloodPressure;
        this.isPreviousTherapyMoreThanSixDays = isPreviousTherapyMoreThanSixDays;
        this.isUnderRegularMonthlyCycle = isUnderRegularMonthlyCycle;
        this.isPreviousDentalInterventionMoreThanSixDays = isPreviousDentalInterventionMoreThanSixDays;
        this.isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths = isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths;
    }

    public QuestionnaireDTO(String bloodType, String currentDateTime, Integer previousTransfusions,
    Integer weight, Boolean isFeelsGood, Boolean isSkinChanged, Integer highBloodPressure,
    Integer lowBloodPressure, Boolean isPreviousTherapyMoreThanSixDays, Boolean isUnderRegularMonthlyCycle,
    Boolean isPreviousDentalInterventionMoreThanSixDays,
    Boolean isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths) {
        this.bloodType = bloodType;
        this.currentDateTime = currentDateTime;
        this.previousTransfusions = previousTransfusions;
        this.weight = weight;
        this.isFeelsGood = isFeelsGood;
        this.isSkinChanged = isSkinChanged;
        this.highBloodPressure = highBloodPressure;
        this.lowBloodPressure = lowBloodPressure;
        this.isPreviousTherapyMoreThanSixDays = isPreviousTherapyMoreThanSixDays;
        this.isUnderRegularMonthlyCycle = isUnderRegularMonthlyCycle;
        this.isPreviousDentalInterventionMoreThanSixDays = isPreviousDentalInterventionMoreThanSixDays;
        this.isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths = isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths;
}

    

}
