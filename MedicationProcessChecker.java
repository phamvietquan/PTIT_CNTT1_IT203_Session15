import java.util.Stack;

public class MedicationProcessChecker {

    private Stack<String> stack = new Stack<>();

    public boolean checkProcess(String[] actions) {

        reset();

        for (int i = 0; i < actions.length; i++) {

            String action = actions[i];

            if (action.equals("PUSH")) {
                stack.push(action);
            }
            else if (action.equals("POP")) {

                if (stack.isEmpty()) {
                    System.out.println("Sai tại bước " + (i + 1) + ": POP khi chưa phát thuốc");
                    return false;
                }

                stack.pop();
            }
            else {
                System.out.println("Hành động không hợp lệ tại bước " + (i + 1));
                return false;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Kết thúc ca trực nhưng vẫn còn thuốc chưa hoàn tất");
            return false;
        }

        System.out.println("Quy trình hợp lệ");
        return true;
    }

    public void reset() {
        stack.clear();
    }
    public class Main {
        public static void main(String[] args) {

            MedicationProcessChecker checker = new MedicationProcessChecker();

            String[] case1 = {"PUSH","PUSH","POP","POP"};
            String[] case2 = {"PUSH","POP","POP"};
            String[] case3 = {"PUSH","PUSH","POP"};

            System.out.println("Ca 1:");
            checker.checkProcess(case1);

            System.out.println("----------------");

            System.out.println("Ca 2:");
            checker.checkProcess(case2);

            System.out.println("----------------");

            System.out.println("Ca 3:");
            checker.checkProcess(case3);
        }
    }
}
