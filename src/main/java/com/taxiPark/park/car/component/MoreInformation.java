package com.taxiPark.park.car.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class MoreInformation implements Serializable {

    private String state;
    private String securityTypes;
    private String comfortTypes;

    private static final Logger logger = LoggerFactory.getLogger(MoreInformation.class);

    public String getState() {
        return state;
    }

    public String getSecurityTypes() {
        return securityTypes;
    }

    public String getComfortTypes() {
        return comfortTypes;
    }

    public MoreInformation() {
        logger.info("Створено новий об'єкт класу MoreInformation.");
    }

    @Override
    public String toString() {
        return  "\n\tstate --------------------------- " + state +
                "\n\tsecurity types ------------------ " + securityTypes +
                "\n\tcomfort types ------------------- " + comfortTypes;
    }

    public static MoreInformationBuilder builder(){
        return new MoreInformationBuilder();
    }

    public static MoreInformationBuilder builder(MoreInformation moreInformation){
        return new MoreInformationBuilder(moreInformation);
    }

    public static class MoreInformationBuilder{
        private final MoreInformation moreInformation;

        public MoreInformationBuilder() {
            this.moreInformation = new MoreInformation();
        }

        public MoreInformationBuilder(MoreInformation moreInformation) {
            this.moreInformation = moreInformation;
        }
        public MoreInformationBuilder setState(String state){
            moreInformation.state = state;
            return this;
        }

        public MoreInformationBuilder setSecurityTypes(String securityTypes){
            moreInformation.securityTypes = securityTypes;
            return this;
        }

        public MoreInformationBuilder setComfortTypes(String comfortTypes){
            moreInformation.comfortTypes = comfortTypes;
            return this;
        }

        public MoreInformation build(){
            return this.moreInformation;
        }
    }
}