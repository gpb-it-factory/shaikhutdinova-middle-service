package com.middleservice.application;

import com.middleservice.domain.*;
import com.middleservice.presentation.CreateTransferRequest;
import com.middleservice.presentation.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(long userId, String userName) throws UserAlreadyExistsException {
        User user = new User(userId, userName);
        userRepository.createUser(user.getUserId(), user.getUserName());
    }

    public void createAccount(long userId) throws AccountAlreadyExistException, UserNotFoundException {
        String accountName = "Акционный";
        userRepository.createAccount(userId, accountName);
    }

    public Account getCurrentBalance(long userId) throws NoAccountFoundException, UserNotFoundException {
        return userRepository.getCurrentBalance(userId);
    }

    public TransferResponse createTransfer(CreateTransferRequest request) throws UserNotFoundException, NoAccountFoundException, InsufficientFundsException {
        long fromUserId = userRepository.getUserIdByUsername(request.getFrom());
        long toUserId = userRepository.getUserIdByUsername(request.getTo());

        Account fromAccount = userRepository.getCurrentBalance(fromUserId);
        Account toAccount = userRepository.getCurrentBalance(toUserId);

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new InsufficientFundsException("Недостаточно средств для перевода");
        }

        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());

        userRepository.updateAccount(fromAccount);
        userRepository.updateAccount(toAccount);

        // Генерация уникального идентификатора перевода
        String transferId = UUID.randomUUID().toString();

        return new TransferResponse(transferId);
    }
}
