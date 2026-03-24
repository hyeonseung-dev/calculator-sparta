import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {
    //속성
    private List<Double> list = new ArrayList<>();
    //생성자
    //기능

    // 기본문법 활용 계산기 메서드(제네릭 활용)
    public double calulatorStart(T num1, char operator, T num2){
        double result;

        switch (operator){
            case '+':
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case '-':
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case '*':
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case '/':
                result = num1.doubleValue() / num2.doubleValue();
                break;
            default:
                return -1;
        }
        list.add(result);
        return result;
    }

    // enum 활용 계산기 메서드 v1(enum을 클래스처럼 사용)
    enum Operator{
        // 상수명과 데이터, 각 객체별 내부로직 선언
        ADD('+') {
            public int apply(int a, int b) {
                return a + b;
            }
        },
        SUB('-') {
            public int apply(int a, int b) {
                return a - b;
            }
        },
        MUL('*') {
            public int apply(int a, int b) {
                return a * b;
            }
        },
        DIV('/') {
            public int apply(int a, int b) {
                return a / b;
            }
        };

        // 상수에 들어가는 필드 선언
        private final char symbol;

        // 생성자 선언하여 데이터 값 연결
        Operator(char symbol) {
            this.symbol = symbol;
        }

        // 객체별 내부로직 추상 함수 선언
        public abstract int apply(int a, int b);

        // 사용자에게 사칙연산를 입력받아 enum 상수에서 찾은 후 Operator(enum) 타입으로 변환
        public static Operator from(char symbol) {
            for (Operator op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            // 예외 처리
            throw new IllegalArgumentException("사칙연산을 다시 입력하세요.");
        }
    }



    // 결과 저장하는 메서드
    public void addList (double result){
        list.add(result);
    }

    //결과를 삭제하는 메서드
    public String removeList (){
        try {
            list.remove(0);
            return "첫 번째 계산 내역이 삭제되었습니다.";
        } catch (IndexOutOfBoundsException e) {
            return "삭제할 계산 내역이 존재하지 않습니다.";
        }
    }

    //결과를 조회하는 메서드
    public double getList (int i){
        return list.get(i);
    }

    //현재 저장된 계산내역 갯수 반환
    public int getListLength (){
        return list.size();
    }

}

