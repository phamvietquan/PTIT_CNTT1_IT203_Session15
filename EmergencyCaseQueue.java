import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {

    private Queue<EmergencyCase> cases = new LinkedList<>();

    public void addCase(EmergencyCase c) {
        cases.add(c);
        System.out.println("Tiếp nhận ca: " + c.getPatient());
        displayQueue();
    }

    public EmergencyCase getNextCase() {
        if (cases.isEmpty()) {
            System.out.println("Không còn ca cấp cứu");
            return null;
        }
        EmergencyCase c = cases.poll();
        System.out.println("Đang xử lý: " + c.getPatient());
        displayQueue();
        return c;
    }

    public void displayQueue() {
        System.out.println("Danh sách chờ:");
        for (EmergencyCase c : cases) {
            System.out.println(c.getPatient());
        }
        System.out.println("-------------------");
    }
    public class Main {
        public static void main(String[] args) {

            EmergencyCaseQueue queue = new EmergencyCaseQueue();

            EmergencyCase c1 = new EmergencyCase(new Patient("BN01","An"));
            EmergencyCase c2 = new EmergencyCase(new Patient("BN02","Binh"));

            queue.addCase(c1);
            queue.addCase(c2);

            EmergencyCase current = queue.getNextCase();

            current.addStep(new TreatmentStep("Tiếp nhận","10:00"));
            current.addStep(new TreatmentStep("Đo huyết áp","10:02"));
            current.addStep(new TreatmentStep("Tiêm thuốc","10:05"));

            current.displaySteps();

            current.undoStep();
            current.displaySteps();

            current = queue.getNextCase();
            current.addStep(new TreatmentStep("Khám ban đầu","10:10"));
            current.displaySteps();
        }
    }
}