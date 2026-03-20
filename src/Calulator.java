import java.util.ArrayList;
import java.util.List;

public class Calulator {
    //속성
    List<Double> list = new ArrayList<>();
    //생성자
    //기능

    // 계산기 메서드
    public double calulatorStart(double num1, char operator, double num2){
        double result;

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

    // 결과 저장하는 메서드
    public void addList (double result){
        list.add(result);
    }

}
