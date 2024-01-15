package com.group.libraryapp.domain.user.loanHistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    //select * from user_loan_history where book_name = ? and is_return =?
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

//    Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
    //위의 코드는 리팩토링으로 사용하지 않게 되었음.
}
