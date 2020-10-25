package homework8;
import java.io.*;
import java.util.*;

class forSearch {
	private File fileToRead = null;  //읽을 파일
	Vector<String> lineVector = new Vector<String>(); //한 줄씩 읽기 위함
	
	public forSearch() { }  
	
	public void run() {
		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		System.out.print("대상 파일명 입력>> ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();

		readFile(fileName); // 파일을 라인 단위로 벡터로 읽어들임
		
		while(true) {
			System.out.print("검색할 단어나 문장>> ");
			String line = scanner.nextLine();
			if(line.equals("그만"))
				break; // 프로그램 종료
			Vector<Integer> LineNumber = whereIs(line); // line의 단어를 포함하는모든 라인 번호 리턴
			printLines(LineNumber);
		}
		scanner.close();
		System.out.println("프로그램을 종료합니다.");
	}

	private void readFile(String fileName) { //파일 읽기 메소드
		fileToRead = new File(fileName);     //fileName을 이름으로 가지는 파일 열기
		try {
			Scanner sc = new Scanner(new FileReader(fileToRead));
			while(sc.hasNext()) {  //한 줄 씩 읽기 위함 
				String line = sc.nextLine();   //한 줄 읽기
				lineVector.add(line);    //lineVector에 추가
			}			
			sc.close();
			
		} 
		catch (FileNotFoundException e) { //예외처리
			e.printStackTrace();
		}
	}
	
	private Vector<Integer> whereIs(String word) { //word가 들어간 라인 번호 리턴
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
