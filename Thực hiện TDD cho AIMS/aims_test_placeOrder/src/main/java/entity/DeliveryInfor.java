package entity;

public class DeliveryInfor {
    private  int id;
    private String name;
    private String province;
    private String instruction;
    private String address;

    public DeliveryInfor(int id, String name, String province, String instruction, String address) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.instruction = instruction;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
