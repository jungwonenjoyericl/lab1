import java.awt.*;

public class Car {

    protected boolean turboOn;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    //public Car(){
        //nrDoors = 2;
        //color = Color.red;
        //enginePower = 125;
        //turboOn = false;
        //modelName = "Saab95";
      //  stopEngine();
    //}

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){  // restructure for readability -- remove nested ifs 
        if ((amount >= 0) && (amount <= 1)) {
            double v1 = getCurrentSpeed();
            incrementSpeed(amount);
            if (getCurrentSpeed() > v1) { //can't slow down
                if (getCurrentSpeed() < getEnginePower()) {
                    decrementSpeed(amount);
                }
            }
        }
    }


    // TODO fix this method according to lab pm
    public void brake(double amount){
        if ((amount >= 0) && (amount <= 1)) {
            double v1 = getCurrentSpeed();
            decrementSpeed(amount);
            if (getCurrentSpeed() < v1) { // undo if brake speeds up car
                if (getCurrentSpeed() > 0) {
                    incrementSpeed(amount);
                }
            }
        }
    }
}
