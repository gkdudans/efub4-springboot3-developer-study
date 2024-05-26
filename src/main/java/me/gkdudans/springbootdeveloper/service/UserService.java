package me.gkdudans.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.gkdudans.springbootdeveloper.domain.User;
import me.gkdudans.springbootdeveloper.dto.AddUserRequest;
import me.gkdudans.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long save(AddUserRequest dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                //.password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .password(encoder.encode(dto.getPassword())) // 10장: BCryptPasswordEncoder 생성자를 사용해 직접 암호화
                .build()).getId();
    }

    // 9장: 토큰 API 구현하기
    public User findById(Long userId){
        return userRepository.findById(userId)
               .orElseThrow(() -> new IllegalArgumentException("not found " + userId));
    }

    // 10장: OAuth, 이메일을 입력받아 유저를 찾음
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }


}
