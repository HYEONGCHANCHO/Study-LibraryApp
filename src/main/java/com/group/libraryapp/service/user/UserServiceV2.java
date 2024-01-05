package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.response.UserResponse;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Transactional은 아래있는 함수가 시작될 때 start transaction;을 해준다(트랜잭션을 시작)
    //함수가 예외 없이 잘 끝났다면 commit 문제가 있다면 rollback한다.
    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(),request.getAge()));
    }
    @Transactional(readOnly = true) //select의 경우 readonly 쓰면 약간의 성능 향상가능
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::new).collect(Collectors.toList());
    }
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.updateName(request.getName());
//        userRepository.save(user); @Transaction 때문에 영속성 컨텍스트가 가능하고, save를 명시하지 않아도 Entity가 변경을 감지해서 적용한다.
    }
    @Transactional
    public void deleteUser(String name) {

        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);


    }


}
