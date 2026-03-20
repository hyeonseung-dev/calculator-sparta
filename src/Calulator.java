import java.util.ArrayList;
import java.util.List;

public class Calulator {
    //속성
    private List<Double> list = new ArrayList<>();
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

    //결과를 삭제하는 메서드
    public void removeList (){
            list.remove(0);
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
