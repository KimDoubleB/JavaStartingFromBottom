public class LgGramBluePrint extends BluePrint{
    @Override
    void setCpu() {
        super.computer.setCpu("i7");
    }

    @Override
    void setRam() {
        super.computer.setRam("64g");
    }

    @Override
    void setStorage() {
        super.computer.setStorage("ssd 256g");
    }
}
