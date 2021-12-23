package hello.hellospring.controller;

//  웹 등록 화면에서 데이터를 전달 받을 폼 객체
public class MemberForm {
    private String name;

    // getter & setter _ 단축키 사용 alt + ins
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
