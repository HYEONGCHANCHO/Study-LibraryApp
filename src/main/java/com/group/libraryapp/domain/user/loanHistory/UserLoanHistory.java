package com.group.libraryapp.domain.user.loanHistory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private Long userId;

    private String bookName;

    private boolean isReturn; //boolean으로 하면 o인경우 false 1인경우 true로 tinyint에 잘 매핑된다.

    protected UserLoanHistory() {

    } //jpa 기본 생성자가 하나 필요해서 넣어주었음.

    public UserLoanHistory(long userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
        this.isReturn = false;
    }  //isReturn은 무조건 false기 때문에 생성자에서 지우고 false를 쓰면 깔끔하다고 해서 이렇게 수정함.
}
