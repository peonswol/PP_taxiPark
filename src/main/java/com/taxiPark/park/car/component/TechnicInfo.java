package com.taxiPark.park.car.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class TechnicInfo implements Serializable {

    private String transmission; //коробка передач
    private String driveType; //тип приводу

    private static final Logger logger = LoggerFactory.getLogger(TechnicInfo.class);

    public String getTransmission() {
        return transmission;
    }

    public String getDriveType() {
        return driveType;
    }

    public TechnicInfo() {
        logger.info("Створено новий об'єкт класу TechnicInfo.");
    }

    @Override
    public String toString() {
        return  "\n\ttransmission -------------------- " + transmission +
                "\n\tdrive type ---------------------- " + driveType;
    }

    public static TechnicInfoBuilder builder(){
        return new TechnicInfoBuilder();
    }

    public static TechnicInfoBuilder builder(TechnicInfo technicInfo){
        return new TechnicInfoBuilder(technicInfo);
    }

    public static class TechnicInfoBuilder{
        private final TechnicInfo technicInfo;

        public TechnicInfoBuilder() {
            this.technicInfo = new TechnicInfo();
        }

        public TechnicInfoBuilder(TechnicInfo technicInfo) {
            this.technicInfo = technicInfo;
        }

        public TechnicInfoBuilder setTransmission(String transmission){
            technicInfo.transmission = transmission;
            return this;
        }

        public TechnicInfoBuilder setDriveType(String driveType){
            technicInfo.driveType = driveType;
            return this;
        }

        public TechnicInfo build(){
            return this.technicInfo;
        }
    }
}
