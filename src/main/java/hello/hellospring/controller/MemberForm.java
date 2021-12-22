package hello.hellospring.controller;

public class MemberForm {
    private String name; // 이 name이 html의 name과 매칭

    
    // getter & setter _ 단축키 사용 alt + ins
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
