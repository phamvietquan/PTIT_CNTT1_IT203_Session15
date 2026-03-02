import java.util.PriorityQueue;

public class EmergencyQueue {

    private long counter = 0;

    private PriorityQueue<EmergencyPatient> queue = new PriorityQueue<>(
            (a, b) -> {
                if (a.getPriority() != b.getPriority())
                    return a.getPriority() - b.getPriority();
                return Long.compare(a.getOrder(), b.getOrder());
            }
    );

    public void addPatient(String id, String name, int priority) {
        EmergencyPatient p = new EmergencyPatient(id, name, priority, counter++);
        queue.add(p);
        System.out.println("Tiếp nhận: " + p);
        displayQueue();
    }

    public EmergencyPatient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không còn bệnh nhân");
            return null;
        }
        EmergencyPatient p = queue.poll();
        System.out.println("Mời khám: " + p);
        displayQueue();
        return p;
    }

    public void displayQueue() {
        System.out.println("Danh sách chờ:");
        for (EmergencyPatient p : queue) {
            System.out.println(p);
        }
        System.out.println("-------------------");
    }
    public class Main {
        public static void main(String[] args) {

            EmergencyQueue eq = new EmergencyQueue();

            eq.addPatient("BN01","An",2);
            eq.addPatient("BN02","Bình",2);
            eq.addPatient("BN03","Chi",1);
            eq.addPatient("BN04","Dũng",1);
            eq.addPatient("BN05","Hà",2);

            eq.callNextPatient();
            eq.callNextPatient();
            eq.callNextPatient();
            eq.callNextPatient();
            eq.callNextPatient();
        }
    }
}