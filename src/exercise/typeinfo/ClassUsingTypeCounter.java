package exercise.typeinfo;

//Exercise 13,14
//: typeinfo/RegisteredFactories.java
//Registering Class Factories in the base class.

import net.mindview.util.TypeCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.mindview.util.Print.print;

class Part {
  public String toString() {
      return getClass().getSimpleName();
  }

  static List<Class<? extends Part>> parClasses =
          new ArrayList<Class<? extends Part>>();

  static {
      // Collections.addAll() gives an "unchecked generic
      // array creation ... for varargs parameter" warning.
	  parClasses.add(FuelFilter.class);
	  parClasses.add(AirFilter.class);
	  parClasses.add(CabinAirFilter.class);
	  parClasses.add(OilFilter.class);
	  parClasses.add(FanBelt.class);
	  parClasses.add(PowerSteeringBelt.class);
	  parClasses.add(GeneratorBelt.class);
  }

  private static Random rand = new Random(47);

  public static Part createRandom() throws InstantiationException, IllegalAccessException {
      int n = rand.nextInt(parClasses.size());
      return  parClasses.get(n).newInstance();
  }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
  // Create a Class Factory for each specific type:
  public static class Factory
          implements typeinfo.factory.Factory<FuelFilter> {
      public FuelFilter create() {
          return new FuelFilter();
      }
  }
}

class AirFilter extends Filter {
  public static class Factory
          implements typeinfo.factory.Factory<AirFilter> {
      public AirFilter create() {
          return new AirFilter();
      }
  }
}

class CabinAirFilter extends Filter {
  public static class Factory
          implements typeinfo.factory.Factory<CabinAirFilter> {
      public CabinAirFilter create() {
          return new CabinAirFilter();
      }
  }
}

class OilFilter extends Filter {
  public static class Factory
          implements typeinfo.factory.Factory<OilFilter> {
      public OilFilter create() {
          return new OilFilter();
      }
  }
}

class Belt extends Part {
}

class FanBelt extends Belt {
  public static class Factory
          implements typeinfo.factory.Factory<FanBelt> {
      public FanBelt create() {
          return new FanBelt();
      }
  }
}

class GeneratorBelt extends Belt {
  public static class Factory
          implements typeinfo.factory.Factory<GeneratorBelt> {
      public GeneratorBelt create() {
          return new GeneratorBelt();
      }
  }
}

class PowerSteeringBelt extends Belt {
  public static class Factory
          implements typeinfo.factory.Factory<PowerSteeringBelt> {
      public PowerSteeringBelt create() {
          return new PowerSteeringBelt();
      }
  }
}

public class ClassUsingTypeCounter {
	private static TypeCounter typeCounter = new TypeCounter(Part.class);
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		List<Part> parts = new ArrayList<Part>(20);
		for(int i = 0; i < 20; i++) {
			parts.add(Part.createRandom());
		}
		for (Part part : parts) {
			typeCounter.count(part);
		}
		print(typeCounter);
		
	}
} /* Output:
GeneratorBelt
CabinAirFilter
GeneratorBelt
AirFilter
PowerSteeringBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
PowerSteeringBelt
FuelFilter
*///:~
