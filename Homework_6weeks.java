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
		
		System.out.print("1��° ���� �̸�>>");
		p1.Name=sc.nextLine();
		System.out.print("2��° ���� �̸�>>");
		p2.Name=sc.nextLine();
		
		while(true) {
			gamer=match%2;  //p1�� 0, p1�� 1�� ��Ÿ���� ����
			if(gamer==0)
				System.out.print("["+p1.Name+"]:<Enter>");
			else
				System.out.print("["+p2.Name+"]:<Enter>");
			
			String enter=sc.nextLine();
			
			if(enter.isEmpty()) {  //enter�Է½�
				for(int i=0;i<3;i++) {
					randNum[i]=(int)((Math.random()*3)+1);
					System.out.print(randNum[i]+" ");
				}
			}
			if((randNum[0]==randNum[1])&&(randNum[2]==randNum[1])){
				if(gamer==0) {  //p1�̸�
					System.out.println(p1.Name+"���� �̰���ϴ�!");
					break;
				}
				else {  //p2�̸�
					System.out.println(p2.Name+"���� �̰���ϴ�!");
					break;
				}
			}
			else {
				System.out.print("�ƽ�����!\n\n");
			}
			match++;
		}
	}

}
