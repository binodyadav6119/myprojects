package com.twitter.Twitter.designpattern;

public class Car {
    private String engine;
    private int wheels;

    public Car(CarBuilder carBuilder) {
        this.engine=carBuilder.engine;
        this.wheels= carBuilder.wheels;
    }


    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public static class CarBuilder
    {
        private String engine;
        private int wheels;



        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;

        }



        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build()
        {
            return new Car(this);
        }
    }
}


//