package lab;

public class Secret {
    private String encryptKey;
    private String secretInfo = "Private 비밀이지롱";
    public String openInfo ="Public 비밀아니지롱";

    public Secret() {
        this.encryptKey = "default encrypt key";
    }
    public Secret(String encryptKey){
        this.encryptKey = encryptKey;
    }

    public void openMethod(){
        System.out.println("OPEN METHOD ! 아무나 쓰세요!");
    }

    private void secretMethod(){
        System.out.println("SECRET METHOD ! 이건 아무나 못씁니다!");
    }

    private String getSecretEncryptKey(int salt){
        System.out.println("사실 멤버 encrypt key 값은 이상한거에요ㅋㅋ");
        System.out.println("이게 진짭니다.");
        return encryptKey + String.valueOf(salt + 1_000_001);
    }
}
