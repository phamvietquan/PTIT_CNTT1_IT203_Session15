import java.util.Stack;

public class B1_SS15_IT203 {
    private Stack<EditAction> history = new Stack<>();

    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã chỉnh sửa: " + action);
        displayHistory();
    }

    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Không có chỉnh sửa để Undo");
            return null;
        }
        EditAction action = history.pop();
        System.out.println("Undo: " + action);
        displayHistory();
        return action;
    }

    public EditAction getLatestEdit() {
        if (history.isEmpty()) return null;
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        System.out.println("Lịch sử hiện tại:");
        if (history.isEmpty()) {
            System.out.println("Trống");
        } else {
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
        System.out.println("-------------------");
    }
    public class Main {
        public static void main(String[] args) {

            B1_SS15_IT203 history = new B1_SS15_IT203();

            history.addEdit(new EditAction("Thêm triệu chứng sốt", "10:00"));
            history.addEdit(new EditAction("Cập nhật huyết áp", "10:05"));
            history.addEdit(new EditAction("Kê đơn thuốc", "10:10"));

            System.out.println("Chỉnh sửa gần nhất: " + history.getLatestEdit());
            System.out.println("-------------------");

            history.undoEdit();
            history.undoEdit();

            System.out.println("Chỉnh sửa gần nhất: " + history.getLatestEdit());
        }
    }
}
