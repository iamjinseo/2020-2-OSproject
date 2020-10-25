package homework8;
import java.io.*;
import java.util.*;

class forSearch {
	private File fileToRead = null;  //���� ����
	Vector<String> lineVector = new Vector<String>(); //�� �پ� �б� ����
	
	public forSearch() { }  
	
	public void run() {
		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		System.out.print("��� ���ϸ� �Է�>> ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();

		readFile(fileName); // ������ ���� ������ ���ͷ� �о����
		
		while(true) {
			System.out.print("�˻��� �ܾ ����>> ");
			String line = scanner.nextLine();
			if(line.equals("�׸�"))
				break; // ���α׷� ����
			Vector<Integer> LineNumber = whereIs(line); // line�� �ܾ �����ϴ¸�� ���� ��ȣ ����
			printLines(LineNumber);
		}
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
	}

	private void readFile(String fileName) { //���� �б� �޼ҵ�
		fileToRead = new File(fileName);     //fileName�� �̸����� ������ ���� ����
		try {
			Scanner sc = new Scanner(new FileReader(fileToRead));
			while(sc.hasNext()) {  //�� �� �� �б� ���� 
				String line = sc.nextLine();   //�� �� �б�
				lineVector.add(line);    //lineVector�� �߰�
			}			
			sc.close();
			
		} 
		catch (FileNotFoundException e) { //����ó��
			e.printStackTrace();
		}
	}
	
	private Vector<Integer> whereIs(String word) { //word�� �� ���� ��ȣ ����
		Vector<Integer> LineNumber = new Vector<Integer>();
		for(int i=0; i<lineVector.size(); i++) {
			String line = lineVector.get(i);
			if(line.indexOf(word) != -1) 
				LineNumber.add(i);
		}
		
		return LineNumber;
	}

	private void printLines(Vector<Integer> LineNumber) {
		for(int i=0; i<LineNumber.size(); i++) {
			int SearchedLine = LineNumber.get(i);
			String line = lineVector.get(SearchedLine);
			System.out.println(SearchedLine + ":" + line);
		}
	}
	
}
	
public class homework_8weeks {
	public static void main(String[] args) {
		forSearch search= new forSearch();
		search.run();
	}
}
