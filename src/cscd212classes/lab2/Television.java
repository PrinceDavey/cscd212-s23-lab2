package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television>{

    private final boolean fourK;

    private final String make;

    private final String model;

    private final int resolution;

    private final int screenSize;

    private final boolean smart;

    public Television(final String make,
                      final String model,
                      final boolean smart,
                      final int screenSize,
                      final int resolution){

        if(model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        this.fourK = resolution == 2160;

    }

    public Television(final String model,
                      final boolean smart,
                      final int screenSize,
                      final int resolution,
                      final String make){

        Television tv = new Television(make, model, smart, screenSize, resolution);

        this.make = tv.make;
        this.model = tv.model;
        this.smart = tv.smart;
        this.screenSize = tv.screenSize;
        this.resolution = tv.resolution;
        this.fourK = tv.fourK;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && make.equals(that.make) && model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.fourK) + this.resolution + Boolean.hashCode(smart) + make.hashCode() + model.hashCode();
    }

    @Override
    public String toString() {
        String smart;
        String fourk;

        if (this.smart == true){smart = "smart tv";}else{smart = "tv";}
        if (this.fourK == true){fourk = " with 4K resolution";}else{fourk = " with " + getResolution() + " resolution";}


        return (getMake() + "-" + getModel() + ", " + getScreenSize() + " inch " + smart + fourk);
    }

    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        if (this.make.compareTo(another.make) == 0) {
            if (this.model.compareTo(another.model) == 0) {
                return this.screenSize - another.screenSize;
            }
            return this.model.compareTo(another.model);
        }
        return this.make.compareTo(another.make);
    }

}
