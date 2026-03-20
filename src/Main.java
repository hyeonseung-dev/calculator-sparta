import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calulator calulator = new Calulator();
        double num1;
        double num2;

        char operator;

        while(true) {
            String menu = "";  // 메뉴 변수 초기화

            System.out.println("계산할 첫 번째 숫자를 입력하세요. : ");

            // 입력되는 숫자 타입오류 예외처리
            try {
                num1 = sc.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("양의 정수를 입력하세요.");
                sc.nextLine();   // 스캐너 변수 초기화
                continue;
            }

            sc.nextLine();   // 스캐너 변수 초기화

            // 양의 정수 입력 예외처리
                if (num1 < 0) {
                    System.out.println("양의 정수를 입력하세요.");
                    continue;
                }


            System.out.println("계산할 사칙연산을 입력하세요.(+, -, *, /) : ");
            operator = sc.next().charAt(0);


            // 사칙연산 예외처리
            if (operator != '+' && operator != '-' && operator != '*' && operator != '/'){
                System.out.println("사칙연산을 다시 입력하세요.");
                continue;
            }
            System.out.println("계산할 두 번째 숫자를 입력하세요. : ");

            // 입력되는 숫자 타입오류 예외처리
            try {
                num2 = sc.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("양의 정수를 입력하세요.");
                sc.nextLine();   // 스캐너 변수 초기화
                continue;
            }

            sc.nextLine();   // 스캐너 변수 초기화

            // 분모 0 나눗셈 예외처리
            if(operator == '/' && num2 == 0){
                System.out.println("분모를 0으로 나눌수 없습니다. 다시 입력하세요.");
                continue;
            }

            // 양의 정수 입력 예외처리
            if (num2 < 0) {
                System.out.println("양의 정수를 입력하세요.");
                continue;
            }

            // 계산기 메서드 실행
            double result = 0;

            result = calulator.calulatorStart(num1,operator,num2);

            // 결과 출력 및 반복 여부 출력
            System.out.println("결과 : " +num1 +" "+ operator+" " + num2 +" = "+ result +"입니다.");
            System.out.println("메뉴를 선택하세요. 1. 종료(exit 입력) 2. 첫번째 계산 내역 삭제(remove 입력) 3. 계산 내역 조회(get 입력) 4. 계속 계산 시(계속 시 아무키)");
            menu = sc.nextLine();

            // 계산기 종료 입력 시
            if(menu.equals("exit")){
                System.out.println("계산기를 종료합니다.");
                return;

            // 계산기 삭제 입력 시
            } else if (menu.equals("remove")) {
                calulator.removeList();
                System.out.println("첫 번째 계산내역이 삭제되었습니다.");
                continue;

            // 계산 내역 조회 입력 시
            } else if (menu.equals("get")) {
                int length = calulator.getListLength();
                System.out.println("===계산 내역===");
                for(int i = 0 ; i < length ; i++) {
                    System.out.println(i+ "번 계산 결과 값 = "+ calulator.getList(i) +" 입니다.");
                }
                continue;
            }



        }
    }
}