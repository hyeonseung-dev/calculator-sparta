import java.util.ArrayList;
import java.util.List;

public class Calulator {
    //속성
    private List<Integer> list = new ArrayList<>();
    //생성자
    //기능

    // 계산기 메서드
    public int calulatorStart(int num1, char operator, int num2){
        int result;

        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                return -1;
        }
        list.add(result);
        return result;
    }

    // enum 활용 계산기 메서드

    enum Operator {

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

        private final char symbol;

        Operator(char symbol) {
            this.symbol = symbol;
        }

        public abstract int apply(int a, int b);

        public static Operator from(char symbol) {
            for (Operator op : values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            throw new IllegalArgumentException("사칙연산을 다시 입력하세요.");
        }
    }



    // 결과 저장하는 메서드
    public void addList (int result){
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
    public int getList (int i){
        return list.get(i);
    }

    //현재 저장된 계산내역 갯수 반환
    public int getListLength (){
        return list.size();
    }

}
