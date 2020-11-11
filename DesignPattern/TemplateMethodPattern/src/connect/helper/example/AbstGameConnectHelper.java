package connect.helper.example;

import java.util.*;

public abstract class AbstGameConnectHelper {
    protected ArrayList<HashMap<String, String>> idPasswordList;
    public AbstGameConnectHelper(){
        // User data init
        idPasswordList  = new ArrayList<>();
        HashMap<String, String> dumpIdPassword = new HashMap<>();
        dumpIdPassword.put("id", "HelloJava");
        dumpIdPassword.put("password", "YouKnowJavaDesignPattern");
        dumpIdPassword.put("role", "0");
        idPasswordList.add((new HashMap<>(dumpIdPassword)));
        dumpIdPassword.replace("id", "HelloJava2");
        dumpIdPassword.put("role", "1");
        idPasswordList.add((new HashMap<>(dumpIdPassword)));
    }

    // 4가지 알고리즘 단계가 존재한다고 하자.
    // 알고리즘 단계이므로, 외부에서 노출이 되면 안됨.
    // 하지만, 하위 클래스에서 재정의해야하므로, protected 사용 (동일한 패키지 상속가능)
    protected abstract Map<String, String> doSecurity(String string);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(Map<String, String> information);

    // Template method
    public String requestConnection(String encodedInformation){

        // 암호화된 데이터를 가지고, 디코딩 작업 수행
        Map<String, String> decodedInformation = doSecurity(encodedInformation);
        String id = decodedInformation.get("id");
        String password = decodedInformation.get("password");

        // 디코딩 된 데이터를 가지고, 아이디 및 비밀번호 파싱
        // 얻은 아이디 및 비밀번호로 인증 수행
        if(!authentication(id, password)){
            throw new Error("id, password are wrong");
        }

        // 얻은 유저 정보를 가지고, 권한 파악
        int role = authorization(id);
        switch (role){
            case 0:
                System.out.println("ROLE: Game Manager");
                break;
            case 1:
                System.out.println("ROLE: Paid Member");
                break;
            case 2:
                System.out.println("ROLE: Free Member");
                break;
            default:
                System.out.println("ROLE: Anonymous");
        }

        return connection(decodedInformation);
    }
}
