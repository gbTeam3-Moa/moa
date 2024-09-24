package com.app.moa.service.user;

import com.app.moa.domain.user.UserVO;
import com.app.moa.repository.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void join(UserVO userVO) { userDAO.save(userVO);
    }

    @Override
    public Optional<UserVO> login(UserVO userVO) {
        return userDAO.findByUserEmailAndUserPassword(userVO);
    }

    @Override
    public Optional<UserVO> getUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void update(UserVO userVO) {
        userDAO.setUser(userVO);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
