package homerowk5;
import java.util.Scanner;

class Person{
	String Name;
}

public class Homework_6weeks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p1=new Person();
		Person p2=new Person();
		int randNum[] = new int[3];
		int match=2;
		int gamer=0;
		
		System.out.print("1번째 선수 이름>>");
		p1.Name=sc.nextLine();
		System.out.print("2번째 선수 이름>>");
		p2.Name=sc.nextLine();
		
		while(true) {
			gamer=match%2;  //p1은 0, p1은 1로 나타내기 위함
			if(gamer==0)
				System.out.print("["+p1.Name+"]:<Enter>");
			else
				System.out.print("["+p2.Name+"]:<Enter>");
			
			String enter=sc.nextLine();
			
			if(enter.isEmpty()) {  //enter입력시
				for(int i=0;i<3;i++) {
					randNum[i]=(int)((Math.random()*3)+1);
					System.out.print(randNum[i]+" ");
				}
			}
			if((randNum[0]==randNum[1])&&(randNum[2]==randNum[1])){
				if(gamer==0) {  //p1이면
					System.out.println(p1.Name+"님이 이겼습니다!");
					break;
				}
				else {  //p2이면
					System.out.println(p2.Name+"님이 이겼습니다!");
					break;
				}
			}
			else {
				System.out.print("아쉽군요!\n\n");
			}
			match++;
		}
	}

}
