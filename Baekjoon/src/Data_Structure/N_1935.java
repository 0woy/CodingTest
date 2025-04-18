package Data_Structure;

import javax.management.relation.InvalidRelationTypeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 피연산자의 개수
        String calc = br.readLine();    // 후위 표기식
        Double [] operand = new Double[n];    // 피연산자 대응값 저장 배열(최대 26)

        for(int i=0;i<n;i++){
            operand[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for(int i=0;i<calc.length();i++){
            // 연산자인 경우
            if(calc.charAt(i)<65 || calc.charAt(i)>90 ){
                Double y = st.pop();
                Double x = st.pop();
                switch (calc.charAt(i)){
                    case '+':
                        st.push(x+y);
                        break;
                    case '-':
                        st.push(x-y);
                        break;
                    case '*':
                        st.push(x*y);
                        break;
                    case '/':
                        st.push(x/y);
                        break;
                }   // 연산자에 따라 계산 후 다시 push
            }
            else{
                Double xop = operand[calc.charAt(i)-65];  // 피연산자에 대응하는 수로 변환
                st.push(xop);
            }
        }
        System.out.printf("%.2f",st.pop());

    }
}
