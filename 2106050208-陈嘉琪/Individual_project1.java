package package1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Individual_project1 {

	public static void main(String[] args) throws IOException {
		
		//System.out.println(math3());
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Object[] all = math1(n);
		@SuppressWarnings("unchecked")
		LinkedList<String> set = ((LinkedList<String>)all[0]);
		@SuppressWarnings("unchecked")
		LinkedList<String> result = ((LinkedList<String>)all[1]);
		File file1 = new File("D:"+File.separator+"Java IDE"+File.separator+"eclipse-workfile"+File.separator+"SE"+File.separator+"Exercises.txt");
		File file2 = new File("D:"+File.separator+"Java IDE"+File.separator+"eclipse-workfile"+File.separator+"SE"+File.separator+"Answers.txt");
		//完成 io流的创建
		BufferedWriter bu1 = new BufferedWriter(new FileWriter(file1,true));
		BufferedWriter bu2 = new BufferedWriter(new FileWriter(file2,true));
		//完成输出
		int i=0;
		for (String string : set) {
			i++;
			bu1.write(Integer.toString(i)+". ");
			bu1.write(string);
			bu1.newLine();
		}
		i = 0;
		for (String string : result) {
			i++;
			bu2.write(Integer.toString(i)+". ");
			bu2.write(string);
			bu2.newLine();
		}
		
		
		scanner.close();
		bu1.close();
		bu2.close();
		
	}
	
	public static Object[] math1(int num) {
		LinkedList<String> set = new LinkedList<>();
		LinkedList<String> result = new LinkedList<>();
		Object object[] = {set,result};
		
		for(int i=0;i<num;i++) {
			int tmp = ((int) (Math.random()*100))%2;
			if(tmp == 0) {
				String s = math2();
				if (set.size() == 0) {
					String re[] = s.split("=");
					set.add(re[0]);
					result.add(re[1]);
				} else {
					for (int j = 0; j < set.size(); j++) {
						if (set.get(j).equals(s) == true) {
							break;
						}
						if ((j == set.size() - 1) && (set.get(j).equals(s) == false)) {
							String re[] = s.split("=");
							set.add(re[0]);
							result.add(re[1]);
							break;
						}
					}
				}

			} else {
				String s = math3();
				if (set.size() == 0) {
					String re[] = s.split("=");
					set.add(re[0]);
					result.add(re[1]);
				} else {
					for (int j = 0; j < set.size(); j++) {
						if (set.get(j).equals(s) == true) {
							break;
						}
						if ((j == set.size() - 1) && (set.get(j).equals(s) == false)) {
							String re[] = s.split("=");
							set.add(re[0]);
							result.add(re[1]);
							break;
						}
					}
				}
			}
		}
		return object;
	}
	
	public static String math2() {
		int data[] = new int[2];
		for(int i=0;i<2;i++) {
			data[i] = (int) (Math.random()*100);
		}
		
		char sign[] = {'+','-'};
		char s = sign[((int) (Math.random()*100))%2];
		int result = 0;
		if(s=='+') {
			result = data[0] + data[1];
		}else {
			result = data[0] - data[1];
		}
		return ""+Integer.toString(data[0])+Character.toString(s)+Integer.toString(data[1])+"="+Integer.toString(result);
	}

	public static String math3() {
		int data[] = new int[3];
		for(int i=0;i<3;i++) {
			data[i] = (int) (Math.random()*100);
		}
		
		char sign[] = {'+','-'};
		char s[] = new char[2];
		for(int i=0;i<2;i++) {
			s[i] = sign[((int) (Math.random()*100))%2];
		}
		int result = 0;
		if(s[0]=='+') {
			if(s[1]=='+') {
				result = data[0]+data[1]+data[2];
			}else {
				result = data[0]+data[1]-data[2];
			}
		}else {
			if(s[1]=='+') {
				result = data[0]-data[1]+data[2];
			}else {
				result = data[0]-data[1]-data[2];
			}
		}
		return ""+Integer.toString(data[0])+Character.toString(s[0])+Integer.toString(data[1])+
				Character.toString(s[1])+Integer.toString(data[2])+"="+Integer.toString(result);
		
	}	
}
