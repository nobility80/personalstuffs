package spring.di.algorithmtest.answer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int result = 0;
        int nHorizon = arr.size();
        int nLTToRB = 0;
        int nRTToLB = 0;

        for (int i = 0; i < nHorizon; i++) {
            //Left Top to Right Bottom
            nLTToRB += arr.get(i).get(i);
            //Right Top to Left Bottom
            nRTToLB += arr.get(nHorizon - i - 1).get(i);
        }

        System.out.println("nLTToRB: " + nLTToRB);
        System.out.println("nRTToLB: " + nRTToLB);

        result = nLTToRB - nRTToLB;
        if (result < 0) result = result * (-1);
        System.out.println("result: " + result);

        return result;
    }

    //getting correct matrix
    //getting correct matrix
    static int[][][] correct_mat = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}};

    int formingMagicSquare(int[][] s) {
        int nOneLocation = 0;
        int result = 0;
        int differ = 0;
        int started = 0;

        //rotate the correct matrix in order to match the input
        for (int h = 0; h < correct_mat.length; h++) {
            for (int i = 0; i < correct_mat[h].length; i++) {    //row
                for (int j = 0; j < correct_mat[h][i].length; j++) { //column
                    differ += Math.abs(correct_mat[h][i][j] - s[i][j]);
                }

            }
            if (started == 0) {
                result = differ;
                started = 1;
            } else {
                if (result > differ)
                    result = differ;
            }
            differ = 0;
        }

        return result;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int answer = 0;
        Map<Integer, Integer> pmap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!pmap.containsKey(a.get(i)))
                pmap.put(a.get(i), 1);
            else
                pmap.put(a.get(i), pmap.get(a.get(i)) + 1);
        }
        
        return answer;
    }
    
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
    
    public static void extraLongFactorials(int n) {
    	BigInteger biResult = BigInteger.ONE;
    	BigInteger bi = new BigInteger(Integer.toString(n));
    	
    	if (n < -1)
    		return;

    	while(! bi.equals(BigInteger.ONE)) {
    		biResult = (biResult.multiply(bi));
    		bi = bi.subtract(BigInteger.ONE);
    	}
    	
    	System.out.println(biResult.toString());

    }
    
    public int[] MaxCounters(int N, int[] A) {
    	int[] answer = new int[N];
    	int stan = 0;
    	
    	for (int i=0; i<A.length; i++) {
    		if (A[i] == N+1) {
    			// find max number
    			for (int j=0; j<N; j++) {
    				if (answer[j] > stan) stan = answer[j];
    			}
    			// save max number in all of array if A[i] == N+1
    			for (int j=0; j<N; j++) {
    				answer[j] = stan;
    			}
    		} else if ((A[i]>=1) && (A[i]<=N)) {
    			answer[A[i]-1]++;
    		}
    	}
    	
    	return answer;
    }
    
    public int MissingInteger(int[] A) {
    	int answer = 1;
    	Set<Integer> set = new HashSet<>();
    	for (int i=0; i<A.length; i++) {
    		set.add(A[i]);
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>(set);
    	Collections.sort(list);

    	Iterator<Integer> it2 = list.iterator();
    	while(it2.hasNext()) {
    		if (it2.next() == answer) {
    			answer++;
    		}
    	}

    	return answer;
    }
    
    public int PermCheck(int[] A) {
    	ArrayList<Integer> list = new ArrayList<>();
    	int answer = 1;
    	
    	for (int i : A) {
    		list.add(i);
    	}
    	
    	Collections.sort(list);
    	
    	for (int i : list) {
    		if (answer == i) answer++;
    		else return 0;
    	}
    	
    	return 1;
    }
    
    public int CountDiv(int A, int B, int K) {
    	int answer = 0;
    	
    	int i = A;
    	while(i<=B) {
    		if (i%K == 0) {
    			answer++;
    			i+=K;
    		} else {
    			i++;
    		}
    	}
    	
    	return answer;
    }
    
    public int getSmallNumber(String S, int P, int Q) {
    	Set<Integer> set = new HashSet<>();
    	char[] charS = S.toCharArray();
    	int start = 0;
    	int end = 0;
    	int answer = 1;
    	
    	if (P>Q) { start=Q;end=P; }
    	else {start=P;end=Q;}
    	
    	for (int i=start; i<=end; i++ ) {
    		if (charS[i] == 'A') set.add(1);
    		else if (charS[i] == 'C') set.add(2);
    		else if (charS[i] == 'G') set.add(3);
    		else if (charS[i] == 'T') set.add(4);
    	}
    	
    	ArrayList<Integer> list = new ArrayList<>(set);
    	Collections.sort(list);
    	
    	return list.get(0);
    }
    
    public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
    	int [] answer = new int[P.length];
    	
    	for (int i=0; i<P.length; i++) {
    		answer[i] = getSmallNumber(S, P[i], Q[i]);
    		System.out.print("answer["+i+"]:" + answer[i]);
    	}
    	
    	return answer;
    	
    }
    
    public int MinAvgTwoSlice(int[] A) {
    	int position = 0;
    	double average = Double.MAX_VALUE;
    	
    	for (int i=0; i<A.length-2; i++) {
    		double avg2 = (A[i] + A[i+1])/2.0;
    		double avg3 = (A[i] + A[i+1] + A[i+2])/3.0;
    		if (average > Math.min(avg2, avg3)) {
    			average = Math.min(avg2, avg3);
    			position = i;
    		}
    	}
    	
    	if (average > (A[A.length-2]+A[A.length-1])/2.0 ) {
    		average = (A[A.length-2]+A[A.length-1])/2.0;
    		position = A.length-2;
    	}
    	
    	return position;
    }
    
    public int PassingCars(int[] A) {
    	int count_zero = 0;
    	int answer = 0;
    	
    	//if there is no car heading east at the beginning of the array
    	//if there is no car heading west at the end of the array
    	for (int i=0; i<A.length; i++) {
    		if (A[i] == 0) {
    			count_zero++;
    		} if (A[i] == 1) answer = answer+count_zero;
    	}
    	
    	if ( (answer > 1000000000) || (answer < 0)) return -1;
    	
    	return answer;
    }
    
    public int Distinct(int[] A) {
    	Set<Integer> set = new HashSet<>();
    	
    	for (int i=0; i<A.length; i++) {
    		set.add(A[i]);
    	}
    	
    	return set.size();
    }
    
    public int MaxProductOfThree(int[] A) {
    	int answer = 0;
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for (int i=0; i<A.length; i++) {
    		list.add(A[i]);
    	}
    	
    	Collections.sort(list);
    	
    	if (list.get(list.size()-1) < 0) {	// if all numbers are minus?
    		answer = list.get(list.size()-3) * list.get(list.size()-2) * list.get(list.size()-1);
    	} else if ((list.get(0) * list.get(1)) >= (list.get(list.size()-3) * list.get(list.size()-2))) {    	//best case is max numbers with (-) minus and (+) plus
    		answer = list.get(0) * list.get(1) * list.get(list.size()-1);
    	} else {
    		answer = list.get(list.size()-3) * list.get(list.size()-2) * list.get(list.size()-1);
    	}
    	
    	return answer;
    }
    
    public int NumberOfDiscIntersections(int[] A) {
    	int answer = 0;
    	
    	for (int i=0; i<A.length-1; i++) {
    		for (int j=i+1; j<A.length; j++ ) {
    			if ((j-A[j]) <= ((long)i+A[i])) {	// circle J is right closed at the edge of circle I
					answer++;
    			}
    		}
    	}
    	
    	if (answer>10000000) return -1;
    	
    	return answer;
    }
    
    public int Triangle(int[] A) {
    	Arrays.sort(A);
    	
    	for (int i=0; i<A.length-2; i++) {
			if ((long)A[i] + (long)A[i+1] > A[i+2])
				return 1;
    	}
    	
    	return 0;
    }
    
    public int Brackets(String S) {
    	Stack<Character> st = new Stack<>();
    	char last_ch;
    	
    	for (char c: S.toCharArray()) {
    		if ((c == '[') || (c == '(') || (c == '{'))
    			st.push(c);
    		else {
    			if (st.empty()) return 0;
    			last_ch = st.pop();
    			
    			if ((c == ']') && (last_ch != '[')) return 0;
    			else if ((c == '}') && (last_ch != '{')) return 0;
    			else if ((c == ')') && (last_ch != '(')) return 0;
    		}
    	}
    	
    	return st.isEmpty()? 1: 0;
    }
    
    public int Fish(int[] A, int[] B) {
    	int answer = 0;
    	Stack<Integer> stackA = new Stack<>();
    	int a = 0;

    	for (int i=0; i<A.length; i++) {
    		if (B[i] == 1) stackA.push(A[i]);
    		else {
    			if (!stackA.isEmpty())
    				a = stackA.pop();

    			if (A[i] > a) answer++;
    		}
    	}
	
    	answer+=stackA.size();
	
    	return answer;
	}

    
    public int Nesting(String S) {
    	int answer = 0;
    	Stack<Character> stack = new Stack<>();
    	char[] charS = S.toCharArray();
    	
    	for (char ch : charS) {
    		if (ch == '(') {
    			stack.push(ch);
    		} else {
    			if (stack.isEmpty()) return 0;
    			
    			char last_ch = stack.pop();
    		}
    	}
    	
    	return stack.isEmpty()? 1: 0;
    }
    
    public int stone_wall(int[] H) {
    	Stack<Integer> stack = new Stack<>();
    	int nHead = 0;
    	int block_count = 0;
    	int m = 0;
    	
    	for (int a : H) {
    		if (a > nHead) {
    			stack.push(a);
    		} else if (a < nHead) {
    			while(((stack.size() > 0) && (m = stack.pop()) > a)) {
    				block_count++;
    			}
    			if (m < a) stack.push(m);
    			if (a > 0) stack.push(a);
    		}
			nHead = a;
    	}
    	
    	while(stack.size() > 0) {
    		m = stack.pop();
    		if ((m == nHead) && (stack.size() > 0)) {
    			m = stack.pop();
    		}
    		
    		if (m < nHead) {
    			block_count++;
    		}
    	}
    	block_count++;
    	
    	return block_count;
    }
    
    public int dominator(int[] A) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int dom_value = 0;
    	
    	if (A.length == 0) return -1;
    	
    	for (int a: A) {
    		if (!map.containsKey(a)) {
    			map.put(a, 1);
    		} else {
    			map.put(a, map.get(a)+1);
    		}
    	}
    	
    	for (int a : map.keySet()) {
    		if (map.get(a) > A.length/2) {
    			dom_value = a;
    			break;
    		}
    	}
    	
    	for (int i=0; i<A.length; i++) {
    		if (A[i] == dom_value)
    			return i;
    	}
    	
    	return -1;
    }
    
    public int equi_leader(int[] A) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int leader = -1;
    	int count_leader = 0;
    	int count = 0;
    	int answer = 0;
    	    	
    	//create map
    	for (int a:A) {
    		if (!map.containsKey(a))
    			map.put(a, 1);
    		else
    			map.put(a, map.get(a)+1);
    	}
    	
    	//getting the leader of the group
    	for (int a:map.keySet()) {
    		if (map.get(a) > count_leader) {
    			leader = a;
    			count_leader = map.get(a);
    		}
    	}
    	
    	//spliting groups having leaders
    	for (int i = 0; i<A.length-1; i++) {
    		if (A[i] == leader) count++;
			if (((count*100/(i+1)) > 50) && (((count_leader-count)*100/(A.length-i-1)) > 50)) {
				answer++;
			}
    	}
    	
    	return answer;
    }
    
    public int max_double_slice_sum(int[] A) {
    	int current_answer = 0;
    	int optimized_answer = 0;
    	int jump_number = 100000;
    	
    	for (int i=1; i<A.length-1; i++) {
    		current_answer+=A[i];
    		if (current_answer < 0) {
    			current_answer = 0;
    			optimized_answer = 0;
    			jump_number = 0;
    		}
    		
    		if (A[i] < jump_number)
    			jump_number = A[i];
    		
    		if (A[i-1] == jump_number)
    			optimized_answer+=jump_number;
    		
    		if (optimized_answer < current_answer)
    			optimized_answer = current_answer;
    	}
    	
    	return optimized_answer - jump_number;
//    	Map<Integer, Map<Integer, Integer>> map = new LinkedHashMap<>();
//    	int start = 0;
//    	int optimized_answer = 0;
//    	int current_answer = 0;
//    	int jump_number = 100000;
//    	map.put(0, new LinkedHashMap<Integer, Integer>()).put(0, 0);
//    	for (int i = 1; i<A.length-1; i++) {
//    		if (start == -1) {
//    			start = i;
//    			map.put(start, new LinkedHashMap<Integer, Integer>()).put(0, 0);
//    		}
//    		current_answer+=A[i];
//    		if (current_answer < 0) {
//    			current_answer = 0;
//    			map.put(start, new LinkedHashMap<Integer, Integer>()).put(jump_number, i);
//    			optimized_answer+=jump_number;
//    			jump_number = 100000;
//    			start = -1;
//    			continue;
//    		}
//    		if (A[i] < jump_number)
//    			jump_number = A[i];
//    			
//    		if (optimized_answer < current_answer)
//    			optimized_answer = current_answer;			
//    	}
//    	
//    	return optimized_answer;
    }
    
    public int max_profit(int[] A) {
    	if ((A.length == 1) || (A.length == 0)) return 0;
    	
    	int min_value = A[0];
    	int max_value = 0;
    	
    	for (int i=1; i<A.length; i++) {
    		if (A[i] < min_value) min_value = A[i];
    		max_value = Math.max(max_value, (A[i]-min_value));
    	}
    	
    	if (max_value < 0) return 0;
    	
    	return max_value;
    }
    
    public int max_slice_sum(int[] A) {
    	long max_value = A[0];
    	int result = A[0];		//result is a sum of  max_value and A[i]
    	boolean max_value_minus = false;
    	for (int i=1; i<A.length; i++) {
    		max_value+=A[i];
    		if (result < max_value) {
    			if (max_value >= A[i]) {
    				result = (int) max_value;
    			} else {
    				result = A[i];
    				max_value = A[i];
    			}
    		} else {
    			if (max_value < 0) {
    				max_value_minus = true;
    			}
    			// if total sum is minus and A[i] is more than the result
    			if ((result < A[i]) && (max_value_minus == true)) {
    				result = A[i];
    				max_value = A[i];
    			//if result is more than A[i] and max_value becomes minus because A[i] is big minus number
    			//the max_value will be newly calculated and result will be kept without any more calculation.
    			} else if ((result > A[i]) && (max_value_minus == true)){
    				max_value = 0;
    				max_value_minus = false;
    			}
    		}
    	}
    	return result;
    }
    
    public int max_count_factors(int N) {
    	Set<Integer> set = new HashSet<>();
    	for (int i=1; i<=Math.sqrt(N); i++) {
    		if (N%i == 0) {
    			set.add(i);
    			set.add(N/i);
    		}
    	}
    	return set.size();
    }

    public int flags(int[] A) {
    	int index=0;
    	int previous_peak = 0;
    	ArrayList<Integer> list = new ArrayList<>();
    	for (int i=1; i<A.length-1; i++) {
    		if ((A[i]>A[i-1]) && (A[i] > A[i+1])) {
    			index++;
    			if ((i-previous_peak) >= index) {
    				list.add(A[i]);
    				previous_peak = i;
    			}
    		}
    	}
    	
    	return list.size(); 
    }
    
    public int min_perimeter_rectangle(int N) {
    	int min_perimeter = 2000000000;
    	for (int i=1; i<=Math.sqrt(N); i++) {
    		if (N%i == 0) {
    			if (min_perimeter > 2*(i+(N/i)))
    				min_perimeter = 2*(i+(N/i));
    		}
        }
    	
    	return min_perimeter;
    }

}