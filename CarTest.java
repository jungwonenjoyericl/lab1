import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.Test;

class MyFirstJUnitJupiterTests {



    private Volvo240 volvo240 = new Volvo240();

	@Test
	public void testGas() {
        double v0 = volvo240.getCurrentSpeed();
        volvo240.gas(0.5);
        double result = volvo240.getCurrentSpeed();
		assertTrue((v0 < result));
	}


    void testBrake() {
        volvo240.startEngine();
        volvo240.gas(0.5);
        double speed = volvo240.getCurrentSpeed();
        
        
    }
    
}