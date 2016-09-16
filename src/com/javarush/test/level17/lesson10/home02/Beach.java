package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>{
    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;//качество

    @Override
    public synchronized int compareTo(Beach o)
    {
        int distanceParam = (int) (distance - o.getDistance());
        int qualityParam = quality - o.getQuality();
        return 10000 * name.compareTo(o.getName()) + 100 * distanceParam + qualityParam;
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
}
