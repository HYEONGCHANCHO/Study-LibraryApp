package com.group.libraryapp.domain.user.loanHistory;

import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne //내가 n이고 너가 1이다 이런느낌 학생 여러명이 교실 한곳에 들어갈 수 있음. //table을 봤을때 관계의 주도권을 가진 table이 주인이다.
    //User와 UserLoanHistory 테이블에서 User테이블만 보면 UserLoanHistory와 연관되는지 알 수 없고 UserLoanHistory테이블을 보면 user_id가 있어서 연관됨을 알 수 있다. 즉, 주도권이 UserLoanHistory 테이블쪽에 있다고 할 수 있다. 즉, UserLoanHistory는 연관관계의 주인이 된다. 그러면 연관관계의 주인이 아닌쪽에서 mappedBy = "user" (연관관계 주인의 필드이름) 를 설정해 주어야 한다.
    private User user;

    private String bookName;

    private boolean isReturn; //boolean으로 하면 o인경우 false 1인경우 true로 tinyint에 잘 매핑된다.

    protected UserLoanHistory() {

    } //jpa 기본 생성자가 하나 필요해서 넣어주었음.

    public UserLoanHistory(User user, String bookName) {
        this.user = user ;
        this.bookName = bookName;
        this.isReturn = false;
    }  //isReturn은 무조건 false기 때문에 생성자에서 지우고 false를 쓰면 깔끔하다고 해서 이렇게 수정함.

    public void doReturn() {
        this.isReturn = true;

    }

    public String getBookName() {
        return this.bookName;
    }
}
