public class MacBookBluePrint extends BluePrint{

    @Override
    void setCpu() {
        super.computer.setCpu("i9");
    }

    @Override
    void setRam() {
        super.computer.setRam("32g");
    }

    @Override
    void setStorage() {
        super.computer.setStorage("ssd 512g");
    }
}
