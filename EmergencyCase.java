import java.util.Stack;

public class EmergencyCase {

    private Patient patient;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;
    }

    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Thêm bước cho " + patient + ": " + step);
    }

    public TreatmentStep undoStep() {
        if (steps.isEmpty()) {
            System.out.println("Không còn bước để hoàn tác");
            return null;
        }
        TreatmentStep s = steps.pop();
        System.out.println("Hoàn tác bước của " + patient + ": " + s);
        return s;
    }

    public void displaySteps() {
        System.out.println("Các bước xử lý của " + patient + ":");
        if (steps.isEmpty()) {
            System.out.println("Chưa có bước");
        } else {
            for (int i = steps.size() - 1; i >= 0; i--) {
                System.out.println(steps.get(i));
            }
        }
        System.out.println("-------------------");
    }

    public Patient getPatient() {
        return patient;
    }
}