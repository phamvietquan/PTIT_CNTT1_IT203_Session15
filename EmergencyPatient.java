public class EmergencyPatient {
    private String id;
    private String name;
    private int priority;
    private long order;

    public EmergencyPatient(String id, String name, int priority, long order) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public long getOrder() {
        return order;
    }

    @Override
    public String toString() {
        String type = priority == 1 ? "Cấp cứu" : "Thường";
        return id + " - " + name + " - " + type;
    }
}