public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public Computer(String cpu, String ram, String storage){
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    public String getCpu(){
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
