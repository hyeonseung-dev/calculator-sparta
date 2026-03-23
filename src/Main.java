import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calulator = new Calculator();
        int num1;
        int num2;

        char operator;

        while(true) {
            int menu = 0;  // 메뉴 변수 초기화

            System.out.println("메뉴 숫자를 입력하세요. 0. 계산 실행 1. 종료 2. 첫번째 계산 내역 삭제 3. 계산 내역 조회 4. 큰 결과값 찾기");

            // 입력 타입 예외처리
            try {
                menu = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("메뉴 숫자를 다시 입력 해주세요.");
                sc.nextLine();
                continue;
            }

                // 계산기 종료 입력 시
            if(menu == 1){
                System.out.println("계산기를 종료합니다.");
                return;

                // 계산기 삭제 입력 시
            } else if (menu == 2) {
                System.out.println(calulator.removeList());
                continue;

                // 계산 내역 조회 입력 시
            } else if (menu == 3) {
                int length = calulator.getListLength();

                //조회할 계산 내역 없을 시 출력
                if(length == 0){
                    System.out.println("조회할 계산 내역이 없습니다.");
                    continue;
                }

                System.out.println("===계산 내역===");
                for(int i = 0 ; i < length ; i++) {
                    System.out.println(i+1+ "번 계산 결과값 = "+ calulator.getList(i) +" 입니다.");
                }
                continue;

            } else if (menu == 0) {
                System.out.println("계산할 첫 번째 숫자를 입력하세요. : ");

                // 입력되는 숫자 타입오류 예외처리
                try {
                    num1 = sc.nextInt();

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
                    num2 = sc.nextInt();
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
                int result = 0;

                // char -> enum으로 변환 op 변수에 해당 enum 상수 객체 저장
                Calculator.Operator op = Calculator.Operator.from(operator);

                // op변수에 저장되어있는 enum 객체 로직 수행(계산)
                result = op.apply(num1, num2);

                // 계산 내역 저장
                calulator.addList(result);

                // 구버전 result = calulator.calulatorStart(num1,operator,num2);

                // 결과 출력 및 반복 여부 출력
                System.out.println("결과 : " + num1 +" "+ operator+" " + num2 +" = "+ result +"입니다.");

                // 계산 내역 중 큰 값들 찾아오기
            } else if(menu == 4){
                System.out.println("계산 내역 중 입력값 보다 큰 값들을 찾습니다. 값을 입력하세요. :  ");
                int input = sc.nextInt();
                System.out.println("입력 값 보다 큰 값들은"+calulator.findMax(input)+"입니다.");
                sc.nextLine();  // 버퍼 초기화

            }






        }
    }
}