package oopsy_daisy;



import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
            @SuiteClasses({
            oopsy_daisy.AssignmentSpec.FlightTest.class,
            oopsy_daisy.AssignmentSpec.PassengerTest.class,
            oopsy_daisy.AssignmentSpec.LuggageManifestTest.class,
            oopsy_daisy.AssignmentSpec.LuggageManifestTest.class 
        })

        public class AllTests {}
