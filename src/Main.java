import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        double num1;
        double num2;

        char operator;


        System.out.println("===sparta 계산기 실행===");
        while(true) {
            int menu = 0;  // 메뉴 변수 초기화

            System.out.println("메뉴를 입력하세요.");
            System.out.println("0. 종료 1. 계산 시작 2. 첫번째 계산 내역 삭제 3. 계산 내역 조회 4. 큰 결과값 찾기");

            // 입력 타입 예외처리
            try {
                menu = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("메뉴 숫자를 다시 입력 해주세요.");
                sc.nextLine();
                continue;
            }

            // 계산기 종료 입력 시
            if(menu == 0){
                System.out.println("===sparta 계산기 종료===");
                return;

                // 계산기 삭제 입력 시
            } else if (menu == 2) {
                System.out.println(calculator.removeList());
                continue;

                // 계산 내역 조회 입력 시
            } else if (menu == 3) {
                int length = calculator.getListLength();

                //조회할 계산 내역 없을 시 출력
                if(length == 0){
                    System.out.println("조회할 계산 내역이 없습니다.");
                    continue;
                }

                System.out.println("===계산 내역===");
                for(int i = 0 ; i < length ; i++) {
                    System.out.println(i+1+ "번 계산 결과값 = "+ calculator.getList(i) +" 입니다.");
                }
                continue;

            } else if (menu == 1) {
                System.out.println("계산할 첫 번째 숫자를 입력하세요. : ");

                // 입력되는 숫자 타입오류 예외처리
                try {
                    num1 = sc.nextDouble();

                }catch (InputMismatchException e){
                    System.out.println("숫자를 입력하세요.");
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
                    System.out.println("숫자를 입력하세요.");
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

                // enum v1. 계산기 메서드 : char -> enum으로 변환 op 변수에 해당 enum 상수 객체 저장
                //Calculator.Operator op = Calculator.Operator.from(operator);
                // enum v1. 계산기 메서드 : op변수에 저장되어있는 enum 객체 로직 수행(계산)
                // result = op.apply(num1, num2);
                // 제네릭 활용 switch-case문 계산기 메서드
                // result = calculator.calculatorStart(num1,operator,num2);

                // 제네릭 활용 enum v2. 계산기 메서드
                result = calculator.calculatorStart2(num1, operator, num2);

                // 계산 내역 저장
                calculator.addList(result);

                // 결과 출력 및 반복 여부 출력
                System.out.println("결과 : " + num1 +" "+ operator+" " + num2 +" = "+ result +"입니다.");
            }






        }
    }
}