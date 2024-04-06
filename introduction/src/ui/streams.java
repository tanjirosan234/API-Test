package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class streams {
@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

@Test
public void streamMap() {
	//Stream.of("Alan","Adam","Don","Mite","Antony","Dado","Deki").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	List<Integer>numbers= Arrays.asList(3,2,2,7,5,1,9,7);
	numbers.stream().distinct().forEach(s->System.out.println(s));
	List<Integer>li=numbers.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li.get(2));
	
	
	
}

}
