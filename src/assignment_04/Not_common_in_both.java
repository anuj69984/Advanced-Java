package assignment_04;
/*
 * @Author- Anuj Kumar
 */


import java.util.ArrayList;
import java.util.*;


class Not_common_in_both {
	public static void main(String[] args) {
		List<Integer> a=Arrays.asList(1,2,3,4);
		List<Integer> b= Arrays.asList(3,4,5,6);
		List<Integer> result=new ArrayList<>();

	int ia=0,ib=0;

	//merge-sort algorithm to do it while traversing each collection only once
	while(ia<a.size()&&ib<b.size())
	{	
		if(a.get(ia)<b.get(ib)){
			result.add(a.get(ia));
			ia++;
		}
		else if(a.get(ia)>b.get(ib)){
			result.add(b.get(ib));ib++;
		}
		else{
			ia++;
			ib++;
		}
	}
	result.addAll(a.subList(ia,a.size()));
	result.addAll(b.subList(ib,b.size()));

	System.out.println("Uncommon elements of set a and set b is : "+result);
	}
}
	