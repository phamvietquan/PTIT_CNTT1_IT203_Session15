import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {

    private Queue<Patient> queue = new LinkedList<>();

    public void addPatient(Patient p) {
        queue.add(p);
        System.out.println("Tiếp nhận: " + p);
        displayQueue();
    }

    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không còn bệnh nhân");
            return null;
        }
        Patient p = queue.poll();
        System.out.println("Mời khám: " + p);
        displayQueue();
        return p;
    }

    public Patient peekNextPatient() {
        if (queue.isEmpty()) return null;
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        System.out.println("Danh sách chờ:");
        if (queue.isEmpty()) {
            System.out.println("Trống");
        } else {
            for (Patient p : queue) {
                System.out.println(p);
            }
        }
        System.out.println("-------------------");
    }
    public class Main {
        public static void main(String[] args) {

            PatientQueue pq = new PatientQueue();

            pq.addPatient(new Patient("BN01", "An", 25));
            pq.addPatient(new Patient("BN02", "Bình", 40));
            pq.addPatient(new Patient("BN03", "Chi", 30));

            System.out.println("Bệnh nhân sắp khám: " + pq.peekNextPatient());
            System.out.println("-------------------");

            pq.callNextPatient();
            pq.callNextPatient();

            System.out.println("Bệnh nhân sắp khám: " + pq.peekNextPatient());
        }
    }
}
