package firstpart.graphics;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.function.BiPredicate;

public class Tests {
	public static void main(String []args) {
		Function<String, Integer> f = Integer::parseInt;
		IO.println(f.apply("4")+6);
		
		
		C cc = new C();
		LetsSee let = cc::longNameMethod;
		System.out.println(let.run(35.2, 4, ""));

		BiPredicate<C, String> bp = C::c;
		boolean bool = bp.test(cc, "A");
		System.out.println(bool);
		
		ArrayList<String> nums = new ArrayList<String>();
		nums.add("2");
		nums.add("3");
		ArrayList<Double> doub = new ArrayList<Double>();
		nums.forEach(n -> doub.add(Double.parseDouble(n)));
	}
}

@FunctionalInterface
interface LetsSee {
	D run(double s, int asd, String ssd);
}

class C {
	
	public boolean c(String a) {
		return true;
	}
	
	public D longNameMethod(double s, int a, String dd) {
		return new D();
	}
}

class D {
	@Override
	public String toString() { return "This is the D Class"; }
}