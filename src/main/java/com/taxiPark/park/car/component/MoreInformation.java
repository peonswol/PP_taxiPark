package com.taxiPark.park.car.component;

import java.io.Serializable;

public class MoreInformation implements Serializable {

    private String state;
    private String securityTypes;
    private String comfortTypes;

    public String getState() {
        return state;
    }

    public String getSecurityTypes() {
        return securityTypes;
    }

    public String getComfortTypes() {
        return comfortTypes;
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